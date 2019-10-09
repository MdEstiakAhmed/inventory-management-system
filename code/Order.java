import java.lang.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Order extends JFrame implements ActionListener, MouseListener
{
	JPanel pn;
	JButton logout, goBack,confirmOrder,load,refresh;
	JLabel userIDLebel,pIDLabel,pquantityLabel,backImgLabel,bandImgLabel,loadIDLabel;
	JTextField userIDTF,pIDTF,pquantityTF,loadIDTF;
	JTable table;
	JScrollPane scroll;
	ImageIcon backImg,bandImg;
	Font btnfont;
	Color halkalal,ashColor;
	String userID,userName,_name,gender,address,status;
	int _phone;
	double _balance;
	String loadId;
	
	public Order(String userID,String userName,String _name,double _balance,String gender,int _phone,String address,String status)
	{
		this.userID=userID;
		this.userName=userName;
		this._name=_name;
		this.gender=gender;
		this._phone=_phone;
		this.address=address;
		this.status=status;
		this._balance=_balance;
		
		this.setTitle("Placed Orders");
		this.setSize(1366,740);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pn = new JPanel();
		pn.setLayout(null);
		
		halkalal = new Color(167,37,37);
		ashColor = new Color(128,128,128);
		btnfont = new Font("Impact",Font.PLAIN,15);

		setTable();

		userIDLebel=new JLabel("User ID:");
		pIDLabel=new JLabel("Product ID:");
		pquantityLabel=new JLabel("Product Quantity:");
		loadIDLabel=new JLabel("Order ID");

		userIDTF= new JTextField();
		pIDTF= new JTextField();
		pquantityTF= new JTextField();
		loadIDTF= new JTextField();

		confirmOrder= new JButton("Confirm Order");
		goBack = new JButton("Go Back");
		logout = new JButton("Logout ?");
		load=new JButton("Load Oder ID");
		refresh=new JButton("refresh");

		backImg = new ImageIcon("back_img.jpg");
		backImgLabel = new JLabel(backImg);
		bandImg = new ImageIcon("side_bar.png");
		bandImgLabel = new JLabel(bandImg);
		
		loadIDLabel.setBounds(900,200,100,30);
		loadIDTF.setBounds(1050,200,200,30);
		load.setBounds(1070,250,160,30);
		userIDLebel.setBounds(900,300,100,30);
		pIDLabel.setBounds(900,350,100,30);
		pquantityLabel.setBounds(900,400,100,30);
		userIDTF.setBounds(1050,300,200,30);
		pIDTF.setBounds(1050,350,200,30);
		pquantityTF.setBounds(1050,400,200,30);
		refresh.setBounds(1050,450,200,30);
		confirmOrder.setBounds(1050,500,200,30);
		logout.setBounds(1050,550,100,30);
		goBack.setBounds(1150,550,100,30);
		backImgLabel.setBounds(0,0,1366,740);
		bandImgLabel.setBounds(850,0,500,700);
		
		goBack.setFont(btnfont);
		logout.setFont(btnfont);
		load.setFont(btnfont);
		confirmOrder.setFont(btnfont);
		refresh.setFont(btnfont);

		load.addActionListener(this);
		refresh.addActionListener(this);
		confirmOrder.addActionListener(this);
		logout.addActionListener(this);
		goBack.addActionListener(this);
		
		pn.add(loadIDLabel);
		pn.add(loadIDTF);
		pn.add(load);
		pn.add(userIDLebel);
		pn.add(pIDLabel);
		pn.add(pquantityLabel);
		pn.add(userIDTF);
		pn.add(pIDTF);
		pn.add(pquantityTF);
		pn.add(refresh);
		pn.add(confirmOrder);
		pn.add(logout);
		pn.add(goBack);
		pn.add(bandImgLabel);
		pn.add(backImgLabel);
		
		this.add(pn);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("p_img.png")));
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String Text = ae.getActionCommand();
		
		if(Text.equals(load.getText()))
		{
			loadOrder();
		}
		if(Text.equals(logout.getText()))
		{
			LoginPG lp = new LoginPG();
			lp.setVisible(true);
			this.setVisible(false);
		}
		else if(Text.equals(goBack.getText()))
		{
			HomePG hp = new HomePG(userID,userName,_name,_balance,gender,_phone,address,status);
			hp.setVisible(true);
			this.setVisible(false);
		}
		else if(Text.equals(refresh.getText()))
		{
			this.setVisible(false);
			Order o = new Order(userID,userName,_name,_balance,gender,_phone,address,status);
			o.setVisible(true);
		}
		else if(Text.equals(confirmOrder.getText()))
		{
			orederConfirm();
		}	
	}
	public void mousePressed(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}
	public void mouseClicked(MouseEvent me){}
	public void mouseEntered(MouseEvent me){}
	public void mouseExited(MouseEvent me){}
	public void loadOrder()
	{
		loadId = loadIDTF.getText();
		String query = "SELECT `orderNo`, `userID`, `pID`, `pQuantity` FROM `order_table` WHERE `orderNo`='"+loadId+"';"; 
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
			String id_ = null;
			String pid_ = null;
			String pq_=null;
			double salary = 0.0;			
			while(rs.next())
			{
				flag=true;
				id_ = rs.getString("userID");
				pid_ = rs.getString("pID");
				pq_=rs.getString("pQuantity");

				userIDTF.setText(id_);
				pIDTF.setText(pid_);
				pquantityTF.setText(pq_);
				JOptionPane.showMessageDialog(this,"Order Information Loaded");
			}
			if(!flag)
			{
				userIDTF.setText("");
				pIDTF.setText("");
				pquantityTF.setText("");
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
					rs.close();

                if(st!=null)
					st.close();

                if(con!=null)
					con.close();
            }
            catch(Exception ex){}
        }
	}
	public void deleteOrder()
	{
		String newId = loadId;
		String query1 = "DELETE from order_table WHERE orderNo='"+newId+"';";
        try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/b25", "root", "");
			Statement stm = con.createStatement();
			stm.execute(query1);
			stm.close();
			con.close();
			
		}
        catch(Exception ex)
		{
			JOptionPane.showMessageDialog(this, "Can not delete");
        }
	}
	public void orederConfirm()
	{
		String userIDCheck=userIDTF.getText();
		String pIDCheck=pIDTF.getText();
		String pquantityCheck=pquantityTF.getText();
		String pPrice=null;
		String balance=null;
		String count=null;
		int flag = 0;

		String query1="SELECT `pPrice`, `pQuantity` FROM `product_details` WHERE `pID`='"+pIDCheck+"';";
		String query2="SELECT `balance` FROM `user_accounts` WHERE `userID`='"+userIDCheck+"';";

		Connection con=null;
        Statement st = null;
		ResultSet rs = null;
        try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/b25","root","");
			st = con.createStatement();

			
			rs = st.executeQuery(query1);
			while(rs.next())
			{
				flag=1;
				pPrice=rs.getString("pPrice");
				count=rs.getString("pQuantity");
			}
			rs = st.executeQuery(query2);
			while(rs.next())
			{
				flag=2;
				balance=rs.getString("balance");
			}
			double newBalance=Double.parseDouble(balance)-(Double.parseDouble(pPrice)*Double.parseDouble(pquantityCheck));
			if(newBalance<0)
			{
				throw new ArithmeticException("Not enough balance");
			}
			int newProductCount=Integer.parseInt(count)-Integer.parseInt(pquantityCheck);
			if(newProductCount<0)
			{
				throw new ArithmeticException("Not enough product");
			}

			String query4="UPDATE user_accounts SET balance = "+newBalance+" WHERE userID='"+userIDCheck+"'";
			String query5="UPDATE product_details SET pQuantity = "+newProductCount+" WHERE pID='"+pIDCheck+"'";

			st.executeUpdate(query4);
			st.executeUpdate(query5);
			deleteOrder();
			JOptionPane.showMessageDialog(this,"order confirm");

			if(flag==0)
			{
				userIDTF.setText("");
				pIDTF.setText("");
				pquantityTF.setText("");
				JOptionPane.showMessageDialog(this,"Invalid ID"); 
			}
		}
		catch(ArithmeticException ex)
		{
			JOptionPane.showMessageDialog(this, ex.getMessage()+" "); 
			System.out.println("Exception : " +ex.getMessage());
        }
        catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
        }
        finally
		{
			loadIDTF.setText("");
			userIDTF.setText("");
			pIDTF.setText("");
			pquantityTF.setText("");
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
	
	public void setTable()
	{
		String query = "SELECT * FROM `order_table`"; 
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
			scroll.setBounds(200,200,650,100);
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