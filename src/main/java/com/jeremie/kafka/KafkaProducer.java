package com.jeremie.kafka;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

import java.util.Properties;

/**
 * @author guanhong 16/6/5 上午12:06.
 */
public class KafkaProducer {

    private final static Properties props;
    private final static Producer<Integer, String> producer;
    private final static String topic;

    static {
        props = new Properties();
        props.put("serializer.class", "kafka.serializer.StringEncoder");
        props.put("metadata.broker.list", "localhost:9092");
        props.put("group.id", "group1");
        producer = new Producer<Integer, String>(new ProducerConfig(props));
        topic = "topic1";
    }

    public static void main(String[] args) {
        int messageNo = 1;
        while (true) {
            String messageStr = "Message_" + messageNo;
            System.out.println("Send:" + messageStr);
            producer.send(new KeyedMessage<Integer, String>(topic, messageStr));
            messageNo++;
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
