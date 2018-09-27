package Controller;

import Models.Fields;
import Models.Figure;

import java.awt.*;

public class CurrentController {
    public Figure currentMove(Fields fields){
        int counterFigure = 0;
        for(int x = 0; x < fields.getCoordinateX(); x++){
            counterFigure = counterFigure + countFigureInTheRow(fields,x);
        }
        if (counterFigure == fields.getCoordinateX() * fields.getCoordinateY())
            return null;

        if (counterFigure % 2 == 0)
            return Figure.X;

        return Figure.O;
    }


    public int countFigureInTheRow(Fields fields, int row){
        int countFigure = 0;
        for(int y = 0; y < fields.getCoordinateY(); y++){

            if (fields.getFigure(new Point(row, y)) != null)
                countFigure++;

        }
        return countFigure;
    }
}
