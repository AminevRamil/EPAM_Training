package com.epam.aminev.task3;

public class Message {
    public static int messageCounter = 0;
    private int id;
    private String message;
    private int basedOn = -1;

    public Message(String message){
        id = messageCounter;
        messageCounter++;
        this.message = message;
    }

    public Message(Message instance){
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
