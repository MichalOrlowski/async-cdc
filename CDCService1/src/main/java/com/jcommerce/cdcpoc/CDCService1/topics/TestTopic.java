package com.jcommerce.cdcpoc.CDCService1.topics;


import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface TestTopic {

    String TEST_OUTPUT = "test";

    @Output(TestTopic.TEST_OUTPUT)
    MessageChannel testOutput();
}
