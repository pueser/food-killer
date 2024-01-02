package kr.co.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.restaurant.domain.BoardDTO;
import kr.co.restaurant.service.IBoardService;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board")
@Log4j
public class BoardController {
	@Autowired
	private IBoardService service;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void listAll(Model model) throws Exception {
		log.info("show all list..................");
		
		model.addAttribute("list", service.listAll());
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET() throws Exception {
		log.info("register get....................");
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPost(BoardDTO bDto, RedirectAttributes rttr) throws Exception {
		log.info("register post....................");
		
		service.regiater(bDto);
		
		rttr.addFlashAttribute("result", bDto.getBno());
		
		return "redirect:/board/list";
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(@RequestParam("bno") int bno, Model model) throws Exception {
		model.addAttribute("board", service.read(bno));
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void modifyGET(@RequestParam("bno") int bno, Model model) throws Exception {
		model.addAttribute("board", service.read(bno));
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPost(BoardDTO bDto, RedirectAttributes rttr) throws Exception {
		log.info("modify post............." + service.modify(bDto));
		
		if (service.modify(bDto)) {
			rttr.addFlashAttribute("result", "success");
		}
		
		return "redirect:/board/list";
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("bno") int bno, RedirectAttributes rttr) throws Exception {
		log.info("remove......................");
		
		if (service.remove(bno)) {
			rttr.addFlashAttribute("result", "success");
		}
		
		return "redirect:/board/list";
	}
}

