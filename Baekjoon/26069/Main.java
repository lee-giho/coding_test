import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine()); // 사람들이 만난 기록의 수 입력

    Set<String> dancers = new HashSet<>();
    dancers.add("ChongChong"); // 총총이는 처음부터 춤추는 상태

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String A = st.nextToken();
      String B = st.nextToken();

      if (dancers.contains(A) || dancers.contains(B)) { // 한 사람이라도 춤을 추고 있다면 모두 추가
        dancers.add(A);
        dancers.add(B);
      }
    }

    System.out.println(dancers.size());
  }
}