package com.brynhagen.gui;

import com.brynhagen.framework.spring.HibernateDaoImpl;
import com.brynhagen.gui.tabs.RankingsTab;

import java.awt.*;
import javax.swing.*;

import net.miginfocom.swing.MigLayout;

public class MainFrame extends JFrame {

    private final Container contentPane;

    HibernateDaoImpl hibernateDaoImpl;
    JTabbedPane tabbedPane;


    public MainFrame(HibernateDaoImpl hibernateDaoImpl)
    {
        this.hibernateDaoImpl = hibernateDaoImpl;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(800, 600));
        contentPane = getContentPane();
        contentPane.setLayout(new MigLayout());
        init();
        setVisible(true);
    }

    private void init()
    {
        tabbedPane = new JTabbedPane();
        tabbedPane.setPreferredSize(new Dimension(800, 600));
        contentPane.setBackground(ClientConstants.contentBackgroundColor);
        contentPane.add(tabbedPane);

        tabbedPane.add(new RankingsTab());

    }
}
