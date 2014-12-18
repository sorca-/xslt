package com.epam.shop.command.factory;

import com.epam.shop.command.AbstractCommand;
import com.epam.shop.command.CommandEnum;
import com.epam.shop.command.impl.*;
import com.epam.shop.constant.ShopConstant;
import org.apache.log4j.Logger;

/**
 * A factory for creating Command objects.
 */
public final class CommandFactory {

    /** The Constant LOG. */
    private static final Logger LOGGER = Logger.getLogger(CommandFactory.class);

    /**
     * Instantiates a new command factory.
     */
    private CommandFactory() {
        super();
    }

    /**
     * Creates a new Command object.
     *
     * @param command
     *            the command
     * @return the i command
     */
    public static AbstractCommand createCommand(String command) {
        AbstractCommand currentCommand = new EmptyCommand();
        if (command == null) {
            return currentCommand;
        }

        try {
            String upperCaseCommand = command.toUpperCase();
            CommandEnum currentEnum = CommandEnum.valueOf(upperCaseCommand);
            currentCommand = currentEnum.getCurrentCommand();
        } catch (IllegalArgumentException e) {
            LOGGER.error("can't find '" + command + "' command.");
        }
        return currentCommand;
    }
}
