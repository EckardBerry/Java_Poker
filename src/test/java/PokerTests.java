import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class PokerTests {
    @Test
    public void test_four_of_a_kind_passes() {
        poker.random_suites = Arrays.asList('♥', '♠', '♦', '♣', '♣');
        poker.random_cards = Arrays.asList("A", "A", "A", "A", "2");
        Assertions.assertEquals(poker.score.get(1), poker.four_of_a_kind());
    }

    @Test
    public void test_four_of_a_kind_fails() {
        poker.random_suites = Arrays.asList('♥', '♠', '♦', '♣', '♣');
        poker.random_cards = Arrays.asList("A", "2", "A", "A", "2");
        Assertions.assertNull(poker.four_of_a_kind());
    }


    @Test
    public void test_full_house_passes() {
        poker.random_cards = Arrays.asList("4", "4", "4", "2", "2");
        Assertions.assertEquals(poker.score.get(2), poker.full_house());
    }

    @Test
    public void test_full_house_fails() {
        poker.random_cards = Arrays.asList("4", "4", "4", "2", "4");
        Assertions.assertNull(poker.full_house());
    }
}
