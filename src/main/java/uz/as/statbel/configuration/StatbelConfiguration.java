package uz.as.statbel.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import uz.as.statbel.repository.FileGeographicalClassifRepo;
import uz.as.statbel.repository.GeographicalClassificationRepo;

@Configuration
public class StatbelConfiguration {

    @Value("${uz.as.statbel.ref-nis-file-path}")
    private String refNisFilePath;

    @Bean
    public GeographicalClassificationRepo geographicalCassificationRepo() {
        return new FileGeographicalClassifRepo(refNisFilePath);
    }

}
