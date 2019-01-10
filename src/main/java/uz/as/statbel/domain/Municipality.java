package uz.as.statbel.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Municipality {

    private final String nisCode;
    private final String administrativeUnitFrench;
    private final String administrativeUnitDutch;

    public Municipality(@JsonProperty("nisCode") String nisCode,
                        @JsonProperty("administrativeUnitFrench") String administrativeUnitFrench,
                        @JsonProperty("administrativeUnitDutch") String administrativeUnitDutch) {
        this.nisCode = nisCode;
        this.administrativeUnitFrench = administrativeUnitFrench;
        this.administrativeUnitDutch = administrativeUnitDutch;
    }

    public String getNisCode() {
        return nisCode;
    }

    public String getAdministrativeUnitFrench() {
        return administrativeUnitFrench;
    }

    public String getAdministrativeUnitDutch() {
        return administrativeUnitDutch;
    }
}
