package com.brynhagen.framework.spring;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;


/**
 * Created by Jonathan on 2017-05-21.
 */
@Repository
public class HibernateDaoImpl extends HibernateDaoSupport implements HibernateDao
{

    SessionFactory sessionFactory;

    @Autowired
    public HibernateDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;

    }

    @Override
    public int getPlayerCount()
    {
        String hql = "select count(*) from PlayerImpl";
        Query query = sessionFactory.openSession().createQuery(hql);

        return ((Long)query.uniqueResult()).intValue();
    }

}
