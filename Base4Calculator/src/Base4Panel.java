import java.awt.FlowLayout;
import java.awt.event.*;

import javax.swing.*;
import net.miginfocom.swing.MigLayout;
import java.util.ArrayList;

public class Base4Panel extends JPanel implements ActionListener {
	private Base4Calc calc; // this object will actually do the calculating work
	private ArrayList<JButton> arr = new ArrayList();
	
	JButton zero, 
	one, 
	two, 
	three,
	
		//+four,five,six,seven,eight,nine,ten,eleven,twelve,thirtn,fourtn,fiftn,sixtn
	
	plus, 
	minus, 
	multiply, 
	divide,
	equals,
	clear;
	
	String lastOp="";
	String inputA="0",
			inputB="0",
			result="0",
			current="0";
	
	
	private int base4=4;
	private JTextField textField;

	Base4Panel() {
		setLayout(new MigLayout("", "[45px][39px][41px][grow][39px][41px][41px][41px][-89.00px][69px]", "[29px][][][][][][]"));
		
		ActionListener operand = new opListener();//need to check the syntax here
		
		textField = new JTextField();
		add(textField, "cell 3 2 3 1,growx");
		textField.setColumns(10);
		
		zero = new JButton("0"); 
		zero.addActionListener(this);
		add(zero, "cell 3 3,alignx left,aligny top");
		arr.add(zero); //add button to ArrayList arr for later
		
		one = new JButton("1");
		one.addActionListener(this);
		add(one, "cell 4 3,alignx left,aligny top");
		arr.add(one);
		
		
		two = new JButton("2"); 
		two.addActionListener(this);
		add(two, "cell 3 4,alignx left,aligny top");
		arr.add(two);
		
		
		three = new JButton("3"); 
		three.addActionListener(this);	
		add(three, "cell 4 4,alignx left,aligny top");
		arr.add(three);
		
		
		//creation of operand buttons
		clear = new JButton("C");
		clear.addActionListener(operand);
		add(clear, "cell 5 3,alignx left,aligny top");
		
			
		plus = new JButton("+"); 
		plus.addActionListener(operand);
		add(plus, "cell 5 4,alignx left,aligny top");

		divide = new JButton("/"); 
		divide.addActionListener(operand);
		//divide.setActionCommand("divide");
		add(divide, "cell 3 5,alignx left,aligny top");
		
		minus = new JButton("-"); 
		minus.addActionListener(operand);
		//minus.setActionCommand("subtract");
		add(minus, "cell 4 5,alignx left,aligny top");
		
		multiply = new JButton("x"); 
		multiply.addActionListener(operand);
		//multiply.addActionListener(this);
		//multiply.setActionCommand("multi");
		add(multiply, "cell 5 5,alignx left,aligny top");
		
		
		equals = new JButton("=");
		equals.addActionListener(operand);
		add(equals, "cell 8 5,alignx left,aligny top");
		
	

	}
	
	public void actionPerformed(ActionEvent click)
	{
	
		if (click.getSource() == zero)
			textField.setText(textField.getText().concat("0"));
		if (click.getSource() == one)
			textField.setText(textField.getText().concat("1"));
		if (click.getSource() == two)
			textField.setText(textField.getText().concat("2"));
		if (click.getSource() == three )
			textField.setText(textField.getText().concat("3"));
		if (click.getSource() == clear )
			   {
					 textField.setText("");
			     calc.clear(); //check to see if this line is actually needed
			  }
				
	
	}
		
	
	public void readIn() 
	{
		inputA =textField.getText();
		stateCheck();//check to make sure this is the right spot
		textField.setText("");		
	}
	
	public void print()
	{
		textField.setText(result);
	}
	
	public void stateCheck()
	{
		if (current == "0")
			current = inputA; 
	}
	
	public void clear()
	{
		//this method may need to be moved here instead of in calc logic
	}
		
		
	class opListener implements ActionListener
		{
		 public void actionPerformed (ActionEvent e)
			{
					
				readIn();
				inputB =textField.getText();
					
          if(e.getActionCommand()== "+")
				
						result = calc.sum(current, inputB);
					            
					if(e.getActionCommand()== "/")
						result = calc.divide(current, inputB);
				
	        if(e.getActionCommand()== "-")
						result = calc.subtract(current, inputB);
				
        if(e.getActionCommand()== "*")
						result = calc.multiply(current, inputB);
						
				
				
				
				
				
				
		
			
				
				/*
				inputB =textField.getText();
						switch(e.getActionCommand())
				{
				case "+":
					result = calc.sum(current, inputB);
						print();
					break;
					
				case "/":
					result = calc.divide(current, inputB);
					print();
						break;
				case "-":
					result = calc.subtract(current, inputB);
					print();
						break;
								
				case "*":
					result = calc.multiply(current, inputB);
					print();
						break;
						
				default: 
						print();//may not actually need this here
				
				
				*/
				
				
				
				}
				//print();	
				
		}
	}
/*

	need to think about exception handling
			what can go wrong
			where is it likely to go wrong
			how can we prevent it from going wrong





*/


