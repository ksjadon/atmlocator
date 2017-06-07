package ing.atm.locator.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ing.atm.locator.domain.CityATMList;
import ing.atm.locator.helper.CityAtmsLocator;

/*
 * This is independent Spring Rest web service which takes the input param
 * as a city and returns the number of ATM in that city.
 */
@RestController
public class AtmLocationRestController {

	@RequestMapping("/test")
	public String testService() {
		return "My Atm Locator Service is Up and Running.";
	}

	@RequestMapping(value = "atm/city/{city}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<CityATMList> getAtmList(@PathVariable String city) {

		CityATMList atmList = new CityATMList(city, CityAtmsLocator.getCityAllATMs(city));
		return new ResponseEntity<CityATMList>(atmList, HttpStatus.OK);
	}

}
