package com.north.idea.plugins.toolwindows;

import com.intellij.openapi.actionSystem.DataProvider;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.components.JBList;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import com.north.idea.plugins.cellrender.CustomCellRenderer;
import com.north.idea.plugins.listeners.FindAllFilesActionListener;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyToolWindows implements ToolWindowFactory {
    private JPanel myToolWindowContent;
    private JBList problemsList;
    private JButton button1;
    private ToolWindow myToolWindow;
    private Project project;

    public MyToolWindows(){
        problemsList.setCellRenderer(new CustomCellRenderer(10 ,Color.PINK));
        addItem("init");
    }

    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        this.project = project;
        myToolWindow = toolWindow;
        ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();
        Content content = contentFactory.createContent(myToolWindowContent, "", false);
        toolWindow.getContentManager().addContent(content);
        addListeners();
    }

    @Override
    public void init(ToolWindow window) {

    }

    @Override
    public boolean shouldBeAvailable(@NotNull Project project) {
        return false;
    }

    @Override
    public boolean isDoNotActivateOnStart() {
        return false;
    }
    private void addListeners(){
        problemsList.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int c = e.getClickCount();
                if(c >= 2){
                    addItem("dbclick");
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        button1.addActionListener(new FindAllFilesActionListener(this.project, this));
    }
    public void addItem(String text){
        ListModel model = problemsList.getModel();
        if(model instanceof  DefaultListModel){
            ((DefaultListModel) model).addElement(text);
        }else{
            DefaultListModel defaultListModel = new DefaultListModel();
            int size = model.getSize();
            for(int i = 0; i < size; i++){
                defaultListModel.addElement(model.getElementAt(i));
            }
            defaultListModel.addElement(text);
            problemsList.setModel(defaultListModel);
        }
    }

}
