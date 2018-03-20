//*******************************************************************************
//* 																			*
//* 			CIS611 Spring 2017 Anand RameshKannan, Jeffrey Cheng			*		
//* 																			*	
//* 						Program Project PP3					 				*
//* 																 			*
//* 				Address class contains address information 					*
//*																				*	
//* 																 			*
//* 					Date Created: 03.25.2017 					 			*
//*						Saved in: Address.java		 	 						*
//* 																 			*
//*******************************************************************************
package PP03;

public class Address {
	
	private String street;
	private String houseNumber;//
	private String city;
	private String state;
	private int zipCode;
	
	
	public Address(String street, String houseNumber, String city, String state, int zipCode) {
		this.street = street;
		this.houseNumber = houseNumber;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public String getHouseNumber() {
		return houseNumber;
	}


	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public int getZipCode() {
		return zipCode;
	}


	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}


	@Override
	public String toString() {
		return street + "," + "\t" + houseNumber + "," + "\t" + city + "," + "\t" + state + "," + "\t" + zipCode;
	}
	
	
	

}
