package com.epam.shop.command.impl;

import com.epam.shop.command.AbstractCommand;
import com.epam.shop.constant.ShopConstant;
import com.epam.shop.listener.RealPathListener;
import com.epam.shop.util.TransformerManager;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * The Class ShowCategoryCommand. Using for showing all categories.
 */
public final class ShowCategoryCommand extends AbstractCommand {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = Logger.getLogger(ShowCategoryCommand.class);

    /**
     * Instantiates a new show category command.
     */
    public ShowCategoryCommand() {
        super();
        LOGGER.debug("Creating 'ShowCategoryCommand' object.");
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

        String xslCategory = RealPathListener.getRealPath() + ShopConstant.XSL_CATEGORY;

        try (PrintWriter writer = response.getWriter()) {
            readLock.lock();// add read lock
            LOGGER.debug("Locking read lock.");
            TransformerManager transformerManager = TransformerManager.getInstance();
            Transformer transformer = transformerManager.getTransformer(xslCategory);
            transformerManager.transform(transformer, writer);
        } catch (TransformerException e) {
            LOGGER.error("TransformerException.", e);
        } finally {
            readLock.unlock();
            LOGGER.debug("Unlocking write lock");
        }
    }
}