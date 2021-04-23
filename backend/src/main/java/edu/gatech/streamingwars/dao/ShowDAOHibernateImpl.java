package edu.gatech.streamingwars.dao;

import edu.gatech.streamingwars.entity.DemographicGroup;
import edu.gatech.streamingwars.entity.Show;
import edu.gatech.streamingwars.entity.ShowId;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ShowDAOHibernateImpl implements ShowDAO{
    private EntityManager entityManager;

    @Autowired
    public ShowDAOHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Show> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        // create a query
        Query<Show> qry =
                currentSession.createQuery("FROM Show s " +
                        "ORDER BY s.shortName, s.year", Show.class);

        // execute query and get result list
        List<Show> shows = qry.getResultList();

        // return the results
        return shows;
    }

    @Override
    public Show findById(String showShortName, int year) {
        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);
        ShowId showId = new ShowId(showShortName, year);

        // create a query
        Show show = currentSession.get(Show.class, showId);
        return show;

    }

    @Override
    public void save(Show show) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.save(show);
        return;
    }
}
