package uz.as.statbel.repository;

import uz.as.statbel.domain.Municipality;

import java.util.List;
import java.util.Optional;

/**
 * https://statbel.fgov.be/nl/over-statbel/methodologie/classificaties/geografie
 */
public interface GeographicalClassificationRepo {

    Optional<Municipality> findMainMuncipality(String mainMunicipality);

    List<Municipality> getAllMainMunicipalities();
}
