import Console.Console;
import Models.Fields;
import Models.Figure;
import Models.Game;
import Models.Player;

public class main {
    public static void main(String[] args) {
        String GameName = "Крестики нолики";

        String name[] = new  String[2];
        name[0] = "Игрок 1";
        name[1] = "Игрок 2";

        Player[] players = new Player[2];
        players[0] = new Player(name[0], Figure.X);
        players[1] = new Player(name[1], Figure.O);

        Game game = new Game(GameName, players, new Fields(3,3));

        Console console = new Console();
        console.show(game);

        while (console.move(game)) {

            console.show(game);

        }

    }
}
