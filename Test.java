import org.json.JSONObject;
import java.io.*;

public class Test {

	String subject;
	String filePath;
	JSONObject test = new JSONObject();
	
	public Test (String subject){
		this.subject = subject;
		filePath = "data/test/" + subject + File.pathSeparator;
	}
	
	public void createQuiz(int timeLimit, String title, int easy, int normal, int diff) throws IOException {
		String path = filePath + title + ".json";
		File testPaper = new File(path);
		int number = easy + normal + diff;
		test.put("title", title);
		test.put("time limit", timeLimit);
		test.put("question number", number);
		TestPaper paper = new TestPaper(subject);
		String testPath = paper.create(title, easy, normal, diff);
		test.put("test path", testPath);
		testPaper.createNewFile();
		BufferedWriter bw = new BufferedWriter(new FileWriter(path));
		String testFile = test.toString();
		System.out.println(testFile);
		bw.close();
		test = null;
	}
	
	public File[] getList() {
		File file = new File(filePath);
		File[] list = file.listFiles();
		return list;
	}
	
}
