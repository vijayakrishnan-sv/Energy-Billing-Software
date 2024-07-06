package application;

import java.io.Serializable;

public class Admin implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userName;
	private String password;
		
	private static int adminCount = 0;

	public Admin() {
		this.userName ="";
		this.password = "";
	}

	public String getUserName() {
		return this.userName;
	}
	
	public String getPassword() {
		return this.password;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public static int getadminCount() {
		return adminCount;
	}

	public static void setadminCount(int count) {
		Admin.adminCount = count;
	}

}
