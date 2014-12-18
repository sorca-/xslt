package com.epam.shop.command.impl;

import com.epam.shop.command.AbstractCommand;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * The Class EmptyCommand.
 */
public class EmptyCommand extends AbstractCommand {

    /** The Constant LOG. */
    private static final Logger LOGGER = Logger.getLogger(EmptyCommand.class);

    /**
     * Instantiates a new no command.
     */
    public EmptyCommand() {
        super();
        LOGGER.debug("Creating empty command.");
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
        // no need to put any lock
    }
}
