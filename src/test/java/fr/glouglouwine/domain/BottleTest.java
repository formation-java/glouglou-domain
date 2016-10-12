package fr.glouglouwine.domain;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Test;

public class BottleTest {

	@Test
	public void testBottle() throws Exception {
		//Setup
		Bottle bottle = new Bottle(1, "A", GrapeTypes.CABERNET, "domain","year");
		//Test
		Assert.assertEquals(100, bottle.getQuantity(),0);
	}
	
	@Test
	public void testDrinkConsumein3times() throws Exception {
		//Setup
		Bottle bottle = new Bottle(1, "A", GrapeTypes.CABERNET, "domain","year");
		
		LocalDateTime drinkOpenDate = LocalDateTime.now().minusHours(2);
		bottle.drink(20, drinkOpenDate);
		//Assert
		Assert.assertEquals(null, bottle.getFinishingDate());
		Assert.assertEquals(drinkOpenDate, bottle.getOpeningDate());
		Assert.assertEquals(80, bottle.getQuantity(),0);
		
		bottle.drink(20, LocalDateTime.now().minusHours(1));
		//Assert
		Assert.assertEquals(null, bottle.getFinishingDate());
		Assert.assertEquals(drinkOpenDate, bottle.getOpeningDate());
		Assert.assertEquals(60, bottle.getQuantity(),0);
		
		LocalDateTime drinkCloseDate = LocalDateTime.now().minusHours(2);
		bottle.drink(60, drinkOpenDate);
		//Assert
		Assert.assertEquals(drinkCloseDate, bottle.getFinishingDate());
		Assert.assertEquals(drinkOpenDate, bottle.getOpeningDate());
		Assert.assertEquals(0, bottle.getQuantity(),0);
	}
	
	@Test
	public void testDrinkConsumeAllInOneTime() throws Exception {
		//Setup
		Bottle bottle = new Bottle(1, "A", GrapeTypes.CABERNET, "domain","year");
		LocalDateTime drinkDate = LocalDateTime.now().minusHours(2);
		bottle.drink(100, drinkDate);
		//Assert
		Assert.assertEquals(drinkDate, bottle.getFinishingDate());
		Assert.assertEquals(drinkDate, bottle.getOpeningDate());
		Assert.assertEquals(bottle.getOpeningDate(), bottle.getFinishingDate());
		Assert.assertEquals(0, bottle.getQuantity(),0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testDrinkConsumeToMuch() throws Exception {
		//Setup
		Bottle bottle = new Bottle(1, "A", GrapeTypes.CABERNET, "domain","year");
		bottle.drink(200, LocalDateTime.now());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testDrinkConsumeNegative() throws Exception {
		//Setup
		Bottle bottle = new Bottle(1, "A", GrapeTypes.CABERNET, "domain","year");
		bottle.drink(-1, LocalDateTime.now());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testDrinkBeforeOpening() throws Exception {
		//Setup
		Bottle bottle = new Bottle(1, "A", GrapeTypes.CABERNET, "domain","year");
		bottle.drink(50, LocalDateTime.now());
		//Test
		bottle.drink(20, LocalDateTime.now().minusMonths(1));
	}

}
