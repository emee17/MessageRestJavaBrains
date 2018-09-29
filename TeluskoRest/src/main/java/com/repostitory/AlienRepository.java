package com.repostitory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.entity.Alien;

public class AlienRepository
{
	static Connection connect =null;
	
	public AlienRepository()
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			connect= DriverManager.getConnection("jdbc:mysql://localhost:3306/chats", "root", "root");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Alien> getAliens()
	{
		List<Alien> aliens = new ArrayList<>();
		
		try {
			PreparedStatement ps = connect.prepareStatement("select * from rest");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				Alien a = new Alien();
				a.setId(rs.getInt(1));
				a.setName(rs.getString(2));
				a.setColor(rs.getString(3));
				aliens.add(a);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return aliens;
	}
	
	public Alien getAlien (int id)
	{
		Alien a = new Alien();
		try {
			PreparedStatement ps = connect.prepareStatement("select * from rest where id="+id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				
				a.setId(rs.getInt(1));
				a.setName(rs.getString(2));
				a.setColor(rs.getString(3));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}

	public void createAlien(Alien a) 
	{
		try {
			PreparedStatement ps = connect.prepareStatement("insert into rest values (?,?,?)");
			ps.setInt(1, a.getId());
			ps.setString(2, a.getName());
			ps.setString(3, a.getColor());
			
			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Alien updateAlien(Alien a)
	{
		try {
			PreparedStatement ps = connect.prepareStatement(" update rest set name=?, color=? where id=? ");
			
			ps.setString(1, a.getName());
			ps.setString(2, a.getColor());
			ps.setInt(3, a.getId());
			
			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
		
	}

	public void delete(int id) 
	{
		try {
			PreparedStatement ps = connect.prepareStatement(" Delete from rest where id ="+id);
			
			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
