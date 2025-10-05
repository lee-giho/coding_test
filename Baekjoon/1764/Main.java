import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken()); // 듣도 못한 사람 수 N 입력
    int M = Integer.parseInt(st.nextToken()); // 보도 못한 사람 수 M 입력

    HashSet<String> unheard = new HashSet<>(); // 듣도 못한 사람 저장할 HashSet
    ArrayList<String> result = new ArrayList<>(); // 듣보잡 사람 저장할 리스트

    // N명의 듣도 못한 사람 입력
    for (int i = 0; i < N; i++) {
      String name = br.readLine();
      unheard.add(name);
    }

    // M명의 보도 못한 사람 입력
    for (int i = 0; i < M; i++) {
      String name = br.readLine();
      if (unheard.contains(name)) { // 듣도 못한 사람에 포함되어 있느면
        result.add(name); // 듣보잡에 추가
      }
    }

    Collections.sort(result); // 오름차순 정렬

    sb.append(result.size()).append("\n");
    for (String name : result) {
      sb.append(name).append("\n");
    }

    System.out.println(sb.toString());
  }
}