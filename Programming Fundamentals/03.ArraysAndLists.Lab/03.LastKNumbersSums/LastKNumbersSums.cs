using System;

namespace _03.LastKNumbersSums
{
    class LastKNumbersSums
    {
        static void Main(string[] args)
        {
            long n = long.Parse(Console.ReadLine());
            long k = long.Parse(Console.ReadLine());

            long[] array = new long[n];
            array[0] = 1;

            for (long i = 1; i < array.Length; i++)
            {
                long sum = 0;
                for (long j = i-k; j <= i-1; j++)
                {
                    if (j >= 0)
                        sum += array[j];
                }
                array[i] = sum;
            }

            for (long i = 0; i < array.Length; i++)
            {
                Console.Write(array[i] + " ");
            }
        }
    }
}