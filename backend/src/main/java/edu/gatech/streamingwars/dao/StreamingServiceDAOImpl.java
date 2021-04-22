package edu.gatech.streamingwars.dao;

import edu.gatech.streamingwars.entity.StreamingService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.List;

public class StreamingServiceDAOImpl implements StreamingServiceDAO{
    private EntityManager entityManager;

    @Autowired
    public StreamingServiceDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<StreamingService> findAll() {
        return null;
    }

    @Override
    public StreamingService findById(String streamingServiceShortName) {
        return null;
    }

    @Override
    public void save(StreamingService streamingService) {

    }
}
