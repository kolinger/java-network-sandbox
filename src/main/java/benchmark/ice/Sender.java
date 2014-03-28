package benchmark.ice;

import Ice.Communicator;
import Ice.InitializationData;
import Ice.ObjectPrx;
import Ice.Util;
import benchmark.ice.internal.Message;
import benchmark.ice.internal.TransporterPrx;
import benchmark.ice.internal.TransporterPrxHelper;

/**
 * @author Tomáš Kolinger <tomas@kolinger.name>
 */
public class Sender {

    public static void main(String[] args) {
        InitializationData initializationData = new InitializationData();
        initializationData.properties = Ice.Util.createProperties();
        initializationData.properties.setProperty("Ice.ThreadPool.Server.Size", "1");
        initializationData.properties.setProperty("Ice.ThreadPool.Server.SizeMax", "1");
        Communicator communicator = Util.initialize(initializationData);

        ObjectPrx proxy = communicator.stringToProxy("transporter:tcp -h 127.0.0.1 -p 10000");
        TransporterPrx transporter = TransporterPrxHelper.checkedCast(proxy);

        for (int count = 1; count <= 1000000; count++) {
            Message message = new Message();
            message.sender = "sender";
            message.receiver = "receiver";
            message.content = count == 1000000 ? "last" : "some content";

            transporter.transport(message);
        }
    }
}
