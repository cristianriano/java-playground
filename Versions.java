import java.util.Arrays;

public class Versions {
  public static void main(String[] args) {
    String[] list = {"1.0.0"};

    System.out.println(Arrays.toString(list));
    System.out.println(Arrays.toString(solution(list)));
  }

  public static String[] solution(String[] l) {
    Arrays.sort(l, Versions::compare);

    return l;
  }

  public static int compare(String v1, String v2) {
    String[] versions1 = v1.split("\\.");
    String[] versions2 = v2.split("\\.");

    int i = 0;
    for (; i < Math.min(versions1.length, versions2.length); i++) {
      int x = Integer.parseInt(versions1[i]);
      int y = Integer.parseInt(versions2[i]);

      if (x > y) { return 1; }
      else if (x < y) { return -1; }
    }
    if (i == versions1.length) { return -1; }
    if (i == versions2.length) { return 1; }

    return 0;
  }
}
