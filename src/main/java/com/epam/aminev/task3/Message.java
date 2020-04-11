package com.epam.aminev.task3;

/**
 * Message object with which chat works and which
 * readers, writers and updaters operate
 *
 * @author Aminev Ramil
 */
public class Message {
    public static int messageCounter = 0;
    private int id;
    private String message;
    private int basedOn = -1;

    /**
     * Construct basic Message instance with unique id
     *
     * @param message that was constructed
     */
    public Message(String message) {
        id = messageCounter;
        messageCounter++;
        this.message = message;
    }

    /**
     * Construct new Message instance based on given Message
     *
     * @param instance of Message
     */
    public Message(Message instance) {
        id = messageCounter;
        messageCounter++;
        basedOn = instance.id;
        this.message = instance.message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getBaseMessageId() {
        return basedOn;
    }

    @Override
    public String toString() {
        return message;
    }

}
