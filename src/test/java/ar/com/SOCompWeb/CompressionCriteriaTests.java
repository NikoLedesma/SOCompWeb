package ar.com.SOCompWeb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import ar.com.SOCompWeb.entity.SOText;
import ar.com.SOCompWeb.entity.business.CompressionBasicCriteria;
import ar.com.SOCompWeb.entity.business.CompressionExtraCriteria;

@RunWith(SpringRunner.class)

public class CompressionCriteriaTests {

	private CompressionBasicCriteria compressionBasicCriteria;
	private CompressionExtraCriteria compressionExtraCriteria;

	@Before
	public void setUp() {
		compressionBasicCriteria = new CompressionBasicCriteria();
		compressionExtraCriteria = new CompressionExtraCriteria();
	}

	@Test
	public void testCompressionBasicCriteria() {
		assertTrue(compressionBasicCriteria.complyCriteria('A'));
		assertTrue(compressionBasicCriteria.complyCriteria('B'));
		assertTrue(compressionBasicCriteria.complyCriteria('C'));
		assertFalse(compressionBasicCriteria.complyCriteria('n'));
		assertFalse(compressionBasicCriteria.complyCriteria('b'));
		assertFalse(compressionBasicCriteria.complyCriteria('3'));
		assertFalse(compressionBasicCriteria.complyCriteria('{'));
		assertFalse(compressionBasicCriteria.complyCriteria('¿'));
	}

	@Test
	public void testCompressionExtraCriteria() {
		assertTrue(compressionExtraCriteria.complyCriteria('A'));
		assertTrue(compressionExtraCriteria.complyCriteria('B'));
		assertTrue(compressionExtraCriteria.complyCriteria('c'));
		assertTrue(compressionExtraCriteria.complyCriteria('n'));
		assertTrue(compressionExtraCriteria.complyCriteria('b'));
		assertFalse(compressionExtraCriteria.complyCriteria('{'));
		assertFalse(compressionExtraCriteria.complyCriteria('¿'));
	}

	@Test
	public void testConversions() {
		assertEquals('A', compressionBasicCriteria.convertCharacter('A'));
		assertEquals('B', compressionBasicCriteria.convertCharacter('B'));
		assertEquals('A', compressionExtraCriteria.convertCharacter('a'));
		assertEquals('B', compressionExtraCriteria.convertCharacter('b'));

	}

}
