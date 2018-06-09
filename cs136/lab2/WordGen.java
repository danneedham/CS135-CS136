//(c) Dan Needham Late Day Used
import structure5.*;
import java.util.Scanner;
public class WordGen {

    public static void main(String[] args){
	
	Scanner in = new Scanner(System.in);
	StringBuffer textBuffer = new StringBuffer ();
	while (in.hasNextLine()) {
	    String line = in.nextLine();
	    textBuffer.append(line);
	    textBuffer.append("\n");
	}		       
	String text = textBuffer.toString();

	int k = 2;
	Table tb = new Table();
	//generates the table of all the frequency lists matched to strings of size k    
	for (int i; i < text.length(); i++){
	    String str = text.substring(i,i+(k+1));
	    tb.update(str);
	}
	String result = new String;
	char c = new char;
	//prints the random text
	for (int i; i < text.length(); i++){
	    c = tb.nextChar(i,i+(k+1));
	    result+=c;
	}
	System.out.println(result);
    }
}
