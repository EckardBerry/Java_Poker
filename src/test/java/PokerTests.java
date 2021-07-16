import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class PokerTests {
    Poker game = new Poker();

    @Test
    public void test_four_of_a_kind_passes() {
        game.random_suites = Arrays.asList('♥', '♠', '♦', '♣', '♣');
        game.random_cards = Arrays.asList("A", "A", "A", "A", "2");
        Assertions.assertEquals(game.score.get(1), game.four_of_a_kind());
    }

    @Test
    public void test_four_of_a_kind_fails() {
        game.random_suites = Arrays.asList('♥', '♠', '♦', '♣', '♣');
        game.random_cards = Arrays.asList("A", "2", "A", "A", "2");
        Assertions.assertNull(game.four_of_a_kind());
    }

    @Test
    public void test_full_house_passes() {
        game.random_cards = Arrays.asList("4", "4", "4", "2", "2");
        Assertions.assertEquals(game.score.get(2), game.full_house());
    }

    @Test
    public void test_full_house_fails() {
        game.random_cards = Arrays.asList("4", "4", "4", "2", "4");
        Assertions.assertNull(game.full_house());
    }

    @Test
    public void test_flush_passes() {
        game.random_suites = Arrays.asList('♥', '♥', '♥', '♥', '♥');
        Assertions.assertEquals(game.score.get(3), game.flush());
    }

    @Test
    public void test_flush_fails() {
        game.random_suites = Arrays.asList('♥', '♥', '♥', '♥', ' ');
        Assertions.assertNull(game.flush());
    }

    @Test
    public void test_three_of_a_kind_passes() {
        game.random_suites = Arrays.asList('♥', '♠', '♦', '♣', '♣');
        game.random_cards = Arrays.asList("4", "J", "10", "J", "J");
        Assertions.assertEquals(game.score.get(5), game.three_of_a_kind());
    }

    @Test
    public void test_three_of_a_kind_fails() {
        game.random_suites = Arrays.asList('♥', '♠', '♦', '♣', '♣');
        game.random_cards = Arrays.asList("J", "J", "10", "J", "J");
        Assertions.assertNull(game.three_of_a_kind());
    }

    @Test
    public void test_two_pair_passes() {
        game.random_suites = Arrays.asList('♥', '♠', '♦', '♣', '♣');
        game.random_cards = Arrays.asList("A", "7", "A", "2", "7");
        Assertions.assertEquals(game.score.get(6), game.two_pair());
    }

    @Test
    public void test_two_pair_fails() {
        game.random_suites = Arrays.asList('♥', '♠', '♦', '♣', '♣');
        game.random_cards = Arrays.asList("A", "7", "A", "7", "7");
        Assertions.assertNull(game.two_pair());
    }

    @Test
    public void test_one_pair_passes() {
        game.random_suites = Arrays.asList('♥', '♠', '♦', '♣', '♣');
        game.random_cards = Arrays.asList("A", "K", "Q", "7", "K");
        Assertions.assertEquals(game.score.get(7), game.one_pair());
    }

    @Test
    public void test_one_pair_fails() {
        game.random_suites = Arrays.asList('♥', '♠', '♦', '♣', '♣');
        game.random_cards = Arrays.asList("7", "K", "Q", "7", "K");
        Assertions.assertNull(game.one_pair());
    }

    @Test
    public void test_search_for_straigh_flush_passes() {
        game.random_suites = Arrays.asList('♥', '♥', '♥', '♥', '♥');
        game.random_cards = Arrays.asList("A", "2", "3", "4", "5");
        Assertions.assertEquals(game.score.get(0), game.search_for_something_straightish());
    }

    @Test
    public void test_search_for_straigh_flush_fails() {
        game.random_suites = Arrays.asList('♥', '♥', '♥', '♥', '♥');
        game.random_cards = Arrays.asList("A", "2", "2", "A", "A");
        Assertions.assertNull(game.search_for_something_straightish());
    }

    @Test
    public void test_search_for_straigh_passes() {
        game.random_suites = Arrays.asList('♥', '♠', '♦', '♣', '♣');
        game.random_cards = Arrays.asList("Q", "10", "K", "J", "A");
        Assertions.assertEquals(game.score.get(4), game.search_for_something_straightish());
    }

    @Test
    public void test_search_for_straight_fails() {
        game.random_suites = Arrays.asList('♥', '♥', '♥', '♥', '♥');
        game.random_cards = Arrays.asList("Q", "10", "K", "5", "A");
        Assertions.assertNull(game.search_for_something_straightish());
    }
}
