package mypack;

import java.util.Scanner;
public class Test {
    static Scanner in;
    public static void main(String[] args) {
        int t;
        in = new Scanner(System.in);
        t = in.nextInt();
        while (t-->0) {
            solve();
        }

    }
    static void solve() {
        String nstr;
        String mstr;
        int y = 0, z =0;
        nstr = in.next();
        mstr = in.next();
        int decimalI = mstr.indexOf('.');
        int n = Integer.valueOf(nstr);
        float m = Float.valueOf(mstr);

        if (decimalI == -1) {
            System.out.println(n+"."+(n+(int)m));
        } else {
            String frac = mstr;
            frac = frac.substring(frac.indexOf('.')+1);
            y = (int)m;
            z = Integer.valueOf(frac);
            System.out.println(((int)z+n)+"."+(y+n));
        }
    }
}