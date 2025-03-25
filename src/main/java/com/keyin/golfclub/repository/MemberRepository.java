package com.keyin.golfclub.repository;

import com.keyin.golfclub.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    // Custom search queries
    List<Member> findByNameContainingIgnoreCase(String name);
    List<Member> findByPhoneNumber(String phoneNumber);
    List<Member> findByStartDate(LocalDate startDate);
    List<Member> findByDurationInMonths(int durationInMonths);
}
