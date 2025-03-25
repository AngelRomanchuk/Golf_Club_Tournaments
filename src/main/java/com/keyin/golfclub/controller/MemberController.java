package com.keyin.golfclub.controller;

import com.keyin.golfclub.entity.Member;
import com.keyin.golfclub.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    // Create member
    @PostMapping
    public Member createMember(@RequestBody Member member) {
        return memberService.saveMember(member);
    }

    // Get all members
    @GetMapping
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }

    // Get member by ID
    @GetMapping("/{id}")
    public Member getMemberById(@PathVariable Long id) {
        return memberService.getMemberById(id).orElseThrow();
    }

    // Delete member by ID
    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
    }

    // Search by name
    @GetMapping("/search/name")
    public List<Member> searchByName(@RequestParam String name) {
        return memberService.searchByName(name);
    }

    // Search by phone number
    @GetMapping("/search/phone")
    public List<Member> searchByPhone(@RequestParam String phone) {
        return memberService.searchByPhoneNumber(phone);
    }

    // Search by start date
    @GetMapping("/search/startDate")
    public List<Member> searchByStartDate(@RequestParam String date) {
        return memberService.searchByStartDate(date);
    }

    // Search by membership duration
    @GetMapping("/search/duration")
    public List<Member> searchByDuration(@RequestParam int months) {
        return memberService.searchByDuration(months);
    }
}
