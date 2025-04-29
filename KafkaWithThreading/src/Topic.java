import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static sun.jvm.hotspot.oops.CellTypeState.ref;

public class Topic {
    private final String name;
    private final List<Message> messages = new ArrayList<>();
    public final Map<String, ConsumerGroup> consumerGroups = new HashMap<>(); //ConsumergroupId versus consumerGroup
   // private final Lock lock = new ReentrantLock();

    public Topic(String name) {
        this.name = name;
    }

    public synchronized void publish(Message message)
    {
      // lock.lock();
        messages.add(message);
    }

    public synchronized void consume(String consumerGroupId, String topicName){
        ConsumerGroup consumerGroup = consumerGroups.get(consumerGroupId);
        if(consumerGroup == null) return;

        consumerGroup.consume(topicName,messages);
    }

    public void registerConsumerGroup(ConsumerGroup group)
    {
        consumerGroups.putIfAbsent(group.getGroupId(), group);
    }

}
