import java.sql.*;	
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class HomePG extends JFrame implements ActionListener, MouseListener
{
	public String loginUser;
	JPanel pn;
	JButton ordered, logout, beverage, vegitable,chaldal,fish,oil,medicine,updateProduct, updateAccounts;
	JLabel s1, s2, uRole, uname, uID, name, phone, balance, genderLB,addressL, backImgLbl,bandImgLbl,breadImgLbl,vegImgLbl,chaldalImgLbl,fishImgLbl,oilImgLbl,mediImgLbl;
	ImageIcon imgp1,imgp2,imgp3,backImg,bandImg,breadImg,vegImg,chaldalImg,fishImg,oilImg,mediImg;
	Color halkalal,ashColor;
	Font s1font,btnfont;
	public String userID,userName,_name,gender,address,status;
	public int _phone;
	public double _balance;
	public int pID,pQuantity;
	public String pName,pCategory;
	public double pPrice;

	public HomePG(String userID,String userName,String _name,double _balance,String gender,int _phone,String address,String status)
	{
		this.userID=userID;
		this.userName=userName;
		this._name=_name;
		this.gender=gender;
		this._phone=_phone;
		this.address=address;
		this.status=status;
		this._balance=_balance;

		loginUser=userName;

		this.setTitle("Amar Bazaar Home Page");
		this.setSize(1366,740);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pn = new JPanel();
		pn.setLayout(null);
		
		halkalal = new Color(167,37,37);
		ashColor = new Color(128,128,128);
		s1font = new Font("Impact",Font.BOLD,30);
		btnfont = new Font("Impact",Font.PLAIN,15);
		
		s1 = new JLabel("Welcome");
		uRole = new JLabel("User Type : "+status);
		uname = new JLabel("your username is : "+userName);
		uID = new JLabel("Identity Number : "+userID);
		name  = new JLabel("Name : "+_name);
		balance = new JLabel("Current Balance : "+_balance);
		genderLB = new JLabel("Gender : "+gender);
		phone = new JLabel("Contact No : "+"0"+_phone);
		addressL = new JLabel("Address : "+address);
		
		logout = new JButton("Logout");
		beverage = new JButton("Bread and Brevarage");
		vegitable = new JButton("vegetable");
		chaldal = new JButton("groceries");
		fish = new JButton("fish");
		oil = new JButton("oil");
		medicine = new JButton("medicine");
		updateProduct = new JButton("Update Product");
		updateAccounts = new JButton("Update Accounts Information");
		ordered = new JButton("Ordered Products");
		
		backImg = new ImageIcon("back_img.jpg");
		backImgLbl = new JLabel(backImg);
		bandImg = new ImageIcon("side_bar.png");
		bandImgLbl = new JLabel(bandImg);
		breadImg = new ImageIcon("bread_img.png");
		breadImgLbl = new JLabel(breadImg);
		vegImg = new ImageIcon("veg_img.jpg");
		vegImgLbl = new JLabel(vegImg);
		chaldalImg = new ImageIcon("chaldal_img.png");
		chaldalImgLbl = new JLabel(chaldalImg);
		fishImg = new ImageIcon("fish_img.jpg");
		fishImgLbl = new JLabel(fishImg);
		oilImg = new ImageIcon("oil_img.jpg");
		oilImgLbl = new JLabel(oilImg);
		mediImg = new ImageIcon("medi_img.jpg");
		mediImgLbl = new JLabel(mediImg);
		
		s1.setBounds(985,150,200,30);
		uRole.setBounds(985,200,300,30);
		uname.setBounds(985,240,300,30);
		uID.setBounds(985,280,300,30);
		name.setBounds(985,320,300,30);
		balance.setBounds(985,360,300,30);
		genderLB.setBounds(985,400,300,30);
		phone.setBounds(985,440,300,30);
		addressL.setBounds(985,450,300,80);
		ordered.setBounds(1060,560,200,30);
		logout.setBounds(950,600,100,30);
		beverage.setBounds(300,300,200,30);
		vegitable.setBounds(550,300,200,30);
		chaldal.setBounds(300,470,200,30);
		fish.setBounds(550,470,200,30);
		oil.setBounds(300,640,200,30);
		medicine.setBounds(550,640,200,30);
		backImgLbl.setBounds(0,0,1366,740);
		bandImgLbl.setBounds(850,0,500,700);
		breadImgLbl.setBounds(300,130,200,200);
		vegImgLbl.setBounds(550,130,200,200);
		chaldalImgLbl.setBounds(300,300,200,200);
		fishImgLbl.setBounds(550,300,200,200);
		oilImgLbl.setBounds(300,500,200,200);
		mediImgLbl.setBounds(550,500,200,200);
		updateProduct.setBounds(1060,600,200,30);
		updateAccounts.setBounds(950,640,310,30);
		
		s1.setForeground(halkalal);
		s1.setFont(s1font);

		updateProduct.setFont(btnfont);
		updateAccounts.setFont(btnfont);
		logout.setFont(btnfont);
		ordered.setFont(btnfont);

		updateProduct.addActionListener(this);
		updateAccounts.addActionListener(this);
		logout.addActionListener(this);
		beverage.addActionListener(this);
		vegitable.addActionListener(this);
		chaldal.addActionListener(this);
		fish.addActionListener(this);
		oil.addActionListener(this);
		medicine.addActionListener(this);
		ordered.addActionListener(this);
		
		
		pn.add(s1);
		pn.add(uname);
		pn.add(uID);
		pn.add(name);
		pn.add(phone);
		pn.add(uRole);
		pn.add(balance);
		pn.add(genderLB);
		pn.add(addressL);
		pn.add(logout);
		pn.add(updateProduct);
		pn.add(updateAccounts);
		pn.add(ordered);
		pn.add(beverage);
		pn.add(vegitable);
		pn.add(chaldal);
		pn.add(fish);
		pn.add(oil);
		pn.add(medicine);
		pn.add(breadImgLbl);
		pn.add(vegImgLbl);
		pn.add(chaldalImgLbl);
		pn.add(fishImgLbl);
		pn.add(oilImgLbl);
		pn.add(mediImgLbl);
		pn.add(bandImgLbl);
		pn.add(backImgLbl);
		
		this.add(pn);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("p_img.png")));
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String Text = ae.getActionCommand();
		
		if(Text.equals(logout.getText()))
		{
			LoginPG lp = new LoginPG();
			lp.setVisible(true);
			this.setVisible(false);
		}
		else if(Text.equals(ordered.getText()))
		{
			Order op = new Order(userID,userName,_name,_balance,gender,_phone,address,status);
			op.setVisible(true);
			this.setVisible(false);
		}
		else if(Text.equals(beverage.getText()))
		{
			productVerify(ae);
			
		}
		else if(Text.equals(vegitable.getText()))
		{
			productVerify(ae);
		}
		else if(Text.equals(chaldal.getText()))
		{
			productVerify(ae);
		}
		else if(Text.equals(fish.getText()))
		{
			productVerify(ae);
		}
		else if(Text.equals(oil.getText()))
		{
			productVerify(ae);
		}
		else if(Text.equals(medicine.getText()))
		{
			productVerify(ae);
		}
		else if(Text.equals(updateProduct.getText()))
		{
			UpdateInventory ui = new UpdateInventory(userID,userName,_name,_balance,gender,_phone,address,status,pID,pQuantity,pName,pCategory,pPrice);
			ui.setVisible(true);
			this.setVisible(false);
		}
		else if(Text.equals(updateAccounts.getText()))
		{
			UpdateAccounts ua = new UpdateAccounts(userID,userName,_name,_balance,gender,_phone,address,status);
			ua.setVisible(true);
			this.setVisible(false);
		}
		
	}
	public void mousePressed(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}
	public void mouseClicked(MouseEvent me){}
	public void mouseEntered(MouseEvent me){}
	public void mouseExited(MouseEvent me){}

	public void productVerify(ActionEvent ae)
	{
		String query="SELECT `pID`, `pName`, `pQuantity`, `pPrice`, `pCategory` FROM `product_details`;";
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

				flag = true;
				pID = rs.getInt("pID");
				pName = rs.getString("pName");
				pQuantity = rs.getInt("pQuantity");
				pPrice=rs.getDouble("pPrice");
				pCategory=rs.getString("pCategory");
				
				String s=ae.getActionCommand();
				if(s.equals("Bread and Brevarage"))
				{
					Product p = new Product(pID,pQuantity,pName,pCategory,pPrice,userID,userName,_name,_balance,gender,_phone,address,status);
					p.setVisible(true);
					this.setVisible(false);
					break;
				}
				else if(s.equals(pCategory))
				{
					Product p = new Product(pID,pQuantity,pName,pCategory,pPrice,userID,userName,_name,_balance,gender,_phone,address,status);
					p.setVisible(true);
					this.setVisible(false);
					break;
				}
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