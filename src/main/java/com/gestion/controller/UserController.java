package com.gestion.controller;

import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gestion.domain.User;
import com.gestion.domain.security.Role;
import com.gestion.domain.security.UserRole;
import com.gestion.service.RoleService;
import com.gestion.service.UserService;
import com.gestion.service.VilleService;
import com.gestion.utility.SecurityUtility;

@Controller
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	@Autowired 
	private VilleService villeService;
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping("/UserList")
	public String userlist(Model model) {
		model.addAttribute("title", "List of Users");
		model.addAttribute("userList", userService.findAll());
		return "user/list";
	}
	
	@RequestMapping("/addUser")
	public String addUser(Model model) {
		model.addAttribute("title", "add User");
		model.addAttribute("user", new User());
		model.addAttribute("RoleList", roleService.findAll());
		model.addAttribute("villeList", villeService.findAll());
		model.addAttribute("roles", new Role());
		return "user/add";
	}
	
	@RequestMapping(value="/addUser", method=RequestMethod.POST)
	public String addUserPost(@ModelAttribute("user") User user,@ModelAttribute("Role") Role role) {
		try {
			Set<UserRole> userRoles = new HashSet<>();
			user.setPassword(SecurityUtility.passwordEncoder().encode(user.getPassword()));
			userRoles.add(new UserRole(user,role));
			userService.createUser(user, userRoles);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:UserList";
	}
	
	@RequestMapping(value="DeleteUser",method=RequestMethod.POST)
	public String deleteUser(@ModelAttribute("id") String id) {
		userService.deleteUserById(Long.parseLong(id.substring(8)));
		return "redirect:UserList";
	}

	@RequestMapping(value="DeleteUsers",method=RequestMethod.POST)
	public String deleteUsers(@RequestBody ArrayList<String> UserIds) {
		for( String id : UserIds) {
			userService.deleteUserById(Long.parseLong(id.substring(8)));
		}
		return "redirect:UserList";
	}
	
	@RequestMapping("/updateUser")
	public String updateUser(@RequestParam("id") Long id,Model model) {
		User user = userService.findBydId(id);
		List<Long> roleIds = new ArrayList<>();
		List<Role> roles = new ArrayList<>();
		for (UserRole ur : user.getUserRoles()) {
			roleIds.add(ur.getRole().getRoleId());
		}
		model.addAttribute("title", "update User");
		model.addAttribute("user",user);
		model.addAttribute("UserRole",roleIds);
		model.addAttribute("roles", roles);
		model.addAttribute("RoleList", roleService.findAll());
		model.addAttribute("villeList", villeService.findAll());
		return "user/update";
	}
	
	@RequestMapping(value="/updateUser",method=RequestMethod.POST)
	public String updateUserPost(@RequestBody User user) {
		//userService.save(user);
		return "redirect:UserList";
	}
}
