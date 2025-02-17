package com.evs.ctl;

import java.io.IOException;
import java.util.List;
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
import com.evs.dto.PartyDTO;
import com.evs.exception.RecordNotFoundException;
import com.evs.form.CandidateForm;
import com.evs.form.ElectionFrom;
import com.evs.form.PartyForm;
import com.evs.service.CandidateService;
import com.evs.service.ElectionService;
import com.evs.service.PartyService;

@Controller
public class CandidateCtl {
	
	@Autowired
	public CandidateService service;
	
	
	@Autowired
	public PartyService partyService;
	
	@Autowired
	public ElectionService electionService;
	

	@GetMapping("/candidate")
	public String event(@ModelAttribute("form")CandidateForm form, Model model) {
       
		List<PartyDTO> party = partyService.list();	
		model.addAttribute("party", party);
		
		
		
		return "candidate";
	}

	@PostMapping("/addCandidate")
	public String add(@Valid @ModelAttribute("form")CandidateForm form,  BindingResult bindingResult, Model model) throws IOException {

		System.out.println("form: "+form);
		try {
		if (bindingResult.hasErrors()) {
			System.out.println("bindingResult : "+bindingResult);
			return "candidate";
		}else {
			CandidateDTO bean = form.getDTO();			
		    long partyId = bean.getPartyId();
		    PartyDTO partyDto = partyService.findPartyById(partyId);
		    bean.setPartyName(partyDto.getPartyName());
			
			if(form.getId()>0) {
				service.update(bean);
				model.addAttribute("success", "Candidate Updated successfully");
			}else {
				
				
			service.Add(bean);
			model.addAttribute("success", "Candidate Added successfully");
			}
			
			return "candidate";
		}}catch (RecordNotFoundException e) {
			// TODO: handle exception
			model.addAttribute("error", e.getMessage());
			e.printStackTrace();
			return "candidate";
		}
	}
	
	@GetMapping("/candidateList")
	public String list(@ModelAttribute("form")CandidateForm form, Model model){
	List<CandidateDTO> list = service.list();
	model.addAttribute("list", list);
	return "candidatelist";
		
	}
	
	
	@GetMapping("/candidateEdit")	
	public String update(@ModelAttribute("form")CandidateForm form, Model model, @RequestParam("id") long id ){
		CandidateDTO bean = service.findCandidateById(id);
	
		form.populate(bean);
		List<PartyDTO> party = partyService.list();	
		model.addAttribute("party", party);
		model.addAttribute("bean",bean);	
		return "candidate";
	}
	
	@GetMapping("/candidateDelete")	
	public String delete(@ModelAttribute("form")CandidateForm form, Model model, @RequestParam("id") long id ) throws Exception{
		service.delete(id);	
		
		List<CandidateDTO> list =	service.list();
		model.addAttribute("list", list);
		model.addAttribute("success", "Candidate Deleted successfully");
		return "candidatelist";
	}

	@GetMapping("/viewCandidate")	
	public String vote(@ModelAttribute("form")ElectionFrom form, Model model, @RequestParam("id") long id ) throws Exception{
		List<CandidateDTO> list = service.list();
		ElectionDTO electionDTO = electionService.findElectionById(id);
		
		
		model.addAttribute("electionDTO", electionDTO);
		model.addAttribute("list", list);
		
		
		
		return "viewcanditate";
	}
	

}
