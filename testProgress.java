import java.io.*;
import java.util.Scanner;

public class testProgress {

	String subject;
	String title;
	String testPath;
	String ansPath;
	int timeLimit;
	int total;
	Scanner scan;
	
	testProgress(String subject, String title) throws IOException {
		this.subject = subject;
		this.title = title;
		testPath = "data/test/" + subject + "/" + title + ".txt";
		File file = new File(testPath);
		scan = new Scanner(file);
		scan.nextLine();
		timeLimit = toInt(scan.nextLine());
		testPath = scan.nextLine();
		ansPath = scan.nextLine();
		total = toInt(scan.nextLine());
		scan.close();
	}
	
	public void startQuiz() {
		TestStartGUI test = new TestStartGUI();
		test.start(total, testPath, ansPath);
		
	}
	
	public int toInt(String number) {
		int result = 0;
		for(int i = 0; i < number.length(); i++) {
			result *= 10;
			result += (number.charAt(i) - 48);
		}
		return result;
	}
}