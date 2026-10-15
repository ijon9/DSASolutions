// https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/
class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length, n = maze[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[][] dirs = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
        };
        queue.add(entrance);
        int steps = 0;
        maze[entrance[0]][entrance[1]] = '+';
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                int[] curr = queue.poll();
                int r = curr[0];
                int c = curr[1];
                if((r != entrance[0] || c != entrance[1]) && (r == 0 || r == m-1 || c == 0 || c == n-1)) return steps;
                for(int[] dir : dirs) {
                    int nextR = curr[0] + dir[0];
                    int nextC = curr[1] + dir[1];
                    if(nextR < m && nextR >= 0 && nextC < n && nextC >= 0 && maze[nextR][nextC] != '+') {
                        queue.add(new int[] {nextR, nextC});
                        maze[nextR][nextC] = '+';
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}
