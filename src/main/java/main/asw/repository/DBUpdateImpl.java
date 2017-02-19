package main.asw.repository;


import main.asw.report.Factory;
import main.asw.report.ReportWriter;
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
        ReportWriter textWriter = factory.createTxtWriter();
        ReportWriter docxWriter = factory.createDocxWriter();
        ReportWriter pdfWriter = factory.createPdfWriter();
        textWriter.writeReport(users);
        docxWriter.writeReport(users);
        pdfWriter.writeReport(users);
    }
}
