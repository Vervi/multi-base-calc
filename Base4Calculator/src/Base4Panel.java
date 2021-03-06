import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import net.miginfocom.swing.MigLayout;
import java.util.*;
/**
 ** <p>
 *	Base4Panel class lays out the Graphical User Interface components of our Calculator.
 *  Utilizes methods in the Base4Calc class to handle action events.
 * </p>
 * @see {@link Base4Calc}
 * @see {@link Base4Calculator}
 * @author zhi/N. Willis

* @version 0.6.0
 * 
 * Methods:
 *  @see #addKeyPress()
 *  @see #print()
 *  @see #baseNotifier()
 *  @see #toggleNumKeys()
 *  @see #clear()
 *  @see #setSlider(JSlider)
 *  @see #numChange()
 *  
 *  @see numListener
 *  @see opListener
 *  @see freshListener
 *  
 */
public class Base4Panel extends JPanel {

	
	private static final long serialVersionUID = 1L;

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
	String current="0";
		
	private boolean numExpected = true;
	private JLabel b_note;	//label to indicate current base
	private int prevBase;
	
	private HashMap<Integer,JButton> num;
	private HashMap<Integer,JButton> op;
	private ArrayList<JButton> numList;
	
	
	private InputMap inMap;
	private ActionMap actMap;
	
	/**
	 * Constructor of the Base4Panel utilizes the MigLayout to arrange GUI components.
	 * 
	 */
	@SuppressWarnings("serial")
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
		
		//initialize/fill map for ease of access/modification of state & adding keypad fn
		num = new HashMap<Integer,JButton>(){ 
			{
			put((KeyEvent.VK_0) ,zero);
			put((KeyEvent.VK_1) ,one);
			put((KeyEvent.VK_2),two);
			put((KeyEvent.VK_3),three);
			put((KeyEvent.VK_4),four);
			put((KeyEvent.VK_5),five);
			put((KeyEvent.VK_6),six);
			put((KeyEvent.VK_7),seven);
			put((KeyEvent.VK_8),eight);
			put((KeyEvent.VK_9),nine);
			put((KeyEvent.VK_A),ten);
			put((KeyEvent.VK_B),elvn);
			put((KeyEvent.VK_C),twelve);
			put((KeyEvent.VK_D),thrtn);
			put((KeyEvent.VK_E),fourtn);
			put((KeyEvent.VK_F),fiftn);
			}
			};
			
			numList = new ArrayList<JButton>(){
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
			Collection<JButton> numkeys = num.values();
			for (JButton jb : numkeys ) 
			{
				jb.addActionListener(digit);
				jb.setForeground(Color.BLUE);
			}
						
			
		//creation of operand buttons
				clear = new JButton("C");//clear button gets its own listener
				clear.addActionListener(clr);
				clear.setForeground(Color.RED);
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

				op = new HashMap<Integer,JButton>(){
				{	
				put((KeyEvent.VK_ADD),plus);
				put((KeyEvent.VK_SUBTRACT),minus);
				put((KeyEvent.VK_MULTIPLY),multiply);
				put((KeyEvent.VK_DIVIDE),divide);
				put((KeyEvent.VK_ENTER),equals);
				}
				};
			
				Collection<JButton> opkeys = op.values();
				for (JButton jb : opkeys ) 
				{
					jb.addActionListener(operand);
					jb.setForeground(Color.MAGENTA);
				}
		
				//add Keyboard Functionality
				Set<Map.Entry<Integer, JButton>> numSet = num.entrySet();
				addKeyPress(numSet);
				Set<Map.Entry<Integer, JButton>> opSet = op.entrySet();
				addKeyPress(opSet);
				
				//add keyboard for clear button
				inMap = clear.getInputMap(WHEN_IN_FOCUSED_WINDOW);
			    actMap = clear.getActionMap();
			    inMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "keyPress");
			    actMap.put("keyPress", new AbstractAction() 
			     {
			       @Override
		          public void actionPerformed(ActionEvent press) 
		          {
	                JButton key = (JButton) press.getSource();
	                key.doClick();
	            }
			     });
	
			//Creation of Jslider
				slider = new JSlider();
				slider.setMinorTickSpacing(1);
				slider.setSnapToTicks(true);
				slider.setPaintLabels(true);
				slider.setMajorTickSpacing(2);
				slider.setMinimum(2);
				slider.setMaximum(16);
				
				slider.setValue(16);
				prevBase = 16; //initial condition
				baseNotifier();
				slider.addChangeListener(new ChangeListener() 
				{
					public void stateChanged(ChangeEvent e) 
					{
					JSlider source = (JSlider)e.getSource();
					if (!source.getValueIsAdjusting())
					    {
						prevBase=calc.getBase();
					  	setSlider(slider);
					    }
					}
			     });//end changeListener decl
						
				slider.setOrientation(SwingConstants.VERTICAL);
				add(slider, "cell 0 2 2 5");
		}//end of constructor

	/**
	 * addKeyPress(Set S) takes a set object of type <Map.Entry<Integer, JButton> and loops through the entries 
	 * to create inputMaps and actionMaps. Method is designed to allow the calculator to programmatically emulate a
	 * button click using the keyboard. Method does not return.
	 * 
	 * @param A : set made of a map that uses KeyEvent integers and Jbuttons as KV pairs
	 * 
	 */
	public void addKeyPress(Set<Map.Entry<Integer, JButton>> A)
	{
	for (Map.Entry<Integer,JButton> pair : A) 
	{
		
		JButton jb = pair.getValue();
						
		inMap = jb.getInputMap(WHEN_IN_FOCUSED_WINDOW);
        actMap = jb.getActionMap();
        
        inMap.put(KeyStroke.getKeyStroke(pair.getKey(), 0), "keyPress");//0 indicates no modifiers
   	    actMap.put("keyPress", new AbstractAction() 
        {
            @Override
            public void actionPerformed(ActionEvent press) 
            {
                JButton key = (JButton) press.getSource();
                key.doClick();
            }
     });//end of override fn
	}
	}//end method decl
	
	/**
	 *  numListener is an implementation of ActionListener used with numeric keys/buttons. It handles writing 
	 *  number strings to the calculator's display.
	 */
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
		}//end inner class decl
	
	 	/**
	 	 * clear () method takes no parameters and has no return value. It resets the state of the calculator (irrespective
	 	 * of base setting).
	 	 * 
	 	 */ 
	 	 
		public void clear()
		{
			 textField.setText("");
			 current ="0";
			 numExpected = true;
		}//end method decl
				
		/**
		 * print() method takes no parameters and has no return value. It handles output to the
		 * calculator's "display".
		 */
		public void print()
		{
			current = calc.equate();
			if (current=="0")
				textField.setText("");
			else
			textField.setText(current);
		}//end method decl
		
		/**
		 *  opListener is an implementation of the ActionListener Interface.
		 * It is used to call methods form the Base4Calc class to handle arithmetic
		 * operations based on button presses.
		 * 
		 * @see Base4Calc
		 *
		 */
	class opListener implements ActionListener
		{
		 public void actionPerformed (ActionEvent e)
			{
			 	if (numExpected & !lastOp.equals("="))
			 	{
			 		
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
			 				//numExpected=false;
				    				
			 			}
			 			else if (lastOp.equals("/"))
			 			{	
					 		inputA= Integer.toString(calc.base10in(inputA));			 	
			 				calc.divide(inputA);
			 			}
			 			else if (lastOp.equals( "+" ))
			 			{
			 				inputA= Integer.toString(calc.base10in(inputA));
			 				calc.sum(inputA);
			 			}
			 			else if (lastOp.equals( "-" ))
			 			{
			 				inputA= Integer.toString(calc.base10in(inputA));
			 				calc.subtract(inputA);
			 			}
			 			else  if (lastOp.equals( "*" ))
				 	{
			 				inputA= Integer.toString(calc.base10in(inputA));
			 				calc.multiply(inputA);
				 	}
			 					 				
			 			print();
				 
			 		}
					catch(ArithmeticException oops) 
					 {
						clear();
						calc.clear();
						textField.setText("Illegal Operation");	
					 }
					 catch(NumberFormatException nfe)
					 	{
						 clear();
						 calc.clear();
						 textField.setText("Illegal entry");				
					 	}
					 catch(NullPointerException nullie) //debug usage
					 {
						clear();
						calc.clear();
						textField.setText("Find the missing link");	
					 }
					 catch(Exception ex)
					 {
						 clear();
							calc.clear();
							textField.setText("Let's try that again..."); 
							ex.printStackTrace();
					 }
					 finally
					 {
					lastOp = e.getActionCommand();
					prevBase= calc.getBase();
					 }	 	
				
			 	}
			}

		}// end of inner class decl
		 
		 /**
		  * 
		  * freshListener is an implementation of the ActionListener Interface.
		  * It is used with the clear button.
		  *
		  */
		 class freshListener implements ActionListener
		 {
			 public void actionPerformed (ActionEvent c)
			 {
				
				 textField.setText("");
				 calc.clear();
			 }
		 }//end inner class decl
		 
		 /**
		  * setSlider(Jslider JS) method takes a Jslider as a parameter and does not return anything. It finds the minimum
		  * and maximum values on the slider and then loops through them all setting the calculator base to the integer value
		  * returned by JSlider.getValue(). Method calls baseNotifier() and toggleNumKeys();
		  *   
		  * @param JS slider to control calculator base and button configuration
		  * 
		  * @see Base4Calc#setBase(int)
		  * @see #baseNotifier()
		  * @see #toggleNumKeys()
		  */
		 void setSlider(JSlider JS)
			{
				for (int i=JS.getMinimum(); i< JS.getMaximum()+1 ;i++)
				if (slider.getValue()==i)
			      {
			    	  calc.setBase(i);
			    	  baseNotifier();
			    	  toggleNumKeys();
			    	  numChange();
			    	  			    	  
			      }//end method decl
			}
		 /**
		  * baseNotifier() method is of type void and takes no parameters. Based on what base calculations are currently
		  * being done in, jLabel text will change to indicate the current base.
		  *
		  */
		 void baseNotifier()
			{
				 b_note.setText("Base " + calc.getBase());
			}//end method decl
		 
		/**
		 * toogleNumKeys() method is of type void and it takes no parameters. It loops through (in this case) an 
		 * ArrayList of Jbuttons and activates/deactivates them depending on what base calculations are currently
		 * being done in.
		 * 
		 */
		public void toggleNumKeys()
			{
			for (int i=0; i < numList.size(); i++)
		  		  if (i<calc.getBase())
		   		  (numList.get(i)).setEnabled(true);
		   		  else
		   		  (numList.get(i)).setEnabled(false);
			}//end method decl
		
		 /**
		  * numChange() method takes no parameters and has no return value. It reads in a string from
		  *  the calculator's display in the last known base and spits it back to the display in the current
		  *  base. Used inside of the setSlider method inside of the Jslider changeListener. For reference purposes, current base is
		  *  updated/maintained elsewhere in the setSlider method while prevBase is updated via both the opListener and changeListener.  
		  */
		 public void numChange()
		 {
			 try{
				 inputA= textField.getText();
			 if(!(inputA.equals("")|inputA =="")) 
			 {		 
			  int x = Integer.valueOf(inputA, prevBase);	
			 // System.out.println(prevBase); //test line
			inputA= Integer.toString(x,calc.getBase());
			//System.out.println(calc.getBase());//test line
			 textField.setText(inputA);
			 }
			 }
			 catch (NumberFormatException nfe)
			 {
				 textField.setText("Exceeds our boundaries...");
				 calc.clear();
				 //clear();
			 }
		 }//end method decl
		 
		
}//end of class decl