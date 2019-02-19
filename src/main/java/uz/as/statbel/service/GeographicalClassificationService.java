package uz.as.statbel.service;

import uz.as.statbel.domain.Municipality;

import java.util.List;
import java.util.Optional;

public interface GeographicalClassificationService {

    Optional<Municipality> findMainMuncipality(String mainMunicipality);

    List<Municipality> getAllMunicipalities();
}
