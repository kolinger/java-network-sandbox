package trash.multicast;

import org.zeromq.ZMQ;

/**
 * @author Tomáš Kolinger <tomas@kolinger.name>
 */
public class Publisher {
    public static void main(String[] args) throws Exception {
        ZMQ.Context context = ZMQ.context(1);

        ZMQ.Socket publisher = context.socket(ZMQ.PUB);
        publisher.bind("tcp://*:10000");

        while (!Thread.currentThread().isInterrupted()) {
            System.out.println("Sending hello...");
            publisher.send("hello subscriber".getBytes(), 0);
            Thread.sleep(1000);
        }

        publisher.close();
        context.term();
    }
}
