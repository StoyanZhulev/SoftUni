using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _06.TriplesOfLetters
{
    class TriplesOfLetters
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            for (char i1 = 'a'; i1 < 'a' + n; i1++)
            {
                for (char i2 = 'a'; i2 < 'a' + n; i2++)
                {
                    for (char i3 = 'a'; i3 < 'a' + n; i3++)
                    {
                        Console.WriteLine($"{i1}{i2}{i3}");

                    }
                }
            }
        }
    }
}
