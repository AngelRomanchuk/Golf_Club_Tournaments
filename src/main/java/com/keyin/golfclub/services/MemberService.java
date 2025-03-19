package com.keyin.golfclub.services;

import com.keyin.golfclub.entity.Member;
import com.keyin.golfclub.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    // Save a new member
    public Member saveMember(Member member) {
        return memberRepository.save(member);
    }

    // Get all members
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    // Get member by ID
    public Optional<Member> getMemberById(Long id) {
        return memberRepository.findById(id);
    }

    // Delete member by ID
    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }

    // Search by name (contains, case-insensitive)
    public List<Member> searchByName(String name) {
        return memberRepository.findByNameContainingIgnoreCase(name);
    }

    // Search by phone number
    public List<Member> searchByPhoneNumber(String phone) {
        return memberRepository.findByPhoneNumber(phone);
    }

    // Search by start date (string version, assuming LocalDate conversion later)
    public List<Member> searchByStartDate(String date) {
        return memberRepository.findByStartDate(date);
    }

    // Search by membership duration
    public List<Member> searchByDuration(int months) {
        return memberRepository.findByDurationInMonths(months);
    }
}
