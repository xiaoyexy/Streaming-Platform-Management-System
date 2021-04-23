package edu.gatech.streamingwars.dao;

import edu.gatech.streamingwars.entity.Show;
import edu.gatech.streamingwars.entity.Studio;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class StudioDAOImpl implements StudioDAO{

    private EntityManager entityManager;

    @Autowired
    public StudioDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }



    @Override
    public List<Studio> findAll() {

        Session currentSession = entityManager.unwrap(Session.class);
        // create a query
        Query<Studio> qry =
                currentSession.createQuery("FROM Studio s " +
                        "ORDER BY s.shortName", Studio.class);

        // execute query and get result list
        List<Studio> studios = qry.getResultList();
        return studios;
    }

    @Override
    public Studio findById(String studioShortName) {
        return null;
    }

    @Override
    public void save(Studio studio) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.save(studio);
    }
}
