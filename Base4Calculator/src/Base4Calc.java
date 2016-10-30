import java.awt.event.*;
import java.util.ArrayList;

public class Base4Calc {
	private int x,y,z;
	int base=4;
    private int base10= 10;
	private String A;
	private String B;
	private String input = "0";

	String result="0";//default string output
	ArrayList<Integer> terms;
	
	
	
	Base4Calc() { result="0"; }
	
	void clear() { result="0"; }

	
	//for base 4 test calc
	String base10in(String s)
	{
		int x = Integer.parseInt(s, base);		//read number in desired base
		input = Integer.toString(x,base10);		//convert to a string in base 10 for calculations
		System.out.println(input);
		return input;
	} 
	
	String sum(String A, String B)//for now focusing just on 2 values
	{	
		x = Integer.parseInt(base10in(A));
		y = Integer.parseInt(base10in(B));
		z = x+y; 
		result=Integer.toString(z);
		System.out.println(result);
		return result;
	}
	//works


	String divide(String A, String B)//for now focusing just on 2 values
	{	
		x = Integer.parseInt(base10in(A));
		y = Integer.parseInt(base10in(B));
		z = x/y; 
		result=Integer.toString(z);
		System.out.println(result);
		return result;
	}
	//works

	String multiply(String A, String B)//for now focusing just on 2 values
	{	
		x = Integer.parseInt(base10in(A));
		y = Integer.parseInt(base10in(B));
		z = x*y; 
		result=Integer.toString(z);
		System.out.println(result);
		return result;
	}
	//works
	String subtract(String A, String B)//for now focusing just on 2 values
	{	
		x = Integer.parseInt(base10in(A));
		y = Integer.parseInt(base10in(B));
		z = x-y; 
		result=Integer.toString(z);
		System.out.println(result);
		return result;
	}
	//works
	
	
	
	
}
