package com.church.service;

import java.util.List;
import org.springframework.data.domain.Page;

import com.church.model.Member;

public interface MemberService {

	List<Member> getAllMembers(String keyword);
	
	List<Member> getAll();
	
	Member saveMember(Member member);
	
	Member getMemberById(Long id);
	
	Member updateMember(Member member);
	
	void deleteMemberById(Long id);
	
	Page<Member> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection, String keyword);
}
