#!/usr/bin/env python3
# (c) 2016 <your name here>
"""
This module provides utilities for grabbing course descriptions from the
Williams College website.

To run this, you must have the following installed:
   requests
   cython
   matplotlib
   wordcloud
"""
import requests
import matplotlib.pyplot as plt
from wordcloud import WordCloud
import re
import time

stopwords = {'a', 'an', 'and', 'are', 'as', 'at', 'be', 'by', 'can', 'for', 'from', 'how', 'in', 'is', 'it', 'of', 'on', 'that', 'the', 'this', 'to', 'will', 'with'}


def subjDict(subj="CSCI",term=1171):
    """Returns a dictionary of dictionaries describing courses in a subject during a term.
    Entries in the course dictionary include:
        'subj' - the course subject
        'number' - the course number
        'title' - the course title
        'cid' - the PeopleSoft ID for the course
        'term' - the PeopleSoft term ID
        'url' - the url (possibly) containing the course description.
    """
    # a regular expression for getting department course offerings:
    url = 'http://catalog.williams.edu/catalog.php?strm={}&subj={}'.format(term,subj)

    # Grab the course page.
    # This loop is typical of what's needed to interact with the peoplesoft-generated pages
    # if there's an oracle error, back off and retry a second later.
    while True:
        r = requests.get(url)
        if r.status_code != 200:
            raise Exception('Invalid request')
        if r.text.find('Error:ORA') == -1:
            break;
        time.sleep(1)
    
    # Find all the course entries on the departmental page, dropping courses into a dictionary
    t = r.text
    d = dict()
    # a regular expression for finding course links:
    cpat = '<a title="(.*)" href="(http://catalog.williams.edu/catalog.php\?&strm=([0-9]+)&subj=([A-Z]+)&cn=([0-9]+)&sctn=(.+)&crsid=([0-9]+))">.*?</a>'    
    for (title,url,t,dept,course,sect,cid) in re.findall(cpat,t):
        course = int(course)
        #cid = int(cid)
        t = int(t)
        url2 = 'http://catalog.williams.edu/catalog.php?strm={}&crsid={}'.format(t,cid)
        if course not in d:
            d[course] = {'subj':dept,'number':course,'title':title,'cid':cid,'url':url2,'term':t}
    if len(d) == 0:
        raise Exception('No courses found.  Bad subject ({}) or term ({})?'.format(subj,term))
    return d

def courseDescr(subj='CSCI',term=1171,number=135,subjdict=None):
    """Return the course description associated with a course number (number)
    in a subject (subj) during a particular semester (term).  Makes use
    of pre-computed subject course dictionary (subjdict) if present."""
    if subjdict is None:
        subjdict = subjDict(subj,term)
    if not subjdict:
        raise Exception('Invalid subject ({}) or term ({}).'.format(subj,term))
    if number not in subjdict:
        raise Exception('No such course: {} {}'.format(subj,number))
    courseURL = subjdict[number]['url']
    #same loop to interact with peoplesoft-generated pages. Backs off for 1 second after receiving an error.
    while True:
        r = requests.get(courseURL)
        if r.status_code != 200:
            raise Exception('Invalid request')
        if r.text.find('Error:ORA') == -1:
            break;
        time.sleep(1)
    t = r.text
    # a regular expression for finding course descriptions
    expr = '<div class="catalogdesc">(.*)</div>'
    return re.findall(expr,t)
        
def courseDescrDept(subj,term,subjdict):
    """Return a list containing course descriptions associated with the course
    numbers of all the courses offered in a given subject (subj) during a 
    given term (term)."""
    descriptions = []
    if not subjdict:
        subjdict = subjDict(subj,term)
    for number in subjdict:
        if number in subjdict:
            descriptions.append(courseDescr(subj,term,number,subjdict))
    return descriptions
                            
def missionCloud():
    """Write a word cloud based on the College mission statement."""
    text = open('mission.txt').read()
    # generate a WordCloud object from text not including stopwords
    wordcloud = WordCloud(width=1000, height=800,stopwords = stopwords)
    wordcloud.generate(text)
    # use matplotlib.pyplot to save the image
    plt.imshow(wordcloud)
    plt.axis("off")
    plt.savefig('mission.png')

def cloudify(subj='CSCI',term=1173):
    """Generate word cloud associated with a subject (subj) during a term (term).
    Writes output to <subj>Cloud.png. (e.g. csciCloud.png)"""
    text = repr(courseDescrDept(subj,term,subjdict=None))
    wordcloud = WordCloud(width=1000, height=800, stopwords = stopwords)
    wordcloud.generate(text)
    plt.imshow(wordcloud)
    plt.axis("off")
    plt.savefig('subject.png')
    
if __name__ == "__main__":
    from sys import argv
    #missionCloud()
    d = subjDict(subj="STAT",term=1171)
    #uncomment the below code to print a course description or a list of course descriptions for a department.
    #print(courseDescr(subj="STAT",term=1171,number=201,subjdict=None))
    #print(courseDescrDept(subj="STAT",term=1171,subjdict=None))
    #generate the word cloud.
    cloudify(subj='STAT',term=1171)
