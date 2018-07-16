import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(value = XmlAccessType.FIELD)
@XmlType(propOrder = { "sname", "addr", "desc","age" })
@XmlRootElement(name="persion")
public class User {
	@XmlElement
	private String sname;
	@XmlElement
	private String addr;
	@XmlAttribute
	private String desc;
	@XmlElement
	private int age;
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "User [sname=" + sname + ", addr=" + addr + ", desc=" + desc + ", age=" + age + "]";
	}
	
	
	

}
