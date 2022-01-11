import java.io.*;

public class TestResult {
	
	String group;
	String account;
	String subject;
	boolean type;
	String filePath;
	
	TestResult(String target, String subject, boolean type) {
		if (type) {
			this.group = target;
			this.subject = subject;
			filePath = "data/score/" + subject + File.pathSeparator + group + File.pathSeparator;
		}
		else {
			this.account = target;
			this.subject = subject;
			filePath = "data/score/" + subject + File.pathSeparator + account;
		}
	}
	
	public File[] getgroupList() {
		File file = new File(filePath);
		File[] list = file.listFiles();
		return list;
	}
	
	public File[] getuserList() {
		File file = new File(filePath);
		File[] list = file.listFiles();
		return list;
	}
	
	public String getScoreGroup(String title) {
		return filePath + title + ".txt";
	}
	
	public String getScore(String type) {
		return filePath + type + ".txt";
	}
	
	public String getTestPaper (String title) {
		return "data/testPaper/" + subject + "/question/" + title + ".txt";
	}
	
	public void writeTestScore(String title, String account, String group, char[] answer) throws IOException {
		String path = "data/score/" + subject + File.pathSeparator + group + File.pathSeparator + title + ".txt";
		BufferedWriter bw, bw1;
		try {
			bw = new BufferedWriter(new FileWriter(path));
		} catch (Exception e) {
			File file = new File(path);
			file.createNewFile();
			bw = new BufferedWriter(new FileWriter(path));
		}
		System.out.println(account + "," + getScore(title, answer, false));
		bw.close();
		path = filePath + "test.txt";
		try {
			bw1 = new BufferedWriter(new FileWriter(path));
		} catch (Exception e) {
			File file = new File(path);
			file.createNewFile();
			bw1 = new BufferedWriter(new FileWriter(path));
		}
		System.out.println(title + "," + getScore(title, answer, false));
		bw1.close();
	}
	
	public void writePracticeScore(char[] answer) throws IOException {
		String path = filePath + "practice.txt";
		BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter(path));
		} catch (Exception e) {
			File file = new File(path);
			file.createNewFile();
			bw = new BufferedWriter(new FileWriter(path));
		}
		System.out.println(account + "," + getScore(account, answer, false));
		bw.close();
	}
	
	public int getScore(String title, char[] answer, boolean type) throws IOException {
		String filePath;
		if(type)
			filePath = "data/testPaper/" + subject + "/answer/" + title + ".txt";
		else
			filePath = "data/Temp/TempAns.txt";
		BufferedReader ansReader = new BufferedReader(new FileReader(filePath));
		String correctAnswer = ansReader.readLine();
		char correct;
		int correctNum = 0, total = answer.length;
		for(int i = 0; i < total; i++) {
			correct = correctAnswer.charAt(i);
			if (answer[i] == correct) {
				correctNum ++;
			}
		}
		ansReader.close();
		return (correctNum * 100 / total);
	}
	
}
