package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.database.DatabaseClass;
import com.entity.Message;
import com.entity.Profile;

public class MessageService
{
	
	private Map<Long,Message> messages = DatabaseClass.getMessage();
	
	/*private Map<Long,Profile> profile = DatabaseClass.getProfile();*/
	
	public MessageService ()
	{
		messages.put(1L, new Message(1,"Alhamdulillah","Muhammad"));
		messages.put(2L, new Message(2,"SubhanAllah","Ahmad"));
	}
	public List<Message> getAllMessage()
	{
		
		return new ArrayList(messages.values());
	}
	
	public Message getMessage(long id)
	{
		return messages.get(id);
	}
	
	public Message addMessage(Message message)
	{
		message.setId(messages.size()+1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message)
	{
		if(message.getId() <= 0)
		{
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(long id)
	{
		return messages.remove(id);
	}
}
