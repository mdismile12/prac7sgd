
import java.util.Scanner;

class seventh {
    static String[] rules = new String[10];
    static String[] first = new String[10];
    static int n;
    static void Find_first() {
        for (int i = 0; i < n; i++)
            first[i] = "";

        boolean change;
        do {
            change = false;

            for (int i = 0; i < n; i++) {
                char lhs = rules[i].charAt(0);
                String rhs = rules[i].substring(2);
                String[] parts = rhs.split("\\|");

                for (String p : parts) {
                    boolean nullable = true;

                    if (p.equals("#")) {
                        if (!first[i].contains("#")) {
                            first[i] += "#";
                            change = true;
                        }
                        continue;
                    }

                    for (int j = 0; j < p.length(); j++) {
                        char c = p.charAt(j);
                        String f = "";

                        if (c >= 'a' && c <= 'z') {
                            f = "" + c;
                        } else {
                            for (int k = 0; k < n; k++) {
                                if (rules[k].charAt(0) == c)
                                    f += first[k];
                            }
                        }
                        for (int k = 0; k < f.length(); k++) {
                            char x = f.charAt(k);
                          if (x != '#' && !first[i].contains("" + x)) {
                                first[i] += x;
                                change = true;
                            }
                        }
                        if (!f.contains("#")) {
                            nullable = false;
                            break;
                        }
                    }

                    if (nullable && !first[i].contains("#")) {
                        first[i] += "#";
                        change = true;
                    }
                }
            }
        } while (change);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of production rules: ");
        n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter rule (A=ab|#): ");
            rules[i] = sc.nextLine().replace(" ", "");
        }

        Find_first();

        System.out.println("\nFIRST sets:");
        for (int i = 0; i < n; i++)
            System.out.println("FIRST(" + rules[i].charAt(0) + ") = {"+ first[i] + "}");
    }
}