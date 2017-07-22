using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _04.DrawAFilledSquare
{
    class DrawAFilledSquare
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            FirstRow(n);
            Body(n);
            FirstRow(n);
        }

        static void FirstRow(int n)
        {
            Console.WriteLine(new string('-', 2*n));
        }

        static void Body(int n)
        {
            for (int i = 0; i < n-2; i++)
            {
                Console.Write('-');
                for (int j = 1; j < n; j++)
                {
                    Console.Write("\\/");
                }

                Console.WriteLine('-');
            }
        }
    }
}
