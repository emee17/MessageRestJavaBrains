package com.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.entity.Message;
import com.service.MessageService;

@Path("/message")
public class MessageResource
{
	MessageService messageservice = new MessageService();
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> getAllMessage()
	{
		
		return messageservice.getAllMessage();
	}
	
	/*@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Message addMessage(Message message)
	{
		return messageservice.addMessage(message);
	}*/
	
	@POST
	@Produces(MediaType.APPLICATION_XML)
	public String addMessage()
	{
		return "Alhamdulillah It works";
	}
	
	
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_XML)
	public Message getMessage(@PathParam("messageId") long messageId)
	{
		
		
		return messageservice.getMessage(messageId);
		
	}
	
}
