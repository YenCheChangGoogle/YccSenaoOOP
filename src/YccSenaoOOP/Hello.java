package YccSenaoOOP;

public class Hello {

	public static void main(String[] args) {
		System.out.println("Â²³æ´ú¸Õ¯ó½Z");

		
		String configJsonSample=
				"{" + 
				"  \"configs\": [ " + 
				"    { \"ext\": \"cs\", " + 
				"      \"location\": \"c:\\Projects\", " + 
				"      \"subDirectory\": true, " + 
				"      \"unit\": \"file\", " + 
				"      \"remove\": false, " + 
				"      \"handler\": \"zip\", " + 
				"      \"destination\": \"directory\", " + 
				"      \"dir\": \"c:\\MyArchieves\", " + 
				"      \"connectionString\": \"\" " + 
				"    }, " + 
				"    { " + 
				"      \"ext\": \"docx\", " + 
				"      \"location\": \"c:\\Documents\", " + 
				"      \"subDirectory\": true, " + 
				"      \"unit\": \"file\", " + 
				"      \"remove\": false, " + 
				"      \"handler\": \"encode\", " + 
				"      \"destination\": \"db\", " + 
				"      \"dir\": \"\", " + 
				"      \"connectionString\": \"MyConnectionString\" " + 
				"    }, " + 
				"    { " + 
				"      \"ext\": \"jpg\", " + 
				"      \"location\": \"c:\\Pictures\", " + 
				"      \"subDirectory\": true, " + 
				"      \"unit\": \"file\", " + 
				"      \"remove\": false, " + 
				"      \"handler\": \"\", " + 
				"      \"destination\": \"directory\", " + 
				"      \"dir\": \"c:\\MyArchieves\", " + 
				"      \"connectionString\": \"\" " + 
				"    }"+
				"  ]"+
				"}";
		ConfigManager cm=new ConfigManager();
		cm.processConfigs(configJsonSample);
		for(int i=0; i<cm.getCount(); i++) {
			Config cfg=cm.getConfig(i);
			System.out.println("ext="+cfg.getExt()+", location="+cfg.getLocation()+", subDirectory="+cfg.isSubDirectory()+", unit="+cfg.getUnit()+", remove="+cfg.isRemove()+", handler="+cfg.getHandler()+", destination="+cfg.getDestination()+", dir="+cfg.getDir()+", connectionString="+cfg.getConnectionString());
		}
		System.out.println();
		
		String scheduleJsonSample=
				"{" + 
				"  \"schedules\": [ " + 
				"    { \"ext\": \"cs\", " + 
				"      \"time\": \"12:00\", " + 
				"      \"interval\": \"Everyday\" " + 
				"    }, " + 
				"    { " + 
				 "   \"ext\": \"docx\", " + 
				"    \"time\": \"20:00\", " + 
				"    \"interval\": \"Everyday\" " + 
				"    },\r\n" + 
				"    { " + 
				"    \"ext\": \"jpg\", " + 
				"    \"time\": \"7:00\", " + 
				"    \"interval\": \"Monday\" " + 
				"    }, " + 
				"  ]" + 
				"}";
		
		ScheduleManager sm=new ScheduleManager();
		sm.processSchedules(scheduleJsonSample);
		for(int i=0; i<sm.getCount(); i++) {
			Schedule sche=sm.getSchedule(i);
			System.out.println("ext="+sche.getExt()+", time="+sche.getTime()+", interval="+sche.getInterval());
		}
	}

}
