package application;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserList implements Serializable {

	/**
	 * defines a list of all students
	 */
	
	private static final long serialVersionUID = 1L;
	private List<User> userList;

	public UserList() {
		userList = new ArrayList<User>();
	}

	public List<User> getUsers() {
		return userList;
	}

	public void addUser(User s) {
		userList.add(s);
	}

}
