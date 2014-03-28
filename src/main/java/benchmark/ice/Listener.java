package benchmark.ice;

import Ice.Communicator;
import Ice.InitializationData;
import Ice.ObjectAdapter;
import Ice.Util;

/**
 * @author Tomáš Kolinger <tomas@kolinger.name>
 */
public class Listener {

    public static void main(String[] args) {
        InitializationData initializationData = new InitializationData();
        initializationData.properties = Ice.Util.createProperties();
        initializationData.properties.setProperty("Ice.ThreadPool.Server.Size", "1");
        initializationData.properties.setProperty("Ice.ThreadPool.Server.SizeMax", "1");
        Communicator communicator = Util.initialize(initializationData);

        ObjectAdapter adapter = communicator.createObjectAdapterWithEndpoints("Transporter", "tcp -h 127.0.0.1 -p 10000");
        adapter.add(new Transporter(), communicator.stringToIdentity("transporter"));
        adapter.activate();

        communicator.waitForShutdown();
    }
}
