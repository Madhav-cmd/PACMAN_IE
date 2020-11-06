package pacman;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LocationTest {

	//Test to check if the checkLocation functions works as supposed or not.
	
	@Test
	void testCheckLocation() {
		Location loc = new Location();
		assertEquals(true,loc.CheckLocation(0, 0, "NORTH"));
		assertEquals(true,loc.CheckLocation(0, 0, "SOUTH"));
		assertEquals(true,loc.CheckLocation(0, 0, "EAST"));
		assertEquals(true,loc.CheckLocation(0, 0, "WEST"));
		assertEquals(true,loc.CheckLocation(4, 4, "NORTH"));
		assertEquals(true,loc.CheckLocation(4, 4, "SOUTH"));
		assertEquals(true,loc.CheckLocation(4, 4, "EAST"));
		assertEquals(false,loc.CheckLocation(5, 4, "WEST"));
		assertEquals(false,loc.CheckLocation(0, 5, "NORTH"));
		assertEquals(false,loc.CheckLocation(0, -1, "SOUTH"));
		assertEquals(false,loc.CheckLocation(-1, 0, "EAST"));
		assertEquals(false,loc.CheckLocation(9, 9, "EAST"));
	}
	@Test
	void test() {
		
	}

}
