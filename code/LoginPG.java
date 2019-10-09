import java.lang.*;
import java.sql.*;	
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class LoginPG extends JFrame implements MouseListener, ActionListener
{
	private JPanel pn;
	private JButton login,register,eye;
	private JLabel s1, uname, upass, backImgLbl,bandImgLbl;
	private JTextField userNameTF;
	private JPasswordField userPS;
	private ImageIcon imgp1,imgp2,imgp3,backImg,bandImg;
	private Color halkalal,ashColor;
	private Font s1font,btnfont,f1;

	public LoginPG()
	{
		this.setTitle("Amar Bazaar Login Page");
		this.setSize(1366,740);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pn = new JPanel();
		pn.setLayout(null);
		
		halkalal = new Color(167,37,37);
		ashColor = new Color(128,128,128);
		s1font = new Font("Impact",Font.BOLD,30);
		btnfont = new Font("Impact",Font.PLAIN,15);
		f1=new Font("Arial",Font.PLAIN,15);
		
		s1 = new JLabel("Sign in here ");
		uname = new JLabel("User Name : ");
		upass = new JLabel("Password  : ");
		
		userNameTF = new JTextField();
		userPS = new JPasswordField();
		userPS.setEchoChar('*');
		
		login = new JButton("Login");
		register = new JButton("Register");
		eye = new JButton("!");
		
		backImg = new ImageIcon("back_img.jpg");
		backImgLbl = new JLabel(backImg);
		bandImg = new ImageIcon("side_bar.png");
		bandImgLbl = new JLabel(bandImg);
		
		s1.setBounds(595,240,200,30);
		uname.setBounds(535,290,100,30);
		userNameTF.setBounds(615,290,180,30);
		upass.setBounds(535,330,100,30);
		userPS.setBounds(615,330,140,30);
		eye.setBounds(755,330,40,30);
		login.setBounds(565,390,100,30);
		register.setBounds(695,390,100,30);
		backImgLbl.setBounds(0,0,1366,740);
		bandImgLbl.setBounds(450,10,450,700);
		
		s1.setForeground(halkalal);
		s1.setFont(s1font);
		userPS.setFont(f1);
		
		login.setFont(btnfont);
		register.setFont(btnfont);
		
		login.addActionListener(this);
		register.addActionListener(this);
		eye.addMouseListener(this);
		
		pn.add(s1);
		pn.add(uname);
		pn.add(upass);
		pn.add(userNameTF);
		pn.add(userPS);
		pn.add(login);
		pn.add(register);
		pn.add(eye);
		pn.add(bandImgLbl);
		pn.add(backImgLbl);
		
		this.add(pn);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("p_img.png")));
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String Text = ae.getActionCommand();
		
		if(Text.equals(login.getText()))
		{
			loginVerify();
		}
		if(Text.equals(register.getText()))
		{
			Register rg = new Register();
			rg.setVisible(true);
			this.setVisible(false);
		}
	}
	
	public void mousePressed(MouseEvent me)
	{
		if(me.getSource() == eye)
		{
			userPS.setEchoChar((char)0);
		}
	}
	public void mouseReleased(MouseEvent me)
	{
		userPS.setEchoChar('*');
	}
	public void mouseClicked(MouseEvent me){}
	public void mouseEntered(MouseEvent me){}
	public void mouseExited(MouseEvent me){}
	public void loginVerify()
	{ 
		String query="SELECT `userID`, `userName`, `name`, `password`, `balance`, `gender`, `phone`, `address`, `status` FROM `user_accounts`;";
        Connection con=null;
        Statement st = null;
		ResultSet rs = null;
        try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/b25","root","");
			st = con.createStatement();
			rs = st.executeQuery(query);
			
			boolean flag = false;		
			while(rs.next())
			{
                String userName = rs.getString("userName");
				String password = rs.getString("password");
				String status = rs.getString("status");

				String userID=rs.getString("userID");
				String name=rs.getString("name");
				double balance=rs.getDouble("balance");
				String gender=rs.getString("gender");
				int phone=rs.getInt("phone");
				String address=rs.getString("address");
				
				if(userName.equals(userNameTF.getText()) && password.equals(userPS.getText()))
				{
					flag=true;
					if(status.equals("Seller"))
					{
						JOptionPane.showMessageDialog(this,"Login Successfull");
						HomePG pg = new HomePG(userID,userName,name,balance,gender,phone,address,status);
						pg.setVisible(true);
						this.setVisible(false);
						break;
					}
					else if(status.equals("Customer"))
					{
						JOptionPane.showMessageDialog(this,"Login Successfull");
						HomePG pg = new HomePG(userID,userName,name,balance,gender,phone,address,status);
						pg.updateProduct.setVisible(false);
						pg.ordered.setVisible(false);
						pg.setVisible(true);
						this.setVisible(false);
						break;
					}
					else if(status.equals("Admin"))
					{
						JOptionPane.showMessageDialog(this,"Login Successfull");
						HomePG pg = new HomePG(userID,userName,name,balance,gender,phone,address,status);
						pg.setVisible(true);
						this.setVisible(false);
						break;
					}
				}
			}
			if(!flag)
			{
				JOptionPane.showMessageDialog(this,"Invalid Credential");
			}
		}
        catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
        }
        finally
		{
            try
			{
                if(rs!=null)
                {
					rs.close();
                }
                if(st!=null)
                {
					st.close();
                }
                if(con!=null)
                {
					con.close();
                }
            }
            catch(Exception ex){}
        }
	}
}