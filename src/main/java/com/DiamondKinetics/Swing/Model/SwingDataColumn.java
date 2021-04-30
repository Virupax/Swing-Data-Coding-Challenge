package com.DiamondKinetics.Swing.Model;

public enum SwingDataColumn {
    ax, ay, az, wx, wy, wz;

    public static Boolean isValid(String str) {
        for (SwingDataColumn me : SwingDataColumn.values()) {
            if (me.name().equalsIgnoreCase(str))
                return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
