package com.xml.test.demo;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import entity.Student;
import entity.Teacher;

public class JaxbDemo {

	public static void main(String[] args) {
		Student stu = new Student();
		stu.setId("1");
		stu.setName("��־ï");
		stu.setAge(25);
		stu.setBirthDay(new Date());
		// list���ϣ�set����һ��
		ArrayList<Teacher> list = new ArrayList<Teacher>();
		list.add(new Teacher(2, "����÷", 22));
		list.add(new Teacher(3, "�ƻ���", 22));
		list.add(new Teacher(4, "��־��", 22));
		stu.setList(list);
		// ��javaBean�����javaBean
		Teacher teacher = new Teacher(1, "����", 22);
		stu.setTeacher(teacher);
		// ���map����
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		map.put("1", "������");
		map.put("2", "�¼�");
		stu.setMap(map);
		try {
			JAXBContext context = JAXBContext.newInstance(Student.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.setProperty(Marshaller.JAXB_ENCODING, "GBK");
			// marshaller.marshal(stu, System.out);
			StringWriter writer = new StringWriter();
			marshaller.marshal(stu, writer);
			System.out.println(writer.toString());
			// �����л�
			Unmarshaller unmarshaller = context.createUnmarshaller();
			StringReader reader = new StringReader(writer.toString());
			Student stu2 = (Student) unmarshaller.unmarshal(reader);
			System.out.println("stu2" + stu2);
		} catch (JAXBException e) {
			e.getMessage();
			e.printStackTrace();
		}
	}
}