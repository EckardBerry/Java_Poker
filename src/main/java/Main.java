public class Main {
    public static void main(String[] args) {
        Poker game = new Poker();

        System.out.println("Your hand: " + game.draw());
        System.out.println(game.functions_caller());
    }
}
