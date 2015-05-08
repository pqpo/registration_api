package cn.edu.hhu.reg.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import cn.edu.hhu.reg.common.error.ApiError;
import cn.edu.hhu.reg.dao.DoctorDao;
import cn.edu.hhu.reg.dao.RegistrationDao;
import cn.edu.hhu.reg.vo.Doctor;
import cn.edu.hhu.reg.vo.Registration;

@RestController
@Transactional(propagation = Propagation.REQUIRED)
public class RegistrationService {

	@Resource
	private RegistrationDao registrationDao;
	@Resource
	private DoctorDao doctorDao;
	
	
	public Registration register(Registration registration) throws Exception {
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
			throw new Exception(ApiError.REGISTRATION_DATE_INVALID.message);
		}
		
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
		return registrationDao.getByUserId(userId);
	}
}
