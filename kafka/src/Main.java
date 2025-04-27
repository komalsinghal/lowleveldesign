import KafaService.KafkaService;
import KafaService.ProducerHelperService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        /*
        Message -
         String
         */
        ProducerHelperService producerHelperService = new ProducerHelperService();
        KafkaService kafkaService = new KafkaService(producerHelperService);
        //kafkaService.publishMessage();

    }
}