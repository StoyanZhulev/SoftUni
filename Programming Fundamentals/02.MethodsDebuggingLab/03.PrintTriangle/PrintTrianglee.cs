using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _03.PrintTriangle
{
    class PrintTrianglee
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            PrintUpperTriangle(n);
            PrintBottomTriangle(n);
        }

        static void PrintLine(int start, int end)
        {
            for (int i = start; i <= end; i++)
            {
                Console.Write(i + " ");
            }
            Console.WriteLine();
        }

        static void PrintUpperTriangle(int n)
        {
            for (int i = 1; i <= n; i++)
            {
                PrintLine(1, i);
            }
        }

        static void PrintBottomTriangle(int n)
        {
            for (int i = n - 1; i > 0; i--)
            {
                PrintLine(1, i);
            }
        }
    }
}
