package com.epam.shop.command.impl;

import com.epam.shop.command.AbstractCommand;
import com.epam.shop.listener.RealPathListener;
import com.epam.shop.util.TransformerManager;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

import static com.epam.shop.constant.ShopConstant.*;

public class SaveProductCommand extends AbstractCommand {
    private static final Logger LOGGER = Logger.getLogger(SaveProductCommand.class);

    public SaveProductCommand() {
        super();
        LOGGER.info("Creating 'CreateProductCommand' object");
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String xslSave = request.getServletContext().getRealPath(XSL_SAVE_PRODUCT);
        File file = new File(RealPathListener.getRealPath() + XML_SHOP_TEST);
        try (Writer fileWriter = new PrintWriter(file, "UTF-8");
             Writer stringWriter = new StringWriter()) {
            Result result = new StreamResult(stringWriter);
            TransformerManager transformerManager = TransformerManager.getInstance();
            Transformer transformer = transformerManager.getTransformer(xslSave);
            boolean inStock = Boolean.valueOf(request.getParameter(PARAM_IN_STOCK));
            pushParams(request, transformer, PARAM_PRODUCER, PARAM_MODEL, PARAM_DATE_OF_ISSUE, PARAM_COLOR, PARAM_PRICE,
                    PARAM_CATEGORY, PARAM_SUBCATEGORY);
            transformer.setParameter(PARAM_IN_STOCK, inStock);
            transformerManager.transform(transformer, result);
            fileWriter.write(stringWriter.toString());
            fileWriter.flush();

        } catch (TransformerException e) {
            LOGGER.error("TransformerException.", e);
        }
    }

    private void pushParams (HttpServletRequest request, Transformer transformer, String... paramNames) {
        for (String paramName : paramNames) {
            String param = request.getParameter(paramName);
            transformer.setParameter(paramName, param);
        }
    }
}
