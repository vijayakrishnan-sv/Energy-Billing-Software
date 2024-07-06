package application;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AdminList implements Serializable {

	/**
	 * defines a list of all students
	 */
	
	private static final long serialVersionUID = 1L;
	private List<Admin> adminList;

	public AdminList() {
		adminList = new ArrayList<Admin>();
	}

	public List<Admin> getAdmins() {
		return adminList;
	}

	public void addAdmin(Admin s) {
		adminList.add(s);
	}

}
