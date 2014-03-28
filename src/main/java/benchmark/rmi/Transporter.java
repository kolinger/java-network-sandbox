package benchmark.rmi;

import benchmark.ice.internal.Message;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author Tomáš Kolinger <tomas@kolinger.name>
 */
public interface Transporter extends Remote {

    void transport(Message message) throws RemoteException;
}
