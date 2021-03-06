// (c) Dan Needham Late Day Used. I ran out of time to debug some of these methods. 
import structure5.*;
import java.util.Random;
public class FrequencyList{
    
    
    protected Vector<Association<String,Integer>> freqList;
    protected int total;

    public FrequencyList(){
	freqList = new Vector<Association<String,Integer>>(1000);
	int total = 0
	
    }

    public void update(String word){
	//fills our frequency list with characters and their frequencies.
       	Association<String,Integer> listItem = new Association<String,Integer>("",0);
	String listWord;
	int i;
	    for (i = 0; i < freqList.size(); i++) {
		total+=1
		listItem = freqList.get(i);
		listWord = listItem.getKey();
		if (listWord.equals(word)) {
		    int f = listItem.getValue();
		    listItem.setValue(new Integer(f + 1));
		    break;
		}
	    }
	    if (i == freqList.size()){
		freqList.add(new Association<String,Integer>(word,1));	
		total += 1
	    }
	    
	    
    }

    public String toString(){
	//prints the list
	String list = new String();
       	Association<String,Integer> assoc;
	int item;
	for (int i = 0; i < freqList.size(); i++){
	    assoc = freqList.get(i);
	    item = assoc.getValue();
	    list+=(assoc.getKey()+" : "+item+" ");
	}
        return list;
    }

    public char pickNext(){
	//adds one character to a string for each instance of that character in the frequency list. Then picks a random integer between 0 and the length of the string-1 and returns the char in that place in the string.
	String letters = new String;
	for (int i = 0; i < total; i++){
	    char c = freqList.get(i).getKey();
	    for (int j; j < freqList.get(i).getValue; i++){
		letters+=c;
	    }
	}
	int index = new Random();
	char next = charAt(index);
	return next;
	
    public static void main(String args[]){
	FrequencyList fl = new FrequencyList();

	fl.update("h");
	fl.update("e");
	fl.update("l");
	fl.update("l");
	fl.update("o");

        System.out.println(fl.toString());
	fl.pickChar();
    }
}	    
    

	    
	      
		    
		    
