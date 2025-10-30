import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine()); // 정수의 개수
    int[] nums = new int[N]; // 정수 저장할 배열
    int sum = 0;

    for (int i = 0; i < N; i++) {
      nums[i] = Integer.parseInt(br.readLine());
      sum += nums[i];
    }

    Arrays.sort(nums);

    // 1. 산술평균
    int mean = (int) Math.round((double) sum / N);

    // 2. 중앙값
    int median = nums[N / 2];

    // 3. 최빈값
    Map<Integer, Integer> freq = new HashMap<>();
    for (int n : nums) {
      freq.put(n, freq.getOrDefault(n, 0) + 1);
    }

    // 빈도 내림차순, 값 오름차순 정렬
    List<Map.Entry<Integer, Integer>> list = new ArrayList<>(freq.entrySet());
    list.sort((a, b) -> {
      if (!a.getValue().equals(b.getValue())) {
        return b.getValue() - a.getValue(); // 빈도 내림차순
      } else {
        return a.getKey() - b.getKey(); // 값 오름차순
      }
    });

    int mode;
    if (list.size() > 1 && list.get(0).getValue().equals(list.get(1).getValue())) { // 원소가 2개 이상이고, 최빈값이 두 개 이상 존재할 때
      mode = list.get(1).getKey(); // 두 번째로 작은 값
    } else {
      mode = list.get(0).getKey(); // 유일한 최빈값
    }

    // 4. 범위
    int range = nums[N - 1] - nums[0];

    System.out.println(mean);
    System.out.println(median);
    System.out.println(mode);
    System.out.println(range);
  }
}