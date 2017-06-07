package ing.atm.locator.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ATMLocation {

	private Address address;
	private double distance;
	private String type;
	
	ATMLocation(){
		
	}

	public ATMLocation(Address address, double distance, String type) {

		this.address = address;
		this.distance = distance;
		this.type = type;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
