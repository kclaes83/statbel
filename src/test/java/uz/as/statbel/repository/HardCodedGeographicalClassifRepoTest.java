package uz.as.statbel.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringRunner;
import uz.as.statbel.domain.Municipality;

import java.util.Optional;

import static org.junit.Assert.*;

/**
 *
 */
@Profile("unitTests")
@RunWith(SpringRunner.class)
@SpringBootTest
public class HardCodedGeographicalClassifRepoTest {

    @Autowired
    private GeographicalClassificationRepo hardCodedGeographicalClassifRepo;

    @Test
    public void findNISforMainMuncipality() {
        final Optional<Municipality> mainMuncipality = hardCodedGeographicalClassifRepo.findMainMuncipality("Brugge");
        assertNotNull(mainMuncipality);
        assertTrue(mainMuncipality.isPresent());

        final Optional<Municipality> assebroek = hardCodedGeographicalClassifRepo.findMainMuncipality("Assebroek");
        assertNotNull(assebroek);
        assertFalse(assebroek.isPresent());
    }
}