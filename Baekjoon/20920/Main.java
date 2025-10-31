import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken()); // 단어의 개수
    int M = Integer.parseInt(st.nextToken()); // 외울 단어의 길이

    // 단어 저장 및 빈도 수 계산
    Map<String, Integer> freq = new HashMap<>();
    for (int i = 0; i < N; i++) {
      String word = br.readLine();
      if (word.length() < M) continue;
      freq.put(word, freq.getOrDefault(word, 0) + 1);
    }

    // 리스트로 변환 후 3가지 기준으로 정렬
    List<Map.Entry<String, Integer>> list = new ArrayList<>(freq.entrySet());
    list.sort((a, b) -> {
      // 빈도 내림차순
      int freqA = a.getValue();
      int freqB = b.getValue();
      if (freqA != freqB) return freqB - freqA;

      // 길이 내림차순
      int lenA = a.getKey().length();
      int lenB = b.getKey().length();
      if (lenB != lenA) return lenB - lenA;

      // 사전순 오름차순
      return a.getKey().compareTo(b.getKey());
    });

    // 정렬된 단어만 출력
    for (Map.Entry<String, Integer> e : list) {
      sb.append(e.getKey()).append("\n");
    }

    System.out.println(sb.toString());
  }
}