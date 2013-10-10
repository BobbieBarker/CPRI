/************************************************************************
 ** @author Chad King
** PssGui holds the GUI for the SamStatRep and the methods that define the behavior of the samstat report itself. 
** This GUI represents what the SamStat looks like at the Battery Level and how it will behave.
*************************************************************************/

package pss;


import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import pss.BNPssGUI.serverInfo;
import pss.FileReceiver.ClientHandler;

import java.util.Calendar;
import java.util.Scanner;
import java.util.TimeZone;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.Window.Type;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;





public class PssGui extends JFrame implements Utility, PSSbehaviours {
	
	private static final long serialVersionUID = 1L;
	private static String FUtype;
	private static int gemcCount = 0;
	private static int pac3ohCount = 0;
	private String valHolder;
	private String valHolder2;
	private static int OPpac3 = 0;
	private JTextField txtTest;
	private static int gemTCount = 0;
	private static int pac3Count = 0;
	private int maxOP;
	private static final int MPPAC3 = 8;
	private static final int MPPAC2 = 4;
	private static final JTextField Battery = null; 
	private final JPanel panel = new JPanel();
	private JTextField secretHeaderLeft;
	private JTextField samStatHeader;
	private JTextField secretHeaderRight;
	private JTextField effectiveDtg;
	private JTextField currentDtg;
	private JTextField unitHeader;
	private JTextField typeHeader;
	private JTextField alertStateHeader;
	private JTextField bnId;
	private JTextField curHeader;
	private JTextField dirHeader;
	private JTextField unitId;
	private JComboBox systemType;
	private JComboBox curSelector;
	private JComboBox dirSelector;
	private JTextField stoHeader;
	private JComboBox stoSelector;
	private JTextField acoHeader;
	private JTextField blackspace;
	private JTextPane DefAssetHeader;
	private JTextArea defendedAssets;
	private JTextField locationHeader;
	private JTextField curLocation;
	private JComboBox acoSelector;
	private JTextField etroHeader;
	private JTextField ptlHeader;
	private JTextField curEtro;
	private JTextField curPtl;
	private JTextField stlHeader;
	private JTextField curStl;
	private JTextField missileHeader;
	private JTextField pac_3Header;
	private JTextField pac_3OpHeader;
	private JTextField pac_3InopHeader;
	private JTextField pac_3OhHeader;
	private JComboBox pac_3OpCount;
	private JComboBox pac_3InopCount;
	private JComboBox pac_3OhCount;
	private JComboBox gemCOpCount;
	private JComboBox gemCInopCount;
	private JComboBox gemCOhCount;
	private JComboBox gemtOpCount;
	private JComboBox gemtInopCount;
	private JComboBox gemtOhCount;
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
	private JTextField totalMissileCount;
	private JComboBox opLsCount;
	private JComboBox inopLsCount;
	private JComboBox opPac_2Count;
	private JComboBox inop_Pac2Count;
	private JTextPane faultHeader;
	private JTextArea remarksField;
	private JButton broadCast_3;
	private JButton tocButton;
	private JButton ecsButton;
	private JButton bcpButton;
	final String ECS = "ECS";
	final String BCP = "BCP";
	final String ICC = "ICC";
	final String TOC = "TOC";
	private static int color = 0;
	private int oldGemC;
	private int oldGemT;
	private int oldPac3; 
	private int sto = 000;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JTextField batteryHeader;
	private JComboBox battery;
	private unitData FUdata;
	private fireUnitData status;
	private connected unitAddress;
	
	
	//Constructor, more arguments can be added later as needed. 
	PssGui(String FUtype, int pac3Count, int gemcCount, int gemTCount, connected unitAddys){
		PssGui.FUtype = FUtype;
		PssGui.gemcCount = gemcCount;
		PssGui.pac3Count = pac3Count;
		PssGui.gemTCount = gemTCount;
		this.unitAddress = unitAddys;
		
		//starts receiver code
		//Thread myThread = new Thread(new FileReceiver2(5000));

		//myThread.start();
		
		startFileReceiver();	
		
		//Sets the title for the JFrame and some behavior/attributes for the frame. 
		setTitle("PATRIOT SMART SAMSTAT");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setAlwaysOnTop(true);
		getContentPane().setBackground(Color.GRAY);
		setBounds(new Rectangle(1500, 500, 1700, 500));
		getContentPane().setLayout(null);
		
		
		
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
		samStatHeader.setText("BATTERY SAMSTATREP");
		samStatHeader.setEditable(false);
		samStatHeader.setBounds(299, 0, 1100, 20);
		getContentPane().add(samStatHeader);
		samStatHeader.setColumns(10);
		
		//Provides a header as per the design of the SamStat report. 
		secretHeaderRight = new JTextField();
		secretHeaderRight.setHorizontalAlignment(SwingConstants.CENTER);
		secretHeaderRight.setForeground(Color.RED);
		secretHeaderRight.setText("SECRET WHEN FILLED IN");
		secretHeaderRight.setEditable(false);
		secretHeaderRight.setColumns(10);
		secretHeaderRight.setBounds(1400, 0, 284, 20);
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
		getContentPane().add(currentDtg);
		currentDtg.setColumns(10);
		
		//Provides a header to the component that identifies the unit. 
		unitHeader = new JTextField();
		unitHeader.setHorizontalAlignment(SwingConstants.CENTER);
		unitHeader.setBackground(Color.ORANGE);
		unitHeader.setText("UNIT");
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
		alertStateHeader.setBounds(161, 42, 140, 20);
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
		curHeader.setBounds(161, 63, 68, 52);
		getContentPane().add(curHeader);
		curHeader.setColumns(10);
		
		//This Component provides a header to the dir AS box. 
		dirHeader = new JTextField();
		dirHeader.setEditable(false);
		dirHeader.setBackground(new Color(218, 165, 32));
		dirHeader.setHorizontalAlignment(SwingConstants.CENTER);
		dirHeader.setText("DIR");
		dirHeader.setColumns(10);
		dirHeader.setBounds(227, 63, 72, 52);
		getContentPane().add(dirHeader);
		
		//This component allows the user to store information on current unit identifier. Maybe necessary to pass this in as an arguement to the PssGui since there is no accounting for callsigns. 
		//This component also needs to be updated with a mouse click event that can turn the color of the box to reflect the tooltip text.
		unitId = new JTextField();
		//unitId.setBackground(Color.GREEN);
		unitId.setHorizontalAlignment(SwingConstants.CENTER);
		unitId.setToolTipText("<html>CLICK BOX TO CHANGE COLOR:<br/>GREEN-MC<br/>RED-NMC<br/>WHITE-UNIT IN TRANSISTION</html>");
		unitId.setText("Set Unit Name");
		unitId.setBounds(0, 116, 84, 172);
		getContentPane().add(unitId);
		unitId.setColumns(10);
		unitId.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			//This if/else if/else statement allows the user to control the background of this JTextField by clicking on the box
				if(color==0){
					unitId.setBackground(Color.WHITE);
					color++;
				}
				else if(color==1){
					unitId.setBackground(Color.RED);
					color++;
				}else{
					color=0;
					unitId.setBackground(Color.GREEN);	
				}	
			}
		});//End mouseListener
		
		
		
		//This component allows the user to store information about the type of system the unit is reporting on. Allowing the selections for avenger or stinger maybe moot points.
		systemType = new JComboBox();
		systemType.setModel(new DefaultComboBoxModel(new String[] {"PATRIOT", "AVENGER", "STINGER", "THAAD"}));
		systemType.setToolTipText("<html>ENTER SYSTEM TYPE:" + "<br/>PAT" + "<br/>AVENGER"+ "<br/>STINGER" + "<br/>THAAD</html>");
		systemType.setEditable(false);
		systemType.setBounds(83, 116, 79, 172);
		getContentPane().add(systemType);
		
		//This component allows the user to store information about the alert state they are currently at. 
		curSelector = new JComboBox();
		curSelector.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7"}));
		curSelector.setEditable(false);
		curSelector.setToolTipText("CURRENT ALERT STATE");
		curSelector.setBounds(161, 116, 68, 172);
		getContentPane().add(curSelector);
		
		//This component allows the user to store information on which alert state they are being directed to. 
		dirSelector = new JComboBox();
		dirSelector.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7"}));
		dirSelector.setEditable(false);
		dirSelector.setToolTipText("DIRECTED ALERT STATE");
		dirSelector.setBounds(227, 116, 74, 172);
		getContentPane().add(dirSelector);
		
		//This component provides a header to the user asking them to use the drop box and indicate which sto they are operating under.
		stoHeader = new JTextField();
		stoHeader.setEditable(false);
		stoHeader.setBackground(Color.YELLOW);
		stoHeader.setHorizontalAlignment(SwingConstants.CENTER);
		stoHeader.setText("CURRENT STO");
		stoHeader.setBounds(0, 289, 161, 102);
		getContentPane().add(stoHeader);
		stoHeader.setColumns(10);
		
		//This component allows the user select and store information about the current surface to air missile tactical order (STO) that they are operating under. 
		stoSelector = new JComboBox();
		stoSelector.setModel(new DefaultComboBoxModel(new String[] {"000"}));
		stoSelector.setBounds(161, 289, 68, 102);
		getContentPane().add(stoSelector);
		stoSelector.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stoIncrementor(stoSelector);
				
			}
		});
		
		//This component acts as a header to the acoSelector drop box prompting the user to enter in the Aco that they are operating under.
		acoHeader = new JTextField();
		acoHeader.setEditable(false);
		acoHeader.setHorizontalAlignment(SwingConstants.CENTER);
		acoHeader.setBackground(Color.YELLOW);
		acoHeader.setText("ACO/SPINS");
		acoHeader.setBounds(227, 289, 74, 102);
		getContentPane().add(acoHeader);
		acoHeader.setColumns(10);
		
		//This component exists for esthetic purposes. 
		blackspace = new JTextField();
		blackspace.setEditable(false);
		blackspace.setBackground(Color.BLACK);
		blackspace.setBounds(299, 21, 327, 41);
		getContentPane().add(blackspace);
		blackspace.setColumns(10);
		
		//This component provides a header for the defendedAssets jtextfield prompting the user to enter in their defended assets. 
		DefAssetHeader = new JTextPane();
		StyledDocument doc = DefAssetHeader.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		DefAssetHeader.setAlignmentX(StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		DefAssetHeader.setEditable(false);
		DefAssetHeader.setText("DEFENDED ASSET");
		DefAssetHeader.setBackground(Color.YELLOW);
		DefAssetHeader.setBounds(299, 62, 86, 53);
		getContentPane().add(DefAssetHeader);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(299, 116, 86, 172);
		getContentPane().add(scrollPane_1);
		
		//This component stores information about the units defended assets. 
		defendedAssets = new JTextArea();
		scrollPane_1.setViewportView(defendedAssets);
		defendedAssets.setLineWrap(true);
		defendedAssets.setWrapStyleWord(true);
		defendedAssets.setToolTipText("ENTER YOUR DEFENDED ASSETS");
		defendedAssets.setColumns(10);
		
		//This component provides a header prompting the user to enter their units location. 
		locationHeader = new JTextField();
		locationHeader.setText("LOCATION");
		locationHeader.setHorizontalAlignment(SwingConstants.CENTER);
		locationHeader.setEditable(false);
		locationHeader.setColumns(10);
		locationHeader.setBackground(Color.YELLOW);
		locationHeader.setBounds(386, 62, 86, 52);
		getContentPane().add(locationHeader);
		
		//This component stores the units current location in latitude and longitude. 
		curLocation = new JTextField();
		curLocation.setToolTipText("ENTER LAT/LONG & MGRS FOR CURRENT LOCATION");
		curLocation.setColumns(10);
		curLocation.setBounds(386, 116, 86, 172);
		getContentPane().add(curLocation);
		
		//This ComboBox allows the user to report which ACO the fire unit is operating under. 
		acoSelector = new JComboBox();
		acoSelector.setToolTipText("Press enter to add an item to the list");
		acoSelector.setModel(new DefaultComboBoxModel(new String[] {"SACO", ""}));
		acoSelector.setEditable(true);
		acoSelector.setBounds(299, 289, 86, 102);
		getContentPane().add(acoSelector);
		acoSelector.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//This code lets the user add to the dropbox list. 
				if ( e.getActionCommand().equals("comboBoxEdited"))
					acoSelector.addItem(acoSelector.getSelectedItem());
				
			}
		});
		
		//This component provides a header to the jtextfield that stores the ETRO information on the unit. 
		etroHeader = new JTextField();
		etroHeader.setText("ETRO");
		etroHeader.setBackground(Color.YELLOW);
		etroHeader.setBounds(474, 62, 50, 52);
		getContentPane().add(etroHeader);
		
		//This jtextfield provides the user a header for the jtextfield that stores information on the PTL.
		ptlHeader = new JTextField();
		ptlHeader.setEditable(false);
		ptlHeader.setBackground(Color.YELLOW);
		ptlHeader.setHorizontalAlignment(SwingConstants.CENTER);
		ptlHeader.setText("PTL");
		ptlHeader.setColumns(10);
		ptlHeader.setBounds(525, 63, 50, 52);
		getContentPane().add(ptlHeader);
		
		//This jtextfield stores information about the current estimated time to return to operation or (ETRO).
		curEtro = new JTextField();
		curEtro.setToolTipText("ENTER DTG OF CURRENT ETRO");
		curEtro.setBounds(474, 116, 50, 172);
		getContentPane().add(curEtro);
		curEtro.setColumns(10);
		
		//This component stores information about the primary target line or (PTL).
		curPtl = new JTextField();
		curPtl.setToolTipText("PRIMARY TARGET LINE");
		curPtl.setColumns(10);
		curPtl.setBounds(525, 116, 50, 172);
		getContentPane().add(curPtl);
		
		//this jtextfield provides a header letting the user know that the jtextfield below is for storing the STL. 
		stlHeader = new JTextField();
		stlHeader.setEditable(false);
		stlHeader.setText("STL");
		stlHeader.setHorizontalAlignment(SwingConstants.CENTER);
		stlHeader.setColumns(10);
		stlHeader.setBackground(Color.YELLOW);
		stlHeader.setBounds(576, 63, 50, 52);
		getContentPane().add(stlHeader);
		
		//This JTextField stores information about the secondary target line or (STL).
		curStl = new JTextField();
		curStl.setToolTipText("SECONDARY TARGET LINE");
		curStl.setColumns(10);
		curStl.setBounds(576, 116, 50, 172);
		getContentPane().add(curStl);
		
		//This component is just a header for the missile section of the samstat
		missileHeader = new JTextField();
		missileHeader.setEditable(false);
		missileHeader.setBackground(new Color(210, 105, 30));
		missileHeader.setText("MISSILES");
		missileHeader.setHorizontalAlignment(SwingConstants.CENTER);
		missileHeader.setBounds(625, 21, 1059, 20);
		getContentPane().add(missileHeader);
		missileHeader.setColumns(10);
		
		//These "header" jtextfields prove the labels to our drop boxes that track the current number of Pac-3 Missiles.
		pac_3Header = new JTextField();
		pac_3Header.setHorizontalAlignment(SwingConstants.CENTER);
		pac_3Header.setText("PAC3");
		pac_3Header.setBackground(new Color(210, 105, 30));
		pac_3Header.setBounds(625, 42, 155, 20);
		getContentPane().add(pac_3Header);
		
		pac_3OpHeader = new JTextField();
		pac_3OpHeader.setHorizontalAlignment(SwingConstants.CENTER);
		pac_3OpHeader.setText("OP");
		pac_3OpHeader.setBackground(new Color(210, 105, 30));
		pac_3OpHeader.setBounds(625, 63, 50, 52);
		getContentPane().add(pac_3OpHeader);
		
		pac_3InopHeader = new JTextField();
		pac_3InopHeader.setText("INOP");
		pac_3InopHeader.setHorizontalAlignment(SwingConstants.CENTER);
		pac_3InopHeader.setBounds(677, 63, 50, 52);
		pac_3InopHeader.setBackground(new Color(210, 105, 30));
		getContentPane().add(pac_3InopHeader);
		
		pac_3OhHeader = new JTextField();
		pac_3OhHeader.setText("OH");
		pac_3OhHeader.setHorizontalAlignment(SwingConstants.CENTER);
		pac_3OhHeader.setEditable(false);
		pac_3OhHeader.setColumns(10);
		pac_3OhHeader.setBackground(new Color(210, 105, 30));
		pac_3OhHeader.setBounds(730, 63, 50, 52);
		getContentPane().add(pac_3OhHeader);
		
		//pac_3OpCount, pac_3InopCount, and pac_3OhCount drop boxes track the current Pac-3 Missile Counts. 
		//Pac3 OP component
		pac_3OpCount = new JComboBox();
		pac_3OpCount.addItem(0);
		pac_3OpCount.setSelectedItem(0);
		pac_3OpCount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					missileBalancer(pac_3OpCount, pac_3OhCount, oldPac3); 
					missileCounter();
				} catch (Exception e1) {
					//Nothing to Catch just handling known NPE issue
				}
			}
		});
		pac_3OpCount.setToolTipText("ENTER # OF OPERATIONAL PAC3");
		pac_3OpCount.setBounds(625, 116, 50, 172);
		getContentPane().add(pac_3OpCount);
		//Pac 3 INOP component
		pac_3InopCount = new JComboBox();
		//pac_3InopCount.addItem(0);
		pac_3InopCount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					missileCounter();
				} catch (Exception e1) {
					//nothing to catch just handling initial NPE
				}
			}
		});
		pac_3InopCount.setToolTipText("ENTER # OF INOP PAC3");
		pac_3InopCount.setBounds(677, 116, 50, 172);
		getContentPane().add(pac_3InopCount);
		//Pac 3 OH component
		pac_3OhCount = new JComboBox();
		pac_3OhCount.setToolTipText("ENTER # OF OH PAC3");
		pac_3OhCount.setBounds(730, 116, 50, 172);
		getContentPane().add(pac_3OhCount);
		pac_3OhCount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					missileCounter();
				} catch (Exception e1) {
						//nothing to catch just handling initial NPE
				}
			}
		});
		
		//These Gem-C "header" jtextfields provide the labels to the drop boxes that track the current Gem-C Missile Counts.
		gemCHeader = new JTextField();
		gemCHeader.setText("GEMC");
		gemCHeader.setHorizontalAlignment(SwingConstants.CENTER);
		gemCHeader.setBackground(new Color(210, 105, 30));
		gemCHeader.setBounds(780, 42, 155, 20);
		getContentPane().add(gemCHeader);
		
		GemcOpHeader = new JTextField();
		GemcOpHeader.setText("OP");
		GemcOpHeader.setHorizontalAlignment(SwingConstants.CENTER);
		GemcOpHeader.setEditable(false);
		GemcOpHeader.setColumns(10);
		GemcOpHeader.setBackground(new Color(210, 105, 30));
		GemcOpHeader.setBounds(780, 63, 50, 52);
		getContentPane().add(GemcOpHeader);
		
		GemcInopHeader = new JTextField();
		GemcInopHeader.setText("INOP");
		GemcInopHeader.setHorizontalAlignment(SwingConstants.CENTER);
		GemcInopHeader.setEditable(false);
		GemcInopHeader.setColumns(10);
		GemcInopHeader.setBackground(new Color(210, 105, 30));
		GemcInopHeader.setBounds(832, 63, 50, 52);
		getContentPane().add(GemcInopHeader);
		
		GemCOhHeader = new JTextField();
		GemCOhHeader.setText("OH");
		GemCOhHeader.setHorizontalAlignment(SwingConstants.CENTER);
		GemCOhHeader.setEditable(false);
		GemCOhHeader.setColumns(10);
		GemCOhHeader.setBackground(new Color(210, 105, 30));
		GemCOhHeader.setBounds(885, 63, 50, 52);
		getContentPane().add(GemCOhHeader);
		
		//gemCOpCount, gemCInopCount, gemCOhCount are the drop boxes that track the current Gem-C missile counts.
		//GEMc OP component
		gemCOpCount = new JComboBox();
		gemCOpCount.addItem(0);
		gemCOpCount.setSelectedItem(0);
		gemCOpCount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					missileBalancer(gemCOpCount, gemCOhCount, oldGemC);
					missileCounter();
				} catch (Exception e1) {
					//Nothing to Catch just handling known NPE issue
				}
			}
		});
		gemCOpCount.setToolTipText("ENTER # OF OP GEM C");
		gemCOpCount.setBounds(780, 116, 50, 172);
		getContentPane().add(gemCOpCount);
		
		//GEMC INOP component
		gemCInopCount = new JComboBox();
		//gemCInopCount.addItem(0);
		gemCInopCount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					missileCounter();
				} catch (Exception e1) {

				}
			}
		});
		gemCInopCount.setToolTipText("ENTER # OF INOP GEM C");
		gemCInopCount.setBounds(832, 116, 50, 172);
		getContentPane().add(gemCInopCount);
		
		//GEMC OH component
		gemCOhCount = new JComboBox();
		//gemCOhCount.addItem(0);
		gemCOhCount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					missileCounter();
				} catch (Exception e1) {
						//nothing to handle just catching the initial NPE from the misileCounter fields being null
				}
			}
		});
		gemCOhCount.setToolTipText("ENTER # OF OH GEM C");
		gemCOhCount.setBounds(885, 116, 50, 172);
		getContentPane().add(gemCOhCount);
		
		//These "header" components provide the labels for the drop boxes that handle the Gem-T missile counts.
		gemTHeader = new JTextField();
		gemTHeader.setText("GEM T");
		gemTHeader.setHorizontalAlignment(SwingConstants.CENTER);
		gemTHeader.setEditable(false);
		gemTHeader.setColumns(10);
		gemTHeader.setBackground(new Color(210, 105, 30));
		gemTHeader.setBounds(935, 42, 155, 20);
		getContentPane().add(gemTHeader);
		
		gemtOpHeader = new JTextField();
		gemtOpHeader.setText("OP");
		gemtOpHeader.setHorizontalAlignment(SwingConstants.CENTER);
		gemtOpHeader.setEditable(false);
		gemtOpHeader.setColumns(10);
		gemtOpHeader.setBackground(new Color(210, 105, 30));
		gemtOpHeader.setBounds(935, 63, 50, 52);
		getContentPane().add(gemtOpHeader);
		
		gemtInopHeader = new JTextField();
		gemtInopHeader.setText("INOP");
		gemtInopHeader.setHorizontalAlignment(SwingConstants.CENTER);
		gemtInopHeader.setEditable(false);
		gemtInopHeader.setColumns(10);
		gemtInopHeader.setBackground(new Color(210, 105, 30));
		gemtInopHeader.setBounds(987, 63, 50, 52);
		getContentPane().add(gemtInopHeader);
		
		gemtOhHeader = new JTextField();
		gemtOhHeader.setText("OH");
		gemtOhHeader.setHorizontalAlignment(SwingConstants.CENTER);
		gemtOhHeader.setEditable(false);
		gemtOhHeader.setColumns(10);
		gemtOhHeader.setBackground(new Color(210, 105, 30));
		gemtOhHeader.setBounds(1040, 63, 50, 52);
		getContentPane().add(gemtOhHeader);
		
		//gemtOpCount, gemtInopCount, and gemtOhCount are the dropboxes for the Gem T missile counts. 
		//GEMT OP component
		gemtOpCount = new JComboBox();
		gemtOpCount.addItem(0);
		gemtOpCount.setSelectedIndex(0);
		gemtOpCount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					missileBalancer(gemtOpCount, gemtOhCount, oldGemT);
					missileCounter();
				} catch (Exception e1) {
					//Nothing to Catch just handling known NPE issue
				}
			}
		});
		gemtOpCount.setToolTipText("ENTER # OF OP GEM C");
		gemtOpCount.setBounds(935, 116, 50, 172);
		getContentPane().add(gemtOpCount);
		
		//GEMT INOP component
		gemtInopCount = new JComboBox();
		//gemtInopCount.addItem(0);
		gemtInopCount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					missileCounter();
				} catch (Exception e1) {
					//Nothing to Catch just handling known NPE issue
				}
			}
		});
		gemtInopCount.setToolTipText("ENTER # OF INOP GEM C");
		gemtInopCount.setBounds(987, 116, 50, 172);
		getContentPane().add(gemtInopCount);
		
		//GEMT OH component
		gemtOhCount = new JComboBox();
		//gemtOhCount.addItem(0);
		gemtOhCount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					missileCounter();
				} catch (Exception e1) {
						//nothing to handle just catching the initial NPE from the fields being null at the start
				}
			}
		});
		gemtOhCount.setToolTipText("ENTER # OF OH GEM C");
		gemtOhCount.setBounds(1040, 116, 50, 172);
		getContentPane().add(gemtOhCount);
		
		missileCountHeader = new JTextField();
		missileCountHeader.setText("TOTAL MISSILES");
		missileCountHeader.setHorizontalAlignment(SwingConstants.CENTER);
		missileCountHeader.setEditable(false);
		missileCountHeader.setColumns(10);
		missileCountHeader.setBackground(new Color(210, 105, 30));
		missileCountHeader.setBounds(1090, 42, 155, 73);
		getContentPane().add(missileCountHeader);
		
		launchersHeader = new JTextField();
		launchersHeader.setText("LAUNCHERS");
		launchersHeader.setHorizontalAlignment(SwingConstants.CENTER);
		launchersHeader.setEditable(false);
		launchersHeader.setColumns(10);
		launchersHeader.setBackground(new Color(205, 133, 63));
		launchersHeader.setBounds(1244, 42, 155, 20);
		getContentPane().add(launchersHeader);
		
		remarksHeader = new JTextField();
		remarksHeader.setText("REMARKS/GENERAL FAULTS");
		remarksHeader.setHorizontalAlignment(SwingConstants.CENTER);
		remarksHeader.setEditable(false);
		remarksHeader.setColumns(10);
		remarksHeader.setBackground(Color.YELLOW);
		remarksHeader.setBounds(1400, 42, 284, 20);
		getContentPane().add(remarksHeader);
		
		launchersInopHeader = new JTextField();
		launchersInopHeader.setText("INOP");
		launchersInopHeader.setHorizontalAlignment(SwingConstants.CENTER);
		launchersInopHeader.setEditable(false);
		launchersInopHeader.setColumns(10);
		launchersInopHeader.setBackground(new Color(205, 133, 63));
		launchersInopHeader.setBounds(1320, 63, 77, 52);
		getContentPane().add(launchersInopHeader);
		
		launchersOPheader = new JTextField();
		launchersOPheader.setText("OP");
		launchersOPheader.setHorizontalAlignment(SwingConstants.CENTER);
		launchersOPheader.setEditable(false);
		launchersOPheader.setColumns(10);
		launchersOPheader.setBackground(new Color(205, 133, 63));
		launchersOPheader.setBounds(1244, 63, 77, 52);
		getContentPane().add(launchersOPheader);
		
		//totalMissileCount represents the total amount of missiles on the site. It is only comprised of this sincle JTextField.
		totalMissileCount = new JTextField();
		totalMissileCount.setEditable(false);
		totalMissileCount.setToolTipText("Your current Total Missile Count");
		totalMissileCount.setHorizontalAlignment(SwingConstants.CENTER);
		totalMissileCount.setForeground(Color.WHITE);
		totalMissileCount.setBackground(new Color(0, 0, 0));
		totalMissileCount.setBounds(1090, 116, 155, 172);
		getContentPane().add(totalMissileCount);
		totalMissileCount.setColumns(10);
		
		//The LsCount and Pac2Count family of components covers the Launchers section of the samstat.
		opLsCount = new JComboBox();
		opLsCount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { //grab current selection from drop box
				valHolder2 = (String)opLsCount.getSelectedItem();
				setMaxOP(valHolder2, MPPAC3);
				fillDropBox(maxOP, pac_3OpCount);
				oldPac3 = getMaxPac3OP();
				
			}
		});
		opLsCount.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}));
		opLsCount.setToolTipText("NUMBER OF OP L'S LAUNCHERS");
		opLsCount.setEditable(false);
		opLsCount.setBackground(new Color(205, 133, 63));
		opLsCount.setBounds(1244, 116, 77, 86);
		getContentPane().add(opLsCount);
		
		inopLsCount = new JComboBox();
		inopLsCount.setToolTipText("NUMBER OF INOP L'S");
		inopLsCount.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}));
		inopLsCount.setEditable(false);
		inopLsCount.setBackground(new Color(205, 133, 63));
		inopLsCount.setBounds(1321, 116, 77, 86);
		getContentPane().add(inopLsCount);
		
		opPac_2Count = new JComboBox();
		opPac_2Count.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				valHolder2 = (String)opPac_2Count.getSelectedItem();
				setMaxOP(valHolder2, MPPAC2);
				fillDropBox(maxOP, gemCOpCount);
				fillDropBox(maxOP, gemtOpCount);
				oldGemC = getMaxPac3OP();
				oldGemT = getMaxPac3OP();
				missileCounter();
			}
		});
		opPac_2Count.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}));
		opPac_2Count.setToolTipText("NUMBER OF OP PAC2 ");
		opPac_2Count.setEditable(false);
		opPac_2Count.setBackground(new Color(205, 133, 63));
		opPac_2Count.setBounds(1244, 202, 77, 86);
		getContentPane().add(opPac_2Count);
		
		inop_Pac2Count = new JComboBox();
		inop_Pac2Count.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}));
		inop_Pac2Count.setToolTipText("NUMBER OF INOP PAC2");
		inop_Pac2Count.setEditable(false);
		inop_Pac2Count.setBackground(new Color(205, 133, 63));
		inop_Pac2Count.setBounds(1321, 202, 77, 86);
		getContentPane().add(inop_Pac2Count);
		
		//This section handled the fault reporting on the samstat. 
		faultHeader = new JTextPane();
		faultHeader.setEditable(false);
		faultHeader.setText("A-AMG B-ECS C-CRG D-BCP E-EPP/EPU F-FORKLIFT G-GMT J-LSTS K-IFF L-LS I-ICC M-MISSILES R-RS");
		faultHeader.setBounds(1400, 63, 284, 52);
		getContentPane().add(faultHeader);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(1400, 118, 284, 343);
		getContentPane().add(scrollPane);
		
		remarksField = new JTextArea();
		scrollPane.setViewportView(remarksField);
		remarksField.setWrapStyleWord(true);
		remarksField.setLineWrap(true);
		remarksField.setBackground(Color.LIGHT_GRAY);
		remarksField.setToolTipText("Enter All Current System Faults and Deadlines Here");
		remarksField.setColumns(10);
		/*
		 * This section is for the objects that should be used with the json
		 */
		
		
			FUdata = new unitData(null, null, null, null, null, null, null);
			status = new fireUnitData(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 
					null, null, null, null, null, null, null, null);
		

		
		
		
		
		/*
		 * These buttons will be for the networking. Each one will need to be assigned some behavior and a target for broadcasting the reports.
		 */
		JButton pssUpdate = new JButton("UPDATE");
		pssUpdate.setToolTipText("This updates the PSS locally. ");
		pssUpdate.setBounds(987, 412, 89, 23);
		getContentPane().add(pssUpdate);
		pssUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				missileCounter();
				currentDtg.setText(zTime());
			}
		});
		//BroadCast_3 is going to be my printer button 
		broadCast_3 = new JButton("");
		broadCast_3.setBounds(832, 412, 89, 23);
		getContentPane().add(broadCast_3);
		broadCast_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//WRITE TRANSMIT CODE HERE
			}
		});
		
		
		
		tocButton = new JButton("TOC");
		tocButton.setToolTipText("Send Your Report to the TOC");
		tocButton.setBounds(677, 412, 89, 23);
		getContentPane().add(tocButton);
		tocButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				missileCounter();
				currentDtg.setText(zTime());
				System.out.println(tocButton.getName());
				//WRITE TRANSMIT CODE HERE
				sendFile(tocButton);
			}
		});
		
		ecsButton = new JButton("ECS");
		ecsButton.setToolTipText("Send Your Report to the ECS");
		ecsButton.setBounds(525, 412, 89, 23);
		getContentPane().add(ecsButton);
		ecsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				missileCounter();
				currentDtg.setText(zTime());
				//WRITE TRANSMIT CODE HERE
				sendFile(ecsButton);
			}
		});
		
		bcpButton = new JButton("BCP");
		bcpButton.setToolTipText("Send Your Report to the BCP ");
		bcpButton.setBounds(525, 412, 89, 23);
		getContentPane().add(bcpButton);
		bcpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				missileCounter();
				currentDtg.setText(zTime());
				//WRITE TRANSMIT CODE HERE
				sendFile(bcpButton);
			}
		});

		
		try {
			//OH Counts
			fillDropBox(gemcCount, gemCOhCount);
			fillDropBox(gemTCount, gemtOhCount);
			fillDropBox(pac3Count, pac_3OhCount);
			//INOP Counts, which are set equal to OH counts since you can never have more INOP than OH missiles.
			fillDropBox(pac3Count, pac_3InopCount);
			fillDropBox(gemcCount, gemCInopCount);
			fillDropBox(gemTCount, gemtInopCount);
		} catch (Exception e1) {
			//Nothing to catch just handling initial NPEs
		}
		//Set the Jboxes so that they start with the correct/current OH counts. 
		pac_3OhCount.setSelectedItem(pac3Count);
		gemtOhCount.setSelectedItem(gemTCount);
		gemCOhCount.setSelectedItem(gemcCount);
		
		batteryHeader = new JTextField();
		batteryHeader.setToolTipText("Identify your Battery");
		batteryHeader.setText("Battery Name");
		batteryHeader.setHorizontalAlignment(SwingConstants.CENTER);
		batteryHeader.setEditable(false);
		batteryHeader.setColumns(10);
		batteryHeader.setBackground(Color.YELLOW);
		batteryHeader.setBounds(386, 289, 140, 50);
		getContentPane().add(batteryHeader);
		
		battery = new JComboBox();
		battery.setModel(new DefaultComboBoxModel(new String[] {"Alpha", "Bravo", "Charlie", "Delta", "ICC"}));
		battery.setToolTipText("Choose a Battery from the List");
		battery.setEditable(false);
		battery.setBackground(Color.YELLOW);
		battery.setBounds(386, 341, 140, 50);
		getContentPane().add(battery);
		battery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FUdata.setUnitName(battery.getSelectedItem().toString());
				getContentPane().remove(battery);
				getContentPane().remove(batteryHeader);				
			}
		});
		
		broadCastSetter(); //Appropriately set the Labels to the three buttons on the bottom of the GUI. 
		
	}//End Constructor
	
	/**
	** setMaxOP sets the maximum amount of operational missiles a Fire Unit could have based on the type of launcher they are using.
	** @param String MaxOp: represents the users selection for how many Operational Launchers from the drop down box. int mpl: represents the missiles per launcher for that particular type of launcher
	** @return: none
	** @throws: none
	**/
	public void setMaxOP(String maxOP, int mpl){
		
		this.valHolder = maxOP;
		this.maxOP = Integer.parseInt(this.valHolder);
		this.maxOP *= mpl;
	}//End setMaxPac3OP
	
	/**
	** Gets the current maxOP.
	** @param none
	** @return maxOP
	** @throws none
	**/
	public int getMaxPac3OP() {
		return maxOP;
	}//end getMaxPac3OP
	
	
	
	@Override
	public void fillDropBox(int potentialMissiles, JComboBox combobox){
		if(combobox.getSelectedItem() != null){//Test keeps the removeAllItems from being called against null combo boxes which I believe was causing a null point error.
		combobox.removeAllItems();//This cleans the model for the drop box. if it isn't present each subsequent call to this method will just be added upon the previous method calls inside the drop box.
		}
		int i = 0;
		for(i = 0; i < potentialMissiles; i++){
			combobox.addItem(i);
		}//end For
		combobox.addItem(i++);
	}//end fillDropBox
	
	@Override
	public void missileCounter(){ //I am thinking of rewriting this methods to accept string parameters. 
								  //This will make the method more versatile for the battalion level samstat 
								  //that will be used by the TOC, but in some cases will require the method to be passed up to six arguments. 
								  //this seems clunky.
		//Create some Local Variables to hold our missile counts inside the method. 
		int missileCount;
		
		int pac3OP = 0;
		int pac3INOP = 0;
		int pac3OH = 0;
		
		int gemCOP = 0;
		int gemCInop = 0;
		int gemCOH = 0;
		
		int gemTOP = 0;
		int gemTInop = 0;
		int GemTOH = 0;
		
		//Pull the current user selected missile counts for pac3
		//If tests are to check to make sure that the current combobox value isn't null. 
		//If it is null then our method sets it to zero and keeps truckin
		pac3OP = (int) pac_3OpCount.getSelectedItem();
		pac3INOP = (int) pac_3InopCount.getSelectedItem();
		pac3OH = (int) pac_3OhCount.getSelectedItem();
		
		gemCOP = (int) gemCOpCount.getSelectedItem();
		gemCInop = (int) gemCInopCount.getSelectedItem();
		gemCOH = (int) gemCOhCount.getSelectedItem();
		
		//Pull the current user selected missile counts for gem-T
		gemTOP = (int) gemtOpCount.getSelectedItem();
		gemTInop = (int) gemtInopCount.getSelectedItem();
		GemTOH = (int) gemtOhCount.getSelectedItem();
		
		//Add all of our missile counts together and set them to a "master" variable that we can pass back 
		missileCount = pac3OP + pac3INOP + pac3OH + gemCOP + gemCInop + gemCOH + gemTOP + gemTInop + GemTOH;
		totalMissileCount.setText(String.valueOf(missileCount));
	}//End MissileCounter
	
	
	public void broadCastSetter(){
		switch ((String)FUtype){//we run the switch statement against the FUtype that we passed to the constructor from PSSmain
		//this lets us make sure all of our buttons on the program reflect whose actually using the program.
		
		case ECS: FUtype.equals("ECS");
		getContentPane().remove(ecsButton);	
			break;
		case BCP: 
			getContentPane().remove(bcpButton);
			break;

		}//End Switch		
	}//End broadCastSetter



	@Override
	public void stoIncrementor(JComboBox combobox) {
		sto++;
		String padded = String.format("%03d", sto);
		combobox.addItem(padded);
		//combobox.setSelectedItem(padded);
	}

	@Override
	public void findIpAddy() {
		// TODO Auto-generated method stub	
	}

	@Override
	public String zTime() {
		SimpleDateFormat formatter = new SimpleDateFormat("ddHHmm'z'MMMyyyy");//This SDF reflects the Army's standard for Date Time Groups
		formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
		Calendar cal = Calendar.getInstance();
		String timestamp = formatter.format(cal.getTime());
		return (timestamp);
	}//End zTime
	
	
	/**
	** missileBalancer compares the users input before and after selection and adjusts the contents of the OH missile count box as necessary.
	** @param JComboBox combobox is the combobox concerning the OP counts, JComboBox combobox1 is the combobox concerning the OH counts, prevOH is the masterOH count.
	** @return
	** @throws
	**/
	public void missileBalancer(JComboBox combobox, JComboBox combobox1, int prevOP){
		int difference = 0;
		int newOH = 0;
		int newOP = (int) combobox.getSelectedItem(); //Current OP count
		int oldOH = (int) combobox1.getSelectedItem();//Current OH count --Adjusting this by the appropriate amount is the goal of this method
		int oldOP = prevOP;
		//oldOP is the OP that we are testing against it needs to be set by the program into a var that we can use in our test.
		if(newOP < oldOP){
			if(combobox.equals(pac_3OpCount)){
			oldPac3 = newOP;//We need to keep track of our count outside of the method.
			}
			else if(combobox.equals(gemCOpCount)){
				oldGemC = newOP;
			}
			else if(combobox.equals(gemtOpCount)){
				oldGemT = newOP;
			}
		}else if(newOP > oldOP){
		difference = newOP - oldOP; 
		newOH = oldOH - difference;
		combobox1.setSelectedItem(newOH);
		if(newOH < 0){//You cannot set selected item to a jcombobox with a negative number so in all cases where newOH is less than zero we simply set the selected item to 0.
			combobox1.setSelectedItem(0);
		}
		if(combobox.equals(pac_3OpCount)){
			oldPac3 = newOP;//We need to keep track of our count outside of the method.
			}
			else if(combobox.equals(gemCOpCount)){
				oldGemC = newOP;
			}
			else if(combobox.equals(gemtOpCount)){
				oldGemT = newOP;
			}	
		}		
	}//End Missile Balancer

	@Override
	public void missileCounter(JTextField field1, JTextField field2, JTextField field3, JTextField field4, JTextField target) {
		// TODO Auto-generated method stub
	}
	

	
	
	
	/**
	 * Method that sends the file to an ip address
	 * @param JButton button to get button text
	 */
	public void sendFile(JButton button)
	{	
		copyDataToObject();
			
		writeStringToFile(convertObjectToJSON(status));
	
		Thread myThread = new Thread(new FileTransfer("samstat.json", ipGetter(button, unitAddress), 5000));

		myThread.start();
	}
		
	
	/**
	 * Method that processes received samstat file and loads it into GUI
	 * @param JButton button to get button text
	 */
	public void receiveFile(String fileName)
	{	
		File file = new File(fileName);
		
		if(file.exists())
		{		
			convertJSONToObject(file);
			
			copyObjectToGUI();
		}
		else
		{
			System.out.println("Received File Does Not Exist");
		}
		
	}
	

	

	/**
	** Collects information from local components and copies them to the fireUnitData status object
	** @param none
	** @return none
	** @throws none
	**/
	public void copyDataToObject()
	{
		status.setDtg(currentDtg.getText());
		status.setStatusBackGround(colorWriter(unitId));
		
		
		status.setCurAs(curSelector.getSelectedItem().toString());
		status.setDirAs(dirSelector.getSelectedItem().toString());
		status.setEtro(curEtro.getText().toString());
		status.setRemarks(remarksField.getText());
		status.setSto(stoSelector.getSelectedItem().toString());
		status.setAco((String) acoSelector.getSelectedItem());
		
		status.setPac3Op(pac_3OpCount.getSelectedItem().toString());
		status.setPac3Inop((String) pac_3InopCount.getSelectedItem().toString());
		status.setPac3Oh(pac_3OhCount.getSelectedItem().toString());
		
		status.setGemCOp(gemCOpCount.getSelectedItem().toString());
		status.setGemCInop(gemCInopCount .getSelectedItem().toString());
		status.setGemCOh(gemCOhCount.getSelectedItem().toString());
		
		status.setGemTOP(gemtOpCount.getSelectedItem().toString());
		status.setGemTInop(gemtInopCount.getSelectedItem().toString());
		status.setGemTOh(gemtOhCount.getSelectedItem().toString());
		
		status.setOpPac3L(opLsCount.getSelectedItem().toString());
		status.setInopPac3L(inopLsCount.getSelectedItem().toString());
		
		status.setOpPac2L(opPac_2Count.getSelectedItem().toString());
		status.setInopPac2(inop_Pac2Count .getSelectedItem().toString());
		
		FUdata.setUnitDesignator(battery.getSelectedItem().toString());
		FUdata.setUnitType( systemType.getSelectedItem().toString());
		FUdata.setUnitName(unitId.getText());
		FUdata.setDefAsset(defendedAssets.getText());
		FUdata.setLocation(curLocation.getText());
		FUdata.setPtl(curPtl.getText());
		FUdata.setStl(curStl.getText());
		status.setUnitData(FUdata);		
	}

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
	}//end colorReader

	/**
	** Method accepts a JTextField as an arguement then returns its background color as a String.
	** @param JTextField
	** @return String result: result will be the current background color of the JTextField
	** @throws
	**/
	public String colorWriter(JTextField field1){
		Color curCulor = field1.getBackground();
		String result = "";
		
		if(curCulor.equals(Color.RED)){
			result = "RED";
		}
		else if(curCulor.equals(Color.WHITE)){
		result = "WHITE";
		}
		else if(curCulor.equals(Color.GREEN)){
			result = "GREEN";
		}
		
		return result;
	}//End colorWriter
	
	/**
	 * Method that copies the contents of an object to GUI
	 */
	
	public synchronized void copyObjectToGUI()
	{
		currentDtg.setText(status.getDtg());
		unitId.setBackground(colorReader(status.getStatusBackGround()));
		curSelector.setSelectedItem(status.getCurAs());
		dirSelector.setSelectedItem(status.getDirAs());
		curEtro.setText(status.getEtro());
		remarksField.setText(status.getRemarks());
		stoSelector.setSelectedItem(status.getSto()); 
		acoSelector.setSelectedItem(status.getAco());
		
		opLsCount.setSelectedItem(status.getOpPac3L());
		inopLsCount.setSelectedItem(status.getInopPac3L());

		opPac_2Count.setSelectedItem(status.getOpPac2L());
		inop_Pac2Count.setSelectedItem(status.getInopPac2());
		
		int opPac3 = Integer.parseInt((status.getPac3Op()));
		pac_3OpCount.addItem(opPac3);
		pac_3OpCount.setSelectedItem(opPac3);  
		
		int inopPac3 = Integer.parseInt(status.getPac3Inop());
		pac_3InopCount.addItem(inopPac3);
		pac_3InopCount.setSelectedItem(inopPac3);
		
		int ohPac3 = Integer.parseInt(status.getPac3Oh());
		pac_3OhCount.addItem(ohPac3);
		pac_3OhCount.setSelectedItem(ohPac3);
		
		int opGemC = Integer.parseInt(status.getGemCOp());
		gemCOpCount.addItem(opGemC); 
		gemCOpCount.setSelectedItem(opGemC); 
		
		int inopGemC = Integer.parseInt(status.getGemCInop());
		gemCInopCount.addItem(inopGemC);
		gemCInopCount.setSelectedItem(inopGemC);
		
		int ohGemC = Integer.parseInt(status.getGemCOh());
		gemCOhCount.addItem(ohGemC);
		gemCOhCount.setSelectedItem(ohGemC);

		int opGemT = Integer.parseInt(status.getGemTOP());
		gemtOpCount.addItem(opGemT);
		gemtOpCount.setSelectedItem(opGemT);
		
		int inopGemt = Integer.parseInt(status.getGemTInop());
		gemtInopCount.addItem(inopGemt);
		gemtInopCount.setSelectedItem(inopGemt);
		
		int ohGemT = Integer.parseInt(status.getGemTOh());
		gemtOhCount.addItem(ohGemT);
		gemtOhCount.setSelectedItem(ohGemT);

		

		FUdata = status.getUnitData();
		systemType.setSelectedItem(FUdata.getUnitType());
		unitId.setText(FUdata.getUnitName());
		defendedAssets.setText(FUdata.getDefAsset());
		curLocation.setText(FUdata.getLocation());
		curPtl.setText(FUdata.getPtl());
		curStl.setText(FUdata.getStl());
	}

	
	/**
	 * JSON Serialize Object Method that converts the fireUnitData object to JSON 
	 * @param fireUnitData object
	 * @return String containing the JSON file
	 */
	public String convertObjectToJSON(fireUnitData fud)
	{
		String jSONString = "";
		
		JSONSerializer serializer = new JSONSerializer();
        
		jSONString = serializer.serialize(fud);
		
		return jSONString;
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
	 * Method that write the JSON string to disk
	 * @param String containing the JSON file
	 */
	public void writeStringToFile(String theString)
	{
		File file = new File("samstat.json");
		
		try
		{			
			PrintWriter out = new PrintWriter(file);
			
			out.println(theString);
			
			out.close();		
		}
		catch(FileNotFoundException e1)
		{
			System.out.println("This file does not exist. Try again:");
		}
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
	 * Method that get the approriate IP Address to send to
	 * @param JButton button to get button text
	 * @param connected object with ip addresses
	 * @return String the ip address
	 */
	public String ipGetter(JButton button, connected unitAddys){
		String testCase = button.getText();
		String result = "";
		switch (testCase){
		
		case ECS: testCase.equals("ECS");
		result = unitAddys.getTarget1();
		
		case BCP: 
			result = unitAddys.getTarget1();
		
		case ICC:
			if(FUtype.equals("TOC")){
			result = unitAddys.getTarget1();
		}else{
			result = unitAddys.getTarget2();
		}
		}//End Switch
		return result;
	}//end ipGetter
	
	
	
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
	

	
	
}//End PssGui