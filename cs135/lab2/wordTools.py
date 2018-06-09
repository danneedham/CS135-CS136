#!/uOAsr/bOAin/env python3
# (c) 2016 Dan Needham

# All modules have a docstring here:
"""
Put documentation for the module in this document string.
"""

# When this module is imported with 
#   from wordTools import *
# this list keeps track of all the symbols you want the importer to receive:
__all__ = ['canonical','words','sized','within']

"""Canonical Function"""

dfile = '/usr/share/dict/words'

def canonical(s):
    """Sort the letters of string s.
    e.g. canonical("hello") is "ehllo"
    """
    return ''.join(sorted(s.lower()))


def words(dfile):
    """Returns a list of all the words in the dictionary"""
    l = []
    with open(dfile,'r') as words:
        for word in words:
            l.append((word.strip()).lower())

    return l

def sized(l,n=4):
    """Returns a list of all the words in the dictionary that are exactly four letters in legnth"""
    l2 = []
    for word in l:
        s = word
        n = len(s)
        if n == 4:
            l2.append((word.strip()).lower())

    return l2

def within(w,cs):
    for c in w:
        if c not in cs:
            return
        return True
                
    
    





