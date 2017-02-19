package main.asw.repository;


import main.asw.report.Factory;
import main.asw.user.User;

import java.util.ArrayList;

public class DBUpdateImpl implements DBUpdate {

    private ArrayList<User> users = new ArrayList<User>();

    @Override
    public void insert(User user) {
        //repository.save(user);
    }

    @Override
    public void writeReport() {
        Factory factory = new Factory();
        factory.getTxtWriter().writeReport(users);
        factory.getDocxWriter().writeReport(users);
        factory.getPdfWriter().writeReport(users);
    }
}
