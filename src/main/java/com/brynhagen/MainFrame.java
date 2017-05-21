package com.brynhagen;

import com.brynhagen.framework.spring.HibernateDaoImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.*;
import javax.swing.*;


public class MainFrame extends JFrame {

    HibernateDaoImpl hibernateDaoImpl;

    JLabel label;


    public MainFrame(HibernateDaoImpl hibernateDaoImpl) {
        this.hibernateDaoImpl = hibernateDaoImpl;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        init();
    }

    public void init() {
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(new Dimension(600, 400));
        label = new JLabel();
        JPanel panel = new JPanel();
        panel.add(label);


        panel.add(new TestButton());
        add(panel);
        setVisible(true);
        setState(Frame.NORMAL);
        show();

        label.setText(Integer.toString(hibernateDaoImpl.getPlayerCount()));

    }
}