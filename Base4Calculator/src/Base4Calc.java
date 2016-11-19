//import java.awt.event.*;
//import java.util.ArrayList;

/**
 * Base4Calc
 * @author zhi
 * 
 * Base4Calc class defines the logic behind our calculator. It is responsible for handling base conversions
 * ans mathematical operations.
 */
public class Base4Calc {
	int base=16;
    private int base10= 10;
	//private String input = "0";
    private int input = 0;
    private int output =0;
	

	String current="0";//tracker for current total
	//ArrayList<Integer> terms;// for expansion
	
	String result;//default  output	
	
	
	/**
	 * Constructor: initializes result field variable to "0";
	 */
	Base4Calc() { result="0"; }
	
	/**
	 * method: clear takes not parameter. sets field variables to appropriate zero value for its type.
	 */
	void clear() { result="0"; input=0; output=0; }

/**
	*	method: setBase takes an int parameter and sets the current base to that value when called
	*		@param int
	*			
*/	
	void setBase(int b)
	{
		base = b;
	}
	

/**
	*method: base10in takes a string as parameter. using the parseInt method from the Integer class/wrapper the string is read into an 
	* int in the appropriate base. The int is then converted to base 10 and then cast back to (and returned as) a string.
	* 	@param s of type String
	* 	@return base 10 version of input string
	* 	
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
	* 	@param s of type String
	*	@return input integer in original base
	*
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

/**
	 *method: setCurr takes a string as parameter and converts it to an Integer in the current base
	 *		@param A of type String
	 *		
 */
void setCurr(String A)
{
	output =  Integer.parseInt(A,base);
}

/**
	 *method: sum takes a string as parameter and uses the 2 helper methods to convert the string to an integer in base 10
	 *add it to the current value of output then convert said output back to the appropriate base.
	 *		@param A of type String
	 *		
 */
void sum(String A)//for now focusing just on 2 values
{	
	output += base10in(A);
	result = Integer.toString(output);
	output = base10out(result);
}
//works

/**
 	*method: divide takes a string as parameter and uses the 2 helper methods to convert the string to an integer in base 10
 	*divides the current value of output by it then convert said output back to the appropriate base.
 	*		@param A of type String
	*		
*/
void divide(String A)//for now focusing just on 2 values
{	
	output /= base10in(A);
	result = Integer.toString(output);
	output = base10out(result);
}
//works

/**
 	*method: multiply takes a string as parameter and uses the 2 helper methods to convert the string to an integer in base 10
 	*multiply the current value of output by it then convert said output back to the appropriate base.
 	*		@param A of type String
	*		
*/
void multiply(String A)//for now focusing just on 2 values
{	
	output *= base10in(A);
	result = Integer.toString(output);
	output = base10out(result);
}
//works

/**
 	*method: subtract takes a string as parameter and uses the 2 helper methods to convert the string to an integer in base 10
 	*find the difference between the current value of output and said integer then convert output back to the appropriate base.
 	*		@param A of type String
	*		
*/
void subtract (String A)
{
	output -= base10in(A);
	result = Integer.toString(output);
	output = base10out(result);
}
}
