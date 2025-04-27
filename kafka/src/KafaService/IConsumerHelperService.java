package KafaService;

import KafaService.Common.ConsumerGroup;
import KafaService.Common.Topic;
import jdk.jshell.spi.ExecutionControl;

import java.util.List;

public interface IConsumerHelperService {
    public boolean subscribeToTopic(ConsumerGroup cg, List<Topic> topicList);
    public void ConsumeMessage(Topic topic, ConsumerGroup group);
}
