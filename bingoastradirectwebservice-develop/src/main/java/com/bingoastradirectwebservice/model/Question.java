package com.bingoastradirectwebservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;


@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Question {
    private String uuid;
    @NotEmpty(message = "Name darf nicht leer sein.")
    private String name;
    private String returnValue;
    private String defaultValue;
    private QuestionType questionType;


    public enum QuestionType {
        LABEL(1, "Label"),
        TEXTBOX(2, "Textfeld"),
        PERSON(3, "Person"),
        ADDRESS(4, "Adresse"),
        CURRENCY(5, "Währung"),
        POSTCODE(6, "Postleitzahl"),
        COINSURE(7, "Mitversichern (coinsure)"),
        SELECT(8, "Auswahl (select)"),
        CONTRACTBEGIN(9, "Vertragsbeginn (contractbegin)"),
        YESNO(10, "Ja / Nein"),
        OPTIONGROUP(11, "Optionsgruppe"),
        HEALTHINSURANCE(12, "Gesetzlich versichert"),
        CHECKBOX(13, "Checkbox"),
        NUMBER(14, "Nummer"),
        NATIONALITY(15, "Nationalität"),
        SEPA(16, "SEPA Eingabe"),
        BIRTHDATE(17, "Geburtsdatum (birthdate)"),
        DATE(18, "Datum"),
        OCCUPATIONGROUP(19, "Berufsgruppe (occupationgroup)"),
        MULTISELECT(20, "Multiselect"),
        INSURANCESELECT(21, "Versicherungsfilter"),
        AUTOSUGGEST(22, "Autovervollständigung"),
        LINKOPTIN(23, "Links mit Checkbox");

        private int value;
        private String label;

        QuestionType(int value, String label) {
            this.value = value;
            this.label = label;
        }

        public int getValue() {
            return value;
        }

        public String getCaption() {
            return name();
        }

        public String getLabel() {
            return label;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return Objects.equals(uuid, question.uuid) && Objects.equals(name, question.name) && Objects.equals(returnValue, question.returnValue) && Objects.equals(defaultValue, question.defaultValue) && questionType == question.questionType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, name, returnValue, defaultValue, questionType);
    }

    @Override
    public String toString() {
        return "Question{" +
                "uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                ", returnValue='" + returnValue + '\'' +
                ", defaultValue='" + defaultValue + '\'' +
                ", questionType=" + questionType +
                '}';
    }
}
