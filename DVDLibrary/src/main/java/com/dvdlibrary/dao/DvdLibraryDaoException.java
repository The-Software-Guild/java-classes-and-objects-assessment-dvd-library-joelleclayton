package com.dvdlibrary.dao;

/**
 *
 * @author joelleclayton
 */

public class DvdLibraryDaoException extends Exception{

    public DvdLibraryDaoException(String message) {
        super(message);
    }

    public DvdLibraryDaoException(String message, Throwable cause) {
        super(message, cause);
    }
}
