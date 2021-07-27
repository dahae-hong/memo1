package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.MemberDAO;

@Service
public class MemberService {
	@Autowired
	MemberDAO memberdao;
	public int insert(String id, String password) {
		
		return memberdao.insert(id,password);
	}
	
}
