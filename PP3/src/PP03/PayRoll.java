//*******************************************************************************
//* 																			*
//* 			CIS611 Spring 2017 Anand RameshKannan, Jeffrey Cheng			*		
//* 																			*	
//* 						Program Project PP3					 				*
//* 																 			*
//* 			PayRoll class has most of all methods relates to UserGUI 		*
//*					like addEmployee and addpayRecord							*
//*																				*	
//* 																 			*
//* 					Date Created: 03.25.2017 					 			*
//*						Saved in: PayRoll.java		 	 						*
//* 																 			*
//*******************************************************************************
package PP03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class PayRoll {

	private static final int NUM_PAY_EMP_RECORDS = 10; 

	private String fileName;
	private PayRecord[] payRecords;
	private Employee[] employees;


	private  double totalNetPay;
	private  double avgNetPay;

	public PayRoll(String fileName){

		this.fileName = fileName;
		payRecords = new PayRecord[NUM_PAY_EMP_RECORDS]; 
		employees = new Employee[NUM_PAY_EMP_RECORDS];

	}


	@SuppressWarnings("deprecation")
	public void readFromFile(String fileName) throws IOException {
		// read the initial data from PayRoll file to create the full 
		// pay records with gross pay, taxes, and net pay, and then store it in PayRecord.txt file
		Status emp;
		Address address = null;
		PayPeriod payPeriod;
		Date sDate;
		Date eDate;
		double mIncome = 0;
		int mNum = 0;
		double hours = 0;
		double rate = 0;

		FileInputStream fis=new FileInputStream(fileName);
		BufferedReader br=new BufferedReader(new InputStreamReader(fis));
		String line;
		while ((line = br.readLine()) != null) {

			if(line.startsWith("e") || line.startsWith("E")) {
				String words[]=line.replaceAll("\\s+", "").split(",");
				if(words[4].equalsIgnoreCase("FULLTIME")) {
					emp=Status.FullTime;
				}
				else {
					emp=Status.Hourly;
				}

				String street = words[5];
				String aptNumber = words[6];
				String city = words[7];
				String state = words[8];
				int zip = Integer.parseInt(words[9]);


				address = new Address(street, aptNumber, city, state, zip);

				//creating new employee object by calling createEmployee method
				createEmployee(Integer.parseInt(words[1]),words[2],words[3],emp,address);
				//message
				JOptionPane.showMessageDialog(null, "The new employee data is stored!");
				JOptionPane.showMessageDialog(null, employees[Employee.getNoOfEmployees()-1].toString());


			}

			else if (line.startsWith("p") || line.startsWith("P")) {
				
				String str [] = line.replaceAll("\\s+", "").split(",");
				
				if (str[3].contains("<m>")) {
					mIncome = Double.parseDouble(str[3].replaceAll("m", "").replaceAll("<", "").replaceAll(">", ""));
					mNum = Integer.parseInt(str[4].replaceAll("n", "").replaceAll("<", "").replaceAll(">", ""));


					sDate = new Date(str[6]);
					eDate = new Date(str[7]);

					payPeriod = new PayPeriod(Integer.parseInt(str[1]), sDate, eDate);
					//creating new pay record object by calling createPayRecord method for fullTime
					createPayRecord(Integer.parseInt(str[2]), employees[PayRecord.getNoOfPayRecords()], payPeriod, mIncome, mNum);
					//message
					JOptionPane.showMessageDialog(null, "The new pay record data is stored!");
					JOptionPane.showMessageDialog(null, displayPayRecord());
					JOptionPane.showMessageDialog(null, String.format("%s $%.2f", "The average net pay is: ", avgNetPay()));

				}
				else if (str[3].contains("<h>")) {
					hours = Double.parseDouble (str[3].replaceAll("h", "").replaceAll("<", "").replaceAll(">", ""));
					rate = Double.parseDouble (str[4].replaceAll("r", "").replaceAll("<", "").replaceAll(">", ""));

					sDate = new Date(str[6]);
					eDate = new Date(str[7]);
					payPeriod = new PayPeriod(Integer.parseInt(str[1]), sDate, eDate);
					
					//creating new pay record object by calling createPayRecord method for hourly
					createPayRecord(Integer.parseInt(str[2]), employees[PayRecord.getNoOfPayRecords()], payPeriod, hours, rate);

					//message
					JOptionPane.showMessageDialog(null, "The new pay record data is stored!");
					JOptionPane.showMessageDialog(null, displayPayRecord());
					JOptionPane.showMessageDialog(null, String.format("%s $%.2f", "The average net pay is: ", avgNetPay()));

				}
			}	

		}
		br.close();
	}




	public void writeToFile(){

		// write employees' pay records to the PayRecord.txt file, it should add employee pay record to the current file data
		String fileName = "PayRecord" + ".txt";
		java.io.File file = new java.io.File(fileName);
		java.io.PrintWriter output1 = null;
		try {//throw FileNotFound exception
			output1 = new java.io.PrintWriter(file);
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < PayRecord.getNoOfPayRecords(); i++) {
			if (payRecords[i] !=null) {
				if (payRecords[i].getEmployee().getEmpStatus() == Status.FullTime) {
					output1.print("Employee" + ":" + "\t" + payRecords[i].getEmployee().geteID() + "," + "\t"+ payRecords[i].getEmployee().getfName() + "," + "\t" +
							payRecords[i].getEmployee().getlName() +"," + "\t" + payRecords[i].getEmployee().getEmpStatus() +"," + "\t" + payRecords[i].getEmployee().getAddress() + "\n" +
							"PayRecord" + ":" + "\t" + payRecords[i].getPayPeriod().getpID() + "," + "\t" + payRecords[i].getrID() + "," + "\t" +
							payRecords[i].getMontlyIncome() + "<m>" + "," + "\t" + payRecords[i].getNumMonths() + "<n>" + "," + "\t" +
							payRecords[i].getPayPeriod().toString() + "\n");
				}
				else if (payRecords[i].getEmployee().getEmpStatus() == Status.Hourly ){
					output1.print("Employee" + ":" + "\t" + payRecords[i].getEmployee().geteID() + "," + "\t" + payRecords[i].getEmployee().getfName() + "," + "\t" +
							payRecords[i].getEmployee().getlName() +"," + "\t"+ payRecords[i].getEmployee().getEmpStatus() + "," + "\t" + payRecords[i].getEmployee().getAddress() + "\n" +
							"PayRecord" + ":" + "\t" + payRecords[i].getPayPeriod().getpID() + "," + "\t" + payRecords[i].getrID() + "," +  "\t" +
							payRecords[i].getPayHours() + "<h>" + "," + "\t" + payRecords[i].getPayRate() + "<r>" + "," + "\t" +
							payRecords[i].getPayPeriod().toString() + "\n");
				}
			}
		}
		output1.close();

	} 

	// creates a new Employee object and add it to the employees array, you need to pass parameters to this method
	@SuppressWarnings("static-access")
	public Employee createEmployee(int eID, String fName, String lName, Status empStatus, Address address){

		Employee employee = new Employee (eID, fName, lName, empStatus, address);

		if (employee.getNoOfEmployees() <= 10) {

			employees[employee.getNoOfEmployees()-1] = employee;

		}
		return employee;

	}

	// creates a new PayRecord for an Employee object and add it to  the payRecords array, you need to pass parameters to this method

	@SuppressWarnings("static-access")
	public void createPayRecord(int id, Employee employee, PayPeriod period, double hours, double rate){


		if (PayRecord.getNoOfPayRecords() < 10) {

			if(employees[PayRecord.getNoOfPayRecords()].getEmpStatus() == Status.FullTime) {

				PayRecord payrecord = new PayRecord (id, employee, period, hours, (int) rate);

				payRecords[PayRecord.getNoOfPayRecords()-1]= payrecord;
			}
			
			else if (employees[PayRecord.getNoOfPayRecords()].getEmpStatus() == Status.Hourly) {
				PayRecord payrecord = new PayRecord (id, employee, period, hours, rate);
				payRecords[PayRecord.getNoOfPayRecords()-1] = payrecord;	
			}
		}
	}

	// it shows all payroll records for all currently added employee and the total net pay and average net pay in the GUI text area
	// at should append data to text area, it must not overwrite data in the GUI text area

	public String displayPayRecord(){

		String payDetails="";
		for (int i = 0; i < PayRecord.getNoOfPayRecords(); i++) {
			payDetails = payRecords[i].toString();
		}
		return payDetails;


	}

	// returns the average of the total net pay of all added employees
	public double avgNetPay(){


		int i = PayRecord.getNoOfPayRecords() - 1;
			totalNetPay+= payRecords[i].netPay();
		
		avgNetPay = totalNetPay / PayRecord.getNoOfPayRecords();
		
		return avgNetPay;
	}

}

