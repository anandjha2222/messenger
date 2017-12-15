package com.kaushik.javabrains.messanger.database;

import java.util.HashMap;
import java.util.Map;

import com.kaushik.javabrains.messanger.model.*;
public class DatabaseClass {

	private static Map<Long,Message> message = new HashMap<Long, Message>();
	private static Map<String,Profile> profile = new HashMap<String, Profile>();
	
	public static Map<Long, Message> getMessages()
	{
		return message;
	}
	
	public static Map<String, Profile> getProfiles()
	{
		return profile;
	}
}
