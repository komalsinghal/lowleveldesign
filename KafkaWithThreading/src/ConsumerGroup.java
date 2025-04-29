import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConsumerGroup {
    private final String groupId;
    private final List<Consumer> consumers = new ArrayList<>();
    //private final Map<String, ConsumerState> consumerOffsets = new HashMap<>();
    private final Map<String, Integer> groupOffset = new HashMap<>();  //TopicVsOffset Map
    private final  Map<String, Integer> topicNextConsumerIndex =  new HashMap<>();

    public ConsumerGroup(String groupId) {
        this.groupId = groupId;
    }

    public synchronized void addConsumer(Consumer consumer) {
        consumers.add(consumer);
        //consumerOffsets.putIfAbsent(consumer.getId(), new ConsumerState());
    }

    public synchronized void consume(String topicName, List<Message> messages)
    {
        if(messages.isEmpty() || consumers.isEmpty()) return;
        int offset = groupOffset.getOrDefault(topicName, 0);
        if (offset >= messages.size()) {
            return; // No new messages to consume
        }
        Message message = messages.get(offset);
        Integer nextConsumerIndex = topicNextConsumerIndex.getOrDefault(topicName,0);
        Consumer consumer = consumers.get(nextConsumerIndex);
        consumer.consume(message, topicName);
        nextConsumerIndex = (nextConsumerIndex+1)%(consumers.size());
        topicNextConsumerIndex.putIfAbsent(topicName, nextConsumerIndex);
        groupOffset.putIfAbsent(topicName, offset+1);

    }

    public String getGroupId() {
        return groupId;
    }

    public Map<String, Integer> getGroupOffset() {
        return groupOffset;
    }

    public Map<String, Integer> getTopicNextConsumerIndex() {
        return topicNextConsumerIndex;
    }

    public List<Consumer> getConsumers() {
        return consumers;
    }

}
