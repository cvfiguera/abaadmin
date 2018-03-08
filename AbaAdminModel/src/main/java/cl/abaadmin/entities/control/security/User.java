package cl.abaadmin.entities.control.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "usuarios", schema = "security")
public class User implements UserDetails {

	private static final long serialVersionUID = 964534461958503730L;
	@Id
	@Column(name = "usuario_id", nullable = false, updatable = false)
	private int userId;
	@Column(name = "usuario", nullable = false, unique = true)
	private String username;
	@Column(name = "clave", nullable = false)
	private String password;
	@Column(name = "email", nullable = false)
	private String email;	
	@Column(name = "bloqueado", nullable = false)
	private Boolean enabled;
	@Column(name = "intentos", nullable = false)
	private Integer n;
	@Column(name = "max_intentos")
	private Integer nMax;
	@Column(name = "rut", nullable = false)
	private String rut;
	@Column(name = "telefono")
	private String phone;
	@Column(name = "organismo")
	private String organization;
	@Column(name = "nombre", nullable = false)
	private String firsName;
	@Column(name = "apellido", nullable = false)
	private String lastName;
	@ManyToOne
	@JoinColumn(name= "roles_id", referencedColumnName="rol_id")
	private Role role;
	
	public User() {
		super();
	}

	
	public User(int userId, String username, String password, String email, Boolean enabled, Integer n, Integer nMax,
			String rut, String phone, String organization, String firsName, String lastName, Role role) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.email = email;
		this.enabled = enabled;
		this.n = n;
		this.nMax = nMax;
		this.rut = rut;
		this.phone = phone;
		this.organization = organization;
		this.firsName = firsName;
		this.lastName = lastName;
		this.role = role;
	}

	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Boolean getEnabled() {
		return enabled;
	}


	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}


	public Integer getN() {
		return n;
	}


	public void setN(Integer n) {
		this.n = n;
	}


	public Integer getnMax() {
		return nMax;
	}


	public void setnMax(Integer nMax) {
		this.nMax = nMax;
	}


	public String getRut() {
		return rut;
	}


	public void setRut(String rut) {
		this.rut = rut;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getOrganization() {
		return organization;
	}


	public void setOrganization(String organization) {
		this.organization = organization;
	}


	public String getFirsName() {
		return firsName;
	}


	public void setFirsName(String firsName) {
		this.firsName = firsName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
            String name = role.getName().toUpperCase();
            if (!name.startsWith("ROLE_"))
                name = "ROLE_" + name;
            authorities.add(new SimpleGrantedAuthority(name));
        return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return !this.enabled;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}


	@Override
	public boolean isEnabled() {
		return !this.enabled;
	}	
}
