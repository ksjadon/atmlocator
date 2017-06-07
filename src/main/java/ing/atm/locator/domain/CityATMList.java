package ing.atm.locator.domain;

import java.util.List;

public class CityATMList {

	private String city;
	private List<Address> atmList;

	public CityATMList() {

	}

	public CityATMList(String city, List<Address> atmList) {
		super();
		this.city = city;
		this.atmList = atmList;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<Address> getAtmList() {
		return atmList;
	}

	public void setAtmList(List<Address> atmList) {
		this.atmList = atmList;
	}

}
