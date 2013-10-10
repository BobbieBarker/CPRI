/***************************************************************************
**Program: Patriot Smart Samstat (PSS)
**Author: Chad King && Jeff Rix
**Description: PSS provides the user a better SamStat experience in an effort to improve operator performance and minimize operator error.
**Input: Multitudes
**Output: Awesomeness
***************************************************************************/

package pss;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import com.google.common.net.InetAddresses;

public class PssMain extends JFrame {

	private JPanel contentPane;
	private JTextField greetingTextField;
	private JTextField userIpAddy;
	private JTextField networkInstructions;
	private JTextField targetOne;
	private JTextField targetTwo;
	private JTextField labelOne;
	private JTextField labelTwo;
	private String selectedFuType;
	private static String holder;
	private static String holder2;
	private static String holder3;
	private String selectedOH;
	private int ohCount; 
	private int gemcCount;
	private int gemTCount; 
	private JButton launchButton;
	private JTextField OHcollector;
	private JTextField OH;
	private JTextField ohCollector1;
	private JTextField oh1;
	private JTextField ohCollector2;
	private JTextField oh2;
	private String hostname;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args){
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PssMain frame = new PssMain();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}//End Catch
			}//End Run
		});//End EventQueue 
	}//End Main

	/**
	 * Create the frame.
	 * @return 
	 */
	public PssMain(){
		
	
		
		setAlwaysOnTop(true);
		setTitle("Patriot Smart SamStat");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		contentPane.setLayout(null);
		
		greetingTextField = new JTextField();
		greetingTextField.setEditable(false);
		greetingTextField.setHorizontalAlignment(SwingConstants.CENTER);
		greetingTextField.setText("Welcome to the Patriot Smart SamStat");
		greetingTextField.setBounds(102, 11, 218, 20);
		contentPane.add(greetingTextField);
		greetingTextField.setColumns(10);
		
		final JComboBox FUdropBox = new JComboBox();
		FUdropBox.setToolTipText("Please Identify Your Component");
		FUdropBox.setModel(new DefaultComboBoxModel(new String[] {"ECS", "BCP", "ICC", "TOC"}));//This needs to be saved in a variable.
		FUdropBox.setBounds(187, 91, 58, 20);
		contentPane.add(FUdropBox);
		
		userIpAddy = new JTextField();
		userIpAddy.setEditable(false);
		userIpAddy.setHorizontalAlignment(SwingConstants.CENTER);
		userIpAddy.setToolTipText("Your IP Address is:");
		userIpAddy.setText(findIpAddy());
		userIpAddy.setBounds(143, 42, 143, 20);
		contentPane.add(userIpAddy);
		userIpAddy.setColumns(10);
		
		final JButton nextButton = new JButton("Next");
		nextButton.setToolTipText("Advance to network Configuration");
		nextButton.setBounds(171, 195, 89, 23);
		contentPane.add(nextButton);
		
		
	
		nextButton.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent arg0) {
				selectedFuType = (String)FUdropBox.getSelectedItem();

				if(selectedFuType.equals("TOC")){
					BNPssGUI BNPssGUI = new BNPssGUI();
					BNPssGUI.setVisible(true);
					PssMain.this.dispose();
				}
				contentPane.removeAll();
				contentPane.repaint();
				
				//Pac3 OH entry field
				OHcollector = new JTextField();
				OHcollector.setToolTipText("ENTER YOUR CURRENT PAC3 OH HAND MISSILE COUNT");
				OHcollector.setBounds(338, 77, 86, 20);
				if(!selectedFuType.equals("TOC")){  //Keeps the user from seeing these fields if they selected ToC
				contentPane.add(OHcollector);
				}
				OHcollector.setColumns(10);
				
				//Pac3 prompt
				OH = new JTextField();
				OH.setEditable(false);
				OH.setText("PAC3 OH COUNT");
				OH.setBounds(230, 77, 105, 20);
				if(!selectedFuType.equals("TOC")){
				contentPane.add(OH);
				}
				OH.setColumns(10);
				
				//GemC OH entry field
				ohCollector1 = new JTextField();
				ohCollector1.setToolTipText("ENTER YOUR CURRENT GEM-C OH HAND MISSILE COUNT");
				ohCollector1.setBounds(338, 110, 86, 20);
				if(!selectedFuType.equals("TOC")){
				contentPane.add(ohCollector1);
				}
				ohCollector1.setColumns(10);
				
				//GemC prompt
				oh1 = new JTextField();
				oh1.setEditable(false);
				oh1.setText("GEMC OH COUNT");
				oh1.setColumns(10);
				oh1.setBounds(230, 110, 106, 20);
				if(!selectedFuType.equals("TOC")){
				contentPane.add(oh1);
				}
				
				//GemC OH entry field
				ohCollector2 = new JTextField();
				ohCollector2.setToolTipText("ENTER YOUR CURRENT GEM-T OH HAND MISSILE COUNT");
				ohCollector2.setBounds(338, 143, 86, 20);
				if(!selectedFuType.equals("TOC")){
				contentPane.add(ohCollector2);
				}
				ohCollector2.setColumns(10);
				
				//GemC prompt
				oh2 = new JTextField();
				oh2.setEditable(false);
				oh2.setText("GEMT OH COUNT");
				oh2.setColumns(10);
				oh2.setBounds(230, 143, 106, 20);
				if(!selectedFuType.equals("TOC")){
				contentPane.add(oh2);
				}
				
				
				networkInstructions = new JTextField();
				networkInstructions.setEditable(false);
				networkInstructions.setText("Please enter the IP Addresses");
				networkInstructions.setToolTipText("If a Component is not connected to your net leave their field blank");
				networkInstructions.setHorizontalAlignment(SwingConstants.CENTER);
				networkInstructions.setBounds(102, 11, 218, 20);
				contentPane.add(networkInstructions);
				networkInstructions.setColumns(10);
				
				targetOne = new JTextField();
				targetOne.setToolTipText("Enter target IP address here:");
				targetOne.setText("xxx.xxx.xxx.xxx");
				targetOne.setBounds(55, 77, 100, 20);
				contentPane.add(targetOne);
				targetOne.setColumns(10);
				
				targetTwo = new JTextField();
				targetTwo.setToolTipText("Enter target IP address here:");
				targetTwo.setText("xxx.xxx.xxx.xxx");
				targetTwo.setColumns(10);
				targetTwo.setBounds(55, 108, 100, 20);
				contentPane.add(targetTwo);

				labelOne = new JTextField();
				labelOne.setEditable(false);
				labelOne.setBounds(10, 77, 40, 20);
				contentPane.add(labelOne);
				labelOne.setColumns(10);
				
				labelTwo = new JTextField();
				labelTwo.setEditable(false);
				labelTwo.setColumns(10);
				labelTwo.setBounds(10, 108, 40, 20);
				contentPane.add(labelTwo);

				broadCastSetter();
				if(selectedFuType.equals("ICC")){
					contentPane.remove(targetTwo);
					contentPane.remove(labelTwo);
					
					contentPane.remove(OHcollector);
					contentPane.remove(ohCollector1);
					contentPane.remove(ohCollector2);
					contentPane.remove(OH);
					contentPane.remove(oh1);
					contentPane.remove(oh2);	
				}
				
				
				contentPane.remove(nextButton);
				final JButton launchButton = new JButton("Launch");
				launchButton.setToolTipText("This button will activate your PSS Station");
				launchButton.setBounds(247, 194, 89, 23);
				contentPane.add(launchButton);
				contentPane.repaint();
				launchButton.addMouseListener(new MouseAdapter(){
					@Override
					public void mouseClicked(MouseEvent arg0) {
						if(selectedFuType.equals("ICC")){
							if(!ipValidation(targetOne)){
								JOptionPane.showMessageDialog(null, "Please enter a valid IP address", "Input Error", JOptionPane.ERROR_MESSAGE);
							}else{
							String addy1 = targetOne.getText();
							connected unitAddys = new connected(addy1, "null");
							PssGui pssGui = new PssGui(selectedFuType, ohCount, gemcCount, gemTCount, unitAddys);
							pssGui.setVisible(true);
							PssMain.this.dispose();
							}
						}else{
						
						
						
						holder = OHcollector.getText();
						holder2 = ohCollector1.getText();
						holder3 = ohCollector2. getText();
						
				
						//What follows is some custom input validation to avoid negative numbers, empty text fields, and letters. 
						if(OHcollector.getText().length() == 0 || ohCollector1.getText().length() == 0 || ohCollector1.getText().length() == 0){
						JOptionPane.showMessageDialog(null, "Please do not leave any fields empty if you don't\nhave any on hand missiles for a certain missile\n type then enter a zero", "Input Error", JOptionPane.ERROR_MESSAGE);
						}
						else if(OHcollector.getText().length() > 0 && ohCollector1.getText().length() > 0 && ohCollector1.getText().length() > 0){
							try {
								ohCount = Integer.parseInt(holder);
								gemcCount = Integer.parseInt(holder2);
								gemTCount = Integer.parseInt(holder3);
								if(ohCount < 0 || gemcCount < 0 || gemTCount < 0){
									JOptionPane.showMessageDialog(null, "Please do not use any negative numbers\n enter your current on hand missile counts", "Input Error", JOptionPane.ERROR_MESSAGE);
									OHcollector.setText("");
									ohCollector1.setText("");
									ohCollector2.setText("");
								
								}else if(!ipValidation(targetOne) || !ipValidation(targetTwo)){//Validate user inputed IPV4 addresses
									targetOne.setText("");
									targetTwo.setText("");
									JOptionPane.showMessageDialog(null, "Please enter a valid IP address", "Input Error", JOptionPane.ERROR_MESSAGE);
									
								}else{
								
									try {
										String addy1 = targetOne.getText();
										String addy2 = targetTwo.getText();
										
										connected unitAddys = new connected(addy1, addy2);
										PssGui pssGui = new PssGui(selectedFuType, ohCount, gemcCount, gemTCount, unitAddys);
										pssGui.setVisible(true);
										PssMain.this.dispose();
									} catch (Exception e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									}
								
							} catch (NumberFormatException e) {
									JOptionPane.showMessageDialog(null, "Please do not use any letters\n enter your current on hand missile counts", "Input Error", JOptionPane.ERROR_MESSAGE);
									OHcollector.setText("");
									ohCollector1.setText("");
									ohCollector2.setText("");
							}
						}
						}
					}//End Event listener
				});//End 2nd mouse LIstener
			}//End Mouse Click event
		});//End Action Listener
	}//End PssMain
	
	public void broadCastSetter(){
		final String ECS = "ECS";
		final String BCP = "BCP";
		final String ICC = "ICC";

		switch ((String)selectedFuType){
		
		case ECS: selectedFuType.equals("ECS");
			labelOne.setText("BCP");
			labelTwo.setText("TOC");
			//labelThree.setText("TOC");
			break;
		case BCP: 
			labelOne.setText("ECS");
			labelTwo.setText("TOC");
		//	labelThree.setText("TOC");
			break;
		case ICC:
			labelOne.setText("TOC");
		//	labelTwo.setText("BCP");
		//	labelThree.setText("TOC");
			break;
		
		}//End Switch
	}
	
	
	public String getFUtype(){
	return this.selectedFuType;
	}
	
	
	public void setOHCount(String input){
		this.selectedOH = input;
		this.ohCount = Integer.parseInt(this.selectedOH);
	}
	
	public int getOhCount(){
		return ohCount;
	}
	
	public String findIpAddy(){
		 try
	        {
	            InetAddress addr = InetAddress.getLocalHost();
	            hostname = addr.getHostAddress();
	            
	        }catch(UnknownHostException e){
	             //throw Exception --- need to write custom exception later!
	        }
		
		return hostname;
	    }
	
	public boolean ipValidation(JTextField field1){
		
		String addy = field1.getText();
		boolean isValid = InetAddresses.isInetAddress(addy);
		if(isValid == true){
		return true;
		}else if(field1.getText().equalsIgnoreCase("")){
			return true;
		}
		else{
			return(false);
		}
	}//end ipValidation
}//End Class