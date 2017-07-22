using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _07.PrimesInGivenRange
{
    class PrimesInGivenRange
    {
        static void Main(string[] args)
        {
            int startNum = int.Parse(Console.ReadLine());
            int endNum = int.Parse(Console.ReadLine());

            List<int> primes = isPrime(startNum, endNum);
            for (int i = 0; i < primes.Count; i++)
            {
                Console.Write(primes[i]);
                if (i == primes.Count - 1)
                {
                    Console.WriteLine();
                    break;
                }
                Console.Write(", ");
            }
        }

        static List<int> isPrime(int startNum,int endNum)
        {
            var primes = new List<int>();
            int num = startNum;
            for (int i = startNum; i <= endNum; i++)
            {
                bool isPrime = true;
                for (int j = 2; j <= Math.Sqrt(i); j++)
                {
                    if (i % j == 0)
                    {
                        isPrime = false;
                        break;
                    }
                }
                
                if (isPrime)
                {
                    primes.Add(i);
                }
            }
            return primes;
        }

    }
}
