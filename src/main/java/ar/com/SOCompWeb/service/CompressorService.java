package ar.com.SOCompWeb.service;

import ar.com.SOCompWeb.entity.SOCompression;
import ar.com.SOCompWeb.entity.SOText;
import ar.com.SOCompWeb.exception.CompressionException;

public interface CompressorService {
	SOCompression compress(SOText soText) throws CompressionException;
}
