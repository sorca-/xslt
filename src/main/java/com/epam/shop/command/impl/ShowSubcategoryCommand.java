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

import static com.epam.shop.constant.ShopConstant.*;

/**
 * The Class ShowSubcategoryCommand. Using for showing all subcategories.
 */
public final class ShowSubcategoryCommand extends AbstractCommand {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = Logger.getLogger(ShowSubcategoryCommand.class);

    /**
     * Instantiates a new show subcategory command.
     */
    public ShowSubcategoryCommand() {
        super();
        LOGGER.info("Creating 'ShowSubcategoryCommand' object.");
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

        String xslSubcategory = RealPathListener.getRealPath() + XSL_SUBCATEGORY;
        String category = request.getParameter(PARAM_CATEGORY);
        TransformerManager transformerManager = TransformerManager.getInstance();

        try (PrintWriter writer = response.getWriter()) {
            readLock.lock();
            LOGGER.debug("Locking read lock.");
            Transformer transformer = transformerManager.getTransformer(xslSubcategory);
            transformer.setParameter(PARAM_CATEGORY, category);
            transformerManager.transform(transformer, writer);
        } catch (TransformerException e) {
            LOGGER.error("TransformerException", e);
        } finally {
            readLock.unlock();
            LOGGER.debug("Unlocking read lock.");
        }
    }
}
