package com.juliodias.orderservice.messaging;

import com.amazonaws.services.sqs.AmazonSQSAsync;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class QueueSender {

    private final QueueMessagingTemplate queueMessagingTemplate;

    public QueueSender(final AmazonSQSAsync amazonSqs) {
        this.queueMessagingTemplate = new QueueMessagingTemplate(amazonSqs);
    }

    public void sendMessage(final String queue, final String message) {
        queueMessagingTemplate.convertAndSend(queue, message);
    }

}
