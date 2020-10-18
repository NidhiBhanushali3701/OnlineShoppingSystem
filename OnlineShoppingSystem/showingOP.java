package OnlineShoppingSystem;

import java.util.*;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;

class showingOP
{
    public static Scanner ob = new Scanner(System.in);
    public static void main(String args[])
	{
        Log_Sign show = new Log_Sign();
    }
}
class Log_Sign extends customer implements ActionListener {
    JButton loginB,signupB,exitB;
    JPanel panel;
    JFrame mainFrame;
    
    Log_Sign()
    {
        mainFrame = new JFrame();
        panel = new JPanel();
        mainFrame.add(panel);

        loginB = new JButton(" LOG-IN ");
        loginB.setBounds(300, 120, 120,48);
        signupB = new JButton(" SIGN-IN ");
        signupB.setBounds(300,201, 120,48);
        exitB =  new JButton(" EXIT ");
        exitB.setBounds(300, 282, 120,48);
        panel.add(loginB);
        panel.add(signupB);
        panel.add(exitB);

        loginB.addActionListener(this);
        signupB.addActionListener(this);
        exitB.addActionListener(this);

        panel.setLayout(null);
        mainFrame.setSize(693, 810);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent a)
    {
        if(a.getSource()==loginB)
        {
            new logIn();
            mainFrame.dispose();
        }
        else if(a.getSource()==signupB)
        {
            new signUp();
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
    JButton loginB,exitB,backB;
    JProgressBar loginProgress;
    Timer loginT;
    int i=0;
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
        loginB = new JButton(" LOG-IN ");
        exitB =  new JButton(" EXIT ");
        lMSG = new JLabel("");
        loginProgress = new JProgressBar(0,15);
        loginT= new Timer(250,this);
        backB = new JButton("<< BACK ");
        lEMail.setBounds(150, 12,120, 45);
        email.setBounds(300, 12,162, 45);
        lPassword.setBounds(150, 73, 120, 45);
        password.setBounds(300, 73,162, 45);
        loginB.setBounds(300,150, 120, 48);
        exitB.setBounds(450, 150, 120,48);
        backB.setBounds(150,150,  120, 48);
        lMSG.setBounds(225, 300, 300,48);
        loginProgress.setBounds(125, 402,450,21);
        panel.add(lEMail);
        panel.add(email);
        panel.add(lPassword);
        panel.add(password);
        panel.add(loginB);
        panel.add(exitB);
        panel.add(backB);
        panel.add(lMSG);
        loginB.addActionListener(this);
        exitB.addActionListener(this);
        backB.addActionListener(this);
        panel.setLayout(null);
        LogInFrame.setSize(693, 810);
        LogInFrame.setVisible(true);
        LogInFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent a)
    {
        if(a.getSource()==loginB)
        {   
            loginT.start();
            panel.add(loginProgress);
            lMSG.setText(" LOGIN STATUS");
            if(check(email.getText(),new String(password.getPassword())))
            {
                lMSG.setText(" LOGIN SUCCESSFUL");
                //customerDashBoard cBoard = new customerDashBoard(userEMail, userPassword);
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
        else if(a.getSource()==backB)
        {
            new Log_Sign();
            LogInFrame.dispose();
        }
        if(i==15)
        {
            if(check(email.getText(),new String(password.getPassword())))
            {
                lMSG.setText(" LOGIN SUCCESSFUL");
                //we open our product display
                customerDashBoard customer_ = new customerDashBoard(email.getText(), new String(password.getPassword()));
                
            }
            else
            {
                lMSG.setText(" INCORRECT EMAIL / PASSWORD ");
                //we tell to try again / sign up
            }
        }
        i++;
        loginProgress.setValue(i);
    }
    public boolean check(String checkEMail,String checkPassword)
    {
        boolean flag=false;
        //customerEmail="user";
        //customerPassword="12345678";
        if(checkPassword.length()>=8)
        {
            if(checkEMail.equals(customerEmail) && checkPassword.equals(customerPassword))
            {   
                flag =true;    
                //we open our product display
            }
        }
        return flag;
    }
}

class signUp extends customer implements ActionListener 
{
    private static final long serialVersionUID = 1L;
    JFrame signUpFrame;
    JPanel panel;
    JLabel lName,lPassword,lPhoneNo,lGender,lEMail,lAddress,lMSG;
    JPasswordField password;
    JTextField name,phoneNo,email,address;
    JRadioButton male,female;
    ButtonGroup gender;
    JButton signupB,exitB,backB;
    JProgressBar signupProgress;
    Timer signupT;
    int i=0;
    public signUp()
    {
        super();
        signUpFrame = new JFrame();
        panel=new JPanel();
        signUpFrame.add(panel);
        lName= new JLabel(" ENTER NAME ");
        lPassword= new JLabel(" ENTER PASSWORD");
        lPhoneNo= new JLabel(" ENTER PHONE NO");
        lGender= new JLabel(" SELECT GENDER ");
        lEMail= new JLabel(" ENTER EMAIL ");
        lAddress= new JLabel(" ENTER ADDRESS");
        lMSG = new JLabel("");
        signupProgress = new JProgressBar(0,25);
        signupT = new Timer(500, this);
        password = new JPasswordField(15);
        name = new JTextField(15);
        phoneNo = new JTextField(15);
        email = new JTextField(15);
        address  = new JTextField(21);
        male = new JRadioButton(" MALE ");
        female = new JRadioButton(" FEMALE ");
        gender = new ButtonGroup();
        signupB = new JButton(" SIGN-IN ");
        exitB =  new JButton(" EXIT ");
        backB = new JButton("<< BACK ");
        gender.add(female);
        gender.add(male);
        lName.setBounds( 150, 12,120, 45);
        name.setBounds(300, 12,162, 45);
        lEMail.setBounds( 150, 63,120, 45);
        email.setBounds(300, 63,162, 45);
        lPassword.setBounds( 150, 123,120, 45);
        password.setBounds(300,123,162, 45);
        lPhoneNo.setBounds( 150,184,120, 45);
        phoneNo.setBounds(300,184,162, 45);
        lGender.setBounds( 150,250,120, 45);
        male.setBounds(300,250,102, 45);
        female.setBounds(450,250,102, 45);
        lAddress.setBounds( 150,330,120, 45);
        address.setBounds(300,330,180, 69);
        signupB.setBounds(300,500,99,48);
        exitB.setBounds(450,500, 99,48);
        backB.setBounds(150,500, 99,48);
        lMSG.setBounds(225,603, 120, 48);
        signupProgress.setBounds( 150,700,450, 21);
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
        panel.add(signupB);
        panel.add(exitB);
        panel.add(backB);
        panel.add(lMSG);
        signupB.addActionListener(this);
        exitB.addActionListener(this);
        backB.addActionListener(this);
        panel.setLayout(null);
        signUpFrame.setSize(693, 810);
        signUpFrame.setVisible(true);
        signUpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    signUp(String customerName,long customerID,long customerPhoneNo,long customerCredits,String customerAddress,String customerEmail,int customerSize,char customerGender,String customerPassword, String prevOrders)
    {
        super(customerName,customerID,customerPhoneNo,customerCredits,customerAddress,customerEmail,customerSize,customerGender,customerPassword,prevOrders);
    }
    @Override
    public void actionPerformed(ActionEvent a)
    {
        if(a.getSource()==signupB)
        {
            signupT.start();
            panel.add(signupProgress);
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
            //this.signup(customerName,customerID,customerPhoneNo,customerCredits,customerAddress,customerEmail,customerSize,customerGender);
            System.out.println( customerName+" "+ customerEmail+" "+ customerGender+" "+ customerPhoneNo + " " + customerPassword);

        }
        else if(a.getSource()==exitB)
        {
            System.exit(0);
            signUpFrame.dispose();
        }
        else if(a.getSource()==backB)
        {
            new Log_Sign();
            signUpFrame.dispose();
        }
        if(i==15)
        {
            lMSG.setText(" SIGN IN SUCCESSFUL!");
            new logIn();
            signUpFrame.dispose();
        }
        i++;
        signupProgress.setValue(i);
    }
}