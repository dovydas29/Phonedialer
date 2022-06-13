/**
 * Author Dovydas Pliauga
 */
package sample.app;

public class Phonedialer {

	private static final Integer[][] keyPad = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { -1, 0, -1 } };

	public static boolean isEasyToRead(String phoneNumberStr) {
		boolean isEasyToRead = false;

		if (phoneNumberValid(phoneNumberStr)) {
			final char[] numbers = phoneNumberStr.replaceAll("\\D+", "").toCharArray();
			Integer previousNumber = null;
			terminate: for (int i = 0; i < numbers.length; i++) {
				int number = Character.getNumericValue(numbers[i]);
				nextNumber: if (previousNumber != null) {
					// if next number same as previous number skip checking since we now current
					// number is easy to dial
					if (previousNumber == number) {
						isEasyToRead = true;
						break nextNumber;
					}

					for (int y = 0; y < 4; y++) {
						for (int x = 0; x < 3; x++) {
							Integer keyPadNumber = keyPad[y][x];
							if (keyPadNumber == number) {
								// vertical comparison
								if (verticallyAdjacent(y, x, previousNumber)) {
									isEasyToRead = true;
									break nextNumber;
									// horizontal comparison
								} else if (horizontallyAdjacent(y, x, previousNumber)) {
									isEasyToRead = true;
									break nextNumber;
									// diagnol comparison
								} else if (diagonallyAdjacent(y, x, previousNumber)) {
									isEasyToRead = true;
									break nextNumber;
								}
								isEasyToRead = false;
								break terminate;
							}
						}
					}
				}
				previousNumber = number;
			}
		} else {
			throw new IllegalArgumentException("Invalid phone numebr format.");
		}
		return isEasyToRead;
	}

	// vertical comparison
	private static boolean verticallyAdjacent(int y, int x, Integer previousNumber) {
		if ((y > 0 && keyPad[y - 1][x] == previousNumber) || (y < 3 && keyPad[y + 1][x] == previousNumber)) {
			return true;
		}
		return false;
	}

	// vertical comparison
	private static boolean horizontallyAdjacent(int y, int x, Integer previousNumber) {
		if ((x > 0 && keyPad[y][x - 1] == previousNumber) || (x < 2 && keyPad[y][x + 1] == previousNumber)) {
			return true;
		}
		return false;
	}

	// diagonal comparison
	private static boolean diagonallyAdjacent(int y, int x, int previousNumber) {
		if ((x > 0 && y > 0 && keyPad[y - 1][x - 1] == previousNumber)
				|| (x < 2 && y < 3 && keyPad[y + 1][x + 1] == previousNumber)
				|| (x < 2 && y > 0 && keyPad[y - 1][x + 1] == previousNumber)
				|| (x > 0 && y < 3 && keyPad[y + 1][x - 1] == previousNumber)) {
			return true;
		}
		return false;
	}

	private static boolean phoneNumberValid(String phoneNumberStr) {
		if (phoneNumberStr != null && phoneNumberStr.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}")) {
			return true;
		}
		return false;

	}

}
