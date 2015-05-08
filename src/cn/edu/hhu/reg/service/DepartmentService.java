package cn.edu.hhu.reg.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.hhu.reg.dao.DepartmentDao;
import cn.edu.hhu.reg.vo.Department;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class DepartmentService {
	
	private DepartmentDao departmentDao;
	@Resource
	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}
	public List<Department> listAll() {
		return departmentDao.findAll(Department.class);
	}

	
}
