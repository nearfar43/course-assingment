//*******************************************************************************
//* 																			*
//* 			CIS611 Spring 2017 Anand RameshKannan, Jeffrey Cheng			*		
//* 																			*	
//* 						Program Project PP3					 				*
//* 																 			*
//* 				Person class contains fName lName and address 				*
//*																				*	
//* 																 			*
//* 					Date Created: 03.25.2017 					 			*
//*						Saved in: Person.java		 	 						*
//* 																 			*
//*******************************************************************************
package PP03;

public class Person {
	
	protected String fName ;
    protected String lName ;
    protected Address address;
    
    public Person(){
    	
    }
    
	public Person(String fName, String lName, Address address) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.address = address;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAdsress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person [fName=" + fName + ", lName=" + lName + ", address=" + address + "]";
	}
    

}
