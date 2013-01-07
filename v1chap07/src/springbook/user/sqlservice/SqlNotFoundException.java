package springbook.user.sqlservice;


@SuppressWarnings("serial")
public class SqlNotFoundException extends RuntimeException {

	public SqlNotFoundException(String message) {
		super(message);
	}

	public SqlNotFoundException(String message, Throwable e) {
		super(message, e);
	}

}
