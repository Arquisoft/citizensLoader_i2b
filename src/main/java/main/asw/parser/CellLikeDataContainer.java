package main.asw.parser;

import java.io.IOException;

/**
 * Created by nicolas on 10/02/17.
 */
public interface CellLikeDataContainer {


    /**
     * Return the number of Rows in the working file
     * @return number of rows of the file
     */
    public int getNumberOfRows();

    /**
     * Return the number of columns in the current Row
     * @return number of Columns of the Row
     */
    public int getNumberOfColumns();




    public boolean nextRow() throws IOException;


    public String getCell(int index);

    int getCurrentRow();
}
