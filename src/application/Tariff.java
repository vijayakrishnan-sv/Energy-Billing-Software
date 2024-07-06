package application;

public class Tariff {
	private static double normal = 0.19349;
	private static double standard = 0.20345;
	private static double vat = 5;
	private static double standingCharg = 22.63;
	private static double gasStandingCharg = 24.87;
	private static double correctionFactor = 1.02264;
	private static double calorificValue = 39.3;
	private static double convertValue = 3.6;
	private static double gasRate = 0.03797;
	
	public static double getGasRate() {
		return gasRate;
	}
	public static void setGasRate(double gasRate) {
		Tariff.gasRate = gasRate;
	}
	public static double getConvertValue() {
		return convertValue;
	}
	public static void setConvertValue(double convertValue) {
		Tariff.convertValue = convertValue;
	}
	public static double getCorrectionFactor() {
		return correctionFactor;
	}
	public static void setCorrectionFactor(double correctionFactor) {
		Tariff.correctionFactor = correctionFactor;
	}
	public static double getCalorificValue() {
		return calorificValue;
	}
	public static void setCalorificValue(double calorificValue) {
		Tariff.calorificValue = calorificValue;
	}
	public static double getNormal() {
		return normal;
	}
	public static void setNormal(double normal) {
		Tariff.normal = normal;
	}
	public static double getStandard() {
		return standard;
	}
	public static void setStandard(double standard) {
		Tariff.standard = standard;
	}
	public static double getVat() {
		return vat;
	}
	public static void setVat(double vat) {
		Tariff.vat = vat;
	}
	public static double getStandingCharg() {
		return standingCharg;
	}
	public static void setStandingCharg(double charge) {
		Tariff.standingCharg = charge;
	}
	public static double getGasStandingCharg() {
		return gasStandingCharg;
	}
	public static void setGasStandingCharg(double charge) {
		Tariff.gasStandingCharg = charge;
	}
	
}
