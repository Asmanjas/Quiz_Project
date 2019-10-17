package com.asmanjas.quizproject;

public class HotStockEntity {

    private String ticker;
    private float price;


    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }


    public String toString(){
        return "(Hotstock ticker=" + ticker + "price=" + price + "}";
    }



}
