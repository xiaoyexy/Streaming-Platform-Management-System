package edu.gatech.streamingwars.dao;

import edu.gatech.streamingwars.entity.DemographicGroup;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class DemographicGroupDAOHibernateImpl implements DemographicGroupDAO{

    // define field for entity manager
    private EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public DemographicGroupDAOHibernateImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }


    @Override
    public List<DemographicGroup> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        // create a query
        Query<DemographicGroup> qry =
                currentSession.createQuery("FROM DemographicGroup u " +
                        "ORDER BY u.shortName", DemographicGroup.class);

        // execute query and get result list
        List<DemographicGroup> DemographicGroups = qry.getResultList();

        // return the results
        return DemographicGroups;
    }

    @Override
    public DemographicGroup findById(String shortName) {
        Session currentSession = entityManager.unwrap(Session.class);
        DemographicGroup demographicGroup = currentSession.get(DemographicGroup.class, shortName);
        return demographicGroup;
    }

    @Override
    public void save(DemographicGroup demographicGroup) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.save(demographicGroup);
        return;
    }
}
