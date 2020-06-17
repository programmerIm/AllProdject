package com.bonc.springboot.module.kafka;

import com.alibaba.fastjson.JSONObject;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.record.Record;

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
        props.put("request.required.acks", "1");//参数值有 0 1 -1/all

        //执行推送的分区类-如果使用自己计算的，可以省略该参数
        props.put("partitioner.class", "com.bonc.springboot.module.kafka.KafkaProducerPartition");

        KafkaProducer producer = new KafkaProducer(props);
        Map<String, Object> msg = new ConcurrentHashMap<>();
        msg.put("activity_id", "11111");
        //方式1.使用默认分区推送 或者 properties文件配置了 分区实现类，按分区实现类返回结果推送
        producer.send(new ProducerRecord<String, String>(producerTopic, JSONObject.toJSONString(msg)));

        //方式2 执行指定分区推送  0 (这里的0也可以使用算法求模的结果)
        producer.send(new ProducerRecord<>(producerTopic,0,"key",JSONObject.toJSONString(msg)));

        //方式3. 使用带有默认分区，且有回调函数的推送消息方法
        producer.send(new ProducerRecord<String,String>(producerTopic, JSONObject.toJSONString(msg)), new Callback() {
            @Override
            public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                if(recordMetadata != null){
                    System.out.println("推送分区为"+recordMetadata.partition()+"----偏移量为:"+recordMetadata.offset());
                }
            }
        });
        producer.close();
    }

}
