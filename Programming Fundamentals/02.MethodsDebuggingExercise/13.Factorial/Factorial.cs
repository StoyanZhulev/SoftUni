using System;
using System.Numerics;

namespace _13.Factorial
{
    class Factorial
    {
        static void Main(string[] args)
        {
            int num =int.Parse(Console.ReadLine());
            // BigInteger factorial = FactorialNum(num);
            BigInteger factorial = 1;
            for (int i = 2; i <= num; i++)
            {
                factorial *= i;
            }
            Console.WriteLine(factorial);
        }

     //static BigInteger FactorialNum (int num)
     //{
     //    BigInteger factorial = 1;
     //    for (int i = 2; i <= num; i++)
     //    {
     //        factorial *= i;
     //    }
     //    return factorial;
     //}
    }
}
