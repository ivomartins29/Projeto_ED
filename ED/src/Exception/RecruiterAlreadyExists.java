/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exception;

/**
 *
 * @author 8150121 e 8150133
 */
public class RecruiterAlreadyExists extends Exception {

    /**
     * Creates a new instance of <code>UserAlreadyExists</code> without detail
     * message.
     */
    public RecruiterAlreadyExists() {
    }

    /**
     * Constructs an instance of <code>UserAlreadyExists</code> with the
     * specified detail message.
     *
     * @param message the detail message.
     */
    public RecruiterAlreadyExists(String message) {
        super(message);
    }
}
