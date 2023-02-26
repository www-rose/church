package com.church.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;


import com.church.model.Evangelism;
import com.church.model.Images;
import com.church.model.Member;
import com.church.model.Note;
import com.church.model.Notem;
import com.church.model.Question;
import com.church.repository.uploadRepository;
import com.church.service.MemberService;
import com.church.service.NoteService;
import com.church.service.NotemService;
import com.church.service.QuestionService;
import com.church.service.imageUploadService;

import jakarta.servlet.http.HttpSession;

import com.church.service.EvangelismService;

@Controller
public class AdminController {

	
	@RequestMapping(value = {"/admin/dashboard"}, method = RequestMethod.GET)
    public String adminHome(){
        return "admin/dashboard";
    }
	
	
	
	 
	QuestionService questionService;
	MemberService memberService;
	EvangelismService evangelismService;
	imageUploadService imageUploadService;
	NoteService noteService;
	NotemService notemService;
	
	public AdminController(QuestionService questionService, MemberService memberService,EvangelismService evangelismService,
			imageUploadService imageUploadService, NoteService noteService, NotemService notemService) {
		this.questionService = questionService;
		this.memberService = memberService;
		this.evangelismService = evangelismService;
		this.imageUploadService = imageUploadService;
		this.noteService = noteService;
		this.notemService = notemService;
	}
    
    
    
	@RequestMapping(value = {"/mymems"}, method = RequestMethod.GET)
    public String listMembers(Model model, 
      		 @Param("keyword") String keyword) {
      	 List<Member> listMembers = memberService.getAllMembers(keyword);
      	model.addAttribute("listMembers", listMembers);
      	 model.addAttribute("keyword", keyword);
      	return "admin/mymems";
    }
      
	@RequestMapping(value = {"/mymems/{id}"}, method = RequestMethod.POST)
	public String updateMember(@PathVariable Long id, 
			@ModelAttribute("member") Member member,
			Model model) {
		
		//get members from database by id
		 Member existingMember = memberService.getMemberById(id);
			existingMember.setId(id);
			existingMember.setFirstName(member.getFirstName());
			existingMember.setLastName(member.getLastName());
			existingMember.setEmail(member.getEmail());
			existingMember.setFellowship(member.getFellowship());
			existingMember.setCell(member.getCell());
			existingMember.setPosition(member.getPosition());
			existingMember.setDepartment(member.getDepartment());
			existingMember.setRhapsody(member.getRhapsody());
			existingMember.setTithe(member.getTithe());
			existingMember.setOthers(member.getOthers());
		
		
		//save updated student object 
		memberService.updateMember(existingMember);
		return "redirect:/mymems";
	}
	
	
	
	
	
	@RequestMapping(value = {"/mydonors"}, method = RequestMethod.GET)
	public String donors(Model model, 
	   		 @Param("keyword") String keyword) {
	   	 List<Evangelism> listEvangelisms = evangelismService.getAllEvangelisms(keyword);
	   	 model.addAttribute("listEvangelisms", listEvangelisms);
	   	 model.addAttribute("keyword", keyword);
	   	model.addAttribute("evangelisms",evangelismService.getAll());
      	return "admin/mydonors";
    }

    @RequestMapping(value = {"/mydonors/new"}, method = RequestMethod.GET)
    public String createEvangelismForm(Model model) {
		 Evangelism evangelism = new Evangelism();
	 	model.addAttribute("evangelism",evangelism);
	 	return "admin/create_mydonors";
    }

    @RequestMapping(value = {"/mydonors"}, method = RequestMethod.POST)
    public String saveEvangelism(@ModelAttribute("question") Evangelism evangelism) {
		 evangelismService.saveEvangelism(evangelism);
	 return "redirect:/mydonors";
	 }
    

    @RequestMapping(value = {"/mydonors/edit/{id}"}, method = RequestMethod.GET)
    public String editEvangelismForm(@PathVariable Long id, Model model) {
		 model.addAttribute("evangelism", evangelismService.getEvangelismById(id));
		 return "admin/edit_mydonors";
		 }


    @RequestMapping(value = {"/mydonors/{id}"}, method = RequestMethod.POST)
    public String updateEvangelism(@PathVariable Long id, 
		 	@ModelAttribute("evangelism") Evangelism evangelism,
		 	Model model) {
 //get RESULT from database by id
	 Evangelism existingEvangelism = evangelismService.getEvangelismById(id);
 existingEvangelism.setId(id);
 existingEvangelism.setRollNo(evangelism.getRollNo());
 existingEvangelism.setS1(evangelism.getS1());
 existingEvangelism.setS2(evangelism.getS2());
 existingEvangelism.setS3(evangelism.getS3());
 existingEvangelism.setS14(evangelism.getS14());
 existingEvangelism.setS4(evangelism.getS4());
 existingEvangelism.setS5(evangelism.getS5());
 existingEvangelism.setS6(evangelism.getS6());
 existingEvangelism.setS7(evangelism.getS7());
 existingEvangelism.setS8(evangelism.getS8());
 existingEvangelism.setS9(evangelism.getS9());
 existingEvangelism.setS10(evangelism.getS10());
 existingEvangelism.setS11(evangelism.getS11());
 existingEvangelism.setS12(evangelism.getS12());
 existingEvangelism.setS13(evangelism.getS13());



 //save updated maths object 
 evangelismService.updateEvangelism(existingEvangelism);
    return "redirect:/mydonors";
    }

    //handler method to handle delete maths request

    @RequestMapping(value = {"/mydonors/{id}"}, method = RequestMethod.GET)
    public String Evangelism(@PathVariable Long id) {
		 evangelismService.deleteEvangelismById(id);
	 return "redirect:/mydonors";
    }
    

    
    
    
    
    
    
    
    @RequestMapping(value = {"/admpublicnotes"}, method = RequestMethod.GET)
	 public String pubNotes(Model model, 
	   		 @Param("keyword") String keyword) {
	   	 List<Notem> listNotems = notemService.getAllNotems(keyword);
	   	 model.addAttribute("listNotems", listNotems);
	   	 model.addAttribute("keyword", keyword);
	   	model.addAttribute("notes",noteService.getAll());
	   	return "admin/publicnote";
	 }
    
    
    
    
    
    
    
    
    
    
    @RequestMapping(value = {"/adimage"}, method = RequestMethod.GET)
	public String adindex(Model m) {

		List<Images> list = imageUploadService.findAll();

		m.addAttribute("list", list);
		m.addAttribute("adimage", imageUploadService.findAll());
		
		return "admin/image";
	}

 
 @RequestMapping(value = {"/adimageUpload"}, method = RequestMethod.POST)
	public String adimageUpload(@ModelAttribute("images") Images im, MultipartFile img, HttpSession session) {

	 im.setImageName(img.getOriginalFilename());

		Images uploadImg = imageUploadService.save(im);
		if (uploadImg != null) {
			try {

				File saveFile = new ClassPathResource("static/img").getFile();

				Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + img.getOriginalFilename());
				System.out.println(path);
				Files.copy(img.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

			} catch (Exception e) {
				e.printStackTrace();
			}
	 
	 
		imageUploadService.save(im);
		session.setAttribute("msg", "Image Upload Sucessfully");
		}
 
		return "redirect:/adimage";
	
 }
}
