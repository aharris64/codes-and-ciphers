package ciphers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Frequency_Analysis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Cipher:");
		String cipherInput = input.nextLine().toUpperCase().replaceAll("[^a-zA-Z ]|\\s", "");
		input.close();
		ArrayList<Character> cipher = intoArray(cipherInput);
		HashMap<Character, Integer> count = freqCipher(cipher);
		HashMap<Character, Double> percent = freqPercent(count, cipher);
		HashMap<Character, Double> english = englishFreq();

		String[][] table = finalArray(count, percent, english, 1);
		for(int i = 0; i < 4; i++) {
			System.out.print(table[0][i] + "	");
		}
		System.out.println();
		for (int i = 1; i < 27; i++) {
			System.out.print(table[i][0] + ":	");
			System.out.print(table[i][1] + "	");
			System.out.print(table[i][2] + "	");
			System.out.print(table[i][3]);
			System.out.println();
		}
	}

	public static ArrayList<Character> intoArray(String message) {
		ArrayList<Character> newMessage = new ArrayList<Character>();
		for (int i = 0; i < message.length(); i++) {
			newMessage.add(message.charAt(i));
		}
		return newMessage;
	}

	public static HashMap<Character, Integer> freqCipher(ArrayList<Character> cipher) {
		HashMap<Character, Integer> letters = new HashMap<Character, Integer>();
		for (int i = 65; i <= 90; i++) {
			letters.put((char) i, 0);
		}
		for (char letter : cipher) {
			switch (letter) {
			case 'A':
				letters.put('A', letters.get('A') + 1);
				break;
			case 'B':
				letters.put('B', letters.get('B') + 1);
				break;
			case 'C':
				letters.put('C', letters.get('C') + 1);
				break;
			case 'D':
				letters.put('D', letters.get('D') + 1);
				break;
			case 'E':
				letters.put('E', letters.get('E') + 1);
				break;
			case 'F':
				letters.put('F', letters.get('F') + 1);
				break;
			case 'G':
				letters.put('G', letters.get('G') + 1);
				break;
			case 'H':
				letters.put('H', letters.get('H') + 1);
				break;
			case 'I':
				letters.put('I', letters.get('I') + 1);
				break;
			case 'J':
				letters.put('J', letters.get('J') + 1);
				break;
			case 'K':
				letters.put('K', letters.get('K') + 1);
				break;
			case 'L':
				letters.put('L', letters.get('L') + 1);
				break;
			case 'M':
				letters.put('M', letters.get('M') + 1);
				break;
			case 'N':
				letters.put('N', letters.get('N') + 1);
				break;
			case 'O':
				letters.put('O', letters.get('O') + 1);
				break;
			case 'P':
				letters.put('P', letters.get('P') + 1);
				break;
			case 'Q':
				letters.put('Q', letters.get('Q') + 1);
				break;
			case 'R':
				letters.put('R', letters.get('R') + 1);
				break;
			case 'S':
				letters.put('S', letters.get('S') + 1);
				break;
			case 'T':
				letters.put('T', letters.get('T') + 1);
				break;
			case 'U':
				letters.put('U', letters.get('U') + 1);
				break;
			case 'V':
				letters.put('V', letters.get('V') + 1);
				break;
			case 'W':
				letters.put('W', letters.get('W') + 1);
				break;
			case 'X':
				letters.put('X', letters.get('X') + 1);
				break;
			case 'Y':
				letters.put('Y', letters.get('Y') + 1);
				break;
			case 'Z':
				letters.put('Z', letters.get('Z') + 1);
				break;
			default:
				break;
			}
		}
		return letters;
	}

	public static HashMap<Character, Double> freqPercent(HashMap<Character, Integer> freq,
			ArrayList<Character> cipher) {
		HashMap<Character, Double> percent = new HashMap<Character, Double>();
		int size = cipher.size();
		for (char letter : freq.keySet()) {
			percent.put(letter, (double) freq.get(letter) / size * 100);
		}
		return percent;
	}

	public static double round(double value, int places) {
		long factor = (long) Math.pow(10, places);
		value = value * factor;
		long tmp = Math.round(value);
		return (double) tmp / factor;
	}

	public static HashMap<Character, Double> englishFreq() {
		HashMap<Character, Double> freq = new HashMap<Character, Double>();
		File file = new File("C:\\Users\\anna\\eclipse-workspace\\Cipher\\src\\ciphers\\English Frequencies");
		try {
			Scanner reader = new Scanner(file);
			while (reader.hasNextLine()) {
				char letter = reader.next().toUpperCase().charAt(0);
				freq.put(letter, 0.0);
				double percent = reader.nextDouble();
				freq.put(letter, percent);
			}
			reader.close();

		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		return freq;

	}

	public static String[][] finalArray(HashMap<Character, Integer> count, HashMap<Character, Double> percent,
			HashMap<Character, Double> english, int round) {
		String[][] table = new String[27][4];
		table[0][0] = "Letter:";
		table[0][1] = "Count:";
		table[0][2] = "%:";
		table[0][3] = "English:";
		for (int i = 1; i < 27; i++) {
			char letter = (char) (64 + i);
			table[i][0] = Character.toString(letter);
			table[i][1] = Integer.toString(count.get(letter));
			table[i][2] = Double.toString(round(percent.get(letter), round));
			table[i][3] = Double.toString(round(english.get(letter), round));
		}
		return table;
	}

}
