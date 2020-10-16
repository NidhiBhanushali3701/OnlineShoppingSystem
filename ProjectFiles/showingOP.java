import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class showingOP
{
    public static void main(String args[])
	{
        Log_Sign show = new Log_Sign();
    }
}
class Log_Sign extends customer implements ActionListener {
    JButton login,signin,exitB;
    JPanel panel;
    JFrame mainFrame;
    Log_Sign()
    {
        mainFrame = new JFrame();
        panel = new JPanel();
        mainFrame.add(panel);

        login = new JButton(" LOG-IN ");
        login.setBounds(300, 120, 120,48);
        signin = new JButton(" SIGN-IN ");
        signin.setBounds(300,201, 120,48);
        exitB =  new JButton(" EXIT ");
        exitB.setBounds(300, 282, 120,48);
        panel.add(login);
        panel.add(signin);
        panel.add(exitB);

        login.addActionListener(this);
        signin.addActionListener(this);
        exitB.addActionListener(this);

        panel.setLayout(null);
        mainFrame.setSize(693, 810);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent a)
    {
        if(a.getSource()==login)
        {
            new logIn();
            mainFrame.dispose();
        }
        else if(a.getSource()==signin)
        {
            new signIn();
            mainFrame.dispose();
        }
        else
        {
            System.exit(0);
            mainFrame.dispose();
        }
    }

}
class logIn extends customer implements ActionListener 
{
    JFrame LogInFrame;
    JPanel panel;
    JLabel lPassword,lEMail,lMSG;
    JPasswordField password;
    JTextField email;
    JButton login,exitB;
    public logIn()
    {
        super();
        LogInFrame = new JFrame();
        panel = new JPanel();
        LogInFrame.add(panel);
        lPassword= new JLabel(" ENTER PASSWORD");
        lEMail= new JLabel(" ENTER EMAIL ");
        password = new JPasswordField(15);
        email = new JTextField(15);
        login = new JButton(" LOG-IN ");
        exitB =  new JButton(" EXIT ");
        lMSG = new JLabel("");

        lEMail.setBounds(150, 12,120, 45);
        email.setBounds(300, 12,120, 45);
        lPassword.setBounds(150, 73, 120, 45);
        password.setBounds(300, 73,120, 45);
        login.setBounds(105,150,120, 45);
        exitB.setBounds(303, 150, 210,48);
        lMSG.setBounds(225, 300, 210,48);

        panel.add(lEMail);
        panel.add(email);
        panel.add(lPassword);
        panel.add(password);
        panel.add(login);
        panel.add(exitB);
        panel.add(lMSG);

        login.addActionListener(this);
        exitB.addActionListener(this);

        panel.setLayout(null);
        LogInFrame.setSize(693, 810);
        LogInFrame.setVisible(true);
        LogInFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent a)
    {
        System.out.println( customerName+" "+ customerEmail+" "+ customerGender+" "+ customerPhoneNo + " " + customerPassword);
        if(a.getSource()==login)
        {
            if(((email.getText()).equals(customerEmail)) && ((new String(password.getPassword()).equals(customerPassword))))
            {
                lMSG.setText(" LOGIN SUCCESSFUL");
            //we open our product display
            }
            else
            {
                lMSG.setText(" INCORRECT EMAIL / PASSWORD ");
            }
        }
        else if(a.getSource()==exitB)
        {
            System.exit(0);
            LogInFrame.dispose();
        }
    }
}
class signIn extends customer implements ActionListener 
{
    private static final long serialVersionUID = 1L;
    JFrame signInFrame;
    JPanel panel;
    JLabel lName,lPassword,lPhoneNo,lGender,lEMail,lAddress,lMSG;
    JPasswordField password;
    JTextField name,phoneNo,email,address;
    JRadioButton male,female;
    ButtonGroup gender;
    JButton signin,exitB;
    public signIn()
    {
        super();
        signInFrame = new JFrame();
        panel=new JPanel();
        signInFrame.add(panel);
        lName= new JLabel(" ENTER NAME ");
        lPassword= new JLabel(" ENTER PASSWORD");
        lPhoneNo= new JLabel(" ENTER PHONE NO");
        lGender= new JLabel(" SELECT GENDER ");
        lEMail= new JLabel(" ENTER EMAIL ");
        lAddress= new JLabel(" ENTER ADDRESS");
        lMSG = new JLabel("");
        password = new JPasswordField(15);
        name = new JTextField(15);
        phoneNo = new JTextField(15);
        email = new JTextField(15);
        address  = new JTextField(21);
        male = new JRadioButton(" MALE ");
        female = new JRadioButton(" FEMALE ");
        gender = new ButtonGroup();
        signin = new JButton(" SIGN-IN ");
        exitB =  new JButton(" EXIT ");
        gender.add(female);
        gender.add(male);
        lName.setBounds( 150, 12,120, 45);
        name.setBounds(300, 12,120, 45);
        lEMail.setBounds( 150, 73,120, 45);
        email.setBounds(300, 73,120, 45);
        lPassword.setBounds( 150, 156,120, 45);
        password.setBounds(300,156,120, 45);
        lPhoneNo.setBounds( 150,303,120, 45);
        phoneNo.setBounds(300,303,120, 45);
        lGender.setBounds( 150,402,120, 45);
        male.setBounds(300,402,111, 45);
        female.setBounds(531,402,111, 45);
        lAddress.setBounds( 150, 531,120, 45);
        address.setBounds(300,531,120, 51);
        signin.setBounds(150,630, 111,48);
        exitB.setBounds(303, 630, 111,48);
        lMSG.setBounds(225, 702, 120, 48);
        panel.add(lName);
        panel.add(name);
        panel.add(lEMail);
        panel.add(email);
        panel.add(lPassword);
        panel.add(password);
        panel.add(lPhoneNo);
        panel.add(phoneNo);
        panel.add(lGender);
        panel.add(male);
        panel.add(female);
        panel.add(lAddress);
        panel.add(address);
        panel.add(signin);
        panel.add(exitB);
        panel.add(lMSG);
        signin.addActionListener(this);
        exitB.addActionListener(this);

        panel.setLayout(null);
        signInFrame.setSize(693, 810);
        signInFrame.setVisible(true);
        signInFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    signIn(String customerName,long customerID,long customerPhoneNo,long customerCredits,String customerAddress,String customerEmail,int customerSize,char customerGender,String customerPassword, String prevOrders)
    {
        super(customerName,customerID,customerPhoneNo,customerCredits,customerAddress,customerEmail,customerSize,customerGender,customerPassword,prevOrders);
    }
    @Override
    public void actionPerformed(ActionEvent a)
    {
        if(a.getSource()==signin)
        {
            customerName=name.getText();
            customerPhoneNo=Integer.parseInt(phoneNo.getText());
            customerEmail=email.getText();
            customerAddress=address.getText();
            customerCredits=0;
            customerID=0;
            customerSize=0;
            customerPassword=new String(password.getPassword());
            if(male.isSelected())
            {
                customerGender='M';
            }
            else if(female.isSelected())
            {
                customerGender='F';
            }
            lMSG.setText(" SIGN IN SUCCESSFUL!");
            //this.signIn(customerName,customerID,customerPhoneNo,customerCredits,customerAddress,customerEmail,customerSize,customerGender);
            System.out.println( customerName+" "+ customerEmail+" "+ customerGender+" "+ customerPhoneNo + " " + customerPassword);

            new logIn();
            signInFrame.dispose();
        }
        else if(a.getSource()==exitB)
        {
            System.exit(0);
            signInFrame.dispose();
        }
    }
}
