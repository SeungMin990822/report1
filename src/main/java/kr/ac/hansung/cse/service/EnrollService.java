package kr.ac.hansung.cse.service;

import kr.ac.hansung.cse.dao.EnrollDao;
import kr.ac.hansung.cse.model.Enroll;
import kr.ac.hansung.cse.model.Offer;
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

    public void insert(Enroll enroll) {
        enrollDao.insert(enroll);
    }



}
