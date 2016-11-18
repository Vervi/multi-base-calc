import java.awt.event.*;
import java.util.ArrayList;

public class Base4Calc {
	private int x,y,z;
	int base=4;
    private int base10= 10;
	private String input = "0";
	

	String current="0";//tracker for current total
	//ArrayList<Integer> terms;// for expansion
	
	String result;//default  output	
	
	Base4Calc() { result="0"; }
	
	//void clear() { result="0"; }

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
	
	String base10in(String s)
{
	int x = Integer.parseInt(s, base);		//read number in desired base
	input = Integer.toString(x,base10);		//convert to a string in base 10 for calculations
	//System.out.println(input);
	return input;
} 

	/**
	*method: base10out takes a string as parameter. using the parseInt method from the Integer class/wrapper the string is read into an 
	* int in base10 The int is then converted to a different base and then cast back to (and returned as) a string.
	*/
String base10out(String s)
{
	int x = Integer.parseInt(s, base10);		
	input = Integer.toString(x,base);		//convert from base 10 back to orig
	//System.out.println(input);
	return input;
} 
//works

void sum(String A, String B)//for now focusing just on 2 values
{	
	
	x = Integer.parseInt(base10in(A));
	y = Integer.parseInt(base10in(B));
	z = x+y; 
	
	result=base10out(Integer.toString(z));
	//	System.out.println(result);
	//return result;
}
//works


void divide(String A, String B)//for now focusing just on 2 values
{	
	x = Integer.parseInt(base10in(A));
	y = Integer.parseInt(base10in(B));
	z = x/y; 
	result=base10out(Integer.toString(z));
	//System.out.println(result);
	//return result;
}
//works

void multiply(String A, String B)//for now focusing just on 2 values
{	
	x = Integer.parseInt(base10in(A));
	y = Integer.parseInt(base10in(B));
	z = x*y; 
	result=base10out(Integer.toString(z));
//	System.out.println(result);
	//return result;
}
//works
void subtract (String A, String B)
{
	x = Integer.parseInt(base10in(A));
	y = Integer.parseInt(base10in(B));
	z = x-y; 
    result=base10out(Integer.toString(z));
	System.out.println(result);
	 //return result;
}	
/*void sum (String A)//for now focusing just on 2 values
{
	 current = base10in(Integer.toString(result)); //take current total & convert to base 10 for summation
	 result = (Integer.parseInt(base10in(current))) +( Integer.parseInt(base10in(A)));
	current=base10out(Integer.toString(result));
	//return result;
}
//works

void sum(String A)//for now focusing just on 2 values
{	
	current = base10in(Integer.toString(result));
	x = Integer.parseInt(base10in(A));
	y = Integer.parseInt(base10in(current));
	z = x+y; 
		
	result=Integer.parseInt(base10out(Integer.toString(z)));
	System.out.println(result);
	//return result;
}

void divide (String A)//for now focusing just on 2 values
{	
	y = Integer.parseInt(base10in(A));
	x = Integer.parseInt(base10in(current));
	result = x/y; 
	//result=base10out(Integer.toString(z));
	System.out.println(result);
//	return result;
}
//works

void multiply(String A, String B)//for now focusing just on 2 values
{	
	x = Integer.parseInt(base10in(A));
	y = Integer.parseInt(base10in(B));
	z = x*y; 
	//result=base10out(Integer.toString(z));
//	System.out.println(result);
	//return result;
}
//works
void subtract(String A, String B)
{	
	x = Integer.parseInt(base10in(A));
	y = Integer.parseInt(base10in(B));
	z = x-y; 
    //result=base10out(Integer.toString(z));
	System.out.println(result);
//	return result;
}
//works
*/

public String equate(){
	
return "" +result; //int as a string
	
}  
}
