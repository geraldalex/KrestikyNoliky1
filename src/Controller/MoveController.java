package Controller;

import Models.Fields;
import Models.Figure;

import java.awt.*;

public class MoveController {
    public void applyFigure(Fields fields, Point point, Figure figure){
        fields.setFields(point,figure);
    }
}
