package com.brynhagen.gui.ui;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

import com.brynhagen.gui.ClientConstants;

/**
 * Created by Jonathan on 2017-06-02.
 */
public class GraphToolbarComboBoxRenderer
	extends JLabel
	implements ListCellRenderer
{

	public GraphToolbarComboBoxRenderer()
	{
		setOpaque(true);
		setForeground(ClientConstants.graphToolbarTextColor);
	}

	@Override
	public Component getListCellRendererComponent(JList list, Object value,
		int index, boolean isSelected, boolean cellHasFocus)
	{
		if(value == null)
		{
			setText("Null");
		}
		else
		{
			setText(value.toString());
		}
		if(isSelected)
		{
			setBackground(ClientConstants.contentBackgroundColor);
		}
		else
		{
			setBackground(ClientConstants.paneContentBackgroundColor);
		}

		return this;
	}
}
