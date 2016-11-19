import java.awt.event.*;
import java.util.ArrayList;

public class Base4Calc {
	private int x,y,z;
	int base=10;//default base is 10 for testing purposes
    private int base10= 10;
	//private String input = "0";
    private int input = 0;
    private int output =0;
	

	String current="0";//tracker for current total
	//ArrayList<Integer> terms;// for expansion
	
	String result;//default  output	
	
	Base4Calc() { result="0"; }
	
	void clear() { result="0"; input=0; output=0; }

/**
	*	method: setBase takes an int parameter and sets the current base to that value when called
	*
*/	
	void setBase(int b)
	{
		base = b;
	}
	

/**
	*method: base10in takes a string as parameter. using the parseInt method from the Integer class/wrapper the string is read into an 
	* int in the appropriate base. The int is then converted to base 10 and then cast back to (and returned as) a string.
*/
	
	int base10in(String s)
{
	input = Integer.parseInt(s, base);		//read number in desired base
	String x = Integer.toString(input,base10);	
	
	//System.out.println(input);
	return Integer.parseInt(x);	
} 

	/**
	*method: base10out takes a string as parameter. using the parseInt method from the Integer class/wrapper the string is read into an 
	* int in base10 The int is then converted to a different base and then cast back to (and returned as) a string.
	*/
int base10out(String s)
{
	input = Integer.parseInt(s, base10);		
	String x = Integer.toString(input,base);		//convert from base 10 back to orig
	//System.out.println(input);
	return input;
} 

public String equate()
{
	
return "" +result; //int as a string
	
} 

void setCurr(String A)
{
	output =  Integer.parseInt(A,base);
}
void sum(String A)//for now focusing just on 2 values
{	
	output += base10in(A);
	result = Integer.toString(output);
	output = base10out(result);
}
//works


void divide(String A)//for now focusing just on 2 values
{	
	output /= base10in(A);
	result = Integer.toString(output);
	output = base10out(result);
}
//works

void multiply(String A)//for now focusing just on 2 values
{	
	output *= base10in(A);
	result = Integer.toString(output);
	output = base10out(result);
}
//works
void subtract (String A)
{
	output -= base10in(A);
	result = Integer.toString(output);
	output = base10out(result);
}
}
