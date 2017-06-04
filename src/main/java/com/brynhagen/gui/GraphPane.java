package com.brynhagen.gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import com.brynhagen.framework.spring.HibernateDaoImpl;

/**
 * Created by jonathan on 26/05/17.
 */
public class GraphPane
	extends JPanel
{

	private GraphPanel graphPanel;
	private GraphController controller;

	public GraphPane(GraphController controller)
	{
		this.controller = controller;
		controller.setGraphPane(this);
		//		setPreferredSize(new Dimension(750, 400));
		setLayout(new MigLayout("", "[][grow, fill]", "[10%][90%]"));
		setBackground(ClientConstants.paneContentBackgroundColor);
		init();
	}

	private void init()
	{
		graphPanel = new GraphPanel(controller);

		add(new GraphSettingPane(controller), "skip, wrap");
		add(new GraphToolbar(graphPanel, controller));
		add(graphPanel, "grow");
	}
}
