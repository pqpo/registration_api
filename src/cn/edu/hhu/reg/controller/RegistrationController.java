package cn.edu.hhu.reg.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.edu.hhu.reg.common.restful.SimpleResponse;
import cn.edu.hhu.reg.service.RegistrationService;
import cn.edu.hhu.reg.vo.Registration;

@RestController
@RequestMapping("/registration")
public class RegistrationController {
	
	@Resource
	private RegistrationService registrationService;
	
	/**
	 * 用户-我的预约
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="/user/list/{userId}",method=RequestMethod.GET)
	public @ResponseBody SimpleResponse listByUser(@PathVariable(value="userId") Integer userId){
		SimpleResponse response = new SimpleResponse();
		try {
			response.setData(registrationService.getByUserId(userId));
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		}
		return response;
	}
	
	/**
	 * 用户-预约
	 * @param registration
	 * @return
	 */
	@RequestMapping(value="/user/register",method=RequestMethod.POST)
	public @ResponseBody SimpleResponse register(@RequestBody Registration registration){
		SimpleResponse response = new SimpleResponse();
		registration.setStatus(0);
		try {
			response.setData(registrationService.register(registration));
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		}
		return response;
	}
	
	/**
	 * 用户-取消预约
	 * @param registrationId
	 * @return
	 */
	@RequestMapping(value="/user/unregister/{registrationId}",method=RequestMethod.GET)
	public SimpleResponse cancelRegistration(@PathVariable(value="registrationId") Integer registrationId){
		SimpleResponse response = new SimpleResponse();
		try {
			registrationService.cancelRegistration(registrationId);
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		}
		return response;
	}
	
}
