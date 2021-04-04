package com.example.consumingwebservice.service;

import com.example.consumingwebservice.soap.CountryClient;
import com.example.consumingwebservice.wsdl.GetCountryResponse;
import org.springframework.stereotype.Service;
import java.util.HashMap;

@Service
public class CountryService {

    private CountryClient countryClient;

    public CountryService(final CountryClient countryClient) {
        this.countryClient = countryClient;
    }

    public HashMap<String, Object> getCountry(String country) {
        GetCountryResponse response = countryClient.getCountry(country);
        HashMap<String, Object> json = new HashMap<>();
        json.put("capital", response.getCountry().getCapital());
        json.put("population", response.getCountry().getPopulation());
        json.put("name", response.getCountry().getName());
        json.put("currency", response.getCountry().getCurrency());
        return json;
    }
}
