package Spring_Security.intern.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api")
public class Demo {

	@GetMapping("/demo")
	public String demo() {
		return "demo@@";
	}
}
