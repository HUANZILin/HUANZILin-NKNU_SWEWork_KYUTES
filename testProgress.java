import java.io.*;
import org.json.JSONObject;

public class testProgress {

	JSONObject testData;
	String subject;
	String title;
	String testPath;
	String account;
	int timeLimit;
	int questionTotal;
	int questionNow;
	
	testProgress(String subject, String title) throws IOException {
		this.subject = subject;
		this.title = title;
		testPath = "data/test/" + subject + File.pathSeparator + title + ".json";
		BufferedReader test = new BufferedReader(new FileReader(testPath));
		String reader = test.readLine();
		testData = new JSONObject(reader);
		test.close();
	}
	
	testProgress(String subject) throws IOException{
		testPath = "data/Temp/TempTest.txt";
		TestPaper test = new TestPaper(subject);
		test.create(15, 5, 5, 5);
	}
	
	public void startQuiz(String group, String userName) {
		timeLimit = testData.getInt("time limit");
		questionTotal = testData.getInt("question number");
		String path = testData.getString("test path");
		TestStartGUI test = new TestStartGUI();
		try {
			test.getTest(questionTotal, path);
		} catch(Exception e) {
			e.getStackTrace();
		}
		test.start();
		test.getData(subject, account, title);
	}
	
	public void startPractice(String userName) {
		TestStartGUI test = new TestStartGUI();
		try {
			test.getTest(15, testPath);
		} catch(Exception e) {
			e.getStackTrace();
		}
		test.start();
	}
	
	public void getAccount(String account) {
		this.account = account;
	}
}