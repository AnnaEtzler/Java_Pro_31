package lesson13.homework.Comparator;

import java.util.Comparator;

public class PlayerRankComparator implements Comparator<Player> {

    @Override
    public int compare(Player o1, Player o2) {
        return Integer.compare(o1.getRank(), o2.getRank());
    }
}
