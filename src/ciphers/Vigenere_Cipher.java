package ciphers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Vigenere_Cipher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Please select option:\n1: Encrypt\n2: Decrypt\n3: Find Shift\n4: Exit");
		int option = input.nextInt();
		switch (option) {
		case 1:
			encrypt();
			System.exit(0);
		case 2:
			decrypt();
			System.exit(0);
		case 3:
			findKey();
			System.exit(0);
		case 4:
			System.exit(0);
		default:
			break;
		}
		input.close();
	}

	public static void encrypt() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Message:");
		String messageInput = input.nextLine().toUpperCase().replaceAll("[^a-zA-Z ]|\\s", "");
		ArrayList<Character> message = intoArray(messageInput);
		System.out.println("Enter Key (Enter '0' if you want a random key - One Time Pad):");
		String keyInput = input.nextLine().toUpperCase();
		input.close();
		ArrayList<Character> key = new ArrayList<Character>();
		if (keyInput.length() == 1 && keyInput.charAt(0) == '0') {
			key = randomKey(message.size());
			System.out.println("Key:");
			for (char item : key) {
				System.out.print(item);
			}
			System.out.println();
		} else {
			key = intoArray(keyInput.replaceAll("[^a-zA-Z ]|\\s", ""));
		}
		ArrayList<Character> cipher = encryption(key, message);
		System.out.println("Encrypted Cipher:");
		for (char item : cipher) {
			System.out.print(item);
		}
	}

	public static void decrypt() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Cipher:");
		String cipherInput = input.nextLine().toUpperCase().replaceAll("[^a-zA-Z ]|\\s", "");
		System.out.println("Enter Key:");
		String keyInput = input.nextLine().toUpperCase();
		input.close();
		ArrayList<Character> key = intoArray(keyInput);
		ArrayList<Character> cipher = intoArray(cipherInput);
		ArrayList<Character> message = decryption(key, cipher);
		System.out.println("Decrypted Message:");
		for (char item : message) {
			System.out.print(item);
		}
	}

	public static void findKey() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Message:");
		String messageInput = input.nextLine().toUpperCase().replaceAll("[^a-zA-Z ]|\\s", "");
		System.out.println("Enter Cipher:");
		String cipherInput = input.nextLine().toUpperCase().replaceAll("[^a-zA-Z ]|\\s", "");
		input.close();
		ArrayList<Character> message = intoArray(messageInput);
		ArrayList<Character> cipher = intoArray(cipherInput);
		ArrayList<Character> key = key(message, cipher);
		System.out.println("Key:");
		for (char item : key) {
			System.out.print(item);
		}
	}

	public static ArrayList<Character> randomKey(int size) {
		ArrayList<Character> key = new ArrayList<Character>();
		for (int i = 0; i < size; i++) {
			int num = (int) (Math.random() * (90 - 65 + 1) + 65);
			key.add((char) num);
		}
		return key;
	}

	public static ArrayList<Character> intoArray(String message) {
		ArrayList<Character> newMessage = new ArrayList<Character>();
		for (int i = 0; i < message.length(); i++) {
			newMessage.add(message.charAt(i));
		}
		return newMessage;
	}

	public static char[][] vigenereSquare() {
		char[][] square = new char[26][26];
		File file = new File("C:\\Users\\anna\\eclipse-workspace\\Cipher\\src\\ciphers\\Vigenere Square");
		try {
			Scanner reader = new Scanner(file);
			int j = 0;
			while (reader.hasNextLine()) {
				String line = reader.nextLine();
				for (int i = 0; i < line.length(); i++) {
					square[j][i] = line.charAt(i);
				}
				j++;
			}
			reader.close();

		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		return square;

	}

	public static ArrayList<Character> encryption(ArrayList<Character> key, ArrayList<Character> message) {
		ArrayList<Character> cipher = new ArrayList<Character>();
		char[][] square = vigenereSquare();
		for (int i = 0; i < message.size(); i += key.size()) {
			for (int j = 0; j < key.size(); j++) {
				int row = ((int) key.get(j)) - 65;
				if (i + j < message.size()) {
					int column = ((int) message.get(i + j)) - 65;
					cipher.add(square[row][column]);
				}
			}
		}
		return cipher;
	}

	public static ArrayList<Character> decryption(ArrayList<Character> key, ArrayList<Character> cipher) {
		ArrayList<Character> message = new ArrayList<Character>();
		char[][] square = vigenereSquare();
		for (int i = 0; i < cipher.size(); i += key.size()) {
			for (int j = 0; j < key.size(); j++) {
				int row = ((int) key.get(j)) - 65;
				for (int k = 0; k < square[row].length; k++) {
					if (i + j < cipher.size()) {
						if (square[row][k] == cipher.get(i + j)) {
							message.add(square[0][k]);
						}
					}
				}
			}
		}
		return message;
	}

	public static ArrayList<Character> key(ArrayList<Character> message, ArrayList<Character> cipher) {
		ArrayList<Character> key = new ArrayList<Character>();
		char[][] square = vigenereSquare();
		for (int i = 0; i < message.size(); i++) {
			int column = ((int) message.get(i)) - 65;
			for (int j = 0; j < square.length; j++) {
				if (square[j][column] == cipher.get(i)) {
					key.add(square[j][0]);
				}
			}
		}
		return key;
	}
}
