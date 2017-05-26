package com.brynhagen.gui;

import java.awt.Dimension;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

import com.brynhagen.entity.PlayerClass;
import com.brynhagen.entity.Specialisation;

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
		JComboBox<PlayerClass> playerClassJComboBox = new JComboBox();
		playerClassJComboBox.setModel(new DefaultComboBoxModel<PlayerClass>(PlayerClass.values()));
		playerClassJComboBox.setPreferredSize(new Dimension(40, 15));
		add(new JComboBox<Object>(), "w 40");
		add(new JComboBox<Object>(), "w 40");
		add(new JTextField("Player"), "w 40");
		add(new JTextField("Realm"), "w 40");
		add(playerClassJComboBox, "w 40!");

		JComboBox<Specialisation> playerSpecJComboBox = new JComboBox();
		playerSpecJComboBox.setModel(new DefaultComboBoxModel<Specialisation>(Specialisation.values()));
		add(playerSpecJComboBox, "w 40");
	}
}
