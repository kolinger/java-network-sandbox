package benchmark;

import java.io.Serializable;

/**
 * @author Tomáš Kolinger <tomas@kolinger.name>
 */
public class Message implements Serializable {

    public String sender;
    public String receiver;
    public String content;
}
