package com.north.idea.plugins.services.impl;

import com.intellij.openapi.components.ProjectComponent;
import com.intellij.openapi.project.Project;
import com.intellij.psi.search.FilenameIndex;
import com.north.idea.plugins.services.MyProjectService;

import java.util.Arrays;
import java.util.List;

public class MyProjectServiceImpl implements MyProjectService {
    private Project project;
    public MyProjectServiceImpl(Project project){
        this.project = project;
    }
    public List tt(){
        ProjectComponent projectComponent = project.getComponent(ProjectComponent.class);
        String [] classConstantMatcherFiles = FilenameIndex.getAllFilenames(project);
        return Arrays.asList(classConstantMatcherFiles);
    }
}
