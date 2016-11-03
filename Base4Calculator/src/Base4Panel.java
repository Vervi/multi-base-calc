import java.awt.FlowLayout;
import java.awt.event.*;

import javax.swing.*;
import net.miginfocom.swing.MigLayout;
import java.util.ArrayList;

public class Base4Panel extends JPanel implements ActionListener{
	private Base4Calc calc; // this object will actually do the calculating work
	private ArrayList<JButton> num = new ArrayList<JButton>(); //using ArrayList so we don't have to make too many changes for expansions
	private ArrayList<JButton> op = new ArrayList<JButton>();
	
	
	private JButton zero;
	private JButton one;
	private JButton two; 
	private JButton three;
	private JButton four;
	private JButton five;
	private JButton six;
	private JButton seven;
	private JButton eight;
	private JButton nine;
	private JButton ten;
	private JButton elvn;
	private JButton twelve;
	private JButton thrtn;
	private JButton fourtn;
	private JButton fiftn;
	
	private JSlider slider;
	private JTextField textField;
	
	private JButton plus;
	private JButton minus; 
	private JButton multiply; 
	private JButton divide;
	private JButton equals;
	private JButton clear;
	
	String lastOp="=";
	String inputA="0";
	String inputB="0";
	String result="0";
	String current="0";
	
	private int count =0;
	private boolean numExpected = true;
	
	Base4Panel() {
		setLayout(new MigLayout("", "[grow][][39px][41px][grow][39px][41px][25.00px][41px][-89.00px][69px]", "[29px][][53.00][33.00,grow][][][33.00][][]"));
		
	//	ActionListener operand = new opListener();//need to check the syntax here
		ActionListener digit = new numListener();
		
		zero = new JButton("0"); 
		zero.addActionListener(digit);
		add(zero, "cell 3 3,alignx left,aligny center");
		num.add(zero); 
		
		slider = new JSlider();
		slider.setMinorTickSpacing(1);
		slider.setSnapToTicks(true);
		slider.setPaintLabels(true);
		slider.setMajorTickSpacing(2);
		slider.setMinimum(2);
		slider.setMaximum(16);
		slider.setOrientation(SwingConstants.VERTICAL);
		add(slider, "cell 0 2 2 5");
		
		textField = new JTextField();
		add(textField, "cell 3 2 5 1,growx");
		textField.setColumns(10);
		
			
		
	//	Creation of numeric buttons
		one = new JButton("1");
		one.addActionListener(digit);
		add(one, "cell 4 3,alignx left,aligny center");
		num.add(one);
		
		
		two = new JButton("2"); 
		two.addActionListener(digit);
		add(two, "cell 5 3,alignx left,aligny center");
		num.add(two);
		
		
		three = new JButton("3"); 
		three.addActionListener(digit);	
		add(three, "cell 6 3,alignx left,aligny center");
		num.add(three);
		
		
		four = new JButton("4");
		add(four, "cell 3 4,aligny center");
		four.setEnabled(false);
		
		five = new JButton("5");
		add(five, "cell 4 4,aligny center");
		five.setEnabled(false);
		
		six = new JButton("6");
		add(six, "cell 5 4,aligny center");
		six.setEnabled(false);
		
		seven = new JButton("7");
		add(seven, "cell 6 4,aligny center");
		seven.setEnabled(false);
		
		eight = new JButton("8");
		add(eight, "cell 3 5,aligny center");
		eight.setEnabled(false);
		
		nine = new JButton("9");
		add(nine, "cell 4 5,aligny center");
		nine.setEnabled(false);
		
		ten = new JButton("A");
		add(ten, "cell 5 5,aligny center");
		ten.setEnabled(false);
		
		elvn = new JButton("B");
		add(elvn, "cell 6 5,aligny center");
		elvn.setEnabled(false);
		
		twelve = new JButton("C");
		add(twelve, "cell 3 6,aligny center");
		twelve.setEnabled(false);
		
		thrtn = new JButton("D");
		add(thrtn, "cell 4 6,aligny center");
		thrtn.setEnabled(false);
		
		fourtn = new JButton("E");
		add(fourtn, "cell 5 6,aligny center");
		fourtn.setEnabled(false);
		
		fiftn = new JButton("F");
		add(fiftn, "cell 6 6,aligny center");
		fiftn.setEnabled(false);
		
		
		//creation of operand buttons
				clear = new JButton("C");//clear button gets its own listener
				clear.addActionListener(new ActionListener(){
						public void actionPerformed (ActionEvent c)
							{
							clear();
							}
						}
						);
				add(clear, "cell 8 2,alignx center,aligny center");
			
				plus = new JButton("+"); 
				plus.addActionListener(this);
				add(plus, "cell 8 3,alignx left,aligny center");
				op.add(plus);
				
				minus = new JButton("-"); 
				minus.addActionListener(this);
				add(minus, "cell 8 4,alignx left,aligny center");
				op.add(minus);
				
				multiply = new JButton("x"); 
				multiply.addActionListener(this);
				add(multiply, "cell 8 5,alignx left,aligny center");
				op.add(multiply);
				
				divide = new JButton("/"); 
				divide.addActionListener(this);
				add(divide, "cell 8 6,alignx left,aligny center");
				op.add(divide);
				
				equals = new JButton("=");
				equals.addActionListener(this);
				add(equals, "cell 5 7,alignx left,aligny center");
				op.add(equals);
	
	}

	public void clear()
	{
		
		 textField.setText("");
		 count = 0;
		 current ="0";
		 //result ="0";
		 numExpected = true;
		 
	}
		
	 class numListener implements ActionListener
	{
		public void actionPerformed (ActionEvent click)
		{
			/*
			if (click.getSource() == zero)
				textField.setText(textField.getText().concat("0"));
			if (click.getSource() == one)
				textField.setText(textField.getText().concat("1"));
			if (click.getSource() == two)
				textField.setText(textField.getText().concat("2"));
			if (click.getSource() == three )
				textField.setText(textField.getText().concat("3"));
			
			need a more efficient way to handle this once other num buttons are added
				*/
			String numInput =click.getActionCommand();
			if (numExpected)
			{
				textField.setText(numInput);
				numExpected = false;
			}
			else
			{
				textField.setText(textField.getText().concat(numInput));
			}
			}
			//works and is a helluva lot more concise
		}
	
		public void readIn() 
		{
			inputA =textField.getText();
		//textField.setText("");
			count++;//will need for stack/rpn/tape fns later
		}
		
		public void stateCheck()
		{
			if (current == "0")
				current = inputA; 
			if(result == "0")
				result= inputA;
			else
				{current = result;}//need to seriously check the results of just this line
		}
		
		public void print()
		{
			//if(result =="0")
			//readIn();
			textField.setText(result);
		}
		
		//need to rethink the logic here
		/* let's say we enter a number 12321
		 * 				the pressing of an operation key will say hey we're done entering the number
		 * 				in which case the following needs to happen (assuming there are no numbers on the stack)
		 * 					capture the number on display and store it in a string variable
		 * 					set the last operand to whichever button was pushed
		 * 					if equal was pushed current & result should be set to whatever was read in
		 * 					if a different button was pressed another number needs to be read in after
		 * 					everytime a number is read in the new total should be displayed 
		 * 
		 * 		 */
		
		
		
	//class opListener implements ActionListener
		//{
		 public void actionPerformed (ActionEvent e)
			{
			 	if (numExpected)
			 	{
			 		clear();
			 		textField.setText("oops trying entering a number.");
			 	}
			 	else
			 	{
			 numExpected = true;
			 try{
				readIn();
				 
				 		 
				 if (lastOp.equals( "=" ))
				 {
				 calc.setCurr(inputA);
				 }
				 else if (lastOp.equals("/"))
				 {
				 	
				 result= calc.divide(inputA);
				 	
				 }
				 if (lastOp.equals( "+" ))
				 {
				 calc.sum(current, inputA);
				 }
				 
				 

				 else
			
					 inputB ="this is soooo not working";
			 }
			catch(Exception oops) 
			 {
				clear();
				textField.setText("Oops! I didn't catch that.");	
			 }
			lastOp = e.getActionCommand();
			 	
			
			}
			 	}

						
			

}

