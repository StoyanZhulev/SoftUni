using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _04.Largest3Numbers
{
    class Largest3Numbers
    {
        static void Main(string[] args)
        {
            string[] input = Console.ReadLine().Split(' ');

            List<int> nums = input
                             .Select(int.Parse)
                             .ToList();
            var sortedNums = nums.OrderByDescending(x => x);
            var result = sortedNums.Take(3);

            Console.WriteLine(string.Join(" ", result));            

            
                
        }
    }
}
