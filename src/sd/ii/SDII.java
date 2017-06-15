package sd.ii;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SDII {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        //DeleteStudent del = new DeleteStudent();
        //del.setVisible(true);
        //DatabaseTest db = new DatabaseTest();
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Stuinfo_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        try {
            Thread.sleep(3000);

        } catch (Exception ex) {

        }
        new StudentLogIn().setVisible(true);
    }
}
