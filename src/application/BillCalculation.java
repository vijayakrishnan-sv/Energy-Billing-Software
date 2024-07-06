package application;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class BillCalculation {
	private static UserList uList;
	private User user;
	
	public static User getUserDetails(BillAndPayment obj) throws ClassNotFoundException, IOException {
		User userObj = new User();
		uList = DataHandler.readUserList(); // read existing student list from file
    	for (int i=0; i<uList.getUsers().size();i++) {
    		User  c = uList.getUsers().get(i);
    		String key = c.getAccountNo();
    		if(key.equals(obj.getAccountNo())) {
    			userObj = c;
    		}
    	}
		return userObj;
	}
	
	public static double gatTariffValue(BillAndPayment obj) throws ClassNotFoundException, IOException {
		User userObj;
		userObj = getUserDetails(obj);
		double tariffValue = 0.00;
		if(userObj.getTariff().equals("normal")) {
			tariffValue = Tariff.getNormal();
		}
		else {
			tariffValue = Tariff.getStandard();
		}
		return tariffValue;
	}
	
	public static String gatTariffName(BillAndPayment obj) throws ClassNotFoundException, IOException {
		User userObj;
		userObj = getUserDetails(obj);
		String tariff = "";
		if(userObj != null) {
			tariff = userObj.getTariff();
		}
		return tariff;
	}
	
	public static String getDateFormator(LocalDate date) {
		String formattedString = date.format(DateTimeFormatter.ofPattern("dd/MM/yy"));
		return formattedString;
	}
	
	
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = BigDecimal.valueOf(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
	
	public static double electricityUsageChargeCalculation(BillAndPayment obj) throws ClassNotFoundException, IOException {
		
		double reading = obj.getEleEndReading() - obj.getEleStartReading();
		double tariffValue = gatTariffValue(obj);
		System.out.println(obj.getEleEndReading() );
		System.out.println(obj.getEleStartReading());
		System.out.println("usageCharge "+ reading + tariffValue);

		
		return round(tariffValue*reading,2 );
	}
	
	public static double electricityTotalAmount(BillAndPayment obj) throws ClassNotFoundException, IOException {
		double supply= electricitySupplyChargeCalculation(obj);
		double vatCharge = electricityVatCalculation(obj);
		double totalAmount = electricitySupplyChargeCalculation(obj) + vatCharge;
		return round(totalAmount,2);
	}
	
	public static double electricityStandingChargeCalculation(BillAndPayment obj) {
		double diff = dateBetweenDays(obj);
		double value = ( diff * Tariff.getStandingCharg() )/100;
		return round(value,2);
	}
	
	public static double electricitySupplyChargeCalculation(BillAndPayment obj) throws ClassNotFoundException, IOException {
		double usageCharge = electricityUsageChargeCalculation(obj);
		double standingCharge = electricityStandingChargeCalculation(obj);
		return round( usageCharge + standingCharge, 2);
	}
	
	public static double electricityVatCalculation(BillAndPayment obj) throws ClassNotFoundException, IOException {
		double supplyCharge = electricitySupplyChargeCalculation(obj);
		double vatCharge = ( supplyCharge) * Tariff.getVat() / 100;
		return round(vatCharge,2);
	}
	
	public static double gasStandingChargeCalculation(BillAndPayment obj) {
		double diff = dateBetweenDays(obj);
		double value = ( diff * Tariff.getGasStandingCharg() )/100;
		return round(value,2);
	}
	public static double gasUsageChargeCalculation(BillAndPayment obj) throws ClassNotFoundException, IOException {
		double reading = getGasKWH(obj);
		double usageCharge = reading * Tariff.getGasRate();
		return round(usageCharge,2);
		
	}
	
	public static double getGasKWH(BillAndPayment obj) {
		double reading = obj.getGasEndReading() - obj.getGasStartReading();
		double readingKwh = ( getGasM3(obj) * Tariff.getCorrectionFactor() * Tariff.getCalorificValue() ) / Tariff.getConvertValue();
		return round(readingKwh,2);
	}
	
	public static double getGasM3(BillAndPayment obj) {
		double reading = obj.getGasEndReading() - obj.getGasStartReading();
		double readingM3 = ( reading * 2.83 );
		return round(readingM3,2);
	}
	public static double gasSupplyChargeCalculation(BillAndPayment obj) throws ClassNotFoundException, IOException {
		double usageCharge = gasUsageChargeCalculation(obj);
		double standingCharge = gasStandingChargeCalculation(obj);
		return round(usageCharge + standingCharge,2);
	}
	
	
	public static double gasVatCalculation(BillAndPayment obj) throws ClassNotFoundException, IOException {
		double supplyCharge = gasSupplyChargeCalculation(obj);
		double vatCharge = ( supplyCharge) * Tariff.getVat() / 100;
		return round(vatCharge,2);
	}
	
	public static double gasTotalAmount(BillAndPayment obj) throws ClassNotFoundException, IOException {
		double supplyCharge = gasSupplyChargeCalculation(obj);
		double vatCharge = gasVatCalculation(obj);
		double totalAmount = supplyCharge + vatCharge;
		return round(totalAmount,2);
	}
	
	public static double finalBillCalculation(BillAndPayment obj) throws ClassNotFoundException, IOException {
		double finalBill = 0.0;
		finalBill = gasTotalAmount(obj) + electricityTotalAmount(obj);
		return round(finalBill,2);
	}
	public static int dateBetweenDays(BillAndPayment obj) {
		long daysBetween = ChronoUnit.DAYS.between(obj.getStartDate(), obj.getEndDate());
		int diff = (int)daysBetween;
		return diff;
	}
}
