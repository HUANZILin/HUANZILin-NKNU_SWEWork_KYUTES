import java.io.*;
import java.nio.charset.StandardCharsets;

public class TestPaper {

	String testTitle;
	String subject;
	String testPath;
	String ansPath;
	String answer;
	String [] question = new String [6];
	QuesDataBase databaseEasy;
	QuesDataBase databaseNormal;
	QuesDataBase databaseDiff;
	OutputStreamWriter osw;
	
	public TestPaper(String subject, String title) {
		this.subject = subject;
		this.databaseEasy = new QuesDataBase(subject,"easy");
		this.databaseNormal = new QuesDataBase(subject,"normal");
		this.databaseDiff = new QuesDataBase(subject,"diff");
		testPath = "data/testPaper/" + subject + "/question/" + testTitle + ".txt";
		ansPath = "data/testPaper" + subject + "/answer/" + testTitle + ".txt";
	}
	
	public TestPaper(String subject, String testPath, String ansPath) {
		this.subject = subject;
		this.databaseEasy = new QuesDataBase(subject,"easy");
		this.databaseNormal = new QuesDataBase(subject,"normal");
		this.databaseDiff = new QuesDataBase(subject,"diff");
		this.testPath = testPath;
		this.ansPath = ansPath;
	}
	
	public void create(int easy, int normal, int diff) throws IOException {
		answer = "";
		File file = new File(testPath);
		file.createNewFile();
		osw = new OutputStreamWriter(new FileOutputStream(testPath), StandardCharsets.UTF_8);
		getEasy(easy);
		getNormal(normal);
		getDiff(diff);
		osw.flush();
		osw.close();
		storeAnswer();
	}
	
	public void getEasy(int number) throws IOException {
		int [] questionNumber = databaseEasy.getRandomNumber(number);
		String loader;
		for(Integer n : questionNumber) {
			question = databaseEasy.getQuestion(n);
			loader = question[0] + "," + question[1] + "," + question[2] + "," + question[3] + "," + question[4] + "\n";
			osw.write(loader);
			answer = answer + question[5];
		}
	}
	
	public void getNormal(int number) throws IOException {
		int [] questionNumber = databaseEasy.getRandomNumber(number);
		String loader;
		for(Integer n : questionNumber) {
			question = databaseEasy.getQuestion(n);
			loader = question[0] + "," + question[1] + "," + question[2] + "," + question[3] + "," + question[4] + "\n";
			osw.write(loader);
			answer = answer + question[5];
		}
	}
	
	public void getDiff(int number) throws IOException {
		int [] questionNumber = databaseDiff.getRandomNumber(number);
		String loader;
		for(Integer n : questionNumber) {
			question = databaseEasy.getQuestion(n);
			loader = question[0] + "," + question[1] + "," + question[2] + "," + question[3] + "," + question[4] + "\n";
			osw.write(loader);
			answer = answer + question[5];
		}
	}
			
	public void storeAnswer() {
		try {
			File ansFile = new File(ansPath);
			ansFile.createNewFile();
			osw = new OutputStreamWriter(new FileOutputStream(ansPath), StandardCharsets.UTF_8);
			osw.write(answer);
			osw.flush();
			osw.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
