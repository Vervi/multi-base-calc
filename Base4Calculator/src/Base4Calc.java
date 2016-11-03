import java.awt.event.*;
import java.util.ArrayList;

public class Base4Calc {
	private int x,y,z;
	int base=4;
    private int base10= 10;
	private String A= "0";
	private String B="0";
	private String input = "0";

	String result="0";//default string output
	String current="0";//tracker for current total
	ArrayList<Integer> terms;// for expansion
	
	
	
	Base4Calc() { result="0"; }
	
	void clear() { result="0"; }

/**
	*	method: setBase takes an int parameter and sets the current base to that value when called
	*
*/	
	void setBase(int b)
	{
		base = b;
	}
	
	void setString (String A, String B)
	{
		A=this.A;
		B=this.B;
	}
	
/**
	*method: base10in takes a string as parameter. using the parseInt method from the Integer class/wrapper the string is read into an 
	* int in the appropriate base. The int is then converted to base 10 and then cast back to (and returned as) a string.
*/
	
	String base10in(String s)
{
	int x = Integer.parseInt(s, base);		//read number in desired base
	input = Integer.toString(x,base10);		//convert to a string in base 10 for calculations
	System.out.println(input);
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
	System.out.println(input);
	return input;
} 
//works

	
	
String sum(String A, String B)//for now focusing just on 2 values
{	
	setString(A,B);
	x = Integer.parseInt(base10in(A));
	y = Integer.parseInt(base10in(B));
	z = x+y; 
	
	result=base10out(Integer.toString(z));
	//	System.out.println(result);
	return result;
}
//works


String divide(String A, String B)//for now focusing just on 2 values
{	
	x = Integer.parseInt(base10in(A));
	y = Integer.parseInt(base10in(B));
	z = x/y; 
	result=base10out(Integer.toString(z));
	//System.out.println(result);
	return result;
}
//works

String multiply(String A, String B)//for now focusing just on 2 values
{	
	x = Integer.parseInt(base10in(A));
	y = Integer.parseInt(base10in(B));
	z = x*y; 
	result=base10out(Integer.toString(z));
//	System.out.println(result);
	return result;
}
//works
String subtract(String A, String B)
{	
	x = Integer.parseInt(base10in(A));
	y = Integer.parseInt(base10in(B));
	z = x-y; 
    result=base10out(Integer.toString(z));
	System.out.println(result);
	return result;
}
//works
	
  
  
  //let's say we want to restructure this such that each operation only takes one term(if that many)
      /*
        example: the case of addition (also think in terms of button presses)
                  lets say we are using our base4calculator 
                         user enters a few numbers, then clicks the "+" button    
                         let's say current= "0" (string)
                         when "+" is pressed the numbers currently in the textfield get stored in a string lets call it in
												if result = 0, set result = A call it a stateCheck();
												else 
                                              
	void stateCheck()
	{
	if (result.equals("0"))
	   current = in;
	}//this needs to be done in panel not base calc logic (probably)
	
		 need to keep track of current value and  operations
		lets say we start with 0 on screen enter (assume base10 for simplicity)
										15 then press "+"
							result = 0;
						current =15;
															then user enters ...
					 result = current + ...
						 return result
			return result;
		*/
	}
