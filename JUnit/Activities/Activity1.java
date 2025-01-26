package junitActivities;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Activity1 {

	static ArrayList<String> list;

	@BeforeEach
	public void setUp() throws Exception {
		list = new ArrayList<String>();
		list.add("alpha");
		list.add("beta");
	}

	@Test
	public void insertTest() {

		assertEquals(2, list.size(), "Wrong Size");
		list.add(2, "gamma");
		assertEquals(3, list.size(), "Wrong Size");

		assertEquals("alpha", list.get(0), "Wrong element");
		assertEquals("beta", list.get(1), "Wrong element");
		assertEquals("gamma", list.get(2), "Wrong element");
	}

	@Test
	public void replaceTest() {

		list.set(1, "zeta");
		assertEquals(2, list.size(), "Wrong size");

		assertEquals("alpha", list.get(0), "Wrong element");
		assertEquals("zeta", list.get(1), "Wrong element");
	}
}
