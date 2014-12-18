package com.epam.shop.util;

import java.io.PrintWriter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.validation.Path;
import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import com.epam.shop.constant.ShopConstant;
import org.apache.log4j.Logger;

import com.epam.shop.listener.RealPathListener;

public final class TransformerManager {

    private static final Logger LOGGER = Logger.getLogger(TransformerManager.class);

    private TransformerFactory transformerFactory;
    private ConcurrentHashMap<String, Templates> cache;

    private TransformerManager() {
        super();
        transformerFactory = TransformerFactory.newInstance();
        cache = new ConcurrentHashMap<>();
        LOGGER.debug("Init instance");
    }

    public Transformer getTransformer (String xslPath) throws TransformerException {
        Templates templates = transformerFactory.newTemplates(new StreamSource(xslPath));
        getInstance().cache.putIfAbsent(xslPath, templates);
        Transformer transformer = getInstance().cache.get(xslPath).newTransformer();
        LOGGER.info("Transformation successful.");
        return transformer;
    }

    public void transform (Transformer transformer, PrintWriter writer) throws TransformerException {
        Source xmlSource = new StreamSource(RealPathListener.getRealPath() + ShopConstant.XML_SHOP);
        StreamResult streamResult = new StreamResult(writer);
        transformer.transform(xmlSource, streamResult);
    }

    public void transform (Transformer transformer, Result result) throws TransformerException {
        Source xmlSource = new StreamSource(RealPathListener.getRealPath() + ShopConstant.XML_SHOP);
        transformer.transform(xmlSource, result);
    }

    private static class SingletonHolder {
        private final static TransformerManager instance = new TransformerManager();
    }

    public static TransformerManager getInstance () {
        return SingletonHolder.instance;
    }

}