package cn.edu.hhu.reg.dao;

import java.util.Date;
import java.util.List;

import cn.edu.hhu.reg.common.dao.impl.BaseDaoImpl;
import cn.edu.hhu.reg.vo.Registration;

public class RegistrationDao extends BaseDaoImpl<Registration> {

	public long findCountByDoctor(Integer doctorId, Date date) {
		String hql = "select count(*) from Registration where doctorId=? and date=? and status=0";
		List<?> l = find(hql, doctorId,date);
		if(l != null && l.size() == 1 ){
			return (long)l.get(0);
		}
		return 0;
	}

	public List<Registration> getByUserId(Integer userId) {
		String hql = "from Registration where userId=? order by date";
		return find(hql, userId);
	}

}
