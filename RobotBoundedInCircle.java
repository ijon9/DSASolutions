// https://leetcode.com/problems/robot-bounded-in-circle/
class Solution {
    public boolean isRobotBounded(String instructions) {
        // Find the net movement in each direction, and see if the two directions cancel each other out
        int n = 0, e = 0, s = 0, w = 0;
        char dir = 'n';
        for(int j=0; j<4; j++) {
            for(int i=0; i < instructions.length(); i++) {
                if(instructions.charAt(i) == 'G') {
                    if(dir == 'n') n++;
                    else if(dir == 'e') e++;
                    else if(dir == 's') s++;
                    else w++; 
                }
                else if(instructions.charAt(i) == 'L') dir = changeDir(dir, 'L');
                else dir = changeDir(dir, 'R');
            }
        }
        return n - s == 0 && w - e == 0;
    }

    public char changeDir(char dir, char rotation) {
        if(rotation == 'L') {
            if(dir == 'n') return 'w';
            else if(dir == 'e') return 'n';
            else if(dir == 's') return 'e';
            else return 's';
        } else {
            if(dir == 'n') return 'e';
            else if(dir == 'e') return 's';
            else if(dir == 's') return 'w';
            else return 'n';
        }
    }
}
