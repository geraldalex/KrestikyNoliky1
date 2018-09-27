package Models;

import java.awt.*;

public class Fields {
    private static int minCoordinate = 0;
    private int coordinateX;
    private int coordinateY;
    private Figure figures[][];



    public Fields(int coordinateX, int coordinateY){
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        figures = new Figure[coordinateX][coordinateY];
    }

    public int getCoordinateX() {
        return coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    public Figure getFigure(Point point){
        return figures[point.x][point.y];
    }

    public void setFields(Point  point,Figure figure){
        figures[point.x][point.y] = figure;

    }

    private boolean checkPoint(Point point) {

        return checkCoordinate(point.x, figures.length) && checkCoordinate(point.y, figures[point.x].length);

    }

    private boolean checkCoordinate(final int coordinate, final int maxCoordinate) {

        return coordinate >= minCoordinate && coordinate < maxCoordinate;

    }
}
