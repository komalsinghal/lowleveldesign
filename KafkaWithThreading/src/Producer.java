import java.util.UUID;

public class Producer {
    String producerId;
    KafkaService kafkaService;

    public Producer(String producerId, KafkaService kafkaService) {
        this.producerId = producerId;
        this.kafkaService = kafkaService;
    }

    public void produce(String topicName, String payload){
        Message message = new Message(UUID.randomUUID().toString(), payload);
        kafkaService.publish(topicName, message);
        System.out.println("Producer " + producerId + " published to " + topicName + ": " + payload);
    }
}
