package com.bonc.springboot.module.kafka;

import com.alibaba.fastjson.JSONObject;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @auther :liming
 * @Description:
 * @Date: create in 2020/5/27 23:51
 */
public class KafkaProducerInstance {
   private String producerTopic = "orderMq8";
   private Properties props = new Properties();

    public  void producerMessage(){
        props.put("serializer.class", "kafka.serializer.StringEncoder");
        props.put("metadata.broker.list", "master:9092,slaver1:9092,slaver2:9092");
        props.put("request.required.acks", "1");
        props.put("partitioner.class", "com.bie.kafka.MyLogPartitioner");

        KafkaProducer producer = new KafkaProducer(props);
        Map<String, Object> msg = new ConcurrentHashMap<>();
        msg.put("activity_id", "11111");
        producer.send(new ProducerRecord<String, String>(producerTopic, JSONObject.toJSONString(msg)));
    }

}
