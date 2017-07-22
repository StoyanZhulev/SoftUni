using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _01.MostFrequentElement
{
    class MostFrequentElement
    {
        public static object FIle { get; private set; }

        static void Main(string[] args)
        {
            string[] lines = File.ReadAllLines("input.txt");
            
            for (int i = 0; i < lines.Length; i++)
            {
                string text = lines[i];
                
                int[] nums = text.Split(' ').Select(int.Parse).ToArray();

                int[] counts = new int[nums.Length];
              

                for (int j = 0; j < nums.Length; j++)
                {
                    int count = 0;
                    for (int k = 0; k < nums.Length; k++)
                    {
                        if(nums[k] == nums[j])
                        {
                            count++;
                        }
                    }

                    counts[j] = count;
                }

                int biggestCount = counts[0];
                int index = 0;

                for (int j = 1; j < counts.Length; j++)
                {
                    if(counts[j] > biggestCount)
                    {
                        biggestCount = counts[i];
                        index = i;
                    }
                }

                File.AppendAllText("output2.txt", nums[index] + Environment.NewLine);
            }
        }
    }
}
