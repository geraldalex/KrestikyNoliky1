package Console;

import Controller.CurrentController;
import Controller.MoveController;
import Controller.WinnerController;
import Models.Fields;
import Models.Figure;
import Models.Game;
import java.awt.*;
import java.util.Scanner;

public class Console {
    private CurrentController currentController = new CurrentController();
    private MoveController moveController = new MoveController();
    private WinnerController winnerController = new WinnerController();
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_YELOW = "\u001B[33m";


    public void show(Game game) {
        System.out.println(ANSI_BLUE+"Имя игры: " + game.getNameGame()+ANSI_RESET);
        printField(game);

    }

    public boolean move(Game game) {
        Fields fields = game.getFields();
        Figure winner = winnerController.getWinner(fields);

        if (winner != null) {
            System.out.printf("Победитель %s:\n", winner);
            return false;
        }

        Figure currentFigure = currentController.currentMove(fields);
        if (currentFigure == null) {

            System.out.println("И победители!!!");
            return false;

        }

        System.out.format(ANSI_BLUE+"Веедите координаты движения для: %s\n"+ANSI_RESET, currentFigure);

        Point point = ascPoint();
        moveController.applyFigure(fields,point,currentFigure);
        return true;

    }

    public Point ascPoint () {

        return new Point(ascCoordinat("X") - 1, ascCoordinat("O") - 1);

    }

    public int ascCoordinat( String coordinatName) {

        System.out.format("Введите %s: ", coordinatName);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
        }



    public void printField(Game game) {

        final Fields fields = game.getFields();

        for (int i = 0; i < fields.getCoordinateX(); i++) {

            printFor(fields, i);

            if (i <= fields.getCoordinateX() - 2) {
                printSeparator(game.getFields());
            }

        }

    }
    public static void printFor( Fields fields, int x) {

        for (int y = 0; y < fields.getCoordinateY(); y++) {

            if (y == 0) System.out.print(" ");

            if (y < fields.getCoordinateY() ) {

                Figure figure;
                figure = fields.getFigure(new Point(x, y));
                System.out.print(figure != null ? figure : " ");

                if (y != fields.getCoordinateY() - 1) {
                    System.out.print(ANSI_YELOW+" | "+ANSI_RESET);
            }
            }

        }
        System.out.println();
    }

    public static void printSeparator(final Fields fields){

        for (int i = 0; i <= fields.getCoordinateX() * 1.8; i++) {
            System.out.print(ANSI_YELOW+"- "+ANSI_RESET);
        }
        System.out.print("\n");
    }
}