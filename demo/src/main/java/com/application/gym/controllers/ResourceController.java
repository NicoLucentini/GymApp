package com.application.gym.controllers;


import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/resources")
public class ResourceController {

	@ResponseBody
	@GetMapping(value = "/image/{path}", produces = MediaType.IMAGE_PNG_VALUE)
	public ResponseEntity<byte[]> getImageAsResource(@PathVariable String path) throws IOException {
		 InputStream in = getClass()
			      .getResourceAsStream("/" + path);
		 
		 if(in == null)
			return  ResponseEntity.notFound().build();

	    return ResponseEntity.ok( IOUtils.toByteArray(in));
	}
}
