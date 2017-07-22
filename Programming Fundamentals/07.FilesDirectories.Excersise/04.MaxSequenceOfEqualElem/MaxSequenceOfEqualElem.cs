using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _04.MaxSequenceOfEqualElem
{
    class MaxSequenceOfEqualElem
    {
        static void Main(string[] args)
        {
            string[] lines = File.ReadAllLines("input.txt");

            for (int i = 0; i < lines.Length; i++)
            {
                string text = lines[i];
                int[] nums = text.Split().Select(int.Parse).ToArray();

                int currentstart = 0;
                int longestStart = 0;
                int currentLength = 1;
                int longestLength = 1;

                for (int j = 1; j < nums.Length; j++)
                {
                    if(nums[j] == nums[j-1])
                    {
                        currentLength++;
                        if(currentLength > longestLength)
                        {
                            longestLength = currentLength;
                            longestStart = currentstart;
                        }
                    }
                    else
                    {
                        currentLength = 1;
                        currentstart = j;
                    }
                }

               List<int> result = new List<int>();
                for (int j = longestStart; j < longestLength + longestStart; j++)
                {
                    result.Add(nums[j]);
                }


                File.AppendAllText("output.txt",string.Join(" ", result) + Environment.NewLine);
            }
        }
    }
}
