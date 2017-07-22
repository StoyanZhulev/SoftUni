using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _08.Most_Frequent_Number
{
    class MostFrequentNumber
    {
        static void Main(string[] args)
        {
            var nums = Console.ReadLine()
                .Split(' ')
                .Select(int.Parse)
                .ToList();
            int[] count = new int[nums.Count];

           for (int i = 0; i < nums.Count; i++)
           {
               int counts = 0;
               for (int j = 0; j < nums.Count; j++)
               {
                   if (nums[j] == nums[i])
                   {
                       counts++;
                   }
               }
               count[i] = counts;
           }
            

           int biggestCount = count[0];
           int biggestIndex = 0;
           for (int i = 1; i < count.Length; i++)
           {       
                if (count[i] > biggestCount)
                {
                    biggestCount = count[i];
                    biggestIndex = i;
                }
         
           }
   
            Console.WriteLine(nums[biggestIndex]);
        }

    }
}
