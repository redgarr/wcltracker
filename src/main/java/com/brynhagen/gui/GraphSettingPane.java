package com.brynhagen.gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;

import net.miginfocom.swing.MigLayout;

import com.brynhagen.entity.Encounter;
import com.brynhagen.entity.Ranking;
import com.brynhagen.entity.Zone;
import com.brynhagen.enums.PlayerClass;
import com.brynhagen.enums.Specialisation;
import com.brynhagen.gui.ui.GraphToolbarComboBoxEditor;
import com.brynhagen.gui.ui.GraphToolbarComboBoxRenderer;
import com.brynhagen.gui.ui.GraphToolbarComboBoxUI;

/**
 * Created by jonathan on 26/05/17.
 */
public class GraphSettingPane
	extends JPanel
{

	private GraphController controller;

	public GraphSettingPane(GraphController controller)
	{
		this.controller = controller;
		controller.setGraphSettingPane(this);
		setLayout(new MigLayout("","","[fill]"));
		setBackground(ClientConstants.contentBackgroundColor);
		init();
	}

	private void init()
	{
		JComboBox<Zone> zonesJComboBox = new JComboBox(controller.getZones().toArray());
		zonesJComboBox.setPreferredSize(new Dimension(40, 15));

		JComboBox<Encounter> encountersJComboBox = new JComboBox();
		encountersJComboBox.setPreferredSize(new Dimension(40, 15));

		zonesJComboBox.addItemListener(new ItemListener()
		{

			@Override
			public void itemStateChanged(ItemEvent e)
			{
				System.out.println("e.getItem() = " + e.getItem().getClass());
				Zone zone = (Zone)e.getItem();

				encountersJComboBox.setModel(
					new DefaultComboBoxModel(zone.getEncounters().toArray()));
				encountersJComboBox.repaint();
			}
		});

		JComboBox<PlayerClass> playerClassJComboBox = new JComboBox();
		Dimension settingSize = new Dimension(130, 30);
		Dimension settingSizeSmaller = new Dimension(70, 30);
		playerClassJComboBox.setPreferredSize(settingSize);
		playerClassJComboBox.setModel(new DefaultComboBoxModel<PlayerClass>(PlayerClass.values()));

		JComboBox<Specialisation> playerSpecJComboBox = new JComboBox();
		playerSpecJComboBox.setModel(new DefaultComboBoxModel<Specialisation>(Specialisation.values()));

		zonesJComboBox.setRenderer(new GraphToolbarComboBoxRenderer());
		zonesJComboBox.setEditor(new GraphToolbarComboBoxEditor());
		zonesJComboBox.setUI(new GraphToolbarComboBoxUI());
		zonesJComboBox.setMinimumSize(settingSize);
		zonesJComboBox.setPreferredSize(settingSize);
		zonesJComboBox.setMaximumSize(settingSize);
		zonesJComboBox.setEditable(true);

		encountersJComboBox.setRenderer(new GraphToolbarComboBoxRenderer());
		encountersJComboBox.setEditor(new GraphToolbarComboBoxEditor());
		encountersJComboBox.setUI(new GraphToolbarComboBoxUI());
		encountersJComboBox.setMinimumSize(settingSize);
		encountersJComboBox.setPreferredSize(settingSize);
		encountersJComboBox.setMaximumSize(settingSize);
		encountersJComboBox.setEditable(true);

		playerClassJComboBox.setRenderer(new GraphToolbarComboBoxRenderer());
		playerClassJComboBox.setEditor(new GraphToolbarComboBoxEditor());
		playerClassJComboBox.setMinimumSize(settingSize);
		playerClassJComboBox.setUI(new GraphToolbarComboBoxUI());
		playerClassJComboBox.setPreferredSize(settingSize);
		playerClassJComboBox.setMaximumSize(settingSize);
		playerClassJComboBox.setEditable(true);

		playerSpecJComboBox.setRenderer(new GraphToolbarComboBoxRenderer());
		playerSpecJComboBox.setEditor(new GraphToolbarComboBoxEditor());
		playerSpecJComboBox.setMinimumSize(settingSizeSmaller);
		playerSpecJComboBox.setUI(new GraphToolbarComboBoxUI());
		playerSpecJComboBox.setPreferredSize(settingSizeSmaller);
		playerSpecJComboBox.setMaximumSize(settingSizeSmaller);
		playerSpecJComboBox.setEditable(true);

		JTextField playerField = new JTextField("Player");

		JTextField realmField = new JTextField("Realm");



		JButton searchButton = new JButton();
		searchButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				List<Ranking> rankingsList = controller.getRankings(playerField.getText(), realmField.getText(), "EU",
					(Zone) zonesJComboBox.getSelectedItem(), (Encounter)encountersJComboBox.getSelectedItem());
				controller.updateRankings(rankingsList);
			}
		});

		add(zonesJComboBox);
		add(encountersJComboBox);
		add(playerField);
		add(realmField);
		add(playerClassJComboBox);
		add(playerSpecJComboBox);
		add(searchButton);

	}

}
