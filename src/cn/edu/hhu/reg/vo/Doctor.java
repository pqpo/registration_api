package cn.edu.hhu.reg.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 医生信息
 * @author qlm
 *
 */
@Entity
@Table(name="doctor")
public class Doctor {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(length = 16)
	private Integer id;
	
	/**
	 * 医生姓名
	 */
	@Column(name="nickname",length=50)
	private String nickname;
	
	/**
	 * 年龄
	 */
	@Column(name="age",length=11)
	private Integer age;
	
	/**
	 * 性别 1：男  0：女
	 */
	@Column(name="gender",length=11)
	private Integer gender;
	
	/**
	 * 科室id
	 */
	@Column(name="department_id",length=16)
	private Integer departmentId;
	
	@Transient
	private String departmentName;
	
	/**
	 * 介绍
	 */
	@Column(name="introduction",length=50)
	private String introduction;
	
	/**
	 * 日最大允许挂号人数
	 */
	@Column(name="reg_max",length=11)
	private Integer regMax;
	
	
	/**
	 * 状态  0：可以挂号 1：不可挂号
	 */
	@Column(name="status",length=11)
	private Integer status;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}
	
	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public Integer getRegMax() {
		return regMax;
	}

	public void setRegMax(Integer regMax) {
		this.regMax = regMax;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Doctor() {
	}
	
}
