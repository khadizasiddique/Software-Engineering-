package library;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*; 

public class ViewLibrarian extends JFrame  
{
    String x[]={"Id","Name","Password","Email","Contact","Address","City"};
    JButton bt;
    String y[][]=new String[20][7];
    int i=0,j=0;
    JTable t;
    Font f,f1;
    ViewLibrarian()
    {
       super ("Add Librarian");//page upora title r jono
       setLocation(450,300);
       setSize(1000,400);
       
       f=new Font("Arial",Font.BOLD,15); 
       
       try
       {
           ConnectionClass obj=new ConnectionClass();
           String s="Select * from librarian";
           ResultSet rs = obj.stm.executeQuery(s);
           while(rs.next())
           {
               y[i][j++]=rs.getString("Lid");
               y[i][j++]=rs.getString("Name");
               y[i][j++]=rs.getString("Password");
               y[i][j++]=rs.getString("Email");
               y[i][j++]=rs.getString("Contact");
               y[i][j++]=rs.getString("Address");
               y[i][j++]=rs.getString("City");
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
       new ViewLibrarian().setVisible(true);
    }
}
