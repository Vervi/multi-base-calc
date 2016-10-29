import java.awt.FlowLayout;
import java.awt.event.*;

import javax.swing.*;
import net.miginfocom.swing.MigLayout;

public class Base4Panel extends JPanel implements ActionListener {
	private Base4Calc calc; // this object will actually do the calculating work
	
	
	JButton zero, 
	one, 
	two, 
	three,

	//four,five,six,seven,eight,nine,ten,eleven,twelve,thirtn,fourtn,fiftn,sixtn
	
	plus, 
	minus, 
	multiply, 
	divide,
	equals,
	clear;
	

	
	
	private String inputA, inputB;
	private int base4=4;
	private JTextField textField;

	Base4Panel() {
		setLayout(new MigLayout("", "[45px][39px][41px][grow][39px][41px][41px][41px][-89.00px][69px]", "[29px][][][][][][]"));
		
	
		
		textField = new JTextField();
		add(textField, "cell 3 2 3 1,growx");
		textField.setColumns(10);
		
		zero = new JButton("0"); 
		zero.addActionListener(this);
		add(zero, "cell 3 3,alignx left,aligny top");
		
		one = new JButton("1");
		one.addActionListener(this);
		add(one, "cell 4 3,alignx left,aligny top");
		
		two = new JButton("2"); 
		two.addActionListener(this);
		add(two, "cell 3 4,alignx left,aligny top");
		
		three = new JButton("3"); 
		three.addActionListener(this);	
		add(three, "cell 4 4,alignx left,aligny top");
		
		
		clear = new JButton("C");
		clear.addActionListener(this);
		add(clear, "cell 5 3,alignx left,aligny top");
		
		equals = new JButton("=");
		equals.addActionListener(this);
		add(equals, "cell 8 5,alignx left,aligny top");
		
		
		
		plus = new JButton("+"); 
		plus.addActionListener(this);
		add(plus, "cell 5 4,alignx left,aligny top");

		divide = new JButton("/"); 
		divide.addActionListener(this);
		add(divide, "cell 3 5,alignx left,aligny top");
		
		minus = new JButton("-"); 
		minus.addActionListener(this);
		add(minus, "cell 4 5,alignx left,aligny top");
		
		multiply = new JButton("x"); 
		multiply.addActionListener(this);
		add(multiply, "cell 5 5,alignx left,aligny top");
		
	

		// you may decide you want to improve the appearance of the layout, 
		// which is fine. But defer that until you get the calculator working. 
		// (You can spend HOURS messing with layout, which is not the point of this exercise!)


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
			textField.setText("");
		
		if (click.getSource() == plus)
		{
			readIn(); 
		}
		if (click.getSource() == minus)
		{
			readIn();
		}	
		if (click.getSource() == multiply)
		{
			readIn();
		
		}	
		if (click.getSource() == divide)
		{
			readIn();
		}	
		
		if (click.getSource() == equals)
		{
			inputB =textField.getText();
			
			textField.setText(result);
			
			
		}	
		
		
		
		
		
		
		
		
		
		
		
	}
	
	public void readIn() 
	{
		inputA =textField.getText();
		textField.setText("");
	}
	
		
	// you need to deal with event handling. before you go too crazy writing code, 
	// think about when the calc object needs to be involved, and when it doesn't 
			//calc needs to be involved  when an operand button is clicked
			//may or may not be needed when a num button is pressed
			//need 2 string objects
}
