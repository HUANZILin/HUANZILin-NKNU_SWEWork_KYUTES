import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class QuesDataBase {

	String path;
	ArrayList<Integer> unusedNum = null;
	
	QuesDataBase(String subject, String difficulity) {
		this.path = "data/questionBase/" + subject + File.pathSeparator + difficulity + File.pathSeparator;
		readUnusedNumber();
	}
	
	public int[] getRandomNumber(int total) {
		int [] output = new int[total];
		int range = getBiggestCode();
		int randomNum;
		for(int count = 0; count < total; count++) {
			randomNum = (int)(Math.random() * range) + 1;
			while(unusedNum.contains(randomNum))
				randomNum++;
		}
		return output;
	}
	
	public void readUnusedNumber() {
		int number;
		String filePath = path + "unesedNumber.txt";
		try {
		BufferedReader allNumber = new BufferedReader(new FileReader(filePath));
		String[] numberReader = allNumber.readLine().split(" ");
		for(String num : numberReader) {
			number = 0;
			for(int i = 0; i < num.length(); i ++) {
				number *= 10;
				number += (num.charAt(i) - 48);
			}
			unusedNum.add(number);
		}
		allNumber.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void storeUnusedNumber() {
		String filePath = path + "unusedNumber.txt";
		try {
			BufferedWriter write = new BufferedWriter(new FileWriter(filePath));
			String numLoader = unusedNum.toString();
			System.out.println(numLoader);
			write.close();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public int getSmallestCode() {
		int result = 0;
		if(unusedNum.size() == 1) {
			result = unusedNum.get(0);
			unusedNum.remove(0);
			unusedNum.add(result + 1);
		} else {
			int pointer = 0;
			result = unusedNum.get(0);
			for(int i = 1; i < unusedNum.size(); i++) {
				if (result > unusedNum.get(i)) {
					result = unusedNum.get(i);
					pointer = i;
				}
			}
			unusedNum.remove(pointer);
		}
		return result;
	}
	
	public int getBiggestCode() {
		int result = 0;
		if(unusedNum.size() == 1) {
			result = unusedNum.get(0);
		} else {
			result = unusedNum.get(0);
			for(int i = 1; i < unusedNum.size(); i++) {
				if (result < unusedNum.get(i)) {
					result = unusedNum.get(i);
				}
			}
		}
		return result-1;
	}
	
	public void add(String question, String ans1, String ans2, String ans3, String ans4, char answer) throws IOException {
		int quesCode = getSmallestCode();
		String questionPath = path + quesCode + ".txt";
		String outputStr = question + '\n' + ans1 + '\n' + ans2 + '\n' + ans3 + '\n' + ans4 + '\n' + answer;
		BufferedWriter bw = new BufferedWriter(new FileWriter(questionPath));
		System.out.println(outputStr);
		bw.close();
		storeUnusedNumber();
	}
	
	public void delete(int quesCode) throws IOException {
		String questionPath = path + quesCode + ".txt";
		File deleteTarget = new File(questionPath);
		deleteTarget.delete();
		unusedNum.add(quesCode);
		storeUnusedNumber();
	}
	
	public String[] getQuestion(int quesCode) throws IOException {
		String questionPath = path + quesCode + ".txt";
		String [] question = new String [6];
		int counter = 0;
		Scanner scan = new Scanner(new FileReader(questionPath));
		while(scan.hasNext()) {
			question[counter] = scan.nextLine();
			counter ++;
		}
		return question;
	}
}
