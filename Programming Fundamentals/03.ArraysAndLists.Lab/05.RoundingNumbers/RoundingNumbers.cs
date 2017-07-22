using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _05.RoundingNumbers
{
    class RoundingNumbers
    {
        static void Main(string[] args)
        {
            string[] array = Console.ReadLine().Split(' ');
            double[] arrayNumbers = new double[array.Length];

            for (int i = 0; i < array.Length; i++)
            {
                arrayNumbers[i] = double.Parse(array[i]);
                int rounded = (int)Math.Round(arrayNumbers[i], MidpointRounding.AwayFromZero);
                Console.WriteLine($"{arrayNumbers[i]} => {rounded}");
            }           
        }
    }
}
