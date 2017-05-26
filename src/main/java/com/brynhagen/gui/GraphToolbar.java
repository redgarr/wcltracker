package com.brynhagen.gui;

import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Created by jonathan on 26/05/17.
 */
public class GraphToolbar
	extends JPanel
{

	private final GraphPanel graphPanel;

	public GraphToolbar(GraphPanel graphPanel)
	{
		this.graphPanel = graphPanel;
		init();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}

	private void init()
	{
		JButton repaintButton = new JButton("RP");
		repaintButton.addActionListener(e -> {graphPanel.repaint();});

		add(repaintButton);
		add(new JButton("B"));
		add(new JButton("C"));
		add(new JButton("D"));
	}

}
