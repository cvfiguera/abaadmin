package cl.abaadmin.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserVO implements UserDetails {

	private static final long serialVersionUID = 2598780025719067312L;
	private int id;
	private String username;
	private String password;
	private Boolean enabled;
	
	public UserVO(int id, String username, String password, Boolean enabled) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		return authorities;
	}
	
	@Override
	public String getPassword() {
		
		return password;
	}
	
	@Override
	public String getUsername() {
		
		return username;
	}
	
	@Override
	public boolean isAccountNonExpired() {

		return true;
	}
	
	@Override
	public boolean isAccountNonLocked() {

		return true;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {

		return true;
	}
	
	@Override
	public boolean isEnabled() {

		return enabled;
	}
	
}
