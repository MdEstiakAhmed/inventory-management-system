import java.util.*;	
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Register extends JFrame implements MouseListener, ActionListener
{
	JPanel pn;
	JButton signUP,signBack,generate;
	JLabel s1, userId, name, phn, balance, uname, upass, gender, address, backImgLbl,bandImgLbl;
	JTextField userIdTF, nameTF, phnTF, balanceTF, unameTF, upassTF;
	JTextArea addressTA;
	JRadioButton genderBtn1,genderBtn2,genderBtn3;
	ButtonGroup bg;
	ImageIcon backImg,bandImg;
	Color halkalal,ashColor;
	Font s1font,btnfont;
	private Random r;

	public Register()
	{
		this.setTitle("Amar Bazaar Registration Page");
		this.setSize(1366,740);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pn = new JPanel();
		pn.setLayout(null);
		
		halkalal = new Color(167,37,37);
		ashColor = new Color(128,128,128);
		s1font = new Font("Impact",Font.BOLD,30);
		btnfont = new Font("Impact",Font.PLAIN,15);

		bg=new ButtonGroup();
		
		s1 = new JLabel("Register for free");
		userId= new JLabel("id: ");
		name = new JLabel("Your Name: ");
		phn = new JLabel("Phone Number: ");
		balance = new JLabel("Balance: ");
		uname = new JLabel("User Name: ");
		upass = new JLabel("User Password: ");
		gender=new JLabel("gender: ");
		address=new JLabel("address: ");
		
		userIdTF= new JTextField();
		nameTF = new JTextField();
		phnTF = new JTextField();
		balanceTF = new JTextField("0.00");
		unameTF = new JTextField();
		upassTF = new JTextField();
		genderBtn1=new JRadioButton("male");
		genderBtn2=new JRadioButton("female");
		genderBtn3=new JRadioButton("other");

		addressTA=new JTextArea();
		addressTA.setLineWrap(true);
		addressTA.setWrapStyleWord(true);
		
		signUP = new JButton("Sign Up");
		signBack = new JButton("Already have an account");
		generate = new JButton("Generate");
		
		backImg = new ImageIcon("back_img.jpg");
		backImgLbl = new JLabel(backImg);
		bandImg = new ImageIcon("side_bar.png");
		bandImgLbl = new JLabel(bandImg);

		genderBtn1.setOpaque(false);
		genderBtn2.setOpaque(false);
		genderBtn3.setOpaque(false);
		
		s1.setBounds(480,100,300,30);
		userId.setBounds(480,180,100,30);
		userIdTF.setBounds(610,180,150,30);
		generate.setBounds(760,180,100,30);
		name.setBounds(480,220,100,30);
		nameTF.setBounds(610,220,150,30);
		phn.setBounds(480,260,100,30);
		phnTF.setBounds(610,260,150,30);
		balance.setBounds(480,300,150,30);
		balanceTF.setBounds(610,300,150,30);
		uname.setBounds(480,340,150,30);
		unameTF.setBounds(610,340,150,30);
		upass.setBounds(480,380,150,30);
		upassTF.setBounds(610,380,150,30);
		gender.setBounds(480,420,150,30);
		genderBtn1.setBounds(610,410,80,50);
		genderBtn2.setBounds(690,410,80,50);
		genderBtn3.setBounds(770,410,80,50);
		address.setBounds(480,460,150,30);
		addressTA.setBounds(610,460,150,80);
		signUP.setBounds(460,650,100,30);
		signBack.setBounds(560,650,300,30);
		backImgLbl.setBounds(0,0,1366,740);
		bandImgLbl.setBounds(420,10,470,700);
		
		s1.setForeground(halkalal);
		s1.setFont(s1font);
		
		signUP.setFont(btnfont);
		signBack.setFont(btnfont);
		generate.setFont(btnfont);
		
		signUP.addActionListener(this);
		signBack.addActionListener(this);
		generate.addActionListener(this);
		
		pn.add(s1);
		pn.add(userId);
		pn.add(userIdTF);
		pn.add(generate);
		pn.add(name);
		pn.add(phn);
		pn.add(balance);
		pn.add(uname);
		pn.add(upass);
		pn.add(nameTF);
		pn.add(phnTF);
		pn.add(balanceTF);
		pn.add(unameTF);
		pn.add(upassTF);
		pn.add(gender);
		pn.add(genderBtn1);
		pn.add(genderBtn2);
		pn.add(genderBtn3);
		pn.add(address);
		pn.add(addressTA);
		pn.add(signUP);
		pn.add(signBack);
		pn.add(bandImgLbl);
		pn.add(backImgLbl);

		bg.add(genderBtn1);
		bg.add(genderBtn2);
		bg.add(genderBtn3);
		
		this.add(pn);
		setIconImage(Toolkit.getDefaultToolkit().getImage("p_img.png"));
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String Text = ae.getActionCommand();
		
		if(Text.equals(signUP.getText()))
		{
			insertIntoDB();
		}
		else if(Text.equals(signBack.getText()))
		{
			LoginPG lp = new LoginPG();
			lp.setVisible(true);
			this.setVisible(false);
		}
		else if(Text.equals(generate.getText()))
		{
			r=new Random();
			int x=r.nextInt((9999-1000)+1)+1000;
			userIdTF.setText(Integer.toString(x));
		}

	}
	
	public void mousePressed(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}
	public void mouseClicked(MouseEvent me){}
	public void mouseEntered(MouseEvent me){}
	public void mouseExited(MouseEvent me){}
	
	public void insertIntoDB()
	{
		String userName = unameTF.getText();
		String name = nameTF.getText();
		String password = upassTF.getText();
		String address = addressTA.getText();
		String userID=null;
		String status = "Customer";
		double balance = 0.00;
		String gender=null;
		int phone=0;
		int id=0;
		if(genderBtn1.isSelected())
		{
			gender = genderBtn1.getText();
		}
		else if(genderBtn2.isSelected())
		{
			gender = genderBtn2.getText();
		}
		else if(genderBtn3.isSelected())
		{
			gender = genderBtn3.getText();
		}

		try
		{
			id=Integer.parseInt(userIdTF.getText());
			userID=Integer.toString(id);
			System.out.println(phnTF.getText().length());
			phone =Integer.parseInt(phnTF.getText());
			if(phone>=0)
			{
				if(phnTF.getText().length()==11)
				{
					char s=phnTF.getText().charAt(1);
					if(s=='1')
					{
						phone =Integer.parseInt(phnTF.getText());
					}
					else
					{
						throw new NumberFormatException("number format error");
					}
				}
				else
				{
					throw new NumberFormatException("number length error");
				}
			}
			else if(phone<0)
			{
				throw new NumberFormatException("Negative number not allow");
			}
			
			String query1 = "INSERT INTO user_accounts VALUES ('"+userID+"','"+userName+"','"+name+"','"+password+"',"+balance+",'"+gender+"',"+ phone+",'"+address+"','"+status+"');";
			String query2 = "INSERT INTO login VALUES ('"+userID+"','"+userName+"','"+password+"','"+status+"');";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/b25", "root", "");
			Statement stm = con.createStatement();
			stm.execute(query1);
			stm.execute(query2);
			stm.close();
			con.close();
			JOptionPane.showMessageDialog(this, "successfully login");
			HomePG hp=new HomePG(userID,userName,name,balance,gender,phone,address,status);
			hp.updateProduct.setVisible(false);
			hp.ordered.setVisible(false);
			hp.setVisible(true);
			this.setVisible(false);
		}
		catch(NumberFormatException ne)
		{
			JOptionPane.showMessageDialog(this, ne.getMessage()+" ");
			System.out.println(ne.getMessage());
		}
        catch(Exception ex)
		{
			JOptionPane.showMessageDialog(this, "correctly fillup the page");
			System.out.println(ex.getMessage());
        }
    }
}