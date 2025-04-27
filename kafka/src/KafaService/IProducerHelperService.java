package KafaService;

import KafaService.Common.ConsumerGroup;
import KafaService.Common.Message;
import KafaService.Common.Topic;
import jdk.jshell.spi.ExecutionControl;

import java.util.List;

public interface IProducerHelperService {
  public void publishMessage(Message message, List<Topic> topicList);

}
