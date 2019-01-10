package uz.as.statbel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.as.statbel.domain.Municipality;
import uz.as.statbel.repository.GeographicalClassificationRepo;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * https://statbel.fgov.be/nl/over-statbel/methodologie/classificaties/geografie
 *
 * TODO krcl make an interface
 */
@Service
public class GeographicalClassificationService {

    private final GeographicalClassificationRepo geographicalClassificationRepo;

    @Autowired
    public GeographicalClassificationService(GeographicalClassificationRepo geographicalClassificationRepo) {
        this.geographicalClassificationRepo = geographicalClassificationRepo;
    }

    public Optional<Municipality> findMainMuncipality(String mainMunicipality) {
        Objects.requireNonNull(mainMunicipality, "mainMunicipality cannot be null");

        return geographicalClassificationRepo.findMainMuncipality(mainMunicipality);
    }

    public List<Municipality> getAllMunicipalities() {
        return geographicalClassificationRepo.getAllMainMunicipalities();
    }
}
