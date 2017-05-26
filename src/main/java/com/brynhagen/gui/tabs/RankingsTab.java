package com.brynhagen.gui.tabs;

import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import com.brynhagen.gui.ClientConstants;
import com.brynhagen.gui.GraphPane;

/**
 * Created by jonathan on 26/05/17.
 */
public class RankingsTab
	extends JPanel
{

	public RankingsTab()
	{
		init();
		setName("Rankings");
		setBackground(ClientConstants.paneContentBackgroundColor);
		setLayout(new MigLayout("","[grow, fill]","[grow, fill]"));
	}

	private void init()
	{
		add(new GraphPane(), "grow");
	}
}
