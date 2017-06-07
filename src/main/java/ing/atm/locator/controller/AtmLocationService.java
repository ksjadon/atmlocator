package ing.atm.locator.controller;

import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import ing.atm.locator.domain.CityATMList;
import ing.atm.locator.helper.CityAtmsLocator;

@Component
@Path("/getAtm")

public interface AtmLocationService {

	@GET
	@Path("/{city}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<CityATMList> getATMList(@PathParam("city") String city);

}
