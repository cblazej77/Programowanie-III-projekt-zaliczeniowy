package com.example.zaliczenieklient2;

public class SendDataToContoller {
    private static final SendDataToContoller instance = new SendDataToContoller();

    private String username;

    private Client client;
    private SendDataToContoller() {
    }
    public static SendDataToContoller getInstance() {
        return instance;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }
}
