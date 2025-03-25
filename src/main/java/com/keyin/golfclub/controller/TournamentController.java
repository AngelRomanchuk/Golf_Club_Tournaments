package com.keyin.golfclub.controller;

import com.keyin.golfclub.entity.Member;
import com.keyin.golfclub.entity.Tournament;
import com.keyin.golfclub.services.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/tournaments")
public class TournamentController {

    @Autowired
    private TournamentService tournamentService;

    // Create tournament
    @PostMapping
    public Tournament createTournament(@RequestBody Tournament tournament) {
        return tournamentService.saveTournament(tournament);
    }

    // Get all tournaments
    @GetMapping
    public List<Tournament> getAllTournaments() {
        return tournamentService.getAllTournaments();
    }

    // Get tournament by ID
    @GetMapping("/{id}")
    public Tournament getTournamentById(@PathVariable Long id) {
        return tournamentService.getTournamentById(id).orElseThrow();
    }

    // Delete tournament by ID
    @DeleteMapping("/{id}")
    public void deleteTournament(@PathVariable Long id) {
        tournamentService.deleteTournament(id);
    }

    // Search by start date
    @GetMapping("/search/startDate")
    public List<Tournament> searchByStartDate(@RequestParam String date) {
        LocalDate parsedDate = LocalDate.parse(date);
        return tournamentService.searchByStartDate(parsedDate);
    }

    // Search by location
    @GetMapping("/search/location")
    public List<Tournament> searchByLocation(@RequestParam String location) {
        return tournamentService.searchByLocation(location);
    }

    // 🔹 Add member to a tournament
    @PutMapping("/{tournamentId}/add-member/{memberId}")
    public Tournament addMemberToTournament(@PathVariable Long tournamentId, @PathVariable Long memberId) {
        return tournamentService.addMemberToTournament(tournamentId, memberId);
    }

    // 🔹 Get all members in a tournament
    @GetMapping("/{tournamentId}/members")
    public List<Member> getMembersInTournament(@PathVariable Long tournamentId) {
        return tournamentService.getMembersInTournament(tournamentId);
    }
}
