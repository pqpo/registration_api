package cn.edu.hhu.reg.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import cn.edu.hhu.reg.dao.DoctorDao;
import cn.edu.hhu.reg.vo.Doctor;

@RestController
@Transactional(propagation = Propagation.REQUIRED)
public class DoctorService {
	
	private DoctorDao doctorDao;
	@Resource
	public void setDoctorDao(DoctorDao doctorDao) {
		this.doctorDao = doctorDao;
	}
	public List<Doctor> listByDepartment(Integer departmentId) {
		return doctorDao.getByDepartmentId(departmentId);
	}
	public List<Doctor> list() {
		return doctorDao.findAll(Doctor.class);
	}
}
