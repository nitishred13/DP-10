public class Balloonburst {
    //To calculate max coins, we need to try bursting each balloon at last and pick maximum value 
    // among these
    //We do this recursively for each of the before and after sub arrays

    // To avoid recalculating the same problems again and again, we use  memoization
    //Time Complexity: O(n^3)
    //Space Complexity: O(n^2)
    int[][] memo;
    public int maxcoins(int[] nums)
    {
        int n = nums.length;
        this.memo = new int[n][n];
        return helper(nums,0,n-1);
    }

    private int helper(int[] nums, int i, int j)
    {
        if(i>j) return 0;
        if(memo[i][j] !=0) return memo[i][j];
        int max = 0;

        for(int k=i;k<=j;k++)
        {
            int before = helper(nums,i,k-1);
            int after = helper(nums, k+1, j);

            int prev = 1, next = 1;
            if(i>0)
            {
                prev = nums[i-1];
            }
            if(j<nums.length-1)
            {
                next = nums[j+1];
            }
            int balloonItself = prev * nums[k] * next;
            max = Math.max(max, before+balloonItself+after);
        }
        memo[i][j] = max;
        return max;
    }
}
