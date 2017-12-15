package com.kaushik.javabrains.messanger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.kaushik.javabrains.messanger.model.Message;
import com.kaushik.javabrains.messanger.services.MessageService;

@Path("/messages")
// if methods consumes and produces json only then we can keep 	@Consumes(MediaType.APPLICATION_JSON) and 
//@Produces(MediaType.APPLICATION_JSON) at class level
public class MessageResource {
	
	MessageService ms = new MessageService();
	
	@GET
	//@Produces(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages(@QueryParam("year") int year,@QueryParam("start") int start,@QueryParam("size") int size)
	{
		if(year>0) //
		{
			return ms.getAllMessagesForYear(year);
		}
		if(start>=0 && size>0)
		{
			return ms.getAllMessagesPaginated(start, size);
		}
		return ms.getAllMessages();
	}
	
	@GET
	@Path("/{id}")
	//@Produces(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam("id") long id) // REG-EX can be used in PathParam
	{
		return ms.getMessage(id);
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message updateMessage(@PathParam("id") long id,Message message)
	{
		message.setId(id);
		return ms.updateMessage(message);
	}
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteMessage(@PathParam("id") long id)
	{
		ms.removeMessage(id);
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message addMessage(Message message)
	{
		return ms.addMessage(message);
	}
}
