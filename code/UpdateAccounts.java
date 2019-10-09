import java.lang.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateAccounts extends JFrame implements ActionListener, MouseListener
{
	public String loginUser;
	JPanel pn;
	JButton load, update, delete, logout, back, refresh, addEmployee;
	JLabel idLbl, nameLbl, phoneLbl, balanceLbl, pvwLbl, backImgLbl ,bandImgLbl,addressLbl,passLbl;
	JTextField idTF, nameTF, phoneTF, balanceTF,addressTF,passTF;
	ImageIcon backImg,bandImg;
	Color halkalal,ashColor;
	Font s1font,btnfont;
	JTable table;
	JScrollPane scroll;
	int pID,pQuantity;
	String pName,pCategory;
	double pPrice;
	public String userID,userName,_name,gender,address,status;
	public int _phone;
	public double _balance;
	
	public UpdateAccounts(String userID,String userName,String _name,double _balance,String gender,int _phone,String address,String status)
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
		
		this.setTitle("Accounts Information Change Page");
		this.setSize(1366,740);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pn = new JPanel();
		pn.setLayout(null);
		
		halkalal = new Color(167,37,37);
		ashColor = new Color(128,128,128);
		s1font = new Font("Impact",Font.BOLD,30);
		btnfont = new Font("Impact",Font.PLAIN,15);

		if(status.equals("Admin"))
		{
			setTable();
		}
		
		idLbl = new JLabel("User's ID :");
		nameLbl = new JLabel("Full Name :");
		phoneLbl = new JLabel("User's Phone No. :");
		addressLbl = new JLabel("User's Address :");
		passLbl = new JLabel("password :");
		balanceLbl = new JLabel("User's Balance :");
		pvwLbl = new JLabel("Accounts Information");
		
		idTF = new JTextField();
		nameTF = new JTextField();
		phoneTF = new JTextField();
		addressTF=new JTextField();
		passTF=new JTextField();
		balanceTF = new JTextField();
		
		load = new JButton("Load Accounts Information");
		refresh=new JButton("refresh");
		update = new JButton("Update Information");
		addEmployee = new JButton("Add Employee");
		logout = new JButton("Logout");
		back = new JButton("Back");
		delete = new JButton("Delete");
		
		backImg = new ImageIcon("back_img.jpg");
		backImgLbl = new JLabel(backImg);
		bandImg = new ImageIcon("side_bar.png");
		bandImgLbl = new JLabel(bandImg);
		
		idLbl.setBounds(950,100,200,30);
		nameLbl.setBounds(925,250,200,30);
		phoneLbl.setBounds(925,300,200,30);
		passLbl.setBounds(925,350,200,30);
		addressLbl.setBounds(925,400,200,30);
		balanceLbl.setBounds(925,450,200,30);
		pvwLbl.setBounds(300,200,600,30);
		idTF.setBounds(1050,95,200,30);
		nameTF.setBounds(1075,250,200,30);
		phoneTF.setBounds(1075,300,200,30);
		passTF.setBounds(1075,350,200,30);
		addressTF.setBounds(1075,400,200,30);
		balanceTF.setBounds(1075,450,200,30);	
		load.setBounds(975,150,225,30);
		refresh.setBounds(975,190,225,30);
		delete.setBounds(1075,520,200,30);
		update.setBounds(1075,560,200,30);
		logout.setBounds(1150,600,125,30);
		back.setBounds(1075,600,70,30);
		addEmployee.setBounds(1075,640,200,30);
		backImgLbl.setBounds(0,0,1366,740);
		bandImgLbl.setBounds(850,0,500,700);
		
		
		pvwLbl.setForeground(halkalal);
		pvwLbl.setFont(s1font);
		
		load.setFont(btnfont);
		refresh.setFont(btnfont);
		delete.setFont(btnfont);
		update.setFont(btnfont);
		addEmployee.setFont(btnfont);
		logout.setFont(btnfont);
		back.setFont(btnfont);
		
		load.addActionListener(this);
		refresh.addActionListener(this);
		delete.addActionListener(this);
		update.addActionListener(this);
		addEmployee.addActionListener(this);
		logout.addActionListener(this);
		back.addActionListener(this);
		
		pn.add(idLbl);
		pn.add(idTF);
		pn.add(nameLbl);
		pn.add(nameTF);
		pn.add(phoneLbl);
		pn.add(phoneTF);
		pn.add(passLbl);
		pn.add(passTF);
		pn.add(addressLbl);
		pn.add(addressTF);
		if(status.equals("Admin"))
		{
			pn.add(balanceLbl);
			pn.add(addEmployee);
		}
		if(status.equals("Admin"))
		{
			pn.add(balanceTF);
			pn.add(addEmployee);
		}
		
		pn.add(pvwLbl);
		pn.add(load);
		pn.add(refresh);
		pn.add(delete);
		pn.add(update);
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
			if(status.equals("Customer"))
			{
				if(userID.equals(idTF.getText()))
				{
					loadDB();
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Access Denied");
					nameTF.setText("");
					phoneTF.setText("");
					passTF.setText("");
					addressTF.setText("");
				}
			}
			if(status.equals("Seller"))
			{
				if(userID.equals(idTF.getText()))
				{
					loadDB();
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Access Denied");
					nameTF.setText("");
					phoneTF.setText("");
					passTF.setText("");
					addressTF.setText("");
				}
			}
			else if(status.equals("Admin"))
			{
				loadDB();
			}
		}
		else if(Text.equals(refresh.getText()))
		{
			this.setVisible(false);
			UpdateAccounts ua = new UpdateAccounts(userID,userName,_name,_balance,gender,_phone,address,status);
			ua.setVisible(true);
		}
		else if(Text.equals(addEmployee.getText()))
		{
			this.setVisible(false);
			EmployeeRegistration uem = new EmployeeRegistration(userID,userName,_name,_balance,gender,_phone,address,status);
			uem.setVisible(true);
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
	public void loadDB()
	{
		String loadId = idTF.getText();
		String query = "SELECT `userID`, `userName`, `name`, `password`, `balance`, `gender`, `phone`, `address`, `status` FROM `user_accounts` WHERE `userID`='"+loadId+"';"; 
        Connection con=null;
        Statement st = null;
		ResultSet rs = null;
		System.out.println(query);
        try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/b25","root","");
			st = con.createStatement();
			rs = st.executeQuery(query);
			
			boolean flag = false;
			String eName = null;
			String phone = null;
			String address=null;
			String password=null;
			double salary = 0.0;			
			while(rs.next())
			{
                eName = rs.getString("name");
				phone = rs.getString("phone");
				address = rs.getString("address");
				password=rs.getString("password");
				salary = rs.getDouble("balance");
				flag=true;
				

				nameTF.setText(eName);
				phoneTF.setText(phone);
				passTF.setText(password);
				addressTF.setText(address);
				balanceTF.setText(""+salary);
				JOptionPane.showMessageDialog(this,"Accounts Information Loaded");
			}
			if(!flag)
			{
				nameTF.setText("");
				phoneTF.setText("");
				passTF.setText("");
				addressTF.setText("");
				balanceTF.setText("");
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
		String id = idTF.getText();
		String  nameSet= nameTF.getText();
		String phnNo = phoneTF.getText();
		String password = passTF.getText();
		String address=addressTF.getText();
		String acBalance = balanceTF.getText();
		double salary=0.0;
		int phn_=0;
		double oldBalnce=0.00;
		double newBalance=0.00;
		String query1 = "SELECT  `balance` FROM `user_accounts` WHERE userID='"+id+"';";
		Connection con=null;
        Statement st = null;
        ResultSet rs = null;
        try
		{
			salary = Double.parseDouble(acBalance);
			phn_=Integer.parseInt(phnNo);
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/b25","root","");
			st = con.createStatement();

			rs = st.executeQuery(query1);
			while(rs.next())
			{
				oldBalnce=rs.getDouble("balance");
			}
			newBalance=oldBalnce+salary;

			String query = "UPDATE user_accounts SET name='"+nameSet+"', phone = '"+phnNo+"', balance = "+newBalance+", password = '"+password+"', address = '"+address+"' WHERE userID='"+id+"'";
			st.executeUpdate(query);
			st.close();
			con.close();
			
			idTF.setText("");
			nameTF.setText("");
			phoneTF.setText("");
			passTF.setText("");
			addressTF.setText("");
			balanceTF.setText("");
			JOptionPane.showMessageDialog(this, "Successfully updated");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(this, "Can not update");
		}
	}
	public void deleteDB()
	{
		String newId = idTF.getText();
		String query1 = "DELETE from user_accounts WHERE userID='"+newId+"';";
		String query2 = "DELETE from login WHERE userID='"+newId+"';";
        try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/b25", "root", "");
			Statement stm = con.createStatement();
			int x=JOptionPane.showConfirmDialog(this,"Do you want to delete?","delete confirmation",JOptionPane.YES_NO_OPTION);
			if(x==0)
			{
				stm.execute(query1);
				stm.execute(query2);
				stm.close();
				con.close();
				if(userID.equals(newId))
				{
					JOptionPane.showMessageDialog(this,"Accounts Information deleted");
					LoginPG lp = new LoginPG();
					lp.setVisible(true);
					this.setVisible(false);
				}
				else
				{
					idTF.setText("");
					nameTF.setText("");
					phoneTF.setText("");
					passTF.setText("");
					addressTF.setText("");
					if(status.equals("Admin"))
					{
						balanceTF.setText("");
					}
				}
			}
			else
			{
				stm.close();
				con.close();
				idTF.setText("");
				nameTF.setText("");
				phoneTF.setText("");
				passTF.setText("");
				addressTF.setText("");
				if(status.equals("Admin"))
				{
					balanceTF.setText("");
				}
			}

			
		}
        catch(Exception ex)
		{
			JOptionPane.showMessageDialog(this, "Can not delete");
			System.out.println(ex.getMessage());
        }
	}
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
				System.out.println("ok10");
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
	public void setTable()
	{
		String query = "SELECT `userID`, `userName`, `name`, `balance`, `gender`, `phone`, `address`, `status` FROM `user_accounts`"; 
        Connection con=null;
        Statement st = null;
		ResultSet rs = null;
        try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/b25","root","");
			st = con.createStatement();
			rs = st.executeQuery(query);

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
			scroll.setBounds(50,250,800,200);
		pn.add(scroll);
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
					rs.close();

                if(st!=null)
					st.close();

                if(con!=null)
					con.close();
            }
            catch(Exception ex){}
        }
	}
}