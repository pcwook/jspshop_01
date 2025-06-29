package com.example.jpashop01.jpashop01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jpashop01.jpashop01.domain.Member;
import com.example.jpashop01.jpashop01.repository.MemberRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MemberService {
	
	@Autowired
	MemberRepository memberRepository;
	
	// 회원가입
	public Long join(Member member) {
		validateDuplicateMember(member); //중복 회원 검증
		memberRepository.save(member);
		return member.getId();
	}
	
	private void validateDuplicateMember(Member member) {
		List<Member> findMembers = memberRepository.findByName(member.getName());
		if(!findMembers.isEmpty()) {
			throw new IllegalStateException("이미 존재하는 회원입니다.");
		}
	}
	
	//전체 회원 조회
	public List<Member> findMembers(){
		return memberRepository.findAll();
	}
	public Member fineOne(Long memberId) {
		return memberRepository.fineOne(memberId);
	}
	
}
