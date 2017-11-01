package YccSenaoOOP;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Config implements java.io.Serializable {

	private String ext; // 設定檔案格式 (cs, docx, jpg, ...)
	private String location; // 設定要備份檔案的目錄
	private boolean subDirectory; // 是否處理子目錄, true:處理子目錄； false:不 處理子目錄
	private String unit; // 設定備份單位, file:以單一檔案為處理單位； directory:以整個目錄為處理單位
	private boolean remove; // 處理完是否刪除檔案, true:刪除； false:不刪除
	private String[] handlers; // 例如 {"zip", "encode"...} (其中zip是壓縮, encode是加密)
	private String destination; // 處理後要儲存到什麼地方, directory:目錄； db:資料庫
	private String dir; // 處理後的目錄
	private String connectionString; // 設定資料庫連接字串

	public Config(String ext, String location, boolean subDirectory, String unit, boolean remove, String[] handlers, String destination, String dir, String connectionString) {
		super();
		this.ext = ext;
		this.location = location;
		this.subDirectory = subDirectory;
		this.unit = unit;
		this.remove = remove;
		this.handlers = handlers;
		this.destination = destination;
		this.dir = dir;
		this.connectionString = connectionString;
	}

	public Config(String configJsonString) throws ParseException {
		JSONParser parser = new JSONParser();
		Object o = parser.parse(configJsonString);
		JSONObject j = (JSONObject) o;
		this.ext = j.get("ext").toString();
		this.location = j.get("location").toString();
		this.subDirectory = j.get("subDirectory").toString().equalsIgnoreCase("true") ? true : false;
		this.unit = j.get("unit").toString();
		this.remove = j.get("remove").toString().equalsIgnoreCase("true") ? true : false;
		this.handlers = j.get("handlers").toString().replace("[", "").replaceAll("]", "").replaceAll("\"", "").split(",");
		this.destination = j.get("destination").toString();
		this.dir = j.get("dir").toString();
		this.connectionString = j.get("connectionString").toString();
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

	public String[] getHandlers() {
		return handlers;
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

	// 測試
	public static void main(String args[]) throws ParseException {
		String configJsonString = "{ " + "  \"ext\": \"cs\", " + "  \"location\": \"c:\\Projects\", "
				+ "  \"subDirectory\": true, " + "  \"unit\": \"file\", " + "  \"remove\": false, "
				+ "  \"handlers\": [\"zip\", \"encode\"] " + "  \"destination\": \"directory\", "
				+ "  \"dir\": \"c:\\MyArchieves\", " + "  \"connectionString\": \"\" " + "}";
		Config c = new Config(configJsonString);
		System.out.println(c.getExt());
		System.out.println(c.getHandlers()[0] + ", " + c.getHandlers()[1]);
		System.out.println(c.isSubDirectory());
		System.out.println(c.getLocation());
	}
}
