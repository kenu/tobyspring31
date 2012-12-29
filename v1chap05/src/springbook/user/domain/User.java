package springbook.user.domain;

public class User {
	private static final int BASIC = 1;
	private static final int SILVER = 2;
	private static final int GOLD = 3;
	
	int level;
	
	public void setLevel(int level) {
		this.level = level;
	}
	
    String id;
    String name;
    String password;
    
	public User(String id, String name, String password) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
	}
	
	public User() {
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
    
}
