package uz.as.statbel.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uz.as.statbel.domain.Municipality;
import uz.as.statbel.service.GeographicalClassificationService;

import java.util.List;
import java.util.Optional;

/**
 * REACTIVE version
 */
@RestController
@RequestMapping("/municipality")
public class MunicipalityController {

    private final GeographicalClassificationService geographicalClassificationService;

    public MunicipalityController(GeographicalClassificationService geographicalClassificationService) {
        this.geographicalClassificationService = geographicalClassificationService;
    }

    @GetMapping("/{municipalityName}")
    private Mono<Municipality> getMunicipalityByName(@PathVariable String municipalityName) {
        final Optional<Municipality> muncipality = geographicalClassificationService.findMainMuncipality(municipalityName);
        return Mono.justOrEmpty(muncipality);
    }

    @GetMapping
    private Flux<Municipality> getAllMunicipalities() {
        final List<Municipality> allMunicipalities = geographicalClassificationService.getAllMunicipalities();
        return Flux.just(allMunicipalities.toArray(new Municipality[0]));
    }

}
