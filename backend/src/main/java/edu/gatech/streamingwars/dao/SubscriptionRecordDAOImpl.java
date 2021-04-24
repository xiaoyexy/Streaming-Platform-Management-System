package edu.gatech.streamingwars.dao;

import edu.gatech.streamingwars.entity.Show;
import edu.gatech.streamingwars.entity.SubscriptionRecord;
import edu.gatech.streamingwars.entity.SubscriptionRecordId;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class SubscriptionRecordDAOImpl implements SubscriptionRecordDAO{
    private EntityManager entityManager;

    @Autowired
    public SubscriptionRecordDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }




    @Override
    public List<SubscriptionRecord> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        // create a query
        Query<SubscriptionRecord> qry =
                currentSession.createQuery("FROM SubscriptionRecord s " +
                        "ORDER BY s.demographicGroupShortName, s.streamingServiceShortName, s.yearMonth", SubscriptionRecord.class);

        // execute query and get result list
        List<SubscriptionRecord> records = qry.getResultList();

        // return the results
        return records;
    }

    @Override
    public SubscriptionRecord findById(String demographicGroupShortName, String streamingServiceShortName, String yearMonth) {
        Session currentSession = entityManager.unwrap(Session.class);
        SubscriptionRecordId subscriptionRecordId = new SubscriptionRecordId(demographicGroupShortName, streamingServiceShortName, yearMonth);
        SubscriptionRecord subscriptionRecord = currentSession.get(SubscriptionRecord.class, subscriptionRecordId);
        return subscriptionRecord;
    }

    @Override
    public void save(SubscriptionRecord subscriptionRecord) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.save(subscriptionRecord);
        return;
    }

    @Override
    public List<SubscriptionRecord> findByDemographicGroup(String demographicGroupSN) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<SubscriptionRecord> qry =
                currentSession.createQuery("FROM SubscriptionRecord s " +
                        "WHERE s.demographicGroupShortName =:demographicGroupSN " +
                        "ORDER BY s.demographicGroupShortName, s.streamingServiceShortName, s.yearMonth", SubscriptionRecord.class);

        qry.setParameter("demographicGroupSN", demographicGroupSN);
        List<SubscriptionRecord> records = qry.getResultList();
        return records;
    }

    @Override
    public List<SubscriptionRecord> findByDemographicGroupYearMonth(String demographicGroupSN, String yearMonth) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<SubscriptionRecord> qry =
                currentSession.createQuery("FROM SubscriptionRecord s " +
                        "WHERE s.demographicGroupShortName =:demographicGroupSN and s.yearMonth =:yearMonth " +
                        "ORDER BY s.demographicGroupShortName, s.streamingServiceShortName, s.yearMonth", SubscriptionRecord.class);

        qry.setParameter("demographicGroupSN", demographicGroupSN);
        qry.setParameter("yearMonth", yearMonth);
        List<SubscriptionRecord> records = qry.getResultList();
        return records;
    }

    @Override
    public List<SubscriptionRecord> findByStreamingServiceYearMonth(String streamingServiceSN, String yearMonth) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<SubscriptionRecord> qry =
                currentSession.createQuery("FROM SubscriptionRecord s " +
                        "WHERE s.streamingServiceShortName =:streamingServiceSN and s.yearMonth =:yearMonth " +
                        "ORDER BY s.demographicGroupShortName, s.streamingServiceShortName, s.yearMonth", SubscriptionRecord.class);

        qry.setParameter("streamingServiceSN", streamingServiceSN);
        qry.setParameter("yearMonth", yearMonth);
        List<SubscriptionRecord> records = qry.getResultList();
        return records;
    }

    @Override
    public List<SubscriptionRecord> findByStreamingService(String streamingServiceSN) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<SubscriptionRecord> qry =
                currentSession.createQuery("FROM SubscriptionRecord s " +
                        "WHERE s.streamingServiceShortName =:streamingServiceSN " +
                        "ORDER BY s.demographicGroupShortName, s.streamingServiceShortName, s.yearMonth", SubscriptionRecord.class);

        qry.setParameter("streamingServiceSN", streamingServiceSN);
        List<SubscriptionRecord> records = qry.getResultList();
        return records;
    }
}
