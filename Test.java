import java.io.*;
import java.nio.charset.StandardCharsets;

public class Test {

	String subject;
	String filePath;
	
	public Test (String subject){
		this.subject = subject;
	}
	
	public void createQuiz(int timeLimit, String title, int easy, int normal, int diff) throws IOException {
		filePath = "data/test/" + subject + "/" + title + ".txt";
		String quesPath = "data/testPaper/" + subject + "/question/" + title + ".txt";
		String ansPath = "data/testPaper/" + subject + "/answer/" + title + ".txt";
		int total = easy + normal + diff;
		TestPaper paper = new TestPaper(subject, title);
		paper.create(easy, normal, diff);
		File test = new File(filePath);
		test.createNewFile();
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(filePath), StandardCharsets.UTF_8);
		osw.write(title + "\n");
		osw.write(timeLimit + "\n");
		osw.write(quesPath + "\n");
		osw.write(ansPath + "\n");
		osw.write(total + "\n");
		osw.flush();
		osw.close();
	}
}
