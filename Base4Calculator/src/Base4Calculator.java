import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UIManager.*;
/**
 * 
 * Base4Calculator is a multi-base calculator able to perform simple arithmetic operations
 * in any base including and between 2 and 16. The application is based on three class definitions:
 * Base4Calc which handles the calculator's logic, Base4Panels which handles the GUI aspects of
 * the calculator and Base4Calculator which builds the actual calculator using blueprint laid out
 * by Base4Panel class.
 * 
 *  @see {@link Base4Calc}
 * @see {@link Base4Panel}
 * @author zhi/N. Willis
 *
 */
public class Base4Calculator {

	public static void main(String[] args) {
		createAndShowGUI();
	}

	private static void createAndShowGUI() {
		
		try
		{
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e)
		
		{
				System.out.println("Desired look and feel unavailable, setting to system default");
				
		}
		finally
		{
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("Base 4 Calculator");			
		frame.add(new Base4Panel());

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setResizable(false);
		frame.setVisible(true);
		}
		
	}
}
