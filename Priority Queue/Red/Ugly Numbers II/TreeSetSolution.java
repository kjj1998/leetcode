import java.util.*;

class TreeSetSolution {
    public int nthUglyNumber(int n) {
        
        int i = 1;
        TreeSet<Long> set = new TreeSet<>();
        int factor2 = 2;
        int factor3 = 3;
        int factor5 = 5;
        set.add(1L);

        while (i < n) {
            
            long temp = set.pollFirst();
            set.add(factor2 * temp);
            set.add(factor3 * temp);
            set.add(factor5 * temp);

            
            i++;
        }

        return set.pollFirst().intValue();
    }
}