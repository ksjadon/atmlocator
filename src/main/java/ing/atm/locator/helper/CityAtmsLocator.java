package ing.atm.locator.helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ing.atm.locator.domain.ATMLocation;
import ing.atm.locator.domain.Address;

public class CityAtmsLocator {

	public static List<Address> getCityAllATMs(String findCityAtm) {
		Map<String, ArrayList<Address>> atmInCity = new HashMap<String, ArrayList<Address>>();
		List<Address> atmAddressInCity = null;
		List<ATMLocation> atmList = null;

		atmList = AtmDataLocator.getAllAtmsDetails();
		if (atmList != null && !atmList.isEmpty()) {
			atmList.forEach((location) -> {
				if (!atmInCity.containsKey(location.getAddress().getCity())) {
					ArrayList<Address> al = new ArrayList<Address>();
					al.add(location.getAddress());
					atmInCity.put(location.getAddress().getCity(), al);
				} else if (atmInCity.containsKey(location.getAddress().getCity())) {
					atmInCity.get(location.getAddress().getCity()).add(location.getAddress());
				}

			});

			atmAddressInCity = atmInCity.get(findCityAtm);
		}
		return atmAddressInCity;
	}
}
