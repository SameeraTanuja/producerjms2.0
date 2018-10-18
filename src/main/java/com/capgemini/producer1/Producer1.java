package com.capgemini.producer1;

import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Producer1 {
	public static void main(String args[]) {
		ConnectionFactory connectionFactory=null;
		Queue queue=null;
		
		
		 try
		 {
			 
			 InitialContext initialContext=new InitialContext();
			 queue=(Queue) initialContext.lookup("jms/RegisterUser");
			 connectionFactory=(ConnectionFactory) initialContext.lookup("jms/__defaultConnectionFactory");
			 
		 }
		 
		 catch(NamingException e) {
			 e.printStackTrace();
		 }
		 try(JMSContext context=connectionFactory.createContext()){
			 TextMessage message=context.createTextMessage("Hello");
			 context.createProducer().send(queue, message);
			 
		 }
	}

}
