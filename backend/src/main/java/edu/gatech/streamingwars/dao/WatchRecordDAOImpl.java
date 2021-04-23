package edu.gatech.streamingwars.dao;

import edu.gatech.streamingwars.entity.Show;
import edu.gatech.streamingwars.entity.WatchRecord;
import edu.gatech.streamingwars.entity.WatchRecordId;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class WatchRecordDAOImpl implements WatchRecordDAO{
    private EntityManager entityManager;

    @Autowired
    public WatchRecordDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<WatchRecord> findAll() {

        Session currentSession = entityManager.unwrap(Session.class);
        // create a query
        Query<WatchRecord> qry =
                currentSession.createQuery("FROM WatchRecord s " +
                        "ORDER BY s.demographicGroupShortName, s.showShortName, s.showYear", WatchRecord.class);

        // execute query and get result list
        List<WatchRecord> records = qry.getResultList();

        // return the results
        return records;
    }

    @Override
    public WatchRecord findById(String demographicGroupShortName, String showShortName, Integer showYear) {
        Session currentSession = entityManager.unwrap(Session.class);
        WatchRecordId watchRecordId = new WatchRecordId(demographicGroupShortName, showShortName, showYear);
        WatchRecord watchRecord = currentSession.get(WatchRecord.class, watchRecordId);
        return watchRecord;
    }

    @Override
    public void save(WatchRecord watchRecord) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.save(watchRecord);
        return;
    }

    @Override
    public List<WatchRecord> findByDemographicGroup(String demographicGroupSN) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<WatchRecord> qry =
                currentSession.createQuery("FROM WatchRecord s " +
                        "WHERE s.demographicGroupShortName =:demographicGroupSN " +
                        "ORDER BY s.demographicGroupShortName, s.showShortName, s.showYear", WatchRecord.class);

        qry.setParameter("demographicGroupSN", demographicGroupSN);
        List<WatchRecord> records = qry.getResultList();
        return records;
    }

    @Override
    public List<WatchRecord> findByDemographicGroupYearMonth(String demographicGroupSN, String yearMonth) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<WatchRecord> qry =
                currentSession.createQuery("FROM WatchRecord s " +
                        "WHERE s.demographicGroupShortName =:demographicGroupSN and s.yearMonth =:yearMonth " +
                        "ORDER BY s.demographicGroupShortName, s.showShortName, s.showYear", WatchRecord.class);

        qry.setParameter("demographicGroupSN", demographicGroupSN);
        qry.setParameter("yearMonth", yearMonth);
        List<WatchRecord> records = qry.getResultList();
        return records;
    }

    @Override
    public List<WatchRecord> findByStreamingServiceYearMonth(String streamingServiceSN, String yearMonth) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<WatchRecord> qry =
                currentSession.createQuery("FROM WatchRecord s " +
                        "WHERE s.streamingServiceShortName =:streamingServiceSN and s.yearMonth =:yearMonth " +
                        "ORDER BY s.demographicGroupShortName, s.showShortName, s.showYear", WatchRecord.class);

        qry.setParameter("streamingServiceSN", streamingServiceSN);
        qry.setParameter("yearMonth", yearMonth);
        List<WatchRecord> records = qry.getResultList();
        return records;
    }

    @Override
    public List<WatchRecord> findByStreamingService(String streamingServiceSN) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<WatchRecord> qry =
                currentSession.createQuery("FROM WatchRecord s " +
                        "WHERE s.streamingServiceShortName =:streamingServiceSN " +
                        "ORDER BY s.demographicGroupShortName, s.showShortName, s.showYear", WatchRecord.class);

        qry.setParameter("streamingServiceSN", streamingServiceSN);
        List<WatchRecord> records = qry.getResultList();
        return records;
    }

    @Override
    public List<WatchRecord> findByShowYearYearMonth(String showShortName, int showYear, String yearMonth) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<WatchRecord> qry =
                currentSession.createQuery("FROM WatchRecord s " +
                        "WHERE s.showShortName =:showShortName and s.showYear =:showYear and s.yearMonth =:yearMonth" +
                        "ORDER BY s.demographicGroupShortName, s.showShortName, s.showYear", WatchRecord.class);

        qry.setParameter("showShortName", showShortName);
        qry.setParameter("showYear", showYear);
        qry.setParameter("yearMonth", yearMonth);
        List<WatchRecord> records = qry.getResultList();
        return records;
    }

    @Override
    public List<WatchRecord> findByStreamingServiceShowYearYearMonth(String streamingServiceShortName, String showShortName, int showYear, String yearMonth) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<WatchRecord> qry =
                currentSession.createQuery("FROM WatchRecord s " +
                        "WHERE s.streamingServiceShortName =:streamingServiceShortName and s.showShortName =:showShortName and s.showYear =:showYear and s.yearMonth =:yearMonth" +
                        "ORDER BY s.demographicGroupShortName, s.showShortName, s.showYear", WatchRecord.class);

        qry.setParameter("streamingServiceShortName", streamingServiceShortName);
        qry.setParameter("showShortName", showShortName);
        qry.setParameter("showYear", showYear);
        qry.setParameter("yearMonth", yearMonth);
        List<WatchRecord> records = qry.getResultList();
        return records;
    }
}
