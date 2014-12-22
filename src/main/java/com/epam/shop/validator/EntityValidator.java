package com.epam.shop.validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;


public class EntityValidator {
    private static final Logger LOGGER = Logger.getLogger(EntityValidator.class);

    private String producer;
    private String model;
    private String dateOfIssue;
    private String color;
    private String price;
    private boolean inStock;

    public EntityValidator(){
        LOGGER.info("create validator");
        producer = null;
        model = null;
        dateOfIssue = null;
        color = null;
        price = null;
        inStock = false;
    }


    public boolean isProductValid(){
        return isProducerValid() &&
                isModelValid() &&
                isDateOfIssueValid() &&
                isColorValid() &&
                isPriceValid();
    }

    public boolean isProducerValid() {
        return notEmpty(producer);
    }

    public boolean isModelValid() {
        return notEmpty(model) && model.matches("[A-Za-z]{2}[0-9]{3}");
    }

    public boolean isDateOfIssueValid() {
        if (notEmpty(dateOfIssue)) {
            try {
                new SimpleDateFormat("dd-MM-yyyy").parse(dateOfIssue);
                return true;
            } catch (ParseException e) {
                return false;
            }
        }
        return false;
    }

    public boolean isColorValid() {
        return notEmpty(color);
    }

    public boolean isPriceValid() {
        return price!=null && price.matches("\\d+");
    }

    private boolean notEmpty(String param) {
        return null != param && !param.isEmpty();
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(String date) {
        this.dateOfIssue = date;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    @Override
    public String toString() {
        return "EntityValidator{" +
                "producer='" + producer + '\'' +
                ", model='" + model + '\'' +
                ", dateOfIssue='" + dateOfIssue + '\'' +
                ", color='" + color + '\'' +
                ", price='" + price + '\'' +
                ", inStock='" + inStock + '\'' +
                '}';
    }

    public String errorMessageForProducer(){
        return "Invalid producer. Producer should not be empty.";
    }
    public String errorMessageForModel(){
        return "Invalid model. Format for model is 'XXNNN', where X is a letter, N is a number";
    }
    public String errorMessageForDate(){
        return "Invalid date. Format for date is 'DD-MM-YYYY'";
    }
    public String errorMessageForColor(){
        return "Invalid color. Color should not be empty.";
    }
    public String errorMessageForPrice(){
        return "Invalid price. Price should not be empty.";
    }
}