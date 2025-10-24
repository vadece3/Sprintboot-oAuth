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

    public List<ProjectModel> getProject1() {
        return projectRepository.findAll();
    }

    public List<ProjectModel> getProject2() {
        return List.of(
                new ProjectModel(
                        1,
                        222,
                        22,
                        "testproject",
                        "0",
                        "0",
                        "not_done"
                )
        );
    }

    public void addNewProject(ProjectModel projectModel) {
        Optional<ProjectModel> projectById = projectRepository.
                findById(projectModel.getId());
        if (projectById.isPresent()) {
            throw new IllegalStateException("id is already taken");
        } else {
            projectRepository.save(projectModel);
        }
    }
    public void deleteProject(Integer projectId) {
        boolean exists = projectRepository.existsById(projectId);
        if (!exists) {
            throw new IllegalStateException(
                    "EntriesModel with id " + projectId + " does not exists");
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

        ProjectModel projectModel = projectRepository.findById(projectId)
                .orElseThrow(() -> new IllegalStateException(
                        "projectModel with id " + projectId + " does not exist"));


        if (projectName != null &&
                projectName.length() > 0 &&
                !Objects.equals(projectModel.getProjectName(), projectName)) {
            projectModel.setProjectName(projectName);
        }

        if (consultantId != null &&
                consultantId > 0 &&
                !Objects.equals(projectModel.getConsultantId(), consultantId)) {
            projectModel.setConsultantId(consultantId);
        }

        if (consumerId != null &&
                consumerId > 0 &&
                !Objects.equals(projectModel.getConsumerId(), consumerId)) {
            projectModel.setConsumerId(consumerId);
        }

        if (startDate != null &&
                startDate.length() > 0 &&
                !Objects.equals(projectModel.getStartDate(), startDate)) {
            projectModel.setStartDate(startDate);
        }

        if (endDate != null &&
                endDate.length() > 0 &&
                !Objects.equals(projectModel.getEndDate(), endDate)) {
            projectModel.setEndDate(endDate);
        }

        if (Status != null &&
                Status.length() > 0 &&
                !Objects.equals(projectModel.getStatus(), Status)) {
            projectModel.setStatus(Status);
        }

    }

}

