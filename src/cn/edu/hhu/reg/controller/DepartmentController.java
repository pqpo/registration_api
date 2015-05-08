package cn.edu.hhu.reg.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.edu.hhu.reg.common.restful.SimpleResponse;
import cn.edu.hhu.reg.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	
	private DepartmentService departmentService;
	@Resource
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	/**
	 * 科室列表
	 * @return
	 */
	@RequestMapping(value = "/list",method=RequestMethod.GET)
	public SimpleResponse list(){
		SimpleResponse response = new SimpleResponse();
		try {
			response.setData(departmentService.listAll());
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		}
		return response;
	}
	
}
