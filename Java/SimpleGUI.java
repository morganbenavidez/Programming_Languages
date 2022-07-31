import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//Morgan Benavidez
public class SimpleGUI extends JFrame implements ActionListener
{
    private static final long serialVersionUID = 1L;
    JLabel l1, l2, l3, l4, l5;       
    JButton b1, b2;
    JTextField t1, t2, t3, t4;
    JCheckBox check1;
    
    SimpleGUI()
    {
        l1 = new JLabel(" Current Salary");
        l2 = new JLabel(" Percent Rate");
        l3 = new JLabel(" New Salary");
        l4 = new JLabel("  ");
        l5 = new JLabel(" Difference");
        check1 = new JCheckBox("bonus pay");
        b1 = new JButton("COMPUTE");
        t1 = new JTextField(10);
        t2 = new JTextField(10);
        t3 = new JTextField(10);
        t4 = new JTextField(10);
        b2 = new JButton("EXIT");
        
        
        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(l3);
        add(t3);
        add(check1);
        add(l4);
        add(l5);
        add(t4);
        add(b1);
        add(b2);
        b1.addActionListener(this);
        b2.addActionListener(e -> System.exit(0));
        check1.setSelected(true);
        
        setSize(500, 300);
        setLayout(new GridLayout(6,2));
        setTitle("Simple Java GUI");
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        float a, b, c, d;
        
        if (ae.getSource() == b1)
        {
            a = Float.parseFloat(t1.getText());
            b = Float.parseFloat(t2.getText());
            c = (a/100) * b;
            d = c + a;
            //t3.setText(String.valueOf(c));
        
            //verify the checkbox state
            if (check1.isSelected())
            {
                d += 500;
                //c = (((a/100) * b) + 500);
                t3.setText(String.valueOf(d));
                t4.setText(String.valueOf(c));
            }
            
            else
            {
                //c = (a/100) * b;
                //d = a - c;
                t3.setText(String.valueOf(d));
                t4.setText(String.valueOf(c));
            }
    }
    }
    public static void main(String args[])
    {
        SimpleGUI a = new SimpleGUI();
        a.setVisible(true);
        a.setLocation(200, 200);
    }
}