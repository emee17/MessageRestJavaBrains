package com.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.entity.Alien;
import com.repostitory.AlienRepository;

@Path("/aliens")
public class AlienResource
{
	AlienRepository alienRepository = new AlienRepository();
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Alien> getAllMessage()
	{
		List<Alien> list = alienRepository.getAliens();
		return list;
	}
	
	@GET
	@Path("/alien/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Alien getAlien(@PathParam("id") int id)
	{
		return alienRepository.getAlien(id);
	}
	
	@POST
	@Path("add")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Alien createAlien(Alien a)
	{
		alienRepository.createAlien(a);
		return a;
	}
}