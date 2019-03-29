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

import ar.com.SOCompWeb.exception.CompressionException;
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
	public void testCompress1() {
		assertEquals("3A2B5A3B8C5A", compressorService.compress("AAABBAAAAABBBCCCCCCCCAAAAA"));
		assertEquals("1Ñ1M2D1Ñ1W1Ñ", compressorService.compress("ÑMDDÑWÑ"));
		assertEquals("3É", compressorService.compress("ÉÉÉ"));
		assertEquals("1M", compressorService.compress("M"));
	}
	
	

	@Test(expected = CompressionException.class)
	public void testExceptionOnlyLetters() {
		assertEquals("3A2B", compressorService.compress("aaabb"));
		assertEquals("3A2B5A3B8C5A", compressorService.compress("AAABBAAAAABBB34CCCCCCCCAAAAAAAAAAAAAA"));
		assertEquals("3A2B5A3B8C5A", compressorService.compress("%%%%"));
		assertEquals("3A2B5A3B8C5A", compressorService.compress("  "));
		assertEquals("3A2B5A3B8C5A", compressorService.compress(""));
	}

}
