//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        KafkaService kafkaService = new KafkaService();
        kafkaService.createTopic("sports");
        kafkaService.createTopic("news");

        Producer producer1 = new Producer("p1", kafkaService);
        Producer producer2 = new Producer("p2", kafkaService);

// Publishing to multiple topics
       /* producer1.produce("sports", "Football Match Tonight");
        producer1.produce("news", "Breaking News: Economy Growth");*/

// Consumers
        Consumer consumer1 = new Consumer("c1");
        Consumer consumer2 = new Consumer("c2");
        Consumer consumer3 = new Consumer("c3");
        Consumer consumer4 = new Consumer("c4");

        kafkaService.subscribe("sports", "group1", consumer1);
        kafkaService.subscribe("news", "group1", consumer1);
        kafkaService.subscribe("sports", "group1", consumer2);

        kafkaService.subscribe("sports", "group2", consumer3);
        kafkaService.subscribe("news", "group2", consumer4);
        kafkaService.subscribe("sports", "group2", consumer4);

// Polling both topics
       /* broker.poll("sports", "group1");
        broker.poll("news", "group1");
        broker.poll("sports", "group2");
        broker.poll("news", "group2");*/


        //With threading-1

        // Producer Threads
        Thread pThread1 = new Thread(() -> producer1.produce("sports", "Football Match Tonight!"));
        Thread pThread2 = new Thread(() -> producer2.produce("news", "Breaking News: Economy is booming!"));
        Thread pThread3 = new Thread(() -> producer1.produce("sports", "Cricket World Cup coming!"));
        Thread pThread4 = new Thread(() -> producer2.produce("news", "Weather Update: Sunny tomorrow"));

        // Start producer threads
        pThread1.start();
        pThread2.start();
        pThread3.start();
        pThread4.start();

        // Wait for producers to finish
        pThread1.join();
        pThread2.join();
        pThread3.join();
        pThread4.join();

        // Consumer Threads
        Thread cThread1 = new Thread(() -> kafkaService.poll("sports", "group1"));
        Thread cThread2 = new Thread(() -> kafkaService.poll("news", "group1"));
        Thread cThread3 = new Thread(() -> kafkaService.poll("sports", "group1"));
        Thread cThread4 = new Thread(() -> kafkaService.poll("news", "group1"));

        Thread cThread5 = new Thread(() -> kafkaService.poll("sports", "group2"));
        Thread cThread6 = new Thread(() -> kafkaService.poll("news", "group2"));
        Thread cThread7 = new Thread(() -> kafkaService.poll("sports", "group2"));
        Thread cThread8 = new Thread(() -> kafkaService.poll("news", "group2"));


        // Start consumer threads
        cThread1.start();
        cThread2.start();
        cThread3.start();
        cThread4.start();
        cThread5.start();
        cThread6.start();
        cThread7.start();
        cThread8.start();


        // Wait for consumers to finish
        cThread1.join();
        cThread2.join();
        cThread3.join();
        cThread4.join();
        cThread5.join();
        cThread6.join();
        cThread7.join();
        cThread8.join();

/*//WIth Threading-2 - Runnable using ProducerTask, ConsumerTask

        Broker broker1 = new Broker();

        // Create topics
        broker1.createTopic("sports");
        broker1.createTopic("news");

        // Create producers
        Producer producer11 = new Producer("p1", broker);
        Producer producer21 = new Producer("p2", broker);

        // Create consumers
        Consumer consumer11 = new Consumer("c1");
        Consumer consumer21 = new Consumer("c2");

        // Subscribe consumers
        broker.subscribe("sports", "group1", consumer1);
        broker.subscribe("sports", "group1", consumer2);
        broker.subscribe("news", "group1", consumer1);

        // Create a fixed thread pool
        ExecutorService executor = Executors.newFixedThreadPool(5);

        // Submit producer tasks
        executor.submit(new ProducerTask(producer11, "sports", "Football Match Tonight!"));
        executor.submit(new ProducerTask(producer21, "news", "Breaking News: Economy is booming!"));
        executor.submit(new ProducerTask(producer11, "sports", "Cricket World Cup coming!"));
        executor.submit(new ProducerTask(producer21, "news", "Weather Update: Sunny tomorrow"));

        // Give some time for producers to produce messages
        Thread.sleep(500);

        // Submit consumer tasks
        executor.submit(new ConsumerTask(broker, "sports", "group1"));
        executor.submit(new ConsumerTask(broker, "news", "group1"));
        executor.submit(new ConsumerTask(broker, "sports", "group1"));
        executor.submit(new ConsumerTask(broker, "news", "group1"));

        // Shutdown executor
        executor.shutdown();*/
    }

}