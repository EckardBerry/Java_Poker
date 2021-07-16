import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.Collections;


public class Poker {

    private final List<String> your_hand = new ArrayList<>();
    public List<Character> random_suites = new ArrayList<>();
    public List<String> random_cards = new ArrayList<>();
    private final List<Character> suites = Arrays.asList('♥', '♠', '♦', '♣');
    private final List<String> cards = Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A");
    private final List<String> cards_rearranged = Arrays.asList("10", "J", "Q", "K", "A", "2", "3", "4", "5", "6", "7", "8", "9");
    public List<String> functions = new ArrayList<>();
    public List<String> score = Arrays.asList("Straight Flush",
                                                "Four of a Kind",
                                                "Full House",
                                                "Flush",
                                                "Straight",
                                                "Three of a kind",
                                                "Two Pair",
                                                "One Pair",
                                                "High Card"
                                            );


    public int random_num(Object[] list) {
        return ThreadLocalRandom.current().nextInt(list.length) % list.length;
    }


    public List<String> draw() {
        for (int i = 1; i <= 5; i++) {
            StringBuilder hand = new StringBuilder();
            Character random_suite_element = suites.get(random_num(suites.toArray()));
            String random_card_element = cards.get(random_num(cards.toArray()));
            random_suites.add(random_suite_element);
            random_cards.add(random_card_element);
            hand.append(random_card_element).append(random_suite_element);
            your_hand.add(hand.toString());
        }
        return your_hand;
    }


    public String search_for_something_straightish() {
        for (int i = 0; i <= cards_rearranged.size() - 5; i++) {
            List<String> sub_list_one = cards.subList(i, i+5);
            List<String> sub_list_two = cards_rearranged.subList(i, i+5);
            if (sub_list_one.containsAll(random_cards)) {
                return straight_or_straight_flush();
            }
            if (sub_list_two.containsAll(random_cards)) {
                return straight_or_straight_flush();
            }
        }
        return null;
    }


    public String straight_or_straight_flush() {
        List<Character> rand_suites = random_suites.stream().distinct().collect(Collectors.toList());
        List<String> rand_cards = random_cards.stream().distinct().collect(Collectors.toList());
        if (rand_suites.size() == 1 && random_cards.size() == rand_cards.size()) {
            return score.get(0);
        }
        if (rand_suites.size() != 1 && random_cards.size() == rand_cards.size()) {
            return score.get(4);
        }
        return null;
    }


    public String four_of_a_kind() {
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


    public String full_house() {
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


    public String flush() {
        List<Character> list = random_suites.stream().distinct().collect(Collectors.toList());
        if (list.size() == 1) {
            return score.get(3);
        }
        return null;
    }


    public String three_of_a_kind() {
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


    public String two_pair() {
        List<Character> list = random_suites.stream().distinct().collect(Collectors.toList());
        int add_up = 0;
        String f_house = full_house();
        if (list.size() != 1) {
            for (String s: random_cards) {
                if (Collections.frequency(random_cards, s) == 2) {
                    add_up++;
                }
            if (f_house == null && add_up == 4) {
                return score.get(6);
                }
            }
        }
        return null;
    }


    public String one_pair() {
        List<Character> list = random_suites.stream().distinct().collect(Collectors.toList());
        int add_up = 0;
        String t_pair = two_pair();
        if (list.size() != 1) {
            for (String s: random_cards) {
                if (Collections.frequency(random_cards, s) == 2) {
                    add_up++;
                }
            if (t_pair == null && add_up == 2) {
                return score.get(7);
                }
            }
        }
        return null;
    }


    private String high_card() {
        return score.get(8);
    }


    public String functions_caller() {
        String s_flush = search_for_something_straightish();
        String four_kind = four_of_a_kind();
        String full_house = full_house();
        String flush = flush();
        String straight = search_for_something_straightish();
        String three_kind = three_of_a_kind();
        String two_pair = two_pair();
        String one_pair = one_pair();
        String high_card = high_card();

        functions.add(s_flush);
        functions.add(four_kind);
        functions.add(full_house);
        functions.add(flush);
        functions.add(straight);
        functions.add(three_kind);
        functions.add(two_pair);
        functions.add(one_pair);
        functions.add(high_card);

        for (String function: functions) {
            if (function != null) {
                return function;
            }
        }
        return score.get(8);
    }
}
