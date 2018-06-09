//Dan Needham
import structure5.*;
import java.util.Iterator;
import java.util.Scanner;

public class LexiconTrie implements Lexicon {

    protected LexiconNode node;
    protected int count;
    protected LexiconNode current;
    protected Vector<String> words;
    
    public LexiconTrie(){
	node = new LexiconNode(' ', false);	
	words = new Vector<String>();
    }
    //@pre containstWord(word) is false.
    public boolean addWord(String word){
	//check if the word is contained in the tire
	if (!this.containsWord(word)){
	    current = node;
	    addHelp(word);
	}
	return true;
    }
    public boolean addHelp(String word) {	
	if (word.length() == 1){
	    char c = word.charAt(0);
	    LexiconNode child = new LexiconNode(c, true);
	    current = current.addChild(child);
	    current.setWord();
	    count++;
	}
	else{
	    char c = word.charAt(0);
	    LexiconNode child = new LexiconNode(c, false);
	    current = current.addChild(child);
	    addHelp(word.substring(1));
	}
	
	return true;
    }
    
    public int addWordsFromFile(String filename) {
	Scanner sc = new Scanner(new FileStream(filename));
	int sum = 0;
	while (sc.hasNext()){
	    if (addWord(sc.next())){
		sum++;
	    }
	}
	return sum;
    }
    public boolean removeWord(String word) {
	if (this.containsWord(word)){
	    this.findWord(word).setNotWord();
	    count--;
	}
	return containsWord(word);
    }

     public int numWords() {
	return count;
    }
    public boolean containsWord(String word){
	if (findWord(word) != null){
	    return findWord(word).isWord();
	}
	else {
	    return false;
	}
    }
    public LexiconNode findWord(String word){
	//What happens when getChild returns null???
	LexiconNode ln = node;
	for (int i=0; i < word.length(); i++){
	    if (ln != null){
		ln = ln.getChild(word.charAt(i));
	    }
	    else{
	    	return null;
	    }
	}
	return ln;
	
    }
    public boolean containsPrefix(String prefix){return true;}

    public String toString(){
	return node.toString();
    }
	
    public Iterator<String> iterator() {
	words.clear();
	iteratorHelper(node, "");
	return words.iterator();
    }

    
    public void iteratorHelper(LexiconNode ln, String w){
	//base case, children are leaves
	//LexiconNode current = new LexiconNode;
	Iterator<LexiconNode> iter = ln.iterator();
	if (ln.isWord()){    
	    words.add(w+ln.letter);
	    //	    w += child.letter;
	}
	while (iter.hasNext()){
	    iteratorHelper(iter.next(), w+ln.letter);
	}
    }

    
	
		    
	
    
    public Set<String> suggestCorrections(String target, int maxDistance) {return null;}
    public Set<String> matchRegex(String pattern){return null;}
}

