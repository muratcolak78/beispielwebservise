package com.bingoastradirectwebservice.factory;

import com.allcompare.bingoastradirectwebservice.model.ResponseStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Date;
import java.util.UUID;



@Validated
@Service
public class ResponseStatusFactory {

    @Value("${bingoApiGateway.user}")
    private String serviceUser;

    public ResponseStatus newResponseStatus(ResponseStatus.Status status, String requestPayload, String responsePayload, String info, String path, UUID contractId) {

        ResponseStatus responseStatus = new ResponseStatus();

        responseStatus.setContractId(contractId);
        responseStatus.setResponseIsJson(false);
        responseStatus.setResponseIsJson(false);

        responseStatus.setStatus(status);
        responseStatus.setInfo(info);

        responseStatus.setCreatedDate(new Date());
        responseStatus.setCreatedUser(serviceUser);

        responseStatus.setRequestPayload(requestPayload);
        responseStatus.setResponsePayload(responsePayload);

        responseStatus.setEndpointPath(path);

        return responseStatus;
    }
}
