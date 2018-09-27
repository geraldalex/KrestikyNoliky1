package Models;

public class Game {
    private String nameGame;

    public String getNameGame() {
        return nameGame;
    }

    public Player[] getPlayer() {
        return player;
    }

    public Fields getFields() {
        return fields;
    }

    private Player[] player;
    private Fields fields;

    public Game(String nameGame, Player[] player, Fields fields) {
        this.nameGame = nameGame;
        this.player = player;
        this.fields = fields;
    }
}
