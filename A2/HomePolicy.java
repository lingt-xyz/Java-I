package A2;
/**
 * @author TAN_LING
 * @date May 1, 2016
 *
 */
public class HomePolicy {

	private Address address;
	private int roomCount;
	private boolean hasFireplace;
	private int squareFootage;
	private int risk;
	private String riskLevel;

	public HomePolicy() {
		this.address = new Address();
		this.roomCount = 1;
		this.hasFireplace = false;
		this.squareFootage = 0;
		this.risk = 0;
		this.riskLevel = "";
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getRoomCount() {
		return roomCount;
	}

	public void setRoomCount(int roomCount) {
		this.roomCount = roomCount;
	}

	public boolean isHasFireplace() {
		return hasFireplace;
	}

	public void setHasFireplace(boolean hasFireplace) {
		this.hasFireplace = hasFireplace;
	}

	public int getSquareFootage() {
		return squareFootage;
	}

	public void setSquareFootage(int squareFootage) {
		this.squareFootage = squareFootage;
	}

	public int getRisk() {
		this.risk = this.squareFootage / this.roomCount * (this.hasFireplace ? 2 : 1);
		return this.risk;
	}

	public String getRiskLevel() {
		if (this.getRisk() < 20) {
			this.riskLevel = "low";
		} else if (this.getRisk() > 200) {
			this.riskLevel = "high";
		} else {
			this.riskLevel = "medium";
		}
		return this.riskLevel;
	}

	public String toString() {
		return "HomePolicy:/n Address: " + this.getAddress() + "\n Room Count: " + this.getRoomCount() + "\n Fireplace?: " + (this.isHasFireplace() ? "Yes" : "No") + "\n Square Footage: " + this.getSquareFootage() + "\n Risk Value: " + this.getRisk() + "\n Risk Level: " + this.getRiskLevel();
	}

	public boolean equals(HomePolicy that) {
		if (that == null)
			return false;
		return this.address.equals(that.getAddress()) && this.roomCount == that.getRoomCount() && this.squareFootage == that.getSquareFootage();
	}

}
