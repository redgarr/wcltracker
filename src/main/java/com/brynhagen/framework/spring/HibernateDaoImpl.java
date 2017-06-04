package com.brynhagen.framework.spring;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.brynhagen.entity.Encounter;
import com.brynhagen.entity.Ranking;
import com.brynhagen.entity.Zone;
import com.brynhagen.rest.RestCaller;

/**
 * Created by Jonathan on 2017-05-21.
 */
@Repository
public class HibernateDaoImpl extends HibernateDaoSupport
{
    SessionFactory sessionFactory;

    @Autowired
    RestCaller caller;

    @Autowired
    public HibernateDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * Tries to retrieve a zone with a given name. Will first look in database and
     * if not  found there will make a call to WCL and stores the zone it found.
     * @param name
     *      name of the zone to get
     * @return
     *      a zone
     */
    public Zone getZone(String name)
    {
        Session session = sessionFactory.openSession();
        List<Zone> dbZones = session.createQuery("from Zone where name='"+ name + "'").list();

        //do rest call instead
        if(dbZones.isEmpty())
        {
            dbZones.addAll(caller.getAllZones());
        }

        Zone zone = dbZones.stream()
            .filter(z -> z.getName().equals(name))
            .findFirst()
            .get();

        if(!dbZones.contains(zone))
        {
            session.save(zone);
            session.flush();
        }

        return zone;
    }

    /**
     * Gets all zones from database and WCL and stores the ones missing from the database.
     *
     * @return
     *      All Zones
     */
    public List<Zone> getAllZones()
    {
		Transaction trans = null;
		Session session = null;
		List<Zone> list = new ArrayList();
		List<Zone> dbZones = null;
		boolean needCommit = false;
    	try
		{
			session = sessionFactory.openSession();
			trans = session.beginTransaction();

			dbZones = session.createQuery("from Zone").list();
			//list = caller.getAllZones();

			for(Zone z : list)
			{
				if(dbZones.contains(z) == false)
				{
					session.save(z);
					needCommit = true;
				}
			}

			if(needCommit == true)
			{
				trans.commit();
			}
		}
		catch(Exception e)
		{
			System.err.print(e);
			trans.rollback();
		}
		finally
		{
			session.flush();
		}

		list.addAll(dbZones);

        return list.stream().sorted().collect(Collectors.toList());
    }

    public List<Ranking> getRankings(String characterName, String serverName, String serverRegion,
		Zone zone, Encounter encounter)
	{
		return caller.getRankings(characterName, serverName, serverRegion, zone, encounter);
	}
}
