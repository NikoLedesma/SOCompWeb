package ar.com.SOCompWeb;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import ar.com.SOCompWeb.entity.SOText;
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
		assertEquals("3A2B5A3B8C5A",
				compressorService.compress(new SOText("AAABBAAAAABBBCCCCCCCCAAAAA")).getCompressed());
		assertEquals("1Ñ1M2D1Ñ1W1Ñ", compressorService.compress(new SOText("ÑMDDÑWÑ")).getCompressed());
		assertEquals("3É", compressorService.compress(new SOText("ÉÉÉ")).getCompressed());
		assertEquals("1M", compressorService.compress(new SOText("M")).getCompressed());
	}

	@Test(expected = CompressionException.class)
	public void testExceptionOnlyLetters() {
		assertEquals("3A2B", compressorService.compress(new SOText("aaabb")).getCompressed());
		assertEquals("5A", compressorService.compress(new SOText("AAA1AA")).getCompressed());
		assertEquals("3A2B5A3B8C5A", compressorService.compress(new SOText("%%%%")).getCompressed());
		assertEquals("3A2B5A3B8C5A", compressorService.compress(new SOText("  ")).getCompressed());
		assertEquals("3A2B5A3B8C5A", compressorService.compress(new SOText("")).getCompressed());
	}

}
