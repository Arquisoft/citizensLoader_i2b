package main.asw.parser;

import main.asw.repository.PersistenceFactory;
import main.asw.user.User;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by nicolas on 3/02/17.
 */
public class Parser implements IParser {

    private CellLikeDataContainer dataSource;
    private List<User> users;

    public Parser(String filename) throws IOException {
        this.dataSource = new ApachePoiDataContainer(filename);
    }


    @Override
    public void readList() throws IOException, ParseException {
        loadData();

    }

    @Override
    public void insert() {
        for (User user : users) {
            PersistenceFactory.getUserDAO().saveUser(user);
        }
    }


    private void loadData() throws IOException, ParseException {
        List<User> users = new ArrayList<>();

        while (dataSource.nextRow()) {
            if (dataSource.getNumberOfColumns() == 7) {
                users.add(rowToUser());
            } else {
                throw new ParseException("Error reading line " + dataSource.toString() +
                        " the number of columns is different than expected", dataSource.getCurrentRow());
            }

        }
        this.users = users;
    }

    private User rowToUser() throws ParseException {
        String name = dataSource.getCell(0);
        String surname = dataSource.getCell(1);
        String email = dataSource.getCell(2);
        String birthDateString = dataSource.getCell(3);
        Date date;

        try {
            date = parseDate(birthDateString);
        } catch (ParseException e) {
            throw new ParseException("Error with the date in " + dataSource.toString() +
                    " it must be in American Format MM/DD/YYYY", dataSource.getCurrentRow());
        }
        String address = dataSource.getCell(4);
        String nationality = dataSource.getCell(5);
        String dni = dataSource.getCell(6);

        return new User(name,
                surname,
                email,
                date,
                address,
                nationality,
                dni);

    }

    private Date parseDate(String birthDateString) throws ParseException {
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        Date date;
        df.setLenient(false);
        date = df.parse(birthDateString);
        if (date.after(new Date()))
            throw new ParseException("", 0);
        return date;
    }

    public List<User> getUsers() {
        return users;
    }

}
