package com.north.idea.plugins.services;

import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.vfs.VirtualFile;

import java.util.List;

public interface MyProjectService {
    static MyProjectService getInstance() {
        return ServiceManager.getService(MyProjectService.class);
    }

    List<VirtualFile> queryAllFiles();
}
