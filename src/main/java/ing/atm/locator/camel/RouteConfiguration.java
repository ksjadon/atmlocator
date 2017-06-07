package ing.atm.locator.camel;

import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.spring.javaconfig.SingleRouteCamelConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class RouteConfiguration extends SingleRouteCamelConfiguration {

	final String CXT = "8080/atmLocator";

	Processor atmProcessor = new ATMProcessor();
	final String CXF_RS_ENDPOINT_URI = "cxfrs://http://localhost:" + CXT
			+ "/rest?resourceClasses=ing.atm.locator.controller.AtmLocationService";

	@Bean
	public RouteBuilder route() {
		return new RouteBuilder() {
			public void configure() {
				rest("/atm").get("/city").to("direct:getAtm").produces("application/json");
				from("direct:getAtm").process(atmProcessor).to(CXF_RS_ENDPOINT_URI);

			};
		};
	}

}
