import java.io.*;
import java.util.*;

public class Main {
  
  static class Person {
    private int weight;
    private int height;
    private int ranking;

    Person(int weight, int height) {
      this.weight = weight;
      this.height = height;
      this.ranking = 1;
    }

    public int getWeight() {
      return this.weight;
    }

    public int getHeight() {
      return this.height;
    }

    public int getRanking() {
      return this.ranking;
    }

    public void increaseRanking() {
      this.ranking++;
    }
  }
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    int n = Integer.parseInt(st.nextToken());

    Person[] persons = new Person[n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int weight = Integer.parseInt(st.nextToken());
      int height = Integer.parseInt(st.nextToken());
      persons[i] = new Person(weight, height);
    }

    compareFrame(persons, n);

    for (int i = 0; i < n; i++) {
      System.out.print(persons[i].getRanking() + " ");
    }
    System.out.println();
  }

  public static void compareFrame(Person[] persons, int n) {
    for (int i = 0; i < n-1; i++) {
      for (int j = i+1; j < n; j++) {
        Person A = persons[i];
        Person B = persons[j];

        if (A.getWeight() > B.getWeight() && A.getHeight() > B.getHeight()) {
          B.increaseRanking();
        } else if (A.getWeight() < B.getWeight() && A.getHeight() < B.getHeight()) {
          A.increaseRanking();
        }
      }
    }
  }
}