package com.nefer.inflearn;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

@org.springframework.stereotype.Repository
public class JpaRepository {

    private final EntityManager em;

    @Autowired
    public JpaRepository(EntityManager em) {
        this.em = em;
    }

    @Transactional
    public Member save(Member member) {
        em.persist(member);
        return member;
    }
    @Transactional
    public void deleteMember(Member member) {
        em.remove(member);
    }

    @Transactional
    public Member findById(Long id) {
        return em.find(Member.class, id);
    }

    @Transactional
    public void modifyMemberName(Long id, String name) {
        Member member = em.find(Member.class, id);
        member.setName(name);
    }

    @Transactional
    public void orderSthCh2() {


        Item item = new Item();
        item.setName("iphone");
        item.setPrice(1000);
        item.setStockQuantity(999);

        Member member = new Member();
        member.setName("aa");
        member.setCity("Seoul");
        member.setStreet("dasan");
        member.setZipcode("12345");

        Order order = new Order();
        order.setOrderDate(LocalDateTime.now());
        order.setMember(member);
        order.setStatus(OrderStatus.ORDER);


        OrderItem orderItemIphone = new OrderItem();
        orderItemIphone.setOrder(order);
        orderItemIphone.setCount(2);
        orderItemIphone.setItem(item);
        orderItemIphone.setOrderPrice(item.getPrice() * orderItemIphone.getCount());

        em.persist(item); //이걸 먼저 영속성 상태로 해야하는군
        em.persist(member); //이걸 먼저 영속성 상태로 해야하는군
        em.persist(orderItemIphone);
        em.persist(order);
    }
}
