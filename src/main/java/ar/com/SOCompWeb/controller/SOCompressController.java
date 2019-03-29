package ar.com.SOCompWeb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ar.com.SOCompWeb.entity.SOCompression;
import ar.com.SOCompWeb.entity.SOText;
import ar.com.SOCompWeb.service.CompressorService;

@RestController
public class SOCompressController {

	private static String NAME_P = "NICOLAS_E_LEDESMA";

	@Autowired
	private CompressorService compressorService;

	@GetMapping("/candidate/")
	private ResponseEntity<String> getCandidate() {
		return new ResponseEntity<String>(NAME_P, HttpStatus.OK);
	}

	@PostMapping("/compress/")
	private ResponseEntity<SOCompression> compressText(@RequestBody SOText soText) {
		return new ResponseEntity<SOCompression>(compressorService.compress(soText), HttpStatus.OK);
	}

}
