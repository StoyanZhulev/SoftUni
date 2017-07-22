using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _12.MaxSequenceOfEqualElements
{
    class MaxSequenceOfEqualElements
    {
        static void Main(string[] args)
        {
            List<int> nums = Console.ReadLine().Split().Select(int.Parse).ToList();

            int currentStart = 0;
            int longestStart = 0;
            int currentLength = 1;
            int longestLength = 1;

            for (int i = 1; i < nums.Count; i++)
            {
                if(nums[i] == nums[i - 1])
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
                    currentLength = 1;
                    currentStart = i;
                }
            }

            List<int> result = new List<int>();
            
            for (int i = longestStart; i < longestLength + longestStart; i++)
            {
                result.Add(nums[i]);
            }

            Console.WriteLine(string.Join(" ", result));
        }
    }
}
