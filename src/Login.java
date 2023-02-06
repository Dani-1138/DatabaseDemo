import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import static java.awt.Component.CENTER_ALIGNMENT;

public class Login extends JFrame implements ActionListener{
    JLabel lb1,lb2,lb3,lb4;
    JTextField nametf,passtf;
    JButton logbtn,regbtn;
    private ImageIcon img;
    private JLabel imglb;
    JPanel p;
    Login(){



        img = new ImageIcon(this.getClass().getResource("/login1.jpg"));
        Image im = img.getImage();
        Image i = im.getScaledInstance(330,500,Image.SCALE_SMOOTH);
        img = new ImageIcon(i);
        imglb = new JLabel("",img,JLabel.LEADING);

        imglb.setBounds(0,0,500,500);
//        imglb.setSize(300,1,200,200);
        add(imglb);

            lb1 = new JLabel("Login Page");
            lb1.setBounds(200,10,200,10);
            add(lb1);

        lb2 = new JLabel("Email or phone");
        lb2.setBounds(350,100,100,30);
        add(lb2);
            nametf = new JTextField(60);
            nametf.setBounds(450,100,180,30);
            //nametf.setBorder(new EmptyBorder(20,3,10,3));
            nametf.setSelectionColor(new Color(76,204,255));

            add(nametf);


        lb2 = new JLabel("Password");
        lb2.setBounds(350,150,100,30);
        add(lb2);
        passtf = new JTextField(60);
        passtf.setBounds(450,150,180,30);
        add(passtf);


            logbtn = new JButton("Login");
            logbtn.setBounds(400,250,200,30);
            add(logbtn);

            logbtn.addActionListener(this);
        regbtn = new JButton("Create New Account");
        regbtn.setBounds(400,300,200,30);
        add(regbtn);
        lb4 = new JLabel();
        add(lb4);

        setVisible(true);
        setSize(700,500);
        setLayout(null);
        setTitle("Login");
        
        logbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = nametf.getText();
                String pass = passtf.getText();
                
                boolean status = authentication(email,pass);
                if(status){
                    JOptionPane.showMessageDialog(null,"Successfully login");
                    dispose();
                    MenuBarEx mb = new MenuBarEx();
                    mb.show();

                }
                else {
                    JOptionPane.showMessageDialog(null,"Failed");
                }
            }


        });
        regbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();

            }
        });
    }
    private boolean authentication(String email, String pass) {
        String  url = "jdbc:mysql://localhost:3306/research";
        String username = "root";
        String password = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url,username,password);
            Statement stat = conn.createStatement();
            //String sql = "INSERT INTO Student VALUES('4','selam',32,'2222')";
            //String sql = "INSERT INTO `researcher`(`Project title`, `Developers name`, `Phone numbers`, `Email`, `Statement of the problem`, `Objective`, `development tools`, `scope`, `password`, `year`, `researchArea`) VALUES ('Grading-System','Daniel Demeke',0963690361,'danieldemeke92@gmail.com','Student grading difficulty','to effective grading system','java','university based','dani1138',2015,'Software')";
            // String sql = new "INSERT INTO `researcher` (`Project title`, `Developers name`, `Phone numbers`, `Email`, `Statement of the problem`, `Objective`, `development tools`, `scope`, `password`, `year`, `researchArea`) VALUES ('chat-bot', 'Tekletsadik', '0984636272', 'tekle@gmail.com', 'Communication problem', 'To improve online chat communication', 'React', 'world based', '1122', '2012', 'Computer science')";
            //String sql = "DELETE FROM `researcher` WHERE year=2015";
            //String sql = "UPDATE `student` SET `id`='717',`name`='Daniel',`age`='33',`password`='3332' WHERE id=1";
            String sql = "SELECT * FROM researcher WHERE email=? AND password=?";
            //stat.executeUpdate(sql);
            PreparedStatement prepstat = conn.prepareStatement(sql);
            prepstat.setString(1,email);
            prepstat.setString(2,pass);
            ResultSet resultSet = prepstat.executeQuery();
            //ResultSet resultSet = stat.executeQuery(sql);



            if (resultSet.next()){
                            return true;
            }
            conn.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return false;
    }
    public  static void main(String[] args){
        new Login();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
