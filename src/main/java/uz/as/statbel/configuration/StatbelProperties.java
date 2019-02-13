package uz.as.statbel.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "uz.as.statbel")
public class StatbelProperties {

    private String refNisFilePath;

    public String getRefNisFilePath() {
        return refNisFilePath;
    }

    public void setRefNisFilePath(String refNisFilePath) {
        this.refNisFilePath = refNisFilePath;
    }
}
