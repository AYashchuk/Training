package Lab2.exception;

/**
 * Overview:
 * @author Yashchuk A. F.
 * @version 1.0
 * @see java.lang.Exception
 *
 */
public class UnknownImportanceStateException extends Exception {
	public UnknownImportanceStateException(String message) {
		super(message);
	}
}
