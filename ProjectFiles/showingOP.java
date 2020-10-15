import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class showingOP
{
    public static void main(String args[])
	{
        details show = new details();
    }
}
class details extends customer{
    JButton login,signin;
    JPanel panel;
    JFrame mainFrame;
    details()
    {
        mainFrame = new JFrame();
        panel = new JPanel();
        mainFrame.add(panel);

        login = new JButton(" LOG-IN ");
        login.setBounds(150, 120, 120,48);
        signin = new JButton(" SIGN-IN ");
        signin.setBounds(330,120, 120,48);
        panel.add(login);
        panel.add(signin);

        login.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent a)
            {
            new logIn();
            mainFrame.dispose();
            }
        });

        signin.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent a)
            {
            new signIn();
            mainFrame.dispose();
            }
        });


        panel.setLayout(null);
        mainFrame.setSize(693, 810);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
class logIn extends customer implements ActionListener 
{
    JFrame LogInFrame;
    JPanel panel;
    JLabel lPassword,lEMail,lMSG;
    JPasswordField password;
    JTextField email;
    JButton login;
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
        lMSG = new JLabel("");

        lEMail.setBounds(150, 12,120, 45);
        email.setBounds(300, 12,120, 45);
        lPassword.setBounds(150, 73, 120, 45);
        password.setBounds(300, 73,120, 45);
        login.setBounds(225,150,120, 45);
        lMSG.setBounds(225, 220, 210,48);

        panel.add(lEMail);
        panel.add(email);
        panel.add(lPassword);
        panel.add(password);
        panel.add(login);
        panel.add(lMSG);

        login.addActionListener(this);

        panel.setLayout(null);
        LogInFrame.setSize(693, 810);
        LogInFrame.setVisible(true);
        LogInFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent a)
    {
        System.out.println( customerName+" "+ customerEmail+" "+ customerGender+" "+ customerPhoneNo + " " + customerPassword);

        if(((email.getText()).equals(customerEmail)) && ((new String(password.getPassword()).equals(customerPassword))))
        {
            lMSG.setText(" LOGIN SUCCESSFUL");
            //we open our product display
        }
        else{
            lMSG.setText(" INCORRECT EMAIL / PASSWORD ");
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
    JButton signin;
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
        gender.add(female);
        gender.add(male);
        int y=39;
        lName.setBounds( 150, 51-y,120, 45);
        name.setBounds(300, 51-y,120, 45);
        lEMail.setBounds( 150, 112-y,120, 45);
        email.setBounds(300, 112-y,120, 45);
        lPassword.setBounds( 150, 233-y,120, 45);
        password.setBounds(300, 233-y,120, 45);
        lPhoneNo.setBounds( 150, 355-y,120, 45);
        phoneNo.setBounds(300, 355-y,120, 45);
        lGender.setBounds( 150, 477-y,120, 45);
        male.setBounds(300, 477-y,120, 45);
        female.setBounds(531, 477-y,120, 45);
        lAddress.setBounds( 150, 599-y,120, 45);
        address.setBounds(300, 599-y,120, 51);
        signin.setBounds(339, 721-y, 111,48);
        lMSG.setBounds(339, 800, 120, 48);
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
        panel.add(lMSG);
        signin.addActionListener(this);
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
}