package springbook.user.sqlservice;

public class SqlUpdateFailureException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public SqlUpdateFailureException(String message) {
		super(message);
	}
	
	public SqlUpdateFailureException(String message, Throwable cause) {
		super(message, cause);
	}

	public SqlUpdateFailureException(Throwable cause) {
		super(cause);
	}
}
