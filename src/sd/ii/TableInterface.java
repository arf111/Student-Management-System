package sd.ii;

import java.sql.SQLException;

public interface TableInterface {
    
    void Show_Table() throws SQLException, ClassNotFoundException;              //Show the table
    void sort();                    //Sort the table
    
}
