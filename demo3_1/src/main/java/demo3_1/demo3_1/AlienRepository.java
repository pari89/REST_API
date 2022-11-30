package demo3_1.demo3_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AlienRepository {
	public Connection connectDB() throws ClassNotFoundException, SQLException
	{
		String un = "root";
		String p = "$riNamu89";
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url= "jdbc:mysql://localhost:3306/alien";
		Connection con = DriverManager.getConnection(url, un, p);
		return con;
	}
	
	public List<Alien> getAliens() throws ClassNotFoundException
	{
		List<Alien> aliens = new ArrayList<Alien>();
		String s = "select * from alien";
		try {
			Statement ps = connectDB().createStatement();
			ResultSet rs = ps.executeQuery(s);
			while(rs.next())
			{
				Alien a =  new Alien();
				a.setId(rs.getInt(1));
				a.setName(rs.getString(2));
				a.setPoints(rs.getInt(3));
				aliens.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print(e);
		}
		
		return aliens;
	}
	
	public Alien getAlien(int id) throws ClassNotFoundException
	{
		String s = "select * from alien where id ="+id;
		Alien a =  new Alien();
		try {
			Statement ps = connectDB().createStatement();
			ResultSet rs = ps.executeQuery(s);
			
			if(rs.next())
			{
				
				a.setId(rs.getInt(1));
				a.setName(rs.getString(2));
				a.setPoints(rs.getInt(3));
				return a;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print(e);
		}
		return a;
	}

	public void create(Alien a1) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		int id = a1.getId();
		String name = a1.getName();
		int points = a1.getPoints();
		try {
			PreparedStatement ps = connectDB().prepareStatement("insert into alien values(?,?,?)");
			ps.setInt(1,id);
			ps.setString(2, name);
			ps.setInt(3, points);
			ps.executeUpdate();
			connectDB().close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print(e);
		}
	}
	
	public void update(Alien a1) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		int id = a1.getId();
		String name = a1.getName();
		int points = a1.getPoints();
		try {
			PreparedStatement ps = connectDB().prepareStatement("update alien set name=?,points=? where id = ?");
			ps.setString(1, name);
			ps.setInt(2, points);
			ps.setInt(3,id);
			ps.executeUpdate();
			connectDB().close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print(e);
		}
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		PreparedStatement ps;
		try {
			ps = connectDB().prepareStatement("delete from alien where id = ?");
			ps.setInt(1,id);
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
