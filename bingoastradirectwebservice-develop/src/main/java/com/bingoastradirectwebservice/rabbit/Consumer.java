package com.bingoastradirectwebservice.rabbit;

import com.bingoastradirectwebservice.model.Contract;

import com.allcompare.bingoastradirectwebservice.service.zazu.ZazuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class Consumer {

    private final ZazuService zazuService;

    public Consumer(ZazuService zazuService) {
        this.zazuService = zazuService;
    }

    @RabbitListener(queues = {"astradirectContractQueue"})
    public void receiveMessage(@Header("method") String method, String message) throws Exception {
        //log.debug("Policy Message: {}", message);
        if (method != null && method.equals("postPolicy")) {
            Contract contract = com.allcompare.bingoastradirectwebservice.utils.JsonUtil.parseJsonToObject(message, Contract.class);
            zazuService.postPolicy(contract);
        } else {
           // log.error("Unknown method in AstraDirectListener: {}", method);
        }
    }
}
