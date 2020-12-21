package ciphers;

import java.util.ArrayList;
import java.util.Scanner;

public class One_Time_Pad_XOR {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Please select option:\n1: Encrypt\n2: Decrypt\n3: Find Key\n4: Exit");
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
		String messageInput = input.nextLine();
		ArrayList<Character> message = intoArray(messageInput);
		ArrayList<Character> key = randomKey(message.size(), message);
		input.close();
		System.out.println("Key:");
		for (char item : key) {
			System.out.print(item);
		}
		System.out.println();
		ArrayList<Character> cipher = encryption(key, message);
		System.out.println("Encrypted Cipher:");
		for (char item : cipher) {
			System.out.print(item);
		}
		
	}

	public static void decrypt() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Cipher:");
		String cipherInput = input.nextLine();
		System.out.println("Enter Key:");
		String keyInput = input.nextLine();
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
		String messageInput = input.nextLine();
		System.out.println("Enter Cipher:");
		String cipherInput = input.nextLine();
		input.close();
		ArrayList<Character> message = intoArray(messageInput);
		ArrayList<Character> cipher = intoArray(cipherInput);
		ArrayList<Character> key = key(message, cipher);
		System.out.println("Key:");
		for (char item : key) {
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

	public static ArrayList<Character> randomKey(int size, ArrayList<Character> message) {
		ArrayList<Character> key = new ArrayList<Character>();
		for(int i = 0; i < size; i++) {
			boolean valid = false;
			while(valid == false) {
				int num = (int) (Math.random() * (126 - 32 + 1) + 32);
				if(valid(num, i, message)) {
					key.add((char) num);
					break;
				}
			}
			
		}
		return key;
	}
	
	public static ArrayList<Character> encryption(ArrayList<Character> key, ArrayList<Character> message) {
		ArrayList<Character> cipher = new ArrayList<Character>();
		for(int i = 0; i < message.size(); i++) {
			String messageBinary = Integer.toBinaryString((int) message.get(i));
			if(messageBinary.length() == 6) {
				messageBinary = "0" + messageBinary;
			}
			String keyBinary = Integer.toBinaryString((int) key.get(i));
			if(keyBinary.length() == 6) {
				keyBinary = "0" + keyBinary;
			}
			String cipherBinary = xor(messageBinary, keyBinary);
			cipher.add((char) Integer.parseInt(cipherBinary,2));
		}
		return cipher;
	}

	public static ArrayList<Character> decryption(ArrayList<Character> key, ArrayList<Character> cipher) {
		ArrayList<Character> message = new ArrayList<Character>();
		for(int i = 0; i < cipher.size(); i++) {
			String cipherBinary = Integer.toBinaryString((int) cipher.get(i));
			if(cipherBinary.length() == 6) {
				cipherBinary = "0" + cipherBinary;
			}
			String keyBinary = Integer.toBinaryString((int) key.get(i));
			if(keyBinary.length() == 6) {
				keyBinary = "0" + keyBinary;
			}
			String messageBinary = xor(cipherBinary, keyBinary);
			message.add((char) Integer.parseInt(messageBinary,2));
		}
		return message;
	}

	public static ArrayList<Character> key(ArrayList<Character> message, ArrayList<Character> cipher) {
		ArrayList<Character> key = new ArrayList<Character>();
		for(int i = 0; i < message.size(); i++) {
			String messageBinary = Integer.toBinaryString((int) message.get(i));
			if(messageBinary.length() == 6) {
				messageBinary = "0" + messageBinary;
			}
			String cipherBinary = Integer.toBinaryString((int) cipher.get(i));
			if(cipherBinary.length() == 6) {
				cipherBinary = "0" + cipherBinary;
			}
			String keyBinary = xor(messageBinary, cipherBinary);
			key.add((char) Integer.parseInt(keyBinary,2));
		}
		return key;
	}
	
	public static Boolean valid(int num, int i, ArrayList<Character> message) {
		String messageBinary = Integer.toBinaryString((int) message.get(i));
		if(messageBinary.length() == 6) {
			messageBinary = "0" + messageBinary;
		}
		String keyBinary = Integer.toBinaryString(num);
		if(keyBinary.length() == 6) {
			keyBinary = "0" + keyBinary;
		}
		String cipherBinary = xor(messageBinary, keyBinary);
		if(Integer.parseInt(cipherBinary,2) < 32 || Integer.parseInt(cipherBinary,2) > 126) {
			return false;
		}
		return true;
	}
	
	public static String xor(String message, String key) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < message.length(); i++) {
			sb.append((message.charAt(i) ^ key.charAt(i)));
		}    
		return sb.toString();
	}
}
