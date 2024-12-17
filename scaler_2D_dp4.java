public class scaler_2D_dp4 {
    public static int totalWaysToReachEnd(int[][] grid){
        int n = grid.length, m = grid[0].length;
        int[][] dp = new int[n][m];
        dp[n-1][m-1] = 1; // Start point

        for (int i = n-1; i>=0; i--) {
           for (int j = m-1; j >= 0; j--) {
               if(i==n-1&&j==m-1) continue;
               int steps = grid[i][j];
               //dp[i][j] = 0;
            // Move Down
               if (i + steps < n) {
                   dp[i][j] += dp[i + steps][j];
               }
            // Move Right
               if (j + steps < m) {
                   dp[i][j] += dp[i][j + steps];
                }
        }
    }
    return dp[n - 1][m - 1]; // Return total ways to reach the bottom-right corner
    }
    public static void main(String[] args) {
        int[][] grid = {
            {2, 3, 1},
            {1, 2, 2},
            {1, 1, 1}
        };
        System.out.println(totalWaysToReachEnd(grid));
    }
}
