package kr.ac.hansung.cse.service;

import kr.ac.hansung.cse.dao.EnrollDao;
import kr.ac.hansung.cse.model.Enroll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollService {

    @Autowired
    private EnrollDao enrollDao;

    public List<Enroll> getAllEnrolls() {
        return enrollDao.getEnrolls();
    }



}
