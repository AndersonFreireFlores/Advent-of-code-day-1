package Day1;

import java.util.List;

import java.util.stream.Collectors;

public class Main {
    List<Integer> sortedList(List<Integer> location) {
        return location.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    List<Integer> distanceList(List<Integer> locations1, List<Integer> locations2) {
        return locations1.stream()
                .map(i -> Math.abs(locations1.get(i) - locations2.get(i)))
                .collect(Collectors.toList());
    }

    Integer sumList(List<Integer> locations) {
        return locations.stream()
                .reduce(0, Integer::sum);
    }
}

