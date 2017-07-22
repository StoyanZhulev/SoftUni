using System;
using System.Numerics;

namespace _14.FactorialTrailingZeroes
{
    class FactorialTrailingZeroes
    {
        static void Main(string[] args)
        {
            int num = int.Parse(Console.ReadLine());
                     
            double factorial = 1;
            for (int i = 2; i <= num; i++)
            {
                factorial *= i;
            }

            int trailingZeroes = (int)(num / 5 + num / (5 * 5));
            Console.WriteLine(trailingZeroes);

        }
    }
}
