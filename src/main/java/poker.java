import java.util.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class poker {

    static List<String> your_hand = new ArrayList<>();
    static List<Character> random_suites = new ArrayList<>();
    static List<String> random_cards = new ArrayList<>();
    static List<Character> suites = Arrays.asList('♥', '♠', '♦', '♣');
    static List<String> cards = Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A");
    static List<String> cards_rearranged = Arrays.asList("10", "J", "Q", "K", "A", "2", "3", "4", "5", "6", "7", "8", "9");

    static List<String> score = Arrays.asList("Straight Flush",
                                                "Four of a Kind",
                                                "Full House",
                                                "Flush",
                                                "Straight",
                                                "Three of a kind",
                                                "Two Pair",
                                                "One Pair",
                                                "High Card"
                                            );

    static void draw() {
        for (int i = 1; i<= 5; i++) {
            Random rand = new Random();
            StringBuilder hand = new StringBuilder();
            Character random_suite_element = suites.get(rand.nextInt(suites.size()));
            String random_card_element = cards.get(rand.nextInt(cards.size()));
            random_suites.add(random_suite_element);
            random_cards.add(random_card_element);
            hand.append(random_card_element.charAt(0)).append(random_suite_element);
            your_hand.add(hand.toString());
        }
    }


    static String four_of_a_kind() {
        List<Character> list = random_suites.stream().distinct().collect(Collectors.toList());
        if (list.size() != random_suites.size()) {
            for (String s: random_cards) {
                if (Collections.frequency(random_cards, s) == 4){
                    return score.get(1);
                }
            }
        }
        return null;
    }


    static String full_house() {
        int add_up = 0;
        for (String s: random_cards){
            if (Collections.frequency(random_cards, s) == 2 || Collections.frequency(random_cards, s) == 3){
                add_up++;
            }
        if (add_up == 5){
            return score.get(2);
            }
        }
        return null;
    }


    static String flush() {
        List<Character> list = random_suites.stream().distinct().collect(Collectors.toList());
        if (list.size() == 1) {
            return score.get(3);
        }
        return null;
    }


    static String three_of_a_kind() {
        List<Character> list = random_suites.stream().distinct().collect(Collectors.toList());
        if (list.size() != 1) {
            for (String s: random_cards) {
                if (Collections.frequency(random_cards, s) == 3) {
                    return score.get(5);
                }
            }
        }
        return null;
    }





    public static void main(String[] args) {
        draw();
        System.out.println("Your hand: " + your_hand);
    }
}
