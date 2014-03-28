package trash.multicast;

import org.zeromq.ZMQ;

/**
 * @author Tomáš Kolinger <tomas@kolinger.name>
 */
public class Subscriber {
    public static void main(String[] args) throws Exception {
        ZMQ.Context context = ZMQ.context(1);

        System.out.println("Creating connection");
        ZMQ.Socket subscriber = context.socket(ZMQ.SUB);
        subscriber.connect("tcp://127.0.0.1:10000");

        System.out.println("Subscribe");
        subscriber.subscribe("".getBytes());

        for (int update_nbr = 0; update_nbr < 100; update_nbr++) {
            String string = new String(subscriber.recv(0), "UTF-8");
            System.out.println("RESPONSE: " + string);
        }

        subscriber.close();
        context.term();
    }
}
