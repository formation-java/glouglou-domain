package fr.glouglouwine.domain;

import org.junit.Test;

public class BottleTest {

	@Test
	public void testBottle() throws Exception {
		//Setup
		Bottle bottle = new Bottle(1, "A", GrapeTypes.CABERNET, "domain","year");
		// TODO : test quantity value
	}
	
	@Test
	public void testDrinkConsumein3times() throws Exception {
		//Setup
		Bottle bottle = new Bottle(1, "A", GrapeTypes.CABERNET, "domain","year");

		// TODO : drink the bottle in 3 times, test quantity, opening & finishing dates
	}
	
	@Test
	public void testDrinkConsumeAllInOneTime() throws Exception {
		//Setup
		Bottle bottle = new Bottle(1, "A", GrapeTypes.CABERNET, "domain","year");

		// TODO : drink the whole bottle in one time
	}
	
	@Test
	public void testDrinkConsumeToMuch() throws Exception {
		//Setup
		Bottle bottle = new Bottle(1, "A", GrapeTypes.CABERNET, "domain","year");

		// TODO : drink more than a bottle with one bottle...
        // use @Test(expected=IllegalArgumentException.class)
	}
	
	@Test
	public void testDrinkConsumeNegative() throws Exception {
		//Setup
		Bottle bottle = new Bottle(1, "A", GrapeTypes.CABERNET, "domain","year");

		// TODO : try to drink a negative quantity
	}
	
	@Test
	public void testDrinkBeforeOpening() throws Exception {
		//Setup
		Bottle bottle = new Bottle(1, "A", GrapeTypes.CABERNET, "domain","year");

		// TODO : drink a first time, and try to drink a second time with a date which is before the opening
	}

}
