package com.evs.ctl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.evs.dto.UserDTO;
import com.evs.dto.VoterApplicationDTO;
import com.evs.exception.RecordNotFoundException;
import com.evs.form.VoterApplicationFrom;
import com.evs.service.PartyService;
import com.evs.service.VoterApplicationService;
import com.evs.utility.DataUtility;

@Controller
public class VoterApplicationCtl {
	
	
	@Autowired
	public VoterApplicationService service;
	
	
	@Autowired
	public PartyService partyService;
	
	

	@GetMapping("/voterapplication")
	public String voterapplication(@ModelAttribute("form")VoterApplicationFrom form, Model model, HttpSession session) {
		UserDTO user = (UserDTO)session.getAttribute("user");
	model.addAttribute("user", user);
		return "voterapplication";
	}

	@PostMapping("/addVoterApplication")
	public String Add(@RequestParam(value = "image") MultipartFile image, @Valid @ModelAttribute("form")VoterApplicationFrom form,  BindingResult bindingResult, Model model) throws IOException {

		System.out.println("form: "+form);
		try {
		if (bindingResult.hasErrors()) {
			System.out.println("bindingResult : "+bindingResult);
			return "voterapplication";
		}else {
			VoterApplicationDTO bean = form.getDTO();			
			bean.setImage(image.getBytes());
			
			//bean.setId(0);
			if(form.getId()>0) {
				service.update(bean);
				model.addAttribute("success", "Voter Application Updated successfully");
			}else {
				
		    bean.setVoterIdNumber("Na");	
			service.Add(bean);
			model.addAttribute("success", "Voter Application Added successfully");
			}
			
			return "voterapplication";
		}}catch (RecordNotFoundException e) {
			// TODO: handle exception
			model.addAttribute("error", e.getMessage());
			e.printStackTrace();
			return "voterapplication";
		}
	}
	
	@GetMapping("/voterapplicationList")
	public String list(@ModelAttribute("form")VoterApplicationFrom form, Model model, HttpSession session){
		UserDTO user = (UserDTO)session.getAttribute("user");
		List<VoterApplicationDTO> list = null;
		if(user.getUserRole().equals("Admin")) {
			list = service.list();
		}else if(user.getUserRole().equals("EOfficer")) {
			list = service.list();
		}else {
			list = service.list().stream().filter(us -> us.getEmail().equalsIgnoreCase(user.getEmail())).toList();
			
		}
	model.addAttribute("list", list);
	
	return "voterapplicationlist";
		
	}
	
	
	@GetMapping("/voterapplicationEdit")	
	public String update(@ModelAttribute("form")VoterApplicationFrom form, Model model, @RequestParam("id") long id ){
		VoterApplicationDTO bean = service.findVoterApplicationById(id);
	
		form.populate(bean);
		model.addAttribute("bean",bean);	
		return "voterapplication";
	}
	
	@GetMapping("/voterapplicationDelete")	
	public String delete(@ModelAttribute("form")VoterApplicationFrom form, Model model, @RequestParam("id") long id ) throws Exception{
		service.delete(id);	
		
		List<VoterApplicationDTO> list =	service.list();
		model.addAttribute("list", list);
		model.addAttribute("success", "voterapplicationlist Deleted successfully");
		return "voterapplicationlist";
	}
	
	
	@GetMapping("/generateVoterId")	
	public String generateVoterId(@ModelAttribute("form")VoterApplicationFrom form, Model model, @RequestParam("id") long id ) throws Exception{
		VoterApplicationDTO voterApplicationDTO = service.findVoterApplicationById(id);
		long voterID =   DataUtility.getRandom();
		voterApplicationDTO.setVoterIdNumber(DataUtility.getStringData(voterID));
	    service.update(voterApplicationDTO);
		return "redirect:/voterapplicationList";
	}
	

	@GetMapping("/getVoterDocImage/{id}")
	public void getdocImage(HttpServletResponse response, @PathVariable("id") long id) throws Exception {
		response.setContentType("image/jpeg");		
		Blob blb=service.getImageById(id);				
		byte[] bytes = blb.getBytes(1, (int) blb.length());
		InputStream inputStream = new ByteArrayInputStream(bytes);
		IOUtils.copy(inputStream, response.getOutputStream());
	
	}
	
	

}
