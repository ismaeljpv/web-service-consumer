package com.example.consumingwebservice.resource;

import com.example.consumingwebservice.service.CountryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/country")
public class CountryResource {

    private CountryService countryService;

    public CountryResource(final CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping(value = "/{country}")
    public HashMap<String, Object> getCountry(@PathVariable String country) {
        return countryService.getCountry(country);
    }
}
