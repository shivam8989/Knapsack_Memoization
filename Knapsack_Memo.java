package Dynamic_Programming;

public class Knapsack_Memo {
    public static int Knapsack(int val[], int wt[], int W, int n, int dp[][]){
        if(n==0 || W==0){
            return 0;
        }
        if(dp[n][W]!=-1){
            return dp[n][W];
        }
        if(wt[n-1]<=W){
            // include
            int ans = val[n-1]+Knapsack(val,wt,W-wt[n-1],n-1,dp);

            // exclude
            int ans1 = Knapsack(val,wt,W,n-1,dp);
            dp[n][W] = Math.max(ans,ans1);
            return dp[n][W];
        }else{
            dp[n][W] = Knapsack(val,wt,W,n-1,dp);
            return dp[n][W];
        }
    }
    public static void main(String args []){
        int val[]= {15,14,10,45,30};
        int wt[] =  {2,5,1,3,4};
        int netwt = 7;
        int dp[][] = new int[val.length+1][netwt+1];
        for(int i = 0; i< dp.length; i++){
            for(int j  = 0; j<dp[0].length; j++){
                dp[i][j] = -1;
            }
        }
        System.out.println(Knapsack(val,wt,netwt,5,dp));
    }
}
