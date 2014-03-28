package benchmark.rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @author Tomáš Kolinger <tomas@kolinger.name>
 */
public class Listener {

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(10000);
            registry.rebind("transporter", new TransporterImpl());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
