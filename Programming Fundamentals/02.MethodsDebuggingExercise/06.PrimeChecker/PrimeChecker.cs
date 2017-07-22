using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _06.PrimeChecker
{
    class PrimeChecker
    {
        static void Main(string[] args)
        {
            long number = long.Parse(Console.ReadLine());
            Console.WriteLine(isPrime(number));
        }

        static bool isPrime(long number)
        {
            if (number > 1)
            {
                for (long i = 2; i <= Math.Sqrt(number); i++)
                {

                    if (i != number && number % i == 0)
                    {
                        return false;
                    }
                }
            }
          else if (number <=1)
              return false;
            return true;
        }
    }
}
