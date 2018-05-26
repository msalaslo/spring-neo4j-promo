package com.msl.neo4j.promo.component;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductoComponentTest {
	
	@Autowired
	ProductoComponent component;
	
	@Before
	public void setUp() {

	}

	@Test
	public void generateReferencesFile() {
		component.generateReferencesFile();
	}
	
	@Test
	public void generateIdsFile() {
		component.generateIdsFile();
	}

}