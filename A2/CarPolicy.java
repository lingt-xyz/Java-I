package A2;
/**
 * @author TAN_LING
 * @date May 1, 2016
 *
 */
public class CarPolicy {

	private String driverName;
	private int driverAge;// in years
	private String carType;
	private int numberOfCitations;
	private int risk;
	private String riskLevel;

	public CarPolicy() {
		this.driverName = "";
		this.driverAge = 0;
		this.carType = "";
		this.numberOfCitations = -1;
		this.risk = 0;
		this.riskLevel = "";
	}

	public CarPolicy(String driverName, int driverAge, String carType) {
		this.driverName = driverName;
		this.driverAge = driverAge;
		this.carType = carType;
	}

	/**
	 * age is b/w 16 and 130
	 * 
	 * @param age
	 * @return true, if input is between 16 and 130; otherwise, false.
	 */
	public boolean checkAge(int age) {
		return age >= 16 && age <= 130;
	}

	/**
	 * Car type can either be sport, sedan, truck.
	 * 
	 * @param carType
	 * @return true, if input right car type from above; otherwise, false.
	 */
	public boolean checkCarType(String carType) {
		return carType.equalsIgnoreCase("sport") || carType.equalsIgnoreCase("sedan") || carType.equalsIgnoreCase("truck");
	}

	/**
	 * Number of citations is b/w 0 and 100
	 * 
	 * @return true, if the number of citations is between 0 and 100; otherwise,
	 *         false.
	 */
	public boolean checkCitation(int number) {
		return number >= 0 && number <= 100;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public int getDriverAge() {
		return driverAge;
	}

	public void setDriverAge(int driverAge) {
		this.driverAge = driverAge;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public int getNumberOfCitations() {
		return numberOfCitations;
	}

	public void setNumberOfCitations(int numberOfCitations) {
		this.numberOfCitations = numberOfCitations;
	}

	public int getRisk() {
		this.risk = (this.numberOfCitations + 1) * this.getCarTypeValue() * this.getAgeCategory();
		return this.risk;
	}

	public String getRiskLevel() {
		if (this.getRisk() < 10) {
			this.riskLevel = "low";
		} else if (this.getRisk() > 100) {
			this.riskLevel = "high";
		} else {
			this.riskLevel = "medium";
		}
		return this.riskLevel;
	}

	public String toString() {
		return "CarPolicy:\n Driver's Name: \t" + this.getDriverName() + "\n Driver's Age: \t\t" + this.getDriverAge() + "\n Car's Type: \t\t" + this.getCarType() + "\n Number of Citations: \t" + this.getNumberOfCitations() + "\n Risk Value:\t\t" + this.getRisk() + "\n Risk Level: \t\t"
				+ this.getRiskLevel();
	}

	public boolean equals(CarPolicy that) {
		if (that == null)
			return false;
		return this.driverName.equals(that.getDriverName()) && this.driverAge == that.getDriverAge() && this.carType.equals(that.getCarType()) && this.numberOfCitations == that.getNumberOfCitations();
	}

	private int getCarTypeValue() {
		int carTypeValue = 0;
		if (this.carType.equalsIgnoreCase("sport")) {
			carTypeValue = 4;
		} else if (this.carType.equalsIgnoreCase("sedan")) {
			carTypeValue = 1;
		} else if (this.carType.equalsIgnoreCase("truck")) {
			carTypeValue = 2;
		}
		return carTypeValue;
	}

	private int getAgeCategory() {
		int ageCategory = 0;
		if (this.driverAge < 20) {
			ageCategory = 5;
		} else if (this.driverAge > 50) {
			ageCategory = 1;
		} else {
			ageCategory = 2;
		}
		return ageCategory;
	}

}
