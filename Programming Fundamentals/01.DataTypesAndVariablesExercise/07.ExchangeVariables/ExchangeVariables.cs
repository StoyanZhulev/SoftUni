using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _07.ExchangeVariables
{
    class ExchangeVariables
    {
        static void Main(string[] args)
        {
            int a = 5;
            int b = 10;

            int newB = a;
            int newA = b; 

            Console.WriteLine("Before:");
            Console.WriteLine($"a = {a}\nb = {b}");
            Console.WriteLine("After:");
            Console.WriteLine($"a = {newA}\nb = {newB}");
        }
    }
}
