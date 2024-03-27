package com.board.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.board.domain.BoardVo;
import com.board.mapper.BoardMapper;
import com.board.menus.domain.MenuVo;
import com.board.menus.mapper.MenuMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/Board")
public class BoardController {

	@Autowired
	private   MenuMapper    menuMapper;
	
	@Autowired
	private   BoardMapper   boardMapper;
	
	//  /Board/List?menu_id=MENU01
	@RequestMapping("/List")
	public   ModelAndView   list(MenuVo  menuVo) {
		
		log.info("menuVo : {}", menuVo );
		
		// 메뉴 목록
		List<MenuVo>  menuList   =  menuMapper.getMenuList();
		
		// 게시물 목록
		List<BoardVo> boardList  =  boardMapper.getBoardList( menuVo  ); 
		System.out.println( boardList );
				
		ModelAndView  mv         =  new ModelAndView();
		
		  String menu_id = menuVo.getMenu_id(); 
		  mv.addObject("menu_id", menu_id );
		 
		mv.addObject("menuList",   menuList );
		mv.addObject("boardList",  boardList );
		mv.setViewName("board/list");
		return   mv;
		
	}
	
	//  /Board/WriteForm
	@RequestMapping("/WriteForm")
	public  ModelAndView   writeForm(MenuVo menuVo) {
		
		String menu_id = menuVo.getMenu_id();
			
		ModelAndView  mv  = new ModelAndView();
		mv.addObject("menu_id", menu_id);
		mv.setViewName("board/write");
		return mv;	
		
	}
//  /Board/Write
	//menu_id=menu01, title=aaa, writer=aaa, content =aaa
	@RequestMapping("/Write")
	public ModelAndView write(BoardVo boardVo) {
		//넘어온 값 Board 저장
		boardMapper.insertBoard(boardVo);
		
		String  menu_id = boardVo.getMenu_id();
 		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/Board/List?menu_id=" +menu_id);
		
		return mv;
	}
	
	///Board/View?bno=${ boardVo.bno }
	@RequestMapping("/View")
	public ModelAndView view(BoardVo boardVo) {
		List<MenuVo>  menuList   =  menuMapper.getMenuList();
		HashMap<String, Object> vo = boardMapper.selectBno(boardVo);
		log.info("-----------------");
		log.info("boardVo : {}", vo );
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("vo", vo);
		mv.addObject("menuList", menuList);
		mv.setViewName("board/view");
		return mv;
	}
}







