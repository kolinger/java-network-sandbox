package trash;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Tomáš Kolinger <tomas@kolinger.name>
 */
public class Message implements Serializable {

    public String sender;
    public String type;
    public String content;
    public List<String> receivers = new ArrayList<String>();

    @Override
    public String toString() {
        return "Message{" +
                "sender='" + sender + '\'' +
                ", type='" + type + '\'' +
                ", content='" + content + '\'' +
                ", receivers=" + receivers +
                '}';
    }
}
