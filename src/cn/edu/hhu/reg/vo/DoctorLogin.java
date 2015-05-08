package cn.edu.hhu.reg.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="doctor_login")
public class DoctorLogin {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(length = 16)
	private Integer id;
	
	/**
	 * 医生id
	 */
	@Column(name="doctor_id",length=16)
	private Integer doctorId;
	
	/**
	 * 医生登录名
	 */
	@Column(name="login_name",length=50)
	private String loginName;
	
	/**
	 * 医生登录密码
	 */
	@Column(name="password",length=50)
	private String password;
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	public DoctorLogin() {
	}
	
}
