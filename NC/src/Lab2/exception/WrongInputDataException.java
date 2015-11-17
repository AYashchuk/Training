package Lab2.exception;


/**
 * Overview:
 * This class - exception
 * @author Yashchuk A. F.
 * @version 1.0
 * @see java.lang.Exception
 *
 */
public class WrongInputDataException extends Exception {
	public WrongInputDataException(String message) {
		super(message);
	}
}
