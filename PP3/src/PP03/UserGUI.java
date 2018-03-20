//*******************************************************************************
//* 																			*
//* 			CIS611 Spring 2017 Anand RameshKannan, Jeffrey Cheng			*		
//* 																			*	
//* 						Program Project PP3					 				*
//* 																 			*
//* 			UserGUI class has main methods and extends from JPanel			*
//*					have layout method and ActionListener method				*
//*																				*	
//* 																 			*
//* 					Date Created: 03.25.2017 					 			*
//*						Saved in: UserGUI.java		 	 						*
//* 																 			*
//*******************************************************************************
package PP03;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.Date;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class UserGUI extends JPanel {
	//declare JLabel
	private JLabel employeeLabel;
	private JLabel addressLabel;
	private JLabel payPeriodLabel;
	private JLabel payRecordLabel;
	private JLabel recordStatusLabel;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JLabel label6;
	private JLabel label7;
	private JLabel label8;
	private JLabel label9;
	private JLabel label10;
	private JLabel label11;
	private JLabel label12;
	private JLabel label13;
	private JLabel label14;
	private JLabel label15;
	private JLabel label16;
	private JLabel label17;
	//declare JTextField
	private JTextField field1;
	private JTextField field2;
	private JTextField field3;
	private JTextField field4;
	private JTextField field5;
	private JTextField field6;
	private JTextField field7;
	private JTextField field8;
	private JTextField field9;
	private JTextField field10;
	private JTextField field11;
	private JTextField field12;
	private JTextField field13;
	private JTextField field14;
	private JTextField field15;

	//declare new JPanel
	JPanel employeePanel = new JPanel();
	JPanel addressPanel = new JPanel();
	JPanel payPeriodPanel = new JPanel();
	JPanel payRecordPanel = new JPanel();
	JPanel outputPanel = new JPanel();

	//declare components
	private JButton addEmployeeButton;
	private JButton addPayRecordButton;
	private JButton closeButton;
	private JTextArea textArea;

	private JComboBox combList;

	private JRadioButton button1;
	private JRadioButton button2;

	private JScrollPane scrollPane;

	private PayRoll payRoll;

	private String fileName = "PayRoll.txt";

	private Status inputStatus = null;
	private String inputState = "";
	private Employee myEmp;
	int inputID = 0;
	private Date sDate;
	private int sMonth;
	private int eMonth;
	private Date eDate;
	private int eYear;
	private int sYear;
	private int sDay;
	private int eDay;

	public UserGUI(PayRoll pR) {
		
		this.payRoll = pR;

		try {
			JOptionPane.showMessageDialog(null, "Read data from PayRoll.txt!");
			payRoll.readFromFile(fileName);
			
		} 
		catch (IOException e1) {
			JOptionPane.showMessageDialog(null, "PayRoll.txt not found!");
		}

		initGUI();
		doTheLayout();

		addEmployeeButton.addActionListener( new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e){
				addEmployee();


			}
		});

		addPayRecordButton.addActionListener( new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e){
				addPayRecord();
			}
		});

		button1.addActionListener( new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e){
				radioButton();
			}
		});

		button2.addActionListener( new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e){
				radioButton();
			}
		});

		closeButton.addActionListener( new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e){
				close();
			}
		});

		combList.addActionListener( new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e){
				combobox();

			}
		});

	} // end of constructor

	private void initGUI(){

		employeeLabel = new JLabel("Employee: ");
		addressLabel = new JLabel("Employee Address:");
		payPeriodLabel = new JLabel("Pay Period: ");
		payRecordLabel = new JLabel("Pay Record: ");
		recordStatusLabel = new JLabel("Current Employee Record and Stat (Total & Average Pays): ");

		label1 = new JLabel("ID: ");
		label2 = new JLabel("First Name: ");
		label3 = new JLabel("Last Name: ");
		label4 = new JLabel("Employee Status: ");
		label5 = new JLabel("Street: ");
		label6 = new JLabel("H/Apt Number: ");
		label7 = new JLabel("City: ");
		label8 = new JLabel("State: ");
		label9 = new JLabel("Zip Code: ");
		label10 = new JLabel("ID: ");
		label11 = new JLabel("Start Date: ");
		label12 = new JLabel("End Date:  ");
		label13 = new JLabel("ID:  ");
		label14 = new JLabel("Monthly Income:  ");
		label15 = new JLabel("Number of Months:  ");
		label16 = new JLabel("Pay Hours:  ");
		label17 = new JLabel("Pay Rates:  ");
		field1 = new JTextField(5);
		field2 = new JTextField(10);
		field3 = new JTextField(10);
		field4 = new JTextField(15);
		field5 = new JTextField(5);
		field6 = new JTextField(10);
		field7 = new JTextField(5);
		field8 = new JTextField(5);
		field9 = new JTextField(10);
		field10 = new JTextField(10);
		field11 = new JTextField(5);
		field12 = new JTextField(10);
		field13 = new JTextField(5);
		field14 = new JTextField(10);
		field15 = new JTextField(10);
		textArea = new JTextArea(5, 30);
		textArea.setColumns(30);
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		scrollPane = new JScrollPane(textArea);
		scrollPane.setPreferredSize(new Dimension (15, 60));
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	

		String[] listState = { "","Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia", "Hawaii", 
				"Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi", 
				"Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma",
				"Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia",
				"Wisconsin", "Wyoming"};

		combList = new JComboBox(listState);

		addEmployeeButton = new JButton("Add Employee");
		addPayRecordButton = new JButton("Add Pay Record");
		closeButton = new JButton("Close");

		button1 = new JRadioButton("Full Time");
		button2 = new JRadioButton("Hourly");

		ButtonGroup group= new ButtonGroup();
		group.add(button1);
		group.add(button2);



	}// end of creating objects method

	private void doTheLayout(){


		//Change JLabel color
		employeeLabel.setForeground(Color.blue);
		payPeriodLabel.setForeground(Color.blue);
		payRecordLabel.setForeground(Color.blue);
		recordStatusLabel.setForeground(Color.blue);

		addEmployeeButton.setPreferredSize(new Dimension (130, 22));
		addPayRecordButton.setPreferredSize(new Dimension (130, 22));
		closeButton.setPreferredSize(new Dimension (100, 22));

		//Layout for employee information
		employeePanel.setPreferredSize(new Dimension( 600, 120));

		Box right = Box.createVerticalBox();
		right.add(button1);
		right.add(button2);
		employeePanel.add(employeeLabel);

		employeePanel.add(Box.createRigidArea(new Dimension(580,5)));

		employeePanel.add(label1);
		employeePanel.add(field1);
		employeePanel.add(label2);
		employeePanel.add(field2);
		employeePanel.add(label3);
		employeePanel.add(field3);
		employeePanel.add(Box.createRigidArea(new Dimension(500, 0)));
		employeePanel.add(label4);
		employeePanel.add(right);
		employeePanel.add(Box.createRigidArea(new Dimension(0, 10)));

		//Layout for employee address
		addressPanel.setPreferredSize(new Dimension(600, 140));
		combList.setPreferredSize(new Dimension(110, 20));

		addressPanel.add(addressLabel);
		addressPanel.add(Box.createRigidArea(new Dimension(560,0)));

		addressPanel.add(label5);
		addressPanel.add(field4);
		addressPanel.add(label6);
		addressPanel.add(field5);
		addressPanel.add(label7);

		addressPanel.add(field6);
		addressPanel.add(Box.createRigidArea(new Dimension(50,0)));
		addressPanel.add(label8);
		addressPanel.add(combList);		
		addressPanel.add(label9);
		addressPanel.add(field7);
		addressPanel.add(Box.createRigidArea(new Dimension(500,5)));
		addressPanel.add(addEmployeeButton);

		//Layout for pay period 
		payPeriodPanel.setPreferredSize( new Dimension( 600, 70 ) );
		payPeriodPanel.add(payPeriodLabel);
		payPeriodPanel.add(Box.createRigidArea(new Dimension(580,5)));
		payPeriodPanel.add(label10);
		payPeriodPanel.add(field8);
		payPeriodPanel.add(label11);
		payPeriodPanel.add(field9);
		payPeriodPanel.add(label12);
		payPeriodPanel.add(field10);

		//Layout for pay record
		payRecordPanel.setPreferredSize(new Dimension(600, 140));
		payRecordPanel.add(payRecordLabel);
		payRecordPanel.add(Box.createRigidArea(new Dimension(580, 5)));

		payRecordPanel.add(label13);
		payRecordPanel.add(field11);
		payRecordPanel.add(label14);
		payRecordPanel.add(field12);
		payRecordPanel.add(label15);
		payRecordPanel.add(field13);
		payRecordPanel.add(Box.createRigidArea(new Dimension(50, 0)));
		payRecordPanel.add(label16);
		payRecordPanel.add(field14);
		payRecordPanel.add(label17);
		payRecordPanel.add(field15);
		payRecordPanel.add(Box.createRigidArea(new Dimension(580, 5)));
		payRecordPanel.add(addPayRecordButton);

		//Layout for output panel

		outputPanel.setPreferredSize(new Dimension(50, 200));
		outputPanel.setLayout(new BorderLayout());
		outputPanel.add(recordStatusLabel, BorderLayout.NORTH);
		outputPanel.add(scrollPane, BorderLayout.CENTER);
		outputPanel.revalidate();
		outputPanel.add(closeButton, BorderLayout.SOUTH);

		//03/21/2016
		//using BoxLayout for 5 panel format
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(employeePanel);
		add(addressPanel);
		add(payPeriodPanel);
		add(payRecordPanel);
		add(outputPanel);
		
		//set payRecordPanel and payPeriodPanel editable to false when program begins
		for (Component cp : payRecordPanel.getComponents() ){
			cp.setEnabled(false);
		}

		for (Component cp : payPeriodPanel.getComponents() ){
			cp.setEnabled(false);
		}
	

	}// end of Layout method


	//addEmployee method start
	void addEmployee(){

		String input = "";
		String inputFName = "";
		String inputLName = "";
		String inputStreet = "";
		String inputHouseNumber = "";
		String inputCity = "";
		int inputZipCode = 0;
		


		while (Employee.getNoOfEmployees() < 10) {

			//id for employee validation
			try {
				input = field1.getText();
				inputID = Integer.parseInt(input);
			}
			catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Please enter only numbers for ID (ex:123)");
				field1.setText("");
				field1.requestFocus();
				break;
			}

			//first name and last name validation
			inputFName = field2.getText();
			inputLName = field3.getText();
			if (field2.getText().equalsIgnoreCase("")) {
				JOptionPane.showMessageDialog(null, "Please enter your first name!");
				field2.requestFocus();
				break;
			}
			else if (field3.getText().equalsIgnoreCase("")) {
				JOptionPane.showMessageDialog(null, "Please enter your last name!");
				field3.requestFocus();
				break;
			}

			//employee status validation
			if (button1.isSelected() == false && button2.isSelected() == false) {
				JOptionPane.showMessageDialog(null, "Please select employee status!");
				break;
			}

			//street of address validation
			inputStreet = field4.getText();

			if (field4.getText().equalsIgnoreCase("")) {
				JOptionPane.showMessageDialog(null, "Please enter your street of address!");
				field4.requestFocus();
				break;
			}

			//house number of address validation
			try {
				inputHouseNumber = field5.getText();

			}
			catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Please enter your house number correctly!");
				field5.setText("");
				field5.requestFocus();
				break;
			}

			//city of address validation
			inputCity = field6.getText();

			if (field6.getText().equalsIgnoreCase("")) {
				JOptionPane.showMessageDialog(null, "Please enter your city of address!");
				field6.requestFocus();
				break;
			}

			//state of address validation
			if (combList.getSelectedItem().toString().compareToIgnoreCase("") == 0) {
				JOptionPane.showMessageDialog(null, "Please select your state of address!");
				break;
			}


			//zip code of address
			try {
				input = field7.getText();

				if (input.length() == 5) {
					inputZipCode = Integer.parseInt(input);
				}
				else {
					JOptionPane.showMessageDialog(null, "Please enter your zipcode with correctly 5 numbers (Ex: 80526)");
					field7.setText("");
					field7.requestFocus();
					break;
				}	
			}
			catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Please enter your zipcode number correctly (Ex: 80526)");
				field7.setText("");
				field7.requestFocus();
				break;
			}

			//creating new address object
			Address address = new Address(inputStreet, inputHouseNumber, inputCity, inputState, inputZipCode);

			//adding new employee data into employees array by calling createEmployee method in PayRoll class
			myEmp = payRoll.createEmployee(inputID, inputFName, inputLName, inputStatus, address);

			//reset the user input to null
			field1.setText(null);
			field2.setText(null);
			field3.setText(null);
			field4.setText(null);
			field5.setText(null);
			field6.setText(null);
			field7.setText(null);
			combList.setSelectedItem("");

			//set payRecordPanel and payPeriodPanel editable and set addEmployeePanel and addressPanel disable after addEmployee method
			for (Component cp : payRecordPanel.getComponents()) {
				cp.setEnabled(true);
			}

			for (Component cp : payPeriodPanel.getComponents()) {
				cp.setEnabled(true);
			}

			for (Component cp : employeePanel.getComponents()) { 
				cp.setEnabled(false);
			}

			for (Component cp : addressPanel.getComponents()) {
				cp.setEnabled(false);
			}

			button1.setEnabled(false);
			button2.setEnabled(false);

			// passing the employee id from employeePanel to the id field of payRecordPanel
			field11.setText(String.valueOf(myEmp.geteID()));
			field11.setEnabled(false);
			field8.requestFocus();

			//output employee information on textArea
			textArea.append("\n" + myEmp.toString());
			textArea.append("\n" + "The number of employee stored:" + Employee.getNoOfEmployees());

			break;	
		}// end while loop

		if (Employee.getNoOfEmployees() == 10) {
			addEmployeeButton.setEnabled(false);//disable button when get the max of employee numbers
		}

	}// end of addEmployee action event method


	//addPayRecord method start
	@SuppressWarnings("deprecation")
	void addPayRecord() {

		String input = "";
		String input1 = "";
		int pid = 0;
		Date startDate = null; 
		Date endDate = null;
		double monthlyIncome = 0;
		int numberOfMonth = 0;
		double hours = 0;
		double rates = 0;

		while (PayRecord.getNoOfPayRecords() < 10) {
			//id for pay period validation
			try {
				input1 = field8.getText();
				pid = Integer.parseInt(input1);
			}
			catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Please enter your pay period id!");
				field8.setText("");
				field8.requestFocus();
				break;
			}

			//start date validation
			input = field9.getText();
			if (input.matches("^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$")) {

				sDate=new Date(input);
				sMonth= sDate.getMonth();
				sYear = sDate.getYear();
				sDay = sDate.getDay();
			}
			else {
				JOptionPane.showMessageDialog(null, "Please enter your start month with specific format (Ex: 03/31/2017)");
				field9.setText("");
				field9.requestFocus();
				break;
			}

			//end date validation
			input = field10.getText();
			if (input.matches("^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$")) {

				eDate=new Date(input);
				eMonth= eDate.getMonth();
				eYear = eDate.getYear();
				eDay = eDate.getDay();

				if(eDate.before(sDate))
					try {
						throw new Exception();
					} 
				catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Please enter a valid end date after start date.");
					field10.setText("");
					field10.requestFocus();
					break;
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "Please enter a valid end month with specific format (Ex: 03/31/2017)");
				field10.setText("");
				field10.requestFocus();
				break;
			}

			//creating new PayPeriod object
			PayPeriod myPeriod = new PayPeriod(pid, sDate, eDate);

			if (myEmp.getEmpStatus()==Status.FullTime) {//Full time situation
				//monthly income validation
				try {
					input = field12.getText();
					monthlyIncome = Double.parseDouble(input);
				}
				catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Please enter your monthly income (Ex: 350.50)");
					field12.setText("");
					field12.requestFocus();
					break;
				}
				//number of month validation
				try {
					input = field13.getText();
					numberOfMonth = Integer.parseInt(input);
					if (eYear > sYear) {
						eMonth += (eYear - sYear) * 12;

					}
					if(numberOfMonth > eMonth - sMonth)
						throw new Exception();

				}
				catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Please enter the correct number of months!");
					field13.setText("");
					field13.requestFocus();
					break;
				}

				//adding new pay record into payRecords array by calling createPayRecord method from PayRoll class
				payRoll.createPayRecord(inputID, myEmp, myPeriod, monthlyIncome, numberOfMonth);	
			}

			else {//Hourly situation

				//pay hours validation
				try {
					input = field14.getText();
					hours = Double.parseDouble(input);
					if (eYear > sYear) {
						eMonth += (eYear - sYear) * 12;
					}
					
					if (hours > ((eMonth - sMonth) * 30) * 24 + (eDay - sDay) * 24) {
						throw new Exception();
						
					}
				}
				catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Please enter a valid number of hours (Ex: 36)");
					field14.setText("");
					field14.requestFocus();
					break;
				}
				//pay rates validation
				try {
					input = field15.getText();
					rates = Double.parseDouble(input);
				}
				catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Please enter your pay rates (Ex: 0.15)");
					field15.setText("");
					field15.requestFocus();
					break;
				}

				//adding new pay record into payRecords array by calling createPayRecord method from PayRoll class
				payRoll.createPayRecord(inputID, myEmp, myPeriod, hours, rates);	
			}

			//reset user input to null
			field8.setText(null);
			field9.setText(null);
			field10.setText(null);
			field11.setText(null);
			field12.setText(null);
			field13.setText(null);
			field14.setText(null);
			field15.setText(null);

			//set payRecordPanel and payPeriodPanel disable and set addEmployeePanel and addressPanel editable after addPayRecord method
			for (Component cp : payRecordPanel.getComponents()) {
				cp.setEnabled(false);
			}

			for (Component cp : payPeriodPanel.getComponents()) {
				cp.setEnabled(false);
			}

			for (Component cp : employeePanel.getComponents()) {
				cp.setEnabled(true);
			}

			for (Component cp : addressPanel.getComponents()) {
				cp.setEnabled(true);
			}

			button1.setEnabled(true);
			button2.setEnabled(true);
			field1.requestFocus();

			//output payRecord on textArea
			textArea.append("\n" + payRoll.displayPayRecord());
			textArea.append("\n" +  String.format("%s$%.2f", "Average Net Pay: ", payRoll.avgNetPay()));
			textArea.append("\n" + "The number of payrecord stored: " + PayRecord.getNoOfPayRecords());
			payRoll.writeToFile();

			break;
		}//end of while loop
		if (PayRecord.getNoOfPayRecords() == 10) {
			//addPayRecordButton.setEnabled(false);
			//addEmployeeButton.setEnabled(false);
			button1.setEnabled(false);
			button2.setEnabled(false);
			for (Component cp : employeePanel.getComponents()) {
				cp.setEnabled(false);
			}

			for (Component cp : addressPanel.getComponents()) {
				cp.setEnabled(false);
			}
			JOptionPane.showMessageDialog(null, "You have reached the maxinum of data input!");
		}


	}//end of addPayReocrd action event method

	void radioButton() {
		if (button1.isSelected()) {
			field14.setEditable(false);
			field15.setEditable(false);
			field12.setEditable(true);
			field13.setEditable(true);
			inputStatus = Status.FullTime;
		}
		else if (button2.isSelected()) {
			field12.setEditable(false);
			field13.setEditable(false);
			field14.setEditable(true);
			field15.setEditable(true);
			inputStatus = Status.Hourly;
		}
		else {
			field14.setEditable(true);
			field15.setEditable(true);
			button2.setEnabled(true);
			button1.setEnabled(true);

		}

	}//end of radioButton action event method

	void combobox() {
		inputState = combList.getSelectedItem().toString();
	}//end of combo box method



	void close(){
		JOptionPane.showMessageDialog(null, "GoodBye");
		System.exit(0);
	}// end of close action event method


	public static void main(String[] args) {
		JFrame f = new JFrame("Pay Roll");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		PayRoll pR = new PayRoll("PayRoll.txt");
		Container contentPane = f.getContentPane(); 
		contentPane.add( new UserGUI(pR));
		BoxLayout boxLayout = new BoxLayout(contentPane, BoxLayout.Y_AXIS);
		f.setLayout(boxLayout);
		f.pack();
		//f.setSize(580, 500);
		f.setVisible(true);


	}

}
