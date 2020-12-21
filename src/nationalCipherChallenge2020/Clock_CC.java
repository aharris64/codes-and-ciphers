package nationalCipherChallenge2020;

import java.util.ArrayList;
import java.util.Scanner;

public class Clock_CC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Please select option:\n1: Encrypt\n2: Decrypt\n3: Find key\n4: Exit");
		int option = input.nextInt();
		switch (option) {
		case 1:
			encrypt();
		case 2:
			decrypt();
		case 3:
			find_key();
		case 4:
			System.exit(0);
		default:
			break;
		}
		input.close();
	}

	public static void encrypt() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Key:");
		String outside = input.nextLine();
		String inside = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		System.out.println("Enter Message:");
		String message = input.nextLine();
		input.close();
		ArrayList<String> cipher = new ArrayList<String>();
		int step = 0;
		int short_pointer = 0;
		int long_pointer = 0;
		for (int i = 0; i < message.length(); i++) {
			for (int j = 0; j < inside.length(); j++) {
				if (message.substring(i, i + 1).equals(inside.substring(j, j + 1))) {
					if (i == 0) {
						step = (26 - short_pointer + j) % 26;
						short_pointer = (short_pointer + step) % 26;
						long_pointer = (long_pointer + step) % 28;
					} else if (message.substring(i - 1, i).equals(message.substring(i, i + 1))) {
						long_pointer = (long_pointer + 26) % 28;
					} else {
						step = (26 - short_pointer + j) % 26;
						short_pointer = (short_pointer + step) % 26;
						long_pointer = (long_pointer + step) % 28;
					}
					cipher.add(outside.substring(long_pointer, long_pointer + 1));

				}
			}
		}

		System.out.println("Encrypted Cipher:");
		for (String item : cipher) {
			System.out.print(item);
		}
	}

	public static void decrypt() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Key:");
		String outside = input.nextLine();
		String inside = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		System.out.println("Enter Cipher:");
		String cipher = input.nextLine();
		input.close();
		ArrayList<String> message = new ArrayList<String>();
		ArrayList<Integer> steparr = new ArrayList<Integer>();
		int step = 0;
		int short_pointer = 0;
		int long_pointer = 0;
		for (int i = 0; i < cipher.length(); i++) {
			for (int j = 0; j < outside.length(); j++) {
				if (cipher.substring(i, i + 1).equals(outside.substring(j, j + 1))) {
					step = (28 - long_pointer + j) % 28;
					short_pointer = (short_pointer + step) % 26;
					long_pointer = (long_pointer + step) % 28;
					message.add(inside.substring(short_pointer, short_pointer + 1));
					steparr.add(step);
				}
			}
		}
		
		System.out.println("Deciphered Message:");
		for (String item : message) {
			System.out.print(item);
		}
	}

	public static void find_key() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Cipher:");
		String cipher = input.nextLine();
		String inside = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		System.out.println("Enter Message:");
		String message = input.nextLine();
		input.close();
		String[] key = new String[28];
		int step = 0;
		int short_pointer = 0;
		int long_pointer = 0;
		for (int i = 0; i < message.length(); i++) {
			for (int j = 0; j < inside.length(); j++) {
				if (message.substring(i, i + 1).equals(inside.substring(j, j + 1))) {
					if (i == 0) {
						step = (26 - short_pointer + j) % 26;
						short_pointer = (short_pointer + step) % 26;
						long_pointer = (long_pointer + step) % 28;
					} else if (message.substring(i - 1, i).equals(message.substring(i, i + 1))) {
						long_pointer = (long_pointer + 26) % 28;
					} else {
						step = (26 - short_pointer + j) % 26;
						short_pointer = (short_pointer + step) % 26;
						long_pointer = (long_pointer + step) % 28;
					}
					key[long_pointer] = cipher.substring(i, i + 1);

				}
			}
		}
		
		System.out.println("Key:");
		for (String item : key) {
			System.out.print(item);
		}
	}

}
