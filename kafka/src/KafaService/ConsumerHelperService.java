package KafaService;

import KafaService.Common.ConsumerGroup;
import KafaService.Common.Message;
import KafaService.Common.Topic;
import jdk.jshell.spi.ExecutionControl;

import java.util.List;

public class ConsumerHelperService implements IConsumerHelperService {

    public boolean subscribeToTopic(ConsumerGroup cg, List<Topic> topicList){
        return  true;
    }
    public void ConsumeMessage(Topic topic, ConsumerGroup group){

    }
}
