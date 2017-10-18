package YccSenaoOOP;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Config implements java.io.Serializable {

	private String ext; //�]�w�ɮ׮榡 (cs, docx, jpg, ...)
	private String location; //�]�w�n�ƥ��ɮת��ؿ�
	private boolean subDirectory; //�O�_�B�z�l�ؿ�, true:�B�z�l�ؿ��F false:�� �B�z�l�ؿ�
	private String unit; //�]�w�ƥ����, file:�H��@�ɮ׬��B�z���F directory:�H��ӥؿ����B�z���
	private boolean remove; //�B�z���O�_�R���ɮ�, true:�R���F false:���R��
	private String handler;	//zip:���Y�F encode:�[�K
	private String destination; //�B�z��n�x�s�줰��a��, directory:�ؿ��F db:��Ʈw
	private String dir;	//�B�z�᪺�ؿ�
	private String connectionString; //�]�w��Ʈw�s���r��
	
	public Config(String ext, String location, boolean subDirectory, String unit, boolean remove, String handler, String destination, String dir, String connectionString) {
		super();
		this.ext = ext;
		this.location = location;
		this.subDirectory = subDirectory;
		this.unit = unit;
		this.remove = remove;
		this.handler = handler;
		this.destination = destination;
		this.dir = dir;
		this.connectionString = connectionString;
	}
	
	public Config(String configJsonString) throws ParseException {
		JSONParser parser = new JSONParser();
		Object o=parser.parse(configJsonString);
		JSONObject j=(JSONObject)o;
		this.ext=j.get("ext").toString();
		this.location=j.get("location").toString();
		this.subDirectory=j.get("subDirectory").toString().equalsIgnoreCase("true")?true:false;
		this.unit=j.get("unit").toString();
		this.remove=j.get("remove").toString().equalsIgnoreCase("true")?true:false;
		this.handler=j.get("handler").toString();
		this.destination=j.get("destination").toString();
		this.dir=j.get("dir").toString();
		this.connectionString=j.get("connectionString").toString();		
	}
	
	public String getExt() {
		return ext;
	}
	public String getLocation() {
		return location;
	}
	public boolean isSubDirectory() {
		return subDirectory;
	}
	public String getUnit() {
		return unit;
	}
	public boolean isRemove() {
		return remove;
	}
	public String getHandler() {
		return handler;
	}
	public String getDestination() {
		return destination;
	}
	public String getDir() {
		return dir;
	}
	public String getConnectionString() {
		return connectionString;
	}
	
	public static void main(String args[]) throws ParseException {
		String configJsonString=
				"{ \"ext\": \"cs\", "+ 
				"  \"location\": \"c:\\Projects\", " + 
				"  \"subDirectory\": true, " + 
				"  \"unit\": \"file\", " + 
				"  \"remove\": false, " + 
				"  \"handler\": \"zip\", " + 
				"  \"destination\": \"directory\", " + 
				"  \"dir\": \"c:\\MyArchieves\", " + 
				"  \"connectionString\": \"\" "+
				"}";
		Config c=new Config(configJsonString);
		System.out.println(c.getExt());
		System.out.println(c.isSubDirectory());
		System.out.println(c.getLocation());
	}
}
