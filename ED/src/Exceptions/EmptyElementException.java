/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**
 *
 * @author jogui
 */
public class EmptyElementException extends Exception {

    /**
     * Creates a new instance of <code>NodeVazioException</code> without detail
     * message.
     */
    public EmptyElementException() {
    }

    /**
     * Constructs an instance of <code>NodeVazioException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public EmptyElementException(String msg) {
        super(msg);
    }
}
