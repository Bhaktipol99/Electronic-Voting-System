package com.evs.ctl;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.evs.dto.CandidateDTO;
import com.evs.dto.ElectionDTO;
import com.evs.dto.UserDTO;
import com.evs.dto.VoteDTO;
import com.evs.exception.RecordNotFoundException;
import com.evs.form.VoteForm;
import com.evs.service.CandidateService;
import com.evs.service.ElectionService;
import com.evs.service.VoterService;

@Controller
public class VoteCtl {

    @Autowired
    public VoterService service;

    @Autowired
    public CandidateService candidateService;

    @Autowired
    public ElectionService electionService;

    @GetMapping("/vote")
    public String vote(@ModelAttribute("form") VoteForm form, Model model,
            @RequestParam("candidateId") long candidateId, @RequestParam("electionId") long electionId,
            HttpSession session) {
        UserDTO user = (UserDTO) session.getAttribute("user");

        // Check if user is null and redirect to login if not found
        if (user == null) {
            return "redirect:/login"; // Assuming there's a login page
        }

        CandidateDTO candidateDTO = candidateService.findCandidateById(candidateId);
        ElectionDTO electionDTO = electionService.findElectionById(electionId);

        model.addAttribute("user", user);
        model.addAttribute("candidateDTO", candidateDTO);
        model.addAttribute("electionDTO", electionDTO);

        return "vote";
    }

    @PostMapping("/addVote")
    public String Add(@Valid @ModelAttribute("form") VoteForm form, BindingResult bindingResult, Model model)
            throws IOException {

        System.out.println("form: " + form);

        try {
            if (bindingResult.hasErrors()) {
                System.out.println("bindingResult : " + bindingResult);
                return "vote";
            } else {
                VoteDTO bean = form.getDTO();
                bean.setStatus(1); // Set status
                service.add(bean); // Updated to follow camel case convention
                model.addAttribute("success", "Thanks for voting for your candidate.");

                return "vote";
            }
        } catch (RecordNotFoundException e) {
            // Handle exception with user-friendly message
            model.addAttribute("error", "Record not found. Please try again.");
            e.printStackTrace();
            return "vote";
        }
    }

    @GetMapping("/resultView")
    public String resultView(@ModelAttribute("form") VoteForm form, Model model, @RequestParam("id") long id) {
        // Fetch the list of votes from the VoterService
        List<VoteDTO> list = service.list(); // Ensure service.list() returns a list of VoteDTO

        // Collect votes for each candidate and count them
        Map<Object, Long> result = list.stream()
            .filter(vote -> {
                // Ensure the electionId is compared correctly as long
                Long electionId = (Long) vote.getElectionId();
                return electionId != null && electionId.longValue() == id; // Compare long values
            })
            .collect(Collectors.groupingBy(
                VoteDTO::getCandidateId, 
                Collectors.counting()
            ));

        // Prepare the final result map with candidate names and their vote counts
        Map<String, Long> finalResult = new HashMap<>();
        for (Entry<Object, Long> entry : result.entrySet()) {
            CandidateDTO candidate = candidateService.findCandidateById(entry.getKey());
            String candidateName = candidate.getFirstName() + " " + candidate.getLastName();
            finalResult.put(candidateName, entry.getValue());
        }

        model.addAttribute("electionName", electionService.findElectionById(id).getElectionName());
        model.addAttribute("result", finalResult);
        return "result";
    }

}
