import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Registration extends JFrame implements ActionListener{
    JLabel lb1,lb2,lb3,lb4,lb5,lb6,lb7,lb8,lb9,lb10,lb11,lb12;
    JTextField title,name,phone,email,problem,objective,tool,scope,pass,area,year;
    JButton register,regbtn;
    private ImageIcon img;
    private JLabel imglb;
    JPanel p;
    Registration(){

//            p = new JPanel();
//            p.setSize(500,900);
//            p.setBackground(Color.CYAN);
//            add(p);
        img = new ImageIcon(this.getClass().getResource("/img.png"));
        imglb = new JLabel("",img,JLabel.CENTER);
        imglb.setBounds(0,0,1000,900);
//        imglb.setSize(300,1,200,200);
        add(imglb);
        lb1 = new JLabel("Registration");
        lb1.setFont(new Font("Time new roman",Font.BOLD,30));
        lb1.setBounds(600,10,200,40);
        add(lb1);
        JScrollPane scroll = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVisible(true);
        add(scroll);
        lb2 = new JLabel("Project title");
        lb2.setBounds(550,100,100,30);
        add(lb2);

        title = new JTextField(60);
        title.setBounds(700,100,180,30);
        add(title);

        lb3 = new JLabel("Developers name");
        lb3.setBounds(550,150,100,30);
        add(lb3);
        name = new JTextField(60);
        name.setBounds(700,150,180,30);
        add(name);

        lb4 = new JLabel("Phone numbers");
        lb4.setBounds(550,200,100,30);
        add(lb4);

        phone = new JTextField(60);
        phone.setBounds(700,200,180,30);
        add(phone);

        lb5 = new JLabel("Email");
        lb5.setBounds(550,250,100,30);
        add(lb5);
        email = new JTextField(60);
        email.setBounds(700,250,180,30);
        add(email);

        lb6 = new JLabel("Statement of the problem");
        lb6.setBounds(550,300,100,30);
        add(lb6);

        problem = new JTextField(60);
        problem.setBounds(700,300,180,30);
        add(problem);

        lb7 = new JLabel("Objective");
        lb7.setBounds(550,350,100,30);
        add(lb7);
        objective = new JTextField(60);
        objective.setBounds(700,350,180,30);
        add(objective);


        lb8 = new JLabel("development tools");
        lb8.setBounds(550,400,100,30);
        add(lb8);

        tool= new JTextField(60);
        tool.setBounds(700,400,180,30);
        add(tool);

        lb9 = new JLabel("scope");
        lb9.setBounds(550,450,100,30);
        add(lb9);
        scope = new JTextField(60);
        scope.setBounds(700,450,180,30);
        add(scope);


        lb10 = new JLabel("password");
        lb10.setBounds(550,500,100,30);
        add(lb10);
        pass = new JTextField(60);
        pass.setBounds(700,500,180,30);
        add(pass);


        lb11 = new JLabel("year");
        lb11.setBounds(550,550,100,30);
        add(lb11);

        year = new JTextField(60);
        year.setBounds(700,550,180,30);
        add(year);

        lb12 = new JLabel("ResearchArea");
        lb12.setBounds(550,600,100,30);
        add(lb12);
        area = new JTextField(60);
        area.setBounds(700,600,180,30);
        add(area);

//        lb2 = new JLabel("researchArea");
//        lb2.setBounds(100,450,100,30);
//        add(lb2);
//        passtf = new JTextField(60);
//        passtf.setBounds(200,450,180,30);
//        add(passtf);

        register = new JButton("Register");
        register.setBounds(750,650,200,30);
        add(register);

        setLayout(null);
        setSize(1000,900);
        setVisible(true);

        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String titlef = title.getText();
                String namef = name.getText();
                int phonef = Integer.parseInt(phone.getText());
                String emailf = email.getText();
                String problemf = problem.getText();
                String objectivef = objective.getText();
                String toolf = tool.getText();
                String scopef = scope.getText();
                String passf = pass.getText();
                int yearf = Integer.parseInt(year.getText());
                String areaf = area.getText();

                registration(titlef,namef,phonef,emailf,problemf,objectivef,toolf,scopef,passf,yearf,areaf);
            }
        });
    }

    private void registration(String titlef, String namef, int phonef, String emailf, String problemf, String objectivef, String toolf, String scopef, String passf, int yearf, String areaf) {
        String  url = "jdbc:mysql://localhost:3306/research";
        String username = "root";
        String password = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url,username,password);
            Statement stat = conn.createStatement();

            String sql = "INSERT INTO `researcher`(`Project title`, `Developers name`, `Phone numbers`, `Email`, `Statement of the problem`, `Objective`, `development tools`, `scope`, `password`, `year`, `researchArea`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement prepstat = conn.prepareStatement(sql);
            prepstat.setString(1,titlef);
            prepstat.setString(2,namef);
            prepstat.setString(3, String.valueOf(phonef));
            prepstat.setString(4,emailf);
            prepstat.setString(5,problemf);
            prepstat.setString(6,objectivef);
            prepstat.setString(7,toolf);
            prepstat.setString(8,scopef);
            prepstat.setString(9, passf);
            prepstat.setString(10, String.valueOf(yearf));
            prepstat.setString(11,areaf);
            prepstat.executeUpdate();

            //ResultSet resultSet = prepstat.executeQuery();

            System.out.println("Success");

                JOptionPane.showMessageDialog(null,"Successfully Registered");
                title.setText("");
                name.setText("");
                phone.setText("");
                email.setText("");
                problem.setText("");
                objective.setText("");
                tool.setText("");
                scope.setText("");
                pass.setText("");
                year.setText("");


            conn.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args){
        new Registration();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
