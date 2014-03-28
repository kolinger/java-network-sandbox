package benchmark.zmq.sync;

import benchmark.Message;
import org.zeromq.ZMQ;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;

/**
 * @author Tomáš Kolinger <tomas@kolinger.name>
 */
public class Listener {

    public static void main(String[] args) {
        ZMQ.Context context = ZMQ.context(1);
        ZMQ.Socket socket = context.socket(ZMQ.PULL);
        socket.bind("tcp://127.0.0.1:10000");

        int count = 0;
        long start = 0;
        while (true) {
            if (count == 0) {
                start = System.nanoTime();
            }
            count++;

            byte[] bytes = socket.recv(0);
            try {
                ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
                ObjectInputStream ois = new ObjectInputStream(bis);
                Message message = (Message) ois.readObject();

                if (message.content.equals("last") || message.content.equals("exit")) {
                    // print result
                    long time = (System.nanoTime() - start) / 1000000000;
                    System.out.println("Total requests: " + count + ", time: " + time + " s, speed: " +
                            (count / time) + " req/s");

                    // reset
                    count = 0;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
