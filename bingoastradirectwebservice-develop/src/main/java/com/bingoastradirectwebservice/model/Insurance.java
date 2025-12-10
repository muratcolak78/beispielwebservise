package com.bingoastradirectwebservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;


@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Insurance {

    private String uuid;

    @NotEmpty(message = "Name darf nicht leer sein.")
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Insurance insurance)) return false;
        return Objects.equals(getUuid(), insurance.getUuid()) && Objects.equals(getName(), insurance.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUuid(), getName());
    }

    @Override
    public String toString() {
        return "Insurance{" +
                "uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
