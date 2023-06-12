package dev.springbooks.application;

import dev.springbooks.infrastructure.model.CountrieInformation;
import dev.springbooks.infrastructure.repository.CountriesRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountriesApplication {

    private final CountriesRepository countriesRepository;

    public CountriesApplication(CountriesRepository countriesRepository) {
        this.countriesRepository = countriesRepository;
    }
    @GetMapping("/rest/countrieInformation/{name}")
    public CountrieInformation countrieInformation(@PathVariable("name") String name){
       return countriesRepository.getCountrie(name);

    }
}
