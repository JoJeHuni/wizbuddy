package com.intbyte.wizbuddy.user.service;

import com.intbyte.wizbuddy.exception.user.UserNotFoundException;
import com.intbyte.wizbuddy.mapper.EmployerMapper;
import com.intbyte.wizbuddy.user.domain.DeleteEmployerInfo;
import com.intbyte.wizbuddy.user.domain.EditEmployerInfo;
import com.intbyte.wizbuddy.user.domain.entity.Employer;
import com.intbyte.wizbuddy.user.dto.EmployerDTO;
import com.intbyte.wizbuddy.user.repository.EmployerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class EmployerService {

    private final EmployerRepository employerRepository;
    private final EmployerMapper employerMapper;

    // user에서 회원가입하면 사장 등록까지 한 번에 처리한다.
    // 수정, 삭제는 employer 에서

    @Transactional
    public void modifyEmployer(EditEmployerInfo modifyEmployerInfo) {
        String employerId = modifyEmployerInfo.getEmployerCode();

        Employer employer = employerMapper.getEmployer(employerId);

        if (employer == null) throw new UserNotFoundException();

        employer.modify(modifyEmployerInfo);
        employerRepository.save(employer);
    }

    @Transactional
    public void deleteEmployer(DeleteEmployerInfo deleteEmployerInfo) {
        String employerId = deleteEmployerInfo.getEmployerCode();

        Employer employer = employerMapper.getEmployer(employerId);

        if (employer == null) throw new UserNotFoundException();

        employer.removeRequest(deleteEmployerInfo);
        employerRepository.save(employer);
    }
}
