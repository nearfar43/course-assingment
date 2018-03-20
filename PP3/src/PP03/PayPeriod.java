//*******************************************************************************
//* 																			*
//* 			CIS611 Spring 2017 Anand RameshKannan, Jeffrey Cheng			*		
//* 																			*	
//* 						Program Project PP3					 				*
//* 																 			*
//* 			PayPeriod class contains pID  pStartDate and pEndDate 			*
//*																				*
//*																				*	
//* 																 			*
//* 					Date Created: 03.25.2017 					 			*
//*						Saved in: PayPeriod.java		 	 					*
//* 																 			*
//*******************************************************************************
package PP03;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class PayPeriod {
	
	private int pID;
    private Date pStartDate, pEndDate;
    
    // 1- add the class constructor
	
    public PayPeriod(int pID, Date pStartDate, Date pEndDate) {
		super();
		this.pID = pID;
		this.pStartDate = pStartDate;
		this.pEndDate = pEndDate;
	}
   
    public PayPeriod() {
    	this(0,null,null);
    }
    
    // 2- add the setters/getters methods

	public int getpID() {
		return pID;
	}
	public void setpID(int pID) {
		this.pID = pID;
	}
	public Date getpStartDate() {
		return pStartDate;
	}
	public void setpStartDate(Date pStartDate) {
		this.pStartDate = pStartDate;
	}
	public Date getpEndDate() {
		return pEndDate;
	}
	public void setpEndDate(Date pEndDate) {
		this.pEndDate = pEndDate;
	}

    // 3- add override method toString() 
	
	@Override
	public String toString() {
		String outputSDate = "";
		String outputEDate = "";
		Calendar cal = new GregorianCalendar();
		cal.setTime(pStartDate);
		int sYear = cal.get(Calendar.YEAR);
		int sMonth = cal.get(Calendar.MONTH) + 1;
		int sDay = cal.get(Calendar.DAY_OF_MONTH);
		cal.setTime(pEndDate);
		int eYear = cal.get(Calendar.YEAR);
		int eMonth = cal.get(Calendar.MONTH) + 1;
		int eDay = cal.get(Calendar.DAY_OF_MONTH);
		
		outputSDate = sMonth + "/" + sDay + "/" + sYear;
		outputEDate = eMonth + "/" + eDay + "/" + eYear;
		return "Pay Period: " + "\t" + "ID:" + pID + "," + "\t" + outputSDate + "," + "\t" + outputEDate;
	}
	
	
}
