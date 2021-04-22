package edu.gatech.streamingwars.dao;

import edu.gatech.streamingwars.entity.SubscriptionRecord;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.List;

public class SubscriptionRecordDAOImpl implements SubscriptionRecordDAO{
    private EntityManager entityManager;

    @Autowired
    public SubscriptionRecordDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }




    @Override
    public List<SubscriptionRecord> findAll() {
        return null;
    }

    @Override
    public SubscriptionRecord findById(String demographicGroupShortName, String streamingServiceShortName, String yearMonth) {
        return null;
    }

    @Override
    public void save(SubscriptionRecord subscriptionRecord) {

    }
}
