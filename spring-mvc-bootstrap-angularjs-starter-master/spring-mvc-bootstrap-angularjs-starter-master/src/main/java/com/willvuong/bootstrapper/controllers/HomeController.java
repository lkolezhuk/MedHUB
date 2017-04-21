package com.willvuong.bootstrapper.controllers;

import com.db.management.db.models.User.UserManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: will
 * Date: 11/23/13
 * Time: 12:37 PM
 */
@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {

        UserManager.CreateUser("Leonardo","De","lllasd","asdasf");
        return "/WEB-INF/views/angular-index.jsp";
    }

}
