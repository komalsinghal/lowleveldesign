package KafaService.Controller;

import KafaService.Common.ConsumerGroup;
import KafaService.Common.Offset;
import KafaService.Common.Topic;

import java.util.List;
import java.util.Map;

public class ConsumerGroupController {
    Map<ConsumerGroup, List<Topic>> CgVsTopic;
    public Offset getLastOffset(ConsumerGroup consumerGroup, Topic topic){
        return consumerGroup.getLastOffset(topic);
    }
}
