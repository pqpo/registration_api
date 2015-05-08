package cn.edu.hhu.reg.dao;

import java.util.List;

import cn.edu.hhu.reg.common.dao.impl.BaseDaoImpl;
import cn.edu.hhu.reg.vo.Doctor;

public class DoctorDao extends BaseDaoImpl<Doctor> {

	
	
	
	public List<Doctor> getByDepartmentId(Integer departmentId) {
		String hql = "from Doctor where departmentId = ?";
		return find(hql, departmentId);
	}

}
