package com.brynhagen.gui;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

/**
 * Created by jonathan on 26/05/17.
 */
public class GraphSettingPane
	extends JPanel
{

	public GraphSettingPane()
	{
		setLayout(new MigLayout("","","[fill]"));
		setBackground(ClientConstants.contentBackgroundColor);
		init();
	}

	private void init()
	{
		add(new JComboBox<Object>(), "w 40");
		add(new JButton("Encounter"), "w 40");
		add(new JButton("Player"), "w 40");
		add(new JButton("Class"), "w 40");
		add(new JButton("Spec"), "w 40");
	}
}
