import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class QuesDataBase {

	String path;
	String tempPath;
	File file;
	OutputStreamWriter osw;
	Scanner scan;
	int max;
	
	QuesDataBase(String subject, String difficulity) {
		path = "data/questionBase/" + subject + "/" + difficulity + "/question.txt";
		tempPath = "data/questionBase/" + subject + "/" + difficulity + "/temp.txt";
		file =  new File(path);
		getQuesNum();
	}
	
	public void getQuesNum() {
		max = 0;
		try {
			scan = new Scanner(file);
			while(scan.hasNext()) {
				max++;
				scan.nextLine();
			}
			scan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public int[] getRandomNumber(int total) {
		int[] numbers = new int[total];
		for(int i = 0; i < total; i++) {
			numbers[i] = (int)(Math.random() * max);
		}
		return numbers;
	}
	
	
	public void add(String question, String ans1, String ans2, String ans3, String ans4, char answer) throws IOException {
		File tempFile = new File(tempPath);
		tempFile.createNewFile();
		String loader;
		String added = question + "," + ans1 + "," + ans2 + "," + ans3 + "," + ans4 + "," + answer;
		scan = new Scanner(file);
		osw = new OutputStreamWriter(new FileOutputStream(tempPath), StandardCharsets.UTF_8);
		while(scan.hasNext()) {
			loader = scan.nextLine();
			osw.write(loader + "\n");
		}
		osw.write(added);
		osw.flush();
		osw.close();
		scan.close();
		file.delete();
		tempFile.renameTo(file);
	}
	
	public boolean delete(int quesCode) throws IOException {
		if (quesCode > max)
			return false;
		File tempFile = new File(tempPath);
		tempFile.createNewFile();
		String loader;
		scan = new Scanner(file);
		osw = new OutputStreamWriter(new FileOutputStream(tempPath), StandardCharsets.UTF_8);
		for(int i = 1; i <= max; i++) {
			if (i != quesCode) {
				loader = scan.nextLine();
				osw.write(loader + '\n');
			}
		}
		osw.flush();
		osw.close();
		scan.close();
		file.delete();
		tempFile.renameTo(file);
		return true;
	}
	
	public String[] getQuestion(int quesCode) throws IOException {
		int number = 1;
		try {
			scan = new Scanner(file);
			while(scan.hasNext() && number!= quesCode) {
				scan.nextLine();
				number++;
			}
			String[] question = scan.nextLine().split(",");
			scan.close();
			return question;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
