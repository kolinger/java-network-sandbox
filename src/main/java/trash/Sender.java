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
public class Sender {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ZMQ.Context context = ZMQ.context(1);

        System.out.println("Connecting to hello world server...");

        ZMQ.Socket requester = context.socket(ZMQ.REQ);
        requester.connect("tcp://127.0.0.1:10000");

        requester.send("msg");
        byte[] reply = requester.recv();
        System.out.println("Reply: " + new String(reply, "UTF-8"));

        for (int requestNbr = 0; requestNbr < 100000; requestNbr++) {
            Message message = new Message();
            message.sender = "sender :)";
            message.type = "type " + requestNbr;
            message.content = "hey";
            message.receivers.add("first");
            message.receivers.add("second");

            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream ous = new ObjectOutputStream(bos);
            ous.writeObject(message);

            requester.send(bos.toByteArray(), 0);

            byte[] reply2 = requester.recv(0);

            ByteArrayInputStream bis = new ByteArrayInputStream(reply);
            ObjectInputStream ois = new ObjectInputStream(bis);
            Message response = (Message) ois.readObject();

            //System.out.println(response);
        }
        requester.close();
        context.term();
    }
}
