package cn.edu.hhu.reg.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import cn.edu.hhu.reg.common.error.ApiError;
import cn.edu.hhu.reg.dao.DepartmentDao;
import cn.edu.hhu.reg.dao.DoctorDao;
import cn.edu.hhu.reg.dao.RegistrationDao;
import cn.edu.hhu.reg.vo.Department;
import cn.edu.hhu.reg.vo.Doctor;
import cn.edu.hhu.reg.vo.Registration;

@RestController
@Transactional(propagation = Propagation.REQUIRED)
public class RegistrationService {

	@Resource
	private RegistrationDao registrationDao;
	@Resource
	private DoctorDao doctorDao;
	@Resource
	private DepartmentDao departmentDao;
	
	
	public Registration register(Registration registration) throws Exception {
		Date date = registration.getDate();
		Calendar cReg = Calendar.getInstance();
		cReg.setTime(date);
		
		Calendar cToday = Calendar.getInstance();
		cToday.set(Calendar.HOUR_OF_DAY, 24);
		cToday.set(Calendar.MINUTE, 60);
		cToday.set(Calendar.SECOND, 60);
		
		if(!cReg.after(cToday)){
			throw new Exception(ApiError.REGISTRATION_DATE_INVALID_AFTER.message);
		}
		cToday.add(Calendar.DAY_OF_MONTH, 7);
		if(!cReg.before(cToday)){
			throw new Exception(ApiError.REGISTRATION_DATE_INVALID_BEFORE.message);
		}
		
		
		Doctor doctor = doctorDao.get(Doctor.class, registration.getDoctorId());
		int status = doctor.getStatus();
		if(status!=0){
			throw new Exception(ApiError.REGISTRATION_DOCTOR_INVALID.message);
		}
		//医生最大预约人数
		int maxReg = doctor.getRegMax();
		//当前该医生当天预约数
		long currentReg = registrationDao.findCountByDoctor(registration.getDoctorId(),registration.getDate());
		if(currentReg>=maxReg){
			throw new Exception(ApiError.REGISTRATION_DATE_INVALID_MAX.message);
		}
		registration.setCreateTime(new Date());
		registrationDao.save(registration);
		return registration;
	}


	public void cancelRegistration(Integer registrationId) throws Exception {
		Registration registration = registrationDao.get(Registration.class, registrationId);
		if(registration.getStatus()!=0){
			throw new Exception(ApiError.REGISTRATION_CANNOT_CANCEL.message);
		}
		registration.setStatus(2);
		registrationDao.update(registration);
	}


	public List<Registration> getByUserId(Integer userId) {		
		List<Registration> list = registrationDao.getByUserId(userId);
		for(Registration re:list){
			int doctorId = re.getDoctorId();
			Doctor doc = doctorDao.get(Doctor.class, doctorId);
			int depId = doc.getDepartmentId();
			Department dep = departmentDao.get(Department.class, depId);
			re.setDoctorName(doc.getNickname());
			re.setDepartmentName(dep.getName());
		}
		return list;
	}
}
