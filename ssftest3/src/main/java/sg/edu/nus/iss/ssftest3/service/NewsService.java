package sg.edu.nus.iss.ssftest3.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import sg.edu.nus.iss.ssftest3.model.Country;

@Service
public class NewsService {

    public List<String> getCountryNames() {

        RestTemplate template = new RestTemplate();

        String baseUrl = "https://restcountries.com/v3.1/alpha";
        String countryCodes = "ae,ar,at,au,be,bg,br,ca,ch,cn,co,cu,cz,de,eg,fr";

        String requestUrl = UriComponentsBuilder
                .fromUriString(baseUrl)
                .queryParam("codes", countryCodes)
                .build().toUriString();

        ResponseEntity<Country[]> response = template.getForEntity(requestUrl, Country[].class);
        Country[] returnedCountries = response.getBody();

        List<String> countriesToReturn = new ArrayList<>();

        for (Country country : returnedCountries) {
            countriesToReturn.add(country.getName().getCommon());
        }

        return countriesToReturn;
    }

}
