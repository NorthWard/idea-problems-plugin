package com.north.idea.plugins.listeners;


import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.module.ModuleServiceManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.projectRoots.Sdk;
import com.intellij.openapi.roots.ProjectRootManager;
import com.intellij.openapi.vfs.VirtualFile;
import com.north.idea.plugins.services.MyModuleService;
import com.north.idea.plugins.services.MyProjectService;
import com.north.idea.plugins.toolwindows.MyToolWindows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class FindAllFilesActionListener implements ActionListener {
    private Project project;
    private MyToolWindows myToolWindows;
    public FindAllFilesActionListener(Project project, MyToolWindows myToolWindows){
        this.project = project;
        this.myToolWindows = myToolWindows;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        MyProjectService myProjectService = ServiceManager.getService(project, MyProjectService.class);
       List< VirtualFile> list = myProjectService.queryAllFiles();
       for(VirtualFile item : list){
           myToolWindows.addItem(item.getUrl());
       }

        Sdk projectSDK = ProjectRootManager.getInstance(project).getProjectSdk();
    }
}
