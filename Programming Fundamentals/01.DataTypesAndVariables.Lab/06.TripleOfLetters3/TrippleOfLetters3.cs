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

            for (int i1 = 'a'; i1 < 'a' + n; i1++)
            {
                for (int i2 = 'a'; i2 < 'a' + n; i2++)
                {
                    for (int i3 = 'a'; i3 < 'a' + n; i3++)
                    {
                        Console.WriteLine($"{(char)(i1)}{(char)(i2)}{(char)(i3)}");

                    }
                }
            }
        }
    }
}
