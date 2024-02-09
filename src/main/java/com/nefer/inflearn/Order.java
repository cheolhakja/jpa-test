package com.nefer.inflearn;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
@Entity
@Getter @Setter @ToString
@Table(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @ManyToOne //외래키를 갖는 쪽이 주인이구나!
    @JoinColumn(name = "member_id") //연관관계를 맺을때 외래키가 있어야 하는구나 !! (연관관례 + 외래키)
    private Member member;      //주문 회원

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime orderDate;     //주문시간

    @Enumerated(EnumType.STRING)
    private OrderStatus status;//주문상태



}
