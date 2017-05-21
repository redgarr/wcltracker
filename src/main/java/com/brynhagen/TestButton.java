package com.brynhagen;

import com.brynhagen.framework.spring.HibernateDao;
import com.brynhagen.framework.spring.HibernateDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Jonathan on 2017-05-21.
 */
@Configurable
public class TestButton extends JButton {


    public TestButton setHibernateDaoImpl(HibernateDaoImpl hibernateDaoImpl) {
        this.hibernateDaoImpl = hibernateDaoImpl;
        return this;
    }

    private HibernateDaoImpl hibernateDaoImpl;


    public TestButton() {
        super();
        setText("Press me!");
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(hibernateDaoImpl);
                TestButton.this.setText(Integer.toString(hibernateDaoImpl.getPlayerCount()));
            }
        });
    }
}