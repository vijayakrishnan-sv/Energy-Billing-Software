package application;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BillAndPaymentList implements Serializable {

	/**
	 * defines a list of all students
	 */
	
	private static final long serialVersionUID = 1L;
	private List<BillAndPayment> billList;

	public BillAndPaymentList() {
		billList = new ArrayList<BillAndPayment>();
	}

	public List<BillAndPayment> getBills() {
		return billList ;
	}

	public void addBill(BillAndPayment s) {
		billList.add(s);
	}

}
