package edu.gatech.streamingwars.dao;

import edu.gatech.streamingwars.entity.ShowLicenseRecord;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.List;

public class ShowLicenseRecordDAOImpl implements ShowLicenseRecordDAO{

    private EntityManager entityManager;

    @Autowired
    public ShowLicenseRecordDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<ShowLicenseRecord> findAll() {
        return null;
    }

    @Override
    public ShowLicenseRecord findById(String streamingServiceShortName, String showShortName, String yearMonth) {
        return null;
    }

    @Override
    public void save(ShowLicenseRecord showLicenseRecord) {

    }
}
