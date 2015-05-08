package cn.edu.hhu.reg.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.edu.hhu.reg.common.restful.SimpleResponse;
import cn.edu.hhu.reg.service.DoctorService;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

	private DoctorService doctorService;
	@Resource
	public void setDoctorService(DoctorService doctorService) {
		this.doctorService = doctorService;
	}
	
	/**
	 * 所有医生列表
	 * @return
	 */
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public SimpleResponse list(){
		SimpleResponse response = new SimpleResponse();
		try {
			response.setData(doctorService.list());
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		}
		return response;
	}
	
	/**
	 * 科室下所有医生
	 * @param departmentId
	 * @return
	 */
	@RequestMapping(value="/list/department/{departmentId}",method=RequestMethod.GET)
	public SimpleResponse doctorsInDepartment(@PathVariable(value="departmentId") Integer departmentId){
		SimpleResponse response = new SimpleResponse();
		try {
			response.setData(doctorService.listByDepartment(departmentId));
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		}
		return response;
	}
}
