package KafaService.Common;

import java.util.Map;

public class ConsumerGroup {
    Map<Topic, Offset> TopicVsLastValidOffset;
    public Offset getLastOffset(Topic topic)
    {
        return TopicVsLastValidOffset.get(topic);
    }
}
