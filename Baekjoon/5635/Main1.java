import java.util.*;
import java.io.*;

public class Main1 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 한 줄 단위로 입력값 입력 받음
    StringTokenizer st = new StringTokenizer(br.readLine()); // 공백을 기준으로 잘라주는 st 생성

    int n = Integer.parseInt(st.nextToken()); // 학생수 N, 정수로 형변환 후 입력

    String[][] birthdays = new String[n][2]; // 학생수 N명에 대한 2차원 배열
    for (int i = 0; i < n; i++) { // 학생의 이름과 생일을 2차원 배열에 저장
      st = new StringTokenizer(br.readLine());
      String name = st.nextToken();
      String day = changeToTwoLetters(st.nextToken());
      String month = changeToTwoLetters(st.nextToken());
      String year = st.nextToken();

      birthdays[i][0] = name;
      birthdays[i][1] = year + month + day; // yyyymmdd로 저장
    }

    Arrays.sort(birthdays, (o1, o2) -> { // 정수 비교 후 내림차순 정렬
      // yyyymmdd 형태로 저장해서 정수값이 클 수록 나이가 적은 사람, 내림차순 정렬을 통해 나이가 적은 생일부터 많은 사람 순으로 정렬됨
      return Integer.compare(Integer.parseInt(o2[1]), Integer.parseInt(o1[1]));
    });

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(birthdays[0][0]); // 가장 나이가 적은 사람의 이름
    bw.newLine();
    bw.write(birthdays[n-1][0]); // 가장 나이가 많은 사람의 이름
    bw.newLine();
    bw.close();
  }

  // month와 day는 1 ~ 9까지 한 자리 수가 될 수 있다. yyyymmdd 형태를 맞춰주기 위해 한 자리 수일 경우 앞에 '0'을 붙여준다.
  public static String changeToTwoLetters(String date) { 
    if (date.length() == 1) { // 한 자리 수일 경우
      date = "0" + date; // 0을 붙여 두 자리로 만들어 반환
    }
    return date;
  }
}