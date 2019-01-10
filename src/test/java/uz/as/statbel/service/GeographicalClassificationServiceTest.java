package uz.as.statbel.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import uz.as.statbel.domain.Municipality;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GeographicalClassificationServiceTest {

    @Autowired
    private GeographicalClassificationService service;

    @Test
    public void findNISforMainMuncipality() {
        final Optional<Municipality> mainMuncipality = service.findMainMuncipality("Brugge");
        assertNotNull(mainMuncipality);
        assertTrue(mainMuncipality.isPresent());

        final Optional<Municipality> assebroek = service.findMainMuncipality("Assebroek");
        assertNotNull(assebroek);
        assertFalse(assebroek.isPresent());
    }
}