package com.example.jpashop01.jpashop01.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.jpashop01.jpashop01.domain.item.Item;

import jakarta.persistence.*;

@Repository
public class ItemRepository {
	
	@PersistenceContext
	EntityManager em;
	
	public void save(Item item) {
		if(item.getId() == null) {
			em.persist(item);
		}else {
			em.merge(item);
		}
	}
	
	public Item fineOne(Long id) {
		return em.find(Item.class, id);
	}
	
	public List<Item> findAll(){
		return em.createQuery("select i from Item i",
				Item.class).getResultList();
	}
	
}
