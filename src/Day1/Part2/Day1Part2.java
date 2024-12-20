package Day1.Part2;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static Day1.Part1.Day1Part1.readList;

public class Day1Part2 {

    public static void main(String[] args) {

        try {
            List<List<Integer>> lists = readList("src/inputDay1");

            List<Integer> locations1 = lists.get(0);
            List<Integer> locations2 = lists.get(1);

            Optional<Integer> totalSimilarityScore = locations1.stream()
                    .map(x -> findSimilarityScore(x, locations2))
                    .reduce(Integer::sum);

            System.out.println(totalSimilarityScore.get());


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static int findSimilarityScore(int x, List<Integer> rightList){
        int z = (int) rightList.stream()
                .filter(y -> y == x)
                .count();
        return x * z;
    }
}

