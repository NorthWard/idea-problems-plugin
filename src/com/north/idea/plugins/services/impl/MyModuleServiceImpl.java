package com.north.idea.plugins.services.impl;

import com.intellij.openapi.module.Module;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.search.FilenameIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.north.idea.plugins.services.MyModuleService;

import java.util.Collection;
import java.util.List;

public class MyModuleServiceImpl implements MyModuleService {
    private Module module;
    public MyModuleServiceImpl(Module module){
        this.module = module;
    }

    public List<VirtualFile> queryAllFiles() {
        Collection<VirtualFile> classConstantMatcherFiles = FilenameIndex.getAllFilesByExt(module.getProject(), "*", GlobalSearchScope.moduleScope(module));
        return (List) classConstantMatcherFiles;
    }
}
