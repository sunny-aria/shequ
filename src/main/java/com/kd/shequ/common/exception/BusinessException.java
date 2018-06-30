package com.kd.shequ.common.exception;

/**
 * 业务异常
 *
 * @author sunny
 * @create 2018/6/28 16:33
 **/
public class BusinessException extends Exception {

    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public BusinessException(String message) {
        super(message);
    }
}
