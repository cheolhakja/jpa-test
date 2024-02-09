package com.nefer;

import com.nefer.inflearn.JpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaPracticeApplication implements CommandLineRunner {



	public static void main(String[] args) {
		SpringApplication.run(JpaPracticeApplication.class, args);
		
		
	}

	private final JpaRepository jpaRepository;


	@Autowired
	public JpaPracticeApplication(JpaRepository jpaRepository) {
		this.jpaRepository = jpaRepository;
	}

	@Override
	public void run(String... args) {
		//Member member = new Member();
		//member.setId(9L);
		//member.setName("diogo");

		//Member를 저장하는 메서드
		//jpaRepository.save(member);

		//Member를 pk값으로 조회 가능
		//Member memberFound = jpaRepository.findById(2L);

		//Member 객체로 delete 쿼리 가능
		//jpaRepository.deleteMember(memberFound);

        /*
        em.persist없이 멤버변수 수정 가능
        한번 commit하면 jpa에서 객체를 관리함 + tx.commit 시점에 변경사항을 확인해서 반영함 (18:30)
         */
		//jpaRepository.modifyMemberName(2L, "modified");

		jpaRepository.orderSthCh2();

	}


}
