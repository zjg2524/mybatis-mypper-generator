package entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DateAdapter extends XmlAdapter<String, Date> {
	// �����л������ڶ���Date
	@Override
	public Date unmarshal(String str) throws Exception {
		SimpleDateFormat format = getSimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return str == null ? null : format.parse(str);
	}

	// ���л���xmL
	@Override
	public String marshal(Date date) throws Exception {
		SimpleDateFormat format = getSimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return date == null ? "" : format.format(date);
	}

	private SimpleDateFormat getSimpleDateFormat(String pattern) {
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format;
	}
}