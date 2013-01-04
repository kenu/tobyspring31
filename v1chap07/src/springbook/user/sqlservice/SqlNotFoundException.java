package springbook.user.sqlservice;

@SuppressWarnings("serial")
public class SqlNotFoundException extends RuntimeException {

	public SqlNotFoundException(String message) {
		super(message);
	}

}
