import java.io.*;
import org.json.JSONObject;

public class AccountManager {
	
	String filePath;
	
	public AccountManager(){
		
	}
	
	public void createAccountGrorp(String group, int amount) throws IOException {
		filePath = "data/profile/" + group;
		File newFile = new File(filePath);
		newFile.mkdir();
		String account, password;
		for(int i = 1; i <= amount; i ++) {
			account = group + String.format("%02d", i);
			password = group + "@" + String.format("%02d", i);
			try {
				accountCreate(account, password, group);
			}
			catch(Exception e) {
				System.out.println("error");
			}
		}
	}
	
	public void createAccountSingle(String account, String password, boolean admin) throws IOException {
		JSONObject newUser = new JSONObject();
		newUser.put("name", "");
		newUser.put("account", account);
		newUser.put("password", password);
		if(admin) {
			newUser.put("group", "teacher");
			filePath = "data/profile/teacher";
		} else {
			newUser.put("group", "other");
			filePath = "data/profile/other";
		}
		newUser.put("admin", admin);
		String profilePath = filePath + "/" + account + ".json";
		File profile = new File(profilePath);
		profile.createNewFile();
		OutputStream bw = new FileOutputStream(profile);
		String writer = newUser.toString();
		System.out.println(writer);
		bw.close();
	}
	
	public void accountCreate(String account, String password, String group) throws IOException {
		String profilePath = filePath + "/" + account + ".json";
		File profile = new File(profilePath);
		profile.createNewFile();
		JSONObject newUser = new JSONObject();
		newUser.put("name", "");
		newUser.put("account", account);
		newUser.put("password", password);
		newUser.put("group", group);
		newUser.put("admin", false);
		BufferedWriter bw = new BufferedWriter(new FileWriter(profile));
		String writer = newUser.toString();
		System.out.println(writer);
		bw.close();
	}
}
