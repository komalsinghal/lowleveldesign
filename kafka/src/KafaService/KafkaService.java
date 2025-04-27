package KafaService;

import KafaService.Common.ConsumerGroup;
import KafaService.Common.Message;
import KafaService.Common.Offset;
import KafaService.Common.Topic;
import KafaService.Controller.ConsumerGroupController;
import KafaService.Controller.TopicController;

import java.util.List;

public class KafkaService {
    ConsumerGroupController consumerGroupController;
    TopicController topicController;
    IProducerHelperService producerHelperService;
    IConsumerHelperService consumerHelperService;

    public KafkaService(IProducerHelperService producerHelperService)
    {
        this.producerHelperService = producerHelperService;
    }
    public KafkaService(IConsumerHelperService consumerHelperService)
    {
        this.consumerHelperService = consumerHelperService;
    }

    public Offset getLastOffsetOfTopic(Topic topic, ConsumerGroup consumerGroup){
        return consumerGroupController.getLastOffset(consumerGroup, topic);
    }

    public void publishMessage(Message message, List<Topic> topicList){
        producerHelperService.publishMessage(message, topicList);
    }
    public void subscribeToTopic(ConsumerGroup consumerGroup, List<Topic> topicList)
    {
        consumerHelperService.subscribeToTopic(consumerGroup, topicList);
    }
}
