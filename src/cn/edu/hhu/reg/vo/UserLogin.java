package cn.edu.hhu.reg.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户登录信息
 * @author qlm
 *
 */
@Entity
@Table(name="user_login_email")
public class UserLogin {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(length = 16)
	private Integer id;
	
	/*
	 * 用户id
	 */
	@Column(name="user_id",length =16)
	private Integer userId;
	
	/**
	 * 登录邮箱
	 */
	@Column(name="email",length=50)
	private String email;
	
	/**
	 * 登录密码
	 */
	@Column(name="password",length=50)
	private String password;

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserLogin() {
	}
	
}
