package Day2.Part1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class D2P1 {

    public static void main(String[] args) {


        try {
            List<List<Integer>> lists = readList2("src/Day2/input");

            List<Boolean> listOfIsSafe = lists.stream()
                    .map(x ->isSafe(x))
                    .toList();

            int count = (int) listOfIsSafe.stream()
                    .filter(x -> x)
                    .count();

            System.out.println(count);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isSafe (List<Integer> list) {

            List<Integer> sortedListAsc = list.stream().sorted().toList();

            List<Integer> sortedListDesc = list.stream()
                    .sorted((a, b) -> b - a)
                    .toList();

            var x = true;
            var y = true;

        for (int i = 0; i < sortedListAsc.size() -1; i++) {
            if ((sortedListAsc.get(i+1) - sortedListAsc.get(i)) > 3){
                x = false;
            }
        }

        for (int i = 0; i < sortedListDesc.size() -1; i++) {
            if ((sortedListDesc.get(i) - sortedListDesc.get(i+1)) > 3){
                y = false;
            }
        }
        return (list.equals(sortedListAsc) && x) || (list.equals(sortedListDesc) && y);
    }


    public static List<List<Integer>> readList2(String filePath) throws IOException {

        List<String> lines = Files.readAllLines(Paths.get(filePath));
        List<List<Integer>> lists = new ArrayList<>();

        for (String line : lines) {
            List<Integer> list = new ArrayList<>();
            for (String number : line.split(" ")) {
                list.add(Integer.parseInt(number));
            }
            lists.add(list);;
        }

        return lists;
    }
}
