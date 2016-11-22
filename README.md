# Project One


A multi-base Swing calculator project for CISC 3120, Fall 2016. For more information see [instructions](http://bc-cisc3120-f16.github.io/project1).

###DevNotes

<p>

Version:0.6.0c
</p>

<p>
revisions:
<ul>
	<li>documentation overhaul</li>
	<li>edit of equals button fn</li> 
	<li>fixed base of output error</li>
	<li>fixed javadoc commentary</li>
	<li>changed condition of opListener</li>
	<li>signFlip() method created</li>
		<ul><li>panel implementation pending</li></ul>
	<li>aesthetic changes</li>
		<ul><li> code: white space removal </li>
			<li> gui: colored buttons </li>
			<li> gui: set look and feel </li>
			</ul>	
</ul>

<p>

under development:
<ul>
	<li> set equals button to recur previous operation</li>
	<li> numpad operation </li>
	<li> keyboard interaction for JSlider<li>
</ul>
	
future development:	

<ul>
	<li> RPN Calculation </li>
	<li> Memento Design Pattern: stack and state control </li>

</ul>

IDE:
<ul>
	<li> Eclipse Neon.1 </li>
</ul>
</p>

notes for the user:
<p>

Current implementation allows for the use of the full 10-key numeric keys to enter numbers into the calculator for bases 2-10. For bases 11 through 16 the key of the letter that corresponds with the base can be pressed. Example, in base 16 
values are denoting 0-9 then the letters A-F. to enter the number 10 (decimal 10 not 10 in base 16 which is 16) one would use the 'A' key. 

At the moment mapping to the numeric keys of the num pad is not functional but the arithmetic operator keys
work just fine. The 'esc' key operates the clear button and the 'enter'/'return' key operates the equal button.


</p>

### Tools & Works Cited 

<em> Plugins:</em>

 <p><a href="http://www.eclipse.org/windowbuilder/">Window Builder Pro </a>
Useful Eclipse Plugin for handling GUI elements and layout design. The design view helped greatly in taking the guesswork out of component alignment. 
 </p>
 <br>

 <em> Logic: </em>
 <p><a href="https://en.wikipedia.org/wiki/Quaternary_numeral_system"> Quarternary Numbers</a> Explanation of Quarternary Number System. Offered charts that were helpful in checking output/test cases.
 </p>
 <p>
<a href="http://www.cleavebooks.co.uk/scol/calnumba.htm"> Number Base Calculator</a> Very helpful in testing Jslider and base conversion cases. Allows user to see representation of a specific value in multiple bases at one time.
</p>
<p>
<p>
<a href="http://www.java67.com/2014/05/3-examples-to-loop-map-in-java-foreach.html"> Map Looping </a> Great examples of different ways to loop over a map.
</p>

 <p><a href="http://stackoverflow.com/questions/27283908/java-jbutton-keylistener"> Java Key Binding Example</a> Unexpected find. Wanted an example of Key Listener use but this offered a alternative solution utilizing Key Bindings. Sample code lead to further perusal of the <a href="https://docs.oracle.com/javase/tutorial/uiswing/misc/keybinding.html">Key Binding </a> and <a href="https://docs.oracle.com/javase/7/docs/api/javax/swing/AbstractButton.html"> Abstract Button</a> APIs. Use of InputMaps and ActionMaps allow user to programmatically "click" the on-screen buttons using the keyboard( without having to duplicate numListener or opListener code inside a new KeyListener).
 </p> 
 <br>
 
 <em> Layout: </em>
 <p>
 <a href="http://www.oracle.com/technetwork/java/architecture-142923.html"> Swing Architecture</a> General information use.
 </p>
 <p> 
 <a href="http://miglayout.com/QuickStart.pdf"> MiGLayout Guide </a> Quick Start guide for the MigLayout.
 </p>
 <p>
 <a href="http://stackoverflow.com/questions/7612592/jframe-and-nimbus-look-and-feel"> Look & Feel</a> When trying to set the Look and Feel to "Nimbus" through Window Builder Pro I noticed that my calculator still showed the default windows/metal theme. I attempted the fix posted in this forum and noticed that while it did change the Jframe the inner JPanel/Gui components remained unchanged. Further research led me <a href=https://docs.oracle.com/javase/tutorial/uiswing/lookandfeel/nimbus.html> here </a>to some helpful Oracle Documentation(non-API web page) from which I utilized the provided try block.
 </p> 
 <br>
 
 <em> Documentation: </em>
 <p>
 <a href ="https://www.wired.com/2010/02/html_cheatsheet/"> HTML Cheat Sheet </a>
Syntax cheat sheet for Html. Great help in formatting documentation.
</p>
<a href= "http://corochann.com/get-to-know-coding-rule-of-javadoc-in-10-mins-366.html#see">JavaDoc Linking </a>Helpful in figuring out proper syntax for Javadoc commenting
</p>



