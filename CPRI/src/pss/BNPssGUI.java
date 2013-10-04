package pss;

import javax.swing.JFrame;

import java.awt.EventQueue;
import java.awt.Rectangle;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import pss.PssGui.FileReceiver2;
import pss.PssGui.FileReceiver2.ClientHandler;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import java.util.TimeZone;

import flexjson.JSONDeserializer;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class BNPssGUI extends JFrame implements Utility, PSSbehaviours{


	private JTextField secretHeaderLeft; // top secret message to the top right
	private JTextField samStatHeader; //header message to samstat
	private JTextField secretHeaderRight;//top secret message to the top left
	private JTextField effectiveDtg;//header for date time group (DTG) info
	private JTextField currentDtg;//field holds current DTG info
	private JTextField unitHeader;
	private JTextField typeHeader;
	private JTextField alertStateHeader;
	private JTextField bnId;
	private JTextField curHeader;
	private JTextField dirHeader;
	private JTextField HHBUnitId;
	private JTextField HHBsystemType;
	private JComboBox HHBcurSelector;
	private JComboBox HHBdirSelector;
	private JTextField blackspace;
	private JTextArea ARemarks;
	private JTextPane DefAssetHeader;
	private JTextArea HHBdefendedAssets;
	private JTextField locationHeader;
	private JTextField HHBcurLocation;
	private JTextField etroHeader;
	private JTextField ptlHeader;
	private JTextField HHBcurEtro;
	private JTextField HHBcurPtl;
	private JTextField stlHeader;
	private JTextField HHBcurStl;
	private JTextField missileHeader;
	private JTextField pac_3Header;
	private JTextField pac_3OpHeader;
	private JTextField pac_3InopHeader;
	private JTextField pac_3OhHeader;
	private JTextField gemCHeader;
	private JTextField GemcOpHeader;
	private JTextField GemcInopHeader;
	private JTextField GemCOhHeader;
	private JTextField gemTHeader;
	private JTextField gemtOpHeader;
	private JTextField gemtInopHeader;
	private JTextField gemtOhHeader;
	private JTextField missileCountHeader;
	private JTextField launchersHeader;
	private JTextField remarksHeader;
	private JTextField launchersInopHeader;
	private JTextField launchersOPheader;
	private JTextField HHBtotalMissileCount;
	private JTextField ASystemType;
	private JTextPane faultHeader;
	private JTextArea remarksField;
	private JTextField HHBOpPac3;
	private JTextField HHBInOpPac3;
	private JTextField HHBPac3Oh;
	private JTextField HHBGemCOP;
	private JTextField HHBGemCInOp;
	private JTextField HHBGemCOh;
	private JTextField HHBGemTOP;
	private JTextField HHBGemTInOp;
	private JTextField HHBGemTOH;
	private JTextField HHBLs;
	private JTextField HHBInopLs;
	private JTextField HHBOPpac2L;
	private JTextField HHBInopPac2L;
	private JTextField aUnitId;
	private JTextField bUnitId;
	private JTextField cUnitId;
	private JTextField dUnitId;
	private JTextField stoHeader;
	private JTextArea AdefendedAssets;
	private JTextField AcurLocation;
	private JTextField AcurEtro;
	private JTextField AcurPtl;
	private JTextField AcurStl;
	private JTextField AOpPac3;
	private JTextField AInOpPac3;
	private JTextField APac3Oh;
	private JTextField AGemCOP;
	private JTextField AGemCInOp;
	private JTextField AGemCOh;
	private JTextField AGemTOP;
	private JTextField AGemTInOp;
	private JTextField AGemTOH;
	private JTextField AtotalMissileCount;
	private JTextField AOPLs;
	private JTextField AOPpac2L;
	private JTextField AInopLs;
	private JTextField AInopPac2L;
	private JTextField BSystemType;
	private JTextField CSystemType;
	private JTextField DSystemType;
	private JTextField ACurAS;
	private JTextField BCurAS;
	private JTextField CCurAS;
	private JTextField DCurAS;
	private JTextField ADirAS;
	private JTextField BDirAS;
	private JTextField CDirAS;
	private JTextField DDirAS;
	private JTextArea BdefendedAssets;
	private JTextArea CdefendedAssets;
	private JTextArea DdefendedAssets;
	private JTextField BcurLocation;
	private JTextField CcurLocation;
	private JTextField DcurLocation;
	private JTextField BcurEtro;
	private JTextField CcurEtro;
	private JTextField DcurEtro;
	private JTextField BcurPtl;
	private JTextField CcurPtl;
	private JTextField DcurPtl;
	private JTextField BcurStl;
	private JTextField CcurStl;
	private JTextField DcurStl;
	private JTextField BOpPac3;
	private JTextField COpPac3;
	private JTextField DOpPac3;
	private JTextField BInOpPac3;
	private JTextField CInOpPac3;
	private JTextField DInOpPac3;
	private JTextField BPac3Oh;
	private JTextField CPac3Oh;
	private JTextField DPac3Oh;
	private JTextField BGemCOP;
	private JTextField CGemCOP;
	private JTextField DGemCOP;
	private JTextField BGemCInOp;
	private JTextField CGemCInOp;
	private JTextField DGemCInOp;
	private JTextField BGemCOh;
	private JTextField CGemCOh;
	private JTextField DGemCOh;
	private JTextField BGemTOP;
	private JTextField CGemTOP;
	private JTextField DGemTOP;
	private JTextField BGemTInOp;
	private JTextField CGemTInOp;
	private JTextField DGemTInOp;
	private JTextField BGemTOH;
	private JTextField CGemTOH;
	private JTextField DGemTOH;
	private JTextField BtotalMissileCount;
	private JTextField CtotalMissileCount;
	private JTextField DtotalMissileCount;
	private JTextArea BRemarks;
	private JTextArea CRemarks;
	private JTextArea DRemarks;
	private JTextField BOPLs;
	private JTextField BInopLs;
	private JTextField BOPpac2L;
	private JTextField BInopPac2L;
	private JTextField COPLs;
	private JTextField CInopLs;
	private JTextField COPpac2L;
	private JTextField CInopPac2L;
	private JTextField DOPLs;
	private JTextField DInopLs;
	private JTextField DOPpac2L;
	private JTextField DInopPac2L;
	private JTextField stoSelector;
	private JTextField txtAcospins;
	private JTextField acoSelector;
	private JTextField Pac3OPcount;
	private JTextField Pac3InopCount;
	private JTextField Pac3OHCount;
	private JTextField GemCOPCount;
	private JTextField GemCInopCount;
	private JTextField GemCOHCount;
	private JTextField GemTOPCount;
	private JTextField GemTInopCount;
	private JTextField GemTOHCount;
	private JTextField BnTotalCount;
	private JTextField BnOpLsCount;
	private JTextField BnPac2OPCount;
	private JTextField BnLsInopCount;
	private JTextField BnPac2InopCount;
	private JTextField curSto;
	private JTextField curAco;
	private JTextField curDTG;
	private JTextField hhbCurSto;
	private JTextField aCurSto;
	private JTextField bCurSto;
	private JTextField cCurSto;
	private JTextField dCurSto;
	private JTextField hhbCurAco;
	private JTextField aCurAco;
	private JTextField bCurAco;
	private JTextField cCurAco;
	private JTextField dCurAco;
	private JTextField hhbDtg;
	private JTextField aDtg;
	private JTextField bDtg;
	private JTextField cDtg;
	private JTextField dDtg;
	private Color lBackGround;
	private String starter = "Place Holder";
	private static int color = 0;
	
	private unitData FUdata;
	private fireUnitData status;
	private JTextArea HHBRemarks;
	
	
	
	BNPssGUI(){
		
			//starts receiver code
			startFileReceiver();	
		
		
			//Thread myThread = new Thread(new FileReceiver2(5000));

			//myThread.start();
			
			
			//Sets the title for the JFrame and some behavior/attributes for the frame. 
			setTitle("PATRIOT SMART SAMSTAT");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setAlwaysOnTop(true);
			getContentPane().setBackground(Color.GRAY);
			setBounds(new Rectangle(1500, 500, 1844, 675));
			getContentPane().setLayout(null);
			
			//This component exists for esthetic purposes. 
			blackspace = new JTextField();
			blackspace.setEditable(false);
			blackspace.setBackground(Color.BLACK);
			blackspace.setBounds(299, 21, 554, 41);
			getContentPane().add(blackspace);
			blackspace.setColumns(10);
			
			
			
			//Provides a header as per the design of the SamStat report.
			secretHeaderLeft = new JTextField();
			secretHeaderLeft.setForeground(Color.RED);
			secretHeaderLeft.setEditable(false);
			secretHeaderLeft.setHorizontalAlignment(SwingConstants.CENTER);
			secretHeaderLeft.setText("SECRET WHEN FILLED IN");
			secretHeaderLeft.setBounds(0, 0, 301, 20);
			getContentPane().add(secretHeaderLeft);
			secretHeaderLeft.setColumns(10);
			
			//Provides a header as per the design of the SamStat report.
			samStatHeader = new JTextField();
			samStatHeader.setHorizontalAlignment(SwingConstants.CENTER);
			samStatHeader.setBackground(Color.YELLOW);
			samStatHeader.setText("BATTALION SAMSTATREP");
			samStatHeader.setEditable(false);
			samStatHeader.setBounds(299, 0, 1247, 20);
			getContentPane().add(samStatHeader);
			samStatHeader.setColumns(10);
			
			//Provides a header as per the design of the SamStat report. 
			secretHeaderRight = new JTextField();
			secretHeaderRight.setHorizontalAlignment(SwingConstants.CENTER);
			secretHeaderRight.setForeground(Color.RED);
			secretHeaderRight.setText("SECRET WHEN FILLED IN");
			secretHeaderRight.setEditable(false);
			secretHeaderRight.setColumns(10);
			secretHeaderRight.setBounds(1544, 0, 284, 20);
			getContentPane().add(secretHeaderRight);
			
			//PRovides a header for our current DTG component. 
			effectiveDtg = new JTextField();
			effectiveDtg.setEditable(false);
			effectiveDtg.setHorizontalAlignment(SwingConstants.CENTER);
			effectiveDtg.setText("EFFECTIVE DTG:");
			effectiveDtg.setBounds(0, 21, 161, 20);
			getContentPane().add(effectiveDtg);
			effectiveDtg.setColumns(10);
			
			//This component will store the current DTG for the samstat. 
			currentDtg = new JTextField();
			currentDtg.setHorizontalAlignment(SwingConstants.CENTER);
			currentDtg.setToolTipText("Your Current DTG");
			currentDtg.setEditable(false);
			currentDtg.setBounds(161, 21, 140, 20);
			currentDtg.setText(zTime());
			//currentDtg.setText(zTime());
			getContentPane().add(currentDtg);
			currentDtg.setColumns(10);
			
			//Provides a header to the component that identifies the unit. 
			unitHeader = new JTextField();
			unitHeader.setEditable(false);
			unitHeader.setBackground(Color.ORANGE);
			unitHeader.setHorizontalAlignment(SwingConstants.CENTER);
			unitHeader.setToolTipText("Unit Name");
			unitHeader.setText("Unit");
			unitHeader.setBounds(0, 42, 79, 20);
			getContentPane().add(unitHeader);
			
			//Provides a header to the unit type box. 
			typeHeader = new JTextField();
			typeHeader.setEditable(false);
			typeHeader.setText("TYPE");
			typeHeader.setHorizontalAlignment(SwingConstants.CENTER);
			typeHeader.setColumns(10);
			typeHeader.setBackground(Color.YELLOW);
			typeHeader.setBounds(75, 42, 86, 20);
			getContentPane().add(typeHeader);
			
			//provides a header for our current and directed alert state components. 
			alertStateHeader = new JTextField();
			alertStateHeader.setHorizontalAlignment(SwingConstants.CENTER);
			alertStateHeader.setBackground(new Color(218, 165, 32));
			alertStateHeader.setText("ALERT STATE");
			alertStateHeader.setEditable(false);
			alertStateHeader.setColumns(10);
			alertStateHeader.setBounds(161, 42, 92, 20);
			getContentPane().add(alertStateHeader);
			
			//This component may need to be adjusted to either a drop box containing all current active battalions or an editable box allowing the user to place what ever they want
			//This component provides information on which battalion the unit belongs to. 
			bnId = new JTextField();
			bnId.setToolTipText("Identify your Battalion");
			bnId.setBackground(new Color(128, 128, 128));
			bnId.setHorizontalAlignment(SwingConstants.CENTER);
			bnId.setText("4-5 AMD BN");
			bnId.setBounds(0, 63, 161, 52);
			getContentPane().add(bnId);
			bnId.setColumns(10);
			
			//This component provides a header to the current AS box.
			curHeader = new JTextField();
			curHeader.setEditable(false);
			curHeader.setBackground(new Color(218, 165, 32));
			curHeader.setText("CUR");
			curHeader.setHorizontalAlignment(SwingConstants.CENTER);
			curHeader.setBounds(161, 63, 45, 52);
			getContentPane().add(curHeader);
			curHeader.setColumns(10);
			
			//This Component provides a header to the dir AS box. 
			dirHeader = new JTextField();
			dirHeader.setEditable(false);
			dirHeader.setBackground(new Color(218, 165, 32));
			dirHeader.setHorizontalAlignment(SwingConstants.CENTER);
			dirHeader.setText("DIR");
			dirHeader.setColumns(10);
			dirHeader.setBounds(207, 63, 45, 52);
			getContentPane().add(dirHeader);
			
			//This component allows the user to store information on current unit identifier. Maybe necessary to pass this in as an arguement to the PssGui since there is no accounting for callsigns. 
			//This component also needs to be updated with a mouse click event that can turn the color of the box to reflect the tooltip text.
			HHBUnitId = new JTextField();
			HHBUnitId.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					
					//This if/else if/else statement allows the user to control the background of this JTextField by clicking on the box
					if(color ==0){
						HHBUnitId.setBackground(Color.WHITE);
						color++;
					}
					else if(color==1){
						HHBUnitId.setBackground(Color.RED);
						color++;
					}else{
						color=0;
						HHBUnitId.setBackground(Color.GREEN);	
					}
					
					
				}
			});
			HHBUnitId.setHorizontalAlignment(SwingConstants.CENTER);
			HHBUnitId.setToolTipText("<html>SHADE CELLS TO REFLECT CURRENT UNIT STATUS:" + "<br/>GREEN-MC" + "<br/>RED-NMC" + "<br/>WHITE-UNIT IN TRANSISTION</html>");
			HHBUnitId.setText("Set Unit Name");
			HHBUnitId.setBounds(0, 116, 84, 96);
			getContentPane().add(HHBUnitId);
			HHBUnitId.setColumns(10);
		
			
			
			
			//This component allows the user to store information about the type of system the unit is reporting on. Allowing the selections for avenger or stinger maybe moot points.
			HHBsystemType = new JTextField();
			HHBsystemType.setHorizontalAlignment(SwingConstants.CENTER);
			HHBsystemType.setToolTipText("<html>ENTER SYSTEM TYPE:" + "<br/>PAT" + "<br/>AVENGER"+ "<br/>STINGER" + "<br/>THAAD</html>");
			HHBsystemType.setBounds(83, 116, 79, 96);
			getContentPane().add(HHBsystemType);
			
			//This component allows the user to store information about the alert state they are currently at. 
			HHBcurSelector = new JComboBox();
			HHBcurSelector.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7"}));
			HHBcurSelector.setEditable(false);
			HHBcurSelector.setToolTipText("CURRENT ALERT STATE");
			HHBcurSelector.setBounds(161, 116, 45, 96);
			getContentPane().add(HHBcurSelector);
			
			//This component allows the user to store information on which alert state they are being directed to. 
			HHBdirSelector = new JComboBox();
			HHBdirSelector.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7"}));
			HHBdirSelector.setEditable(false);
			HHBdirSelector.setToolTipText("DIRECTED ALERT STATE");
			HHBdirSelector.setBounds(207, 116, 45, 96);
			getContentPane().add(HHBdirSelector);
			
			//This component provides a header for the defendedAssets jtextfield prompting the user to enter in their defended assets. 
			DefAssetHeader = new JTextPane();
			StyledDocument doc = DefAssetHeader.getStyledDocument();
			SimpleAttributeSet center = new SimpleAttributeSet();
			DefAssetHeader.setAlignmentX(StyleConstants.ALIGN_CENTER);
			doc.setParagraphAttributes(0, doc.getLength(), center, false);
			DefAssetHeader.setEditable(false);
			DefAssetHeader.setText("DEFENDED ASSET");
			DefAssetHeader.setBackground(Color.YELLOW);
			DefAssetHeader.setBounds(253, 62, 86, 53);
			getContentPane().add(DefAssetHeader);
			
			//This component stores information about the units defended assets. 
			HHBdefendedAssets = new JTextArea();
			HHBdefendedAssets.setWrapStyleWord(true);
			HHBdefendedAssets.setLineWrap(true);
			HHBdefendedAssets.setToolTipText("ENTER YOUR DEFENDED ASSETS");
			HHBdefendedAssets.setBounds(253, 116, 86, 95);
			getContentPane().add(HHBdefendedAssets);
			HHBdefendedAssets.setColumns(10);
			
			//This component provides a header prompting the user to enter their units location. 
			locationHeader = new JTextField();
			locationHeader.setText("LOCATION");
			locationHeader.setHorizontalAlignment(SwingConstants.CENTER);
			locationHeader.setEditable(false);
			locationHeader.setColumns(10);
			locationHeader.setBackground(Color.YELLOW);
			locationHeader.setBounds(340, 62, 86, 53);
			getContentPane().add(locationHeader);
			
			//This component stores the units current location in latitude and longitude. 
			HHBcurLocation = new JTextField();
			HHBcurLocation.setHorizontalAlignment(SwingConstants.CENTER);
			HHBcurLocation.setToolTipText("ENTER LAT/LONG & MGRS FOR CURRENT LOCATION");
			HHBcurLocation.setColumns(10);
			HHBcurLocation.setBounds(340, 116, 86, 96);
			getContentPane().add(HHBcurLocation);
			
			//This component provides a header to the jtextfield that stores the ETRO information on the unit. 
			etroHeader = new JTextField();
			etroHeader.setToolTipText("Estimated Time to Return to Operations");
			etroHeader.setBackground(Color.ORANGE);
			etroHeader.setHorizontalAlignment(SwingConstants.CENTER);
			etroHeader.setText("ETRO");
			etroHeader.setBounds(425, 62, 121, 53);
			getContentPane().add(etroHeader);
			
			//This jtextfield provides the user a header for the jtextfield that stores information on the PTL.
			ptlHeader = new JTextField();
			ptlHeader.setEditable(false);
			ptlHeader.setBackground(Color.YELLOW);
			ptlHeader.setHorizontalAlignment(SwingConstants.CENTER);
			ptlHeader.setText("PTL");
			ptlHeader.setColumns(10);
			ptlHeader.setBounds(546, 63, 40, 53);
			getContentPane().add(ptlHeader);
			
			//This jtextfield stores information about the current estimated time to return to operation or (ETRO).
			HHBcurEtro = new JTextField();
			HHBcurEtro.setHorizontalAlignment(SwingConstants.CENTER);
			HHBcurEtro.setToolTipText("ENTER DTG OF CURRENT ETRO");
			HHBcurEtro.setBounds(425, 116, 121, 96);
			getContentPane().add(HHBcurEtro);
			HHBcurEtro.setColumns(10);
			
			//This component stores information about the primary target line or (PTL).
			HHBcurPtl = new JTextField();
			HHBcurPtl.setHorizontalAlignment(SwingConstants.CENTER);
			HHBcurPtl.setToolTipText("HHB'S PRIMARY TARGET LINE");
			HHBcurPtl.setColumns(10);
			HHBcurPtl.setBounds(546, 116, 40, 96);
			getContentPane().add(HHBcurPtl);
			
			//this jtextfield provides a header letting the user know that the jtextfield below is for storing the STL. 
			stlHeader = new JTextField();
			stlHeader.setEditable(false);
			stlHeader.setText("STL");
			stlHeader.setHorizontalAlignment(SwingConstants.CENTER);
			stlHeader.setColumns(10);
			stlHeader.setBackground(Color.YELLOW);
			stlHeader.setBounds(586, 63, 40, 53);
			getContentPane().add(stlHeader);
			
			//This JTextField stores information about the secondary target line or (STL).
			HHBcurStl = new JTextField();
			HHBcurStl.setHorizontalAlignment(SwingConstants.CENTER);
			HHBcurStl.setToolTipText("HHB'S SECONDARY TARGET LINE");
			HHBcurStl.setColumns(10);
			HHBcurStl.setBounds(586, 116, 40, 96);
			getContentPane().add(HHBcurStl);
			
			//This component is just a header for the missile section of the samstat
			missileHeader = new JTextField();
			missileHeader.setEditable(false);
			missileHeader.setBackground(new Color(210, 105, 30));
			missileHeader.setText("MISSILES");
			missileHeader.setHorizontalAlignment(SwingConstants.CENTER);
			missileHeader.setBounds(853, 21, 975, 20);
			getContentPane().add(missileHeader);
			missileHeader.setColumns(10);
			
			pac_3OpHeader = new JTextField();
			pac_3OpHeader.setHorizontalAlignment(SwingConstants.CENTER);
			pac_3OpHeader.setText("OP");
			pac_3OpHeader.setBounds(853, 63, 40, 52);
			pac_3OpHeader.setBackground(new Color(210, 105, 30));
			getContentPane().add(pac_3OpHeader);
			
			pac_3InopHeader = new JTextField();
			pac_3InopHeader.setForeground(Color.BLACK);
			pac_3InopHeader.setHorizontalAlignment(SwingConstants.CENTER);
			pac_3InopHeader.setEditable(false);
			pac_3InopHeader.setText("INOP");
			pac_3InopHeader.setBounds(893, 63, 40, 52);
			pac_3InopHeader.setBackground(new Color(210, 105, 30));
			getContentPane().add(pac_3InopHeader);
			
			pac_3OhHeader = new JTextField();
			pac_3OhHeader.setText("OH");
			pac_3OhHeader.setHorizontalAlignment(SwingConstants.CENTER);
			pac_3OhHeader.setEditable(false);
			pac_3OhHeader.setColumns(10);
			pac_3OhHeader.setBackground(new Color(210, 105, 30));
			pac_3OhHeader.setBounds(934, 63, 40, 52);
			getContentPane().add(pac_3OhHeader);
		
			//These "header" jtextfields prove the labels to our drop boxes that track the current number of Pac-3 Missiles.
			pac_3Header = new JTextField();
			pac_3Header.setEditable(false);
			pac_3Header.setHorizontalAlignment(SwingConstants.CENTER);
			pac_3Header.setBackground(new Color(210, 105, 30));
			pac_3Header.setText("PAC 3");
			pac_3Header.setBounds(853, 42, 121, 20);
			getContentPane().add(pac_3Header);
		
			gemCHeader = new JTextField();
			gemCHeader.setHorizontalAlignment(SwingConstants.CENTER);
			gemCHeader.setEditable(false);
			gemCHeader.setText("GEM C");
			gemCHeader.setBackground(new Color(210, 105, 30));
			gemCHeader.setBounds(984, 42, 121, 20);
			getContentPane().add(gemCHeader);
			
			GemcOpHeader = new JTextField();
			GemcOpHeader.setText("OP");
			GemcOpHeader.setHorizontalAlignment(SwingConstants.CENTER);
			GemcOpHeader.setEditable(false);
			GemcOpHeader.setColumns(10);
			GemcOpHeader.setBackground(new Color(210, 105, 30));
			GemcOpHeader.setBounds(983, 63, 40, 52);
			getContentPane().add(GemcOpHeader);
			
			GemcInopHeader = new JTextField();
			GemcInopHeader.setText("INOP");
			GemcInopHeader.setHorizontalAlignment(SwingConstants.CENTER);
			GemcInopHeader.setEditable(false);
			GemcInopHeader.setColumns(10);
			GemcInopHeader.setBackground(new Color(210, 105, 30));
			GemcInopHeader.setBounds(1024, 63, 40, 52);
			getContentPane().add(GemcInopHeader);
			
			GemCOhHeader = new JTextField();
			GemCOhHeader.setText("OH");
			GemCOhHeader.setHorizontalAlignment(SwingConstants.CENTER);
			GemCOhHeader.setEditable(false);
			GemCOhHeader.setColumns(10);
			GemCOhHeader.setBackground(new Color(210, 105, 30));
			GemCOhHeader.setBounds(1065, 63, 40, 52);
			getContentPane().add(GemCOhHeader);
		
			//These "header" components provide the labels for the drop boxes that handle the Gem-T missile counts.
			gemTHeader = new JTextField();
			gemTHeader.setText("GEM T");
			gemTHeader.setHorizontalAlignment(SwingConstants.CENTER);
			gemTHeader.setEditable(false);
			gemTHeader.setColumns(10);
			gemTHeader.setBackground(new Color(210, 105, 30));
			gemTHeader.setBounds(1115, 42, 121, 20);
			getContentPane().add(gemTHeader);
			
			gemtOpHeader = new JTextField();
			gemtOpHeader.setText("OP");
			gemtOpHeader.setHorizontalAlignment(SwingConstants.CENTER);
			gemtOpHeader.setEditable(false);
			gemtOpHeader.setColumns(10);
			gemtOpHeader.setBackground(new Color(210, 105, 30));
			gemtOpHeader.setBounds(1114, 63, 40, 52);
			getContentPane().add(gemtOpHeader);
			
			gemtInopHeader = new JTextField();
			gemtInopHeader.setText("INOP");
			gemtInopHeader.setHorizontalAlignment(SwingConstants.CENTER);
			gemtInopHeader.setEditable(false);
			gemtInopHeader.setColumns(10);
			gemtInopHeader.setBackground(new Color(210, 105, 30));
			gemtInopHeader.setBounds(1156, 63, 40, 52);
			getContentPane().add(gemtInopHeader);
			
			gemtOhHeader = new JTextField();
			gemtOhHeader.setText("OH");
			gemtOhHeader.setHorizontalAlignment(SwingConstants.CENTER);
			gemtOhHeader.setEditable(false);
			gemtOhHeader.setColumns(10);
			gemtOhHeader.setBackground(new Color(210, 105, 30));
			gemtOhHeader.setBounds(1196, 63, 40, 52);
			getContentPane().add(gemtOhHeader);
			
			missileCountHeader = new JTextField();
			missileCountHeader.setText("TOTAL MISSILES");
			missileCountHeader.setHorizontalAlignment(SwingConstants.CENTER);
			missileCountHeader.setEditable(false);
			missileCountHeader.setColumns(10);
			missileCountHeader.setBackground(new Color(210, 105, 30));
			missileCountHeader.setBounds(1236, 42, 155, 73);
			getContentPane().add(missileCountHeader);
			
			launchersHeader = new JTextField();
			launchersHeader.setText("LAUNCHERS");
			launchersHeader.setHorizontalAlignment(SwingConstants.CENTER);
			launchersHeader.setEditable(false);
			launchersHeader.setColumns(10);
			launchersHeader.setBackground(new Color(205, 133, 63));
			launchersHeader.setBounds(1391, 42, 155, 20);
			getContentPane().add(launchersHeader);
			
			remarksHeader = new JTextField();
			remarksHeader.setText("REMARKS/GENERAL FAULTS");
			remarksHeader.setHorizontalAlignment(SwingConstants.CENTER);
			remarksHeader.setEditable(false);
			remarksHeader.setColumns(10);
			remarksHeader.setBackground(Color.YELLOW);
			remarksHeader.setBounds(1544, 42, 284, 20);
			getContentPane().add(remarksHeader);
			
			launchersInopHeader = new JTextField();
			launchersInopHeader.setText("INOP");
			launchersInopHeader.setHorizontalAlignment(SwingConstants.CENTER);
			launchersInopHeader.setEditable(false);
			launchersInopHeader.setColumns(10);
			launchersInopHeader.setBackground(new Color(205, 133, 63));
			launchersInopHeader.setBounds(1469, 63, 77, 52);
			getContentPane().add(launchersInopHeader);
			
			launchersOPheader = new JTextField();
			launchersOPheader.setText("OP");
			launchersOPheader.setHorizontalAlignment(SwingConstants.CENTER);
			launchersOPheader.setEditable(false);
			launchersOPheader.setColumns(10);
			launchersOPheader.setBackground(new Color(205, 133, 63));
			launchersOPheader.setBounds(1391, 63, 77, 52);
			getContentPane().add(launchersOPheader);
			
			//This section handled the fault reporting on the samstat. 
			faultHeader = new JTextPane();
			faultHeader.setEditable(false);
			faultHeader.setText("A-AMG B-ECS C-CRG D-BCP E-EPP/EPU F-FORKLIFT G-GMT J-LSTS K-IFF L-LS I-ICC M-MISSILES R-RS");
			faultHeader.setBounds(1544, 63, 284, 52);
			getContentPane().add(faultHeader);
			
			HHBOpPac3 = new JTextField();
			HHBOpPac3.setEnabled(false);
			HHBOpPac3.setBackground(Color.GRAY);
			HHBOpPac3.setToolTipText("");
			HHBOpPac3.setColumns(10);
			HHBOpPac3.setBounds(853, 116, 40, 96);
			getContentPane().add(HHBOpPac3);
			
			HHBInOpPac3 = new JTextField();
			HHBInOpPac3.setEnabled(false);
			HHBInOpPac3.setBackground(Color.GRAY);
			HHBInOpPac3.setToolTipText("");
			HHBInOpPac3.setColumns(10);
			HHBInOpPac3.setBounds(893, 116, 40, 96);
			getContentPane().add(HHBInOpPac3);
			
			HHBPac3Oh = new JTextField();
			HHBPac3Oh.setEnabled(false);
			HHBPac3Oh.setBackground(Color.GRAY);
			HHBPac3Oh.setToolTipText("");
			HHBPac3Oh.setColumns(10);
			HHBPac3Oh.setBounds(934, 116, 40, 96);
			getContentPane().add(HHBPac3Oh);
			
			HHBGemCOP = new JTextField();
			HHBGemCOP.setEnabled(false);
			HHBGemCOP.setBackground(Color.GRAY);
			HHBGemCOP.setToolTipText("");
			HHBGemCOP.setColumns(10);
			HHBGemCOP.setBounds(983, 116, 40, 96);
			getContentPane().add(HHBGemCOP);
			
			HHBGemCInOp = new JTextField();
			HHBGemCInOp.setEnabled(false);
			HHBGemCInOp.setBackground(Color.GRAY);
			HHBGemCInOp.setToolTipText("");
			HHBGemCInOp.setColumns(10);
			HHBGemCInOp.setBounds(1024, 116, 40, 96);
			getContentPane().add(HHBGemCInOp);
			
			HHBGemCOh = new JTextField();
			HHBGemCOh.setEnabled(false);
			HHBGemCOh.setBackground(Color.GRAY);
			HHBGemCOh.setToolTipText("");
			HHBGemCOh.setColumns(10);
			HHBGemCOh.setBounds(1065, 116, 40, 96);
			getContentPane().add(HHBGemCOh);
			
			HHBGemTOP = new JTextField();
			HHBGemTOP.setBackground(Color.GRAY);
			HHBGemTOP.setEnabled(false);
			HHBGemTOP.setBackground(Color.GRAY);
			HHBGemTOP.setToolTipText("");
			HHBGemTOP.setColumns(10);
			HHBGemTOP.setBounds(1114, 116, 40, 96);
			getContentPane().add(HHBGemTOP);
			
			HHBGemTInOp = new JTextField();
			HHBGemTInOp.setBackground(Color.GRAY);
			HHBGemTInOp.setEnabled(false);
			HHBGemTInOp.setToolTipText("");
			HHBGemTInOp.setColumns(10);
			HHBGemTInOp.setBounds(1156, 116, 40, 96);
			getContentPane().add(HHBGemTInOp);
			
			HHBGemTOH = new JTextField();
			HHBGemTOH.setBackground(Color.GRAY);
			HHBGemTOH.setEnabled(false);
			HHBGemTOH.setToolTipText("");
			HHBGemTOH.setColumns(10);
			HHBGemTOH.setBounds(1196, 116, 40, 96);
			getContentPane().add(HHBGemTOH);
			
			//totalMissileCount represents the total amount of missiles on the site. It is only comprised of this sincle JTextField.
			HHBtotalMissileCount = new JTextField();
			HHBtotalMissileCount.setEditable(false);
			HHBtotalMissileCount.setToolTipText("");
			HHBtotalMissileCount.setHorizontalAlignment(SwingConstants.CENTER);
			HHBtotalMissileCount.setForeground(Color.WHITE);
			HHBtotalMissileCount.setBackground(new Color(0, 0, 0));
			HHBtotalMissileCount.setBounds(1236, 116, 155, 96);
			getContentPane().add(HHBtotalMissileCount);
			HHBtotalMissileCount.setColumns(10);
			
			HHBLs = new JTextField();
			HHBLs.setEnabled(false);
			HHBLs.setBackground(Color.GRAY);
			HHBLs.setHorizontalAlignment(SwingConstants.CENTER);
			HHBLs.setToolTipText("");
			HHBLs.setColumns(10);
			HHBLs.setBounds(1391, 116, 77, 48);
			getContentPane().add(HHBLs);
			
			HHBInopLs = new JTextField();
			HHBInopLs.setEnabled(false);
			HHBInopLs.setBackground(Color.GRAY);
			HHBInopLs.setToolTipText("");
			HHBInopLs.setColumns(10);
			HHBInopLs.setBounds(1469, 116, 77, 48);
			getContentPane().add(HHBInopLs);
			
			HHBRemarks = new JTextArea();
			HHBRemarks.setToolTipText("Enter All Current System Faults and Deadlines Here");
			HHBRemarks.setWrapStyleWord(true);
			HHBRemarks.setLineWrap(true);
			HHBRemarks.setBackground(Color.LIGHT_GRAY);
			HHBRemarks.setBounds(1544, 116, 284, 95);
			getContentPane().add(HHBRemarks);
			
			HHBOPpac2L = new JTextField();
			HHBOPpac2L.setBackground(Color.GRAY);
			HHBOPpac2L.setEnabled(false);
			HHBOPpac2L.setToolTipText("");
			HHBOPpac2L.setColumns(10);
			HHBOPpac2L.setBounds(1391, 164, 77, 48);
			getContentPane().add(HHBOPpac2L);
			
			HHBInopPac2L = new JTextField();
			HHBInopPac2L.setBackground(Color.GRAY);
			HHBInopPac2L.setEnabled(false);
			HHBInopPac2L.setToolTipText("");
			HHBInopPac2L.setColumns(10);
			HHBInopPac2L.setBounds(1469, 164, 77, 48);
			getContentPane().add(HHBInopPac2L);
			
			aUnitId = new JTextField();
			aUnitId.setToolTipText("<html>SHADE CELLS TO REFLECT CURRENT UNIT STATUS:<br/>GREEN-MC<br/>RED-NMC<br/>WHITE-UNIT IN TRANSISTION</html>");
			aUnitId.setText("Set Unit Name");
			aUnitId.setHorizontalAlignment(SwingConstants.CENTER);
			aUnitId.setColumns(10);
			aUnitId.setBounds(0, 212, 84, 96);
			aUnitId.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
				//This if/else if/else statement allows the user to control the background of this JTextField by clicking on the box
					if(color==0){
						aUnitId.setBackground(Color.WHITE);
						color++;
					}
					else if(color==1){
						aUnitId.setBackground(Color.RED);
						color++;
					}else{
						color=0;
						aUnitId.setBackground(Color.GREEN);	
					}	
				}
			});//End mouseListener
			getContentPane().add(aUnitId);
			
			bUnitId = new JTextField();
			bUnitId.setToolTipText("<html>SHADE CELLS TO REFLECT CURRENT UNIT STATUS:<br/>GREEN-MC<br/>RED-NMC<br/>WHITE-UNIT IN TRANSISTION</html>");
			bUnitId.setText("Set Unit Name");
			bUnitId.setHorizontalAlignment(SwingConstants.CENTER);
			bUnitId.setColumns(10);
			bUnitId.setBounds(0, 307, 84, 96);
			bUnitId.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
				//This if/else if/else statement allows the user to control the background of this JTextField by clicking on the box
					if(color==0){
						bUnitId.setBackground(Color.WHITE);
						color++;
					}
					else if(color==1){
						bUnitId.setBackground(Color.RED);
						color++;
					}else{
						color=0;
						bUnitId.setBackground(Color.GREEN);	
					}	
				}
			});//End mouseListener
			getContentPane().add(bUnitId);
			
			cUnitId = new JTextField();
			cUnitId.setToolTipText("<html>SHADE CELLS TO REFLECT CURRENT UNIT STATUS:<br/>GREEN-MC<br/>RED-NMC<br/>WHITE-UNIT IN TRANSISTION</html>");
			cUnitId.setText("Set Unit Name");
			cUnitId.setHorizontalAlignment(SwingConstants.CENTER);
			cUnitId.setColumns(10);
			cUnitId.setBounds(0, 402, 84, 96);
			cUnitId.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
				//This if/else if/else statement allows the user to control the background of this JTextField by clicking on the box
					if(color==0){
						cUnitId.setBackground(Color.WHITE);
						color++;
					}
					else if(color==1){
						cUnitId.setBackground(Color.RED);
						color++;
					}else{
						color=0;
						cUnitId.setBackground(Color.GREEN);	
					}	
				}
			});//End mouseListener
			getContentPane().add(cUnitId);
			
			dUnitId = new JTextField();
			dUnitId.setToolTipText("<html>SHADE CELLS TO REFLECT CURRENT UNIT STATUS:<br/>GREEN-MC<br/>RED-NMC<br/>WHITE-UNIT IN TRANSISTION</html>");
			dUnitId.setText("Set Unit Name");
			dUnitId.setHorizontalAlignment(SwingConstants.CENTER);
			dUnitId.setColumns(10);
			dUnitId.setBounds(0, 498, 84, 96);
			dUnitId.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
				//This if/else if/else statement allows the user to control the background of this JTextField by clicking on the box
					if(color==0){
						dUnitId.setBackground(Color.WHITE);
						color++;
					}
					else if(color==1){
						dUnitId.setBackground(Color.RED);
						color++;
					}else{
						color=0;
						dUnitId.setBackground(Color.GREEN);	
					}	
				}
			});//End mouseListener
			getContentPane().add(dUnitId);
			
			stoHeader = new JTextField();
			stoHeader.setEditable(false);
			stoHeader.setHorizontalAlignment(SwingConstants.CENTER);
			stoHeader.setText("Current STO");
			stoHeader.setBackground(Color.YELLOW);
			stoHeader.setBounds(0, 594, 163, 40);
			getContentPane().add(stoHeader);
			stoHeader.setColumns(10);
			
			ASystemType = new JTextField();
			ASystemType.setHorizontalAlignment(SwingConstants.CENTER);
			ASystemType.setToolTipText("<html>ENTER SYSTEM TYPE:<br/>PAT<br/>AVENGER<br/>STINGER<br/>THAAD</html>");
			ASystemType.setBounds(82, 212, 79, 96);
			getContentPane().add(ASystemType);
			
			ACurAS = new JTextField();
			ACurAS.setColumns(10);
			ACurAS.setHorizontalAlignment(SwingConstants.CENTER);
			ACurAS.setToolTipText("ALPHA CURRENT ALERT STATE");
			ACurAS.setBounds(161, 212, 45, 96);
			getContentPane().add(ACurAS);
			
			ADirAS = new JTextField();
			ADirAS.setColumns(10);
			ADirAS.setHorizontalAlignment(SwingConstants.CENTER);
			ADirAS.setToolTipText("ALPHA DIRECTED ALERT STATE");
			ADirAS.setBounds(207, 212, 45, 96);
			getContentPane().add(ADirAS);
			
			AdefendedAssets = new JTextArea();
			AdefendedAssets.setWrapStyleWord(true);
			AdefendedAssets.setLineWrap(true);
			AdefendedAssets.setToolTipText("ALPHA'S DEFENDED ASSETS");
			AdefendedAssets.setColumns(10);
			AdefendedAssets.setBounds(253, 212, 86, 94);
			getContentPane().add(AdefendedAssets);
			
			AcurLocation = new JTextField();
			AcurLocation.setHorizontalAlignment(SwingConstants.CENTER);
			AcurLocation.setToolTipText("ALPHA'S CURRENT LOCATION");
			AcurLocation.setColumns(10);
			AcurLocation.setBounds(340, 212, 86, 96);
			getContentPane().add(AcurLocation);
			
			AcurEtro = new JTextField();
			AcurEtro.setHorizontalAlignment(SwingConstants.CENTER);
			AcurEtro.setToolTipText("ALPHA'S CURRENT ETRO");
			AcurEtro.setColumns(10);
			AcurEtro.setBounds(425, 212, 121, 96);
			getContentPane().add(AcurEtro);
			
			AcurPtl = new JTextField();
			AcurPtl.setHorizontalAlignment(SwingConstants.CENTER);
			AcurPtl.setToolTipText("ALPHA'S PRIMARY TARGET LINE");
			AcurPtl.setColumns(10);
			AcurPtl.setBounds(546, 212, 40, 96);
			getContentPane().add(AcurPtl);
			
			AcurStl = new JTextField();
			AcurStl.setHorizontalAlignment(SwingConstants.CENTER);
			AcurStl.setToolTipText("ALPHA'S SECONDARY TARGET LINE");
			AcurStl.setColumns(10);
			AcurStl.setBounds(586, 212, 40, 96);
			getContentPane().add(AcurStl);
			
			AOpPac3 = new JTextField();
			AOpPac3.setHorizontalAlignment(SwingConstants.CENTER);
			AOpPac3.setToolTipText("Number of OP Pac3");
			AOpPac3.setColumns(10);
			AOpPac3.setBackground(Color.WHITE);
			AOpPac3.setBounds(853, 212, 40, 96);
			AOpPac3.getDocument().addDocumentListener(new DocumentListener(){

				@Override
				public void changedUpdate(DocumentEvent arg0) {
					try {
						compMissileUpdater();
					} catch (Exception e) {
						
						//e.printStackTrace();
					}
					
				}

				@Override
				public void insertUpdate(DocumentEvent arg0) {
					try {
						compMissileUpdater();
					} catch (Exception e) {
						
						//e.printStackTrace();
					}
					
				}

				@Override
				public void removeUpdate(DocumentEvent arg0) {
					//blah
					
					
				}
			
			});//End LIsenter
			getContentPane().add(AOpPac3);
			
			AInOpPac3 = new JTextField();
			AInOpPac3.setHorizontalAlignment(SwingConstants.CENTER);
			AInOpPac3.setToolTipText("Number of INOP Pac3");
			AInOpPac3.setColumns(10);
			AInOpPac3.setBackground(Color.WHITE);
			AInOpPac3.setBounds(893, 212, 40, 96);
			AInOpPac3.getDocument().addDocumentListener(new DocumentListener(){

				@Override
				public void changedUpdate(DocumentEvent e) {
					try {
						compMissileUpdater();
					} catch (Exception e1) {
						
						//e.printStackTrace();
					}
				}

				@Override
				public void insertUpdate(DocumentEvent e) {
					try {
						compMissileUpdater();
					} catch (Exception e1) {
						
						//e.printStackTrace();
					}
					
				}

				@Override
				public void removeUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				
				
			});
			getContentPane().add(AInOpPac3);
			
			APac3Oh = new JTextField();
			APac3Oh.setHorizontalAlignment(SwingConstants.CENTER);
			APac3Oh.setToolTipText("Number of OH Pac3");
			APac3Oh.setColumns(10);
			APac3Oh.setBackground(Color.WHITE);
			APac3Oh.setBounds(934, 212, 40, 96);
			APac3Oh.getDocument().addDocumentListener(new DocumentListener(){

				@Override
				public void changedUpdate(DocumentEvent e) {
					try {
						compMissileUpdater();
					} catch (Exception e1) {
						
						//e.printStackTrace();
					}
				}

				@Override
				public void insertUpdate(DocumentEvent e) {
					try {
						compMissileUpdater();
					} catch (Exception e1) {
						
						//e.printStackTrace();
					}
					
				}

				@Override
				public void removeUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					
				}
				
			});
			getContentPane().add(APac3Oh);
			
			AGemCOP = new JTextField();
			AGemCOP.setHorizontalAlignment(SwingConstants.CENTER);
			AGemCOP.setToolTipText("Number of OP GemC");
			AGemCOP.setColumns(10);
			AGemCOP.setBackground(Color.WHITE);
			AGemCOP.setBounds(983, 212, 40, 96);
			AGemCOP.getDocument().addDocumentListener(new DocumentListener(){

				@Override
				public void changedUpdate(DocumentEvent e) {
					try {
						compMissileUpdater();
					} catch (Exception e1) {
						
						//e.printStackTrace();
					}
					
				}

				@Override
				public void insertUpdate(DocumentEvent e) {
					try {
						compMissileUpdater();
					} catch (Exception e1) {
						
						//e.printStackTrace();
					}
					
				}

				@Override
				public void removeUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					
				}
				
			});
			getContentPane().add(AGemCOP);
			
			AGemCInOp = new JTextField();
			AGemCInOp.setHorizontalAlignment(SwingConstants.CENTER);
			AGemCInOp.setToolTipText("Number of INOP GemC");
			AGemCInOp.setColumns(10);
			AGemCInOp.setBackground(Color.WHITE);
			AGemCInOp.setBounds(1024, 212, 40, 96);
			AGemCInOp.getDocument().addDocumentListener(new DocumentListener(){

				@Override
				public void changedUpdate(DocumentEvent e) {
					try {
						compMissileUpdater();
					} catch (Exception e1) {
						
						//e.printStackTrace();
					}
					
				}

				@Override
				public void insertUpdate(DocumentEvent e) {
					try {
						compMissileUpdater();
					} catch (Exception e1) {
						
						//e.printStackTrace();
					}
					
				}

				@Override
				public void removeUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					
				}
				
			});
			getContentPane().add(AGemCInOp);
			
			AGemCOh = new JTextField();
			AGemCOh.setHorizontalAlignment(SwingConstants.CENTER);
			AGemCOh.setToolTipText("Number of OH GemC");
			AGemCOh.setColumns(10);
			AGemCOh.setBackground(Color.WHITE);
			AGemCOh.setBounds(1065, 212, 40, 96);
			AGemCOh.getDocument().addDocumentListener(new DocumentListener(){

				@Override
				public void changedUpdate(DocumentEvent e) {
					try {
						compMissileUpdater();
					} catch (Exception e1) {
						
						//e.printStackTrace();
					}
					
				}

				@Override
				public void insertUpdate(DocumentEvent e) {
					try {
						compMissileUpdater();
					} catch (Exception e1) {
						
						//e.printStackTrace();
					}
					
				}

				@Override
				public void removeUpdate(DocumentEvent e) {
					//
					
				}
				
			});
			getContentPane().add(AGemCOh);
			
			AGemTOP = new JTextField();
			AGemTOP.setHorizontalAlignment(SwingConstants.CENTER);
			AGemTOP.setToolTipText("Number of OP GemT");
			AGemTOP.setColumns(10);
			AGemTOP.setBackground(Color.WHITE);
			AGemTOP.setBounds(1114, 212, 40, 96);
			AGemTOP.getDocument().addDocumentListener(new DocumentListener(){

				@Override
				public void changedUpdate(DocumentEvent e) {
					try {
						compMissileUpdater();
					} catch (Exception e1) {
						
						//e.printStackTrace();
					}
					
				}

				@Override
				public void insertUpdate(DocumentEvent e) {
					try {
						compMissileUpdater();
					} catch (Exception e1) {
						
						//e.printStackTrace();
					}
					
				}

				@Override
				public void removeUpdate(DocumentEvent e) {
					try {
						compMissileUpdater();
					} catch (Exception e1) {
						
						//e.printStackTrace();
					}
					
				}
				
			});
			getContentPane().add(AGemTOP);
			
			AGemTInOp = new JTextField();
			AGemTInOp.setHorizontalAlignment(SwingConstants.CENTER);
			AGemTInOp.setToolTipText("Number of Inop GemT");
			AGemTInOp.setColumns(10);
			AGemTInOp.setBackground(Color.WHITE);
			AGemTInOp.setBounds(1156, 212, 40, 96);
			AGemTInOp.getDocument().addDocumentListener(new DocumentListener(){

				@Override
				public void changedUpdate(DocumentEvent e) {
					try {
						compMissileUpdater();
					} catch (Exception e1) {
						
						//e.printStackTrace();
					}
					
				}

				@Override
				public void insertUpdate(DocumentEvent e) {
					try {
						compMissileUpdater();
					} catch (Exception e1) {
						
						//e.printStackTrace();
					}
					
				}

				@Override
				public void removeUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					
				}
				
			});
			getContentPane().add(AGemTInOp);
			
			AGemTOH = new JTextField();
			AGemTOH.setHorizontalAlignment(SwingConstants.CENTER);
			AGemTOH.setToolTipText("Number of OH GemT");
			AGemTOH.setColumns(10);
			AGemTOH.setBackground(Color.WHITE);
			AGemTOH.setBounds(1196, 212, 40, 96);
			AGemTInOp.getDocument().addDocumentListener(new DocumentListener(){

				@Override
				public void changedUpdate(DocumentEvent e) {
					try {
						compMissileUpdater();
					} catch (Exception e1) {
						
						//e.printStackTrace();
					}
					
				}

				@Override
				public void insertUpdate(DocumentEvent e) {
					try {
						compMissileUpdater();
					} catch (Exception e1) {
						
						//e.printStackTrace();
					}
					
				}

				@Override
				public void removeUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					
				}
				
			});
			getContentPane().add(AGemTOH);
			
			AtotalMissileCount = new JTextField();
			AtotalMissileCount.setToolTipText("Total Missile Count for Alpha");
			AtotalMissileCount.setHorizontalAlignment(SwingConstants.CENTER);
			AtotalMissileCount.setForeground(Color.WHITE);
			AtotalMissileCount.setEditable(false);
			AtotalMissileCount.setColumns(10);
			AtotalMissileCount.setBackground(Color.BLACK);
			AtotalMissileCount.setBounds(1236, 212, 155, 96);
			getContentPane().add(AtotalMissileCount);
			
			AOPLs = new JTextField();
			AOPLs.setToolTipText("Current Number of OP Pac3 Launchers");
			AOPLs.setHorizontalAlignment(SwingConstants.CENTER);
			AOPLs.setColumns(10);
			AOPLs.setBackground(new Color(205, 133, 63));
			AOPLs.setBounds(1391, 212, 77, 48);
			AOPLs.getDocument().addDocumentListener(new DocumentListener(){

				@Override
				public void changedUpdate(DocumentEvent e) {
					try {
						compMissileUpdater();
					} catch (Exception e1) {
						
						//e.printStackTrace();
					}
					
				}

				@Override
				public void insertUpdate(DocumentEvent e) {
					try {
						compMissileUpdater();
					} catch (Exception e1) {
						
						//e.printStackTrace();
					}
					
				}

				@Override
				public void removeUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					
				}
				
			});
			getContentPane().add(AOPLs);
			
			AOPpac2L = new JTextField();
			AOPpac2L.setHorizontalAlignment(SwingConstants.CENTER);
			AOPpac2L.setToolTipText("Current Number of OP Pac2 Launchers\r\n");
			AOPpac2L.setColumns(10);
			AOPpac2L.setBackground(new Color(205, 133, 63));
			AOPpac2L.setBounds(1391, 260, 77, 48);
			AOPpac2L.getDocument().addDocumentListener(new DocumentListener(){

				@Override
				public void changedUpdate(DocumentEvent e) {
					try {
						compMissileUpdater();
					} catch (Exception e1) {
						
						//e.printStackTrace();
					}
					
				}

				@Override
				public void insertUpdate(DocumentEvent e) {
					try {
						compMissileUpdater();
					} catch (Exception e1) {
						
						//e.printStackTrace();
					}
					
				}

				@Override
				public void removeUpdate(DocumentEvent e) {
					//
					
				}
				
			});
			getContentPane().add(AOPpac2L);
			
			AInopLs = new JTextField();
			AInopLs.setHorizontalAlignment(SwingConstants.CENTER);
			AInopLs.setToolTipText("Current number of INOP Pac3 Launchers\r\n");
			AInopLs.setColumns(10);
			AInopLs.setBackground(new Color(205, 133, 63));
			AInopLs.setBounds(1469, 212, 77, 48);
			AInopLs.getDocument().addDocumentListener(new DocumentListener(){

				@Override
				public void changedUpdate(DocumentEvent e) {
					try {
						compMissileUpdater();
					} catch (Exception e1) {
						
						//e.printStackTrace();
					}
					
				}

				@Override
				public void insertUpdate(DocumentEvent e) {
					try {
						compMissileUpdater();
					} catch (Exception e1) {
						
						//e.printStackTrace();
					}
					
				}

				@Override
				public void removeUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					
				}
				
			});
			getContentPane().add(AInopLs);
			
			AInopPac2L = new JTextField();
			AInopPac2L.setHorizontalAlignment(SwingConstants.CENTER);
			AInopPac2L.setToolTipText("Current Number of INOP Pac2 Launchers");
			AInopPac2L.setColumns(10);
			AInopPac2L.setBackground(new Color(205, 133, 63));
			AInopPac2L.setBounds(1469, 260, 77, 48);
			AInopPac2L.getDocument().addDocumentListener(new DocumentListener(){

				@Override
				public void changedUpdate(DocumentEvent e) {
					try {
						compMissileUpdater();
					} catch (Exception e1) {
						
						//e.printStackTrace();
					}
					
				}

				@Override
				public void insertUpdate(DocumentEvent e) {
					try {
						compMissileUpdater();
					} catch (Exception e1) {
						
						//e.printStackTrace();
					}
					
				}

				@Override
				public void removeUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					
				}
				
			});
			getContentPane().add(AInopPac2L);
			
			ARemarks = new JTextArea();
			ARemarks.setWrapStyleWord(true);
			ARemarks.setToolTipText("Alpha's Current System Faults and Deadlines ");
			ARemarks.setLineWrap(true);
			ARemarks.setBackground(Color.LIGHT_GRAY);
			ARemarks.setBounds(1544, 212, 284, 96);
			getContentPane().add(ARemarks);
			
			BSystemType = new JTextField();
			BSystemType.setHorizontalAlignment(SwingConstants.CENTER);
			BSystemType.setToolTipText("<html>ENTER SYSTEM TYPE:<br/>PAT<br/>AVENGER<br/>STINGER<br/>THAAD</html>");
			BSystemType.setBounds(83, 307, 79, 96);
			getContentPane().add(BSystemType);
			
			CSystemType = new JTextField();
			CSystemType.setHorizontalAlignment(SwingConstants.CENTER);
			CSystemType.setToolTipText("<html>ENTER SYSTEM TYPE:<br/>PAT<br/>AVENGER<br/>STINGER<br/>THAAD</html>");
			CSystemType.setBounds(83, 402, 79, 96);
			getContentPane().add(CSystemType);
			
			DSystemType = new JTextField();
			DSystemType.setHorizontalAlignment(SwingConstants.CENTER);
			DSystemType.setToolTipText("<html>ENTER SYSTEM TYPE:<br/>PAT<br/>AVENGER<br/>STINGER<br/>THAAD</html>");
			DSystemType.setBounds(83, 498, 79, 96);
			getContentPane().add(DSystemType);
			
			BCurAS = new JTextField();
			BCurAS.setColumns(10);
			BCurAS.setHorizontalAlignment(SwingConstants.CENTER);
			BCurAS.setToolTipText("BRAVO CURRENT ALERT STATE");
			BCurAS.setBounds(161, 307, 45, 96);
			getContentPane().add(BCurAS);
			
			CCurAS = new JTextField();
			CCurAS.setColumns(10);
			CCurAS.setHorizontalAlignment(SwingConstants.CENTER);
			CCurAS.setToolTipText("CHARLIE CURRENT ALERT STATE");
			CCurAS.setBounds(161, 402, 45, 96);
			getContentPane().add(CCurAS);
			
			DCurAS = new JTextField();
			DCurAS.setColumns(10);
			DCurAS.setHorizontalAlignment(SwingConstants.CENTER);
			DCurAS.setToolTipText("DELTA CURRENT ALERT STATE");
			DCurAS.setBounds(161, 498, 45, 96);
			getContentPane().add(DCurAS);
			
			BDirAS = new JTextField();
			BDirAS.setHorizontalAlignment(SwingConstants.CENTER);
			BDirAS.setToolTipText("BRAVO DIRECTED ALERT STATE");
			BDirAS.setBounds(207, 307, 45, 96);
			getContentPane().add(BDirAS);
			
			CDirAS = new JTextField();
			CDirAS.setHorizontalAlignment(SwingConstants.CENTER);
			CDirAS.setToolTipText("CHARLIE DIRECTED ALERT STATE");
			CDirAS.setBounds(207, 402, 45, 96);
			getContentPane().add(CDirAS);
			
			DDirAS = new JTextField();
			DDirAS.setHorizontalAlignment(SwingConstants.CENTER);
			DDirAS.setToolTipText("DELTA DIRECTED ALERT STATE");
			DDirAS.setBounds(207, 498, 45, 96);
			getContentPane().add(DDirAS);
			
			BdefendedAssets = new JTextArea();
			BdefendedAssets.setWrapStyleWord(true);
			BdefendedAssets.setLineWrap(true);
			BdefendedAssets.setToolTipText("BRAVO'S DEFENDED ASSETS");
			BdefendedAssets.setColumns(10);
			BdefendedAssets.setBounds(253, 307, 86, 94);
			getContentPane().add(BdefendedAssets);
			
			CdefendedAssets = new JTextArea();
			CdefendedAssets.setWrapStyleWord(true);
			CdefendedAssets.setLineWrap(true);
			CdefendedAssets.setToolTipText("CHARLIE'S DEFENDED ASSETS");
			CdefendedAssets.setColumns(10);
			CdefendedAssets.setBounds(253, 402, 86, 95);
			getContentPane().add(CdefendedAssets);
			
			DdefendedAssets = new JTextArea();
			DdefendedAssets.setWrapStyleWord(true);
			DdefendedAssets.setLineWrap(true);
			DdefendedAssets.setToolTipText("DELTA'S DEFENDED ASSETS");
			DdefendedAssets.setColumns(10);
			DdefendedAssets.setBounds(253, 498, 86, 96);
			getContentPane().add(DdefendedAssets);
			
			BcurLocation = new JTextField();
			BcurLocation.setHorizontalAlignment(SwingConstants.CENTER);
			BcurLocation.setToolTipText("BRAVO'S CURRENT LOCATION");
			BcurLocation.setColumns(10);
			BcurLocation.setBounds(340, 307, 86, 96);
			getContentPane().add(BcurLocation);
			
			CcurLocation = new JTextField();
			CcurLocation.setHorizontalAlignment(SwingConstants.CENTER);
			CcurLocation.setToolTipText("CHARLIE'S CURRENT LOCATION");
			CcurLocation.setColumns(10);
			CcurLocation.setBounds(340, 402, 86, 96);
			getContentPane().add(CcurLocation);
			
			DcurLocation = new JTextField();
			DcurLocation.setHorizontalAlignment(SwingConstants.CENTER);
			DcurLocation.setToolTipText("DELTA'S CURRENT LOCATION");
			DcurLocation.setColumns(10);
			DcurLocation.setBounds(340, 498, 86, 96);
			getContentPane().add(DcurLocation);
			
			BcurEtro = new JTextField();
			BcurEtro.setHorizontalAlignment(SwingConstants.CENTER);
			BcurEtro.setToolTipText("BRAVO'S CURRENT ETRO");
			BcurEtro.setColumns(10);
			BcurEtro.setBounds(425, 307, 121, 96);
			getContentPane().add(BcurEtro);
			
			CcurEtro = new JTextField();
			CcurEtro.setHorizontalAlignment(SwingConstants.CENTER);
			CcurEtro.setToolTipText("ENTER DTG OF CURRENT ETRO");
			CcurEtro.setColumns(10);
			CcurEtro.setBounds(425, 402, 121, 96);
			getContentPane().add(CcurEtro);
			
			DcurEtro = new JTextField();
			DcurEtro.setHorizontalAlignment(SwingConstants.CENTER);
			DcurEtro.setToolTipText("DELTA'S CURRENT ETRO");
			DcurEtro.setColumns(10);
			DcurEtro.setBounds(425, 498, 121, 96);
			getContentPane().add(DcurEtro);
			
			BcurPtl = new JTextField();
			BcurPtl.setToolTipText("BRAVO'S PRIMARY TARGET LINE");
			BcurPtl.setHorizontalAlignment(SwingConstants.CENTER);
			BcurPtl.setColumns(10);
			BcurPtl.setBounds(546, 307, 40, 96);
			getContentPane().add(BcurPtl);
			
			CcurPtl = new JTextField();
			CcurPtl.setToolTipText("CHARLIE'S PRIMARY TARGET LINE");
			CcurPtl.setHorizontalAlignment(SwingConstants.CENTER);
			CcurPtl.setColumns(10);
			CcurPtl.setBounds(546, 402, 40, 96);
			getContentPane().add(CcurPtl);
			
			DcurPtl = new JTextField();
			DcurPtl.setToolTipText("DELTA'S PRIMARY TARGET LINE");
			DcurPtl.setHorizontalAlignment(SwingConstants.CENTER);
			DcurPtl.setColumns(10);
			DcurPtl.setBounds(546, 498, 40, 96);
			getContentPane().add(DcurPtl);
			
			BcurStl = new JTextField();
			BcurStl.setToolTipText("BRAVO'S SECONDARY TARGET LINE");
			BcurStl.setHorizontalAlignment(SwingConstants.CENTER);
			BcurStl.setColumns(10);
			BcurStl.setBounds(586, 307, 40, 96);
			getContentPane().add(BcurStl);
			
			CcurStl = new JTextField();
			CcurStl.setToolTipText("CHARLIE'S SECONDARY TARGET LINE");
			CcurStl.setHorizontalAlignment(SwingConstants.CENTER);
			CcurStl.setColumns(10);
			CcurStl.setBounds(586, 402, 40, 96);
			getContentPane().add(CcurStl);
			
			DcurStl = new JTextField();
			DcurStl.setToolTipText("DELTA'S SECONDARY TARGET LINE");
			DcurStl.setHorizontalAlignment(SwingConstants.CENTER);
			DcurStl.setColumns(10);
			DcurStl.setBounds(586, 498, 40, 96);
			getContentPane().add(DcurStl);
			
			BOpPac3 = new JTextField();
			BOpPac3.setToolTipText("Number of OP Pac3");
			BOpPac3.setHorizontalAlignment(SwingConstants.CENTER);
			BOpPac3.setColumns(10);
			BOpPac3.setBackground(Color.WHITE);
			BOpPac3.setBounds(853, 307, 40, 96);
			BOpPac3.getDocument().addDocumentListener(new DocumentListener(){

				@Override
				public void changedUpdate(DocumentEvent arg0) {
					try {
						compMissileUpdater();
					} catch (Exception e) {
						
						//e.printStackTrace();
					}
					
				}

				@Override
				public void insertUpdate(DocumentEvent arg0) {
					try {
						compMissileUpdater();
					} catch (Exception e) {
						
						//e.printStackTrace();
					}
					
				}

				@Override
				public void removeUpdate(DocumentEvent arg0) {
					//blah
					
					
				}
			
			});//End LIsenter
			getContentPane().add(BOpPac3);
			
			COpPac3 = new JTextField();
			COpPac3.setToolTipText("Number of OP Pac3");
			COpPac3.setHorizontalAlignment(SwingConstants.CENTER);
			COpPac3.setColumns(10);
			COpPac3.setBackground(Color.WHITE);
			COpPac3.setBounds(853, 402, 40, 96);
			COpPac3.getDocument().addDocumentListener(new DocumentListener(){

				@Override
				public void changedUpdate(DocumentEvent arg0) {
					try {
						compMissileUpdater();
					} catch (Exception e) {
						
						//e.printStackTrace();
					}
					
				}

				@Override
				public void insertUpdate(DocumentEvent arg0) {
					try {
						compMissileUpdater();
					} catch (Exception e) {
						
						//e.printStackTrace();
					}
					
				}

				@Override
				public void removeUpdate(DocumentEvent arg0) {
					//blah
				}
			
			});//End LIsenter
			getContentPane().add(COpPac3);
			
			DOpPac3 = new JTextField();
			DOpPac3.setToolTipText("Number of OP Pac3");
			DOpPac3.setHorizontalAlignment(SwingConstants.CENTER);
			DOpPac3.setColumns(10);
			DOpPac3.setBackground(Color.WHITE);
			DOpPac3.setBounds(853, 498, 40, 96);
			DOpPac3.getDocument().addDocumentListener(new DocumentListener(){

				@Override
				public void changedUpdate(DocumentEvent arg0) {
					try {
						compMissileUpdater();
					} catch (Exception e) {
						
						//e.printStackTrace();
					}
					
				}

				@Override
				public void insertUpdate(DocumentEvent arg0) {
					try {
						compMissileUpdater();
					} catch (Exception e) {
						
						//e.printStackTrace();
					}
					
				}

				@Override
				public void removeUpdate(DocumentEvent arg0) {
					//blah
				}
			
			});//End LIsenter
			getContentPane().add(DOpPac3);
			
			BInOpPac3 = new JTextField();
			BInOpPac3.setToolTipText("Number of INOP Pac3");
			BInOpPac3.setHorizontalAlignment(SwingConstants.CENTER);
			BInOpPac3.setColumns(10);
			BInOpPac3.setBackground(Color.WHITE);
			BInOpPac3.setBounds(893, 307, 40, 96);
			BInOpPac3.getDocument().addDocumentListener(new DocumentListener(){

				@Override
				public void changedUpdate(DocumentEvent arg0) {
					try {
						compMissileUpdater();
					} catch (Exception e) {
						
						//e.printStackTrace();
					}
					
				}

				@Override
				public void insertUpdate(DocumentEvent arg0) {
					try {
						compMissileUpdater();
					} catch (Exception e) {
						
						//e.printStackTrace();
					}
				}

				@Override
				public void removeUpdate(DocumentEvent arg0) {
					//blah
				}
			
			});//End LIsenter
			getContentPane().add(BInOpPac3);
			
			CInOpPac3 = new JTextField();
			CInOpPac3.setToolTipText("Number of INOP Pac3");
			CInOpPac3.setHorizontalAlignment(SwingConstants.CENTER);
			CInOpPac3.setColumns(10);
			CInOpPac3.setBackground(Color.WHITE);
			CInOpPac3.setBounds(893, 402, 40, 96);
			CInOpPac3.getDocument().addDocumentListener(new DocumentListener(){

				@Override
				public void changedUpdate(DocumentEvent arg0) {
					try {
						compMissileUpdater();
					} catch (Exception e) {
						
						//e.printStackTrace();
					}
					
				}

				@Override
				public void insertUpdate(DocumentEvent arg0) {
					try {
						compMissileUpdater();
					} catch (Exception e) {
						
						//e.printStackTrace();
					}
					
				}

				@Override
				public void removeUpdate(DocumentEvent arg0) {
					//blah
				}
			
			});//End LIsenter
			getContentPane().add(CInOpPac3);
			
			DInOpPac3 = new JTextField();
			DInOpPac3.setToolTipText("Number of INOP Pac3");
			DInOpPac3.setHorizontalAlignment(SwingConstants.CENTER);
			DInOpPac3.setColumns(10);
			DInOpPac3.setBackground(Color.WHITE);
			DInOpPac3.setBounds(893, 498, 40, 96);
			DInOpPac3.getDocument().addDocumentListener(new DocumentListener(){

				@Override
				public void changedUpdate(DocumentEvent arg0) {
					try {
						compMissileUpdater();
					} catch (Exception e) {
						
						//e.printStackTrace();
					}
					
				}

				@Override
				public void insertUpdate(DocumentEvent arg0) {
					try {
						compMissileUpdater();
					} catch (Exception e) {
						
						//e.printStackTrace();
					}
					
				}

				@Override
				public void removeUpdate(DocumentEvent arg0) {
					//blah
				}
			
			});//End LIsenter
			getContentPane().add(DInOpPac3);
			
			BPac3Oh = new JTextField();
			BPac3Oh.setToolTipText("Number of OH Pac3");
			BPac3Oh.setHorizontalAlignment(SwingConstants.CENTER);
			BPac3Oh.setColumns(10);
			BPac3Oh.setBackground(Color.WHITE);
			BPac3Oh.setBounds(934, 307, 40, 96);
			BPac3Oh.getDocument().addDocumentListener(new DocumentListener(){

				@Override
				public void changedUpdate(DocumentEvent arg0) {
					try {
						compMissileUpdater();
					} catch (Exception e) {
						
						//e.printStackTrace();
					}
					
				}

				@Override
				public void insertUpdate(DocumentEvent arg0) {
					try {
						compMissileUpdater();
					} catch (Exception e) {
						
						//e.printStackTrace();
					}
					
				}

				@Override
				public void removeUpdate(DocumentEvent arg0) {
					//blah
				}
			
			});//End LIsenter
			getContentPane().add(BPac3Oh);
			
			CPac3Oh = new JTextField();
			CPac3Oh.setToolTipText("Number of OH Pac3");
			CPac3Oh.setHorizontalAlignment(SwingConstants.CENTER);
			CPac3Oh.setColumns(10);
			CPac3Oh.setBackground(Color.WHITE);
			CPac3Oh.setBounds(934, 402, 40, 96);
			CPac3Oh.getDocument().addDocumentListener(new DocumentListener(){

				@Override
				public void changedUpdate(DocumentEvent arg0) {
					try {
						compMissileUpdater();
					} catch (Exception e) {
						
						//e.printStackTrace();
					}
					
				}

				@Override
				public void insertUpdate(DocumentEvent arg0) {
					try {
						compMissileUpdater();
					} catch (Exception e) {
						
						//e.printStackTrace();
					}
					
				}

				@Override
				public void removeUpdate(DocumentEvent arg0) {
					//blah
				}
			
			});//End LIsenter
			getContentPane().add(CPac3Oh);
			
			DPac3Oh = new JTextField();
			DPac3Oh.setToolTipText("Number of OH Pac3");
			DPac3Oh.setHorizontalAlignment(SwingConstants.CENTER);
			DPac3Oh.setColumns(10);
			DPac3Oh.setBackground(Color.WHITE);
			DPac3Oh.setBounds(934, 498, 40, 96);
			DPac3Oh.getDocument().addDocumentListener(new DocumentListener(){

				@Override
				public void changedUpdate(DocumentEvent arg0) {
					try {
						compMissileUpdater();
					} catch (Exception e) {
						
						//e.printStackTrace();
					}
					
				}

				@Override
				public void insertUpdate(DocumentEvent arg0) {
					try {
						compMissileUpdater();
					} catch (Exception e) {
						
						//e.printStackTrace();
					}
					
				}

				@Override
				public void removeUpdate(DocumentEvent arg0) {
					//blah
				}
			
			});//End LIsenter
			getContentPane().add(DPac3Oh);
			
			BGemCOP = new JTextField();
			BGemCOP.setToolTipText("Number of OP GemC");
			BGemCOP.setHorizontalAlignment(SwingConstants.CENTER);
			BGemCOP.setColumns(10);
			BGemCOP.setBackground(Color.WHITE);
			BGemCOP.setBounds(983, 307, 40, 96);
			BGemCOP.getDocument().addDocumentListener(new DocumentListener(){

				@Override
				public void changedUpdate(DocumentEvent arg0) {
					try {
						compMissileUpdater();
					} catch (Exception e) {
						
						//e.printStackTrace();
					}
					
				}

				@Override
				public void insertUpdate(DocumentEvent arg0) {
					try {
						compMissileUpdater();
					} catch (Exception e) {
						
						//e.printStackTrace();
					}
					
				}

				@Override
				public void removeUpdate(DocumentEvent arg0) {
					//blah
				}
			
			});//End LIsenter
			getContentPane().add(BGemCOP);
			
			CGemCOP = new JTextField();
			CGemCOP.setToolTipText("Number of OP GemC");
			CGemCOP.setHorizontalAlignment(SwingConstants.CENTER);
			CGemCOP.setColumns(10);
			CGemCOP.setBackground(Color.WHITE);
			CGemCOP.setBounds(983, 402, 40, 96);
			CGemCOP.getDocument().addDocumentListener(new DocumentListener(){

				@Override
				public void changedUpdate(DocumentEvent arg0) {
					try {
						compMissileUpdater();
					} catch (Exception e) {
						
						//e.printStackTrace();
					}
					
				}

				@Override
				public void insertUpdate(DocumentEvent arg0) {
					try {
						compMissileUpdater();
					} catch (Exception e) {
						
						//e.printStackTrace();
					}
					
				}

				@Override
				public void removeUpdate(DocumentEvent arg0) {
					//blah
				}
			
			});//End LIsenter
			getContentPane().add(CGemCOP);
			
			DGemCOP = new JTextField();
			DGemCOP.setToolTipText("Number of OP GemC");
			DGemCOP.setHorizontalAlignment(SwingConstants.CENTER);
			DGemCOP.setColumns(10);
			DGemCOP.setBackground(Color.WHITE);
			DGemCOP.setBounds(983, 498, 40, 96);
			DGemCOP.getDocument().addDocumentListener(new DocumentListener(){

				@Override
				public void changedUpdate(DocumentEvent arg0) {
					try {
						compMissileUpdater();
					} catch (Exception e) {
						
						//e.printStackTrace();
					}
					
				}

				@Override
				public void insertUpdate(DocumentEvent arg0) {
					try {
						compMissileUpdater();
					} catch (Exception e) {
						
						//e.printStackTrace();
					}
				}

				@Override
				public void removeUpdate(DocumentEvent arg0) {
					//blah
				}
			
			});//End LIsenter
			getContentPane().add(DGemCOP);
			
			BGemCInOp = new JTextField();
			BGemCInOp.setToolTipText("Number of INOP GemC");
			BGemCInOp.setHorizontalAlignment(SwingConstants.CENTER);
			BGemCInOp.setColumns(10);
			BGemCInOp.setBackground(Color.WHITE);
			BGemCInOp.setBounds(1024, 307, 40, 96);
			BGemCInOp.getDocument().addDocumentListener(new DocumentListener(){

				@Override
				public void changedUpdate(DocumentEvent arg0) {
					try {
						compMissileUpdater();
					} catch (Exception e) {
						
						//e.printStackTrace();
					}
					
				}

				@Override
				public void insertUpdate(DocumentEvent arg0) {
					try {
						compMissileUpdater();
					} catch (Exception e) {
						
						//e.printStackTrace();
					}
					
				}

				@Override
				public void removeUpdate(DocumentEvent arg0) {
					//blah
				}
			
			});//End LIsenter
			getContentPane().add(BGemCInOp);
			
			CGemCInOp = new JTextField();
			CGemCInOp.setToolTipText("Number of INOP GemC");
			CGemCInOp.setHorizontalAlignment(SwingConstants.CENTER);
			CGemCInOp.setColumns(10);
			CGemCInOp.setBackground(Color.WHITE);
			CGemCInOp.setBounds(1024, 402, 40, 96);
			CGemCInOp.getDocument().addDocumentListener(new DocumentListener(){

				@Override
				public void changedUpdate(DocumentEvent arg0) {
					try {
						compMissileUpdater();
					} catch (Exception e) {
						
						//e.printStackTrace();
					}
					
				}

				@Override
				public void insertUpdate(DocumentEvent arg0) {
					try {
						compMissileUpdater();
					} catch (Exception e) {
						
						//e.printStackTrace();
					}
					
				}

				@Override
				public void removeUpdate(DocumentEvent arg0) {
					//blah
				}
			
			});//End LIsenter
			getContentPane().add(CGemCInOp);
			
			DGemCInOp = new JTextField();
			DGemCInOp.setToolTipText("Number of INOP GemC");
			DGemCInOp.setHorizontalAlignment(SwingConstants.CENTER);
			DGemCInOp.setColumns(10);
			DGemCInOp.setBackground(Color.WHITE);
			DGemCInOp.setBounds(1024, 498, 40, 96);
			DGemCInOp.getDocument().addDocumentListener(new DocumentListener(){

				@Override
				public void changedUpdate(DocumentEvent arg0) {
					try {
						compMissileUpdater();
					} catch (Exception e) {
						
						//e.printStackTrace();
					}
					
				}

				@Override
				public void insertUpdate(DocumentEvent arg0) {
					try {
						compMissileUpdater();
					} catch (Exception e) {
						
						//e.printStackTrace();
					}
					
				}

				@Override
				public void removeUpdate(DocumentEvent arg0) {
					//blah
				}
			
			});//End LIsenter
			getContentPane().add(DGemCInOp);
			
			BGemCOh = new JTextField();
			BGemCOh.setToolTipText("Number of OH GemC");
			BGemCOh.setHorizontalAlignment(SwingConstants.CENTER);
			BGemCOh.setColumns(10);
			BGemCOh.setBackground(Color.WHITE);
			BGemCOh.setBounds(1065, 307, 40, 96);
			BGemCOh.getDocument().addDocumentListener(new DocumentListener(){

				@Override
				public void changedUpdate(DocumentEvent arg0) {
					try {
						compMissileUpdater();
					} catch (Exception e) {
						
						//e.printStackTrace();
					}
					
				}

				@Override
				public void insertUpdate(DocumentEvent arg0) {
					try {
						compMissileUpdater();
					} catch (Exception e) {
						
						//e.printStackTrace();
					}
					
				}

				@Override
				public void removeUpdate(DocumentEvent arg0) {
					//blah
				}
			
			});//End LIsenter
			getContentPane().add(BGemCOh);
			
			CGemCOh = new JTextField();
			CGemCOh.setToolTipText("Number of OH GemC");
			CGemCOh.setHorizontalAlignment(SwingConstants.CENTER);
			CGemCOh.setColumns(10);
			CGemCOh.setBackground(Color.WHITE);
			CGemCOh.setBounds(1065, 402, 40, 96);
			CGemCOh.getDocument().addDocumentListener(new DocumentListener(){

				@Override
				public void changedUpdate(DocumentEvent arg0) {
					try {
						compMissileUpdater();
					} catch (Exception e) {
						
						//e.printStackTrace();
					}
					
				}

				@Override
				public void insertUpdate(DocumentEvent arg0) {
					try {
						compMissileUpdater();
					} catch (Exception e) {
						
						//e.printStackTrace();
					}
					
				}

				@Override
				public void removeUpdate(DocumentEvent arg0) {
					//blah
				}
			
			});//End LIsenter
			getContentPane().add(CGemCOh);
			
			DGemCOh = new JTextField();
			DGemCOh.setToolTipText("Number of OH GemC");
			DGemCOh.setHorizontalAlignment(SwingConstants.CENTER);
			DGemCOh.setColumns(10);
			DGemCOh.setBackground(Color.WHITE);
			DGemCOh.setBounds(1065, 498, 40, 96);
			DGemCOh.getDocument().addDocumentListener(new DocumentListener(){

				@Override
				public void changedUpdate(DocumentEvent arg0) {
					try {
						compMissileUpdater();
					} catch (Exception e) {
						
						//e.printStackTrace();
					}
					
				}

				@Override
				public void insertUpdate(DocumentEvent arg0) {
					try {
						compMissileUpdater();
					} catch (Exception e) {
						
						//e.printStackTrace();
					}
					
				}

				@Override
				public void removeUpdate(DocumentEvent arg0) {
					//blah
				}
			
			});//End LIsenter
			getContentPane().add(DGemCOh);
			
			BGemTOP = new JTextField();
			BGemTOP.setToolTipText("Number of OP GemT");
			BGemTOP.setHorizontalAlignment(SwingConstants.CENTER);
			BGemTOP.setColumns(10);
			BGemTOP.setBackground(Color.WHITE);
			BGemTOP.setBounds(1114, 307, 40, 96);
			BGemTOP.getDocument().addDocumentListener(new DocumentListener(){

				@Override
				public void changedUpdate(DocumentEvent arg0) {
					try {
						compMissileUpdater();
					} catch (Exception e) {
						
						//e.printStackTrace();
					}
					
				}

				@Override
				public void insertUpdate(DocumentEvent arg0) {
					try {
						compMissileUpdater();
					} catch (Exception e) {
						
						//e.printStackTrace();
					}
					
				}

				@Override
				public void removeUpdate(DocumentEvent arg0) {
					//blah
				}
			
			});//End LIsenter
			getContentPane().add(BGemTOP);
			
			CGemTOP = new JTextField();
			CGemTOP.setToolTipText("Number of OP GemT");
			CGemTOP.setHorizontalAlignment(SwingConstants.CENTER);
			CGemTOP.setColumns(10);
			CGemTOP.setBackground(Color.WHITE);
			CGemTOP.setBounds(1114, 402, 40, 96);
			CGemTOP.getDocument().addDocumentListener(new DocumentListener(){

				@Override
				public void changedUpdate(DocumentEvent arg0) {
					try {
						compMissileUpdater();
					} catch (Exception e) {
						
						//e.printStackTrace();
					}
					
				}

				@Override
				public void insertUpdate(DocumentEvent arg0) {
					try {
						compMissileUpdater();
					} catch (Exception e) {
						
						//e.printStackTrace();
					}
					
				}

				@Override
				public void removeUpdate(DocumentEvent arg0) {
					//blah
				}
			
			});//End LIsenter
			getContentPane().add(CGemTOP);
			
			DGemTOP = new JTextField();
			DGemTOP.setToolTipText("Number of OP GemT");
			DGemTOP.setHorizontalAlignment(SwingConstants.CENTER);
			DGemTOP.setColumns(10);
			DGemTOP.setBackground(Color.WHITE);
			DGemTOP.setBounds(1114, 498, 40, 96);
			DGemTOP.getDocument().addDocumentListener(new DocumentListener(){

				@Override
				public void changedUpdate(DocumentEvent arg0) {
					try {
						compMissileUpdater();
					} catch (Exception e) {
						
						//e.printStackTrace();
					}
					
				}

				@Override
				public void insertUpdate(DocumentEvent arg0) {
					try {
						compMissileUpdater();
					} catch (Exception e) {
						
						//e.printStackTrace();
					}
					
				}

				@Override
				public void removeUpdate(DocumentEvent arg0) {
					//blah
				}
			
			});//End LIsenter
			getContentPane().add(DGemTOP);
			
			BGemTInOp = new JTextField();
			BGemTInOp.setToolTipText("Number of Inop GemT");
			BGemTInOp.setHorizontalAlignment(SwingConstants.CENTER);
			BGemTInOp.setColumns(10);
			BGemTInOp.setBackground(Color.WHITE);
			BGemTInOp.setBounds(1156, 307, 40, 96);
			BGemTInOp.getDocument().addDocumentListener(new DocumentListener(){

				@Override
				public void changedUpdate(DocumentEvent arg0) {
					try {
						compMissileUpdater();
					} catch (Exception e) {
						
						//e.printStackTrace();
					}
					
				}

				@Override
				public void insertUpdate(DocumentEvent arg0) {
					try {
						compMissileUpdater();
					} catch (Exception e) {
						
						//e.printStackTrace();
					}
					
				}

				@Override
				public void removeUpdate(DocumentEvent arg0) {
					//blah
				}
			
			});//End LIsenter
			getContentPane().add(BGemTInOp);
			
			CGemTInOp = new JTextField();
			CGemTInOp.setToolTipText("Number of Inop GemT");
			CGemTInOp.setHorizontalAlignment(SwingConstants.CENTER);
			CGemTInOp.setColumns(10);
			CGemTInOp.setBackground(Color.WHITE);
			CGemTInOp.setBounds(1156, 402, 40, 96);
			CGemTInOp.getDocument().addDocumentListener(new DocumentListener(){

				@Override
				public void changedUpdate(DocumentEvent arg0) {
					try {
						compMissileUpdater();
					} catch (Exception e) {
						
						//e.printStackTrace();
					}
					
				}

				@Override
				public void insertUpdate(DocumentEvent arg0) {
					try {
						compMissileUpdater();
					} catch (Exception e) {
						
						//e.printStackTrace();
					}
					
				}

				@Override
				public void removeUpdate(DocumentEvent arg0) {
					//blah
				}
			
			});//End LIsenter
			getContentPane().add(CGemTInOp);
			
			DGemTInOp = new JTextField();
			DGemTInOp.setToolTipText("Number of Inop GemT");
			DGemTInOp.setHorizontalAlignment(SwingConstants.CENTER);
			DGemTInOp.setColumns(10);
			DGemTInOp.setBackground(Color.WHITE);
			DGemTInOp.setBounds(1156, 498, 40, 96);
			DGemTInOp.getDocument().addDocumentListener(new DocumentListener(){

				@Override
				public void changedUpdate(DocumentEvent arg0) {
					try {
						compMissileUpdater();
					} catch (Exception e) {
						
						//e.printStackTrace();
					}
					
				}

				@Override
				public void insertUpdate(DocumentEvent arg0) {
					try {
						compMissileUpdater();
					} catch (Exception e) {
						
						//e.printStackTrace();
					}
					
				}

				@Override
				public void removeUpdate(DocumentEvent arg0) {
					//blah
				}
			
			});//End LIsenter
			getContentPane().add(DGemTInOp);
			
			BGemTOH = new JTextField();
			BGemTOH.setToolTipText("Number of OH GemT");
			BGemTOH.setHorizontalAlignment(SwingConstants.CENTER);
			BGemTOH.setColumns(10);
			BGemTOH.setBackground(Color.WHITE);
			BGemTOH.setBounds(1196, 307, 40, 96);
			BGemTOH.getDocument().addDocumentListener(new DocumentListener(){

				@Override
				public void changedUpdate(DocumentEvent arg0) {
					try {
						compMissileUpdater();
					} catch (Exception e) {
						
						//e.printStackTrace();
					}
					
				}

				@Override
				public void insertUpdate(DocumentEvent arg0) {
					try {
						compMissileUpdater();
					} catch (Exception e) {
						
						//e.printStackTrace();
					}
					
				}

				@Override
				public void removeUpdate(DocumentEvent arg0) {
					//blah
				}
			
			});//End LIsenter
			getContentPane().add(BGemTOH);
			
			CGemTOH = new JTextField();
			CGemTOH.setToolTipText("Number of OH GemT");
			CGemTOH.setHorizontalAlignment(SwingConstants.CENTER);
			CGemTOH.setColumns(10);
			CGemTOH.setBackground(Color.WHITE);
			CGemTOH.setBounds(1196, 402, 40, 96);
			CGemTOH.getDocument().addDocumentListener(new DocumentListener(){

				@Override
				public void changedUpdate(DocumentEvent arg0) {
					try {
						compMissileUpdater();
					} catch (Exception e) {
						
						//e.printStackTrace();
					}
					
				}

				@Override
				public void insertUpdate(DocumentEvent arg0) {
					try {
						compMissileUpdater();
					} catch (Exception e) {
						//e.printStackTrace();
					}
					
				}

				@Override
				public void removeUpdate(DocumentEvent arg0) {
					//blah
				}
			
			});//End LIsenter
			getContentPane().add(CGemTOH);
			
			DGemTOH = new JTextField();
			DGemTOH.setToolTipText("Number of OH GemT");
			DGemTOH.setHorizontalAlignment(SwingConstants.CENTER);
			DGemTOH.setColumns(10);
			DGemTOH.setBackground(Color.WHITE);
			DGemTOH.setBounds(1196, 498, 40, 96);
			DGemTOH.getDocument().addDocumentListener(new DocumentListener(){

				@Override
				public void changedUpdate(DocumentEvent arg0) {
					try {
						compMissileUpdater();
					} catch (Exception e) {
						//e.printStackTrace();
					}
					
				}

				@Override
				public void insertUpdate(DocumentEvent arg0) {
					try {
						compMissileUpdater();
					} catch (Exception e) {
						//e.printStackTrace();
					}
					
				}

				@Override
				public void removeUpdate(DocumentEvent arg0) {
					//blah
				}
			
			});//End LIsenter
			getContentPane().add(DGemTOH);
			
			BtotalMissileCount = new JTextField();
			BtotalMissileCount.setToolTipText("Total Missile Count for Bravo");
			BtotalMissileCount.setHorizontalAlignment(SwingConstants.CENTER);
			BtotalMissileCount.setForeground(Color.WHITE);
			BtotalMissileCount.setEditable(false);
			BtotalMissileCount.setColumns(10);
			BtotalMissileCount.setBackground(Color.BLACK);
			BtotalMissileCount.setBounds(1236, 308, 155, 96);
			getContentPane().add(BtotalMissileCount);
			
			CtotalMissileCount = new JTextField();
			CtotalMissileCount.setToolTipText("Total Missile Count for Charlie");
			CtotalMissileCount.setHorizontalAlignment(SwingConstants.CENTER);
			CtotalMissileCount.setForeground(Color.WHITE);
			CtotalMissileCount.setEditable(false);
			CtotalMissileCount.setColumns(10);
			CtotalMissileCount.setBackground(Color.BLACK);
			CtotalMissileCount.setBounds(1236, 404, 155, 96);
			getContentPane().add(CtotalMissileCount);
			
			DtotalMissileCount = new JTextField();
			DtotalMissileCount.setToolTipText("Total Missile Count for Delta");
			DtotalMissileCount.setHorizontalAlignment(SwingConstants.CENTER);
			DtotalMissileCount.setForeground(Color.WHITE);
			DtotalMissileCount.setEditable(false);
			DtotalMissileCount.setColumns(10);
			DtotalMissileCount.setBackground(Color.BLACK);
			DtotalMissileCount.setBounds(1236, 500, 155, 96);
			getContentPane().add(DtotalMissileCount);
			
			BRemarks = new JTextArea();
			BRemarks.setWrapStyleWord(true);
			BRemarks.setToolTipText("Bravo's Current System Faults and Deadlines ");
			BRemarks.setLineWrap(true);
			BRemarks.setBackground(Color.LIGHT_GRAY);
			BRemarks.setBounds(1544, 310, 284, 94);
			getContentPane().add(BRemarks);
			
			CRemarks = new JTextArea();
			CRemarks.setWrapStyleWord(true);
			CRemarks.setToolTipText("Charlie's Current System Faults and Deadlines");
			CRemarks.setLineWrap(true);
			CRemarks.setBackground(Color.LIGHT_GRAY);
			CRemarks.setBounds(1544, 405, 284, 95);
			getContentPane().add(CRemarks);
			
			DRemarks = new JTextArea();
			DRemarks.setWrapStyleWord(true);
			DRemarks.setToolTipText("Delta's Current System Faults and Deadlines");
			DRemarks.setLineWrap(true);
			DRemarks.setBackground(Color.LIGHT_GRAY);
			DRemarks.setBounds(1544, 501, 284, 96);
			getContentPane().add(DRemarks);
			
			BOPLs = new JTextField();
			BOPLs.setToolTipText("Current Number of OP Pac3 Launchers");
			BOPLs.setHorizontalAlignment(SwingConstants.CENTER);
			BOPLs.setColumns(10);
			BOPLs.setBackground(new Color(205, 133, 63));
			BOPLs.setBounds(1391, 308, 77, 48);
			BOPLs.getDocument().addDocumentListener(new DocumentListener(){

				@Override
				public void changedUpdate(DocumentEvent arg0) {
					try {
						compMissileUpdater();
					} catch (Exception e) {
						//e.printStackTrace();
					}
					
				}

				@Override
				public void insertUpdate(DocumentEvent arg0) {
					try {
						compMissileUpdater();
					} catch (Exception e) {
						//e.printStackTrace();
					}
					
				}

				@Override
				public void removeUpdate(DocumentEvent arg0) {
					//blah
				}
			
			});//End LIsenter
			getContentPane().add(BOPLs);
			
			BInopLs = new JTextField();
			BInopLs.setHorizontalAlignment(SwingConstants.CENTER);
			BInopLs.setToolTipText("Current number of INOP Pac3 Launchers\r\n");
			BInopLs.setColumns(10);
			BInopLs.setBackground(new Color(205, 133, 63));
			BInopLs.setBounds(1469, 308, 77, 48);
			BInopLs.getDocument().addDocumentListener(new DocumentListener(){

				@Override
				public void changedUpdate(DocumentEvent arg0) {
					try {
						compMissileUpdater();
					} catch (Exception e) {
						//e.printStackTrace();
					}
					
				}

				@Override
				public void insertUpdate(DocumentEvent arg0) {
					try {
						compMissileUpdater();
					} catch (Exception e) {
						//e.printStackTrace();
					}
					
				}

				@Override
				public void removeUpdate(DocumentEvent arg0) {
					//blah
				}
			
			});//End LIsenter
			getContentPane().add(BInopLs);
			
			BOPpac2L = new JTextField();
			BOPpac2L.setHorizontalAlignment(SwingConstants.CENTER);
			BOPpac2L.setToolTipText("Current Number of OP Pac2 Launchers\r\n");
			BOPpac2L.setColumns(10);
			BOPpac2L.setBackground(new Color(205, 133, 63));
			BOPpac2L.setBounds(1391, 356, 77, 48);
			BOPpac2L.getDocument().addDocumentListener(new DocumentListener(){

				@Override
				public void changedUpdate(DocumentEvent arg0) {
					try {
						compMissileUpdater();
					} catch (Exception e) {
						//e.printStackTrace();
					}
					
				}

				@Override
				public void insertUpdate(DocumentEvent arg0) {
					try {
						compMissileUpdater();
					} catch (Exception e) {
						//e.printStackTrace();
					}
					
				}

				@Override
				public void removeUpdate(DocumentEvent arg0) {
					//blah
				}
			
			});//End LIsenter
			getContentPane().add(BOPpac2L);
			
			BInopPac2L = new JTextField();
			BInopPac2L.setHorizontalAlignment(SwingConstants.CENTER);
			BInopPac2L.setToolTipText("Current Number of INOP Pac2 Launchers");
			BInopPac2L.setColumns(10);
			BInopPac2L.setBackground(new Color(205, 133, 63));
			BInopPac2L.setBounds(1469, 356, 77, 48);
			BInopPac2L.getDocument().addDocumentListener(new DocumentListener(){

				@Override
				public void changedUpdate(DocumentEvent arg0) {
					try {
						compMissileUpdater();
					} catch (Exception e) {
						//e.printStackTrace();
					}
					
				}

				@Override
				public void insertUpdate(DocumentEvent arg0) {
					try {
						compMissileUpdater();
					} catch (Exception e) {
						//e.printStackTrace();
					}
					
				}

				@Override
				public void removeUpdate(DocumentEvent arg0) {
					//blah
				}
			
			});//End LIsenter
			getContentPane().add(BInopPac2L);
			
			COPLs = new JTextField();
			COPLs.setToolTipText("Current Number of OP Pac3 Launchers");
			COPLs.setHorizontalAlignment(SwingConstants.CENTER);
			COPLs.setColumns(10);
			COPLs.setBackground(new Color(205, 133, 63));
			COPLs.setBounds(1391, 404, 77, 48);
			COPLs.getDocument().addDocumentListener(new DocumentListener(){

				@Override
				public void changedUpdate(DocumentEvent arg0) {
					try {
						compMissileUpdater();
					} catch (Exception e) {
						//e.printStackTrace();
					}
					
				}

				@Override
				public void insertUpdate(DocumentEvent arg0) {
					try {
						compMissileUpdater();
					} catch (Exception e) {
						//e.printStackTrace();
					}
					
				}

				@Override
				public void removeUpdate(DocumentEvent arg0) {
					//blah
				}
			
			});//End LIsenter
			getContentPane().add(COPLs);
			
			CInopLs = new JTextField();
			CInopLs.setHorizontalAlignment(SwingConstants.CENTER);
			CInopLs.setToolTipText("Current number of INOP Pac3 Launchers\r\n");
			CInopLs.setColumns(10);
			CInopLs.setBackground(new Color(205, 133, 63));
			CInopLs.setBounds(1469, 404, 77, 48);
			CInopLs.getDocument().addDocumentListener(new DocumentListener(){

				@Override
				public void changedUpdate(DocumentEvent arg0) {
					try {
						compMissileUpdater();
					} catch (Exception e) {
						//e.printStackTrace();
					}
					
				}

				@Override
				public void insertUpdate(DocumentEvent arg0) {
					try {
						compMissileUpdater();
					} catch (Exception e) {
						//e.printStackTrace();
					}
					
				}

				@Override
				public void removeUpdate(DocumentEvent arg0) {
					//blah
				}
			
			});//End LIsenter
			getContentPane().add(CInopLs);
			
			COPpac2L = new JTextField();
			COPpac2L.setHorizontalAlignment(SwingConstants.CENTER);
			COPpac2L.setToolTipText("Current Number of OP Pac2 Launchers\r\n");
			COPpac2L.setColumns(10);
			COPpac2L.setBackground(new Color(205, 133, 63));
			COPpac2L.setBounds(1391, 452, 77, 48);
			COPpac2L.getDocument().addDocumentListener(new DocumentListener(){

				@Override
				public void changedUpdate(DocumentEvent arg0) {
					try {
						compMissileUpdater();
					} catch (Exception e) {
						//e.printStackTrace();
					}
					
				}

				@Override
				public void insertUpdate(DocumentEvent arg0) {
					try {
						compMissileUpdater();
					} catch (Exception e) {
						//e.printStackTrace();
					}
					
				}

				@Override
				public void removeUpdate(DocumentEvent arg0) {
					//blah
				}
			
			});//End LIsenter
			getContentPane().add(COPpac2L);
			
			CInopPac2L = new JTextField();
			CInopPac2L.setHorizontalAlignment(SwingConstants.CENTER);
			CInopPac2L.setToolTipText("Current Number of INOP Pac2 Launchers");
			CInopPac2L.setColumns(10);
			CInopPac2L.setBackground(new Color(205, 133, 63));
			CInopPac2L.setBounds(1469, 452, 77, 48);
			CInopPac2L.getDocument().addDocumentListener(new DocumentListener(){

				@Override
				public void changedUpdate(DocumentEvent arg0) {
					try {
						compMissileUpdater();
					} catch (Exception e) {
						//e.printStackTrace();
					}
					
				}

				@Override
				public void insertUpdate(DocumentEvent arg0) {
					try {
						compMissileUpdater();
					} catch (Exception e) {
						//e.printStackTrace();
					}
					
				}

				@Override
				public void removeUpdate(DocumentEvent arg0) {
					//blah
				}
			
			});//End LIsenter
			getContentPane().add(CInopPac2L);
			
			DOPLs = new JTextField();
			DOPLs.setToolTipText("Current Number of OP Pac3 Launchers");
			DOPLs.setHorizontalAlignment(SwingConstants.CENTER);
			DOPLs.setColumns(10);
			DOPLs.setBackground(new Color(205, 133, 63));
			DOPLs.setBounds(1391, 500, 77, 48);
			DOPLs.getDocument().addDocumentListener(new DocumentListener(){

				@Override
				public void changedUpdate(DocumentEvent arg0) {
					try {
						compMissileUpdater();
					} catch (Exception e) {
						//e.printStackTrace();
					}
					
				}

				@Override
				public void insertUpdate(DocumentEvent arg0) {
					try {
						compMissileUpdater();
					} catch (Exception e) {
						//e.printStackTrace();
					}
					
				}

				@Override
				public void removeUpdate(DocumentEvent arg0) {
					//blah
				}
			
			});//End LIsenter
			getContentPane().add(DOPLs);
			
			DInopLs = new JTextField();
			DInopLs.setHorizontalAlignment(SwingConstants.CENTER);
			DInopLs.setToolTipText("Current number of INOP Pac3 Launchers\r\n");
			DInopLs.setColumns(10);
			DInopLs.setBackground(new Color(205, 133, 63));
			DInopLs.setBounds(1469, 500, 77, 48);
			DInopLs.getDocument().addDocumentListener(new DocumentListener(){

				@Override
				public void changedUpdate(DocumentEvent arg0) {
					try {
						compMissileUpdater();
					} catch (Exception e) {
						//e.printStackTrace();
					}
					
				}

				@Override
				public void insertUpdate(DocumentEvent arg0) {
					try {
						compMissileUpdater();
					} catch (Exception e) {
						//e.printStackTrace();
					}
					
				}

				@Override
				public void removeUpdate(DocumentEvent arg0) {
					//blah
				}
			
			});//End LIsenter
			getContentPane().add(DInopLs);
			
			DOPpac2L = new JTextField();
			DOPpac2L.setHorizontalAlignment(SwingConstants.CENTER);
			DOPpac2L.setToolTipText("Current Number of OP Pac2 Launchers\r\n");
			DOPpac2L.setColumns(10);
			DOPpac2L.setBackground(new Color(205, 133, 63));
			DOPpac2L.setBounds(1391, 548, 77, 48);
			DOPpac2L.getDocument().addDocumentListener(new DocumentListener(){

				@Override
				public void changedUpdate(DocumentEvent arg0) {
					try {
						compMissileUpdater();
					} catch (Exception e) {
						//e.printStackTrace();
					}
					
				}

				@Override
				public void insertUpdate(DocumentEvent arg0) {
					try {
						compMissileUpdater();
					} catch (Exception e) {
						//e.printStackTrace();
					}
					
				}

				@Override
				public void removeUpdate(DocumentEvent arg0) {
					//blah
				}
			
			});//End LIsenter
			getContentPane().add(DOPpac2L);
			
			DInopPac2L = new JTextField();
			DInopPac2L.setHorizontalAlignment(SwingConstants.CENTER);
			DInopPac2L.setToolTipText("Current Number of INOP Pac2 Launchers");
			DInopPac2L.setColumns(10);
			DInopPac2L.setBackground(new Color(205, 133, 63));
			DInopPac2L.setBounds(1469, 548, 77, 48);
			DInopPac2L.getDocument().addDocumentListener(new DocumentListener(){

				@Override
				public void changedUpdate(DocumentEvent arg0) {
					try {
						compMissileUpdater();
					} catch (Exception e) {
						//e.printStackTrace();
					}
					
				}

				@Override
				public void insertUpdate(DocumentEvent arg0) {
					try {
						compMissileUpdater();
					} catch (Exception e) {
						//e.printStackTrace();
					}
					
				}

				@Override
				public void removeUpdate(DocumentEvent arg0) {
					//blah
				}
			
			});//End LIsenter
			getContentPane().add(DInopPac2L);
			
			stoSelector = new JTextField();
			stoSelector.setBounds(161, 594, 68, 40);
			getContentPane().add(stoSelector);
			stoSelector.setColumns(10);
			
			txtAcospins = new JTextField();
			txtAcospins.setEditable(false);
			txtAcospins.setBackground(Color.YELLOW);
			txtAcospins.setText("ACO/SPINS");
			txtAcospins.setHorizontalAlignment(SwingConstants.CENTER);
			txtAcospins.setBounds(227, 594, 74, 40);
			getContentPane().add(txtAcospins);
			txtAcospins.setColumns(10);
			
			acoSelector = new JTextField();
			acoSelector.setColumns(10);
			acoSelector.setBounds(299, 594, 86, 40);
			getContentPane().add(acoSelector);
			
			Pac3OPcount = new JTextField();
			Pac3OPcount.setToolTipText("TOTAL OP PAC3 FOR THE BN");
			Pac3OPcount.setEditable(false);
			Pac3OPcount.setHorizontalAlignment(SwingConstants.CENTER);
			Pac3OPcount.setBounds(853, 594, 40, 40);
			getContentPane().add(Pac3OPcount);
			Pac3OPcount.setColumns(10);
			Pac3OPcount.setBackground(new Color(210, 105, 30));
			
			Pac3InopCount = new JTextField();
			Pac3InopCount.setToolTipText("TOTAL INOP PAC3'S FOR THE BN");
			Pac3InopCount.setEditable(false);
			Pac3InopCount.setHorizontalAlignment(SwingConstants.CENTER);
			Pac3InopCount.setColumns(10);
			Pac3InopCount.setBounds(893, 594, 40, 40);
			Pac3InopCount.setBackground(new Color(210, 105, 30));
			getContentPane().add(Pac3InopCount);
			
			
			Pac3OHCount = new JTextField();
			Pac3OHCount.setToolTipText("TOTAL OH PAC3 FOR THE BN");
			Pac3OHCount.setEditable(false);
			Pac3OHCount.setHorizontalAlignment(SwingConstants.CENTER);
			Pac3OHCount.setColumns(10);
			Pac3OHCount.setBounds(934, 594, 40, 40);
			Pac3OHCount.setBackground(new Color(210, 105, 30));
			getContentPane().add(Pac3OHCount);
			
			GemCOPCount = new JTextField();
			GemCOPCount.setToolTipText("TOTAL OP GEMC'S FOR THE BN");
			GemCOPCount.setEditable(false);
			GemCOPCount.setHorizontalAlignment(SwingConstants.CENTER);
			GemCOPCount.setColumns(10);
			GemCOPCount.setBounds(983, 594, 40, 40);
			GemCOPCount.setBackground(new Color(210, 105, 30));
			getContentPane().add(GemCOPCount);
			
			GemCInopCount = new JTextField();
			GemCInopCount.setToolTipText("TOTAL INOP GEMC'S FOR THE BN");
			GemCInopCount.setEditable(false);
			GemCInopCount.setHorizontalAlignment(SwingConstants.CENTER);
			GemCInopCount.setColumns(10);
			GemCInopCount.setBounds(1024, 594, 40, 40);
			GemCInopCount.setBackground(new Color(210, 105, 30));
			getContentPane().add(GemCInopCount);
			
			GemCOHCount = new JTextField();
			GemCOHCount.setToolTipText("TOTAL OH GEMC'S FOR THE BN");
			GemCOHCount.setEditable(false);
			GemCOHCount.setHorizontalAlignment(SwingConstants.CENTER);
			GemCOHCount.setColumns(10);
			GemCOHCount.setBounds(1065, 594, 40, 40);
			GemCOHCount.setBackground(new Color(210, 105, 30));
			getContentPane().add(GemCOHCount);
			
			GemTOPCount = new JTextField();
			GemTOPCount.setToolTipText("TOTAL OP GEMT'S FOR THE BN");
			GemTOPCount.setEditable(false);
			GemTOPCount.setHorizontalAlignment(SwingConstants.CENTER);
			GemTOPCount.setColumns(10);
			GemTOPCount.setBounds(1114, 594, 40, 40);
			GemTOPCount.setBackground(new Color(210, 105, 30));
			getContentPane().add(GemTOPCount);
			
			GemTInopCount = new JTextField();
			GemTInopCount.setToolTipText("TOTAL INOP GEMT'S FOR THE BN");
			GemTInopCount.setEditable(false);
			GemTInopCount.setHorizontalAlignment(SwingConstants.CENTER);
			GemTInopCount.setColumns(10);
			GemTInopCount.setBounds(1156, 594, 40, 40);
			GemTInopCount.setBackground(new Color(210, 105, 30));
			getContentPane().add(GemTInopCount);
			
			GemTOHCount = new JTextField();
			GemTOHCount.setToolTipText("TOTAL OH GEMT'S FOR THE BN");
			GemTOHCount.setEditable(false);
			GemTOHCount.setHorizontalAlignment(SwingConstants.CENTER);
			GemTOHCount.setColumns(10);
			GemTOHCount.setBounds(1196, 594, 40, 40);
			GemTOHCount.setBackground(new Color(210, 105, 30));
			getContentPane().add(GemTOHCount);
			
			BnTotalCount = new JTextField();
			BnTotalCount.setToolTipText("TOTAL MISSILE COUNTS FOR THE BN");
			BnTotalCount.setHorizontalAlignment(SwingConstants.CENTER);
			BnTotalCount.setEditable(false);
			BnTotalCount.setForeground(Color.WHITE);
			BnTotalCount.setBackground(Color.BLACK);
			BnTotalCount.setColumns(10);
			BnTotalCount.setBounds(1236, 594, 155, 40);
			getContentPane().add(BnTotalCount);
			
			BnOpLsCount = new JTextField();
			BnOpLsCount.setToolTipText("TOTAL NUMBER OF OP PAC3 LAUNCHERS");
			BnOpLsCount.setEditable(false);
			BnOpLsCount.setHorizontalAlignment(SwingConstants.CENTER);
			BnOpLsCount.setBounds(1391, 594, 77, 20);
			BnOpLsCount.setBackground(new Color(205, 133, 63));
			getContentPane().add(BnOpLsCount);
			BnOpLsCount.setColumns(10);
			
			BnPac2OPCount = new JTextField();
			BnPac2OPCount.setEditable(false);
			BnPac2OPCount.setToolTipText("TOTAL NUMBER OF OP PAC2 LAUNCHERS");
			BnPac2OPCount.setHorizontalAlignment(SwingConstants.CENTER);
			BnPac2OPCount.setColumns(10);
			BnPac2OPCount.setBounds(1391, 614, 77, 20);
			BnPac2OPCount.setBackground(new Color(205, 133, 63));
			getContentPane().add(BnPac2OPCount);
			
			BnLsInopCount = new JTextField();
			BnLsInopCount.setEditable(false);
			BnLsInopCount.setToolTipText("TOTAL NUMBER OF INOP PAC3 LAUNCHERS");
			BnLsInopCount.setHorizontalAlignment(SwingConstants.CENTER);
			BnLsInopCount.setColumns(10);
			BnLsInopCount.setBounds(1469, 594, 77, 20);
			BnLsInopCount.setBackground(new Color(205, 133, 63));
			getContentPane().add(BnLsInopCount);
			
			BnPac2InopCount = new JTextField();
			BnPac2InopCount.setToolTipText("TOTAL NUMBER OF INOP PAC2 LAUNCHERS");
			BnPac2InopCount.setEditable(false);
			BnPac2InopCount.setHorizontalAlignment(SwingConstants.CENTER);
			BnPac2InopCount.setColumns(10);
			BnPac2InopCount.setBounds(1469, 614, 77, 20);
			BnPac2InopCount.setBackground(new Color(205, 133, 63));
			getContentPane().add(BnPac2InopCount);
			
			JButton btnNewButton = new JButton("UPDATE");
			btnNewButton.setToolTipText("Click to refresh the program");
			btnNewButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					//PAC3 COUNTS FOR THE BN
					missileCounter(AOpPac3, BOpPac3, COpPac3, DOpPac3, Pac3OPcount);
				 	missileCounter(AInOpPac3, BInOpPac3, CInOpPac3, DInOpPac3, Pac3InopCount);
					missileCounter(APac3Oh, BPac3Oh, CPac3Oh, DPac3Oh, Pac3OHCount);
					//GEMC COUNTS FOR THE BN
					missileCounter(AGemCOP, BGemCOP, CGemCOP, DGemCOP, GemCOPCount);
					missileCounter(AGemCInOp, BGemCInOp, CGemCInOp, DGemCInOp, GemCInopCount);
					missileCounter(AGemCOh, BGemCOh, CGemCOh, DGemCOh, GemCOHCount);
					//GEMT COUNTS FOR THE BN
					missileCounter(AGemTOP, BGemTOP, CGemTOP, DGemTOP, GemTOPCount);
					missileCounter(AGemTInOp, BGemTInOp, CGemTInOp, DGemTInOp, GemTInopCount);
					missileCounter(AGemTOH, BGemTOH, CGemTOH, DGemTOH, GemTOHCount);
					//MISSILE COUNTS PER UNIT
					missileCounter(AOpPac3, AInOpPac3, APac3Oh, AGemCOP, AGemCInOp, AGemCOh, AGemTOP, AGemTInOp, AGemTOH, AtotalMissileCount);
					missileCounter(BOpPac3, BInOpPac3, BPac3Oh, BGemCOP, BGemCInOp, BGemCOh, BGemTOP, BGemTInOp, BGemTOH, BtotalMissileCount);
					missileCounter(COpPac3, CInOpPac3, CPac3Oh, CGemCOP, CGemCInOp, CGemCOh, CGemTOP, CGemTInOp, CGemTOH, CtotalMissileCount);
					missileCounter(DOpPac3, DInOpPac3, DPac3Oh, DGemCOP, DGemCInOp, DGemCOh, DGemTOP, DGemTInOp, DGemTOH, DtotalMissileCount);
					//TOTAL COUNT FOR THE BN
					
					missileCounter(Pac3OPcount, Pac3InopCount, Pac3OHCount, GemCOPCount, GemCInopCount, GemCOHCount, GemTOPCount, GemTInopCount, GemTOHCount, BnTotalCount);
					//Resetting the boxes back to orange is a lot easier than writing a special case or method to handle these boxes
					//with out this manual reset on the background the IOvalidator method will set these boxes to white when we call missileCounter to add up the BN totals.
					Pac3OPcount.setBackground(new Color(210, 105, 30));
					Pac3InopCount.setBackground(new Color(210, 105, 30));
					Pac3OHCount.setBackground(new Color(210, 105, 30));
					GemCOPCount.setBackground(new Color(210, 105, 30));
					GemCOPCount.setBackground(new Color(210, 105, 30));
					GemCInopCount.setBackground(new Color(210, 105, 30));
					GemCOHCount.setBackground(new Color(210, 105, 30));
					GemTOPCount.setBackground(new Color(210, 105, 30));
					GemTInopCount.setBackground(new Color(210, 105, 30));
					GemTOHCount.setBackground(new Color(210, 105, 30));
					
					//COUNT UP LAUNCHERS
					missileCounter(AOPLs, BOPLs, COPLs, DOPLs, BnOpLsCount);
					missileCounter(AOPpac2L, BOPpac2L, COPpac2L, DOPpac2L, BnPac2OPCount);
					missileCounter(AInopLs, BInopLs, CInopLs, DInopLs, BnLsInopCount);
					missileCounter(AInopPac2L, BInopPac2L, CInopPac2L, DInopPac2L, BnPac2InopCount);
										
					currentDtg.setText(zTime()); //Update time stamp
				}
			});
			btnNewButton.setBounds(1701, 603, 89, 23);
			getContentPane().add(btnNewButton);
			
			curSto = new JTextField();
			curSto.setToolTipText("UNIT'S CURRENT STO");
			curSto.setText("STO");
			curSto.setHorizontalAlignment(SwingConstants.CENTER);
			curSto.setEditable(false);
			curSto.setColumns(10);
			curSto.setBackground(Color.RED);
			curSto.setBounds(638, 63, 40, 53);
			getContentPane().add(curSto);
			
			curAco = new JTextField();
			curAco.setText("ACO");
			curAco.setHorizontalAlignment(SwingConstants.CENTER);
			curAco.setEditable(false);
			curAco.setColumns(10);
			curAco.setBackground(Color.RED);
			curAco.setBounds(680, 63, 40, 53);
			getContentPane().add(curAco);
			
			curDTG = new JTextField();
			curDTG.setToolTipText("DTG FOR LAST RECIEVED SAMSTAT");
			curDTG.setText("DTG");
			curDTG.setHorizontalAlignment(SwingConstants.CENTER);
			curDTG.setEditable(false);
			curDTG.setColumns(10);
			curDTG.setBackground(Color.RED);
			curDTG.setBounds(722, 63, 121, 53);
			getContentPane().add(curDTG);
			
			hhbCurSto = new JTextField();
			hhbCurSto.setToolTipText("UNIT'S CURRENT STO");
			hhbCurSto.setHorizontalAlignment(SwingConstants.CENTER);
			hhbCurSto.setEditable(false);
			hhbCurSto.setColumns(10);
			hhbCurSto.setBackground(Color.WHITE);
			hhbCurSto.setBounds(638, 116, 40, 96);
			getContentPane().add(hhbCurSto);
			
			aCurSto = new JTextField();
			aCurSto.setToolTipText("UNIT'S CURRENT STO");
			aCurSto.setHorizontalAlignment(SwingConstants.CENTER);
			aCurSto.setColumns(10);
			aCurSto.setBackground(Color.WHITE);
			aCurSto.setBounds(638, 212, 40, 96);
			getContentPane().add(aCurSto);
			
			bCurSto = new JTextField();
			bCurSto.setToolTipText("UNIT'S CURRENT STO");
			bCurSto.setHorizontalAlignment(SwingConstants.CENTER);
			bCurSto.setColumns(10);
			bCurSto.setBackground(Color.WHITE);
			bCurSto.setBounds(638, 307, 40, 96);
			getContentPane().add(bCurSto);
			
			cCurSto = new JTextField();
			cCurSto.setToolTipText("UNIT'S CURRENT STO");
			cCurSto.setHorizontalAlignment(SwingConstants.CENTER);
			cCurSto.setColumns(10);
			cCurSto.setBackground(Color.WHITE);
			cCurSto.setBounds(638, 402, 40, 96);
			getContentPane().add(cCurSto);
			
			dCurSto = new JTextField();
			dCurSto.setToolTipText("UNIT'S CURRENT STO");
			dCurSto.setHorizontalAlignment(SwingConstants.CENTER);
			dCurSto.setColumns(10);
			dCurSto.setBackground(Color.WHITE);
			dCurSto.setBounds(638, 498, 40, 96);
			getContentPane().add(dCurSto);
			
			hhbCurAco = new JTextField();
			hhbCurAco.setToolTipText("UNIT'S CURRENT ACO");
			hhbCurAco.setHorizontalAlignment(SwingConstants.CENTER);
			hhbCurAco.setEditable(false);
			hhbCurAco.setColumns(10);
			hhbCurAco.setBackground(Color.WHITE);
			hhbCurAco.setBounds(680, 116, 40, 96);
			getContentPane().add(hhbCurAco);
			
			aCurAco = new JTextField();
			aCurAco.setToolTipText("UNIT'S CURRENT ACO");
			aCurAco.setHorizontalAlignment(SwingConstants.CENTER);
			aCurAco.setColumns(10);
			aCurAco.setBackground(Color.WHITE);
			aCurAco.setBounds(680, 212, 40, 96);
			getContentPane().add(aCurAco);
			
			bCurAco = new JTextField();
			bCurAco.setToolTipText("UNIT'S CURRENT ACO");
			bCurAco.setHorizontalAlignment(SwingConstants.CENTER);
			bCurAco.setColumns(10);
			bCurAco.setBackground(Color.WHITE);
			bCurAco.setBounds(680, 307, 40, 96);
			getContentPane().add(bCurAco);
			
			cCurAco = new JTextField();
			cCurAco.setToolTipText("UNIT'S CURRENT ACO");
			cCurAco.setHorizontalAlignment(SwingConstants.CENTER);
			cCurAco.setColumns(10);
			cCurAco.setBackground(Color.WHITE);
			cCurAco.setBounds(680, 402, 40, 96);
			getContentPane().add(cCurAco);
			
			dCurAco = new JTextField();
			dCurAco.setToolTipText("UNIT'S CURRENT ACO");
			dCurAco.setHorizontalAlignment(SwingConstants.CENTER);
			dCurAco.setColumns(10);
			dCurAco.setBackground(Color.WHITE);
			dCurAco.setBounds(680, 498, 40, 96);
			getContentPane().add(dCurAco);
			
			hhbDtg = new JTextField();
			hhbDtg.setToolTipText("DTG FOR LAST RECIEVED SAMSTAT");
			hhbDtg.setHorizontalAlignment(SwingConstants.CENTER);
			hhbDtg.setColumns(10);
			hhbDtg.setBackground(Color.WHITE);
			hhbDtg.setBounds(722, 116, 121, 96);
			getContentPane().add(hhbDtg);
			
			aDtg = new JTextField();
			aDtg.setToolTipText("DTG FOR LAST RECIEVED SAMSTAT");
			aDtg.setHorizontalAlignment(SwingConstants.CENTER);
			aDtg.setColumns(10);
			aDtg.setBackground(Color.WHITE);
			aDtg.setBounds(722, 212, 121, 96);
			getContentPane().add(aDtg);
			
			bDtg = new JTextField();
			bDtg.setToolTipText("DTG FOR LAST RECIEVED SAMSTAT");
			bDtg.setHorizontalAlignment(SwingConstants.CENTER);
			bDtg.setColumns(10);
			bDtg.setBackground(Color.WHITE);
			bDtg.setBounds(722, 307, 121, 96);
			getContentPane().add(bDtg);
			
			cDtg = new JTextField();
			cDtg.setToolTipText("DTG FOR LAST RECIEVED SAMSTAT");
			cDtg.setHorizontalAlignment(SwingConstants.CENTER);
			cDtg.setColumns(10);
			cDtg.setBackground(Color.WHITE);
			cDtg.setBounds(722, 402, 121, 96);
			getContentPane().add(cDtg);
			
			dDtg = new JTextField();
			dDtg.setToolTipText("DTG FOR LAST RECIEVED SAMSTAT");
			dDtg.setHorizontalAlignment(SwingConstants.CENTER);
			dDtg.setColumns(10);
			dDtg.setBackground(Color.WHITE);
			dDtg.setBounds(722, 498, 121, 96);
			getContentPane().add(dDtg);
			
			lBackGround = AOPLs.getBackground();
			
			unitData uData = new unitData(starter, starter, starter, starter, starter, starter, starter);
			fireUnitData fUData = new fireUnitData(starter, starter, starter, starter, starter, starter, starter, starter, starter, starter, starter, starter, starter, starter, starter, starter, starter, starter, starter, starter, starter, uData);



			
			
	}//End Constructor

	






	@Override
	public void broadCastSetter() {
		// TODO Auto-generated method stub
		
	}//end broadCastSetter


	@Override
	public void missileCounter(JTextField field1, JTextField field2, JTextField field3, JTextField field4, JTextField target) {
		int addend1 = 0;
		int addend2 = 0;
		int addend3 = 0;
		int addend4 = 0;
		int Sum = 0;
		
		addend1 = IOvalidator(field1);
		addend2 = IOvalidator(field2);
		addend3 = IOvalidator(field3);
		addend4 = IOvalidator(field4);
		
		Sum = addend1 + addend2 + addend3 + addend4;
		target.setText(String.valueOf(Sum));
	}//End missileCounter
	
	/**
	** This missileCounter method is used to update all of a batteries missile counts.
	** @param field1, field2, field3, field4, field5, field6, field7, field8, field9 target
	** @return none
	** @throws none
	**/

	public void missileCounter(JTextField field1, JTextField field2, JTextField field3, JTextField field4, JTextField field5, JTextField field6, JTextField field7, JTextField field8, JTextField field9, JTextField target){
		int addend1 = 0;
		int addend2 = 0;
		int addend3 = 0;
		int addend4 = 0;
		int addend5 = 0;
		int addend6 = 0;
		int addend7 = 0;
		int addend8 = 0;
		int addend9 = 0;
		int Sum = 0;
		
		addend1 = IOvalidator(field1);
		addend2 = IOvalidator(field2);
		addend3 = IOvalidator(field3);
		addend4 = IOvalidator(field4);
		addend5 = IOvalidator(field5);
		addend6 = IOvalidator(field6);
		addend7 = IOvalidator(field7);
		addend8 = IOvalidator(field8);
		addend9 = IOvalidator(field9);
		
		Sum = addend1 + addend2 + addend3 + addend4 + addend5 + addend6 + addend7 + addend8 + addend9;
		target.setText(String.valueOf(Sum));
	}//end MissileCounter




	@Override
	public void fillDropBox(int potentialMissiles, JComboBox combobox) {
		// TODO Auto-generated method stub
		
	}//end fillDropBox


	@Override
	public void stoIncrementor(JComboBox combobox) {
		// TODO Auto-generated method stub
		
	}//end stoIncrementor






	@Override
	public void findIpAddy() {
		// TODO Auto-generated method stub
		
	}//end findIpAddy


	@Override
	public String zTime() {
		SimpleDateFormat formatter = new SimpleDateFormat("ddHHmm'z'MMMyyyy");//This SDF reflects the Army's standard for Date Time Groups
		formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
		Calendar cal = Calendar.getInstance();
		String timestamp = formatter.format(cal.getTime());
		return (timestamp);
	}//end zTime

	
	@Override
	public void missileCounter() {
		// TODO Auto-generated method stub
		
	}//end missileCounter
	
	/**
	** IOvalidator provide input validation for the calling method. 
	** @param JTextField field1 
	** @return int validInt, int invalidInt
	** @throws
	**/

	public int IOvalidator(JTextField field1){
		String holder1; //string var to hold the info we pull from the JTextField
		int validInt = 0; //the Int we will return
		int invalidInt = 0;
		
		if(field1.getText().length() ==0){
			field1.setText("0");
			field1.setBackground(Color.red);
		}
		else if(field1.getText().length() > 0){
			holder1 = field1.getText();
			try {
				validInt = Integer.parseInt(holder1);
				if(validInt < 0){
					field1.setText("");
					field1.setBackground(Color.red);
					
				}else if(validInt == 0){
					field1.setBackground(Color.white);
					}
				else{
					field1.setBackground(lBackGround);
					return(validInt);
				}
			} catch (NumberFormatException e) {
				field1.setText("");
				field1.setBackground(Color.red);
			}
		}
		return(invalidInt);
	}//End IOvalidator
	
	/**
	** dataCopier takes the information from the fireUnitData and unitData objects and copies it into the relevant GUI components 
	** @param fireUnitData fUData, unitData uData
	** @return
	** @throws
	**/
public void dataCopier(fireUnitData status){ 
		
		if(status.getUnitData().getUnitDesignator().equalsIgnoreCase("Alpha")){
			
			ACurAS.setText(status.getCurAs());
			
		 	ADirAS.setText(status.getDirAs());
		 	AcurEtro.setText(status.getEtro());
		 	aCurSto.setText(status.getSto());
		 	aCurAco.setText(status.getAco());
		 	aDtg.setText(status.getDtg());
	
		 	AOpPac3.setText(status.getPac3Op());
		 	AInOpPac3.setText(status.getPac3Inop());
		 	APac3Oh.setText(status.getPac3Oh());
		 	
		 	AGemCOP.setText(status.getGemCOp());
		 	AGemCInOp.setText(status.getGemCInop());
		 	AGemCOh.setText(status.getGemCOh());
		 	
		 	AGemTOP.setText(status.getGemCOp());
		 	AGemTInOp.setText(status.getGemTInop());
		 	AGemTOH.setText(status.getGemTOh());
		 	
		 	AOPLs.setText(status.getOpPac3L());
		 	AInopLs.setText(status.getInopPac3L());
	
		 	AOPpac2L.setText(status.getOpPac2L());
		 	AInopPac2L.setText(status.getInopPac2());
		 	
		 	aUnitId.setBackground(colorReader(status.getStatusBackGround()));
		 	System.out.println(status.getStatusBackGround());
		 	
		 	AdefendedAssets.setText(status.getUnitData().getDefAsset());
		 	aUnitId.setText(status.getUnitData().getUnitName());
		 	AcurLocation.setText(status.getUnitData().getLocation());
		 	AcurPtl.setText(status.getUnitData().getPtl());
		 	AcurStl.setText(status.getUnitData().getStl());
		 	ASystemType.setText(status.getUnitData().getUnitType());
		 	ARemarks.setText(status.getRemarks());
		 	
		 	System.out.println("The Current AS" + status.getCurAs());
		 }
		 else if(status.getUnitData().getUnitDesignator().equalsIgnoreCase("Bravo")){
			 	BCurAS.setText(status.getCurAs());
			 	BDirAS.setText(status.getDirAs());
			 	BcurEtro.setText(status.getEtro());
			 	bCurSto.setText(status.getSto());
			 	bCurAco.setText(status.getAco());
			 	bDtg.setText(status.getDtg());
	
			 	BOpPac3.setText(status.getPac3Op());
			 	BInOpPac3.setText(status.getPac3Inop());
			 	BPac3Oh.setText(status.getPac3Oh());
			 	
			 	BGemCOP.setText(status.getGemCOp());
			 	BGemCInOp.setText(status.getGemCInop());
			 	BGemCOh.setText(status.getGemCOh());
			 	
			 	BGemTOP.setText(status.getGemCOp());
			 	BGemTInOp.setText(status.getGemTInop());
			 	BGemTOH.setText(status.getGemTOh());
			 	
			 	BOPLs.setText(status.getOpPac3L());
			 	BInopLs.setText(status.getInopPac3L());
	
			 	BOPpac2L.setText(status.getOpPac2L());
			 	BInopPac2L.setText(status.getInopPac2());
			 	
			 	bUnitId.setBackground(colorReader(status.getStatusBackGround()));
			 	
			 	BdefendedAssets.setText(status.getUnitData().getDefAsset());
			 	bUnitId.setText(status.getUnitData().getUnitName());
			 	
			 	BcurLocation.setText(status.getUnitData().getLocation());
			 	BcurPtl.setText(status.getUnitData().getPtl());
			 	BcurStl.setText(status.getUnitData().getStl());
			 	BRemarks.setText(status.getRemarks());
			 	BSystemType.setText(status.getUnitData().getUnitType());
		 }
		 else if(status.getUnitData().getUnitDesignator().equalsIgnoreCase("Charlie")){
			 	CCurAS.setText(status.getCurAs());
			 	CDirAS.setText(status.getDirAs());
			 	CcurEtro.setText(status.getEtro());
			 	cCurSto.setText(status.getSto());
			 	cCurAco.setText(status.getAco());
			 	cDtg.setText(status.getDtg());
	
			 	COpPac3.setText(status.getPac3Op());
			 	CInOpPac3.setText(status.getPac3Inop());
			 	CPac3Oh.setText(status.getPac3Oh());
			 	
			 	CGemCOP.setText(status.getGemCOp());
			 	CGemCInOp.setText(status.getGemCInop());
			 	CGemCOh.setText(status.getGemCOh());
			 	
			 	CGemTOP.setText(status.getGemCOp());
			 	CGemTInOp.setText(status.getGemTInop());
			 	CGemTOH.setText(status.getGemTOh());
			 	
			 	COPLs.setText(status.getOpPac3L());
			 	CInopLs.setText(status.getInopPac3L());
	
			 	COPpac2L.setText(status.getOpPac2L());
			 	CInopPac2L.setText(status.getInopPac2());
			 	
			 	cUnitId.setBackground(colorReader(status.getStatusBackGround()));
			 	
			 	CdefendedAssets.setText(status.getUnitData().getDefAsset());
			 	cUnitId.setText(status.getUnitData().getUnitName());
			 	
			 	CcurLocation.setText(status.getUnitData().getLocation());
			 	CcurPtl.setText(status.getUnitData().getPtl());
			 	CcurStl.setText(status.getUnitData().getStl());
			 	CRemarks.setText(status.getRemarks());
			 	
			 	CSystemType.setText(status.getUnitData().getUnitType());
		 }
		 else if(status.getUnitData().getUnitDesignator().equalsIgnoreCase("Delta")){
			 	DCurAS.setText(status.getCurAs());
			 	DDirAS.setText(status.getDirAs());
			 	DcurEtro.setText(status.getEtro());
			 	dCurSto.setText(status.getSto());
			 	dCurAco.setText(status.getAco());
			 	dDtg.setText(status.getDtg());
	
			 	DOpPac3.setText(status.getPac3Op());
			 	DInOpPac3.setText(status.getPac3Inop());
			 	DPac3Oh.setText(status.getPac3Oh());
			 	
			 	DGemCOP.setText(status.getGemCOp());
			 	DGemCInOp.setText(status.getGemCInop());
			 	DGemCOh.setText(status.getGemCOh());
			 	
			 	DGemTOP.setText(status.getGemCOp());
			 	DGemTInOp.setText(status.getGemTInop());
			 	DGemTOH.setText(status.getGemTOh());
			 	
			 	DOPLs.setText(status.getOpPac3L());
			 	DInopLs.setText(status.getInopPac3L());
	
			 	DOPpac2L.setText(status.getOpPac2L());
			 	DInopPac2L.setText(status.getInopPac2());
			 	
			 	dUnitId.setBackground(colorReader(status.getStatusBackGround()));
			 	
			 	DdefendedAssets.setText(status.getUnitData().getDefAsset());
			 	dUnitId.setText(status.getUnitData().getUnitName());
			 	DRemarks.setText(status.getRemarks());
			 	DcurLocation.setText(status.getUnitData().getLocation());
			 	DcurPtl.setText(status.getUnitData().getPtl());
			 	DcurStl.setText(status.getUnitData().getStl());
			 	
			 	
			 	DSystemType.setText(status.getUnitData().getUnitType());
		 }
		 else if(status.getUnitData().getUnitDesignator().equalsIgnoreCase("ICC")){
			 	HHBcurSelector.setSelectedItem(status.getCurAs());
			 	HHBdirSelector.setSelectedItem(status.getDirAs());
			 	HHBcurEtro.setText(status.getEtro());
			 	hhbCurSto.setText(status.getSto());
			 	hhbCurAco.setText(status.getAco());
			 	hhbDtg.setText(status.getDtg());
	
			 	HHBOpPac3.setText(status.getPac3Op());
			 	HHBInOpPac3.setText(status.getPac3Inop());
			 	HHBPac3Oh.setText(status.getPac3Oh());
			 	
			 	HHBGemCOP.setText(status.getGemCOp());
			 	HHBGemCInOp.setText(status.getGemCInop());
			 	HHBGemCOh.setText(status.getGemCOh());
			 	
			 	HHBGemTOP.setText(status.getGemCOp());
			 	HHBGemTInOp.setText(status.getGemTInop());
			 	HHBGemTOH.setText(status.getGemTOh());
			 	
			 	HHBLs.setText(status.getOpPac3L());
			 	HHBInopLs.setText(status.getInopPac3L());
	
			 	HHBOPpac2L.setText(status.getOpPac2L());
			 	HHBInopPac2L.setText(status.getInopPac2());
			 	HHBUnitId.setBackground(colorReader(status.getStatusBackGround()));
			 	
			 	HHBdefendedAssets.setText(status.getUnitData().getDefAsset());
			 	HHBUnitId.setText(status.getUnitData().getUnitName());
			 	HHBRemarks.setText(status.getRemarks());
			 	HHBcurLocation.setText(status.getUnitData().getLocation());
			 	HHBcurPtl.setText(status.getUnitData().getPtl());
			 	HHBcurStl.setText(status.getUnitData().getStl());
			 	
			 	
			 	HHBsystemType.setText(status.getUnitData().getUnitType());
		 }
	}//End dataCopier
	
	/**
	** Color reader accepts strings as arguments runs them through a switch statement and returns the corresponding Color.
	** @param String toStringColor
	** @return curColor: a corresponding color object 
	** @throws
	**/
		public Color colorReader(String toStringColor){
			String color = toStringColor;
			Color curColor = null;
			final String WHITE = "WHITE";
			final String RED = "RED";
			final String GREEN = "GREEN";
			switch (color){
			case WHITE:
				curColor = Color.WHITE;
				break;
			case RED: 
				curColor = Color.RED;
				break;
			case GREEN:
				curColor = Color.GREEN;
				break;
			}
			return curColor;
		}
		
		
		
		/**
		 * Method that processes received samstat file and loads it into GUI
		 * @param JButton button to get button text
		 */
		public void receiveFile(String fileName)
		{	
			System.out.println("Received File Method Called");
			File file = new File(fileName);
			
			if(file.exists())
			{		
				convertJSONToObject(file);			
				
				dataCopier(status);
			}
			else
			{
				System.out.println("Received File Does Not Exist");
			}
			
		}
		
	

		/**
		 * JSON Deserialize Object  Method that converts the JSON to fireUnitData object
		 * @param fireUnitData object
		 * @return String containing the JSON file
		 */
		public void convertJSONToObject(File theFile)
		{			
			String jsonString = readFileToString(theFile);		
			fireUnitData  fud = new fireUnitData();
				
			fud = new JSONDeserializer<fireUnitData>().deserialize(jsonString);
			
			status = fud;
			
		}
		

		/**
		 * Method that writes JSON file to a String
		 * @param FILE the JSON file
		 * @return String the json file in a String
		 */
		private String readFileToString(File file){
			
			String jsonString= "";
			//check if file is valid
			try
			{
				Scanner output = new Scanner(file);
				
				//write file lines to console
				while(output.hasNextLine())
				{
					jsonString += output.nextLine();				
				}
				output.close();
						
			}
			catch(FileNotFoundException e)
			{
				System.out.println("This file does not exist. Try again:");
			}
			
			return jsonString;
		}
		
		/**
		 * File Receiver Inner Class		
		 */
		public class FileReceiver2 implements Runnable 
		{
			private int  portNumber;
			private ServerSocket serverSock = null;	
			
			public FileReceiver2(int portNumber)
			{
				this.portNumber = portNumber;
			}	
			
			public void startServer() throws IOException
			{	
				serverSock = new ServerSocket(portNumber);
				System.out.println("running");
				while(true)
				{
					Socket socket = serverSock.accept();				
						
					Thread t = new Thread(new ClientHandler(socket));	
					t.setPriority(Thread.MAX_PRIORITY);
					t.start();
					System.out.println("got a connection");
				    
				}
			}
			
			public class ClientHandler implements Runnable 
			{		
				Socket socket;
				ObjectInputStream inStream;
				String fileName;
				
				public ClientHandler(Socket clientSocket)
				{
					try 
					{
						socket = clientSocket;
						inStream = new ObjectInputStream(socket.getInputStream());
					}
					catch (Exception ex)
					{
						ex.printStackTrace();
					}
				}
				
				@Override
				public void run(){
					try 
					{
						fileName = (String) inStream.readObject();	
						System.out.println(fileName);
						FileOutputStream outStream = new FileOutputStream(fileName);
					    byte[] buffer = new byte[200000];
			            int bytesRead = 0, counter = 0;
			 
			            while (bytesRead >= 0) 
			            {
			                bytesRead = inStream.read(buffer);
			                if (bytesRead >= 0) 
			                {
			                    outStream.write(buffer, 0, bytesRead);
			                    counter += bytesRead;
			                    System.out.println("total bytes read: " + counter);
			                }
			                if (bytesRead < 1024) 
			                {
			                    outStream.flush();
			                    break;
			                }
			            }
					
				        System.out.println("Download Successfully!");
				        
				        receiveFile(fileName);
				        
				        
			            outStream.close(); 
			            inStream.close();
					} 
					catch (Exception e) 
					{				
						e.printStackTrace();
					}
				}
			}

			@Override
			public void run() {
				try
				{
					startServer();
				}
				catch(IOException e)
				{
					e.printStackTrace(); 			
				}
			}
		}
		
		
		
		public void startFileReceiver()
		{
			
			SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>()
			{

				@Override
				protected Void doInBackground() throws Exception {
						
					ServerSocket serverSock = new ServerSocket(5000);
					System.out.println("running");
					while(true)
					{
						Socket socket = serverSock.accept();				
							
						startFileReceiver2(socket);
						
					    
					}	
					
					
				}
			};
	
			
			worker.execute();
		}
		
		public static class serverInfo
		{
			public String fileName;
			public Socket socket;
		}
		
		
		public void startFileReceiver2(Socket sock)
		{
			
			final serverInfo si = new serverInfo();
			
			si.socket = sock;
			
			
			
			
			SwingWorker<Boolean, Void> worker = new SwingWorker<Boolean, Void>()
			{

				@Override
				protected Boolean doInBackground() throws Exception {
						
					ObjectInputStream inStream = new ObjectInputStream(si.socket.getInputStream());
					si.fileName = (String) inStream.readObject();	
					System.out.println(si.fileName);
					FileOutputStream outStream = new FileOutputStream(si.fileName);
				    byte[] buffer = new byte[200000];
		            int bytesRead = 0, counter = 0;
		 
		            while (bytesRead >= 0) 
		            {
		                bytesRead = inStream.read(buffer);
		                if (bytesRead >= 0) 
		                {
		                    outStream.write(buffer, 0, bytesRead);
		                    counter += bytesRead;
		                    System.out.println("total bytes read: " + counter);
		                }
		                if (bytesRead < 1024) 
		                {
		                    outStream.flush();
		                    break;
		                }
		            }
				
			        System.out.println("Download Successfully!");
			        
			      
			        
		            outStream.close(); 
		            inStream.close();
					
					
					return true;
				}

				/* (non-Javadoc)
				 * @see javax.swing.SwingWorker#done()
				 */
				@Override
				protected void done() {
					// TODO Auto-generated method stub
					
					
					receiveFile(si.fileName);
					super.done();
				}
			};
	
			
			worker.execute();
		}
public void compMissileUpdater(){
	//PAC3 COUNTS FOR THE BN
	missileCounter(AOpPac3, BOpPac3, COpPac3, DOpPac3, Pac3OPcount);
 	missileCounter(AInOpPac3, BInOpPac3, CInOpPac3, DInOpPac3, Pac3InopCount);
	missileCounter(APac3Oh, BPac3Oh, CPac3Oh, DPac3Oh, Pac3OHCount);
	//GEMC COUNTS FOR THE BN
	missileCounter(AGemCOP, BGemCOP, CGemCOP, DGemCOP, GemCOPCount);
	missileCounter(AGemCInOp, BGemCInOp, CGemCInOp, DGemCInOp, GemCInopCount);
	missileCounter(AGemCOh, BGemCOh, CGemCOh, DGemCOh, GemCOHCount);
	//GEMT COUNTS FOR THE BN
	missileCounter(AGemTOP, BGemTOP, CGemTOP, DGemTOP, GemTOPCount);
	missileCounter(AGemTInOp, BGemTInOp, CGemTInOp, DGemTInOp, GemTInopCount);
	missileCounter(AGemTOH, BGemTOH, CGemTOH, DGemTOH, GemTOHCount);
	//MISSILE COUNTS PER UNIT
	missileCounter(AOpPac3, AInOpPac3, APac3Oh, AGemCOP, AGemCInOp, AGemCOh, AGemTOP, AGemTInOp, AGemTOH, AtotalMissileCount);
	missileCounter(BOpPac3, BInOpPac3, BPac3Oh, BGemCOP, BGemCInOp, BGemCOh, BGemTOP, BGemTInOp, BGemTOH, BtotalMissileCount);
	missileCounter(COpPac3, CInOpPac3, CPac3Oh, CGemCOP, CGemCInOp, CGemCOh, CGemTOP, CGemTInOp, CGemTOH, CtotalMissileCount);
	missileCounter(DOpPac3, DInOpPac3, DPac3Oh, DGemCOP, DGemCInOp, DGemCOh, DGemTOP, DGemTInOp, DGemTOH, DtotalMissileCount);
	//TOTAL COUNT FOR THE BN
	
	missileCounter(Pac3OPcount, Pac3InopCount, Pac3OHCount, GemCOPCount, GemCInopCount, GemCOHCount, GemTOPCount, GemTInopCount, GemTOHCount, BnTotalCount);
	//Resetting the boxes back to orange is a lot easier than writing a special case or method to handle these boxes
	//with out this manual reset on the background the IOvalidator method will set these boxes to white when we call missileCounter to add up the BN totals.
	Pac3OPcount.setBackground(new Color(210, 105, 30));
	Pac3InopCount.setBackground(new Color(210, 105, 30));
	Pac3OHCount.setBackground(new Color(210, 105, 30));
	GemCOPCount.setBackground(new Color(210, 105, 30));
	GemCOPCount.setBackground(new Color(210, 105, 30));
	GemCInopCount.setBackground(new Color(210, 105, 30));
	GemCOHCount.setBackground(new Color(210, 105, 30));
	GemTOPCount.setBackground(new Color(210, 105, 30));
	GemTInopCount.setBackground(new Color(210, 105, 30));
	GemTOHCount.setBackground(new Color(210, 105, 30));
	
	//COUNT UP LAUNCHERS
	missileCounter(AOPLs, BOPLs, COPLs, DOPLs, BnOpLsCount);
	missileCounter(AOPpac2L, BOPpac2L, COPpac2L, DOPpac2L, BnPac2OPCount);
	missileCounter(AInopLs, BInopLs, CInopLs, DInopLs, BnLsInopCount);
	missileCounter(AInopPac2L, BInopPac2L, CInopPac2L, DInopPac2L, BnPac2InopCount);
						
	currentDtg.setText(zTime()); //Update time stamp
}

		
}//End Class




