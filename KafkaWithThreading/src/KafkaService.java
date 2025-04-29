import java.util.HashMap;
import java.util.Map;

public class KafkaService {
    private final Map<String, Topic> topics = new HashMap<>();

    public synchronized void createTopic(String topicName)
    {
        Topic topic = new Topic(topicName);
        topics.putIfAbsent(topicName, topic);
    }

    public synchronized void publish(String topicName, Message message){
        Topic topic = topics.get(topicName);
        if(topic != null){
            topic.publish(message);
        }
    }

    public synchronized void subscribe(String topicName, String groupId, Consumer consumer) {
        topics.putIfAbsent(topicName, new Topic(topicName));
        Topic topic = topics.get(topicName);
        ConsumerGroup group = topic.consumerGroups.getOrDefault(groupId, new ConsumerGroup(groupId));
        group.addConsumer(consumer);
        topic.registerConsumerGroup(group);
    }

    public synchronized void poll(String topicName, String consumerGroupId) {
        Topic topic = topics.get(topicName);
        if (topic != null) {
            topic.consume(consumerGroupId, topicName);
        }
    }

}
