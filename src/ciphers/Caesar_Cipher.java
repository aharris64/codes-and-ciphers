package ciphers;

import java.util.ArrayList;
import java.util.Scanner;

public class Caesar_Cipher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Please select option:\n1: Encrypt\n2: Decrypt\n3: Find Shift\n4: Brute Force (Unknown Shift)\n5: Exit");
		int option = input.nextInt();
		switch (option) {
		case 1:
			encrypt();
			System.exit(0);
		case 2:
			decrypt();
			System.exit(0);
		case 3:
			findShift();
			System.exit(0);
		case 4:
			bruteForce();
			System.exit(0);
		case 5:
			System.exit(0);
		default:
			break;
		}
		input.close();
	}

	public static void encrypt() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Shift (Enter '0' if you want a random shift):");
		int shift = Integer.parseInt(input.nextLine());
		if (shift == 0) {
			shift = (int)(Math.random() * (26 - 1 + 1) + 1);
		}
		System.out.println("Enter Message:");
		String messageInput = input.nextLine().toUpperCase().replaceAll("[^a-zA-Z ]|\\s", "");
		input.close();
		ArrayList<Character> message = intoArray(messageInput);
		ArrayList<Character> cipher = new ArrayList<Character>();
		cipher = convertToString(addShift(shift, convertToNum(message)));
		System.out.println("Encrypted Cipher:");
		for (char item : cipher) {
			System.out.print(item);
		}
		System.out.println();
		System.out.println("(Shift = " + shift + ")");
	}

	public static void decrypt() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Shift (Enter 'random' if you want a random shift):");
		int shift = Integer.parseInt(input.nextLine());
		System.out.println("Enter Cipher:");
		String cipherInput = input.nextLine().toUpperCase().replaceAll("[^a-zA-Z ]|\\s", "");
		input.close();
		ArrayList<Character> cipher = intoArray(cipherInput);
		ArrayList<Character> message = new ArrayList<Character>();
		message = convertToString(subShift(shift, convertToNum(cipher)));
		System.out.println("Deciphered Message:");
		for (char item : message) {
			System.out.print(item);
		}
	}

	public static void findShift() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Message:");
		String messageInput = input.nextLine().toUpperCase().replaceAll("[^a-zA-Z ]|\\s", "");
		System.out.println("Enter Cipher:");
		String cipherInput = input.nextLine().toUpperCase().replaceAll("[^a-zA-Z ]|\\s", "");
		input.close();
		ArrayList<Character> message = intoArray(messageInput);
		ArrayList<Character> cipher = intoArray(cipherInput);
		int shift = compareShift(message, cipher);
		if (shift == 100) {
			System.out.println("Not a Caesar Cipher");
		} else {
			System.out.println(shift);
		}
	}
	
	public static void bruteForce() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Cipher:");
		String cipherInput = input.nextLine().toUpperCase().replaceAll("[^a-zA-Z ]|\\s", "");
		input.close();
		ArrayList<Character> cipher = intoArray(cipherInput);
		System.out.println("All possible shifts:");
		for(int i = 1; i < 26; i ++) {
			ArrayList<Character> message = new ArrayList<Character>();
			message = convertToString(subShift(i, convertToNum(cipher)));
			for (char item : message) {
				System.out.print(item);
			}
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

	public static ArrayList<Integer> convertToNum(ArrayList<Character> message) {
		ArrayList<Integer> intArray = new ArrayList<Integer>();
		for (char item : message) {
			int num = (int) item;
			intArray.add(num);
		}
		return intArray;
	}

	public static ArrayList<Character> convertToString(ArrayList<Integer> message) {
		ArrayList<Character> charArray = new ArrayList<Character>();
		for (int num : message) {
			char letter = (char) num;
			charArray.add(letter);
		}
		return charArray;
	}

	public static ArrayList<Integer> addShift(int key, ArrayList<Integer> message) {
		ArrayList<Integer> newMessage = new ArrayList<Integer>();
		for (int num : message) {
			int newNum = num + key;
			if (newNum > 90) {
				newNum -= 26;
			}
			newMessage.add(newNum);
		}
		return newMessage;
	}

	public static ArrayList<Integer> subShift(int key, ArrayList<Integer> message) {
		ArrayList<Integer> newMessage = new ArrayList<Integer>();
		for (int num : message) {
			int newNum = num - key;
			if (newNum < 65) {
				newNum += 26;
			}
			newMessage.add(newNum);
		}
		return newMessage;
	}

	public static int compareShift(ArrayList<Character> message, ArrayList<Character> cipher) {
		ArrayList<Integer> messageInt = convertToNum(message);
		ArrayList<Integer> cipherInt = convertToNum(cipher);
		ArrayList<Integer> shifts = new ArrayList<Integer>();
		for (int i = 0; i < message.size(); i++) {
			int shift = 0;
			shift = cipherInt.get(i) - messageInt.get(i);
			if(shift < 0) {
				shift+= 26;
			}
			shifts.add(shift);
		}
		System.out.println();
		Boolean caesar = true;
		for (int num : shifts) {
			if (shifts.get(0) != num) {
				caesar = false;
			}
		}
		if (caesar == false) {
			return 100;
		}
		return shifts.get(0);
	}

}
