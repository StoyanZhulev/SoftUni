using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _08.MultiplyEvensByOdds
{
    class MultiplyEvensByOdds
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            Console.WriteLine(MultipleOfEvensAndOdds(n));

        }

        static int MultipleOfEvensAndOdds(int n)
        {
            int sumEvens = SumOfEvens(n);
            int sumOdds = SumOfOdds(n);
            return sumEvens * sumOdds;
        }

        private static int SumOfOdds(int n)
        {
            int sum = 0;
            while (n > 0 || n < 0)
            {
                int lastDigit = n % 10;
                if(lastDigit % 2 == 0)
                {
                    sum +=lastDigit;
                }
                n /= 10;
            }
            return sum;
        }

        private static int SumOfEvens(int n)
        {
            int sum = 0;
            while (n > 0 || n < 0)
            {
                int lastDigit = n % 10;
                if (lastDigit % 2 != 0)
                {
                    sum += lastDigit;
                }
                n /= 10;
            }
            return sum;
        }
    }
}
