package cn.edu.hhu.reg.service;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import cn.edu.hhu.reg.common.error.ApiError;
import cn.edu.hhu.reg.dao.UserDao;
import cn.edu.hhu.reg.dao.UserLoginDao;
import cn.edu.hhu.reg.vo.User;
import cn.edu.hhu.reg.vo.UserLogin;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UserService {
	
	@Resource
	private UserDao userDao;
	@Resource
	private UserLoginDao userLoginDao;

	/**
	 * 登录
	 * @param userLogin
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> login(UserLogin userLogin) throws Exception{
		UserLogin userLoginByEmail = userLoginDao.getByEmail(userLogin.getEmail());
		if(userLoginByEmail==null){
			throw new Exception(ApiError.USER_NOT_REGISTER.message);
		}
		if(!userLoginByEmail.getPassword().equals(userLogin.getPassword())){
			throw new Exception(ApiError.PASSWORD_NOT_MATCH.message);
		}
		Map<String, Object> result = new HashMap<String, Object>();
	    result.put("uid", userLoginByEmail.getUserId());
	    result.put("email", userLoginByEmail.getEmail());
	    return result;
	}
	
	/**
	 * 注册
	 * @param userLogin
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> register(UserLogin userLogin) throws Exception{
		UserLogin userLoginByEmail = userLoginDao.getByEmail(userLogin.getEmail());
		if(userLoginByEmail!=null){
			throw new Exception(ApiError.USER_ALREADY_REGISTERED.message);
		}
		User user = new User();
		user.setEmail(userLogin.getEmail());
		userDao.save(user);
		userLogin.setUserId(user.getId());
		userLoginDao.save(userLogin);
		Map<String, Object> result = new HashMap<String, Object>();
	    result.put("uid", userLogin.getUserId());
	    result.put("email", userLogin.getEmail());
	    return result;
	}

	public User getUser(Integer uid) {
		return userDao.get(User.class, uid);
	}

	public User updateUser(User user) {
		User u = userDao.get(User.class, user.getId());
		u.setNickname(user.getNickname());
		u.setAge(user.getAge());
		u.setGender(user.getGender());
		userDao.update(u);
		return u;
	}

	public UserLogin resetPassword(UserLogin userLogin) throws Exception {
		UserLogin ul = userLoginDao.getByUid(userLogin.getUserId());
		if(ul==null){
			throw new Exception(ApiError.USER_NOT_REGISTER.message);
		}
		ul.setPassword(userLogin.getPassword());
		userLoginDao.update(ul);
		return ul;
	}

}
