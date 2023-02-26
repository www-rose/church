package com.church.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

import com.church.model.Images;
import com.church.model.Member;
import com.church.model.Note;
import com.church.service.MemberService;
import com.church.service.NoteService;
import com.church.model.Question;
import com.church.service.QuestionService;
import com.church.service.imageUploadService;

import jakarta.servlet.http.HttpSession;

@Controller
public class FellowController {

	
	
	@RequestMapping(value = {"/fellow/dashboard"}, method = RequestMethod.GET)
    public String fellowHome(){
        return "fellow/dashboard";
    }
	
	QuestionService questionService;
	MemberService memberService;
	imageUploadService imageUploadService;
	NoteService noteService;
	
	public FellowController(QuestionService questionService, MemberService memberService, 
			imageUploadService imageUploadService, NoteService noteService) {
		this.questionService = questionService;
		this.memberService = memberService;
		this.imageUploadService = imageUploadService;
		this.noteService = noteService;
	}
    
    
    
    @RequestMapping(value = {"/results"}, method = RequestMethod.GET)
    public String views(Model model, 
      		 @Param("keyword") String keyword) {
      	 List<Question> listQuestions = questionService.getAllQuestions(keyword);
      	 model.addAttribute("listQuestions", listQuestions);
      	 model.addAttribute("keyword", keyword);
      	return "fellow/results";
    }

    @RequestMapping(value = {"/results/new"}, method = RequestMethod.GET)
    public String createQuestionForm(Model model) {
    	Question question = new Question();
    	model.addAttribute("question",question);
    	return "fellow/create_result";
    }

    @RequestMapping(value = {"/results"}, method = RequestMethod.POST)
    public String saveQuestion(@ModelAttribute("question") Question question) {
    	questionService.saveQuestion(question);
    return "redirect:/results";
    }

    @RequestMapping(value = {"/results/edit/{id}"}, method = RequestMethod.GET)
    public String editQuestionForm(@PathVariable Long id, Model model) {
    model.addAttribute("question", questionService.getQuestionById(id));
    return "fellow/edit_result";
    }

    @RequestMapping(value = {"/results/{id}"}, method = RequestMethod.POST)
    public String updateQuestion(@PathVariable Long id, 
    	@ModelAttribute("question") Question question,
    	Model model) {

    //get RESULT from database by id
    	Question existingQuestion = questionService.getQuestionById(id);
    existingQuestion.setId(id);
    existingQuestion.setRollNo(question.getRollNo());
    existingQuestion.setS1(question.getS1());
    existingQuestion.setS2(question.getS2());
    existingQuestion.setS3(question.getS3());
    existingQuestion.setS4(question.getS4());
    existingQuestion.setS5(question.getS5());
    existingQuestion.setS6(question.getS6());
    existingQuestion.setS7(question.getS7());
    existingQuestion.setS8(question.getS8());
    existingQuestion.setS9(question.getS9());
    existingQuestion.setS10(question.getS10());
    existingQuestion.setS11(question.getS11());
    existingQuestion.setS12(question.getS12());
    existingQuestion.setS13(question.getS13());
    existingQuestion.setS14(question.getS14());
    existingQuestion.setS15(question.getS15());
    existingQuestion.setS16(question.getS16());
    existingQuestion.setS17(question.getS17());
    existingQuestion.setS18(question.getS18());
    existingQuestion.setS19(question.getS19());
    existingQuestion.setS20(question.getS20());
    existingQuestion.setS21(question.getS21());
    existingQuestion.setS22(question.getS22());
    existingQuestion.setS23(question.getS23());
    existingQuestion.setS24(question.getS24());
    existingQuestion.setS25(question.getS25());
    existingQuestion.setS26(question.getS26());
    existingQuestion.setS27(question.getS27());
    existingQuestion.setS28(question.getS28());
    existingQuestion.setS29(question.getS29());
    existingQuestion.setS30(question.getS30());




    //save updated maths object 
    questionService.updateQuestion(existingQuestion);
    return "redirect:/results";
    }

    //handler method to handle delete maths request

    @RequestMapping(value = {"/results/{id}"}, method = RequestMethod.GET)
    public String Question(@PathVariable Long id) {
    	questionService.deleteQuestionById(id);
    return "redirect:/results";
    }

    
    
    
    
    

    
    
    
    @RequestMapping(value = {"/felmems"}, method = RequestMethod.GET)
    public String listMembers(Model model, 
      		 @Param("keyword") String keyword) {
      	 List<Member> listMembers = memberService.getAllMembers(keyword);
      	model.addAttribute("listMembers", listMembers);
      	 model.addAttribute("keyword", keyword);
      	return "fellow/felmems";
    }
    

	@RequestMapping(value = {"/felmems/new"}, method = RequestMethod.GET)
	public String createMemberForm(Model model) {
		Member member = new Member();
		model.addAttribute("member", member);
		return "fellow/create_member";
	}
	
	 @RequestMapping(value = {"/felmems"}, method = RequestMethod.POST)
	public String saveMember(@ModelAttribute("member") Member member) {
		memberService.saveMember(member);
		return "redirect:/felmems";
	}
	
	 @RequestMapping(value = {"/felmems/edit/{id}"}, method = RequestMethod.GET)
	public String editMemberForm(@PathVariable Long id, Model model) {
		model.addAttribute("member", memberService.getMemberById(id));
		return "fellow/edit_member";
	}
	
	 @RequestMapping(value = {"/felmems/{id}"}, method = RequestMethod.POST)
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
		return "redirect:/felmems";
	}
	
	// handler method to handle delete member request

	 @RequestMapping(value = {"/felmems/{id}"}, method = RequestMethod.GET)
		public String deleteMember(@PathVariable Long id) {
		memberService.deleteMemberById(id);
		return "redirect:/felmems";
	}
	 
	
	 
	 
	 
	 
	 @RequestMapping(value = {"/felnotes"}, method = RequestMethod.GET)
	 public String felNotes(Model model, 
	   		 @Param("keyword") String keyword) {
	   	 List<Note> listNotes = noteService.getAllNotes(keyword);
	   	 model.addAttribute("listNotes", listNotes);
	   	 model.addAttribute("keyword", keyword);
	   	model.addAttribute("notes",noteService.getAll());
	   	return "fellow/notes";
	 }
	 
	 
	 
	 
	 
	 
	 @RequestMapping(value = {"/feimage"}, method = RequestMethod.GET)
		public String adindex(Model m) {

			List<Images> list = imageUploadService.findAll();

			m.addAttribute("list", list);
			m.addAttribute("adimage", imageUploadService.findAll());
			
			return "fellow/image";
		}

	 
	 @RequestMapping(value = {"/feimageUpload"}, method = RequestMethod.POST)
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
	 
			return "redirect:/feimage";
		
	 }
	 
}
