package com.example.jpashop01.jpashop01.domain;

import java.util.ArrayList;
import java.util.List;

import com.example.jpashop01.jpashop01.domain.item.Item;

import jakarta.persistence.*;

@Entity
public class Category {

	@Id @GeneratedValue
	@Column(name="CATEGORY_ID")
	private Long id;
	
	private String name;
	
	@ManyToMany
	@JoinTable(name="CATEGORY_ITEM",
	joinColumns = @JoinColumn(name="CATEGORY_ID"),
	inverseJoinColumns = @JoinColumn(name = "ITEM_ID"))
	private List<Item> items =new ArrayList<Item>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PARENT_ID")
	private Category parent;
	
	@OneToMany(mappedBy = "parent")
	private List<Category> child = new ArrayList<Category>();
	
	public void addChildCategory(Category child) {
		this.child.add(child);
		child.setParent(this);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Category getParent() {
		return parent;
	}

	public void setParent(Category parent) {
		this.parent = parent;
	}

	public List<Category> getChild() {
		return child;
	}

	public void setChild(List<Category> child) {
		this.child = child;
	}
	
	
}
