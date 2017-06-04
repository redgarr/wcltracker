package com.brynhagen.gui;

import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.brynhagen.framework.spring.HibernateDaoImpl;

/**
 * Created by jonathan on 26/05/17.
 */
public class GraphToolbar
	extends JPanel
{

	private final GraphPanel graphPanel;
	private GraphController controller;

	public GraphToolbar(GraphPanel graphPanel, GraphController controller)
	{
		this.graphPanel = graphPanel;
		this.controller = controller;
		controller.setGraphToolbar(this);
		init();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}

	private void init()
	{
		JButton repaintButton = new JButton("RP");
		repaintButton.addActionListener(e -> {graphPanel.repaint();});


		JButton getZonesButton = new JButton("GZ");
		getZonesButton.addActionListener(e -> {});

		add(repaintButton);
		add(getZonesButton);
		add(new JButton("C"));
		add(new JButton("D"));
	}

}
