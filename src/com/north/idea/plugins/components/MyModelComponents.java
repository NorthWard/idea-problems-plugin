package com.north.idea.plugins.components;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleComponent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class MyModelComponents implements ModuleComponent {
    public MyModelComponents(){
        super();
    }
    public MyModelComponents(Module module){
        super();
    }

}
