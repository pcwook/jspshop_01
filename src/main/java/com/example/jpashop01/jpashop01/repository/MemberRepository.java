package com.example.jpashop01.jpashop01.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.jpashop01.jpashop01.domain.Member;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class MemberRepository {
	
	@PersistenceContext
	EntityManager em;
	
	public void save(Member member) {
		em.persist(member);
	}
	
	public Member fineOne(Long id) {
		return em.find(Member.class, id);
	}
	
	public List<Member> findAll(){
		return em.createQuery("select m from Member m", Member.class).getResultList();
	}
	
	public List<Member> findByName(String name){
		return em.createQuery("select m from Member m where m.name = :name",Member.class)
				.setParameter("name", name)
				.getResultList();
	}
	
}
