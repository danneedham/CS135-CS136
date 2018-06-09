/** @author Dan Needham
 */
import structure5.*;
import java.util.Iterator;

public class CharacterIterator extends AbstractIterator<Character> {

    private int i;
    private String s;
    
    public CharacterIterator(String str) {
	i = 0;
	s = str;
    }
    
    public Character next() {
	i++;
	return s.charAt(i);
    }

    public boolean hasNext() {
	return i > s.length();
    }
    public void reset(){
	i = 0;
    }
    public Character get(){
	return s.charAt(i);
    }
    public static void main(String[] args) {
	CharacterIterator iter = new CharacterIterator("string");
	while (iter.hasNext()){
	    System.out.println(iter.next());
	}
    }
}
