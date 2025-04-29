import java.util.HashMap;
import java.util.Map;

public class Consumer {
    private final String id;

    public Consumer(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
   /* public void addConsumerGroup(ConsumerGroup group){
        consumerGroupMap.putIfAbsent(group.getGroupId(), group);
    }*/

    public void consume(Message message, String topicName) {

        System.out.println("Consumer " + id + " consumed message: " + message.getPayload() + "from topic " + topicName);
    }

    /*public void consume(String topicName, String groupId){
        ConsumerGroup group = consumerGroupMap.get(groupId);
        Map<String, Integer> groupOffset = group.getGroupOffset();
        Integer offset = groupOffset.get(topicName);
        group.consume(topicName);

    }*/
}
