/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**
 *
 * @author fabio
 */
public class NotComparableException extends Exception {

    /**
     * Creates a new instance of <code>NotComparableException</code> without
     * detail message.
     */
    public NotComparableException() {
    }

    /**
     * Constructs an instance of <code>NotComparableException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public NotComparableException(String msg) {
        super(msg);
    }
}
