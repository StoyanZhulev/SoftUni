using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _12.SumAdjacentEqualNumbers
{
    class SumAdjacentEqualNumbers
    {
        static void Main(string[] args)
        {
            var nums = Console.ReadLine().Split(' ')
                .Select(double.Parse)
                .ToList();

          for (int i = 0; i < nums.Count-1; i++)
          {
                while (i < nums.Count-1)
                {
                    if (nums[i] == nums[i + 1])
                    {
                        nums[i] += nums[i + 1];
                        nums.Remove(nums[i + 1]);
                        if(i > 0)
                        {
                            i--;
                        }
                    }
                    else
                    {
                        i++;
                    }
                }
                  
              
          }         
                Console.WriteLine(string.Join(" ", nums));
            
        }
    }
}
