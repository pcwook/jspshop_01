package com.example.jpashop01.jpashop01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jpashop01.jpashop01.domain.Member;
import com.example.jpashop01.jpashop01.domain.item.Item;
import com.example.jpashop01.jpashop01.repository.ItemRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ItemService {
	
	@Autowired
	ItemRepository itemRepository;
	
	public void saveItem(Item item) {
		itemRepository.save(item);
	}
	
	public List<Item> findMembers(){
		return itemRepository.findAll();
	}
	public Item fineOne(Long itemId) {
		return itemRepository.fineOne(itemId);
	}
	
}
