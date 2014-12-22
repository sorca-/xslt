package com.epam.shop.command.impl;

import com.epam.shop.command.AbstractCommand;
import com.epam.shop.listener.RealPathListener;
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
import java.util.HashMap;
import java.util.Map;

import static com.epam.shop.constant.ShopConstant.PARAM_CATEGORY;
import static com.epam.shop.constant.ShopConstant.PARAM_SUBCATEGORY;

/**
 * The Class ShowProductsCommand. Using for showing all products selected
 * category.
 */
public final class ShowProductsCommand extends AbstractCommand {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = Logger.getLogger(ShowProductsCommand.class);

    /**
     * Instantiates a new show products command.
     */
    public ShowProductsCommand() {
        super();
        LOGGER.info("Creating 'ShowProductsCommand' object.");
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * com.epam.shop.command.ICommand#execute(javax.servlet.http.HttpServletRequest
     * , javax.servlet.http.HttpServletResponse)
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String xslProducts = RealPathListener.getRealPath() + ShopConstant.XSL_PRODUCTS;
        TransformerManager transformerManager = TransformerManager.getInstance();

        try (PrintWriter writer = response.getWriter()) {
            readLock.lock();
            LOGGER.debug("Locking read lock.");
            Transformer transformer = transformerManager.getTransformer(xslProducts);
            pushParamsFromRequest(request, transformer,PARAM_CATEGORY, PARAM_SUBCATEGORY);
            transformerManager.transform(transformer, writer);
        } catch (TransformerException e) {
            LOGGER.error("TransformerException.", e);
        } finally {
            readLock.unlock();
            LOGGER.debug("Unlocking read lock.");
        }
    }
}