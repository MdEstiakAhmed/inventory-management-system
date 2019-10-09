import java.lang.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateInventory extends JFrame implements ActionListener, MouseListener
{
	public String loginUser;
	JPanel pn;
	JButton load, update, delete, logout, back, refresh,addProduct;
	JLabel idLbl, nameLbl, quantityLbl, priceLbl, catagoryLbl, pvwLbl, backImgLbl ,bandImgLbl;
	JTextField idTF, nameTF, quantityTF, priceTF, catagoryTF;
	JComboBox catagoryCB;
	ImageIcon backImg,bandImg;
	Color halkalal,ashColor;
	Font s1font,btnfont;
	JTable table;
	JScrollPane scroll;
	int pID,pQuantity;
	String pName,pCategory;
	double pPrice;
	private String[] catagoryName={"","beverage","vegetable","groceries","fish","oil","medicine"};
	public String userID,userName,_name,gender,address,status;
	public int _phone;
	public double _balance;
	
	public UpdateInventory(String userID,String userName,String _name,double _balance,String gender,int _phone,String address,String status,int pID,int pQuantity,String pName,String pCategory,double pPrice)
	{
		loginUser=userName;

		this.userID=userID;
		this.userName=userName;
		this._name=_name;
		this.gender=gender;
		this._phone=_phone;
		this.address=address;
		this.status=status;
		this._balance=_balance;

		this.pID=pID;
		this.pQuantity=pQuantity;
		this.pName=pName;
		this.pCategory=pCategory;
		this.pPrice=pPrice;

		this.setTitle("Products Information Change Page");
		this.setSize(1366,740);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pn = new JPanel();
		pn.setLayout(null);
		
		halkalal = new Color(167,37,37);
		ashColor = new Color(128,128,128);
		s1font = new Font("Impact",Font.BOLD,30);
		btnfont = new Font("Impact",Font.PLAIN,15);

		setTable();
		
		idLbl = new JLabel("Product ID :");
		nameLbl = new JLabel("Product Name :");
		quantityLbl = new JLabel("Product Quantity :");
		priceLbl = new JLabel("Product Price :");
		catagoryLbl = new JLabel("Product Catagory :");
		pvwLbl = new JLabel("Product Information");
		
		idTF = new JTextField();
		nameTF = new JTextField();
		quantityTF = new JTextField();
		priceTF = new JTextField();

		catagoryCB=new JComboBox(catagoryName);
		catagoryCB.setEditable(true);
		
		load = new JButton("Load Product Information");
		refresh=new JButton("refresh");
		delete = new JButton("Delete");
		update = new JButton("Update Information");
		addProduct=new JButton("Add Product");
		logout = new JButton("Logout");
		back = new JButton("Back");

		
		backImg = new ImageIcon("back_img.jpg");
		backImgLbl = new JLabel(backImg);
		bandImg = new ImageIcon("side_bar.png");
		bandImgLbl = new JLabel(bandImg);
		
		idLbl.setBounds(950,100,200,30);
		nameLbl.setBounds(925,250,200,30);
		quantityLbl.setBounds(925,300,200,30);
		priceLbl.setBounds(925,350,200,30);
		catagoryLbl.setBounds(925,400,200,30);
		pvwLbl.setBounds(350,100,300,30);
		idTF.setBounds(1050,95,200,30);
		nameTF.setBounds(1075,250,200,30);
		quantityTF.setBounds(1075,300,200,30);
		priceTF.setBounds(1075,350,200,30);
		catagoryCB.setBounds(1075,400,200,30);	
		load.setBounds(975,150,225,30);
		refresh.setBounds(975,190,225,30);
		delete.setBounds(1075,480,200,30);
		update.setBounds(1075,520,200,30);
		addProduct.setBounds(1075,560,200,30);
		logout.setBounds(1150,600,125,30);
		back.setBounds(1075,600,70,30);
		backImgLbl.setBounds(0,0,1366,740);
		bandImgLbl.setBounds(850,0,500,700);
		
		
		pvwLbl.setForeground(halkalal);
		pvwLbl.setFont(s1font);
		
		load.setFont(btnfont);
		refresh.setFont(btnfont);
		delete.setFont(btnfont);
		update.setFont(btnfont);
		addProduct.setFont(btnfont);
		logout.setFont(btnfont);
		back.setFont(btnfont);
		
		load.addActionListener(this);
		refresh.addActionListener(this);
		delete.addActionListener(this);
		update.addActionListener(this);
		addProduct.addActionListener(this);
		logout.addActionListener(this);
		back.addActionListener(this);
		
		pn.add(idLbl);
		pn.add(idTF);
		pn.add(nameLbl);
		pn.add(nameTF);
		pn.add(quantityLbl);
		pn.add(quantityTF);
		pn.add(priceLbl);
		pn.add(priceTF);
		pn.add(catagoryLbl);
		pn.add(catagoryCB);
		pn.add(pvwLbl);
		pn.add(load);
		pn.add(refresh);
		pn.add(delete);
		pn.add(update);
		pn.add(addProduct);
		pn.add(logout);
		pn.add(back);
		pn.add(bandImgLbl);
		pn.add(backImgLbl);
		
		this.add(pn);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("p_img.png")));
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String Text = ae.getActionCommand();
		
		if(Text.equals(load.getText()))
		{
			loadDB();
		}
		else if(Text.equals(addProduct.getText()))
		{
			addDB();
		}
		else if(Text.equals(refresh.getText()))
		{
			this.setVisible(false);
			UpdateInventory ui = new UpdateInventory(userID,userName,_name,_balance,gender,_phone,address,status,pID,pQuantity,pName,pCategory,pPrice);
			ui.setVisible(true);
		}
		else if(Text.equals(delete.getText()))
		{
			deleteDB();
		}
		else if(Text.equals(update.getText()))
		{
			updateInDB();
		}
		else if(Text.equals(logout.getText()))
		{
			LoginPG lp = new LoginPG();
			lp.setVisible(true);
			this.setVisible(false);
		}
		else if(Text.equals(back.getText()))
		{
			ckStatus(loginUser);
			this.setVisible(false);
		}
		
	}
	public void mousePressed(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}
	public void mouseClicked(MouseEvent me){}
	public void mouseEntered(MouseEvent me){}
	public void mouseExited(MouseEvent me){}
	public void ckStatus(String loginUser)
	{
		this.loginUser=loginUser;
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
				flag = true;
                String userName = rs.getString("userName");
				String status = rs.getString("status");

				String userID=rs.getString("userID");
				String name=rs.getString("name");
				double balance=rs.getDouble("balance");
				String gender=rs.getString("gender");
				int phone=rs.getInt("phone");
				String address=rs.getString("address");
				if(userName.equals(loginUser))
				{
					flag=true;
					if(status.equals("Seller"))
					{
						HomePG pg = new HomePG(userID,userName,name,balance,gender,phone,address,status);
						pg.setVisible(true);
						this.setVisible(false);
						break;
					}
					else if(status.equals("Customer"))
					{
						HomePG pg = new HomePG(userID,userName,name,balance,gender,phone,address,status);
						pg.updateProduct.setVisible(false);
						pg.ordered.setVisible(false);
						pg.setVisible(true);
						this.setVisible(false);
						break;
					}
					else if(status.equals("Admin"))
					{
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
	public void loadDB()
	{
		String loadId = idTF.getText();
		String query = "SELECT `pID`, `pName`, `pQuantity`, `pPrice`, `pCategory` FROM `product_details` WHERE `pID`='"+loadId+"';"; 
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
			String pName = null;
			int pQuantity = 0;
			double pPrice = 0.0;
			String pCategory=null;


			while(rs.next())
			{
				flag=true;
				pName = rs.getString("pName");
				pQuantity = rs.getInt("pQuantity");
				pPrice=rs.getDouble("pPrice");
				pCategory=rs.getString("pCategory");
				
				nameTF.setText(pName);
				quantityTF.setText(""+pQuantity);
				priceTF.setText(""+pPrice);
				catagoryCB.setSelectedItem(pCategory);
				JOptionPane.showMessageDialog(this,"Product Information Loaded");
			}
			if(!flag)
			{
				idTF.setText("");
				JOptionPane.showMessageDialog(this,"Invalid ID"); 
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
	public void updateInDB()
	{
		String pID = idTF.getText();
		String  pName= nameTF.getText();
		String pQuantity = quantityTF.getText();
		String pPrice = priceTF.getText();
		String pCategory = catagoryCB.getSelectedItem().toString();
		double pPrice_=0.0;
		int pQuantity_=0;
		String query = "UPDATE product_details SET pName='"+pName+"', pQuantity = '"+pQuantity+"', pPrice = '"+pPrice+"', pCategory = '"+pCategory+"' WHERE pID='"+pID+"'";	
		Connection con=null;
        Statement st = null;
        try
		{
			pPrice_ = Double.parseDouble(pPrice);
			pQuantity_=Integer.parseInt(pQuantity);

			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/b25","root","");
			st = con.createStatement();
			st.executeUpdate(query);
			st.close();
			con.close();
			JOptionPane.showMessageDialog(this,"Product Information Updated");
			
			idTF.setText("");
			nameTF.setText("");
			quantityTF.setText("");
			priceTF.setText("");
			catagoryCB.setSelectedItem("");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(this, "Can not update product.");
		}
	}
	public void deleteDB()
	{
		String pID = idTF.getText();
		String query1 = "DELETE from product_details WHERE pID='"+pID+"';";
        try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/b25", "root", "");
			Statement stm = con.createStatement();
			stm.execute(query1);
			stm.close();
			con.close();
			JOptionPane.showMessageDialog(this, "Product Deleted");
			
			idTF.setText("");
			nameTF.setText("");
			quantityTF.setText("");
			priceTF.setText("");
			catagoryCB.setSelectedItem("");
			
		}
        catch(Exception ex)
		{
			JOptionPane.showMessageDialog(this, "Can not delete");
        }
	}
	public void addDB()
	{
		String pID = idTF.getText();
		String pName = nameTF.getText();
		String pPrice = priceTF.getText();
		String pQuantity = quantityTF.getText();
		String pCategory = catagoryCB.getSelectedItem().toString();
		
		int id =Integer.parseInt(idTF.getText());
		int count =Integer.parseInt(quantityTF.getText());
		double price =Double.parseDouble(priceTF.getText());

		String query = "INSERT INTO product_details VALUES ("+pID+",'"+pName+"',"+price+","+count+",'"+pCategory+"');";
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/b25", "root", "");
			Statement stm = con.createStatement();
			stm.execute(query);
			stm.close();
			con.close();
			JOptionPane.showMessageDialog(this, "New product added");

			idTF.setText("");
			nameTF.setText("");
			priceTF.setText("");
			quantityTF.setText("");
			catagoryCB.setSelectedItem("");
		}
        catch(Exception ex)
		{
			JOptionPane.showMessageDialog(this, "Can not add new Product");
			System.out.println(ex.getMessage());
        }
	}
	public void setTable()
	{
		String query="SELECT * FROM `product_details`"; 
        Connection con=null;
        Statement st=null;
		ResultSet rs=null;
        try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/b25","root","");
			st=con.createStatement();
			rs=st.executeQuery(query);

			ResultSetMetaData rsmd=rs.getMetaData();
			int c=rsmd.getColumnCount();
			Vector column=new Vector(c);

			for(int i=1;i<=c;i++)
			{
				column.add(rsmd.getColumnName(i));
			}

			Vector data=new Vector();
			Vector row=new Vector();

			while(rs.next())
			{
				row=new Vector(c);
				for(int i=1;i<=c;i++)
				{
					row.add(rs.getString(i));
				}
				data.add(row);
			}	

			table=new JTable(data,column);
			table.setEnabled(false);
			scroll=new JScrollPane(table);
			scroll.setBounds(100,150,750,500);
			pn.add(scroll);
		}
        catch(Exception ex)
		{
			JOptionPane.showMessageDialog(this, "Can not show product table");
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