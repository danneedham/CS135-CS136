/** @author Dan Needham
 * A class for determining subsets of a word that are also words.
 * Uses a LexiconTrie for the lexicon of words from the file input. 
 */
import structure5.*;

public class SubWords {
    
    //A lexicon to store words.
    private LexiconTrie lexicon;
    //A vector of the characters contained in the word being considered.
    private Vector<Character> word;
    //Count the number of sub words.
    private int count;
    
    public SubWords(){
	this.lexicon = new LexiconTrie();
	this.word = new Vector<Character>();
	this.count = 0;
    }

    /**
     * @pre takes two arguements: a file with words to be added to the lexicon, and a string word.
     * @post prints out all of the subsequences of the word that are themselves words in the lexicon. 
     */
    public static void main(String[] args){
	SubWords sim = new SubWords();
	sim.lexicon.addWordsFromFile(args[0]);
	for (int i=0;i<args[1].length();i++){
	    sim.word.add(args[1].charAt(i));
	}
	SubsetIterator<Character> iter = new SubsetIterator<Character>(sim.word);
        while (iter.hasNext()){
       	    String w = "";
	    Vector<Character> vector = iter.next();
	    for (Character c : vector){
		w+=c;
	    }
	    if (sim.lexicon.containsWord(w)){	
		sim.count++;
		System.out.println(w);
	    }
	}
	System.out.println("Words found: " + sim.count);
    }	
}
