package dev.springbooks.infrastructure.repository;

import dev.springbooks.infrastructure.model.CountrieInformation;
import io.vavr.control.Try;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;


@Repository
@Slf4j
public class CountriesRepository {

    private final RestTemplate restTemplate;
    final static String BASE_URL = "https://restcountries.com/v3.1/name/";

    public CountriesRepository(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public CountrieInformation getCountrie(String name) {

        return Try.of(() -> getCountrieInformationByName(name))
                .map(Arrays::asList)
                .onFailure(e -> log.error("e", e))
                .get()
                .stream().findAny()
                .orElse(null);
    }

    private CountrieInformation[] getCountrieInformationByName(String name) {

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        return restTemplate.exchange(BASE_URL + name, HttpMethod.GET, entity, CountrieInformation[].class).getBody();


    }
}
