package com.mohamed;

import org.hibernate.query.Query;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.hibernate.Session;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mohamed.entity.Custom;
import com.mohamed.entity.Detail;
import com.mohamed.entity.RequestCustom;
import com.mohamed.hibernate.HiberConfig;
import com.mohamed.req.CustomReq;
import com.mohamed.req.CustomReqToShop;
import com.mohamed.utils.DateUtil;
import com.sun.jmx.snmp.Timestamp;

@Controller
@RequestMapping(value = "/customer")
public class HandlerController {
	
	
	
	@RequestMapping(value = "/add")
	public String viewAddCustomer(Model model) {
		
		
		model.addAttribute("custom", new CustomReq());
		
		return "customerpage";
		
	}
	
	
	@RequestMapping(method = RequestMethod.GET , value = "/savenewcustomer")
	public String saveCustomer(@Valid @ModelAttribute("custom") CustomReq req , BindingResult result) {
		
		if(result.hasErrors())
			return "customerpage";		
		
		
		
		Session session = HiberConfig.getSessionFactory().getCurrentSession();
		try {
			
			session.beginTransaction();
		
			if(exists(session, req.getEmail()))
				return "customerpage";
			
			Custom custom = new Custom();
			BeanUtils.copyProperties(req, custom);
	    	session.save(custom);
			session.getTransaction().commit();
			// saving java object toMysql
			return "redirect:http://localhost:8080/SpringWithHibernate";
				
		}
		
		finally {
			
			session.close();
			
		}
		
		
	}
	
	
	@RequestMapping(value = "/getDetails" , method = RequestMethod.GET)
	public String getDetails(@RequestParam("id") int id , Model model ) {
		
		Session session = HiberConfig
				          .getSessionFactory()
				          .getCurrentSession();
		try {
			
			session.beginTransaction();
			
			Custom custom = session.get(Custom.class, id);
			session.getTransaction().commit();
			if(custom!=null) {
				
				model.addAttribute("detail", custom.getDetailcustomer());
				return "customdetail";
			}else {
				
				return "mainpage";
			}
			
		}
		
		finally {
			
			session.close();
			
		}
		
	}
	
	@RequestMapping(value = "/updated" , method = {RequestMethod.POST, RequestMethod.GET})
	public String submitUpdate(@Valid @ModelAttribute("oldcustom") CustomReq req ,
			                    BindingResult result) {
		
		if(result.hasErrors())
			return "updatecustomer";
		
		
		Session session = HiberConfig
				         .getSessionFactory()
				         .getCurrentSession();
		try {
			session.beginTransaction();
			Custom custom = session.get(Custom.class, req.getId());
			BeanUtils.copyProperties(req, custom);		
			session.merge(custom);
			session.getTransaction().commit();
			return "redirect:http://localhost:8080/SpringWithHibernate";
		}

		finally {

			session.close();

		}
		
		
		
		
	}
	
	
	
	@RequestMapping(value = "/update" , method = {RequestMethod.POST, RequestMethod.GET})
	public String update( @RequestParam("id") int id , Model model) {
		
		
		Session session = HiberConfig.getSessionFactory().getCurrentSession();
		try {

			session.beginTransaction();
			Custom custom = session.get(Custom.class, id);
			session.getTransaction().commit();
			
			CustomReq req = new CustomReq();
			BeanUtils.copyProperties(custom, req);
			model.addAttribute("oldcustom" , req);
			return "updatecustomer";
			

		}

		finally {

			session.close();

		}
		
		
		
		
	}
	
	
	@RequestMapping(value = "/delete" , method = RequestMethod.GET)
	public String delete(@RequestParam("id") int id) {

		Session session = HiberConfig.getSessionFactory().getCurrentSession();
		try {

			session.beginTransaction();

			Custom custom = session.get(Custom.class, id);
			
			session.delete(custom);
			
			
			
			session.getTransaction().commit();
			
			return "redirect:http://localhost:8080/SpringWithHibernate";
			

		}

		finally {

			session.close();

		}
		
	}
	
	
	@RequestMapping(method = RequestMethod.GET , value="/home")
	public String home() {
		
		return "redirect:http://localhost:8080/SpringWithHibernate";
		
	}
	
	
	
	@RequestMapping(value = "/addReq" , method = RequestMethod.GET)
	public String addReq(@RequestParam("id") int id , Model model) {
		
		CustomReqToShop req = new CustomReqToShop();
		req.setReqId(id);
		model.addAttribute("CustomReqToShop",req);
		
		return "requestform";
		
	}
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(value = "/getRequests" , method = RequestMethod.GET)
	public String getRequests(@RequestParam("id") int id , Model model) {
		
		Session session = HiberConfig.getSessionFactory().getCurrentSession();
		try {

			session.beginTransaction();

			Custom custom = session.get(Custom.class, id);
			
			List<RequestCustom> listreq = custom.getRequests();
			
			System.out.println(listreq);
			
			List<CustomReqToShop> list  = copy(listreq);
			
			System.out.println(list);
			model.addAttribute("data", list);
			
			session.getTransaction().commit();

		}

		finally {

			session.close();

		}
		
		return "allcustomreq";
	}
	
	
	public List<CustomReqToShop> copy(List<RequestCustom> req) {
		
		List<CustomReqToShop> list = new ArrayList<CustomReqToShop>() ;
		
		for(RequestCustom c : req) {
			CustomReqToShop customreq  = new CustomReqToShop();
			String date = DateUtil.getStringDate(c.getDate());
			customreq.setCustom(c.getCustom());
			customreq.setDate(date);
			customreq.setPrice(c.getPrice());
			customreq.setReq(c.getReq());
			customreq.setReqId(c.getReqId());
			list.add(customreq);
		}
		
		return list;
	}
	
	
	
	
	@RequestMapping(value = "/deleteReq/{reqId}/{id}" , method = RequestMethod.GET)
	public String deleteReq(@PathVariable int reqId , @PathVariable int id) {
		
		
		Session session = HiberConfig.getSessionFactory().getCurrentSession();
		try {

			session.beginTransaction();

			System.out.println("ID is :"  +id);
			System.out.println("IDReq is :"  +reqId);
			RequestCustom req = session.get(RequestCustom.class, reqId);
			
			session.delete(req);
			
			session.getTransaction().commit();
			
			return "redirect:http://localhost:8080/SpringWithHibernate/customer/getRequests?id="+id+"";
			

		}

		finally {

			session.close();

		}
		
		
	}
	
	
	
	
	
	@RequestMapping(value = "/reqadded" , method = {RequestMethod.POST,RequestMethod.GET})
	public String reqAdded(@Valid @ModelAttribute("CustomReqToShop") CustomReqToShop req,
			                BindingResult result) {
		
		if(result.hasErrors())
			return "requestform";
		
		System.out.println(req.getReqId());
		System.out.println(req.getReq());
		System.out.println(req.getReqId());
		System.out.println(req.getDate());
		
		Session session = HiberConfig
				      .getSessionFactory()
				      .getCurrentSession();
		try {

			session.beginTransaction();
			Custom custom = session.get(Custom.class, req.getReqId());
			RequestCustom customreq = new RequestCustom();
			Date date     = DateUtil.getDate( req.getDate());
			BeanUtils.copyProperties(req, customreq);
			customreq.setDate(date);
			System.out.println(customreq.getDate());
			customreq.setReqId(null);
			custom.addRequest(customreq);
			session.save(customreq);
			session.getTransaction().commit();
			
			return "redirect:http://localhost:8080/SpringWithHibernate";	
			
			
			
		}catch(Exception e) {
			
			e.printStackTrace();
			System.out.println(e.getMessage());
			return "requestform";
		}

		finally {

			session.close();

		}
		
	
		
	}
	
	
	
	
	
	public Boolean exists (Session session,String email) {
	    Query query = session.             
	    createQuery("select 1 from Custom t where t.email = :key");
	        query.setParameter("key", email );
	    return (query.uniqueResult() != null);
	}
	

	@InitBinder
	public void InitBinder(WebDataBinder webDataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	
	
	
}
