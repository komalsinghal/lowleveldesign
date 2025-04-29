public class ProducerTask implements Runnable{
    Producer producer;
    String topicName;
    String message;

    public ProducerTask(Producer producer, String topicName, String message) {
        this.producer = producer;
        this.topicName = topicName;
        this.message = message;
    }

    @Override
    public void run() {
       producer.produce(topicName, message);
    }
}
