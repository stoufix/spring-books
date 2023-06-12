package dev.springbooks.infrastructure.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountrieInformation {

    private String cca2;
    private String ccn3;
    private String cca3;
    private String cioc;
    private String area;
    private String region;
    private String subregion;
    private boolean independent;


}
