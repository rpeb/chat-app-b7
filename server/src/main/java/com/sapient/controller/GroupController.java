package com.sapient.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.sapient.dao.GroupDAO;
import com.sapient.entity.Group;
import com.sapient.interfaces.IGroupDAO;

// http://localhsot:8080/api/health 
// http://localhost:8080/api/group - GET 
//http://localhost:8080/api/group/1 - GET

@RestController
@RequestMapping("/api")
public class GroupController {

	private IGroupDAO dao = new GroupDAO();

	@CrossOrigin(origins = "*")
	@GetMapping("/health")
	public String health() {
		return "Chat Service is UP... ";
	}

	@CrossOrigin(origins = "*")
	@GetMapping("/group")
	public List<Group> getAllGroups() {
		return dao.getAllGroups();
	}

	@CrossOrigin(origins = "*")
	@GetMapping("/group/{gId}")
	public Group getGroup(@PathVariable int gId) {

		return dao.getGroup(gId);
	}

	@CrossOrigin(origins = "*")
	@PostMapping("/group")
	public String insertGroup(@RequestBody Group g) {
		System.out.println(g);
		return dao.saveGroup(g) ? "Inserted" : "Not Inserted";
	}

//	public Group deleteGroup(int group_Id);
//	public Group nameGroup(String  groupName,int groupId);
//	public Group changedescrption(String  groupdescrp,int groupId);

	@CrossOrigin(origins = "*")
	@GetMapping("/deleteGroup/{gId}")
	public String deleteGroup(@PathVariable int gId) {

		return dao.deleteGroup(gId) ? "group deleted" : "fail to delete";
	}

	@CrossOrigin(origins = "*")
	@GetMapping("/renameGroup/{gId}/{newName}")
	public String renameGroup(@PathVariable int gId, @PathVariable String newName) {

		return dao.renameGroup(newName, gId) ? "renamed " : "fail to rename";
	}

	@CrossOrigin(origins = "*")
	@GetMapping("/changeGroupDescription/{gId}/{newText}")
	public String changeGroupDescription(@PathVariable int gId, @PathVariable String newText) {

		return dao.changedescrption(newText, gId) ? "group description changed" : "fail to change group description";
	}

}
