package com.brynhagen.gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

/**
 * Created by jonathan on 26/05/17.
 */
public class GraphPane
	extends JPanel
{

	GraphPanel graphPanel;

	public GraphPane()
	{
//		setPreferredSize(new Dimension(750, 400));
		setLayout(new MigLayout("", "[][grow, fill]", "[10%][90%]"));
		setBackground(ClientConstants.paneContentBackgroundColor);
		init();
	}

	private void init()
	{
		graphPanel = new GraphPanel();

		add(new GraphSettingPane(), "skip, wrap");
		add(new GraphToolbar(graphPanel));
		add(graphPanel, "grow");
	}
}
