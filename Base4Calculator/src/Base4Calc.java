/**
 * Base4Calc class defines the logic behind our calculator. It is responsible for handling base conversions
 * and mathematical operations.
 * 
 * @author zhi/N. Willis
 * @version 0.6.0
 * 
 *  <p> Field Variables:
 * <ul>
 * 		<li>base : an integer variable pertaining to the number base the calculator is operating in</li>
 * 		<li>base10 : constant int variable to represent base 10 for simplified operation purposes</li>
 * 		<li>input : integer version of string to be read in and converted into/out of base 10.</li>
 * 		<li>output : integer keeping track of current total (result)</li>
 * </ul>
 * </p>
 *   
 *   @see #clear()
 *   @see #sum(String)
 *   @see #subtract(String)
 *   @see #multiply(String)
 *   @see #divide(String)
 *   @see #equate()
 *   @see #setBase(int)
 *   @see #setCurr(String)
 *   @see #base10in(String)
 *   @see #base10out(String)
 *   @see Base4Calc#signFlip()
 *   
 *  
 */
public class Base4Calc {
	int base=16;
    private final int base10= 10;
	private int input = 0;
    private int output =0;
	String result;//default  output	
		
	/**
	 * Constructor: initializes result field variable to "0";
	 */
	Base4Calc() { result="0"; }
	
	/**
	 * method: clear takes not parameter. sets field variables to appropriate zero value for its type.
	 */
	void clear() { result="";
					input=0;
					output=0; }

/**
	*	method: setBase takes an int parameter and sets the current base to that value when called
	*		@param int
	*			
*/	
	void setBase(int b)
	{
		base = b;
	}
	int getBase()
	{
		return base;
	}

/**
	*method: base10in takes a string as parameter. using the valueOf method from the Integer class/wrapper the string is read into an 
	* int in the appropriate base. The int is then converted to base 10 and then cast back to (and returned as) a string.
	* 	@param s of type String
	* 	@return base 10 version of input string
	* 	
*/
	
	int base10in(String s)
{
	String x="0";
	try
	{	
	input = Integer.valueOf(s, base);		//read number in desired base
	x = Integer.toString(input,base10);	
	}
	catch(NumberFormatException nex)
	{
	System.out.println(x);
	}
	return Integer.valueOf(x);	
} 

/**
	*method: base10out takes a string as parameter. using the valueOf method from the Integer class/wrapper the string is read into an 
	* int in base10 The int is then converted to a different base and then cast back to (and returned as) a string.
	* 	@param s of type String
	*	@return input integer in original base
	*
*/ 	
int base10out(String s)
{
	input = Integer.valueOf(s, base10);		
	String x = Integer.toString(input,base);	//convert from base 10 back to orig
	input = Integer.valueOf(x);	
	return input;
} 
/**
 * @return current result
 */
public String equate()
{
return result;
} 

/**
	 *method: setCurr takes a string as parameter and converts it to an Integer in the current base
	 *		@param A of type String
	 *		
 */
void setCurr(String A) throws NumberFormatException
{
	output =  Integer.valueOf(A,base);
	result = Integer.toString(output,base);
	
}

/**
	 *method: sum takes a string as parameter (pre-converted to base 10) adds the current value of output and 
	 *converts back to the appropriate base
	 *		@param A of type String
	 *		
 */
void sum(String A)//for now focusing just on 2 values
{	
	output +=Integer.valueOf(A);
	result = Integer.toString(output,base);
}
//works

/**
 	*method: divide takes a string as parameter (pre-converted to base 10) divides the current
 	* value of output by it then convert said output back to the appropriate base.
 	*		@param A of type String
	*		
*/
void divide(String A)//for now focusing just on 2 values
{	
	
	output /=Integer.valueOf(A);
	result = Integer.toString(output,base);
}

/**
 	*method: multiply takes a string as parameter (pre-converted to base 10)  
 	*multiplies the current value of output by it and converts the result back to the appropriate base.
 	*		@param A of type String
	*		
*/
void multiply(String A)//for now focusing just on 2 values
{	
	output *=Integer.valueOf(A);
	result = Integer.toString(output,base);
}

/**
 	*method: subtract takes a string as parameter (pre-converted to base 10)  finds the difference 
 	*between the current value of output and said integer then converts output back to the appropriate base.
 	*		@param A of type String
	*		
*/
void subtract (String A)
{
	output -=Integer.valueOf(A);
	result = Integer.toString(output,base);
}

/**
 * method: signFlip negates the sign of the current value. 
 * 			under construction:
 *  needs corresponding action listener & button in panel class
 */
void signFlip()
{
	output =Integer.valueOf(result);
	result = Integer.toString(-output);
	
}

}//end of class definition

