package uz.as.statbel.repository;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvParser;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import uz.as.statbel.domain.Municipality;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * https://statbel.fgov.be/nl/over-statbel/methodologie/classificaties/geografie
 *
 * REFNIS csv file : https://statbel.fgov.be/sites/default/files/Over_Statbel_FR/Nomenclaturen/REFNIS_2019.csv
 */
//@Primary
//@Repository//   create via uz.as.statbel.configuration.StatbelConfiguration
public class FileGeographicalClassifRepo implements GeographicalClassificationRepo {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileGeographicalClassifRepo.class);

    private static final Map<String, Municipality> MUNICIPALITIES = new ConcurrentHashMap<>();

    private static final char COLUMN_SEPARATOR = ';';

    public FileGeographicalClassifRepo(String refNisFilePath) {
        try {
            CsvSchema schema = CsvSchema.emptySchema()
                    .withSkipFirstDataRow(true)
                    .withColumnSeparator(COLUMN_SEPARATOR);
            CsvMapper mapper = new CsvMapper();
            mapper.enable(CsvParser.Feature.WRAP_AS_ARRAY);
            File file = new ClassPathResource(refNisFilePath).getFile();

            MappingIterator<String[]> readValues = mapper.readerFor(String[].class)
                    .with(schema)
                    .readValues(new InputStreamReader(new FileInputStream(file), "ISO-8859-1"));
//                    .readValue(new InputStreamReader(new FileInputStream(file), "windows-1252"));

            initializeCache(readValues);
        } catch (IOException e) {
            final String errorMessage = "Error occurred while loading statbel NIS from file " + refNisFilePath;
            LOGGER.error(errorMessage, e);
        }
    }

    private void initializeCache(MappingIterator<String[]> readValues) {
        while (readValues.hasNext()) {
            final String[] line = readValues.next();

            // TODO krcl debugging
//            System.out.println("\n\n");
//            Arrays.stream(line).forEach(item -> System.out.println(item));

            final String nisCode = line[0];
            MUNICIPALITIES.put(nisCode, new Municipality(nisCode, line[1], line[4]));
        }
    }

    /**
     * find by the Dutch and French municipality name
     *
     * TODO ignore special characters
     */
    @Override
    public Optional<Municipality> findMainMuncipality(String mainMunicipality) {
        for (Municipality municipality : MUNICIPALITIES.values()) {
            if (municipality.getAdministrativeUnitDutch().equalsIgnoreCase(mainMunicipality)) {
                return Optional.of(municipality);
            }
        }
        for (Municipality municipality : MUNICIPALITIES.values()) {
            if (municipality.getAdministrativeUnitFrench().equalsIgnoreCase(mainMunicipality)) {
                return Optional.of(municipality);
            }
        }

        return Optional.empty();
    }

    @Override
    public List<Municipality> getAllMainMunicipalities() {
        return new ArrayList<>(MUNICIPALITIES.values());
    }

}
