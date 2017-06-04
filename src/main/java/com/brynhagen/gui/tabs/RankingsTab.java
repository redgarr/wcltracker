package com.brynhagen.gui.tabs;

import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import com.brynhagen.framework.spring.HibernateDaoImpl;
import com.brynhagen.gui.ClientConstants;
import com.brynhagen.gui.GraphController;
import com.brynhagen.gui.GraphPane;

/**
 * Created by jonathan on 26/05/17.
 */
public class RankingsTab
	extends JPanel
{

	private GraphController controller;

	public RankingsTab(GraphController controller)
	{
		this.controller = controller;
		init();
		setName("Rankings");
		setBackground(ClientConstants.paneContentBackgroundColor);
		setLayout(new MigLayout("","[grow, fill]","[grow, fill]"));
	}

	private void init()
	{
		add(new GraphPane(controller), "grow");
	}
}
