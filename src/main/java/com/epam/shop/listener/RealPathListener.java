package com.epam.shop.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public final class RealPathListener implements ServletContextListener {


    public RealPathListener() {
        super();
    }

    private static String realPath = null;


    @Override
    public void contextDestroyed(ServletContextEvent context) {
    }


    @Override
    public void contextInitialized(ServletContextEvent context) {
        realPath = context.getServletContext().getRealPath("");
    }

    public static String getRealPath() {
        return realPath;
    }
}