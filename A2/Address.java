package A2;
/**
 * Address consist of Street (String), Street number (int), City (String), and
 * Country (String).
 * 
 * @author TAN_LING
 * @date May 1, 2016
 *
 */
public class Address {

	private String street;
	private int streetNumber;
	private String city;
	private String country;

	public Address() {
		this.street = "";
		this.streetNumber = 0;
		this.city = "";
		this.country = "";
	}

	public Address(String street, int streetNumber, String city, String country) {
		this.street = street;
		this.streetNumber = streetNumber;
		this.city = city;
		this.country = country;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String toString() {
		return "Address:\n Street: " + this.getStreet() + "\n Street Number: " + this.getStreetNumber() + "\n City: " + this.getCity() + "\n Country: " + this.getCountry();
	}

	public boolean equals(Address that) {
		if (that == null)
			return false;
		return this.street.equals(that.getStreet()) && this.streetNumber == that.getStreetNumber() && this.city.equals(that.getCity()) && this.country.equals(that.getCountry());
	}

}
