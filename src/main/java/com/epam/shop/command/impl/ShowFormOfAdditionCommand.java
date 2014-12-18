package com.epam.shop.command.impl;

import com.epam.shop.command.AbstractCommand;
import com.epam.shop.constant.ShopConstant;
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
        String category = request.getParameter(PARAM_CATEGORY);
        String subcategory = request.getParameter(PARAM_SUBCATEGORY);
        TransformerManager transformerManager = TransformerManager.getInstance();

        try (PrintWriter writer = response.getWriter()) {
            Transformer transformer = transformerManager.getTransformer(xslAddProduct);
            transformer.setParameter(PARAM_CATEGORY, category);
            transformer.setParameter(PARAM_SUBCATEGORY, subcategory);
            transformerManager.transform(transformer, writer);
        } catch (TransformerException e) {
            LOGGER.error("TransformerException.", e);
        }
    }
}