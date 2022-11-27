package library;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*; 

public class ViewBook extends JFrame
{
    String x[]={"Id","Book no","Book name","Author","Publisher","Quantity","Issued","Date"};
    JButton bt;
    String y[][]=new String[20][8];
    int i=0,j=0;
    JTable t;
    Font f,f1;
    ViewBook()
    {
       super ("Book Information");//page upora title r jono
       setLocation(450,300);
       setSize(1000,400);
       
       f=new Font("Arial",Font.BOLD,15); 
       
       try
       {
           ConnectionClass obj=new ConnectionClass();
           String s="Select * from addbook";
           ResultSet rs = obj.stm.executeQuery(s);
           while(rs.next())
           {
               y[i][j++]=rs.getString("id");
               y[i][j++]=rs.getString("BookNo");
               y[i][j++]=rs.getString("bookname");
               y[i][j++]=rs.getString("author");
               y[i][j++]=rs.getString("publisher");
               y[i][j++]=rs.getString("quantity");
               y[i][j++]=rs.getString("issuebook");
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
       new ViewBook().setVisible(true);
    }
}
