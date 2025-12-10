package com.bingoastradirectwebservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import java.util.Objects;


@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class InsuranceType {
    private String uuid;
    @NotEmpty(message = "Name darf nicht leer sein.")
    private String name;

    @Override
    public String toString() {
        return "InsuranceType{" +
                "uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InsuranceType that = (InsuranceType) o;
        return Objects.equals(uuid, that.uuid) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, name);
    }
}
