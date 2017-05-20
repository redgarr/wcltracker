package com.brynhagen;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new SpringApplicationBuilder(Application.class)
                .headless(false)
                .web(false)
                .run(args);

        PropertyConfigurator.configure("log4j.properties");
    }

    @Bean
    public JFrame createMainFrame()
    {
        MainFrame mainFrame = new MainFrame();
        return mainFrame;
    }

}