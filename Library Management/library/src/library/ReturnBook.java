package library;
import java.awt.event.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

import java.util.Date;

public class ReturnBook extends JFrame implements ActionListener
{
    JLabel l1,l2,l3;
    JButton bt1,bt2;
    JPanel p1,p2;
    Font f,f1;
    JTextField tf1,tf2;
    Choice ch;

    ReturnBook()
    {
        super("Return Book");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        f1=new Font("Arial",Font.BOLD,20);

        l3=new JLabel("Return Books");
        l3.setFont(new Font("Tahoma",Font.BOLD,18));
        l3.setForeground(Color.BLUE);
        l3.setBounds(150, 20, 150, 30);
        l3.setBackground(Color.CYAN);
        add(l3);

        l1= new JLabel("Book No");
        l1.setFont(new Font("Tahoma",Font.BOLD,18));
        l1.setBounds(40, 70, 100, 30);
        add(l1);

        tf1=new JTextField();
        tf1.setBounds(170, 70, 200, 30);
        tf1.setFont(f1);
        tf1.setEditable(false);
        add(tf1);

        l2= new JLabel("Student Id");
        l2.setFont(new Font("Tahoma",Font.BOLD,18));
        l2.setBounds(40, 120, 100, 30);
        add(l2);

        ch=new Choice();
       try
       {
            ConnectionClass obj=new ConnectionClass();
            String q="select studentid from issuebook";
            ResultSet r=obj.stm.executeQuery(q);
            while(r.next())
            {
                ch.add(r.getString("studentid"));
            }
        }
        catch (Exception k)
        {
            k.printStackTrace();
        }
       ch.setFont(f1);
       ch.setBounds(170, 120, 200, 30);
       add(ch);


        bt1=new JButton("Return Book");
        bt1.setBounds(40,180,190,30);
        bt1.setFont(f1);
        bt1.addActionListener(this);
        add(bt1);

        bt2 =new JButton("Cancel");
        bt2 .setBounds(300,180,190,30);
        bt2.setFont(f1);
        bt2 .addActionListener(this);
        add(bt2 );

        setBounds(500,200,560,300);
        setVisible(true);

        ch.addMouseListener(new MouseAdapter()
       {

            public void mouseClicked(MouseEvent e) {
                try
                {
                    ConnectionClass obj2=new ConnectionClass();
                    String id=(ch.getSelectedItem());
                    String q1="select *from issuebook where studentid='"+id+"'";
                    ResultSet rs=obj2.stm.executeQuery(q1);
                  while(rs.next())
                    {
                        tf1.setText(rs.getString("bookno"));
                   }
               }
                catch(Exception exx)
               {
                    exx.printStackTrace();
                }
            }
       });



    }
    public void actionPerformed(ActionEvent ae)
    {
        String id=(ch.getSelectedItem());
        String bookno=tf1.getText();
        if(ae.getSource()==bt1)
        {
            if(id.equals(" ")||bookno.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please Fill The All Field");
                return;
            }
            try
            {
                ConnectionClass obj=new ConnectionClass();
                String q= "delete from issuebook where bookno='"+bookno+"'";
                int res=obj.stm.executeUpdate(q);
                if(res==0)
                {
                    JOptionPane.showMessageDialog(null, "Book is't issue");
                    this.setVisible(false);
                }
                else
                {
                    String q3="update addbook set issuebook= issuebook-1 where BookNo='"+bookno+"'";
                    String q4="update addbook set quantity= quantity+1 where BookNo='"+bookno+"'";
                    int aaa=obj.stm.executeUpdate(q3);
                    int aaaa=obj.stm.executeUpdate(q4);
                    if(aaa==1)
                    {
                        if(aaaa==1)
                        {
                            JOptionPane.showMessageDialog(null, "Your book successfully returned");
                            this.setVisible(false);
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Please~Fill all details carefully");
                        }

                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Please~Fill all details carefully");
                    }
                }

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        if(ae.getSource()==bt2)
        {
            JOptionPane.showMessageDialog(null, "Are You sure !");
            this.setVisible(false);
        }
    }
    public static void main(String[] args)
    {
        new ReturnBook().setVisible(true);
    }
}

