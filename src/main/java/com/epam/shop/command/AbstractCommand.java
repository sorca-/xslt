package com.epam.shop.command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public abstract class AbstractCommand {

    /** The Constant re entrant read write lock. */
    public static final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    /** The Constant readLock. */
    public static final ReentrantReadWriteLock.ReadLock readLock = rwl.readLock();

    /** The Constant writeLock. */
    public static final ReentrantReadWriteLock.WriteLock writeLock = rwl.writeLock();

    public abstract void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException;

}
