package com.urong.mybatis.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.urong.mybatis.model.Login;
import com.urong.mybatis.model.Member;
import com.urong.mybatis.model.BoardVo;
import com.urong.mybatis.model.SearchVo;

@Controller
public class BoardController {

	static final int contentLenth = 10;
	@Autowired
	@Qualifier("sql")
	private SqlSession sqlSession;

	@RequestMapping(value = "list.do")
	private ModelAndView viewVo(@RequestParam("page") String page) {
		// List<BoardVo> outputs =
						// sqlSession.selectList("userControlMapper.select"); //full scan
		ModelAndView mav = new ModelAndView();
		int pageNum = Integer.parseInt(page);
		pageNum = (pageNum - 1) * contentLenth;

		int rowCount = getTotalCount();
		int viewPageNumber = (rowCount / contentLenth);
		boolean modflag = (rowCount % contentLenth) == 0 ? true : false;
		viewPageNumber = modflag ? viewPageNumber : viewPageNumber + 1;

		List<BoardVo> outputs = 
				sqlSession.selectList("userControlMapper.selectLimitCount", pageNum);

		mav.addObject("pageCount", viewPageNumber);
		mav.addObject("viewVo", outputs);
		mav.setViewName("list");

		return mav;
	}

	@RequestMapping(value = "search.do")
	private ModelAndView searchTaget(SearchVo svo) {
		ModelAndView mav = new ModelAndView();
		String userSelect = svo.getSearchSelect();
		String word = svo.getSearchText();
		List<BoardVo> searchList = null;

		switch (userSelect) {
		case "t":
			searchList = sqlSession.selectList("userControlMapper.searchTitle", word);
			break;
		case "w":
			searchList = sqlSession.selectList("userControlMapper.searchWriter", word);
			break;
		case "t+c":
			searchList = sqlSession.selectList("userControlMapper.searchTitleOrContent", word);
			break;
		case "w+c":
			searchList = sqlSession.selectList("userControlMapper.searchWriterOrContent", word);
			break;
		}
		mav.addObject("viewVo", searchList);
		mav.addObject("searchFlag", true);
		mav.setViewName("list");

		return mav;
	}

	private int getTotalCount() { 
		int count = sqlSession.selectOne("userControlMapper.selectRowCount");

		return count;
	}

	@RequestMapping(value = "update.do")
	private String update(BoardVo vo) {
		sqlSession.update("userControlMapper.update", vo);

		return "success";
	}

	@RequestMapping(value = "insertForm.do")
	private String insertForm() {

		return "write";
	}

	@RequestMapping(value = "insert.do")
	private String insert(@ModelAttribute("BoardVo") BoardVo vo) {
		sqlSession.insert("userControlMapper.insert", vo);

		return "writeSuccess";
	}

	@RequestMapping(value = "success.do")
	private String success() {
		return "success";
	}

	@RequestMapping(value = "login.do")
	private String loginForm() {
		return "login";
	}

	@RequestMapping(value = "updateForm.do")
	private String updateForm(@RequestParam("idx") int idx, HttpServletRequest request) {
		BoardVo vo = sqlSession.selectOne("userControlMapper.selectOne", idx);

		request.setAttribute("vo", vo);

		return "update";
	}

	@RequestMapping(value = "delete.do")
	private ModelAndView delete(@RequestParam("idx") int idx) {
		ModelAndView mav = new ModelAndView();

		int deleteValue = sqlSession.delete("userControlMapper.delete", idx);
		if (deleteValue == 1) {
			mav.setViewName("deleteSuccess");
		} else {
			mav.setViewName("deleteFaild");
		}
		return mav;
	}

	@RequestMapping(value = "confirmLogin.do")
	private ModelAndView confirmUserInfo(Login login, HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();

		try {
			Login successLogin = sqlSession.selectOne("userControlMapper.selectMember", login);
			String id = successLogin.getId();

			System.out.println("id = " + id);
			System.out.println("pass = " + successLogin.getPassword());

			req.getSession().setAttribute("loginId", id);

			mav.addObject("successLogin", successLogin.getId());
			mav.setViewName("LoginSuccess");

			return mav;
		} catch (Exception ex) {
			mav.setViewName("login");
			mav.addObject("faild", 1);

			return mav;
		}
	}

	@RequestMapping(value = "logout.do")
	private ModelAndView logout(HttpServletRequest req) {
		req.getSession().invalidate();
		ModelAndView mav = new ModelAndView();

		mav.addObject("logout", 1);
		mav.setViewName("login");

		return mav;
	}

	@RequestMapping(value = "/join.do")
	private ModelAndView vaildCheckTest() {
		ModelAndView mav = new ModelAndView();

		mav.setViewName("join");

		return mav;
	}

	@RequestMapping(value = "joinMember.do")
	private ModelAndView insertMember(Member member) {
		ModelAndView mav = new ModelAndView();

		String id = member.getId();
		Object duplicateId = sqlSession.selectOne("userControlMapper.selectDuplicateId", id);

		if (!duplicateId.equals("") || duplicateId != null) { 
			mav.setViewName("joinFaild");
			return mav;
		}

		sqlSession.insert("userControlMapper.InsertMember", member);
		mav.addObject("memberName", member.getName());
		mav.setViewName("joinSuccess");

		return mav;
	}

	@RequestMapping(value = "check_id.do") 
	private void checkId(@RequestParam("id") String id, HttpServletResponse res) throws IOException {
		int idLength = id.length();
		if (idLength > 5) {
			Object duplicateId = sqlSession.selectOne("userControlMapper.selectDuplicateId", id);

			res.setContentType("text/html;charset=UTF-8");
			res.setHeader("Cache-Control", "no-cache");
			PrintWriter out = res.getWriter();

			String result = null;
			if (duplicateId == null || duplicateId.equals("")) {
				result = "<font color='green'> 사용 가능한 ID 입니다.</font>";
			} else {
				result = "<font color='red'> 이미 등록된 ID 입니다.</font>";
			}
			out.println(result);
			out.close();
		}
	}

	@RequestMapping(value = "cookie.do")
	private ModelAndView cookieTest() {
		ModelAndView mav = new ModelAndView();
		
		Cookie cookie = new Cookie("1", "값");
		mav.addObject(cookie);

		cookie.setMaxAge(contentLenth); // 수명시간
		cookie.setValue("값 수정");

		mav.addObject("cookie", cookie);
		mav.setViewName("cookie");
		return mav;
	}

	@RequestMapping(value = "newFile.do")
	private ModelAndView test1() {
		ModelAndView mav = new ModelAndView();

		mav.setViewName("redirect:/newFile.html");
		return mav;
	}

	// @ExceptionHandler(익셉션 명) 단일 에러만 잡는.

}
