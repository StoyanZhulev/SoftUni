using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _06.MaxSequenceOfEqualElements
{
    class MaxSequenceOfEqualElements
    {
        static void Main(string[] args)
        {
            int[] array = Console.ReadLine()
                .Split(' ')
                .Select(int.Parse)
                .ToArray();

            int currentStart = 0;
            int longestStart = 0;
            int currentLength = 1;
            int longestLength = 1;

            for (int i = 1; i < array.Length; i++)
            {
                if(array[i] == array[i-1])
                {
                    currentLength++;
                    if(currentLength > longestLength)
                    {
                        longestLength = currentLength;
                        longestStart = currentStart;
                    }
                }
                else
                {
                    currentStart = i;
                    currentLength = 1;
                }
            }

            int[] result = new int[longestLength];
            int j = 0;
            for (int i = longestStart; i < longestLength + longestStart; i++)
            {

                result[j] = array[i];
                j++;
            }

            Console.WriteLine(string.Join(" ", result));
        }
    }
}
