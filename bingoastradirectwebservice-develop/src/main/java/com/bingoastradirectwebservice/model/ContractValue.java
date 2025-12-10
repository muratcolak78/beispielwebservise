package com.bingoastradirectwebservice.model;
import com.bingoastradirectwebservice.annotation.FormElement;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContractValue {
    @FormElement(questionName = "id")
    private String id;
    @FormElement(questionName = "contractBegin")
    private String contractBegin;
    @FormElement(questionName = "insureGroup")
    private String insureGroup;
    @FormElement(questionName = "ipFamilyStatus")
    private String ipFamilyStatus;
    @FormElement(questionName = "selectedTariffRetention")
    private String selectedTariffRetention;
    @FormElement(questionName = "wayOfPayment")
    private String wayOfPayment;
    @FormElement(questionName = "minimumDuration")
    private String minimumDuration;

    //versicherungsnehmer
    @FormElement(questionName = "title")
    private String title;
    @FormElement(questionName = "salutation")
    private String salutation;
    @FormElement(questionName = "firstName")
    private String firstName;
    @FormElement(questionName = "lastName")
    private String lastName;
    @FormElement(questionName = "ipBirthdate")
    private String ipBirthdate;
    @FormElement(questionName = "job")
    private String job;
    @FormElement(questionName = "healthinsurance")
    private String healthinsurance;  //Gesetzliche Krankenkasse
    @FormElement(questionName = "questionSelfInsuredPerson")
    private String questionSelfInsuredPerson;  //Sind Sie selbst die zu versichernde Person?

    //SelfInsuredPerson
    @FormElement(questionName = "lpSalutation")
    private String lpSalutation;
    @FormElement(questionName = "lpSurname")
    private String lpSurname;
    @FormElement(questionName = "lpForename")
    private String lpForename;
    @FormElement(questionName = "lpJob")
    private String lpJob;
    @FormElement(questionName = "lpHealthInsurance")
    private String lpHealthInsurance;
    @FormElement(questionName = "realtedList")
    private String realtedList;  //Welcher Angehörigenstatus zum Versicherungsnehmer liegt vor? (Personenbezogene Daten)
    @FormElement(questionName = "lpBirthdate")
    private String lpBirthdate;
    @FormElement(questionName = "lpTitle")
    private String lpTitle;

    // Price
    @FormElement(questionName = "birthdate")
    private String birthdate;

    //Zähne
    @FormElement(questionName = "tooth")
    private String tooth;  // Haben Sie fehlende bzw. zu ziehende Zähne oder besteht bereits Zahnersatz? Ausgenommen sind Milch-, Weisheitszähne und Lückenschluss.
    @FormElement(questionName = "toothPull")
    private String toothPull;  // Wie viele Zähne sind zu ziehen?
    @FormElement(questionName = "astra_missingTooth")
    private String missingTooth;  // Wie viele Zähne fehlen, die noch nicht ersetzt wurden?
    @FormElement(questionName = "insureToothIncare")
    private String insureToothIncare;  // Wurde bei den fehlenden Zähnen bereits eine Behandlung angeraten bzw. empfohlen?
    @FormElement(questionName = "looseProsthesis")
    private String looseProsthesis;  // Wie viele Zähne wurden mit herausnehmbarem Zahnersatz ersetzt?
    @FormElement(questionName = "fixedProsthesis")
    private String fixedProsthesis;  // Wie viele Zähne wurden mit festem Zahnersatz ersetzt? Wichtig: Bitte zählen Sie je Brücke mindestens zwei Zähne (Ankerzahn, Brückenbefestigung) hinzu.
    @FormElement(questionName = "parodontoseEver")
    private String parodontoseEver;  // Wurde jemals eine Parodontose / Zahnfleischerkrankung festgestellt oder wurden Sie diesbezüglich behandelt?
    @FormElement(questionName = "parodontose_current")
    private String parodontoseCurrent;  // Befinden Sie sich in einer laufenden Parodontosebehandlung?
    @FormElement(questionName = "parodontose3y")
    private String parodontose3y;  // Wurde in den vergangenen 3 Jahren eine Parodontosebehandlung durchgeführt, oder hatten Sie eine Zahnfleischerkrankung?
    @FormElement(questionName = "biteplane")
    private String biteplane;  // Wurde jemals eine Zahn- oder Aufbissschiene angefertigt bzw. angeraten oder hatten Sie Kiefergelenksbeschwerden?
    @FormElement(questionName = "biteplane3y")
    private String biteplane3y;  // Waren Sie in den vergangenen 3 Jahren wegen einer Zahn- / Aufbissschiene oder Kiefergelenksbeschwerden in Behandlung?
    @FormElement(questionName = "incare")
    private String incare;  // Wurde eine zahnärztliche oder kieferorthopädische Behandlung begonnen, geplant oder angeraten?
    @FormElement(questionName = "kv_insurance")
    private String kvInsurance;  // Wie ist die zu versichernde Person krankenversichert?
    @FormElement(questionName = "filterAgeProvision")
    private String filterAgeProvision;
    @FormElement(questionName = "prosthesisAge")
    private String prosthesisAge;  // Wie viele der festen Zahnersätze sind älter als 10 Jahre?
    @FormElement(questionName = "singlecalculation")
    private String singlecalculation;
    @FormElement(questionName = "insureToothCount")
    private String insureToothCount;  // Wie viele der fehlenden Zähne sollen mitversichert werden?
    @FormElement(questionName = "leistung")
    private String leistung;
    @FormElement(questionName = "allianz_otherInsurance")
    private String allianzOtherInsurance;
    @FormElement(questionName = "allianz_incareYesNo")
    private String allianzIncareYesNo;
    @FormElement(questionName = "allianz_incare")
    private String allianzIncare;
    @FormElement(questionName = "allianz_missingTooth")
    private String allianzMissingTooth;

    //Adresse
    @FormElement(questionName = "ipCity")
    private String ipCity;
    @FormElement(questionName = "ipHousenumber")
    private String ipHousenumber;
    @FormElement(questionName = "ipStreet")
    private String ipStreet;
    @FormElement(questionName = "ipTelefon")
    private String ipTelefon;
    @FormElement(questionName = "ipPostcode")
    private String ipPostcode;
    @FormElement(questionName = "email")
    private String email;

    //Sepa Bank und AbweichenderKontoinhaber
    @FormElement(questionName = "sepaBankIban")
    private String sepaBankIban;
    @FormElement(questionName = "sepaBic")
    private String sepaBic;
    @FormElement(questionName = "sepaBankName")
    private String sepaBankName;
    @FormElement(questionName = "sepaBankOtherPersonQuestion")
    private String sepaBankOtherPersonQuestion;
    @FormElement(questionName = "sepaBankOtherPersonSalutation")
    private String sepaBankOtherPersonSalutation;
    @FormElement(questionName = "sepaBankOtherPersonSurname")
    private String sepaBankOtherPersonSurname;
    @FormElement(questionName = "sepaBankOtherPersonForename")
    private String sepaBankOtherPersonForename;
    @FormElement(questionName = "sepaBankOtherPersonBirthdate")
    private String sepaBankOtherPersonBirthdate;

    //Sepa AbweichenderKontoinhaber Adresse
    @FormElement(questionName = "bankOtherAddressQuestion")
    private String bankOtherAddressQuestion;
    @FormElement(questionName = "bankOtherAddressCity")
    private String bankOtherAddressCity;
    @FormElement(questionName = "bankOtherAddressPostcode")
    private String bankOtherAddressPostcode;
    @FormElement(questionName = "bankOtherAddressStreet")
    private String bankOtherAddressStreet;
    @FormElement(questionName = "bankOtherAddressHousenumber")
    private String bankOtherAddressHousenumber;

    //Sepa AbweichenderKontoinhaber Adresse
    @FormElement(questionName = "employeeDaimler")
    private String employeeDaimler;
    @FormElement(questionName = "employeeDaimlerDevision")
    private String employeeDaimlerDevision;
    @FormElement(questionName = "tariffName")
    private String tariffName;
}