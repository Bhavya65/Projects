package com.ctrl;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.DB.thread_ImportData;
import com.dao.springDao;
import com.entities.spring;
import com.entities.login;


@Controller
public class HomeCtrl {

    @Autowired
    springDao springDao;

    @RequestMapping("/home")
    public String home(Model m) {
        
        String str = "";
        m.addAttribute("page", str);
        return "home";
    }

    @RequestMapping("/add")
    public String addspring(Model m) {
        spring t = new spring();
        m.addAttribute("page", "add");
        m.addAttribute("spring", t);
        File f = new File("C:\\Users\\bhavyachhabra\\Documents\\AssignmentLinks");
        String[] pathnames;
        pathnames = f.list();
        Thread[] threads = new Thread[pathnames.length];
        for (int i = 0; i < pathnames.length; i++) {
            threads[i] = new Thread(new thread_ImportData(pathnames[i]));
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
            try {
                threads[i].join();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return "home";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String savespring(@ModelAttribute("spring") spring t, Model m) {
        String str = "HOME";
        m.addAttribute("page", str);
        List<spring> list = this.springDao.getAll(t.getDelLoc(), t.getArrLoc(), t.getValidTill(), t.getClass1(),
                t.getOutPref());
        m.addAttribute("springs", list);
        return "home";
    }
    
    @RequestMapping(value = "/", method = RequestMethod.GET) 
    public String displayLogin(Model model) { 
        model.addAttribute("login", new login()); 
        return "home"; 
    }

    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("login") login t, Model m) {
        
        if(t.getUname()=="Bhavya" && t.getPass()=="password") {
        m.addAttribute("page", "SUCCESS");}
        else {
            m.addAttribute("page", "FAILURE");
        }
        return "home";
    }

}