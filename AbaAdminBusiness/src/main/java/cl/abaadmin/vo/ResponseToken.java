package cl.abaadmin.vo;

public class ResponseToken implements java.io.Serializable{

	private static final long serialVersionUID = 3709784339872355727L;
	private Integer userId;
	private String username;
	private String token;
	
	public ResponseToken() {
		super();
	}
	
	public ResponseToken(Integer userId, String username, String token) {
		super();
		this.userId = userId;
		this.username = username;
		this.token = token;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
