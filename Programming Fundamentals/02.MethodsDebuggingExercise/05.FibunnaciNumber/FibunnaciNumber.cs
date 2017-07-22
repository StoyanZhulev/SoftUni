using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _05.FibunnaciNumber
{
    class FibunnaciNumber
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            Console.WriteLine(FibNum(n));
            
        }

        static int FibNum(int n)
        {
            int firstNum = 1;
            int secondNum = 1;

            for (int i = 2; i <= n; i++)
            {

                int oldSecond = secondNum;
                secondNum = firstNum + oldSecond;
                firstNum = oldSecond;
            }
            return secondNum;
        }
    }
}
