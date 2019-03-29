package ar.com.SOCompWeb;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import ar.com.SOCompWeb.entity.business.CompressionBasicCriteria;
import ar.com.SOCompWeb.entity.business.CompressionCriteria;
import ar.com.SOCompWeb.entity.business.CompressionExtraCriteria;
import ar.com.SOCompWeb.entity.business.Compressor;
import ar.com.SOCompWeb.exception.CompressionException;

@RunWith(SpringRunner.class)
public class CompressorTest {

	private Compressor compressor;
	private CompressionCriteria compressionBasicCriteria;
	private CompressionCriteria compressionExtraCriteria;

	@Before
	public void setUp() {
		compressor = new Compressor();
		compressionBasicCriteria = new CompressionBasicCriteria();
		compressionExtraCriteria = new CompressionExtraCriteria();

	}

	@Test
	public void testCompressorWithBasicCriteria() {
		assertEquals("3A4L", compressor.compress("AAALLLL", compressionBasicCriteria));
		assertEquals("1J", compressor.compress("J", compressionBasicCriteria));
		assertEquals("1P2O", compressor.compress("POO", compressionBasicCriteria));

	}

	@Test
	public void testCompressorWithExtraCriteria() {
		assertEquals("5A", compressor.compress("AAaaA", compressionExtraCriteria));
		assertEquals("2A5Y", compressor.compress("AayyYYy", compressionExtraCriteria));
		assertEquals("4A2H", compressor.compress("aaaahh", compressionExtraCriteria));
	}

	@Test(expected = CompressionException.class)
	public void testCompressorExeptions() {
		compressor.compress("SSSfdDF", compressionBasicCriteria);
		compressor.compress("RDddDE", compressionBasicCriteria);
		compressor.compress("RR3FF", compressionBasicCriteria);
		compressor.compress("trrTTR$sd", compressionExtraCriteria);
		compressor.compress("sdd123r", compressionExtraCriteria);

	}

}
