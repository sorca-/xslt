package com.epam.shop.entities;

import org.apache.log4j.Logger;

import java.io.Serializable;
import java.util.Date;

public class Product implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -3707207726859490440L;
    /** The Constant LOG. */
    private static final Logger LOGGER = Logger.getLogger(Product.class);
    /** The id. */
    private int id;
    /** The model. */
    private String model;
    /** The price. */
    private double price;
    /** The producer. */
    private String producer;
    /** The color. */
    private String color;
    /** The date of issue. */
    private Date dateOfIssue;
    /** In stock. */
    private boolean inStock;

    /**
     * Instantiates a new product.
     */
    public Product() {
        super();
        LOGGER.debug("Creating new product.");
    }

    /**
     * Instantiates a new product.
     *
     * @param model
     *            the model
     * @param color
     *            the color
     * @param dateOfIssue
     *            the date of issue
     * @param price
     *            the price
     * @param producer
     *            the producer
     * @param inStock
     *            the not in stock
     */
    public Product(String model, String color, Date dateOfIssue, double price,
                   String producer, boolean inStock) {
        this.model = model;
        this.producer = producer;
        this.dateOfIssue = dateOfIssue;
        this.inStock = inStock;
        this.price = price;
        this.color = color;
        LOGGER.debug("Creating new product with params.");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Date getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(Date dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }
}
