package cn.edu.hhu.reg.controller;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.edu.hhu.reg.common.restful.SimpleResponse;
import cn.edu.hhu.reg.service.UserService;
import cn.edu.hhu.reg.vo.User;
import cn.edu.hhu.reg.vo.UserLogin;

@RestController
@RequestMapping("/user")
public class UserController {

	Log log = LogFactory.getLog(getClass());
	@Resource
	private UserService userService;
	
	/**
	 * 登录
	 * @param userLogin
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody SimpleResponse login(@RequestBody UserLogin userLogin){
		SimpleResponse response = new SimpleResponse();
		try {
			response.setData(userService.login(userLogin));
		} catch (Exception e) {
			log.info(e.getMessage());
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		}
		return response;
	}
	
	/**
	 * 注册
	 * @param userLogin
	 * @return
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public @ResponseBody SimpleResponse register(@RequestBody UserLogin userLogin){
		SimpleResponse response = new SimpleResponse();
		try {
			response.setData(userService.register(userLogin));
		} catch (Exception e) {
			log.info(e.getMessage());
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		}
		return response;
	}
	
	/**
	 * 获取用户信息
	 * @param uid
	 * @return
	 */
	@RequestMapping(value="/profile/{uid}",method=RequestMethod.GET)
	public @ResponseBody SimpleResponse getUser(@PathVariable(value="uid") Integer uid){
		SimpleResponse response = new SimpleResponse();
		try {
			response.setData(userService.getUser(uid));
		} catch (Exception e) {
			log.info(e.getMessage());
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		}
		return response;
	}
	
	/**
	 * 修改用户信息
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/profile/update",method=RequestMethod.POST)
	public SimpleResponse modifyUser(@RequestBody User user){
		SimpleResponse response = new SimpleResponse();
		try {
			response.setData(userService.updateUser(user));
		} catch (Exception e) {
			log.info(e.getMessage());
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		}
		return response;
	}
	
	/**
	 * 修改密码
	 * @param userLogin
	 * @return
	 */
	@RequestMapping(value="/password/reset",method=RequestMethod.POST)
	public @ResponseBody SimpleResponse resetPassword(@RequestBody UserLogin userLogin){
		SimpleResponse response = new SimpleResponse();
		try {
			response.setData(userService.resetPassword(userLogin));
		} catch (Exception e) {
			log.info(e.getMessage());
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		}
		return response;
	}
}
