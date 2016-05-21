package com.scrub.util;

import com.scrub.Game;
import com.scrub.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by ishan on 6/15/14.
 */
public class CRUD {
    public static User saveUser(User user) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();

        Integer id = (Integer) session.save(user);
        user.setId(id);

        session.getTransaction().commit();

        session.close();

        return user;
    }

    public static User readUser(String email) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        Query query = session.createQuery("from User where email = :email");
        query.setParameter("email", email);
        List users = query.list();
        session.close();
        if(users != null && !users.isEmpty()){
            users.get(0);
        }
        return null;
    }

    public static User read(Long id) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        User user = (User) session.get(User.class, id);
        session.close();
        return user;
    }

    public static Game saveGame(Game game) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();

        Integer id = (Integer) session.save(game);
        game.setId(id);

        session.getTransaction().commit();

        session.close();

        return game;
    }
}
