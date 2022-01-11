import java.io.*;
import java.util.*;

public class Group {
	
	String group;
	String filePath;
	String memberPath;
	String subjectPath;
	ArrayList<String> member = null;
	ArrayList<String> subject = null;
	
	Group(String group) throws IOException{
		this.group = group;
		filePath = "data/group/" + group;
		readData();
	}
	
	Group() {
		filePath = "data/group";
	}
	
	public void newGroup(String name) throws IOException {
		this.group = name;
		filePath = filePath + File.pathSeparator + name;
		File newGroup = new File(filePath);
		File newMemData = new File(memberPath);
		newGroup.mkdir();
		newMemData.createNewFile();
	}
	
	public void readData() throws IOException{
		BufferedReader newMemData = new BufferedReader(new FileReader(filePath + "/member.txt"));
		String[] memLoader = newMemData.readLine().split(",");
		for(String mem : memLoader) {
			member.add(mem);
		}
		newMemData.close();
	}
	
	public void addMember(String memberAccount) {
		member.add(memberAccount);
	}
	
	public void addMember(String[] memberAccount) {
		for(String mem : memberAccount) {
			member.add(mem);
		}
	}
	
	public void deleteMember(String target) {
		member.remove(target);
	}
	
	public void saveGroupData() throws IOException{
		BufferedWriter memberWriter = new BufferedWriter(new FileWriter(memberPath));
		for(String mem : member) {
			System.out.print(mem + ",");
		}
		memberWriter.close();
		BufferedWriter subjectWriter = new BufferedWriter(new FileWriter(subjectPath));
		for(String mem : subject) {
			System.out.print(mem + ",");
		}
		subjectWriter.close();
	}
	
	public void switchGroup(String user, String newGroup) throws IOException{
		member.remove(user);
		String newFilePath = filePath = "data/group/" + newGroup + "member.txt";
		BufferedWriter memberWriter = new BufferedWriter(new FileWriter(newFilePath));
		System.out.print(user + ",");
		memberWriter.close();
		User newUser = new User(group, user);
		newUser.changeGroup(newGroup);
		newUser.saveProfile();
	}
	
}
