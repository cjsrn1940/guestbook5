package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestbookVo;

@Repository
public class GuestbookDao {

	@Autowired
	private SqlSession sqlSession;
	
	//리스트
		public List<GuestbookVo> getGuestList() {
			System.out.println("[GusetbookDao.getGuestList()]");
			
			List<GuestbookVo> guestList = sqlSession.selectList("guestbook.guestList");

			return guestList;

		}
		
	//추가
	public int guestInsert(GuestbookVo guestVo) {
		System.out.println("[GusetbookDao.guestInsert()]");
		
		int count = sqlSession.insert("guestbook.guestInsert", guestVo);
		
		return count;
		
	}
	
	
	
}














