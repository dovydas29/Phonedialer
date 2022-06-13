/**
 * Author Dovydas Pliauga
 */
package sample.app;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {

		// read phone number
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a phone number: ");
		final String phoneNumber = sc.nextLine();
		sc.close();

		// process phone number
		boolean isEasyToRead = Phonedialer.isEasyToRead(phoneNumber);
		System.out.println(
				"Phone number " + phoneNumber + " is " + (isEasyToRead ? " easy to dial" : "not easy to dial"));
	}
}
