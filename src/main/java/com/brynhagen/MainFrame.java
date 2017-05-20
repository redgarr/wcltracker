package com.brynhagen;

import org.apache.log4j.Logger;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.WindowConstants;


public class MainFrame extends JFrame {

    Logger logger = Logger.getLogger(MainFrame.class);

    public MainFrame() {
        logger.trace("Initializing MainFrame");
        init();
    }

    public void init() {
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(new Dimension(600, 400));
 
        setVisible(true);
        setState(Frame.NORMAL);
        show();
    }
}