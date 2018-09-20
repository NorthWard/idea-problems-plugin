package com.north.idea.plugins.listeners;


import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.project.Project;
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
        MyProjectService projectService = ServiceManager.getService(project, MyProjectService.class);
       List<String> list = projectService.tt();
       for(String item : list){
           myToolWindows.addItem(item);
       }
    }
}
