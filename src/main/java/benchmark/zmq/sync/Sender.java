package benchmark.zmq.sync;

import benchmark.Message;
import org.zeromq.ZMQ;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;

/**
 * @author Tomáš Kolinger <tomas@kolinger.name>
 */
public class Sender {

    public static void main(String[] args) {
        ZMQ.Context context = ZMQ.context(1);
        ZMQ.Socket socket = context.socket(ZMQ.PUSH);
        socket.connect("tcp://127.0.0.1:10000");

        for (int count = 1; count <= 1000000; count++) {
            Message message = new Message();
            message.sender = "sender";
            message.receiver = "receiver";
            message.content = count == 1000000 ? "last" : "some content";

            try {
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                ObjectOutputStream ous = new ObjectOutputStream(bos);
                ous.writeObject(message);
                byte[] bytes = bos.toByteArray();

                socket.send(bytes, 0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        socket.close();
        context.close();
    }
}
