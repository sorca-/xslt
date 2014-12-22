package com.epam.shop.command.impl;

import com.epam.shop.command.AbstractCommand;
import com.epam.shop.constant.ShopConstant;
import com.epam.shop.entities.Product;
import com.epam.shop.util.TransformerManager;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.io.PrintWriter;

import static com.epam.shop.constant.ShopConstant.PARAM_CATEGORY;
import static com.epam.shop.constant.ShopConstant.PARAM_SUBCATEGORY;

public final class ShowFormOfAdditionCommand extends AbstractCommand {

    private static final Logger LOGGER = Logger.getLogger(ShowFormOfAdditionCommand.class);

    public ShowFormOfAdditionCommand() {
        super();
        LOGGER.info("Creating 'CreateProductCommand' object");
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String xslAddProduct = request.getServletContext().getRealPath(ShopConstant.XSL_ADD_PRODUCT);
        TransformerManager transformerManager = TransformerManager.getInstance();

        try (PrintWriter writer = response.getWriter()) {
            Transformer transformer = transformerManager.getTransformer(xslAddProduct);
            Product product = getProduct(request);
            transformer.setParameter("product", product);
            LOGGER.debug("Locking read lock.");
            readLock.lock();
            transformerManager.transform(transformer, writer);
        } catch (TransformerException e) {
            LOGGER.error("TransformerException.", e);
        } finally {
            readLock.unlock();
            LOGGER.debug("Unlocking read lock.");
        }
    }

    private Product getProduct (HttpServletRequest request) {
        Product product = (Product)request.getAttribute("product");
        if (product == null) {
            product = new Product();
            product.setCategory(request.getParameter(PARAM_CATEGORY));
            product.setSubcategory(request.getParameter(PARAM_SUBCATEGORY));
        }
        return product;
    }
}