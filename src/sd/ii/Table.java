package sd.ii;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class Table extends JFrame{
    JTable jt;
    
    Object[] columnTitle = {"Course", "Marks"};
    Object[][] values = {{"DS", "70"}};
    
    public Table()
    {
        jt = new JTable(values, columnTitle);
        jt.setBounds(50,50,200,300);
        JScrollPane js = new JScrollPane(jt);
        this.add(js);
        this.setSize(500, 700);
        this.setVisible(true);
    }
}