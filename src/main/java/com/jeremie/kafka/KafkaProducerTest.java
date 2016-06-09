package com.jeremie.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * @author guanhong 16/6/5 上午12:06.
 */
public class KafkaProducerTest {

    private final static Properties props;
    private final static KafkaProducer<Integer, String> producer;
    private final static String topic;

    static {
        props = new Properties();
        props.put("serializer.class", "kafka.serializer.StringEncoder");
        props.put("metadata.broker.list", "localhost:9092");
        props.put("group.id", "group1");
        producer = new KafkaProducer<>(props);
        topic = "topic1";
    }

    public static void main(String[] args) {
        int messageNo = 1;
        while (true) {
            String messageStr = "Message_" + messageNo;
            System.out.println("Send:" + messageStr);
            producer.send(new ProducerRecord<>(topic, messageStr));
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
