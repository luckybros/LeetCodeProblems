import java.util.Arrays;

class Solution {
    public int coinChangeTopDown(int[] coins, int amount) {
        if(amount == 0) return 0;
        int[] cache = new int[amount + 1];
        Arrays.fill(cache, -1);
        int result = DP(coins, amount, cache);
        return (result == Integer.MAX_VALUE) ? -1 : result;
    }

    public int DP(int[] coins, int amount, int[] cache) {
        if(amount == 0) return 0;
        if(amount < 0) return Integer.MAX_VALUE;
        if (cache[amount] != -1) return cache[amount];

        int min = Integer.MAX_VALUE;

        for(int coin : coins) {
            int subResult = DP(coins, amount - coin, cache);
            if(subResult != Integer.MAX_VALUE) {
                min = Math.min(min, 1 + subResult);
            }
        }

        cache[amount] = min;
        return min;
    }

    public int coinChangeBottomUp(int[] coins, int amount) {
        if(amount == 0) return 0;
        int[] cache = new int[amount + 1];
        Arrays.fill(cache, Integer.MAX_VALUE);
        cache[0] = 0;

        for(int i = 1; i <= amount; i++) {
            cache[i] = Integer.MAX_VALUE;
            for(int coin : coins) {
                if(i - coin >= 0 && cache[i - coin] != Integer.MAX_VALUE)
                    cache[i] = Math.min(cache[i], cache[i-coin] + 1);
            }
        }

        return (cache[amount] == Integer.MAX_VALUE) ? -1 : cache[amount];
    }
}

