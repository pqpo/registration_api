package cn.edu.hhu.reg.vo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="registration")
public class Registration {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(length = 16)
	private Integer id;
	
	/**
	 * 用户id
	 */
	@Column(name="user_id",length=16)
	private Integer userId;
	
	/**
	 * 医生id
	 */
	@Column(name="doctor_id",length=16)
	private Integer doctorId;
	
	/**
	 * 预约日期
	 */
	@Column(name="date")
	@Temporal(TemporalType.DATE)
	private Date date;
	
	/**
	 * 患者姓名
	 */
	@Column(name="name",length=50)
	private String name;
	
	/**
	 * 患者年龄
	 */
	@Column(name="age",length=11)
	private Integer age;
	
	/**
	 * 患者性别 1：男  0：女
	 */
	@Column(name="gender",length=11)
	private Integer gender;
	
	/**
	 * 病情描述
	 */
	@Column(name="description",length=50)
	private String description;
	
	/**
	 * 状态 0:有效  1:已完成 2:用户已取消 3：已过期
	 */
	@Column(name="status",length=11)
	private Integer status;
	
	/**
	 * 创建时间
	 */
	@Column(name="create_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createTime;
	
	


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


	public Integer getDoctorId() {
		return doctorId;
	}


	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
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


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}


	public Date getCreateTime() {
		return createTime;
	}


	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}



	public Registration() {
	}
	
	
}
