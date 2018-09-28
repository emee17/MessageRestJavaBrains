package com.repostitory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.entity.Alien;

public class AlienRepository
{
	List<Alien> aliens;
	
	public AlienRepository()
	{
		aliens = new ArrayList<>();
		Alien a1 = new Alien();
		a1.setId(101);
		a1.setName("Mark");
		a1.setColor("Green");
		
		Alien a2 = new Alien();
		a2.setId(102);
		a2.setName("Jarvis");
		a2.setColor("Red");
		
		Alien a3 = new Alien();
		a3.setId(103);
		a3.setName("Harry");
		a3.setColor("Black");
		
		aliens.add(a1); aliens.add(a2);aliens.add(a3);
	}
	
	public List<Alien> getAliens()
	{
		return aliens;
	}
	
	public Alien getAlien (int id)
	{
		for (Alien alien : aliens)
		{
			if (alien.getId()==id)
			{
				return alien;
			}
		}
		return null;
	}

	public void createAlien(Alien a) 
	{
		aliens.add(a);
	}
}
