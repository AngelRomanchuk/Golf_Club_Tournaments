package com.keyin.golfclub.services;

import com.keyin.golfclub.entity.Member;
import com.keyin.golfclub.entity.Tournament;
import com.keyin.golfclub.repository.TournamentRepository;
import com.keyin.golfclub.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TournamentService {

    @Autowired
    private TournamentRepository tournamentRepository;

    @Autowired
    private MemberRepository memberRepository;

    // Save new tournament
    public Tournament saveTournament(Tournament tournament) {
        return tournamentRepository.save(tournament);
    }

    // Get all tournaments
    public List<Tournament> getAllTournaments() {
        return tournamentRepository.findAll();
    }

    // Get tournament by ID
    public Optional<Tournament> getTournamentById(Long id) {
        return tournamentRepository.findById(id);
    }

    // Delete tournament by ID
    public void deleteTournament(Long id) {
        tournamentRepository.deleteById(id);
    }

    // Search by start date
    public List<Tournament> searchByStartDate(LocalDate startDate) {
        return tournamentRepository.findByStartDate(startDate);
    }

    // Search by location
    public List<Tournament> searchByLocation(String location) {
        return tournamentRepository.findByLocationContainingIgnoreCase(location);
    }

    // Add a member to a tournament
    public Tournament addMemberToTournament(Long tournamentId, Long memberId) {
        Tournament tournament = tournamentRepository.findById(tournamentId).orElseThrow();
        Member member = memberRepository.findById(memberId).orElseThrow();

        tournament.getParticipatingMembers().add(member);
        return tournamentRepository.save(tournament);
    }

    // Get all members of a tournament
    public List<Member> getMembersInTournament(Long tournamentId) {
        Tournament tournament = tournamentRepository.findById(tournamentId).orElseThrow();
        return List.copyOf(tournament.getParticipatingMembers());
    }
}
