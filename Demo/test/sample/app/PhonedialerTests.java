/**
 * Author Dovydas Pliauga
 */
package sample.app;

import org.junit.Assert;
import org.junit.Test;

public class PhonedialerTests {

	@Test
	public void phoneNumberEasyToDial() {
		Assert.assertTrue(Phonedialer.isEasyToRead("585-953-2111"));
		Assert.assertTrue(Phonedialer.isEasyToRead("888-999-5555"));
	}

	@Test
	public void phoneNumberNotEasyToDial() {
		Assert.assertFalse(Phonedialer.isEasyToRead("408-998-4321"));
		Assert.assertFalse(Phonedialer.isEasyToRead("123-456-7890"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void phoneNumberFormatIncorrect() {
		Assert.assertFalse(Phonedialer.isEasyToRead("5859532111"));
	}
}
