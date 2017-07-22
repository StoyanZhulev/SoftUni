using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _15.SquareNumbers
{
    class SquareNumbers
    {
        static void Main(string[] args)
        {
            var numbers = Console.ReadLine().Split(' ').Select(int.Parse).ToList();
            var result = new List<int>();

            foreach (int num in numbers)
            {
                if(Math.Sqrt(num) == (int)(Math.Sqrt(num)))
                {
                    result.Add(num);
                }
            }
            result.Sort((a, b) => b.CompareTo(a));
            //result.Sort();
            //result.Reverse();
            Console.WriteLine(string.Join(" ", result));
        }
    }
}
