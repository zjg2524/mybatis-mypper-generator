import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;



public class Test {

	public static void main(String[] args) throws JAXBException {
		User user = new User();
		user.setAddr("下关");
		user.setAge(18);
		user.setSname("huahua");
		user.setDesc("一个人");
		String parseXml = parseXml(user, User.class, "UTF-8");
		System.out.println(parseXml);
		
		User user1 = xmlToObject(parseXml, User.class);
		System.out.println(user1);
	}
	
	
	public static String parseXml(Object obj,Class claz,String encode) throws JAXBException
	{
		JAXBContext context = JAXBContext.newInstance(claz);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.setProperty(Marshaller.JAXB_ENCODING, encode);
		// marshaller.marshal(stu, System.out);
		StringWriter writer = new StringWriter();
		marshaller.marshal(obj, writer);
		return writer.toString();
	}
	
	public static <T> T xmlToObject(String xml,Class <T>claz) throws JAXBException
	{
		JAXBContext context = JAXBContext.newInstance(claz);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		StringReader reader = new StringReader(xml);
		T obj =  (T) unmarshaller.unmarshal(reader);
		return obj;
	}
	
	
	

}
