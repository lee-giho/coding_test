import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String S = br.readLine(); // 문자열 입력
    int n = S.length(); // 문자열의 길이

    HashSet<String> set = new HashSet<>(); // 서로 다른 문자열을 담을 집합

    // 부분 문자열 집합에 추가
    for (int i = 0; i < n; i++) {
      for (int j = i+1; j < n+1; j++) {
        set.add(S.substring(i, j));
      }
    }

    System.out.println(set.size());
  }
}