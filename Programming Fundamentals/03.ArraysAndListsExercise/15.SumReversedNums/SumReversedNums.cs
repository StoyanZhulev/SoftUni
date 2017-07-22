using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _15.SumReversedNums
{
    class SumReversedNums
    {
        static void Main(string[] args)
        {
            List<int> nums = Console.ReadLine()
                .Split(' ').Select(int.Parse).ToList();
            List<int> reversedNums = new List<int>();
            for (int i = 0; i < nums.Count; i++)
            {
                int reversed = int.Parse(Reverse(nums[i]));
                reversedNums.Add(reversed);
            }

            var sum = 0;
            foreach (int num in reversedNums)
            {
                sum += num;
            }
            Console.WriteLine(sum);
        }

        private static string Reverse(int num)
        {
            char[] charArray = num.ToString().ToCharArray();
            Array.Reverse(charArray);
            return new string(charArray);
        }
    }
}
