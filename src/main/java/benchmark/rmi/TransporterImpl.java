package benchmark.rmi;

import benchmark.ice.internal.Message;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author Tomáš Kolinger <tomas@kolinger.name>
 */
public class TransporterImpl extends UnicastRemoteObject implements Transporter {

    private int count = 0;
    private long start = 0;

    protected TransporterImpl() throws RemoteException {
    }

    public synchronized void transport(Message message) throws RemoteException {
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
