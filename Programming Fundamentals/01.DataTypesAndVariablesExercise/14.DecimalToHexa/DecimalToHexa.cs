using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _14.DecimalToHexa
{
    class DecimalToHexa
    {
        static void Main(string[] args)
        {
            int num = int.Parse(Console.ReadLine());

            string toHexa = Convert.ToString(num, 16).ToUpper();
            string toBinary = Convert.ToString(num, 2).ToUpper();

            Console.WriteLine(toHexa);
            Console.WriteLine(toBinary);
        }
    }
}
