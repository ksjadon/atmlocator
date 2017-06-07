# atmlocator

There are two different services created in this project.
--> First Rest service build by using Spring REST and work independently.It's fetch the all ATM list for given cityName in URL and produce JSON in browser.
Below the URL to get the ATM list of city.

http://localhost:8080/atmLocator/atm/city/cityName

--> Another service is build by usign JAX-RS and integrated with Camel for routing. This is not tested as I didn't get enough time to read/write code.

--> To fetch the Records from  https://www.ing.nl/api/locator/atms/ I used RestTemplate and created some helper class to process the Data. This is an independent code which can work with any type of Service and no need to rewrite business logic again. 

--> REST DSL with java configuration is used to route the service.

--> I didn't code Exception Handling and Security which can be achieved by Spring again. Spring Caching can be used to saved the ATM list but it’s later implementation.

--> This is the first time I am using Apache Camel and not aware of basic.It's time taking development for me to integrate with Spring. So I didn't coded all module and just created a architecture to achive the things. 

* There is no need to create two services but as I developed SPRING rest api first and later don't get enough time to integrate with Camel, I created another service for just integratin.

/**
 * 
 * Exposes a CXF service
 * 
 */
 
@Component
@Path("/getAtm")

public interface AtmLocationService {

	@GET
	@Path("/{city}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<CityATMList> getATMList(@PathParam("city") String city);

}
