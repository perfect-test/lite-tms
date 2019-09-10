package com.perfecttest.tms.storage.projects;

import com.perfecttest.tms.domain.Project;

import java.util.List;

public interface ProjectsDao {
    List<Project> getAllProjects();

    Project getProjectById(int id);

    void saveNewProject(Project project);

    void updateProject(Project project);

    void deleteProject(Project project);
}
