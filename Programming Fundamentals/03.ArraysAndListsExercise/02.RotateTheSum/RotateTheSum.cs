using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _02.RotateTheSum
{
    class RotateTheSum
    {
        static void Main(string[] args)
        {
            string[] nums = Console.ReadLine().Split(' ');
            int[] numbers = new int[nums.Length];
            for (int i = 0; i < nums.Length; i++)
            {
                numbers[i] = int.Parse(nums[i]);
            }
           
            int k = int.Parse(Console.ReadLine());
            int[] sum = new int[numbers.Length];
            for (int rotation = 0; rotation < k; rotation++)
            {
                int last = numbers[numbers.Length - 1];
                for (int j = numbers.Length - 1; j > 0; j--)
                {
                    numbers[j] = numbers[(j - 1)];
                }

                numbers[0] = last;

                for (int i = 0; i < numbers.Length; i++)
                {
                    sum[i] += numbers[i];
                }           
            }          
            Console.WriteLine(string.Join(" ", sum));           
        }
    }
}
