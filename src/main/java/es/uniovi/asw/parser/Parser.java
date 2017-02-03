package es.uniovi.asw.parser;

import es.uniovi.asw.user.User;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileInputStream;
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
public class Parser {


    public List<User> loadData(String fileName) throws IOException, ParseException {
        HSSFWorkbook wb = this.readFile(fileName);
        List<User> users = new ArrayList<User>();

        for (int k = 0; k < wb.getNumberOfSheets(); k++) {
            HSSFSheet sheet = wb.getSheetAt(k);
            int rows = sheet.getPhysicalNumberOfRows();
            for (int r = 0; r < rows; r++) {
                HSSFRow row = sheet.getRow(r);

                if (row == null) {
                    throw new ParseException("Error reading line number " + k+1,k+1);
                }
                else if(row.getPhysicalNumberOfCells() != 7){
                    throw new ParseException("Error reading line " + row.getRowNum() + " the number of columns is different than expected",row.getRowNum());
                }

                else users.add(rowToUser(row));
            }
        }
        wb.close();
        return users;
    }

    private User rowToUser(HSSFRow row) throws ParseException {
        String name = row.getCell(0).getStringCellValue();
        String surname = row.getCell(1).getStringCellValue();
        String email = row.getCell(2).getStringCellValue();
        String birthDateString = row.getCell(3).getStringCellValue();
        Date date;

        try {
            date = parseDate(birthDateString);
        } catch (ParseException e) {throw new ParseException("Error with the date in " + row.getRowNum() +" it must be in American Format MM/DD/YYYY",row.getRowNum()); }
        String address = row.getCell(4).getStringCellValue();
        String nationality = row.getCell(5).getStringCellValue();
        String dni = row.getCell(6).getStringCellValue();

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
        if(!birthDateString.matches("[1-9][0-9]?/[1-9][0-9]?/[1|2][9|0][0-9][0-9]")) throw new ParseException("",0);
        date = df.parse(birthDateString);
        return date;
    }


    private HSSFWorkbook readFile(String filename) throws IOException {
        FileInputStream fis = new FileInputStream(filename);
        try {
            return new HSSFWorkbook(fis);
        } finally {
            fis.close();
        }
    }
}
