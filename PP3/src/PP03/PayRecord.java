//*******************************************************************************
//* 																			*
//* 			CIS611 Spring 2017 Anand RameshKannan, Jeffrey Cheng			*		
//* 																			*	
//* 						Program Project PP3					 				*
//* 																 			*
//* 			PayRecord class has netPay method and most of  					*
//*					calculation	method											*
//*																				*	
//* 																 			*
//* 					Date Created: 03.25.2017 					 			*
//*						Saved in: PayRecord.java		 	 					*
//* 																 			*
//*******************************************************************************
package PP03;


public class PayRecord {

	private int rID;
	private Employee employee;
	private PayPeriod payPeriod;
	private TaxIncome payTax;

	private double payHours;
	private double payRate;

	private double montlyIncome;
	private int numMonths;
	
	private double taxValue;

	private static int noOfPayRecords;   


	public static final int REG_HOURS = 40;
	public static final double OT_RATE = 1.25;

	// pay record constructor for hourly employee
	public PayRecord(int id, Employee e, PayPeriod period, double hours, double rate){

		this.rID = id;
		this.employee = e;
		this.payPeriod = period;
		this.payHours = hours;
		this.payRate = rate;
		this.montlyIncome = 0;
		this.numMonths = 0;
		this.payTax = new TaxIncome();
		noOfPayRecords++;

	}

	// pay record constructor for full time employee
	public PayRecord(int id, Employee e, PayPeriod period, double mIncome, int mNum){

		this.rID = id;
		this.employee = e;
		this.payPeriod = period;
		this.payHours = 0;
		this.payRate = 0;
		this.montlyIncome = mIncome;
		this.numMonths = mNum;
		this.payTax = new TaxIncome();
		noOfPayRecords++;
	}




	// 1- add setters and getters methods
	// 2- add override method toString()
	// 3- complete the code in the following methods: grossPay() and netPay()

	public int getrID() {
		return rID;
	}

	public void setrID(int rID) {
		this.rID = rID;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public PayPeriod getPayPeriod() {
		return payPeriod;
	}

	public void setPayPeriod(PayPeriod payPeriod) {
		this.payPeriod = payPeriod;
	}

	public TaxIncome getPayTax() {
		return payTax;
	}

	public void setPayTax(TaxIncome payTax) {
		this.payTax = payTax;
	}

	public double getPayHours() {
		return payHours;
	}

	public void setPayHours(double payHours) {
		this.payHours = payHours;
	}

	public double getPayRate() {
		return payRate;
	}

	public void setPayRate(double payRate) {
		this.payRate = payRate;
	}

	public double getMontlyIncome() {
		return montlyIncome;
	}

	public void setMontlyIncome(double montlyIncome) {
		this.montlyIncome = montlyIncome;
	}

	public int getNumMonths() {
		return numMonths;
	}

	public void setNumMonths(int numMonths) {
		this.numMonths = numMonths;
	}

	public static int getNoOfPayRecords() {
		return noOfPayRecords;
	}

	public static void setNoOfPayRecords(int noOfPayRecords) {
		PayRecord.noOfPayRecords = noOfPayRecords;
	}

	public static int getRegHours() {
		return REG_HOURS;
	}

	public static double getOtRate() {
		return OT_RATE;
	}


	@Override
	public String toString() {

			if(this.getEmployee().getEmpStatus() == Status.FullTime)  {
				return "PayRecord: " + "\t" + "ID: " + rID + "," + "\t" + "\n" + payPeriod.toString() + "\n" + "Monthly Income: "
						+ montlyIncome + "," + "\t" + "Number of Month: " + numMonths + "," + "\t" + 
						String.format("%s $%.2f", "Tax Value: ", payTax.compIncomeTax(grossPay())) + "," + "\t" + "\n" +
						String.format("%s $%.2f", "Net Pay: ", netPay());
			}
			else	{
				return "PayRecord: " + "\t" + "ID: " + rID + "," + "\t" + "\n" + payPeriod.toString() + "\n" + "Pay Hours: "
						+ payHours + "," + "\t" + "Pay Rate: " + payRate + "," + "\t" + 
						String.format("%s $%.2f", "Tax Value: ", payTax.compIncomeTax(grossPay())) + "," + "\t" + "\n" +
						String.format("%s $%.2f", "Net Pay: ", netPay());
			}	
			
	}

	// complete the code to compute the gross pay for the employee based on the employee status
	public double grossPay(){
		double grossPay;
		if(this.employee.getEmpStatus() == Status.FullTime) {
			grossPay = numMonths * montlyIncome;
		}
		else {
			if(payHours <= 40) {
				grossPay = payHours * payRate;
			}
			else {
				grossPay=(REG_HOURS*payRate)+((payHours-REG_HOURS)*OT_RATE);
			}

		}
		return grossPay;

	}

	// complete the code in this method to compute the net pay of the employee after taxes (state and federal)
	public double netPay(){
		taxValue = payTax.compIncomeTax(grossPay());
		return grossPay()- taxValue;
	}



}
