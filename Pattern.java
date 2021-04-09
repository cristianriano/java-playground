import java.util.ArrayList;
import java.util.Collections;

public class Pattern {
  public static void main(String[] args) {
    int i;
    i = Pattern.solution("abcabcabcabc");
    System.out.println(i);

    i = Pattern.solution("abccbaabccba");
    System.out.println(i);

    i = Pattern.solution("aaaaaaaaaa");
    System.out.println(i);

    i = Pattern.solution("abcdefghij");
    System.out.println(i);

    i = Pattern.solution("abababababab");
    System.out.println(i);
  }

  public static int solution(String x) {
    ArrayList<Integer> divisors = allDivisors(x.length());

    boolean invalid;

    for (int size : divisors) {
      String pattern = x.substring(0, size);

      invalid = false;
      for (int i = size; i < x.length(); i += size) {
        if (!pattern.equals(x.substring(i, i+size))) {
          invalid = true;
          break;
        }
      }

      if (!invalid) { return x.length() / size; }
    }

    return 0;
  }

  public static ArrayList<Integer> allDivisors(int n) {
    ArrayList<Integer> divisors = new ArrayList<>();
    divisors.add(1);
    divisors.add(n);

    for (int i = 2; i < Math.sqrt(n); i++) {
      if (n % i == 0) {
        divisors.add(i);
        divisors.add(n/i);
      }
    }

    Collections.sort(divisors);
    return divisors;
  }
}