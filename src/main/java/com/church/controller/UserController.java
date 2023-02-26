package com.church.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;
import org.springframework.data.repository.query.Param;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.church.model.Member;
import com.church.model.Note;
import com.church.model.Notem;
import com.church.model.Question;
import com.church.model.Evangelism;
import com.church.service.MemberService;
import com.church.service.NoteService;
import com.church.service.QuestionService;
import com.church.service.NotemService;
import com.church.service.imageUploadService;
import com.church.model.Images;
import com.church.repository.uploadRepository;

import jakarta.servlet.http.HttpSession;

import com.church.service.EvangelismService;


@Controller
public class UserController {

	
	MemberService memberService;
	QuestionService questionService;
	EvangelismService evangelismService;
	imageUploadService imageUploadService;
	NoteService noteService;
	NotemService notemService;
	
	
	public UserController(MemberService memberService, QuestionService questionService, NotemService notemService,
			EvangelismService evangelismService, imageUploadService imageUploadService, NoteService noteService) {
		this.memberService = memberService;
		this.questionService = questionService;
		this.evangelismService = evangelismService;
		this.imageUploadService = imageUploadService;
		this.noteService = noteService;
		this.notemService = notemService;
	}
	
	 @RequestMapping(value = {"/dashboard"}, method = RequestMethod.GET)
	    public String homePage(){
	        return "user/dashboard";
	    }
	 
		
	  
	    @RequestMapping(value = {"/members"}, method = RequestMethod.GET)
	    public String umems(Model model, 
	      		 @Param("keyword") String keyword) {
	      	 List<Member> listMembers = memberService.getAllMembers(keyword);
	      	model.addAttribute("listMembers", listMembers);
	      	 model.addAttribute("keyword", keyword);
	      	return findPaginated(1, "firstName", "asc", "keyword", model);
	    }
	    

		@RequestMapping(value = {"/members/new"}, method = RequestMethod.GET)
		public String createMemberForm(Model model) {
			Member member = new Member();
			model.addAttribute("member", member);
			return "user/create_member";
		}
		
		 @RequestMapping(value = {"/members"}, method = RequestMethod.POST)
		public String saveMember(@ModelAttribute("member") Member member) {
			memberService.saveMember(member);
			return "redirect:/members";
		}
		
		 @RequestMapping(value = {"/members/edit/{id}"}, method = RequestMethod.GET)
		public String editMemberForm(@PathVariable Long id, Model model) {
			model.addAttribute("member", memberService.getMemberById(id));
			return "user/edit_member";
		}
		
		 @RequestMapping(value = {"/members/{id}"}, method = RequestMethod.POST)
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
			return "redirect:/members";
		}
		
		// handler method to handle delete member request

		 @RequestMapping(value = {"/members/{id}"}, method = RequestMethod.GET)
			public String deleteMember(@PathVariable Long id) {
			memberService.deleteMemberById(id);
			return "redirect:/members";
		}
		 
		 @RequestMapping(value = {"/page/{pageNo}"}, method = RequestMethod.GET)
		 public String findPaginated(@PathVariable (value = "pageNo") int pageNo,
				 @RequestParam("sortField") String sortField,
				 @RequestParam("sortDir") String sortDir,
				 @Param("keyword") String keyword,
				 Model model) {
			 int pageSize = 8;
			 
			 Page<Member> page = memberService.findPaginated(pageNo, pageSize, sortField, sortDir, keyword);
			 List<Member> listMembers = page.getContent();
			 
			 
		
			 model.addAttribute("currentPage", pageNo);
			 model.addAttribute("totalPages", page.getTotalPages());
			 model.addAttribute("totalItems", page.getTotalElements());
			 
			 model.addAttribute("sortField", sortField);
			 model.addAttribute("sortDirection", sortDir);
			 model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "des" : "asc");
			 
			 
			 model.addAttribute("listMembers", listMembers);
			model.addAttribute("members",memberService.getAll());
			model.addAttribute("keyword", keyword);
			 return "user/members";	 
			 
		 } 
		
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 @RequestMapping(value = {"/questions"}, method = RequestMethod.GET)
		    public String views(Model model, 
		      		 @Param("keyword") String keyword) {
		      	 List<Question> listQuestions = questionService.getAllQuestions(keyword);
		      	 model.addAttribute("listQuestions", listQuestions);
		      	 model.addAttribute("keyword", keyword);
		      	model.addAttribute("questions",questionService.getAll());
		      	return "user/questions";
		    }

		    @RequestMapping(value = {"/questions/new"}, method = RequestMethod.GET)
		    public String createQuestionForm(Model model) {
		    	Question question = new Question();
		    	model.addAttribute("question",question);
		    	return "user/create_question";
		    }

		    @RequestMapping(value = {"/questions"}, method = RequestMethod.POST)
		    public String saveQuestion(@ModelAttribute("question") Question question) {
		    	questionService.saveQuestion(question);
		    return "redirect:/questions";
		    }

		    @RequestMapping(value = {"/questions/edit/{id}"}, method = RequestMethod.GET)
		    public String editQuestionForm(@PathVariable Long id, Model model) {
		    model.addAttribute("question", questionService.getQuestionById(id));
		    return "user/edit_question";
		    }

		    @RequestMapping(value = {"/questions/{id}"}, method = RequestMethod.POST)
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
		    return "redirect:/questions";
		    }

		    //handler method to handle delete maths request

		    @RequestMapping(value = {"/questions/{id}"}, method = RequestMethod.GET)
		    public String Question(@PathVariable Long id) {
		    	questionService.deleteQuestionById(id);
		    return "redirect:/questions";
		    }
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 @RequestMapping(value = {"/evangelisms"}, method = RequestMethod.GET)
		 public String Evangelisms(Model model, 
		   		 @Param("keyword") String keyword) {
		   	 List<Evangelism> listEvangelisms = evangelismService.getAllEvangelisms(keyword);
		   	 model.addAttribute("listEvangelisms", listEvangelisms);
		   	 model.addAttribute("keyword", keyword);
		   	model.addAttribute("questions",questionService.getAll());
		   	return "user/evangelisms";
		 }

		 @RequestMapping(value = {"/evangelisms/new"}, method = RequestMethod.GET)
		 public String createEvangelismForm(Model model) {
			 Evangelism evangelism = new Evangelism();
		 	model.addAttribute("evangelism",evangelism);
		 	return "user/create_evangelism";
		 }

		 @RequestMapping(value = {"/evangelisms"}, method = RequestMethod.POST)
		 public String saveEvangelism(@ModelAttribute("question") Evangelism evangelism) {
			 evangelismService.saveEvangelism(evangelism);
		 return "redirect:/evangelisms";
		 }

		 @RequestMapping(value = {"/evangelisms/edit/{id}"}, method = RequestMethod.GET)
		 public String editEvangelismForm(@PathVariable Long id, Model model) {
		 model.addAttribute("evangelism", evangelismService.getEvangelismById(id));
		 return "user/edit_evangelism";
		 }
		 @RequestMapping(value = {"/evangelisms/{id}"}, method = RequestMethod.POST)
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
		 existingEvangelism.setS14(evangelism.getS14());
		 
		 
		 //save updated maths object 
		 evangelismService.updateEvangelism(existingEvangelism);
		 return "redirect:/evangelisms";
		 }

		 //handler method to handle delete maths request

		 @RequestMapping(value = {"/evangelisms/{id}"}, method = RequestMethod.GET)
		 public String Evangelism(@PathVariable Long id) {
			 evangelismService.deleteEvangelismById(id);
		 return "redirect:/evangelisms";
		 }


	
		 
		 
		 
		 
		 
		 @RequestMapping(value = {"/notes"}, method = RequestMethod.GET)
		 public String Notes(Model model, 
		   		 @Param("keyword") String keyword) {
		   	 List<Note> listNotes = noteService.getAllNotes(keyword);
		   	 model.addAttribute("listNotes", listNotes);
		   	 model.addAttribute("keyword", keyword);
		   	model.addAttribute("notes",noteService.getAll());
		   	return "user/notes";
		 }
		 
		 @RequestMapping(value = {"/publicnotes"}, method = RequestMethod.GET)
		 public String pubNotes(Model model, 
		   		 @Param("keyword") String keyword) {
		   	 List<Notem> listNotems = notemService.getAllNotems(keyword);
		   	 model.addAttribute("listNotems", listNotems);
		   	 model.addAttribute("keyword", keyword);
		   	model.addAttribute("notems",notemService.getAll());
		   	return "user/publicnote";
		 }

		 @RequestMapping(value = {"/notes/new"}, method = RequestMethod.GET)
		 public String createNoteForm(Model model) {
			 Note note = new Note();
		 	model.addAttribute("note",note);
		 	return "user/create_note";
		 }
		 
		 @RequestMapping(value = {"/publicnotes/new"}, method = RequestMethod.GET)
		 public String pubcreateNoteForm(Model model) {
			 Notem notem = new Notem();
		 	model.addAttribute("notem",notem);
		 	return "user/create_publicnote";
		 }

		 @RequestMapping(value = {"/notes"}, method = RequestMethod.POST)
		 public String saveNote(@ModelAttribute("note") Note note) {
			 noteService.saveNote(note);
		 return "redirect:/notes";
		 }
		 
		 @RequestMapping(value = {"/publicnotes"}, method = RequestMethod.POST)
		 public String pubsaveNotem(@ModelAttribute("note") Notem notem) {
			 notemService.saveNotem(notem);
		 return "redirect:/publicnotes";
		 }

		 @RequestMapping(value = {"/notes/edit/{id}"}, method = RequestMethod.GET)
		 public String editNoteForm(@PathVariable Long id, Model model) {
		 model.addAttribute("note", noteService.getNoteById(id));
		 return "user/edit_note";
		 }
		 
		 @RequestMapping(value = {"/publicnotes/edit/{id}"}, method = RequestMethod.GET)
		 public String pubeditNotemForm(@PathVariable Long id, Model model) {
		 model.addAttribute("notem", notemService.getNotemById(id));
		 return "user/edit_publicnote";
		 }
		 @RequestMapping(value = {"/notes/{id}"}, method = RequestMethod.POST)
		 public String updateNote(@PathVariable Long id, 
		 	@ModelAttribute("note") Note note,
		 	Model model) {

		 //get RESULT from database by id
			 Note existingNote = noteService.getNoteById(id);
		 existingNote.setId(id);
		 existingNote.setRollNo(note.getRollNo());
		 existingNote.setS1(note.getS1());
		 existingNote.setS2(note.getS2());
		 existingNote.setS3(note.getS3());
		 existingNote.setS4(note.getS4());
		 existingNote.setS5(note.getS5());
		 existingNote.setS6(note.getS6());
		 existingNote.setS7(note.getS7());
		 existingNote.setS8(note.getS8());
		 existingNote.setS9(note.getS9());
		 existingNote.setS10(note.getS10());
		 existingNote.setS11(note.getS11());
		 existingNote.setS12(note.getS12());
		 existingNote.setS13(note.getS13());
		 existingNote.setS14(note.getS14());
		 
		 
		 //save updated maths object 
		 noteService.updateNote(existingNote);
		 return "redirect:/notes";
		 }
		 
		 
		 @RequestMapping(value = {"/publicnotes/{id}"}, method = RequestMethod.POST)
		 public String pubupdateNotem(@PathVariable Long id, 
		 	@ModelAttribute("notem") Notem notem,
		 	Model model) {

		 //get RESULT from database by id
			 Notem existingNotem = notemService.getNotemById(id);
		 existingNotem.setId(id);
		 existingNotem.setRollNo(notem.getRollNo());
		 existingNotem.setS8(notem.getS8());
		 existingNotem.setS9(notem.getS9());
		 existingNotem.setS10(notem.getS10());
		 existingNotem.setS11(notem.getS11());
		 existingNotem.setS12(notem.getS12());
		 existingNotem.setS13(notem.getS13());
		 existingNotem.setS14(notem.getS14());
		 
		 
		 //save updated maths object 
		 notemService.updateNotem(existingNotem);
		 return "redirect:/publicnotes";
		 }

		 //handler method to handle delete maths request

		 @RequestMapping(value = {"/notes/{id}"}, method = RequestMethod.GET)
		 public String Note(@PathVariable Long id) {
			 noteService.deleteNoteById(id);
		 return "redirect:/notes";
		 }
		 
		 @RequestMapping(value = {"/publicnotes/{id}"}, method = RequestMethod.GET)
		 public String pubNotem(@PathVariable Long id) {
			 notemService.deleteNotemById(id);
		 return "redirect:/publicnotes";
		 }

		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 @RequestMapping(value = {"/image"}, method = RequestMethod.GET)
			public String adindex(Model m) {

				List<Images> list = imageUploadService.findAll();

				m.addAttribute("list", list);
				m.addAttribute("adimage", imageUploadService.findAll());
				
				return "user/image";
			}

		 
		 @RequestMapping(value = {"/imageUpload"}, method = RequestMethod.POST)
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
		 
				return "redirect:/image";
			
		 }
		 
		 
		}

