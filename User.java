import org.json.JSONObject;
import java.io.*;

public class User {
	
	String name;
	String account;
	String password;
	String group;
	boolean admin;
	
	String read = null;
	String write = null;
	String profilePath;
	JSONObject user;
	
	public User(String group, String account) throws IOException {
		profilePath = "data/profile/" + group + File.separator + account + ".json";
		BufferedReader br = new BufferedReader(new FileReader(profilePath));
		read = br.readLine();
		user = new JSONObject(read);
		getData(user);
		br.close();
	}
	
	public void getData(JSONObject profile) {
		this.name = user.getString("name");
		this.account = user.getString("account");
		this.password = user.getString("passowrd");
		this.group = user.getString("group");
		this.admin = user.getBoolean("admin");
	}
	
	public void changeName(String newName) {
		this.name = newName;
	}
	
	public boolean changePassword(String oldPassword, String newPassword) {
		if(password.equals(oldPassword)) {
			password = newPassword;
			return true;
		}
		else
			return false;
	}
	public void changeGroup(String group) {
		this.group = group;
		File oldFile = new File(profilePath);
		this.profilePath = "data/profile/" + group + File.separator + account + ".json";
		File newFile = new File(profilePath);
		oldFile.renameTo(newFile);
	}
	
	public boolean saveProfile() throws IOException {
		File profile = new File(profilePath);
		if(profile.exists()) {
			profile.delete();
			profile.createNewFile();
			BufferedWriter bw = new BufferedWriter(new FileWriter(profilePath));
			write = user.toString();
			System.out.println(write);
			bw.close();
			return true;
		} else
			return false; 
	}
	
	public boolean login(String password) {
		if(password.equals(this.password))
			return true;
		else
			return false;
	}
	
}
