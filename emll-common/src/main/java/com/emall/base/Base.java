package com.emall.base;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public abstract class Base {

	public Logger log=LoggerFactory.getLogger(getClass().getName());
	
	public static Date getDate()
	{
		return new Date();
	}
	
	public static boolean empty(Object obj)
	{
		return obj==null;
	}
	
	public static boolean notEmpty(Object obj)
	{
		return obj!=null;
	}
}
