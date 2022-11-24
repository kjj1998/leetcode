import java.util.*;

class MyCalendar {

    TreeMap<Integer, Integer> calendar;

    public MyCalendar() {
        calendar = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        Integer prevStart = calendar.floorKey(start);
        Integer nextStart = calendar.ceilingKey(start);

        if ((prevStart == null || calendar.get(prevStart) <= start) && (nextStart == null || end <= nextStart)) 
        {
            calendar.put(start, end);
            return true;
        }

        return false;
    }
}