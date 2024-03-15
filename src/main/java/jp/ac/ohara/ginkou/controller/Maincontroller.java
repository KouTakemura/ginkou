package jp.ac.ohara.ginkou.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import io.micrometer.common.lang.NonNull;
import jp.ac.ohara.ginkou.model.Ginkou;
import jp.ac.ohara.ginkou.service.AccountService;
import jp.ac.ohara.ginkou.service.GinkouService;

@Controller
public class Maincontroller {
	@Autowired
	private AccountService AccountService;
	@Autowired
	private GinkouService GinkouService;

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("list",this.AccountService.getAddressList());
		return "top";
	}

	@GetMapping("/nyuu")
	public ModelAndView add(Ginkou ginkou, ModelAndView model) {
		model.addObject("okane",ginkou);
		model.setViewName("nyuu");
		return model;
	}

	@PostMapping("/nyuu")
	public String complate(@Validated @ModelAttribute @NonNull Ginkou ginkou, RedirectAttributes result,
			ModelAndView model, RedirectAttributes redirectAttributes) {
		try {
			this.GinkouService.save(ginkou);
			redirectAttributes.addFlashAttribute("exception", "");

		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("exception", e.getMessage());
		}
		return "/top";
}

	@GetMapping("/syutu")
	public ModelAndView ad(Ginkou ginkou, ModelAndView model) {
		model.addObject("okane", ginkou);
		model.setViewName("syutu");
		return model;
		
	}

	@PostMapping("/syutu")
	public String comp(@Validated @ModelAttribute @NonNull Ginkou ginkou, BindingResult result,
			ModelAndView model, RedirectAttributes redirectAttributes) {
		try {
			this.GinkouService.save(ginkou);
			redirectAttributes.addFlashAttribute("exception", "");

		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("exception", e.getMessage());
		}
		return "/top";
	}
//	@GetMapping("/update1/")
//	  public void update1(Account account ,int updateMoney) {
//	      int updatebank = account.getNyuu() ;
//	      if (updatebank + updateMoney < 0) { 
//	          new Exception();
//	      }
//	      int newBlance = updatebank + updateMoney;
//	  }
	
//	@GetMapping("/update2/")
//	  public void update2(Account account ,int updateMoney) {
//	      int updatebank = account.getNyuu() ;
//	      if (updatebank + updateMoney < 0) { 
//	          new Exception();
//	      }
//	      int newBlance = updatebank - updateMoney;
//	  }
	
	@GetMapping("/rireki")
	public String in(Model model) {
		model.addAttribute("list",this.GinkouService.getAddressList());
		return "rireki";
	
}
}