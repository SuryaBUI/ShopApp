package shop;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Dukan {

	private JFrame frame, frame1;
	private JTextField goldRate;
	private JTextField goldWeight;
	private JTextField goldTunch;
	private JTextField goldMaking;
	private JTextField oldRate;
	private JTextField oldWeight;
	private JTextField oldTunch;
	private JPanel mainMenu;
	private JPanel goldPage;
	private JPanel silverPage;
	private JPanel bankiPage;
	private JPanel bahiPage;
	private JTextField silverRate;
	private JTextField silverWeight;
	private JTextField silverTunch;
	private JTextField oldSilverRate;
	private JTextField oldSilverWeight;
	private JTextField oldSilverTunch;
	private JTextField newAnswerAmount;
	private JTextField bankiName;
	private JTextField bankiAmount;
	private JTextField bahiName;
	private JTextField bahiAmount;
	private JTextArea details;
	private JTextArea silverDetails;
	private JTextArea bankiAddress;
	private JTextArea bankiDetails;
	private JTextArea bahiAddress;
	private JTextArea bahiDetails;
	static java.util.Date date = new java.util.Date();
	static java.sql.Date todaysDate;
Connection conn= null;
ResultSet rs= null;
String[] columnNames = {"Id", "Name", "Date", "Amount",};
String[] columnName = {"Id", "Name", "Date", "New Amount", "New Weight", "New Rate", "Old Weight", "Old Rate", "Old Amount"};
private JTextField oldAmountAns;
private JTextField newAmountAns;
private JTextField name;
private JTextField oldAnswerAmount;
private JTextField silverName;
private JTextField banName;
private JTable table;
private JTextField bankiID;
private JTextField bankiRate;
private JTextField banAmount;
private JTextField bahiPaidName;
private JTextField bahiID;
private JTextField bahiPaidAmount;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dukan window = new Dukan();
					window.frame.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage(),"Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
	public static Connection connectDb(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/jewelapp", "root", "root");
			if (conn!= null) {
				System.out.println("connected");
			}
			return conn;
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e.getMessage(),"Error",
					JOptionPane.ERROR_MESSAGE);
			return null;
		}
		
	}
	

	/**
	 * Create the application.
	 */
	public Dukan() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 536, 389);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel mainMenu = new JPanel();
		frame.getContentPane().add(mainMenu, "name_2930248628607034");
		mainMenu.setLayout(null);
		mainMenu.setVisible(true);
		
		JPanel goldPage = new JPanel();
		frame.getContentPane().add(goldPage, "name_2930155258377852");
		goldPage.setLayout(null);
		goldPage.setVisible(false);
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(null);
		panel1.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel1.setBounds(10, 28, 500, 209);
		goldPage.add(panel1);
		
		JLabel label = new JLabel("New Rate");
		label.setBounds(10, 39, 54, 14);
		panel1.add(label);
		
		goldRate = new JTextField();
		goldRate.setColumns(10);
		goldRate.setBounds(93, 36, 64, 20);
		panel1.add(goldRate);
		
		JLabel label_1 = new JLabel("Weight");
		label_1.setBounds(10, 67, 46, 14);
		panel1.add(label_1);
		
		JLabel label_2 = new JLabel("New");
		label_2.setFont(new Font("Monotype Corsiva", Font.BOLD, 15));
		label_2.setBounds(65, 11, 36, 14);
		panel1.add(label_2);
		
		goldWeight = new JTextField();
		goldWeight.setColumns(10);
		goldWeight.setBounds(93, 64, 64, 20);
		panel1.add(goldWeight);
		
		JLabel label_3 = new JLabel("Tunch");
		label_3.setBounds(10, 97, 46, 14);
		panel1.add(label_3);
		
		goldTunch = new JTextField();
		goldTunch.setColumns(10);
		goldTunch.setBounds(93, 95, 64, 20);
		panel1.add(goldTunch);
		
		JLabel label_4 = new JLabel("Making");
		label_4.setBounds(10, 128, 46, 14);
		panel1.add(label_4);
		
		goldMaking = new JTextField();
		goldMaking.setColumns(10);
		goldMaking.setBounds(93, 125, 64, 20);
		panel1.add(goldMaking);
		
		JLabel label_6 = new JLabel("Old Rate");
		label_6.setBounds(265, 39, 46, 14);
		panel1.add(label_6);
		
		JLabel label_7 = new JLabel("Weight");
		label_7.setBounds(265, 67, 46, 14);
		panel1.add(label_7);
		

		
		JLabel label_8 = new JLabel("Tunch");
		label_8.setBounds(265, 97, 36, 14);
		panel1.add(label_8);
		
		oldRate = new JTextField();
		oldRate.setColumns(10);
		oldRate.setBounds(339, 36, 64, 20);
		panel1.add(oldRate);
		
		oldWeight = new JTextField();
		oldWeight.setColumns(10);
		oldWeight.setBounds(339, 64, 64, 20);
		panel1.add(oldWeight);
		
		oldTunch = new JTextField();
		oldTunch.setColumns(10);
		oldTunch.setBounds(339, 94, 64, 20);
		panel1.add(oldTunch);
		
		JButton oldAmount = new JButton("Amount");
		oldAmount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float oldRates = 0, oldTunchs = 0, oldWeights = 0, oldAmount;
				try {
					oldRates=Float.valueOf(oldRate.getText());
					
					oldTunchs=Float.valueOf(oldTunch.getText());
					oldWeights=Float.valueOf(oldWeight.getText());
					
					oldAmount = ((oldRates/10)*(oldWeights*oldTunchs/100));
					oldAmountAns.setText(Float.toString(oldAmount));
					JOptionPane.showMessageDialog(null, " Final Amount:- "+oldAmount);
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage(),"Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		oldAmount.setBounds(249, 178, 89, 23);
		panel1.add(oldAmount);
		
		JLabel lblDescription_1 = new JLabel("Details");
		lblDescription_1.setBounds(265, 128, 36, 14);
		panel1.add(lblDescription_1);
		
		JTextArea details = new JTextArea();
		details.setBounds(339, 123, 151, 44);
		panel1.add(details);
		
		JLabel lblOld = new JLabel("Old");
		lblOld.setFont(new Font("Monotype Corsiva", Font.BOLD, 15));
		lblOld.setBounds(336, 11, 46, 14);
		panel1.add(lblOld);
		
		oldAmountAns = new JTextField();
		oldAmountAns.setBounds(349, 179, 54, 20);
		panel1.add(oldAmountAns);
		oldAmountAns.setColumns(10);
		
		JButton newAmount = new JButton("Amount");
		newAmount.setBounds(0, 156, 83, 23);
		panel1.add(newAmount);
		
		newAmountAns = new JTextField();
		newAmountAns.setBounds(92, 157, 65, 20);
		panel1.add(newAmountAns);
		newAmountAns.setColumns(10);
		newAmount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				float goldRates = 0, goldMakings = 0, goldTunchs = 0, goldWeights = 0, amount, oldRates = 0, oldTunchs = 0, oldWeights = 0, oldAmount;
				try {
					goldRates=Float.valueOf(goldRate.getText());
					goldMakings=Float.valueOf(goldMaking.getText());
					goldTunchs=Float.valueOf(goldTunch.getText());
					goldWeights=Float.valueOf(goldWeight.getText());
					
					amount = (((goldRates/10)*(goldWeights*goldTunchs/100))+(goldMakings*goldWeights));
					newAmountAns.setText(Float.toString(amount));
					JOptionPane.showMessageDialog(null, " Final Amount:- "+amount);
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage(),"Error",
							JOptionPane.ERROR_MESSAGE);
				} 
			}
		});
		
		
		
		
		JLabel lblGold = new JLabel("GOLD");
		lblGold.setFont(new Font("Monotype Corsiva", Font.BOLD, 20));
		lblGold.setBounds(241, 0, 68, 36);
		goldPage.add(lblGold);
		
		JButton saveBillGold = new JButton("SAVE");
		saveBillGold.setBounds(10, 316, 89, 23);
		goldPage.add(saveBillGold);
		
//		private void clearFields(){
//			
//		}
		JButton btnClear_2 = new JButton("CLEAR");
		btnClear_2.setBounds(109, 316, 89, 23);
		goldPage.add(btnClear_2);
		
		JButton backButton = new JButton("BACK");
		backButton.setBounds(421, 314, 89, 23);
		goldPage.add(backButton);
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainMenu.setVisible(true);
				goldPage.setVisible(false);
				
				
			}
		});
		backButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblName_1 = new JLabel("NAME");
		lblName_1.setFont(new Font("Monotype Corsiva", Font.BOLD, 15));
		lblName_1.setBounds(22, 267, 53, 14);
		goldPage.add(lblName_1);
		
		name = new JTextField();
		name.setBounds(86, 264, 112, 20);
		goldPage.add(name);
		name.setColumns(10);
		
		JButton btnPrint = new JButton("PRINT");
		btnPrint.setBounds(209, 316, 89, 23);
		goldPage.add(btnPrint);
		btnClear_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				panel1.cl
				try {
					clearAllFields("goldPage");
					
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, e2.getMessage(),"Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		saveBillGold.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				todaysDate = new java.sql.Date(date.getTime());
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/jewelapp", "root", "root");
					String sql="insert IGNORE into billing (newrate, newweight, newtunch, making, name, oldrate, oldtunch, oldweight, date, newamount, oldamount, description)"
					+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; 
					PreparedStatement pst= conn.prepareStatement(sql);
					pst.setString(1, goldRate.getText());
					pst.setString(2, goldWeight.getText());
					pst.setString(3, goldTunch.getText());
					pst.setString(4, goldMaking.getText());
					pst.setString(5, name.getText());
					pst.setString(6, oldRate.getText());
					pst.setString(7, oldTunch.getText());
					pst.setString(8, oldWeight.getText());
					pst.setDate(9, todaysDate);
					pst.setString(10, newAmountAns.getText());
					pst.setString(11, oldAmountAns.getText());
					pst.setString(12, details.getText());
					pst.execute();
					JOptionPane.showMessageDialog(null, "-:Data Saved:-");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage(),"Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		
		JPanel silverPage = new JPanel();
		frame.getContentPane().add(silverPage, "name_2930158909479683");
		silverPage.setLayout(null);
		silverPage.setVisible(false);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel_1.setBounds(10, 50, 469, 261);
		silverPage.add(panel_1);
		
		JLabel label_9 = new JLabel("New Rate");
		label_9.setBounds(43, 39, 54, 14);
		panel_1.add(label_9);
		
		silverRate = new JTextField();
		silverRate.setColumns(10);
		silverRate.setBounds(107, 36, 64, 20);
		panel_1.add(silverRate);
		
		JLabel label_10 = new JLabel("Weight");
		label_10.setBounds(43, 67, 46, 14);
		panel_1.add(label_10);
		
		JLabel label_11 = new JLabel("New");
		label_11.setFont(new Font("Monotype Corsiva", Font.BOLD, 15));
		label_11.setBounds(65, 11, 36, 14);
		panel_1.add(label_11);
		
		silverWeight = new JTextField();
		silverWeight.setColumns(10);
		silverWeight.setBounds(107, 64, 64, 20);
		panel_1.add(silverWeight);
		
		JLabel label_12 = new JLabel("Tunch");
		label_12.setBounds(43, 97, 46, 14);
		panel_1.add(label_12);
		
		silverTunch = new JTextField();
		silverTunch.setColumns(10);
		silverTunch.setBounds(107, 94, 64, 20);
		panel_1.add(silverTunch);
		
		JLabel label_14 = new JLabel("Old");
		label_14.setFont(new Font("Monotype Corsiva", Font.BOLD, 15));
		label_14.setBounds(329, 11, 30, 14);
		panel_1.add(label_14);
		
		JLabel label_15 = new JLabel("Old Rate");
		label_15.setBounds(313, 39, 46, 14);
		panel_1.add(label_15);
		
		JLabel label_16 = new JLabel("Weight");
		label_16.setBounds(313, 67, 46, 14);
		panel_1.add(label_16);
		
		JLabel label_17 = new JLabel("Tunch");
		label_17.setBounds(313, 97, 36, 14);
		panel_1.add(label_17);
		
		oldSilverRate = new JTextField();
		oldSilverRate.setColumns(10);
		oldSilverRate.setBounds(381, 36, 64, 20);
		panel_1.add(oldSilverRate);
		
		oldSilverWeight = new JTextField();
		oldSilverWeight.setColumns(10);
		oldSilverWeight.setBounds(381, 64, 64, 20);
		panel_1.add(oldSilverWeight);
		
		oldSilverTunch = new JTextField();
		oldSilverTunch.setColumns(10);
		oldSilverTunch.setBounds(381, 94, 64, 20);
		panel_1.add(oldSilverTunch);
		
		JButton newButton = new JButton("Amount");
		newButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		newButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float silverRates = 0, silverTunchs = 0, silverWeights = 0, amount;
				try {
					silverRates=Float.valueOf(silverRate.getText());
					silverTunchs=Float.valueOf(silverTunch.getText());
					silverWeights=Float.valueOf(silverWeight.getText());
					
					amount = (silverRates*(silverWeights*silverTunchs/100));
					newAnswerAmount.setText(Float.toString(amount));
					JOptionPane.showMessageDialog(null, " Final Amount:- "+amount);
					
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, e2.getMessage(),"Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		newButton.setBounds(13, 122, 76, 23);
		panel_1.add(newButton);
		
		newAnswerAmount = new JTextField();
		newAnswerAmount.setColumns(10);
		newAnswerAmount.setBounds(107, 125, 64, 20);
		panel_1.add(newAnswerAmount);
		
		JButton oldButton = new JButton("Amount");
		oldButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		oldButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float oldRates = 0, oldTunchs = 0, oldWeights = 0, amount;
				try {
					oldRates=Float.valueOf(oldSilverRate.getText());
					
					oldTunchs=Float.valueOf(oldSilverTunch.getText());
					oldWeights=Float.valueOf(oldSilverWeight.getText());
					
					amount = ((oldRates)*(oldWeights*oldTunchs/100));
					oldAnswerAmount.setText(Float.toString(amount));
					JOptionPane.showMessageDialog(null, " Final Amount:- "+amount);
					
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, e2.getMessage(),"Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		oldButton.setBounds(282, 122, 77, 23);
		panel_1.add(oldButton);
		
		oldAnswerAmount = new JTextField();
		oldAnswerAmount.setBounds(381, 125, 64, 20);
		panel_1.add(oldAnswerAmount);
		oldAnswerAmount.setColumns(10);
		
		JLabel lblDetails = new JLabel("Details");
		lblDetails.setBounds(303, 178, 46, 14);
		panel_1.add(lblDetails);
		
		JTextArea silverDetails = new JTextArea();
		silverDetails.setBounds(360, 173, 109, 37);
		panel_1.add(silverDetails);
		
		JLabel label_5 = new JLabel("NAME");
		label_5.setFont(new Font("Monotype Corsiva", Font.BOLD, 15));
		label_5.setBounds(13, 222, 53, 14);
		panel_1.add(label_5);
		
		silverName = new JTextField();
		silverName.setColumns(10);
		silverName.setBounds(77, 219, 112, 20);
		panel_1.add(silverName);
		
		JLabel lblSilver = new JLabel("SILVER");
		lblSilver.setFont(new Font("Monotype Corsiva", Font.BOLD, 20));
		lblSilver.setBounds(217, 11, 92, 47);
		silverPage.add(lblSilver);
		
		JButton button_2 = new JButton("BACK");
		button_2.setBounds(424, 316, 86, 23);
		silverPage.add(button_2);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainMenu.setVisible(true);
				silverPage.setVisible(false);
				
			}
		});
		button_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton saveBillSilver = new JButton("SAVE");
		saveBillSilver.setBounds(10, 316, 89, 23);
		silverPage.add(saveBillSilver);
		saveBillSilver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				todaysDate = new java.sql.Date(date.getTime());
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/jewelapp", "root", "root");
					String sql="insert IGNORE into billing (newrate, newweight, newtunch, name, oldrate, oldtunch, oldweight, date, newamount, oldamount, description, making)"
					+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; 
					PreparedStatement pst= conn.prepareStatement(sql);
					System.out.println(silverRate.getText());
					pst.setString(1, silverRate.getText());
					pst.setString(2, silverWeight.getText());
					pst.setString(3, silverTunch.getText());
					pst.setString(4, silverName.getText());
					pst.setString(5, oldSilverRate.getText());
					pst.setString(6, oldSilverTunch.getText());
					pst.setString(7, oldSilverWeight.getText());
					pst.setDate(8,todaysDate);
					pst.setString(9, newAnswerAmount.getText());
					pst.setString(10, oldAnswerAmount.getText());
					pst.setString(11, silverDetails.getText());
					pst.setString(12, "Making included");
//					if(silverRate.getText()!= null){
					pst.execute();
					JOptionPane.showMessageDialog(null, "-:Data Saved:-");
					System.out.println("nnn");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage(),"Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		
		JButton button_3 = new JButton("CLEAR");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					clearAllFields("silverPage");
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, e2.getMessage(),"Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		button_3.setBounds(109, 316, 89, 23);
		silverPage.add(button_3);
		
		JButton button_4 = new JButton("PRINT");
		button_4.setBounds(209, 316, 89, 23);
		silverPage.add(button_4);
		silverPage.setVisible(false);
		
		JPanel bankiPage = new JPanel();
		frame.getContentPane().add(bankiPage, "name_2930162213918259");
		bankiPage.setLayout(null);
		bankiPage.setVisible(false);
		
		JLabel lblBanki = new JLabel("BANKI");
		lblBanki.setFont(new Font("Monotype Corsiva", Font.BOLD, 20));
		lblBanki.setBounds(223, 11, 73, 31);
		bankiPage.add(lblBanki);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel_2.setBounds(20, 44, 434, 261);
		bankiPage.add(panel_2);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setBounds(57, 14, 54, 14);
		panel_2.add(lblName);
		
		bankiName = new JTextField();
		bankiName.setColumns(10);
		bankiName.setBounds(175, 11, 186, 20);
		panel_2.add(bankiName);
		
		JLabel lblDate = new JLabel("AMOUNT");
		lblDate.setBounds(57, 42, 46, 14);
		panel_2.add(lblDate);
		
		bankiAmount = new JTextField();
		bankiAmount.setColumns(10);
		bankiAmount.setBounds(175, 42, 74, 20);
		panel_2.add(bankiAmount);
		
		JLabel lblAddress = new JLabel("ADDRESS");
		lblAddress.setBounds(57, 73, 46, 14);
		panel_2.add(lblAddress);
		
		JTextArea bankiDetails = new JTextArea();
		bankiDetails.setBounds(175, 121, 186, 47);
		panel_2.add(bankiDetails);
		
		JTextArea bankiAddress = new JTextArea();
		bankiAddress.setBounds(175, 73, 186, 37);
		panel_2.add(bankiAddress);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				todaysDate = new java.sql.Date(date.getTime());
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/jewelapp", "root", "root");
					String sql="insert IGNORE into banki (name, address, details, date, amount)"
					+ " values (?, ?, ?, ?, ?)"; 
					PreparedStatement pst= conn.prepareStatement(sql);
					
					pst.setString(1, bankiName.getText());
					pst.setString(2, bankiAddress.getText());
					pst.setString(3, bankiDetails.getText());
					pst.setDate(4, todaysDate);
					pst.setString(5, bankiAmount.getText());
					pst.execute();
					JOptionPane.showMessageDialog(null, "-:Data Saved:-");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage(),"Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSave.setBounds(175, 204, 89, 23);
		panel_2.add(btnSave);
		
		
		
		JLabel lblDescription = new JLabel("DESCRIPTION");
		lblDescription.setBounds(57, 126, 94, 14);
		panel_2.add(lblDescription);
		
	
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					clearAllFields("bankiPage");
					
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, e2.getMessage(),"Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnClear.setBounds(274, 204, 89, 23);
		panel_2.add(btnClear);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setBounds(324, 238, 80, 23);
		panel_2.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bankiPage.setVisible(false);
				mainMenu.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		
		JPanel bahiPage = new JPanel();
		frame.getContentPane().add(bahiPage, "name_2930173085253064");
		bahiPage.setLayout(null);
		bahiPage.setVisible(false);
		
		JLabel lblBahi = new JLabel("BAHI");
		lblBahi.setFont(new Font("Monotype Corsiva", Font.BOLD, 20));
		lblBahi.setBounds(119, 11, 58, 34);
		bahiPage.add(lblBahi);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel_3.setBounds(20, 41, 427, 261);
		bahiPage.add(panel_3);
		
		JLabel label_13 = new JLabel("NAME");
		label_13.setBounds(10, 14, 54, 14);
		panel_3.add(label_13);
		
		bahiName = new JTextField();
		bahiName.setColumns(10);
		bahiName.setBounds(74, 11, 186, 20);
		panel_3.add(bahiName);
		
		JLabel label_18 = new JLabel("AMOUNT");
		label_18.setBounds(10, 39, 46, 14);
		panel_3.add(label_18);
		
		bahiAmount = new JTextField();
		bahiAmount.setColumns(10);
		bahiAmount.setBounds(74, 42, 74, 20);
		panel_3.add(bahiAmount);
		
		JLabel label_19 = new JLabel("ADDRESS");
		label_19.setBounds(10, 64, 46, 14);
		panel_3.add(label_19);
		
		JTextArea bahiAddress = new JTextArea();
		bahiAddress.setBounds(74, 73, 186, 37);
		panel_3.add(bahiAddress);
		
		JTextArea bahiDetails = new JTextArea();
		bahiDetails.setBounds(74, 121, 186, 47);
		panel_3.add(bahiDetails);
		
		JButton button = new JButton("SAVE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				todaysDate = new java.sql.Date(date.getTime());
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/jewelapp", "root", "root");
					String sql="insert IGNORE into bahi (name, address, details, date, amount, finalamount)"
					+ " values (?, ?, ?, ?, ?, ?)"; 
					PreparedStatement pst= conn.prepareStatement(sql);
					
					pst.setString(1, bahiName.getText());
					pst.setString(2, bahiAddress.getText());
					pst.setString(3, bahiDetails.getText());
					pst.setDate(4, todaysDate);
					pst.setString(5, bahiAmount.getText());
					pst.setString(6, bahiAmount.getText());
					pst.execute();
					JOptionPane.showMessageDialog(null, "-:Data Saved:-");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage(),"Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 14));
		button.setBounds(10, 198, 89, 23);
		panel_3.add(button);
		
		
		
		JLabel label_20 = new JLabel("DESCRIPTION");
		label_20.setBounds(0, 126, 89, 14);
		panel_3.add(label_20);
		
		
		
		JButton btnClear_1 = new JButton("CLEAR");
		btnClear_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					clearAllFields("bahiPage");
					
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, e2.getMessage(),"Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnClear_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnClear_1.setBounds(122, 198, 89, 23);
		panel_3.add(btnClear_1);
		
		bahiPaidName = new JTextField();
		bahiPaidName.setBounds(338, 11, 86, 20);
		panel_3.add(bahiPaidName);
		bahiPaidName.setColumns(10);
		
		bahiID = new JTextField();
		bahiID.setBounds(338, 42, 54, 20);
		panel_3.add(bahiID);
		bahiID.setColumns(10);
		
		bahiPaidAmount = new JTextField();
		bahiPaidAmount.setBounds(338, 75, 68, 20);
		panel_3.add(bahiPaidAmount);
		bahiPaidAmount.setColumns(10);
		
		JButton btnDone = new JButton("DONE");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/jewelapp", "root", "root");
					int bahiId = Integer.valueOf(bahiID.getText());
					int bahiAmount = Integer.valueOf(bahiPaidAmount.getText());
					
					
					String sql = "select * from bahi Where id = '"+bahiId+"'";
					PreparedStatement ps = conn.prepareStatement(sql);
					ResultSet rs = ps.executeQuery();
					if(rs.next()){
						
						todaysDate = new java.sql.Date(date.getTime());
						PreparedStatement pst;
						int amount= rs.getInt("finalamount");
						amount -= bahiAmount;
						String queryalter= "UPDATE bahi SET finalamount = '"+amount+"' WHERE id = '"+bahiId+"'";
						pst= conn.prepareStatement(queryalter);
						pst.execute();
						
						String query="insert IGNORE into bahipaid (name, date, amount, finalamount)"
								+ " values (?, ?, ?, ?)"; 
								pst= conn.prepareStatement(query);
								
								pst.setString(1, bahiPaidName.getText());
								pst.setDate(2, todaysDate);
								pst.setString(3, bahiPaidAmount.getText());
								pst.setFloat(4, amount);
								
								pst.execute();
								JOptionPane.showMessageDialog(null, "-:Data Saved:-");
								
						if(rs.getFloat("finalamount") <= 0){
							String delete ="DELETE FROM bahi WHERE id = '"+bahiId+"'";
							pst= conn.prepareStatement(delete);
							pst.execute();
						}
						clearAllFields("bahiPage");
						
						
					 }
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage(),"Error",
							JOptionPane.ERROR_MESSAGE);
				}
				
				
			}
		});
		btnDone.setBounds(338, 122, 89, 23);
		panel_3.add(btnDone);
		
		JButton btnBack_1 = new JButton("BACK");
		btnBack_1.setBounds(419, 316, 80, 23);
		bahiPage.add(btnBack_1);
		btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bahiPage.setVisible(false);
				mainMenu.setVisible(true);
			}
		});
		btnBack_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblPaid = new JLabel("PAID");
		lblPaid.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPaid.setBounds(383, 11, 46, 23);
		bahiPage.add(lblPaid);
		
		JButton btnGo = new JButton("GO");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame1 = new JFrame("Database Search Result");
				frame1.getContentPane().setLayout(new BorderLayout()); 
				DefaultTableModel model = new DefaultTableModel();
				model.setColumnIdentifiers(columnNames);
				table = new JTable();
				table.setModel(model); 
				table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
				table.setFillsViewportHeight(true);
				JScrollPane scroll = new JScrollPane(table);
				scroll.setHorizontalScrollBarPolicy(
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				scroll.setVerticalScrollBarPolicy(
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
				String textvalue = bahiPaidName.getText();
				String id= "";
				String name= "";
				String date = "";
				String amount = "";
				
				
				try
				{ 
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/jewelapp", "root", "root");
				String sql = "select * from bahi Where Name like '%"+textvalue+"%'";
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				int i =0;
				while (rs.next())
				{
				id = rs.getString("id");
				name = rs.getString("name");
				date = rs.getString("date");
				amount = rs.getString("finalamount"); 
				model.addRow(new Object[]{id, name, date, amount});
				i++; 
				}
				if(i <1)
				{
				JOptionPane.showMessageDialog(null, "No Record Found","Error",
				JOptionPane.ERROR_MESSAGE);
				}
				if(i ==1)
				{
				System.out.println(i+" Record Found");
				}
				else
				{
				System.out.println(i+" Records Found");
				}
				}
				catch(Exception ex)
				{
				JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",
				JOptionPane.ERROR_MESSAGE);
				}
				frame1.getContentPane().add(scroll);
				frame1.setVisible(true);
				frame1.setSize(400,300);
			}
		});
		btnGo.setBounds(452, 52, 58, 23);
		bahiPage.add(btnGo);
		
		JLabel lblId_1 = new JLabel("ID");
		lblId_1.setBounds(472, 86, 27, 14);
		bahiPage.add(lblId_1);
		
		JLabel lblAmount = new JLabel("AMOUNT");
		lblAmount.setBounds(453, 119, 57, 14);
		bahiPage.add(lblAmount);
		
		
		
		JLabel WELCOME = new JLabel("WELCOME");
		WELCOME.setFont(new Font("Monotype Corsiva", Font.BOLD, 18));
		WELCOME.setBounds(206, 11, 99, 23);
		mainMenu.add(WELCOME);
		
		JButton btnGold = new JButton("GOLD");
		btnGold.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goldPage.setVisible(true);
				mainMenu.setVisible(false);
			}
		});
		btnGold.setBounds(48, 59, 77, 23);
		mainMenu.add(btnGold);
		
		JButton btnSilver = new JButton("SILVER");
		btnSilver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				silverPage.setVisible(true);
				mainMenu.setVisible(false);
			}
		});
		btnSilver.setBounds(327, 59, 77, 23);
		mainMenu.add(btnSilver);
		
		JButton btnBanki = new JButton("BANKI");
		btnBanki.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bankiPage.setVisible(true);
				mainMenu.setVisible(false);
			}
		});
		btnBanki.setBounds(48, 116, 77, 23);
		mainMenu.add(btnBanki);
		
		JButton btnBahi = new JButton("BAHI");
		btnBahi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bahiPage.setVisible(true);
				mainMenu.setVisible(false);
			}
		});
		btnBahi.setBounds(327, 116, 77, 23);
		mainMenu.add(btnBahi);
		
		JPanel viewBill = new JPanel();
		frame.getContentPane().add(viewBill, "name_3968726769797025");
		viewBill.setLayout(null);
		
		JLabel lblViewBill = new JLabel("VIEW DATA");
		lblViewBill.setBounds(204, 11, 91, 30);
		viewBill.add(lblViewBill);
		
		JButton btnBahi_1 = new JButton("BAHI");
		btnBahi_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showTableData("bahi"); 
			}
		});
		btnBahi_1.setBounds(34, 61, 100, 23);
		viewBill.add(btnBahi_1);
		
		JButton btnBanki_1 = new JButton("BANKI");
		btnBanki_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showTableData("banki");
			}
		});
		btnBanki_1.setBounds(34, 127, 100, 23);
		viewBill.add(btnBanki_1);
		
		JButton btnGoldBills = new JButton("GOLD BILLS");
		btnGoldBills.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				frame1 = new JFrame("Database Search Result");
				frame1.getContentPane().setLayout(new BorderLayout()); 
				DefaultTableModel model = new DefaultTableModel();
				model.setColumnIdentifiers(columnName);
				table = new JTable();
				table.setModel(model); 
				table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
				table.setFillsViewportHeight(true);
				JScrollPane scroll = new JScrollPane(table);
				scroll.setHorizontalScrollBarPolicy(
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				scroll.setVerticalScrollBarPolicy(
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
				
				String id= "";
				String name= "";
				String date = "";
				String newrate = "";
				String newweight = "";
				String newamount = "";
				String oldweight = "";
				String oldrate = "";
				String oldamount = "";
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/jewelapp", "root", "root");
					
					String sql = "select * from billing ";
					PreparedStatement ps = conn.prepareStatement(sql);
					ResultSet rs = ps.executeQuery();
					int i =0;
					while (rs.next())
					{
						int x = Integer.parseInt(rs.getString("newrate"));
						if(x>9999 && x<100000) {
							id = rs.getString("id");
							name = rs.getString("name");
							date = rs.getString("date");
							newamount = rs.getString("newamount"); 
							newweight = rs.getString("newweight");
							newrate = rs.getString("newrate");
							oldweight = rs.getString("oldweight");
							oldrate = rs.getString("oldrate");
							oldamount = rs.getString("oldamount");
							
							model.addRow(new Object[]{id, name, date, newamount, newweight, newrate, oldweight, oldrate, oldamount});
							i++; 
						}
					}
				} catch (Exception ex) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",
					JOptionPane.ERROR_MESSAGE);
				}
				frame1.getContentPane().add(scroll);
				frame1.setVisible(true);
				frame1.setSize(700,300);
			}
		});
		btnGoldBills.setBounds(204, 61, 122, 23);
		viewBill.add(btnGoldBills);
		
		JButton btnSilverBills = new JButton("SILVER BILLS");
		btnSilverBills.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame1 = new JFrame("Database Search Result");
				frame1.getContentPane().setLayout(new BorderLayout()); 
				DefaultTableModel model = new DefaultTableModel();
				model.setColumnIdentifiers(columnName);
				table = new JTable();
				table.setModel(model); 
				table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
				table.setFillsViewportHeight(true);
				JScrollPane scroll = new JScrollPane(table);
				scroll.setHorizontalScrollBarPolicy(
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				scroll.setVerticalScrollBarPolicy(
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
				
				String id= "";
				String name= "";
				String date = "";
				String newrate = "";
				String newweight = "";
				String newamount = "";
				String oldweight = "";
				String oldrate = "";
				String oldamount = "";
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/jewelapp", "root", "root");
					
					String sql = "select * from billing ";
					PreparedStatement ps = conn.prepareStatement(sql);
					ResultSet rs = ps.executeQuery();
					int i =0;
					while (rs.next())
					{
						int x = Integer.parseInt(rs.getString("newrate"));
						if(x>9 && x<100) {
							id = rs.getString("id");
							name = rs.getString("name");
							date = rs.getString("date");
							newamount = rs.getString("newamount"); 
							newweight = rs.getString("newweight");
							newrate = rs.getString("newrate");
							oldweight = rs.getString("oldweight");
							oldrate = rs.getString("oldrate");
							oldamount = rs.getString("oldamount");
							
							model.addRow(new Object[]{id, name, date, newamount, newweight, newrate, oldweight, oldrate, oldamount});
							i++; 
						}
					}
				} catch (Exception ex) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",
					JOptionPane.ERROR_MESSAGE);
				}
				frame1.getContentPane().add(scroll);
				frame1.setVisible(true);
				frame1.setSize(700,300);
			}
			

			
		});
		btnSilverBills.setBounds(204, 127, 122, 23);
		viewBill.add(btnSilverBills);
		
		JButton btnBack_3 = new JButton("BACK");
		btnBack_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewBill.setVisible(false);
				mainMenu.setVisible(true);
			}
		});
		btnBack_3.setBounds(388, 316, 89, 23);
		viewBill.add(btnBack_3);
		
		JButton btnViewBill = new JButton("BILL");
		btnViewBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewBill.setVisible(true);
				mainMenu.setVisible(false);
			}
		});
		btnViewBill.setBounds(48, 173, 77, 23);
		mainMenu.add(btnViewBill);
		
		JPanel calBankiPage = new JPanel();
		frame.getContentPane().add(calBankiPage, "name_3968655218874180");
		calBankiPage.setLayout(null);
		
		JButton btnNewButton = new JButton("CALBANKI");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calBankiPage.setVisible(true);
				mainMenu.setVisible(false);
			}
		});
		btnNewButton.setBounds(327, 173, 89, 23);
		mainMenu.add(btnNewButton);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(162, 279, 89, 23);
		mainMenu.add(btnExit);
		
		
		
		JLabel lblCalculateBanki = new JLabel("CALCULATE BANKI");
		lblCalculateBanki.setFont(new Font("Monotype Corsiva", Font.BOLD, 15));
		lblCalculateBanki.setBounds(160, 11, 165, 27);
		calBankiPage.add(lblCalculateBanki);
		
		JLabel lblName_2 = new JLabel("NAME");
		lblName_2.setBounds(39, 50, 46, 14);
		calBankiPage.add(lblName_2);
		
		banName = new JTextField();
		banName.setBounds(97, 47, 176, 20);
		calBankiPage.add(banName);
		banName.setColumns(10);
		
		table = new JTable();
		table.setBounds(84, 155, 165, -35);
		calBankiPage.add(table);
		
		 JButton btnFind = new JButton("FIND");
		btnFind.setBounds(300, 46, 72, 23);
		calBankiPage.add(btnFind);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(39, 120, 32, 14);
		calBankiPage.add(lblId);
		
		bankiID = new JTextField();
		bankiID.setBounds(97, 117, 64, 20);
		calBankiPage.add(bankiID);
		bankiID.setColumns(10);
		
		JLabel lblRatemonth = new JLabel("RATE");
		lblRatemonth.setBounds(39, 155, 46, 14);
		calBankiPage.add(lblRatemonth);
		
		bankiRate = new JTextField();
		bankiRate.setBounds(97, 152, 64, 20);
		calBankiPage.add(bankiRate);
		bankiRate.setColumns(10);
		
		JButton btnAmount = new JButton("AMOUNT");
		btnAmount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/jewelapp", "root", "root");
					Float banId = Float.valueOf(bankiID.getText());
					Float banRate = Float.valueOf(bankiRate.getText());
					
					
					String sql = "select * from banki Where id = '"+banId+"'";
					PreparedStatement ps = conn.prepareStatement(sql);
					ResultSet rs = ps.executeQuery();
					if(rs.next()){
						 Date din = rs.getDate("date");
						 Calendar startCalendar = new GregorianCalendar();
						startCalendar.setTime(din);
						Calendar endCalendar = new GregorianCalendar();
						
						todaysDate = new java.sql.Date(date.getTime());
						endCalendar.setTime(todaysDate);
						int diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
						float diffMonth = diffYear * 12 + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH)-1;
						SimpleDateFormat formatter = new SimpleDateFormat("dd");
						String strDate = formatter.format(date);
						float days= (Float.valueOf(strDate))/30;
						diffMonth +=days;
						float principle= rs.getFloat("amount");
						if (diffMonth >= 1) {
							float interest= (float) ((principle/100)*diffMonth* banRate);
							double totalAmount= principle + interest;
							JOptionPane.showMessageDialog(null, "Interest:-"+interest+"\nTotal Amount:-"+totalAmount);
							banAmount.setText(Double.toString(totalAmount));
							System.out.println(interest +" is interest.");
						} else {
							JOptionPane.showMessageDialog(null, "\nTotal Amount:- "+principle+30);
							banAmount.setText(Double.toString(principle));
						}
					 }
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage(),"Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnAmount.setBounds(191, 131, 89, 23);
		calBankiPage.add(btnAmount);
		
		banAmount = new JTextField();
		banAmount.setBounds(324, 132, 86, 20);
		calBankiPage.add(banAmount);
		banAmount.setColumns(10);
		
		JButton btnClear_3 = new JButton("CLEAR");
		btnClear_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					clearAllFields("calBankiPage");
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		btnClear_3.setBounds(191, 178, 89, 23);
		calBankiPage.add(btnClear_3);
		
		JButton btnBack_2 = new JButton("BACK");
		btnBack_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calBankiPage.setVisible(false);
				mainMenu.setVisible(true);
			}
		});
		btnBack_2.setBounds(324, 178, 89, 23);
		calBankiPage.add(btnBack_2);
		
		JButton btnPaid = new JButton("PAID");
		btnPaid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/jewelapp", "root", "root");
					int banId = Integer.parseInt(bankiID.getText());
					String sql = "DELETE FROM banki Where id = '"+banId+"'";
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.execute();
					System.out.println("abc");
					
						JOptionPane.showMessageDialog(null, "Record deleted","Succes",
								JOptionPane.INFORMATION_MESSAGE);
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnPaid.setBounds(191, 220, 89, 23);
		calBankiPage.add(btnPaid);
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//btnFind = (JButton)e.getSource();
				
				showTableData("banki");
			}

			
		});
	}
	protected void showTableData(String abc) {
		// TODO Auto-generated method stub
		frame1 = new JFrame("Database Search Result");
		frame1.getContentPane().setLayout(new BorderLayout()); 
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNames);
		table = new JTable();
		table.setModel(model); 
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setFillsViewportHeight(true);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setHorizontalScrollBarPolicy(
		JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(
		JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
		String textvalue = banName.getText();
		String id= "";
		String name= "";
		String date = "";
		String amount = "";
		
		try
		{ 
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/jewelapp", "root", "root");
		String sql = "select * from "+abc+" Where Name like '%"+textvalue+"%'";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		int i =0;
		while (rs.next())
		{
		id = rs.getString("id");
		name = rs.getString("name");
		date = rs.getString("date");
		amount = rs.getString("amount"); 
		model.addRow(new Object[]{id, name, date, amount});
		i++; 
		}
		if(i <1)
		{
		JOptionPane.showMessageDialog(null, "No Record Found","Error",
		JOptionPane.ERROR_MESSAGE);
		}
		if(i ==1)
		{
		System.out.println(i+" Record Found");
		}
		else
		{
		System.out.println(i+" Records Found");
		}
		}
		catch(Exception ex)
		{
		JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",
		JOptionPane.ERROR_MESSAGE);
		}
		frame1.getContentPane().add(scroll);
		frame1.setVisible(true);
		frame1.setSize(400,300);
		
	}
	private Object clearAllFields(String string) {
		if (string == "goldPage") {
			try {
				goldRate.setText("");
				oldRate.setText("");
				goldWeight.setText("");
				oldWeight.setText("");
				goldTunch.setText("");
				oldTunch.setText("");
				goldMaking.setText("");
				newAmountAns.setText("");
				oldAmountAns.setText("");
				details.setText("");
				name.setText("");
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, e.getMessage(),"Error",
						JOptionPane.ERROR_MESSAGE);
			}
		} else if(string=="silverPage"){
			try {
				silverRate.setText("");
				silverWeight.setText("");
				silverTunch.setText("");
				silverName.setText("");
				oldSilverRate.setText("");
				oldSilverTunch.setText("");
				oldSilverWeight.setText("");
				newAnswerAmount.setText("");
				oldAnswerAmount.setText("");
				silverDetails.setText("");
			} catch (Exception e) {
				// TODO: handle exception
			
			JOptionPane.showMessageDialog(null, e.getMessage(),"Error",
					JOptionPane.ERROR_MESSAGE);
			}
		} else if (string=="bankiPage") {
			try {
				bankiName.setText("");
				bankiAmount.setText("");
				bankiAddress.setText("");
				bankiDetails.setText("");
				
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, e.getMessage(),"Error",
						JOptionPane.ERROR_MESSAGE);
			}
		} else if (string=="bahiPage") {
			try {
				bahiName.setText("");
				bahiAmount.setText("");
				bahiAddress.setText(null);
				bahiDetails.setText("");
				bahiPaidName.setText("");
				bahiID.setText("");
				bahiPaidAmount.setText("");
			} catch (Exception e2) {
				// TODO: handle exception
			JOptionPane.showMessageDialog(null, e2.getMessage(),"Error",
					JOptionPane.ERROR_MESSAGE);
			}
		} else if(string=="calBankiPage"){
			try {
				banName.setText("");
				bankiID.setText("");
				bankiRate.setText("");
				banAmount.setText("");
				
			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, e2.getMessage(),"Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}else {
			System.out.println("blank");
		}
		System.out.println("Cleared");
		return null;
	}
}
