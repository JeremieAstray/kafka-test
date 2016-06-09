package com.jeremie.testObject;

import com.jeremie.util.SerializeTool;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * @author guanhong 16/6/5 上午12:06.
 */
public class KafkaProducerTest {

    private final static Properties props;
    private final static KafkaProducer<Integer, byte[]> producer;
    private final static String topic;

    static {
        props = new Properties();
        props.put("serializer.class", "kafka.serializer.DefaultEncoder");
        props.put("metadata.broker.list", "localhost:9092");
        props.put("group.id", "group1");
        producer = new KafkaProducer<>(props);
        topic = "kafka_object_test_topic";
    }

    public static void main(String[] args) {
        int messageNo = 1;
        while (true) {
            String messageStr = "Message_" + messageNo;
            System.out.println("Send:" + messageStr);
            Test test = new Test(messageNo, messageStr);
            producer.send(new ProducerRecord<>(topic, SerializeTool.objectToByteArray(test)));
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
