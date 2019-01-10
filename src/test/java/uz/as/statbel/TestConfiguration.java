package uz.as.statbel;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import uz.as.statbel.repository.GeographicalClassificationRepo;
import uz.as.statbel.repository.HardCodedGeographicalClassifRepo;

@Profile("unitTests")
@org.springframework.boot.test.context.TestConfiguration
public class TestConfiguration {

    @Bean
    public GeographicalClassificationRepo geographicalCassificationRepo() {
        return new HardCodedGeographicalClassifRepo();
    }


}
