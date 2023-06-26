package com.example.MyMemberProject.model.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MyMemberProject.model.beans.Member;
import com.example.MyMemberProject.model.dtos.MemberDto;
import com.example.MyMemberProject.model.repositories.MemberRepository;

@Service
public class MemberService {
	
    @Autowired
    private MemberRepository memberRepository;

    public Member saveMember(MemberDto memberDto) {
        String email = memberDto.getEmail();
        Optional<Member> optionalMember = memberRepository.findMemberByEmail(email);
        if (optionalMember.isPresent()) {
            // 已存在會員，執行相應的邏輯（例如拋出異常或返回特定的結果）
            throw new RuntimeException("已註冊過的電子郵件");
        } else {
            Member member = new Member(memberDto);
            return memberRepository.save(member);
        }
    }
    
    public Member findMemberById(String id) {
    	Optional<Member> optionalMember = memberRepository.findById(id);
    	if(optionalMember.isPresent()) {
    		Member member = optionalMember.get();
    		return member;
    	}
    	return null;
    }
    
    public Member findMemberByEmail(String email) {
    	Optional<Member> optionalMember = memberRepository.findMemberByEmail(email);
    	if(optionalMember.isPresent()) {
    		Member member = optionalMember.get();
    		return member;
    	}
    	return null;
    }
}