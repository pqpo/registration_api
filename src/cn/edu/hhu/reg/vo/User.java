package cn.edu.hhu.reg.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 用户信息
 * @author qlm
 *
 */

@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(length = 16)
	private Integer id;
	
	/**
	 * 邮箱
	 */
	@Column(name="email",length=50)
	private String email;
	
	/**
	 * 姓名
	 */
	@Column(name="nickname",length=50)
	private String nickname;
	
	/**
	 * 性别 1：男  0：女
	 */
	@Column(name="gender",length=11)
	private Integer gender;
	
	/**
	 * 年龄
	 */
	@Column(name="age",length=11)
	private Integer age;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public User(){}
}
