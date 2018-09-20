package com.north.idea.plugins.cellrender;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class CustomCellRenderer extends DefaultListCellRenderer {

    private Font font1;
    private Font font2;
    private Color rowcolor;

    public CustomCellRenderer() {
        this.font1 = getFont();
        this.font2 = font1.deriveFont((float) (font1.getSize() + 10));
    }

    public CustomCellRenderer(int row, Color color) {
        this.rowcolor = color;
    }

    public CustomCellRenderer(int[] rows, Color color) {
        this.rowcolor = color;
    }

    public Component getListCellRendererComponent(JList list, Object value,
                                                  int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
/*       setBackground(this.rowcolor);
         setFont(getFont().deriveFont((float) (getFont().getSize() + 2)));*/
        setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        return this;
    }
}
