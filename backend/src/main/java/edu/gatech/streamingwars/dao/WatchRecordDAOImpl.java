package edu.gatech.streamingwars.dao;

import edu.gatech.streamingwars.entity.WatchRecord;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.List;

public class WatchRecordDAOImpl implements WatchRecordDAO{
    private EntityManager entityManager;

    @Autowired
    public WatchRecordDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<WatchRecord> findAll() {
        return null;
    }

    @Override
    public WatchRecord findById(String demographicGroupShortName, String showShortName, Integer showYear) {
        return null;
    }

    @Override
    public void save(WatchRecord subscriptionRecord) {

    }
}
