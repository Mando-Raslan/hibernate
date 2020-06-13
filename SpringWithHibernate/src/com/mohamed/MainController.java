package com.mohamed;


import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mohamed.entity.Custom;
import com.mohamed.hibernate.HiberConfig;


@Controller
public class MainController {
	
	
	
	@RequestMapping(method = RequestMethod.GET , value = "/")
	public String page(Model model) {
		
		Session session = HiberConfig
				          .getSessionFactory()
				          .getCurrentSession();
		try {
			
			session.beginTransaction();
			List<Custom> list = session.createQuery("from Custom c").list();
			
			session.getTransaction().commit();
			model.addAttribute("customers", list);
			return "mainpage";
			
			
		}finally {
			session.close();
		}
		
		
		
	}
	
	
	
	
}
