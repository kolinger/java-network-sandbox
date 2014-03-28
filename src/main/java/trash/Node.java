package trash;

import org.zeromq.ZMQ;

/**
 * @author Tomáš Kolinger <tomas@kolinger.name>
 */
public class Node {

    private static Thread serverThread;

    public static void main(String[] args) throws Exception {
        serverThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    runServer();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        serverThread.start();
        if (args.length > 0) {
            runClient(args[0]);
        }
    }

    public static void runServer() throws Exception {
        ZMQ.Context context = ZMQ.context(1);

        ZMQ.Socket subscriber = context.socket(ZMQ.SUB);
        subscriber.connect("tcp://127.0.0.1:10000");
        subscriber.subscribe("".getBytes());

        int count = 0;
        long start = System.nanoTime();
        while (!Thread.currentThread().isInterrupted()) {
            byte[] bytes = subscriber.recv();
            System.out.println(new String(bytes, "UTF-8"));
        }

        long time = (System.nanoTime() - start) / 1000000000;
        System.out.println("Speed: " + (count / time) + " req/s");

        subscriber.close();
        context.term();
    }

    public static void runClient(String port) throws Exception {
        ZMQ.Context context = ZMQ.context(1);

        ZMQ.Socket client = context.socket(ZMQ.DEALER);
        client.connect("tcp://127.0.0.1:" + port);

        for (int count = 1; count <= 100000; count++) {
            client.send("My port is: " + port + " and i sending request number #" + count);
        }

        serverThread.interrupt();

        client.close();
        context.term();
    }
}
