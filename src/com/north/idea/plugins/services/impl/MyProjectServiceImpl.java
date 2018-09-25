package com.north.idea.plugins.services.impl;

import com.intellij.openapi.components.ProjectComponent;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.search.FilenameIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.north.idea.plugins.services.MyProjectService;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class MyProjectServiceImpl implements MyProjectService {
    private Project project;
    public MyProjectServiceImpl(Project project){
        this.project = project;
    }
    public List queryAllFiles(){
        Collection<VirtualFile> classConstantMatcherFiles = FilenameIndex.getAllFilesByExt(project, "java", GlobalSearchScope.projectScope(project));
        return (List) classConstantMatcherFiles;
    }
}
