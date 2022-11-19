import java.util.*;

class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {

        List<List<Integer>> result = new ArrayList<>();

        if (buildings == null || buildings.length == 0
            || buildings[0].length == 0) {
            return result;
        }

        List<Edge> edges = new ArrayList<Edge>();

        // add all left/right edges
        for (int[] each: buildings) {
            edges.add(new Edge(each[0], each[2], true));
            edges.add(new Edge(each[1], each[2], false));
        }

        // sort edges, NlogN
        Collections.sort(edges, (a, b) -> {
            if (a.x != b.x) {
                return Integer.compare(a.x, b.x);
            }

            if (a.isStart && b.isStart) {
                return Integer.compare(b.height, a.height); // higher edge at front
            }

            if (!a.isStart && !b.isStart) {
                return Integer.compare(a.height, b.height); // lower edge at front
            }

            return a.isStart ? -1 : 1; // lower edge at front
        });

        // process edges, comparator is reverseOrder()
        PriorityQueue<Integer> heightHeap = new PriorityQueue<Integer>(Collections.reverseOrder());

        for (Edge edge : edges) {

            if (edge.isStart) {

                if (heightHeap.isEmpty() || edge.height > heightHeap.peek()) {
                    result.add(Arrays.asList( edge.x, edge.height ));
                }

                heightHeap.add(edge.height);

            } else {

                heightHeap.remove(edge.height);

                if (heightHeap.isEmpty()){
                    result.add( Arrays.asList(edge.x, 0) ); // last point
                } else if (edge.height > heightHeap.peek()){ // @note: intersect
                    result.add( Arrays.asList(edge.x, heightHeap.peek()) );
                }
            }
        }
        return result;
    }

    class Edge {
        int x; // x坐标
        int height;
        boolean isStart;

        public Edge(int x, int height, boolean isStart) {
            this.x = x;
            this.height = height;
            this.isStart = isStart;
        }
    }
}