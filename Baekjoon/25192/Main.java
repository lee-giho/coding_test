import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine()); // 채팅방의 기록 수

    Set<String> nickNames = new HashSet<>(); // 방에서 본 닉네임들
    long count = 0; // 전체 인사 횟수

    for (int i = 0; i < N; i++) {
      String s = br.readLine();

      if (s.equals("ENTER")) {
        // 이전 방의 인사 횟수를 더하고 새 방 시작
        count += nickNames.size();
        nickNames.clear();
      } else {
        // 현재 방에서 닉네임 기록
        nickNames.add(s);
      }
    }

    // 마지막 방의 닉네임 수도 더하기
    count += nickNames.size();

    System.out.println(count);
  }
}