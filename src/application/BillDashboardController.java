package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class BillDashboardController {
	 @FXML
    private Label billDate;

    @FXML
    private Label billNo;

    @FXML
    private Label billNo1;

    @FXML
    private Label calorificValue;

    @FXML
    private Label closingReading;

    @FXML
    private Label correctionFactor;

    @FXML
    private Label days;

    @FXML
    private Label electricityStandingCharge;

    @FXML
    private Label electricityStandingChargeAmount;

    @FXML
    private Label electricitySupplyCharge;

    @FXML
    private Label electricityTotal;

    @FXML
    private Label electricityUsageCharge;

    @FXML
    private Label electricityVatCharge;

    @FXML
    private Label gasClosingingReading;

    @FXML
    private Label gasKwh;

    @FXML
    private Label gasM3;

    @FXML
    private Label gasOpeningReading;

    @FXML
    private Label gasRate;

    @FXML
    private Label gasStandingCharge;

    @FXML
    private Label gasStandingChargeAmount;

    @FXML
    private Label gasSupplyCharge;

    @FXML
    private Label gasTotal;

    @FXML
    private Label gasUnits;

    @FXML
    private Label gasUsageCharge;
    
    @FXML
    private Label gasUsageCharge1;

    @FXML
    private Label gasVatCharge;

    @FXML
    private Label kwh;

    @FXML
    private Label m3Value;

    @FXML
    private Label numberOfDays;

    @FXML
    private Label openingReading;

    @FXML
    private Button payBillButton;

    @FXML
    private Label period;

    @FXML
    private Label price;

    @FXML
    private Label rate;

    @FXML
    private Button sendMailButtton;

    @FXML
    private Label tariff;
    
    @FXML
    private Label convertValue;
    

    @FXML
    private Label timePeriod;


    @FXML
    private Label totalAmount;

    @FXML
    private Label vat;

    @FXML
    private Label vat1;
    
    private BillAndPayment bill = new BillAndPayment();
	private BillAndPaymentList bList;
    public void initialize(URL location, ResourceBundle resources) throws ClassNotFoundException, IOException {
   		// TODO Auto-generated method stub
		
    
    	
   		
   	}
    
    public void setBillData(BillAndPayment obj) throws ClassNotFoundException, IOException {
    	bill = obj;
    	bList = new BillAndPaymentList();
		bList = DataHandler.readeBillList(); // read existing student list from file
    	setElectricityBillDetails(obj);
    	setGasBillDetails(obj);
    	if(bill.isPayment()) {
    		payBillButton.setVisible(false);
    	}
    }
    
    public void setElectricityBillDetails(BillAndPayment obj) throws ClassNotFoundException, IOException {
    	billNo.setText(obj.getBillNo());
    	String billPeriod = BillCalculation.getDateFormator(obj.getStartDate()) + " - " + BillCalculation.getDateFormator(obj.getEndDate()) ;
    	closingReading.setText( String.valueOf (obj.getEleEndReading()) );
    	openingReading.setText( String.valueOf( obj.getEleStartReading() ));
    	days.setText(String.valueOf( BillCalculation.dateBetweenDays(obj) ));
    	electricityStandingCharge.setText(String.valueOf( Tariff.getStandingCharg() ));
    	electricityStandingChargeAmount.setText(String.valueOf( BillCalculation.electricityStandingChargeCalculation(obj) ));
    	electricitySupplyCharge.setText(String.valueOf( BillCalculation.electricitySupplyChargeCalculation(obj) ));
    	electricityTotal.setText(String.valueOf( BillCalculation.electricityTotalAmount(obj) ));
    	electricityUsageCharge.setText(String.valueOf( BillCalculation.electricityUsageChargeCalculation(obj) ));
    	electricityVatCharge.setText(String.valueOf( BillCalculation.electricityVatCalculation(obj) ));
    	kwh.setText(String.valueOf( obj.getEleEndReading() - obj.getEleStartReading() ));
    	price.setText(String.valueOf( BillCalculation.electricityUsageChargeCalculation(obj) ));
    	rate.setText(String.valueOf(BillCalculation.gatTariffValue(obj) ) );
    	tariff.setText(String.valueOf(BillCalculation.gatTariffName(obj) ) );
    	totalAmount.setText(String.valueOf(BillCalculation.finalBillCalculation(obj) ) );
    	vat.setText(String.valueOf(Tariff.getVat() ) );
    	period.setText(billPeriod );
    	timePeriod.setText(billPeriod );
    	
    }
    
    public void setGasBillDetails(BillAndPayment obj) throws ClassNotFoundException, IOException {
    	billNo1.setText(obj.getBillNo());
    	calorificValue.setText(String.valueOf( Tariff.getCalorificValue() ));
    	convertValue.setText(String.valueOf( Tariff.getConvertValue() ));
    	correctionFactor.setText(String.valueOf( Tariff.getCorrectionFactor() ));
    	correctionFactor.setText(String.valueOf( Tariff.getCorrectionFactor() ));
    	gasClosingingReading.setText( String.valueOf (obj.getGasEndReading()) );
    	gasKwh.setText(String.valueOf( BillCalculation.getGasKWH(obj) ));
    	gasM3.setText(String.valueOf( BillCalculation.getGasM3(obj) ));
    	gasOpeningReading.setText( String.valueOf (obj.getGasStartReading()) );
    	gasRate.setText(String.valueOf( Tariff.getGasRate() ));
    	gasStandingCharge.setText(String.valueOf( Tariff.getGasStandingCharg() ));
    	gasStandingChargeAmount.setText(String.valueOf( BillCalculation.gasStandingChargeCalculation(obj) ));
    	gasSupplyCharge.setText(String.valueOf( BillCalculation.gasSupplyChargeCalculation(obj) ));
    	gasTotal.setText(String.valueOf( BillCalculation.gasTotalAmount(obj) ));
    	gasUnits.setText(String.valueOf( obj.getGasEndReading() - obj.getGasStartReading() ));
    	gasUsageCharge.setText(String.valueOf( BillCalculation.gasUsageChargeCalculation(obj) ));
    	gasUsageCharge1.setText(String.valueOf( BillCalculation.gasUsageChargeCalculation(obj) ));
    	gasVatCharge.setText(String.valueOf( BillCalculation.gasVatCalculation(obj) ));
    	m3Value.setText(String.valueOf( BillCalculation.getGasM3(obj) ));
    	numberOfDays.setText(String.valueOf( BillCalculation.dateBetweenDays(obj) ));
    	vat1.setText(String.valueOf(Tariff.getVat() ) );
    	billDate.setText( BillCalculation.getDateFormator(obj.getBillDate())  );
    }
    
    public BillAndPaymentList updatepayment() {
    	BillAndPaymentList newbList = new BillAndPaymentList();

    	for (int i=0; i<bList.getBills().size();i++) {
    		BillAndPayment  c = bList.getBills().get(i);
    		String billNo = bill.getBillNo();
    		if(billNo.equals(c.getBillNo())) {
    			c.setPayment(true);
    			c.setPaymentText("Success");
    		}
    		newbList.addBill(c);
    	}
    	return newbList;
    }
    
    @FXML
    void payBillListener() throws IOException {
		BillAndPaymentList newList = updatepayment();
		DataHandler.writeToFile(newList); 
    	
    }

    @FXML
    void sendMailListener(ActionEvent event) {

    }
}
