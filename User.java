import org.json.JSONObject;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class User {
	
	String name;
	String account;
	String password;
	String group;
	boolean admin;
	
	OutputStreamWriter osw;
	String profilePath;
	JSONObject user;
	
	public User(String group, String account) throws IOException {
		profilePath = "data/profile/" + group + "/" + account + ".json";
		BufferedReader br = new BufferedReader(new FileReader(profilePath));
		String read = br.readLine();
		user = new JSONObject(read);
		getData(user);
		br.close();
	}
	
	public void getData(JSONObject profile) {
		this.name = user.getString("name");
		this.account = user.getString("account");
		this.password = user.getString("password");
		this.group = user.getString("group");
		this.admin = user.getBoolean("admin");
	}
	
	public void saveProfile(String newAccount, String newPassword, String newName) throws IOException {
		JSONObject newUser = new JSONObject();
		File file = new File(profilePath);
		file.delete();
		profilePath = "data/profile/" + group + "/" + newAccount + ".json";
		file = new File(profilePath);
		file.createNewFile();
		newUser.put("name", newName);
		newUser.put("account", newAccount);
		newUser.put("password", newPassword);
		newUser.put("group", group);
		newUser.put("admin", admin);
		String writer = newUser.toString();
		osw = new OutputStreamWriter(new FileOutputStream(profilePath), StandardCharsets.UTF_8);
		osw.write(writer);
        osw.flush();
        osw.close();
		
	}
	
	public boolean login(String password) {
		if(password.equals(this.password))
			return true;
		else
			return false;
	}
	
}
