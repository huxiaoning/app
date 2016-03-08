package org.hxn.app.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "user")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3538410583801960045L;

	@Id
	@GeneratedValue(generator = "userGenerator")
	@GenericGenerator(name = "userGenerator", strategy = "uuid.hex")
	@Column(name = "user_id", length = 32)
	private String id;

	@Column(name = "username", length = 20, unique = true, nullable = false)
	private String username;

	@Column(name = "password", length = 255, nullable = false)
	private String password;

	@Column(name = "nickname", length = 255, nullable = false)
	private String nickname;

	@Column(name = "age", length = 3, nullable = false)
	private Integer age;

	@Column(name = "locked")
	private boolean locked = false;// 默认没有锁定

	@ManyToMany
	@JoinTable(name = "user_role", joinColumns = {
			@JoinColumn(name = "user_id", referencedColumnName = "user_id") }, inverseJoinColumns = {
					@JoinColumn(name = "role_id") })
	private Set<Role> roles = new HashSet<Role>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public boolean getLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", nickname=" + nickname
				+ ", age=" + age + ", locked=" + locked + ", roles=" + roles + "]";
	}

}
