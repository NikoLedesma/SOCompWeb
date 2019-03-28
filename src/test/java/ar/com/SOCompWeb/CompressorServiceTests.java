package ar.com.SOCompWeb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import ar.com.SOCompWeb.service.CompressorService;
import ar.com.SOCompWeb.service.CompressorServiceImpl;

@RunWith(SpringRunner.class)

public class CompressorServiceTests {
	
	@TestConfiguration
	static class CartServiceImplTestContextConfiguration {
		
		@Bean
		public CompressorService cartService() {
			return new CompressorServiceImpl();
		}

	}
	
	@Autowired
	private CompressorService compressorService;
	
	@Before
	public void setUp() {
	}

	@Test
	public void testCompress() {
		assertEquals("3A2B5A3B8C5A",compressorService.compress("AAABBAAAAABBBCCCCCCCCAAAAA"));
	}
	
	@Test
	public void sCompress() {
		assertNotEquals("3A2B5A3B8C5A",compressorService.compress("AAABBAAAAABBBCCCCCCCCAAAAAAAAAAAAAA"));
	}

	
	@Test
	public void testCharacters() {
		assertNotEquals("3A2B5A3B8C5A",compressorService.compress("AAABBAAAAABBB34CCCCCCCCAAAAAAAAAAAAAA"));
	}
	
	
}
