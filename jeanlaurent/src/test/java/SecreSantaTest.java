import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.fest.assertions.Assertions.assertThat;

public class SecreSantaTest {

    @Test
    public void should_assign_two_people() {
        List<Pair> pairs = (new SecretSanta(asList("Walter White", "Jesse Pinkman"))).assign();
        assertThat(pairs).containsExactly(
                new Pair("Walter White", "Jesse Pinkman"),
                new Pair("Jesse Pinkman", "Walter White")
        );
    }

    @Test
    public void should_assign_three_people() {
        List<Pair> pairs = (new SecretSanta(asList(
                "Walter White",
                "Jesse Pinkman",
                "Saul Goodman"
        ))).assign();
        assertThat(pairs).containsExactly(
                new Pair("Walter White", "Jesse Pinkman"),
                new Pair("Jesse Pinkman", "Saul Goodman"),
                new Pair("Saul Goodman", "Walter White")
        );
    }

    @Test
    public void should_assign_four_people_caring_for_family() {
        List<Pair> pairs = (new SecretSanta(asList(
                "Walter White",
                "Jesse Pinkman",
                "Skyler White",
                "Saul Goodman"
        ))).assign();
        assertThat(pairs).containsExactly(
                new Pair("Walter White", "Jesse Pinkman"),
                new Pair("Jesse Pinkman", "Skyler White"),
                new Pair("Skyler White", "Saul Goodman"),
                new Pair("Saul Goodman", "Walter White")
        );
    }

    @Test
    public void should_assign_four_people_sorted_by_name() {
        List<Pair> pairs = (new SecretSanta(asList(
                "Walter White",
                "Skyler White",
                "Jesse Pinkman",
                "Saul Goodman"
        ))).assign();
        assertThat(pairs).containsExactly(
                new Pair("Walter White", "Jesse Pinkman"),
                new Pair("Jesse Pinkman", "Skyler White"),
                new Pair("Skyler White", "Saul Goodman"),
                new Pair("Saul Goodman", "Walter White")
        );
    }

    @Test
    public void should_seclude_family_member() {
        List<String> players = new SecretSanta(asList(
                "Walter White",
                "Skyler White",
                "Jesse Pinkman",
                "Saul Goodman"
        )).getPlayers();
        assertThat(players).containsExactly(
                "Walter White",
                "Jesse Pinkman",
                "Skyler White",
                "Saul Goodman"
        );
    }

    @Test
    public void should_seclude_family_member_edge_case() {
        List<String> players = new SecretSanta(asList(
                "Walter White",
                "Jesse Pinkman",
                "Saul Goodman",
                "Skyler White"
        )).getPlayers();
        assertThat(players).containsExactly(
                "Jesse Pinkman",
                "Walter White",
                "Saul Goodman",
                "Skyler White"
        );
    }

    @Test
    public void should_handle_edge_case() {
        List<Pair> pairs = new SecretSanta(asList(
                "Walter White",
                "Robert White",
                "Skyler White",
                "WalterJr White",
                "Saul Goodman",
                "Sarah Goodman",
                "Eliot Goodman",
                "Arthur Goodman"
        )).assign();
        assertThat(pairs).containsExactly(
                new Pair("Eliot Goodman", "Skyler White"),
                new Pair("Skyler White", "Saul Goodman"),
                new Pair("Saul Goodman", "WalterJr White"),
                new Pair("WalterJr White", "Sarah Goodman"),
                new Pair("Sarah Goodman", "Robert White"),
                new Pair("Robert White", "Arthur Goodman"),
                new Pair("Arthur Goodman", "Walter White"),
                new Pair("Walter White", "Eliot Goodman")
        );
    }

}
