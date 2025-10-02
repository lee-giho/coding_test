import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());
 
    int N = Integer.parseInt(st.nextToken()); // 포켓몬의 개수
    int M = Integer.parseInt(st.nextToken()); // M: 맞춰야 하는 문제의 개수

    
    String[] idToName = new String[N + 1]; // 번호 -> 이름
    Map<String, Integer> nameToId = new HashMap<>(); // 이름 -> 번호
    
    // 포켓몬 도감 입력
    for (int i = 1; i < N+1; i++) {
      String name = br.readLine();
      idToName[i] = name;
      nameToId.put(name, i);
    }

    // 문제 처리
    for (int i = 0; i < M; i++) {
      String line = br.readLine();
      if (Character.isDigit(line.charAt(0))) { // 숫자면
        int index = Integer.parseInt(line);
        sb.append(idToName[index]).append("\n"); // 이름 출력
      } else { // 문자열이면
        sb.append(nameToId.get(line)).append("\n"); // 번호 출력
      }
    }

    System.out.println(sb.toString());
  }
}