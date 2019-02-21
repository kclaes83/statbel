package uz.as.statbel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import uz.as.statbel.domain.Municipality;
import uz.as.statbel.repository.GeographicalClassificationRepo;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * https://statbel.fgov.be/nl/over-statbel/methodologie/classificaties/geografie
 */
@Service
public class DefaultGeographicalClassificationService implements GeographicalClassificationService {

    private final GeographicalClassificationRepo geographicalClassificationRepo;

    @Autowired
    public DefaultGeographicalClassificationService(GeographicalClassificationRepo geographicalClassificationRepo) {
        this.geographicalClassificationRepo = geographicalClassificationRepo;
    }

    @Override
    public Optional<Municipality> findMainMuncipality(String mainMunicipality) {
        Objects.requireNonNull(mainMunicipality, "mainMunicipality cannot be null");

        return geographicalClassificationRepo.findMainMuncipality(mainMunicipality);
    }

    @Override
    public List<Municipality> getAllMunicipalities() {
        return geographicalClassificationRepo.getAllMainMunicipalities();
    }
}
