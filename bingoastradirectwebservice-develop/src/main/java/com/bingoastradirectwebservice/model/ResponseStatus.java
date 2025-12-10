package com.bingoastradirectwebservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.Date;
import java.util.UUID;


@Data
public class ResponseStatus {

    private UUID contractId;

    private Status status;

    @NotBlank
    private String info;
    private String requestPayload;
    private boolean requestIsJson;

    private String responsePayload;
    private boolean responseIsJson;

    private String createdUser;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy HH:mm:ss", timezone = "Europe/Berlin")
    private Date createdDate;

    private String endpointPath;

    public enum Status {
        OK, NOK
    }
}