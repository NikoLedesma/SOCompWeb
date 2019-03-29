package ar.com.SOCompWeb.service;

import org.springframework.stereotype.Service;

import ar.com.SOCompWeb.entity.SOCompression;
import ar.com.SOCompWeb.entity.SOText;
import ar.com.SOCompWeb.entity.business.CompressionBasicCriteria;
import ar.com.SOCompWeb.entity.business.Compressor;
import ar.com.SOCompWeb.exception.CompressionException;
import ar.com.SOCompWeb.exception.ExceptionMSG;

@Service
public class CompressorServiceImpl implements CompressorService {

	@Override
	public SOCompression compress(SOText soText) throws CompressionException {
		String text = soText.getValue();
		if (text.trim().isEmpty()) {
			throw new CompressionException(ExceptionMSG.EXCEPTION_EMPTY_COMPRESSION);
		}
		Compressor compressor = new Compressor();
		String compressedText = compressor.compress(text, new CompressionBasicCriteria());
		return new SOCompression(compressedText);
	}

}
