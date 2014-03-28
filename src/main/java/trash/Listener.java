package trash;

import org.zeromq.ZMQ;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author Tomáš Kolinger <tomas@kolinger.name>
 */
public class Listener {

    public static void main(String[] args) throws InterruptedException, IOException, ClassNotFoundException {
        ZMQ.Context context = ZMQ.context(1);

        //  Socket to talk to clients
        ZMQ.Socket responder = context.socket(ZMQ.REP);
        responder.bind("tcp://*:5555");

        int count = 0;
        long start = System.nanoTime();
        while (!Thread.currentThread().isInterrupted()) {
            count++;
            byte[] request = responder.recv(0);
            ByteArrayInputStream bis = new ByteArrayInputStream(request);
            ObjectInputStream ois = new ObjectInputStream(bis);
            Message response = (Message) ois.readObject();

            response.content = "hi mate";

            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream ous = new ObjectOutputStream(bos);
            ous.writeObject(response);

            responder.send(bos.toByteArray(), 0);
            if (count == 100000) {
                break;
            }
        }
        long time = (System.nanoTime() - start) / 1000000000;
        System.out.println("Speed: " + (count / time) + " req/s");
        responder.close();
        context.term();
    }
}
