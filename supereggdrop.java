//Idea is to drop from every floor and find the worstcase among both break and no-break scenarios
//return the mimimum among all the worst case scenarios
//Use DP memoization to store sub problem results
//Time Complexity: O(k*n^2)
//Space Complexity: O(k*n)
public class supereggdrop {
    int[][] memo;
    public int superEggdrop(int k,int n)
    {
        this.memo = new int[k+1][n+1];
        return helper(k,n);
    }

    private int helper(int k, int n)
    {
        if(n==0) return 0;
        if(k==1) return n;

        if(memo[k][n]!=0) return memo[k][n];
        int min = Integer.MAX_VALUE;
        //Iterate to start with each floor and explore both egg and no egg break till n floors  
        for(int f=1;f<=n;f++)
        {
            // Egg break scenario: If egg breaks, reduce eggs and explore below floors 
            int br = helper(k-1,f-1); 
            // No Egg break scenario: If no egg breaks, keep egg count same and explore above floors
            int noBr = helper(k,n-f);
            // Take maximum attempts made to find the floor 
            int worstcase = 1+ Math.max(br,noBr);

            //filter the minimum attempts to find the floor among all the possible attempts  
            min = Math.min(min,worstcase);
        }
        memo[k][n] = min;
        return min;

    }
}
