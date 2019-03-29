package ar.com.SOCompWeb.service;

import ar.com.SOCompWeb.exception.CompressionException;

public interface CompressorService {
	String compress(String value) throws CompressionException;
}
