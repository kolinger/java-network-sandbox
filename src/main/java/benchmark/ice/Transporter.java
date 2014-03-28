package benchmark.ice;

import Ice.Communicator;
import Ice.Current;
import benchmark.ice.internal.Message;
import benchmark.ice.internal._TransporterDisp;

/**
 * @author Tomáš Kolinger <tomas@kolinger.name>
 */
public class Transporter extends _TransporterDisp {

    private int count = 0;
    private long start = 0;

    public synchronized void transport(Message message, Current current) {
        if (count == 0) {
            start = System.nanoTime();
        }
        count++;

        if (message.content.equals("last") || message.content.equals("exit")) {
            // print result
            long time = (System.nanoTime() - start) / 1000000000;
            System.out.println("Total requests: " + count + ", time: " + time + " s, speed: " +
                    (count / time) + " req/s");

            // reset
            count = 0;
        }
    }
}
