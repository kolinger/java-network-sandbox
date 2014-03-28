package trash.multicast;

import org.zeromq.ZMQ;

/**
 * @author Tomáš Kolinger <tomas@kolinger.name>
 */
public class Test {
    public static void main(String[] args) {
        //  Prepare our context and sockets
        ZMQ.Context context = ZMQ.context(1);

        //  This is where the weather server sits
        ZMQ.Socket frontend = context.socket(ZMQ.SUB);
        frontend.connect("tcp://127.0.0.1:5556");

        //  This is our public endpoint for subscribers
        ZMQ.Socket backend = context.socket(ZMQ.PUB);
        backend.bind("tcp://127.0.0.1:5556");

        //  Subscribe on everything
        frontend.subscribe("".getBytes());

        frontend.close();
        backend.close();
        context.term();
    }
}
