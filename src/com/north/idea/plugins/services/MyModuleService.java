package com.north.idea.plugins.services;

import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.vfs.VirtualFile;

import java.util.List;

public interface MyModuleService {
    static MyModuleService getInstance() {
        return ServiceManager.getService(MyModuleService.class);
    }
    List<VirtualFile> queryAllFiles();
}
