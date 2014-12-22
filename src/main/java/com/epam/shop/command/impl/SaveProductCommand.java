package com.epam.shop.command.impl;

import com.epam.shop.command.AbstractCommand;
import com.epam.shop.listener.RealPathListener;
import com.epam.shop.util.TransformerManager;
import com.epam.shop.validator.EntityValidator;
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
        EntityValidator entityValidator = new EntityValidator();
        File file = new File(RealPathListener.getRealPath() + XML_SHOP_TEST);
        String category = request.getParameter(PARAM_CATEGORY);
        String subcategory = request.getParameter(PARAM_SUBCATEGORY);

        //todo: StandardCharsets.UTF_8?
        try (Writer fileWriter = new PrintWriter(file, UTF8);
             Writer stringWriter = new StringWriter()) {
            Result result = new StreamResult(stringWriter);

            TransformerManager transformerManager = TransformerManager.getInstance();
            Transformer transformer = transformerManager.getTransformer(xslSave);

            validateParams(request, new EntityValidator());
            pushParamsFromRequest(request, transformer, PARAM_CATEGORY, PARAM_SUBCATEGORY);
            transformer.setParameter(PARAM_VALIDATOR, entityValidator);

            readLock.lock();
            transformerManager.transform(transformer, result);

            if (entityValidator.isProductValid()) {
                String link = "/shop?command=show_products&category="+category+"&subcategory="+subcategory;
                fileWriter.write(stringWriter.toString());
                fileWriter.flush();
                response.sendRedirect(link);
            } else {
                response.getWriter().write(stringWriter.toString());
            }



        } catch (TransformerException e) {
            LOGGER.error("TransformerException.", e);
        } finally {
            readLock.unlock();
        }
    }

    private EntityValidator validateParams(HttpServletRequest request, EntityValidator entityValidator) {
        entityValidator.setInStock(Boolean.valueOf(request.getParameter(PARAM_IN_STOCK)));
        entityValidator.setColor(request.getParameter(PARAM_COLOR));
        entityValidator.setProducer(request.getParameter(PARAM_PRODUCER));
        entityValidator.setDateOfIssue(request.getParameter(PARAM_DATE_OF_ISSUE));
        entityValidator.setModel(request.getParameter(PARAM_MODEL));
        entityValidator.setPrice(request.getParameter(PARAM_PRICE));
        entityValidator.setColor(request.getParameter(PARAM_COLOR));

        return entityValidator;
    }
}
