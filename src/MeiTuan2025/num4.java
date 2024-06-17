package MeiTuan2025;

import java.util.*;

public class num4 {
    static final int MOD = 1000000007;

    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        String[] firstLine = reader.nextLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int k = Integer.parseInt(firstLine[1]);
        int[] a = Arrays.stream(reader.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Set<List<Integer>> results = new HashSet<>();
        mergeAndRecord(a, k, results, new ArrayList<>());

        System.out.println(results.size() % MOD);
    }

    private static void mergeAndRecord(int[] array, int k, Set<List<Integer>> results, List<Integer> current) {
        if (array.length == 0) {
            if (current.stream().allMatch(x -> x >= k)) {
                results.add(new ArrayList<>(current));
            }
            return;
        }

        // No merge, continue with the next element
        List<Integer> nextCurrent = new ArrayList<>(current);
        nextCurrent.add(array[0]);
        mergeAndRecord(Arrays.copyOfRange(array, 1, array.length), k, results, nextCurrent);

        // Merge the last element of current with the first element of array if possible
        if (!current.isEmpty() && current.size() > 0) {
            int[] newArray = Arrays.copyOfRange(array, 1, array.length);
            List<Integer> mergedCurrent = new ArrayList<>(current);
            int lastElement = mergedCurrent.remove(mergedCurrent.size() - 1) + array[0];
            mergedCurrent.add(lastElement);
            mergeAndRecord(newArray, k, results, mergedCurrent);
        }
    }
}
