package com.epam.shop.controller;

import com.epam.shop.command.AbstractCommand;
import com.epam.shop.command.factory.CommandFactory;
import com.epam.shop.listener.RealPathListener;
import com.epam.shop.constant.ShopConstant;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="ShopController",urlPatterns={"/shop"})
public class ShopController extends HttpServlet {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 142077859315960143L;
    /** The Constant LOG. */
    private static final Logger LOGGER = Logger.getLogger(ShopController.class);

    /**
     * Process request.
     *
     * @param request
     *            the request
     * @param response
     *            the response
     */
    private void processRequest(HttpServletRequest request,
                                HttpServletResponse response) {
        String commandName = request.getParameter(ShopConstant.PARAM_COMMAND);
        AbstractCommand command = CommandFactory.createCommand(commandName);

        try {
            response.setContentType(ShopConstant.CONTENT_TYPE);
            command.execute(request, response);
        } catch (IOException e) {
            LOGGER.error("IOException.", e);
        } catch (ServletException e) {
            LOGGER.error("ServletException.", e);
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest
     * , javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest
     * , javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        processRequest(req, resp);
    }

}