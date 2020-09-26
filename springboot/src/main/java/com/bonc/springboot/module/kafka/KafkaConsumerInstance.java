package com.bonc.springboot.module.kafka;

import com.alibaba.fastjson.JSON;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;

import java.util.*;

/**
 * @auther :liming
 * @Description: 消费者
 * @Date: create in 2020/5/27 23:50
 */
public class KafkaConsumerInstance {
    private Properties consumerConfig = new Properties();
    private String topicName = "orderMq8";
    private int partitionRange = 1;//指定消费的分区
    private int pullTime = 300;

    public  void ConsumerMessage(){
        consumerConfig.put("bootstrap.servers", "");
        consumerConfig.put("session.timeout.ms", "");
        consumerConfig.put("heartbeat.interval.ms","");//心跳频率，一般为会话的三分之一
        consumerConfig.put("fetch.max.wait.ms","");//broker的等待时间
        consumerConfig.put("request.timeout.ms","600000");
        consumerConfig.put("auto.commit.interval.ms","1000");//自动提交的时间间隔1秒
        consumerConfig.put("zookeeper.sync.time.ms","");
        consumerConfig.put("auto.offset.reset", "");//自动提交重试次数
        consumerConfig.put("key.deserializer","");
        consumerConfig.put("value.deserializer","");
        List<TopicPartition> partitions = new LinkedList<TopicPartition>();
        partitions.add(new TopicPartition(topicName,partitionRange));//添加指定消费的分区
        KafkaConsumer  consumer  = new KafkaConsumer(consumerConfig);
        consumer.assign(partitions);

        try {
            while (true){
                ConsumerRecords<String, String> records = consumer.poll(pullTime);
                List<Map<String,Object>>   AllList = new ArrayList<>();
                for (ConsumerRecord record : records) {
                    HashMap<String, Object> order = JSON.parseObject(record.value().toString(),HashMap.class);
                    if(null==order){
                        System.out.println("mess is null ");
                        continue;
                    }
                    AllList.add(order);//消费下来的消息
                }
                consumer.commitAsync();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                consumer.commitSync();
            }finally {
                consumer.close();
            }
        }



    }
}
