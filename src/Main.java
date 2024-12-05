import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public static void main(String[] args) {

    try {
        List<List<Integer>> lists = readList("src/inputDay1");

        List<Integer> locations1 = lists.get(0);
        List<Integer> locations2 = lists.get(1);

        List<Integer> sortedLocations1 = sortedList(locations1);
        List<Integer> sortedLocations2 = sortedList(locations2);

        List<Integer> distances = distanceList(sortedLocations1, sortedLocations2);
        Integer sum = sumDistanceList(distances);

        System.out.println("Sum of Distances: " + sum);
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    public static List<List<Integer>> readList(String filePath) throws IOException {

        List<String> lines = Files.readAllLines(Paths.get(filePath));
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for (String line : lines) {
            String[] parts = line.trim().split("\\s+");
            list1.add(Integer.parseInt(parts[0]));
            list2.add(Integer.parseInt(parts[1]));
        }

        List<List<Integer>> lists = new ArrayList<>();
        lists.add(list1);
        lists.add(list2);
        return lists;
}


    public static List<Integer> sortedList(List<Integer> location) {
        return location.stream()
                .sorted()
                .collect(Collectors.toList());
    }

public static List<Integer> distanceList(List<Integer> locations1, List<Integer> locations2) {
    return IntStream.range(0, locations1.size())
            .mapToObj(i -> Math.abs(locations1.get(i) - locations2.get(i)))
            .collect(Collectors.toList());
}

    public static Integer sumDistanceList(List<Integer> locations) {
        return locations.stream()
                .reduce(0, Integer::sum);
    }
