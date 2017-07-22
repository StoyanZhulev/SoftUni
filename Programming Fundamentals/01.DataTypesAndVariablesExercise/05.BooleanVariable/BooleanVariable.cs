using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _05.BooleanVariable
{
    class BooleanVariable
    {
        static void Main(string[] args)
        {
            string text = Console.ReadLine();
            bool isTrue = true;
            if (text == "False")
                isTrue = false;

            if (isTrue)
                Console.WriteLine("Yes");
            else
                Console.WriteLine("No");
        }
    }
}
