package cn.edu.hhu.reg.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import cn.edu.hhu.reg.dao.DepartmentDao;
import cn.edu.hhu.reg.dao.DoctorDao;
import cn.edu.hhu.reg.vo.Department;
import cn.edu.hhu.reg.vo.Doctor;

@RestController
@Transactional(propagation = Propagation.REQUIRED)
public class DoctorService {
	@Resource
	private DoctorDao doctorDao;
	@Resource
	private DepartmentDao departmentDao;
	
	public List<Doctor> listByDepartment(Integer departmentId) {
		List<Doctor> list = doctorDao.getByDepartmentId(departmentId);
		Department department = departmentDao.get(Department.class, departmentId);
		for(Doctor doc:list){
			doc.setDepartmentName(department.getName());
		}
		return list;
	}
	
	public List<Doctor> list() {
		List<Doctor> list = doctorDao.findAll(Doctor.class);
		for(Doctor doc:list){
			Department department = departmentDao.get(Department.class, doc.getDepartmentId());
			doc.setDepartmentName(department.getName());
		}
		return doctorDao.findAll(Doctor.class);
	}
}
