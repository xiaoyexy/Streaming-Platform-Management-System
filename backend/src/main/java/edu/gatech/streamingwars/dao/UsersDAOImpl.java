package edu.gatech.streamingwars.dao;

import edu.gatech.streamingwars.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UsersDAOImpl implements UsersDAO{
    private EntityManager entityManager;
    @Autowired
    public UsersDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        // create a query
        Query<User> qry =
                currentSession.createQuery("FROM User u " +
                        "ORDER BY u.username", User.class);

        // execute query and get result list
        List<User> users = qry.getResultList();

        // return the results
        return users;
    }

    @Override
    public List<User> authenticate(String username, String password) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<User> qry =
                currentSession.createQuery("FROM User u " +
                        "where u.username= :username and u.password= :password",
                        User.class);
//        User user = currentSession.get(User.class, shortName);
        List<User> users=qry.setParameter(
                "username",username).setParameter(
                        "password",password).getResultList();
        return users;
    }
}
