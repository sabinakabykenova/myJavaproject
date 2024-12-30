class Esep31 {

    static int powmod(int x, int y, int p)
    {
        int res = 1;

        x = x % p;

        while (y > 0)
        {
            // Eger y tak bolsa, x -ti natizhemen kobeytemiz
            if ((y & 1)>0)
                res = (res*x) % p;

            y = y>>1; // y = y/2
            x = (x*x) % p;
        }
        return res;
    }

    // Berilgen a, b, m ushin k eseptey funkciasy
    static int discreteLogarithm(int a, int b, int m) {

        int n = (int) (Math.sqrt (m) + 1);

        int[] value=new int[m];

        //  a^(n*i)
        for (int i = n; i >= 1; --i)
            value[ powmod (a, i * n, m) ] = i;

        for (int j = 0; j < n; ++j)
        {
            // (a ^ j) * b eseptey zhane teksery

            int cur = (powmod (a, j, m) * b) % m;

            if (value[cur]>0)
            {
                int ans = value[cur] * n - j;

                if (ans < m)
                    return ans;
            }
        }
        return -1;
    }

    // Kod
    public static void main(String[] args)
    {
        int a = 3, b =11, m =43;
        System.out.println(discreteLogarithm(a, b, m));

    }
}


