package com.keyin.golfclub.repository;

import com.keyin.golfclub.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    // Custom search queries
    List<Member> findByNameContainingIgnoreCase(String name);
    List<Member> findByPhoneNumber(String phoneNumber);
    List<Member> findByStartDate(String startDate); // You can change to LocalDate if preferred
    List<Member> findByDurationInMonths(int durationInMonths);
}
