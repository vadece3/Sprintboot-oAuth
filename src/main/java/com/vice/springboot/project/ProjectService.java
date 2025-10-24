package com.vice.springboot.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> getProject1() {
        return projectRepository.findAll();
    }

    public List<Project> getProject2() {
        return List.of(
                new Project(
                        "testproject",
                        22,
                        222,
                        "0",
                        "0",
                        "not_done"
                )
        );
    }

    public void addNewProject(Project project) {
            projectRepository.save(project);
    }

    public void deleteProject(Integer projectId) {
        boolean exists = projectRepository.existsById(projectId);
        if (!exists) {
            throw new IllegalStateException(
                    "Entries with id " + projectId + " does not exists");
        } else {
            projectRepository.deleteById(projectId);
        }
    }

    @Transactional
    public void updateProject(
            Integer projectId,
            String projectName,
            Integer consultantId,
            Integer consumerId,
            String startDate,
            String endDate,
            String Status) {

        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new IllegalStateException(
                        "project with id " + projectId + " does not exist"));


        if (projectName != null &&
                projectName.length() > 0 &&
                !Objects.equals(project.getProjectName(), projectName)) {
            project.setProjectName(projectName);
        }

        if (consultantId != null &&
                consultantId > 0 &&
                !Objects.equals(project.getConsultantId(), consultantId)) {
            project.setConsultantId(consultantId);
        }

        if (consumerId != null &&
                consumerId > 0 &&
                !Objects.equals(project.getConsumerId(), consumerId)) {
            project.setConsumerId(consumerId);
        }

        if (startDate != null &&
                startDate.length() > 0 &&
                !Objects.equals(project.getStartDate(), startDate)) {
            project.setStartDate(startDate);
        }

        if (endDate != null &&
                endDate.length() > 0 &&
                !Objects.equals(project.getEndDate(), endDate)) {
            project.setEndDate(endDate);
        }

        if (Status != null &&
                Status.length() > 0 &&
                !Objects.equals(project.getStatus(), Status)) {
            project.setStatus(Status);
        }

    }

}

