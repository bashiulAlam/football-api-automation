package com.assignment.endtoendtest.helper

import org.slf4j.Logger
import org.slf4j.LoggerFactory

class ExceptionHelper {

    private static Logger logger = LoggerFactory.getLogger(ExceptionHelper.class)

    static def handleException(Exception ex) {
        logger.error("Exception occurred : " + ex.getMessage() + "\nStack trace for the exception: " + ex.getStackTrace())
    }
}
