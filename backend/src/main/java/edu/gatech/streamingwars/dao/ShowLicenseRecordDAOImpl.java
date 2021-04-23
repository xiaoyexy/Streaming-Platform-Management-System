package edu.gatech.streamingwars.dao;

import edu.gatech.streamingwars.entity.Show;
import edu.gatech.streamingwars.entity.ShowLicenseRecord;
import edu.gatech.streamingwars.entity.ShowLicenseRecordId;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ShowLicenseRecordDAOImpl implements ShowLicenseRecordDAO{

    private EntityManager entityManager;

    @Autowired
    public ShowLicenseRecordDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<ShowLicenseRecord> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        // create a query
        Query<ShowLicenseRecord> qry =
                currentSession.createQuery("FROM ShowLicenseRecord s " +
                        "ORDER BY s.streamingServiceShortName, s.showShortName, s.showYear", ShowLicenseRecord.class);

        // execute query and get result list
        List<ShowLicenseRecord> showLicenseRecords = qry.getResultList();

        // return the results
        return showLicenseRecords;
    }

    @Override
    public void save(ShowLicenseRecord showLicenseRecord) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.save(showLicenseRecord);
        return;
    }

    @Override
    public ShowLicenseRecord findById(String streamingServiceShortName, String showShortName, Integer showYear, String yearMonth) {
        Session currentSession = entityManager.unwrap(Session.class);
        ShowLicenseRecordId showLicenseRecordId = new ShowLicenseRecordId(streamingServiceShortName, showShortName, showYear, yearMonth);
        ShowLicenseRecord showLicenseRecord = currentSession.get(ShowLicenseRecord.class, showLicenseRecordId);
        return showLicenseRecord;
    }

    @Override
    public List<ShowLicenseRecord> findByStudio(String studioSN) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<ShowLicenseRecord> qry =
                currentSession.createQuery("FROM ShowLicenseRecord s " +
                        "WHERE s.studioShortName =:studioSN " +
                        "ORDER BY s.streamingServiceShortName, s.showShortName, s.showYear", ShowLicenseRecord.class);

        qry.setParameter("studioSN", studioSN);
        List<ShowLicenseRecord> showLicenseRecords = qry.getResultList();
        return showLicenseRecords;
    }

    @Override
    public List<ShowLicenseRecord> findByStreamingService(String streamingServiceSN) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<ShowLicenseRecord> qry =
                currentSession.createQuery("FROM ShowLicenseRecord s " +
                        "WHERE s.streamingServiceShortName =:streamingServiceSN " +
                        "ORDER BY s.streamingServiceShortName, s.showShortName, s.showYear", ShowLicenseRecord.class);

        qry.setParameter("streamingServiceSN", streamingServiceSN);
        List<ShowLicenseRecord> showLicenseRecords = qry.getResultList();
        return showLicenseRecords;
    }

    @Override
    public List<ShowLicenseRecord> findByStudioYearMonth(String studioSN, String yearMonth) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<ShowLicenseRecord> qry =
                currentSession.createQuery("FROM ShowLicenseRecord s " +
                        "WHERE s.studioShortName =:studioSN and s.yearMonth = :yearMonth " +
                        "ORDER BY s.streamingServiceShortName, s.showShortName, s.showYear", ShowLicenseRecord.class);

        qry.setParameter("studioSN", studioSN);
        qry.setParameter("yearMonth", yearMonth);
        List<ShowLicenseRecord> showLicenseRecords = qry.getResultList();
        return showLicenseRecords;
    }

    @Override
    public List<ShowLicenseRecord> findByStreamingServiceYearMonth(String streamingServiceSN, String yearMonth) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<ShowLicenseRecord> qry =
                currentSession.createQuery("FROM ShowLicenseRecord s " +
                        "WHERE s.streamingServiceShortName =:streamingServiceSN and s.yearMonth =:yearMonth " +
                        "ORDER BY s.streamingServiceShortName, s.showShortName, s.showYear", ShowLicenseRecord.class);

        qry.setParameter("streamingServiceSN", streamingServiceSN);
        qry.setParameter("yearMonth", yearMonth);
        List<ShowLicenseRecord> showLicenseRecords = qry.getResultList();
        return showLicenseRecords;
    }

    @Override
    public void deleteById(String streamingServiceShortName, String showShortName, Integer showYear, String yearMonth) {
        Session currentSession = entityManager.unwrap(Session.class);
        ShowLicenseRecord showLicenseRecord = findById(streamingServiceShortName, showShortName, showYear, yearMonth);
        currentSession.remove(showLicenseRecord);
        return;
    }
}
