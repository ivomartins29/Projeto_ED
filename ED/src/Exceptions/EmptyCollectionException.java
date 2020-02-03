package Exceptions;

public class EmptyCollectionException extends Exception {
	public EmptyCollectionException() {
		System.out.println("Empty Collection/STACK!");
	}

    public EmptyCollectionException(String heap_Vazia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
