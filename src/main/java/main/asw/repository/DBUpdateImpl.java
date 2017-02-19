package main.asw.repository;


import main.asw.report.Factory;
import main.asw.user.User;

import java.util.List;

class DBUpdateImpl implements DBUpdate {

    private List<User> users;

    @Override
    public void insert(List<User> users) {
        UserDao ud = PersistenceFactory.getUserDAO();
        this.users = users;
        users.forEach(ud::saveUser);
    }

    @Override
    public void writeReport() {
        Factory factory = new Factory();
        factory.getTxtWriter().writeReport(users);
        factory.getDocxWriter().writeReport(users);
        factory.getPdfWriter().writeReport(users);
    }
}
