package main.asw.repository;


import main.asw.report.ReportFactory;
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
        ReportWriter textWriter = ReportFactory.createTxtWriter();
        ReportWriter docxWriter = ReportFactory.createDocxWriter();
        ReportWriter pdfWriter = ReportFactory.createPdfWriter();
        textWriter.writeReport(users);
        docxWriter.writeReport(users);
        pdfWriter.writeReport(users);
    }
}
