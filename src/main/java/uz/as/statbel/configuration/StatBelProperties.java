package uz.as.statbel.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "uz.as.statbel")
public class StatBelProperties {

    private String refNisFilePath;

    public String getRefNisFilePath() {
        return refNisFilePath;
    }

    public void setRefNisFilePath(String refNisFilePath) {
        this.refNisFilePath = refNisFilePath;
    }
}
