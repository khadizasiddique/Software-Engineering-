package library;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class ViewIssueBook extends JFrame
{
    String x[]={"Book Id","Book no","Book name","Student id","Student name","Student contact","Date"};
    JButton bt;
    String y[][]=new String[20][7];
    int i=0,j=0;
    JTable t;
    Font f,f1;

    ViewIssueBook()
    {
        super ("Issue Information");//page upora title r jono
        setLocation(450,300);
        setSize(1000,400);

        f=new Font("Arial",Font.BOLD,15);

        try
        {
            ConnectionClass obj=new ConnectionClass();
            String s="Select * from issuebook";
            ResultSet rs = obj.stm.executeQuery(s);
            while(rs.next())
            {
                y[i][j++]=rs.getString("BookId");
                y[i][j++]=rs.getString("bookno");
                y[i][j++]=rs.getString("bookname");
                y[i][j++]=rs.getString("studentid");
                y[i][j++]=rs.getString("studentname");
                y[i][j++]=rs.getString("studentcontact");
                y[i][j++]=rs.getString("date");
                i++;
                j=0;

            }
            t=new JTable(y,x);
            t.setFont(f);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        JScrollPane sp= new JScrollPane(t);
        add(sp);
    }
    public static void main(String[] args)
    {
        new ViewIssueBook().setVisible(true);
    }
}
