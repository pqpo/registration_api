package cn.edu.hhu.reg.dao;

import java.io.Serializable;
import java.util.List;

import cn.edu.hhu.reg.common.dao.impl.BaseDaoImpl;
import cn.edu.hhu.reg.common.secutiry.Mid;
import cn.edu.hhu.reg.vo.UserLogin;

public class UserLoginDao extends BaseDaoImpl<UserLogin> {
	
	public UserLogin getByEmail(String email){
		UserLogin userLogin = null;
		String hql = "from UserLogin where email = ?";
		List<UserLogin> users = find(hql, email);
		if(users!=null&&!users.isEmpty()){
			userLogin = users.get(0);
		}
		return userLogin;
	}

	public UserLogin getByUid(Integer userId) {
		UserLogin ul = null;
		String hql = "from UserLogin where userId = ?";
		List<UserLogin> users = find(hql, userId);
		if(users!=null&&!users.isEmpty()){
			ul = users.get(0);
		}
		return ul;
	}
}
