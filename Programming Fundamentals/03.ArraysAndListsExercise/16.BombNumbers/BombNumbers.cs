using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _16.BombNumbers
{
    class BombNumbers
    {
        static void Main(string[] args)
        {
            List<int> numbers = Console.ReadLine().Split(' ').Select(int.Parse).ToList();
            int[] bombAndRange = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();
            int bomb = bombAndRange[0];
            int range = bombAndRange[1];

            for (int i = 0; i < numbers.Count; i++)
            {
                if(numbers[i] == bomb)
                {
                    int left = Math.Max(i - range, 0);
                    int right = Math.Min(i + range, numbers.Count - 1);
                    int length = right - left + 1;
                    numbers.RemoveRange(left, length);
                    i = 0;
                }              
            }
            Console.WriteLine(numbers.Sum());
        }
    }
}
