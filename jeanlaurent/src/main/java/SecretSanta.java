import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;

// this implement step1 & 2
public class SecretSanta {
    private final List<String> players;

    public SecretSanta(List<String> players) {
        this.players = secludeFamilyMember(players);
    }

    public List<Pair> assign() {
        List<Pair> result = new ArrayList<>();
        for (int current = 0; current < players.size(); current++) {
            int next = (current + 1) % players.size();
            result.add(new Pair(players.get(current), players.get(next)));
        }
        return result;
    }

    List<String> getPlayers() {
        return ImmutableList.copyOf(players);
    }

    private List<String> secludeFamilyMember(List<String> players) {
        boolean permutation = true;
        while (permutation) {
            permutation = false; // here's come poor man bubble sort, sortof...
            for (int current = 0; current < players.size(); current++) {
                int next = (current + 1) % players.size();
                if (areInTheSameFamily(players.get(current), players.get(next))) {
                    int n2 = (current + 2) % players.size();
                    swap(players, next, n2);
                    permutation = true;
                }
            }
        }
        return players;
    }

    private void swap(List<String> players, int next, int n2) {
        String temp = players.get(next);
        players.set(next, players.get(n2));
        players.set(n2, temp);
    }

    private boolean areInTheSameFamily(String player1, String player2) {
        return familyNameOf(player1).equals(familyNameOf(player2));
    }

    private String familyNameOf(String fullName) {
        return fullName.substring(fullName.indexOf(" ") + 1);
    }

}
