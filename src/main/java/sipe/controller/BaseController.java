package sipe.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class BaseController {

	@RequestMapping("/")
	public String index() {
		return "Hola mundo SIPE!";
	}
}
