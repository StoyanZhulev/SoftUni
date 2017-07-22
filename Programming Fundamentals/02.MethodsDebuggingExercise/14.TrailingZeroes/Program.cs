using System;
using System.Numerics;

class TrailingZeroesInNFact
{
    static void Main()
    {
        Console.Write("n = ");
        BigInteger n = BigInteger.Parse(Console.ReadLine());

        BigInteger factN = 1;

        for (int i = 1; i <= n; i++)
        {
            factN *= i;
        }

        int trailingZeroes = (int)(n / 5 + n / (5 * 5));
        Console.WriteLine(trailingZeroes);
    }
}