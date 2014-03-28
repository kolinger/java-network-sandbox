package benchmark.rmi;

import benchmark.ice.internal.Message;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @author Tomáš Kolinger <tomas@kolinger.name>
 */
public class Sender {

    public static void main(String[] args) {
        try {
            Registry stub = LocateRegistry.getRegistry("127.0.0.1", 10000);
            Transporter transporter = (Transporter) stub.lookup("transporter");

            for (int count = 1; count <= 1000000; count++) {
                Message message = new Message();
                message.sender = "sender";
                message.receiver = "receiver";
                message.content = count == 1000000 ? "last" : "some content";

                transporter.transport(message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
