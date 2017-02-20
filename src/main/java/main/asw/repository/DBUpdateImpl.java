package main.asw.repository;


import main.asw.report.ReportFactory;
import main.asw.report.ReportWriter;
import main.asw.user.User;

import java.io.File;
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
        generateDirectories();
        ReportWriter textWriter = ReportFactory.createTxtWriter();
        ReportWriter docxWriter = ReportFactory.createDocxWriter();
        ReportWriter pdfWriter = ReportFactory.createPdfWriter();
        textWriter.writeReport(users);
        docxWriter.writeReport(users);
        pdfWriter.writeReport(users);
    }

    private void generateDirectories() {
        File dir = new File("Generated/GeneratedTxt");
        File dir2 = new File("Generated/GeneratedDocx");
        File dir3 = new File("Generated/GeneratedPdf");

        dir.mkdirs();
        dir2.mkdirs();
        dir3.mkdirs();
    }
}
