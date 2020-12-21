package ciphers;

import java.util.ArrayList;
import java.util.Scanner;

public class Atbash {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Please select option:\n1: Encrypt\n2: Decrypt\n3: Exit");
		int option = input.nextInt();
		switch (option) {
		case 1:
			encrypt();
			System.exit(0);
		case 2:
			decrypt();
			System.exit(0);
		case 3:
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
		input.close();
		ArrayList<Character> message = intoArray(messageInput);
		ArrayList<Character> cipher = encryption(message);
		System.out.println("Encrypted Cipher:");
		for (char item : cipher) {
			System.out.print(item);
		}
	}

	public static void decrypt() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Cipher:");
		String cipherInput = input.nextLine().toUpperCase().replaceAll("[^a-zA-Z ]|\\s", "");
		input.close();
		ArrayList<Character> cipher = intoArray(cipherInput);
		ArrayList<Character> message = decryption(cipher);
		System.out.println("Deciphered Message:");
		for (char item : message) {
			System.out.print(item);
		}
	}

	public static ArrayList<Character> intoArray(String message) {
		ArrayList<Character> newMessage = new ArrayList<Character>();
		for (int i = 0; i < message.length(); i++) {
			newMessage.add(message.charAt(i));
		}
		return newMessage;
	}

	public static ArrayList<Character> encryption(ArrayList<Character> message) {
		ArrayList<Character> cipher = new ArrayList<Character>();
		for(int i = 0; i < message.size(); i++) {
			int mChar = ((int) message.get(i)) - 65;
			char cChar = (char) (26 - mChar + 64);
			cipher.add(cChar);
		}
		return cipher;
	}

	public static ArrayList<Character> decryption(ArrayList<Character> cipher) {
		ArrayList<Character> message = new ArrayList<Character>();
		for(int i = 0; i < cipher.size(); i++) {
			int cChar = ((int) cipher.get(i)) - 65;
			char mChar = (char) (26 - cChar + 64);
			message.add(mChar);
		}
		return message;
	}

}
