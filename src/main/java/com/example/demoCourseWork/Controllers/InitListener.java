package com.example.demoCourseWork.Controllers;

import com.example.demoCourseWork.DB.DAOImplementations.DAOFactory;
import com.example.demoCourseWork.Services.LotService;
import com.example.demoCourseWork.Services.UserService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.IOException;

public class InitListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        DAOFactory daoFactory = new DAOFactory();
        StrategySelector strategySelector = new StrategySelector(
                new UserService(daoFactory),
                new LotService(daoFactory)
        );
        servletContextEvent.getServletContext().setAttribute("selector", strategySelector);

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
