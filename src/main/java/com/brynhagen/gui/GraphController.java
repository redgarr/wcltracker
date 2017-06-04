package com.brynhagen.gui;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Component;

import com.brynhagen.entity.Encounter;
import com.brynhagen.entity.Ranking;
import com.brynhagen.entity.Zone;
import com.brynhagen.framework.spring.HibernateDao;
import com.brynhagen.framework.spring.HibernateDaoImpl;

/**
 * Created by Jonathan on 2017-05-27.
 */
@Component
public class GraphController
{

	@Autowired
	HibernateDaoImpl hibernateDao;

	@Autowired
	TaskExecutor executor;

	GraphToolbar graphToolbar;

	GraphPanel graphPanel;

	GraphPane graphPane;

	GraphSettingPane graphSettingPane;

	public GraphController(TaskExecutor executor, HibernateDaoImpl hibernateDao)
	{
		this.executor = executor;
		this.hibernateDao = hibernateDao;
		System.out.println("executor = " + executor);
		System.out.println("hibernateDao = " + hibernateDao);
	}

	public HibernateDaoImpl getHibernateDao()
	{
		return hibernateDao;
	}

	public void setHibernateDao(HibernateDaoImpl hibernateDao)
	{
		this.hibernateDao = hibernateDao;
	}

	public GraphToolbar getGraphToolbar()
	{
		return graphToolbar;
	}

	public void setGraphToolbar(GraphToolbar graphToolbar)
	{
		this.graphToolbar = graphToolbar;
	}

	public GraphPanel getGraphPanel()
	{
		return graphPanel;
	}

	public void setGraphPanel(GraphPanel graphPanel)
	{
		this.graphPanel = graphPanel;
	}

	public GraphPane getGraphPane()
	{
		return graphPane;
	}

	public void setGraphPane(GraphPane graphPane)
	{
		this.graphPane = graphPane;
	}

	public GraphSettingPane getGraphSettingPane()
	{
		return graphSettingPane;
	}

	public void setGraphSettingPane(GraphSettingPane graphSettingPane)
	{
		this.graphSettingPane = graphSettingPane;
	}

	public List<Zone> getZones()
	{
		return hibernateDao.getAllZones();
	}

	public List<Ranking> getRankings(String characterName, String serverName, String serverRegion,
		Zone zone, Encounter encounter)
	{
		return hibernateDao.getRankings(characterName, serverName, serverRegion, zone, encounter);
	}

	public void invoke(Runnable runnable)
	{
		executor.execute(runnable);
	}

	public void updateRankings(List<Ranking> rankingsList)
	{
		graphPanel.updateRankings(rankingsList);
	}
}
