using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _06_ReversedArrayOfStrings
{
    class ReversedArrayOfStrings
    {
        static void Main(string[] args)
        {
            string[] array = Console.ReadLine().Split(' ');
            string[] reversed = new string[array.Length];
            int length = array.Length;
            for (int i = 0; i < length; i++)
            {
                reversed[length - i -1] = array[i];
              
            }
            Console.Write(string.Join(" ", reversed));
            Console.WriteLine();
        }
    }
}
