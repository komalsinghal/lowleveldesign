public class ConsumerTask implements  Runnable{
    KafkaService kafkaService;
    String topicName;
    String groupId;

    public ConsumerTask(KafkaService kafkaService, String topicName, String groupId) {
        this.kafkaService = kafkaService;
        this.topicName = topicName;
        this.groupId = groupId;
    }

    @Override
    public void run() {
        kafkaService.poll(topicName, groupId);
    }
}
