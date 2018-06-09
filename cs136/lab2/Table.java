//(c) Dan Needham, Late Day Used
import structure5.*;
public class Table{

    protected Vector<Association<String,FrequencyList>> table;

    public Table(){
	table = new Vector<Association<String,FrequencyList>>(1000);
    }
    public void update(String text){
	//text is a string of length "k+1," where we are recording the first k characters in our table and mapping it to a frequency list for the k+1st character. 
	String firstK = text.substring(0,text.length()-1);
	String kPlusOne = text.substring(text.length()-1);
	//FrequencyList fl = new FrequencyList();
	String listChar = new String();
	int i;
	Association<String,FrequencyList> tableItem;
	for (i = 0; i < table.size(); i++) {
	        tableItem = table.get(i);
	    if (tableItem.getKey().equals(firstK)) { 
		tableItem.getValue().update(kPlusOne);
		break;
	    }
	}	
	if (i == table.size()){

	    FrequencyList fl = new FrequencyList();
	    Association<String,FrequencyList> newItem = new Association(firstK,fl);
	    fl.update(kPlusOne);
	    table.add(newItem);
	}   
    }    
						   
    public char pickNext(String str){
	//calls the association str and then uses the frequency list method pickNext to select a random character.
	Association<String,FrequencyList> tableItem;
	FrequencyList list = new FrequencyList;
	char c = new char;
	for (int i = 0; i < table.size(); i++){
	    if table.get(i).equals(str);
	    list = table.get(i).getValue();
	    c =list.pickNext();
	    return c;
	    
		      
    public String toString(){
	Association<String,FrequencyList> assoc;
	FrequencyList item = new FrequencyList();
	for (int i = 0; i < table.size(); i++){
	    assoc = table.get(i);
	    item = assoc.getValue();
	    System.out.println(assoc.getKey()+" : "+item.toString());
	}
	return "";
    }

     public static void main(String args[]){
	Table tb = new Table();
	
	tb.update("hello");
	System.out.println("hello my".length());
	//System.out.println(tb.size());
	System.out.println(tb.toString());
     }
}		      	      
			   
    
	    
     
