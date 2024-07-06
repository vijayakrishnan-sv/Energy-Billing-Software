package application;

import java.io.Serializable;

/**
 * stores information of each book
 */

public class User implements Serializable {
	private String name;
	private String accountNo;
	private String phoneNo;
	private String address;
	private String pincode;
	private String email;
	private String meterType;
	private String tariff;
	private String houseNO;
	private double initMeterReading;
	private double gasReading;
	private static int userCount = 0;
	
	//public User(String name, String phoneNo, String address, String pincode, String email, String meterType, String tariff ) {
	//	this.name = name;
	//	this.phoneNo = phoneNo;
	//	this.address = address;
	//	this.pincode = pincode;
	//	this.email = email;
	//	this.meterType = meterType;
	//	this.tariff = tariff;
	//}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMeterType() {
		return meterType;
	}

	public void setMeterType(String meterType) {
		this.meterType = meterType;
	}

	public String getTariff() {
		return tariff;
	}
	public String getHouseNo() {
		return houseNO;
	}

	public void setHouseNo(String houseNo) {
		this.houseNO = houseNo;
	}

	public static void setUserCount(int userCount) {
		User.userCount = userCount;
	}

	public static int getUserCount() {
		return userCount;
	}

	public void setTariff(String tariff) {
		this.tariff = tariff;
		
	}
	public  double getInitMeterReading() {
		return this.initMeterReading;
	}

	public void setInitMeterReading(double initReading) {
		this.initMeterReading = initReading;
		
	}
	public  String getAccountNo() {
		return this.accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
		
	}
	public  double getGasReading() {
		return this.gasReading;
	}

	public void setGasReading(double gasReading) {
		this.gasReading = gasReading;
		
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", accountNo=" + accountNo + ", phoneNo=" + phoneNo + ", address=" + address
				+ ", pincode=" + pincode + ", email=" + email + ", meterType=" + meterType + ", tariff=" + tariff
				+ ", houseNO=" + houseNO + ", initMeterReading=" + initMeterReading + ", gasReading=" + gasReading
				+ "]";
	}


}
