/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**
 *
 * @author Joao Sousa
 */
public class AreaCodeNotFoundException extends Exception {

    /**
     * Constructs an instance of <code>AreaCodeNotFoundException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public AreaCodeNotFoundException(String msg) {
        super(msg);
        System.out.println(msg);
    }

    public AreaCodeNotFoundException() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
