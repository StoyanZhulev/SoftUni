using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _07.SumArrays
{
    class SumArrays
    {
        static void Main(string[] args)
        {
            string[] arr1 = Console.ReadLine().Split(' ');
            int[] arr1Nums = new int[arr1.Length];
            for (int i = 0; i < arr1.Length; i++)
            {
                 arr1Nums[i] = int.Parse(arr1[i]);
                Console.Write(arr1Nums[i]);
            }
            int length1 = arr1Nums.Length;

            string[] arr2 = Console.ReadLine().Split(' ');
            int[] arr2Nums = new int[arr2.Length];
            for (int i = 0; i < arr2.Length; i++)
            {
                arr2Nums[i] = int.Parse(arr2[i]);
            }
            int length2 = arr2Nums.Length;
            var longer = Math.Max(length1, length2);

            int[] result = new int[longer];

            for (int i = 0; i < longer; i++)
            {
                result[i] = arr1Nums[i%length1] + arr2Nums[i%length2];
            }
            Console.Write(string.Join(" ", result));

        }
    }
}
