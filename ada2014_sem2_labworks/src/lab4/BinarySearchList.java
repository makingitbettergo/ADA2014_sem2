package lab4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BinarySearchList {
	public ArrayList<String> searchStrings;
	public int result;
	public String key;
	public int searchedTime;

	public BinarySearchList(ArrayList<String> searchStrings, String key) {
		this.searchStrings = searchStrings;
		this.key = key;
	}

	public BinarySearchList() {
		this.searchStrings = new ArrayList<>();

	}

	public int search() {
		int low = 0;
		int high = searchStrings.size();
		while (low <= high) {
			int mid = (high + low) / 2;
			int compareResult = this.key.compareTo(this.searchStrings.get(mid));
			if (compareResult > 0) {
				low = mid + 1;
			} else if (compareResult < 0) {
				high = mid - 1;
			} else {
				this.result = mid;
				return this.result;
			}
		}
		return -1;
	}

	public void readFromFile() {
		System.out.println("readed");
		URL url = getClass().getResource("name.txt");
		File file = new File(url.getPath());
		this.searchStrings.clear();
		try {
			FileInputStream fs = new FileInputStream(file);
			Scanner in = new Scanner(fs);
			while (in.hasNext())
				this.searchStrings.add(in.nextLine());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void writeToFile() {
		URL url = getClass().getResource("name.txt");
		File file = new File(url.getPath());
		try {
			// FileOutputStream fs = new FileOutputStream(file);
			BufferedWriter out = new BufferedWriter(new FileWriter(file));
			for (String string : searchStrings) {
				System.out.println(string);
				out.write(string);
			}
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		BinarySearchList tbs1 = new BinarySearchList();
		System.out.println(tbs1.searchStrings.size());
		tbs1.readFromFile();
		tbs1.key = "James";
//		Collections.sort(tbs1.searchStrings);
//		tbs1.writeToFile();
		 System.out.println(tbs1.search());
	}
}