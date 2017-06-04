package com.brynhagen.gui.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicComboBoxEditor;

import com.brynhagen.gui.ClientConstants;

/**
 * Created by Jonathan on 2017-06-02.
 */
public class GraphToolbarComboBoxEditor
	extends BasicComboBoxEditor
{
	private JLabel label = new JLabel();
	private JPanel panel = new JPanel();
	private Object selectedItem;

	public GraphToolbarComboBoxEditor()
	{
		label.setOpaque(true);
		label.setFont(new Font("Arial", Font.BOLD, 12));
		label.setBackground(ClientConstants.paneContentBackgroundColor);
		label.setForeground(ClientConstants.graphToolbarTextColor);

		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 2));
		panel.add(label);
		panel.setBackground(ClientConstants.paneContentBackgroundColor);
		panel.setForeground(ClientConstants.graphToolbarTextColor);
	}

	public Component getEditorComponent() {
		return this.panel;
	}

	public Object getItem() {
		return selectedItem;
	}

	public void setItem(Object item) {
		this.selectedItem = item;
		if(selectedItem == null)
		{
			label.setText("Null");
		}
		else
		{
			label.setText(selectedItem.toString());
		}
	}

}
