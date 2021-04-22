package edu.gatech.streamingwars.dao;

import edu.gatech.streamingwars.entity.Studio;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.List;

public class StudioDAOImpl implements StudioDAO{

    private EntityManager entityManager;

    @Autowired
    public StudioDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }



    @Override
    public List<Studio> findAll() {
        return null;
    }

    @Override
    public Studio findById(String studioShortName) {
        return null;
    }

    @Override
    public void save(Studio studio) {

    }
}
