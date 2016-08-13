package org.mattpayne.springboot.sql;

import org.mattpayne.springboot.sql.dao.Member;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

	@RequestMapping("/member")
	public Member get(
			@RequestParam(value="id",defaultValue="0") int id,//
			@RequestParam(value="firstName",defaultValue="Matt") String firstName
			) {
		// using the id parameter is a way to know we're receiving it...
		Member member = new Member(id, firstName, "Payne");
		return member;
	}
}
