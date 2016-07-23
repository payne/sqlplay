package org.mattpayne.springboot.sql;

import org.mattpayne.springboot.sql.dao.Member;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

	@RequestMapping("/member")
	public Member get(@RequestParam(value="id",defaultValue="0") int id) {
		// using the id parameter is a way to know we're receiving it...
		Member member = new Member(id, "Matt", "Payne");
		return member;
	}
}
