package com.north.idea.plugins.components;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.ProjectComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiDocumentManager;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FilenameIndex;
import com.intellij.psi.search.GlobalSearchScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class MyProjectComponents implements ProjectComponent {
    private Project project;
    public MyProjectComponents(){
        super();
    }
    public MyProjectComponents(Project project){
        this.project = project;
    }
    private void tt(){
        String [] classConstantMatcherFiles = FilenameIndex.getAllFilenames(project);
    }

}
