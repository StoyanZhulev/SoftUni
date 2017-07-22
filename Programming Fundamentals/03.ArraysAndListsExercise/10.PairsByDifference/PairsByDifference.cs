using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _10.PairsByDifference
{
    class PairsByDifference
    {
        static void Main(string[] args)
        {
            double[] array = Console.ReadLine()
                .Split(' ')
                .Select(double.Parse)
                .ToArray();
            int n = int.Parse(Console.ReadLine());
            int count = 0;
            for (int i = 0; i < array.Length; i++)
            {
                for (int j = i +1; j < array.Length; j++)
                {
                    if(Math.Abs(array[i] - array[j]) == n)
                    {
                        count++;
                       // i++;
                    }
                }
            }

            Console.WriteLine(count);

        }
    }
}
