import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int n = Integer.parseInt(br.readLine()); // 로그에 기록된 출입 기록의 수 n을 입력받는다.

    HashSet<String> inCompany = new HashSet<>(); // 현재 회사에 있는 사람을 관리할 집합

    // 한 줄씩 입력받으며 command에 따라 집합에 추가/삭제 한다.
    for (int i = 0; i < n; i++) {
      String line = br.readLine();
      int space = line.indexOf(' '); // 공백 위치 찾기
      String name = line.substring(0, space); // 이름
      String command = line.substring(space + 1); // 명령어: enter || leave

      if (command.equals("enter")) {
        inCompany.add(name);
      } else {
        inCompany.remove(name);
      }
    }

    // 집합에 남은 사람들을 리스트로 변환 후 내림차순 정렬
    ArrayList<String> list = new ArrayList<>(inCompany);
    list.sort(Collections.reverseOrder());

    // 정렬된 이름 출력 버퍼에 저장
    for (String name : list) {
      sb.append(name).append("\n");
    }

    System.out.println(sb.toString());
  }
}