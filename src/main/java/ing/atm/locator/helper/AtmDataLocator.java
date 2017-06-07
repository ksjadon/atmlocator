package ing.atm.locator.helper;

import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import ing.atm.locator.domain.ATMLocation;

public class AtmDataLocator {

	public static List<ATMLocation> getAllAtmsDetails() {

		RestTemplate restTemplate = new RestTemplate();
		String url = "https://www.ing.nl/api/locator/atms/";
		String response = restTemplate.getForObject(url, String.class);
		boolean startWithValidChar = false;
		List<ATMLocation> atmList = null;
		String validJson;
		ObjectMapper objectMapper;
		int next = 0;

		while (!startWithValidChar) {
			if ((response.charAt(next) == '{') || (response.charAt(next) == '[')) {
				startWithValidChar = true;
				break;
			}
			next++;
		}

		try {
			validJson = response.substring(next, response.length());
			objectMapper = new ObjectMapper();
			objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
			atmList = objectMapper.readValue(validJson,
					objectMapper.getTypeFactory().constructCollectionType(List.class, ATMLocation.class));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return atmList;
	}
}
