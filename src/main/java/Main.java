public class Main {
    public static void main(String[] args) {
        poker game = new poker();

        System.out.println("Your hand: " + game.draw());
        System.out.println(game.functions_caller());
    }
}
