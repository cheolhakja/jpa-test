package com.nefer.inflearn;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

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
}
