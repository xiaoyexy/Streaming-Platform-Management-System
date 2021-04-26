package edu.gatech.streamingwars.dao;

import edu.gatech.streamingwars.entity.ShowLicenseRecord;
import edu.gatech.streamingwars.entity.StreamingService;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class StreamingServiceDAOImpl implements StreamingServiceDAO{
    private EntityManager entityManager;

    @Autowired
    public StreamingServiceDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<StreamingService> findAll() {

        Session currentSession = entityManager.unwrap(Session.class);
        // create a query
        Query<StreamingService> qry =
                currentSession.createQuery("FROM StreamingService s " +
                        "ORDER BY s.shortName", StreamingService.class);

        // execute query and get result list
        List<StreamingService> streamingServices = qry.getResultList();

        // return the results
        return streamingServices;
    }

    @Override
    public StreamingService findById(String streamingServiceShortName) {

        Session currentSession = entityManager.unwrap(Session.class);
        StreamingService streamingService = currentSession.get(StreamingService.class, streamingServiceShortName);
        return streamingService;
    }

    @Override
    public void save(StreamingService streamingService) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.save(streamingService);
    }
}
