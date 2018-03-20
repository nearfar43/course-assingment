//*******************************************************************************
//* 																			*
//* 			CIS611 Spring 2017 Anand RameshKannan, Jeffrey Cheng			*		
//* 																			*	
//* 						Program Project PP3					 				*
//* 																 			*
//* 			TaxIncome class implements Taxable class for					*
//*					calculating taxValue										*
//*																				*	
//* 																 			*
//* 					Date Created: 03.25.2017 					 			*
//*						Saved in: TaxIncome.java		 	 					*
//* 																 			*
//*******************************************************************************
package PP03;

public class TaxIncome implements Taxable{

	@Override
	public double compStateTax(double grossPay) {

		double taxValue;
		taxValue = grossPay*STATE_TAX;
		return taxValue;
	}

	@Override
	public double compFederalTax(double grossPay) {

		double taxValue;
		taxValue = grossPay*FEDERAL_TAX;
		return taxValue;
	}

	@Override
	public double compIncomeTax(double grossPay) {
		// TODO Auto-generated method stub
		double taxValue;
		
		taxValue= compStateTax(grossPay)+compFederalTax(grossPay);
		return taxValue;
	}
	
	

	// 1- this class implements the Taxable interface
	// 2- implement all the unimplemented abstract methods in the Taxable Interface, income tax is computed based on state and federal taxes   
	

}
