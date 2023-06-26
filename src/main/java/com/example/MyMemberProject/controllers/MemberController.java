package com.example.MyMemberProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MyMemberProject.model.beans.Member;
import com.example.MyMemberProject.model.dtos.MemberDto;
import com.example.MyMemberProject.model.services.MemberService;

@RestController
@RequestMapping("/api/member")
public class MemberController {

	@Autowired
	private MemberService memberService;

	@PostMapping
	public ResponseEntity<?> createMember(@RequestBody MemberDto memberDto) {
		try {
			Member member = memberService.saveMember(memberDto);
			MemberDto returnMemberDto = new MemberDto(member);
			return ResponseEntity.ok(returnMemberDto);
		} catch (RuntimeException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PostMapping("/login")
	public ResponseEntity<?> loginMember(@RequestBody MemberDto memberDto) {
	  try {
	    String email = memberDto.getEmail();
	    String password = memberDto.getPassword();

	    Member member = memberService.findMemberByEmail(email);
	    if (member != null) {
	      if (member.getPassword().equals(password)) {
	    	  MemberDto dto = new MemberDto(member);
	        return ResponseEntity.ok(dto);
	      } else {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("密碼錯誤");
	      }
	    } else {
	      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("未註冊的電子信箱");
	    }
	  } catch (Exception e) {
	    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
	  }
	}

//	@PutMapping("/members/{id}")
//	public ResponseEntity<?> updateMember(@PathVariable String id, @RequestBody MemberDto memberDto) {
//		try {
//			Member updatedMember = memberService.updateMember(id, memberDto);
//			return ResponseEntity.ok(updatedMember);
//		} catch (RuntimeException e) {
//			return ResponseEntity.badRequest().body(e.getMessage());
//		} catch (Exception e) {
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
//		}
//	}

}
