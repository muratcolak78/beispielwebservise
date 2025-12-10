package com.bingoastradirectwebservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tariff {

    private String uuid;

    @NotEmpty(message = "Name darf nicht leer sein.")
    private String name;

    private String suffix;

    private String identifier;

    private String tariffNameComplete;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tariff tariff = (Tariff) o;
        return Objects.equals(uuid, tariff.uuid) && Objects.equals(name, tariff.name) && Objects.equals(suffix, tariff.suffix) && Objects.equals(identifier, tariff.identifier) && Objects.equals(tariffNameComplete, tariff.tariffNameComplete);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, name, suffix, identifier, tariffNameComplete);
    }

    @Override
    public String toString() {
        return "Tariff{" +
                "uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                ", suffix='" + suffix + '\'' +
                ", identifier='" + identifier + '\'' +
                ", tariffNameComplete='" + tariffNameComplete + '\'' +
                '}';
    }
}
