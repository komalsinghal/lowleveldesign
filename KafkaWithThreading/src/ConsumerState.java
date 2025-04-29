import java.util.HashMap;
import java.util.Map;

public class ConsumerState {

    Map<String, Integer> topicOffsets = new HashMap<>();

    public synchronized int getOffset(String topic) {
        return topicOffsets.getOrDefault(topic, 0);
    }

    public synchronized void incrementOffset(String topic) {
        topicOffsets.put(topic, getOffset(topic) + 1);
    }
}
