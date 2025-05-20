package com.example.jpashop01.jpashop01.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "ORDERS")
public class Order {
	@Id
	@GeneratedValue
	@Column(name = "ORDER_ID")
	private Long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MEMBER_ID")
	private Member member;
	
	
	@OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
	private List<OrderItem> orderItems = new ArrayList<OrderItem>();
	
	@OneToOne(cascade =CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="DELIVERY_ID")
	private Delivery delivery;
	
	private Date orderDate;
	
	@Enumerated(EnumType.STRING)
	private OrderStatus status;
	
	public static Order createOrder(Member member,Delivery delivery, OrderItem orderitem,List<OrderItem> orderItems) {
		Order order = new Order();
		order.setMember(member);
		order.setDelivery(delivery);
		for(OrderItem orderItem : orderItems) {
			order.addOrderItem(orderitem);
		}
		order.setStatus(OrderStatus.ORDER);
		order.setOrderDate(new Date());
		return order;
	}
	
	public void cancel() {
		if(delivery.getStatus() == DeliveryStatus.COMP) {
			throw new RuntimeException("이미 배송완료된 상품은 취고가 불가능합니다.");
		}
		this.setStatus(OrderStatus.CANCEL);
		for(OrderItem orderItem : orderItems) {
			orderItem.cancel();
		}
	}
	

	public void setMember(Member member) {
		this.member=member;
		member.getOrders().add(this);
	}
	
	public void addOrderItem(OrderItem orderItem) {
		orderItems.add(orderItem);
		orderItem.setOrder(this);
	}
	
	public void setDelivery(Delivery delivery) {
		this.delivery=delivery;
		delivery.setOrder(this);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Member getMember() {
		return member;
	}

	public Delivery getDelivery() {
		return delivery;
	}

	
	
}
