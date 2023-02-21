package com.example.simulatedeviceproducer.ignore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@ToString
public class CustomMessage {

    private String messageId;
    private String message;
    private Date messageDate;

    public CustomMessage() {
    }

    public CustomMessage(String messageId, String message, Date messageDate) {
        this.messageId = messageId;
        this.message = message;
        this.messageDate = messageDate;
    }

    public CustomMessage(String message) {
        this.message = message;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(Date messageDate) {
        this.messageDate = messageDate;
    }
}










