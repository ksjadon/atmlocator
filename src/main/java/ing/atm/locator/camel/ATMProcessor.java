package ing.atm.locator.camel;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.util.ExchangeHelper;

import ing.atm.locator.domain.CityATMList;
import ing.atm.locator.helper.CityAtmsLocator;

public class ATMProcessor implements Processor {

	ProducerTemplate producer;
	
	public void process(Exchange exchange) throws Exception {

		String auth = ExchangeHelper.getMandatoryHeader(exchange, "Authorization", String.class);
		/*
		 * Do some Authorization here based on Header values like and reroute if
		 * it's not valid
		 */

		String city = ExchangeHelper.getMandatoryHeader(exchange, "city", String.class);
		CityATMList atmList = new CityATMList(city, CityAtmsLocator.getCityAllATMs(city));
		exchange.getOut().setBody(atmList);

	}
}
