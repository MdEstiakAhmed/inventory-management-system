import java.lang.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;	

class EmployeeRegistration extends JFrame implements MouseListener, ActionListener
{
	JPanel pn;
	JButton signUP,goBack,generate,logout;
	JLabel s1, userIdLbl, nameLbl, phnLbl, balanceLbl, unameLbl, upassLbl, genderLbl, addressLbl ,statusLbl ,backImgLbl,bandImgLbl;
	JTextField userIdTF, nameTF, phnTF, balanceTF, unameTF, upassTF;
	JComboBox box;
	JTextArea addressTA;
	JRadioButton genderBtn1,genderBtn2;
	ButtonGroup bg;
	ImageIcon backImg,bandImg;
	Color halkalal,ashColor;
	Font s1font,btnfont;
	public String userID,userName,_name,gender,address,status;
	public int _phone;
	public double _balance;	
	private Random r;
	
	public EmployeeRegistration(String userID,String userName,String _name,double _balance,String gender,int _phone,String address,String status)
	{
		this.userID=userID;
		this.userName=userName;
		this._name=_name;
		this.gender=gender;
		this._phone=_phone;
		this.address=address;
		this.status=status;
		this._balance=_balance;
		
		this.setTitle("Employee Registration Page");
		this.setSize(1366,740);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pn = new JPanel();
		pn.setLayout(null);
		
		halkalal = new Color(167,37,37);
		ashColor = new Color(128,128,128);
		s1font = new Font("Impact",Font.BOLD,30);
		btnfont = new Font("Impact",Font.PLAIN,15);

		bg=new ButtonGroup();
		
		s1 = new JLabel("Register Employee");
		userIdLbl= new JLabel("id: ");
		nameLbl = new JLabel("Your Name: ");
		phnLbl = new JLabel("Phone Number: ");
		balanceLbl = new JLabel("Balance: ");
		unameLbl = new JLabel("User Name: ");
		upassLbl = new JLabel("User Password: ");
		genderLbl=new JLabel("gender: ");
		statusLbl=new JLabel("Status: ");
		addressLbl=new JLabel("address: ");
		
		userIdTF= new JTextField();
		nameTF = new JTextField();
		phnTF = new JTextField();
		balanceTF = new JTextField("0.00");
		unameTF = new JTextField();
		upassTF = new JTextField();
		genderBtn1=new JRadioButton("male");
		genderBtn2=new JRadioButton("female");

		addressTA=new JTextArea();
		addressTA.setLineWrap(true);
		addressTA.setWrapStyleWord(true);
		
		String s[] = {"Admin","Seller"};
		box = new  JComboBox(s);
		
		signUP = new JButton("Register Employee");
		goBack = new JButton("Back");
		generate = new JButton("Generate");
		logout = new JButton("Logout");
		
		backImg = new ImageIcon("back_img.jpg");
		backImgLbl = new JLabel(backImg);
		bandImg = new ImageIcon("side_bar.png");
		bandImgLbl = new JLabel(bandImg);

		genderBtn1.setOpaque(false);
		genderBtn2.setOpaque(false);
		
		s1.setBounds(480,100,300,30);
		userIdLbl.setBounds(480,180,100,30);
		userIdTF.setBounds(610,180,150,30);
		generate.setBounds(760,180,100,30);
		nameLbl.setBounds(480,220,100,30);
		nameTF.setBounds(610,220,150,30);
		phnLbl.setBounds(480,260,100,30);
		phnTF.setBounds(610,260,150,30);
		balanceLbl.setBounds(480,300,150,30);
		balanceTF.setBounds(610,300,150,30);
		unameLbl.setBounds(480,340,150,30);
		unameTF.setBounds(610,340,150,30);
		upassLbl.setBounds(480,380,150,30);
		upassTF.setBounds(610,380,150,30);
		genderLbl.setBounds(480,420,150,30);
		genderBtn1.setBounds(610,410,80,50);
		genderBtn2.setBounds(690,410,80,50);
		statusLbl.setBounds(480,460,150,30);
		box.setBounds(610,460,150,30);
		addressLbl.setBounds(480,500,150,30);
		addressTA.setBounds(610,500,150,80);
		signUP.setBounds(460,600,200,30);
		goBack.setBounds(670,600,180,30);
		logout.setBounds(670,650,180,30);
		backImgLbl.setBounds(0,0,1366,740);
		bandImgLbl.setBounds(420,10,470,700);
		
		s1.setForeground(halkalal);
		s1.setFont(s1font);
		
		signUP.setFont(btnfont);
		goBack.setFont(btnfont);
		generate.setFont(btnfont);
		logout.setFont(btnfont);
		
		signUP.addActionListener(this);
		goBack.addActionListener(this);
		generate.addActionListener(this);
		logout.addActionListener(this);
		
		pn.add(s1);
		pn.add(userIdLbl);
		pn.add(userIdTF);
		pn.add(generate);
		pn.add(nameLbl);
		pn.add(phnLbl);
		pn.add(balanceLbl);
		pn.add(unameLbl);
		pn.add(upassLbl);
		pn.add(nameTF);
		pn.add(phnTF);
		pn.add(balanceTF);
		pn.add(unameTF);
		pn.add(upassTF);
		pn.add(genderLbl);
		pn.add(genderBtn1);
		pn.add(genderBtn2);
		pn.add(statusLbl);
		pn.add(box);
		pn.add(addressLbl);
		pn.add(addressTA);
		pn.add(signUP);
		pn.add(goBack);
		pn.add(logout);
		pn.add(bandImgLbl);
		pn.add(backImgLbl);

		bg.add(genderBtn1);
		bg.add(genderBtn2);
		
		this.add(pn);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("p_img.png")));
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String Text = ae.getActionCommand();
		
		if(Text.equals(signUP.getText()))
		{
			insertIntoDB();
		}
		else if(Text.equals(goBack.getText()))
		{
			UpdateAccounts lp = new UpdateAccounts(userID,userName,_name,_balance,gender,_phone,address,status);
			lp.setVisible(true);
			this.setVisible(false);
		}
		else if(Text.equals(generate.getText()))
		{
			r=new Random();
			int x=r.nextInt((9999-1000)+1)+1000;
			userIdTF.setText(Integer.toString(x));
		}
		else if(Text.equals(logout.getText()))
		{
			LoginPG lp = new LoginPG();
			lp.setVisible(true);
			this.setVisible(false);
		}
	}
	
	public void mousePressed(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}
	public void mouseClicked(MouseEvent me){}
	public void mouseEntered(MouseEvent me){}
	public void mouseExited(MouseEvent me){}

	public void insertIntoDB()
	{
		String userID_ = userIdTF.getText();
		String userName_ = unameTF.getText();
		String name_ = nameTF.getText();
		String password_ = upassTF.getText();
		double balance_ = 0.00;
		String gender_=null;
		
		if(genderBtn1.isSelected())
		{
			gender_ = genderBtn1.getText();
		}
		else if(genderBtn2.isSelected())
		{
			gender_ = genderBtn2.getText();
		}

		int phone_ = 0;
		String status_ = box.getSelectedItem().toString();
		String address_ = addressTA.getText();
		
		try
		{
			phone_ =Integer.parseInt(phnTF.getText());
			if(phone_>=0)
			{
				if(phnTF.getText().length()==11)
				{
					char s=phnTF.getText().charAt(1);
					if(s=='1')
					{
						phone_ =Integer.parseInt(phnTF.getText());
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
			else if(phone_<0)
			{
				throw new NumberFormatException("Negative number not allow");
			}


			String query1 = "INSERT INTO user_accounts VALUES ('"+userID_+"','"+userName_+"','"+name_+"','"+password_+"',"+balance_+",'"+gender_+"',"+ phone_+",'"+address_+"','"+status_+"');";
        	String query2 = "INSERT INTO login VALUES ('"+userID_+"','"+userName_+"','"+password_+"','"+status_+"');";

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/b25", "root", "");
			Statement stm = con.createStatement();
			stm.execute(query1);
			stm.execute(query2);
			stm.close();
			con.close();
			JOptionPane.showMessageDialog(this, status+" succcesfully added.");
			UpdateAccounts ua =new UpdateAccounts(userID,userName,_name,_balance,gender,_phone,address,status);
			ua.setVisible(true);
			this.setVisible(false);
		}
		catch(NumberFormatException ne)
		{
			JOptionPane.showMessageDialog(this, ne.getMessage()+" ");
			System.out.println(ne.getMessage());
		}
        catch(Exception ex)
		{
			JOptionPane.showMessageDialog(this, "Account Can't Be Created");
			System.out.println(ex.getMessage());
	    }
    }
}