/**
 * @author Tomáš Kolinger <tomas@kolinger.name>
 */

[["java:package:benchmark.ice"]]
module internal {
    struct Message {
        string sender;
        string receiver;
        string content;
    };

    interface Transporter {
        void transport(Message msg);
    };
};