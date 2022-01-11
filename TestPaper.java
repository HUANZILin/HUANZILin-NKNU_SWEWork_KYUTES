import java.io.*;

public class TestPaper {

	String testTitle;
	String subject;
	String filePath;
	QuesDataBase databaseEasy;
	QuesDataBase databaseNormal;
	QuesDataBase databaseDiff;
	
	public TestPaper(String subject) {
		this.subject = subject;
		this.databaseEasy = new QuesDataBase(subject,"easy");
		this.databaseNormal = new QuesDataBase(subject,"normal");
		this.databaseDiff = new QuesDataBase(subject,"diff");
		filePath = "data/testPaper/" + subject;
	}
	
	public String create(String testTitle, int easy, int normal, int diff) throws IOException {
		String quizPath = filePath +  "/question/" + testTitle + ".txt";
		String answerPath = filePath +  "/answer/" + testTitle + ".txt";
		String answer = "";
		answer = answer + getEasy(quizPath, easy);
		answer = answer + getNormal(quizPath, normal);
		answer = answer + getDiff(quizPath, diff);
		storeAnswer(answer, answerPath);
		return quizPath;
	}
	
	public void create(int quesNum, int easy, int normal, int diff) throws IOException {
		String practicePath = "data/Temp/TempTest.txt";
		String answer = "";
		answer = answer + getEasy(practicePath, easy);
		answer = answer + getNormal(practicePath, normal);
		answer = answer + getDiff(practicePath, diff);
		storeAnswer(answer, "data/Temp/TempAns.txt");
	}
	
	public String getEasy(String path, int number) throws IOException {
		String answer = "";
		String [] question = new String [6];
		int [] questionNumber = databaseEasy.getRandomNumber(number);
		BufferedWriter write = new BufferedWriter(new FileWriter(path));
		for(Integer n : questionNumber) {
			question = databaseEasy.getQuestion(n);
			System.out.println(question[0]);
			System.out.println(question[1]);
			System.out.println(question[2]);
			System.out.println(question[3]);
			System.out.println(question[4]);
			answer = answer + question[5];
		}
		write.close();
		return answer;
	}
	
	public String getNormal(String path, int number) throws IOException {
		String answer = "";
		String [] question = new String [6];
		int [] questionNumber = databaseEasy.getRandomNumber(number);
		BufferedWriter write = new BufferedWriter(new FileWriter(path));
		for(Integer n : questionNumber) {
			question = databaseEasy.getQuestion(n);
			System.out.println(question[0]);
			System.out.println(question[1]);
			System.out.println(question[2]);
			System.out.println(question[3]);
			System.out.println(question[4]);
			answer = answer + question[5];
		}
		write.close();
		return answer;
	}
	
	public String getDiff(String path, int number) throws IOException {
		String answer = "";
		String [] question = new String [6];
		int [] questionNumber = databaseDiff.getRandomNumber(number);
		BufferedWriter write = new BufferedWriter(new FileWriter(path));
		for(Integer n : questionNumber) {
			question = databaseEasy.getQuestion(n);
			System.out.println(question[0]);
			System.out.println(question[1]);
			System.out.println(question[2]);
			System.out.println(question[3]);
			System.out.println(question[4]);
			answer = answer + question[5];
		}
		write.close();
		return answer;
	}
			
	public void storeAnswer(String answer, String path) {
		try {
			File ansFile = new File(path);
			ansFile.createNewFile();
			BufferedWriter writer = new BufferedWriter(new FileWriter(path));
			System.out.println(answer);
			writer.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
