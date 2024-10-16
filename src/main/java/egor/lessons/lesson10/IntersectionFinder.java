package egor.lessons.lesson10;

import java.util.Comparator;
import java.util.List;

public class IntersectionFinder {

    public static PowerSet intersection(List<PowerSet> powerSets) {
        if (powerSets.size() < 3) {
            return null;
        }

        if (powerSets.size() % 2 == 0) {
            return getPairPowerSetIntersection(powerSets);
        }

        PowerSet first = powerSets.get(0);
        PowerSet second = getPairPowerSetIntersection(powerSets.subList(1, powerSets.size()));

        return first.size() < second.size()
                ? first.intersection(second)
                : second.intersection(first);
    }

    private static PowerSet getPairPowerSetIntersection(List<PowerSet> powerSets) {
        PowerSet first;
        PowerSet second;

        if (powerSets.size() == 2) {
            first = powerSets.get(0);
            second = powerSets.get(1);
        } else {
            first = getPairPowerSetIntersection(powerSets.subList(0, 2));
            second = getPairPowerSetIntersection(powerSets.subList(2, powerSets.size()));
        }

        return first.size() < second.size()
                ? first.intersection(second)
                : second.intersection(first);
    }
}
