package com.vice.springboot.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin

public class ProjectController {
    //	@GetMapping
//	public String hello() {
//		return "HELLO World";
//	}
//
    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @RequestMapping(path = "api/v1/project1")
    @GetMapping
    public List<ProjectModel> getProject1() {
        return projectService.getProject1();
    }

    @RequestMapping(path = "api/v1/project2")
    @GetMapping
    public List<ProjectModel> getProject2() {
        return projectService.getProject2();
    }

    @RequestMapping(path = "api/v1/storeNewProject")
    @PostMapping
    public String postProject(@RequestBody ProjectModel projectModel) {
        projectService.addNewProject(projectModel);
        return "New Project Added";
    }

    @RequestMapping(path = "api/v1/deleteProject/{projectId}")
    @DeleteMapping
    public void deleteProject(@PathVariable("projectId") Integer projectId) {
        projectService.deleteProject(projectId);
    }

    @RequestMapping(path = "api/v1/deleteProject")
    @DeleteMapping
    public void deleteProject1(@RequestBody Integer projectId) {
        projectService.deleteProject(projectId);
    }

    @RequestMapping(path = "api/v1/updateProject/{projectId}")
    @PutMapping
    public void updateProject1(
            @PathVariable("projectId") Integer projectId,
            @RequestParam(required = false) String projectName,
            @RequestParam(required = false) Integer consultantId,
            @RequestParam(required = false) Integer consumerId,
            @RequestParam(required = false) String startDate,
            @RequestParam(required = false) String endDate,
            @RequestParam(required = false) String status) {
        projectService.updateProject(projectId, projectName, consultantId, consumerId, startDate, endDate, status);
    }

    @RequestMapping(path = "api/v1/updateProject")
    @PutMapping
    public void updateProject2(
            @RequestBody Integer projectId,
            @RequestParam(required = false) String projectName,
            @RequestParam(required = false) Integer consultantId,
            @RequestParam(required = false) Integer consumerId,
            @RequestParam(required = false) String startDate,
            @RequestParam(required = false) String endDate,
            @RequestParam(required = false) String status) {
        projectService.updateProject(projectId, projectName, consultantId, consumerId, startDate, endDate, status);
    }

}

