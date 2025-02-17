package com.evs.ctl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
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
import com.evs.dto.PartyDTO;
import com.evs.exception.RecordNotFoundException;
import com.evs.form.PartyForm;
import com.evs.service.PartyService;

@Controller
public class PartyCtl {
	
	@Autowired
	public PartyService service;
	
	

	@GetMapping("/party")
	public String event(@ModelAttribute("form")PartyForm form, Model model) {

		return "party";
	}

	@PostMapping("/addParty")
	public String Add(@RequestParam(value = "image") MultipartFile image, @Valid @ModelAttribute("form")PartyForm form,  BindingResult bindingResult, Model model) throws IOException {

		System.out.println("form: "+form);
		try {
		if (bindingResult.hasErrors()) {
			System.out.println("bindingResult : "+bindingResult);
			return "party";
		}else {
			PartyDTO bean = form.getDTO();			
			bean.setImage(image.getBytes());
			if(form.getId()>0) {
				service.update(bean);
				model.addAttribute("success", "Party Updated successfully");
			}else {
			service.Add(bean);
			model.addAttribute("success", "Party Added successfully");
			}
			
			return "party";
		}}catch (RecordNotFoundException e) {
			// TODO: handle exception
			model.addAttribute("error", e.getMessage());
			e.printStackTrace();
			return "party";
		}
	}
	
	@GetMapping("/partyList")
	public String list(@ModelAttribute("form")PartyForm form, Model model){
	List<PartyDTO> list = service.list();
	model.addAttribute("list", list);
	return "partylist";
		
	}
	
	
	@GetMapping("/eventEdit")	
	public String update(@ModelAttribute("form")PartyForm form, Model model, @RequestParam("id") long id ){
		PartyDTO bean = service.findPartyById(id);
		form.populate(bean);
		model.addAttribute("bean",bean);	
		return "party";
	}
	
	@GetMapping("/eventDelete")	
	public String delete(@ModelAttribute("form")PartyForm form, Model model, @RequestParam("id") long id ) throws Exception{
		service.delete(id);	
		
		List<PartyDTO> list =	service.list();
		model.addAttribute("list", list);
		model.addAttribute("success", "Party Deleted successfully");
		return "partylist";
	}

	@GetMapping("/getPartyImage/{id}")
	public void getNewsImage(HttpServletResponse response, @PathVariable("id") long id) throws Exception {
		response.setContentType("image/jpeg");		
		Blob blb=service.getImageById(id);				
		byte[] bytes = blb.getBytes(1, (int) blb.length());
		InputStream inputStream = new ByteArrayInputStream(bytes);
		IOUtils.copy(inputStream, response.getOutputStream());
	
	}
	

}
