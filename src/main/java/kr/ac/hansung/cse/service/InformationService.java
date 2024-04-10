package kr.ac.hansung.cse.service;

import kr.ac.hansung.cse.dao.InformationDao;
import kr.ac.hansung.cse.model.Enroll;
import kr.ac.hansung.cse.model.Information;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InformationService {

    @Autowired
    private InformationDao informationDao;

    public List<Information> getAllInformations() {
        return informationDao.getInformations();
    }
    public List<Information> getCreditSummary() {
        return informationDao.getCreditSummary();
    }
}
