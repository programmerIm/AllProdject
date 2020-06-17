package com.bonc.springboot.module.kafka;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;
import org.apache.kafka.common.PartitionInfo;

import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @auther :liming
 * @Description: kafka生成者执行分区推送：分区类
 *              在创建生产者同时，可以执行该类。
 * @Date: create in 2020/6/17 20:52
 */
public class KafkaProducerPartition implements Partitioner {
    @Override
    public int partition(String topic, Object key, byte[] serializedKey, Object value, byte[] serializedValue, Cluster cluster) {
        List<PartitionInfo> partitions = cluster.partitionsForTopic(topic);
        int numPartitions = partitions.size();
        // 1.当key为空返回随机的一个分区
        if (key == null ) {
            Random rand = new Random();
            return rand.nextInt(numPartitions);
        }
        // 2.当key不为空，依据key的hash返回  这个可针对于业务上，某个数据一直推送到一个分区
        int partitionNum = key.hashCode()%numPartitions;
        return partitionNum;
    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> map) {

    }
}
