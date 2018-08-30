package poiExport.com.demo01.activemq;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Publish01 {
	
	public static void main(String[] args) throws JMSException {
		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(MqCommon.URL);
		Connection connection = factory.createConnection();
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Queue queue = session.createQueue(MqCommon.QUEUETEST);
		TextMessage msg = session.createTextMessage("hello world.......");
		MessageProducer product = session.createProducer(queue);
		product.send(msg);
		
		connection.close();
	}
	


}
