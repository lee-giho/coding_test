import java.io.*;
import java.util.*;

public class Main {

  public static void solveWithArraySort() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 한 줄 단위로 입력값 입력 받음
    StringTokenizer st = new StringTokenizer(br.readLine()); // 공백을 기준으로 잘라주는 st 생성

    int n = Integer.parseInt(st.nextToken()); // 회원수 N 정수로 형변환 후 입력
    
    String[][] users = new String[n][2]; // 회원수 N명에 대한 2차원 배열
    for (int i = 0; i < n; i++) { // 회원의 나이와 이름을 2차원 배열에 저장
      st = new StringTokenizer(br.readLine());
      users[i][0] = st.nextToken(); // 나이
      users[i][1] = st.nextToken(); // 이름
    }

    Arrays.sort(users, (o1, o2) -> { // 정수 비교 후 오름차순 정렬
      return Integer.compare(Integer.parseInt(o1[0]), Integer.parseInt(o2[0]));
    });

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
    for (int i = 0; i < n; i++) {
      bw.write(users[i][0] + " " + users[i][1]); // 이름과 나이를 공백으로 구분해 출력
      bw.newLine(); // 줄바꿈
    }
    bw.close();
  }

  public static void solveWithTreeMap() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 한 줄 단위로 입력값 입력 받음
    StringTokenizer st = new StringTokenizer(br.readLine()); // 공백을 기준으로 잘라주는 st 생성

    int n = Integer.parseInt(st.nextToken()); // 회원수 N 정수로 형변환 후 입력
    
    TreeMap<Integer, List<String>> users = new TreeMap<>(); // 회원을 저장할 map
    for (int i = 0; i < n; i++) { // 회원의 나이와 이름을 map에 저장
      st = new StringTokenizer(br.readLine());
      int age = Integer.parseInt(st.nextToken());
      String name = st.nextToken();
      users.computeIfAbsent(age, k -> new ArrayList<>()).add(name); // key 값에 해당하는 value가 존재하면 가져와서 사용하고 없으면 새로 만듦
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
    for (Map.Entry<Integer, List<String>> user : users.entrySet()) { // map에 저장된 (key, value) 쌍을 Set 형태로 가져오기
      int age = user.getKey();
      for (String name : user.getValue()) { // 같은 나이로 저장된 이름 리스트 가져오기
        bw.write(age + " " + name);
        bw.newLine();
      }
    }
    bw.close();
  }

  public static void main(String[] args) {
    try {
      solveWithArraySort();
      // solveWithTreeMap();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}