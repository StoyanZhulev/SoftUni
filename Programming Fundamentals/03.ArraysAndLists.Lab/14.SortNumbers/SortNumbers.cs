using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _14.SortNumbers
{
    class SortNumbers
    {
        static void Main(string[] args)
        {
            List<decimal> List = Console.ReadLine().Split().Select(decimal.Parse).ToList();
            List.Sort();
            Console.WriteLine(string.Join(" <= ", List));
        }
    }
}
