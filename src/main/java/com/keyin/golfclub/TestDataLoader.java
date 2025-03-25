package com.keyin.golfclub;

import com.keyin.golfclub.entity.Member;
import com.keyin.golfclub.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class TestDataLoader implements CommandLineRunner {

    @Autowired
    private MemberService memberService;

    @Override
    public void run(String... args) throws Exception {
        Member newMember = new Member();
        newMember.setName("Test User");
        newMember.setAddress("123 Main St");
        newMember.setEmail("test@example.com");
        newMember.setPhoneNumber("123-456-7890");
        newMember.setStartDate(LocalDate.now());
        newMember.setDurationInMonths(12);

        Member created = memberService.saveMember(newMember);
        System.out.println("✅ Created test member: " + created.getId());
    }
}

