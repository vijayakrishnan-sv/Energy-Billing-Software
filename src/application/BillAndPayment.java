package application;

import java.io.Serializable;
import java.time.LocalDate;

public class BillAndPayment implements Serializable{
	private String billNo;
	private String accountNo;
	private LocalDate startDate;
	private LocalDate endDate;
	private double EleStartReading;
	private double EleEndReading;
	private double gasStartReading;
	private double gasEndReading;
	private double amount;
	private boolean payment;
	private String paymentText;
	
	
	public String getPaymentText() {
		return paymentText;
	}

	public void setPaymentText(String paymentText) {
		this.paymentText = paymentText;
	}

	private LocalDate billDate;

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	private static int billCount = 0;
	
	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public double getEleStartReading() {
		return EleStartReading;
	}

	public void setEleStartReading(double eleStartReading) {
		this.EleStartReading = eleStartReading;
	}

	public double getEleEndReading() {
		return EleEndReading;
	}

	public void setEleEndReading(double eleEndReading) {
		this.EleEndReading = eleEndReading;
	}

	public double getGasStartReading() {
		return gasStartReading;
	}

	public void setGasStartReading(double gasStartReading) {
		this.gasStartReading = gasStartReading;
	}

	public double getGasEndReading() {
		return gasEndReading;
	}

	public void setGasEndReading(double gasEndReading) {
		this.gasEndReading = gasEndReading;
	}

	public boolean isPayment() {
		return payment;
	}

	public void setPayment(boolean payment) {
		this.payment = payment;
	}

	public static int getBillCount() {
		return billCount;
	}

	public static void setBillCount(int billCount) {
		BillAndPayment.billCount = billCount;
	}
	public void setBillNo() {
		this.billNo = this.accountNo + ( billCount + 1 );
		BillAndPayment.billCount += 1;
	}
	public LocalDate getBillDate() {
		return billDate;
	}

	public void setBillDate() {
		this.billDate = LocalDate.now();
	}

	public String getBillNo() {
		return this.billNo;
	}

	@Override
	public String toString() {
		return "BillAndPayment [billNo=" + billNo + ", accountNo=" + accountNo + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", EleStartReading=" + EleStartReading + ", EleEndReading=" + EleEndReading
				+ ", gasStartReading=" + gasStartReading + ", gasEndReading=" + gasEndReading + ", amount=" + amount
				+ ", payment=" + payment + ", paymentText=" + paymentText + ", billDate=" + billDate + "]";
	}

	
	
	
	}


