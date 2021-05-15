package SpringSecurity.SpringSecurityAssignment1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@GetMapping("/admin")
	public String admin()
	{	
		return "Welcome Admin";
	}

}
