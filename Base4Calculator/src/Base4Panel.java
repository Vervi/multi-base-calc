import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import net.miginfocom.swing.MigLayout;
import java.util.ArrayList;
/**
 * Base4Panel
 * @category gui
 * @author zhi
 * 
 * Base4Panel class lays out the Graphical User Interface component of our Calculator.
 * 
 *
 */
public class Base4Panel extends JPanel {
	private Base4Calc calc; // this object will actually do the calculating work
	
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
	private ArrayList<JButton> num;
	
	
	private JSlider slider;
	private JTextField textField;
	
	private JButton plus;
	private JButton minus; 
	private JButton multiply; 
	private JButton divide;
	private ArrayList<JButton> op;
	
	private JButton equals;
	private JButton clear;
	
	String lastOp="=";
	String inputA="0";
	String current="0";
	
	private boolean numExpected = true;
	private JLabel b_note;
	
	Base4Panel() {
		
		calc = new Base4Calc();
		setLayout(new MigLayout("", "[grow][][39px][41px,grow][grow][39px][41px][25.00px][41px][-89.00px][69px]", "[29px][][53.00][33.00,grow][][][33.00][][]"));
		
		ActionListener operand = new opListener();//need to check the syntax here
		ActionListener digit = new numListener();
		ActionListener clr = new freshListener();
		
		b_note = new JLabel();
		add(b_note, "cell 3 1 4 1,growx");
		b_note.setHorizontalAlignment(SwingConstants.CENTER);
		
		zero = new JButton("0"); 
		add(zero, "cell 3 3,alignx left,aligny center");
				
		
		textField = new JTextField();
		add(textField, "cell 3 2 5 1,growx");
		textField.setColumns(10);
		
			
		
	//	Creation of numeric buttons
		one = new JButton("1");
		add(one, "cell 4 3,alignx left,aligny center");
			
		two = new JButton("2"); 
		add(two, "cell 5 3,alignx left,aligny center");
		
		three = new JButton("3"); 
		add(three, "cell 6 3,alignx left,aligny center");
					
		four = new JButton("4");
		add(four, "cell 3 4,aligny center");
				
		five = new JButton("5");
		add(five, "cell 4 4,aligny center");
				
		six = new JButton("6");
		add(six, "cell 5 4,aligny center");
		
		seven = new JButton("7");
		add(seven, "cell 6 4,aligny center");
		
		eight = new JButton("8");
		add(eight, "cell 3 5,aligny center");
			
		nine = new JButton("9");
		add(nine, "cell 4 5,aligny center");

		ten = new JButton("A");
		add(ten, "cell 5 5,aligny center");
		
		elvn = new JButton("B");
		add(elvn, "cell 6 5,aligny center");
		
		twelve = new JButton("C");
		add(twelve, "cell 3 6,aligny center");
		
		thrtn = new JButton("D");
		add(thrtn, "cell 4 6,aligny center");
		
		fourtn = new JButton("E");
		add(fourtn, "cell 5 6,aligny center");
		
		fiftn = new JButton("F");
		add(fiftn, "cell 6 6,aligny center");
		
		//initialize/fill array list for ease of access/modification of state
		num = new ArrayList<JButton>(){ //
			{
			add(zero);
			add(one);
			add(two);
			add(three);
			add(four);
			add(five);
			add(six);
			add(seven);
			add(eight);
			add(nine);
			add(ten);
			add(elvn);
			add(twelve);
			add(thrtn);
			add(fourtn);
			add(fiftn);
			}
			};
		
			//adding actoinListeners to each of the buttons
			for(JButton button : num)
			{
				button.addActionListener(digit);
			}
		
	
		//creation of operand buttons
				clear = new JButton("C");//clear button gets its own listener
				clear.addActionListener(clr);
				add(clear, "cell 8 2,alignx center,aligny center");
			
				plus = new JButton("+"); 
				add(plus, "cell 8 3,alignx left,aligny center");
					
				minus = new JButton("-"); 
				add(minus, "cell 8 4,alignx left,aligny center");
							
				multiply = new JButton("*"); 
				add(multiply, "cell 8 5,alignx left,aligny center");
						
				divide = new JButton("/"); 
				add(divide, "cell 8 6,alignx left,aligny center");
							
				equals = new JButton("=");
				add(equals, "cell 5 7,alignx left,aligny center");

				op = new ArrayList<JButton>(){
				{	
				add(plus);
				add(minus);
				add(multiply);
				add(divide);
				add(equals);
				}
				};
			
				for(JButton button : op)
				{
					button.addActionListener(operand);
				}
				
				//Creation of Jslider
				slider = new JSlider();
				slider.setMinorTickSpacing(1);
				slider.setSnapToTicks(true);
				slider.setPaintLabels(true);
				slider.setMajorTickSpacing(2);
				slider.setMinimum(2);
				slider.setMaximum(16);
				
				slider.setValue(16);
				b_note.setText("calculating in base 16");
				
				slider.addChangeListener(new ChangeListener() {
					     public void stateChanged(ChangeEvent e) {
					    JSlider source = (JSlider)e.getSource();
					      if (!source.getValueIsAdjusting())
					      {
					    	
					      if (slider.getValue()==2)
					      {
					    	  calc.setBase(2);
					    	  b_note.setText("calculating in base 2");
					    	  for (int i=0; i < num.size(); i++)
					    		  if (i<2)
					    		  (num.get(i)).setEnabled(true);
					    		  else
					    		  (num.get(i)).setEnabled(false);
					    			  					      
					      }
					      else if(slider.getValue()==3)
					      {
					    	  calc.setBase(3);
					    	  b_note.setText("calculating in base 3");
					    	  for (int i=0; i < num.size(); i++)
					    		  if (i<3)
					    		  (num.get(i)).setEnabled(true);
					    		  else
					    		  (num.get(i)).setEnabled(false);
					    			  					      
					      }
					     
					      else if(slider.getValue()==4)
					      {
					    	  calc.setBase(4);
					    	  b_note.setText("calculating in base 4");
					    	  for (int i=0; i < num.size(); i++)
					    		  if (i<4)
					    		  (num.get(i)).setEnabled(true);
					    		  else
					    		  (num.get(i)).setEnabled(false);
					    			  					      
					      }
					      
					      if (slider.getValue()==5)
					      {
					    	  calc.setBase(5);
					    	  b_note.setText("calculating in base 5");
					    	  for (int i=0; i < num.size(); i++)
					    		  if (i<5)
					    		  (num.get(i)).setEnabled(true);
					    		  else
					    		  (num.get(i)).setEnabled(false);
					    			  					      
					      }  
					      
					      if (slider.getValue()==6)
					      {
					    	  calc.setBase(6);
					    	  b_note.setText("calculating in base 6");
					    	  for (int i=0; i < num.size(); i++)
					    		  if (i<6)
					    		  (num.get(i)).setEnabled(true);
					    		  else
					    		  (num.get(i)).setEnabled(false);
					    			  					      
					      }
					      
					      if (slider.getValue()==7)
					      {
					    	  calc.setBase(7);
					    	  b_note.setText("calculating in base 7");
					    	  for (int i=0; i < num.size(); i++)
					    		  if (i<7)
					    		  (num.get(i)).setEnabled(true);
					    		  else
					    		  (num.get(i)).setEnabled(false);
					    			  					      
					      }
					      
					      if (slider.getValue()==8)
					      {
					    	  calc.setBase(8);
					    	  b_note.setText("calculating in base 8");
					    	  for (int i=0; i < num.size(); i++)
					    		  if (i<8)
					    		  (num.get(i)).setEnabled(true);
					    		  else
					    		  (num.get(i)).setEnabled(false);
					    			  					      
					      }
					      
					      if (slider.getValue()==9)
					      {
					    	  calc.setBase(9);
					    	  b_note.setText("calculating in base 9");
					    	  for (int i=0; i < num.size(); i++)
					    		  if (i<9)
					    		  (num.get(i)).setEnabled(true);
					    		  else
					    		  (num.get(i)).setEnabled(false);
					    			  					      
					      }
					      
					      else if(slider.getValue()==10)
					      {
					    	  calc.setBase(10);
					    	  b_note.setText("calculating in base 10");
					    	  for (int i=0; i < num.size(); i++)
					    		  if (i<10)
					    		  (num.get(i)).setEnabled(true);
					    		  else
					    		  (num.get(i)).setEnabled(false);
					    			  					      
					      }
					      if (slider.getValue()==11)
					      {
					    	  calc.setBase(11);
					    	  b_note.setText("calculating in base 11");
					    	  for (int i=0; i < num.size(); i++)
					    		  if (i<11)
					    		  (num.get(i)).setEnabled(true);
					    		  else
					    		  (num.get(i)).setEnabled(false);
					    			  					      
					      }
					      
					      if (slider.getValue()==12)
					      {
					    	  calc.setBase(12);
					    	  b_note.setText("calculating in base 12");
					    	  for (int i=0; i < num.size(); i++)
					    		  if (i<12)
					    		  (num.get(i)).setEnabled(true);
					    		  else
					    		  (num.get(i)).setEnabled(false);
					    			  					      
					      }
					      
					      if (slider.getValue()==13)
					      {
					    	  calc.setBase(13);
					    	  b_note.setText("calculating in base 13");
					    	  for (int i=0; i < num.size(); i++)
					    		  if (i<13)
					    		  (num.get(i)).setEnabled(true);
					    		  else
					    		  (num.get(i)).setEnabled(false);
					    			  					      
					      }
					      
					      if (slider.getValue()==14)
					      {
					    	  calc.setBase(14);
					    	  b_note.setText("calculating in base 14");
					    	  for (int i=0; i < num.size(); i++)
					    		  if (i<14)
					    		  (num.get(i)).setEnabled(true);
					    		  else
					    		  (num.get(i)).setEnabled(false);
					    			  					      
					      }
					      
					      if (slider.getValue()==15)
					      {
					    	  calc.setBase(15);
					    	  b_note.setText("calculating in base 15");
					    	  for (int i=0; i < num.size(); i++)
					    		  if (i<15)
					    		  (num.get(i)).setEnabled(true);
					    		  else
					    		  (num.get(i)).setEnabled(false);
					    			  					      
					      }
					      else if(slider.getValue()==16)
					      {
					    	  calc.setBase(16);
					    	  b_note.setText("calculating in base 16");
					    	  for (int i=0; i < num.size(); i++)
					    		  if (i<16)
					    		  (num.get(i)).setEnabled(true);
					    		  else
					    		  (num.get(i)).setEnabled(false);
					    			  					      
					      }
					     }
					     } 
					    });
						
				slider.setOrientation(SwingConstants.VERTICAL);
				add(slider, "cell 0 2 2 5");
		
	}


		
	 class numListener implements ActionListener
	{
		public void actionPerformed (ActionEvent click)
		{
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
		}
	
				public void clear()
		{
			
			 textField.setText("");
			 current ="0";
			 numExpected = true;
			
		}
				
		public void print()
		{
			current = calc.equate();
			textField.setText(current);
		}
		
		public void readIn() 
		{
			inputA =textField.getText();
		}
		
		
		//NOTE:edit required, see log for issues w/ equals button
	class opListener implements ActionListener
		{
		 public void actionPerformed (ActionEvent e)
			{
			 	if (numExpected)
			 	{
			 		//clear();
			 		textField.setText("");
			 		calc.clear();
			 		textField.setText("oops trying entering a number.");
			 	}
			 	else
			 	{
			 numExpected = true;
			 	try{
				 inputA =textField.getText();
				 		 
				 if (lastOp.equals( "=" ))
				 {
				calc.setCurr(inputA);
				 }
				 else if (lastOp.equals("/"))
				 {				 	
					 calc.divide(inputA);
				  }
				 else if (lastOp.equals( "+" ))
				 {
					 calc.sum(inputA);
				 }
				 else if (lastOp.equals( "-" ))
				 {
					calc.subtract(inputA);
				 }
				 else  if (lastOp.equals( "*" ))
				 {
					calc.multiply(inputA);
				 }
				 
				 print();
				 
			 }
			catch(ArithmeticException oops) 
			 {
				clear();
				calc.clear();
				textField.setText("Not sure that's legal...");	
			 }
			 catch(NullPointerException nullie) //debug usage
			 {
				clear();
				calc.clear();
				textField.setText("I seem to be losing my faculties...");	
			 }
			 catch(Exception ex)
			 {
				 clear();
					calc.clear();
					textField.setText("Let's try that again..."); 
			 }
			lastOp = e.getActionCommand();
			 	
			
			}
			 	}

			}// end of oplistener decl
		 
		 
		 class freshListener implements ActionListener
		 {
			 public void actionPerformed (ActionEvent c)
			 {
				// clear();
				 textField.setText("");
				 calc.clear();
			 }
		 }
		 
		 
		
}

