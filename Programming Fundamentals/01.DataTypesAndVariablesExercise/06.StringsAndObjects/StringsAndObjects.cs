using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _06.StringsAndObjects
{
    class StringsAndObjects
    {
        static void Main(string[] args)
        {
            string text1 = "Hello";
            string text2 = "World";
            string ready = $"{text1} {text2}";

            Console.WriteLine(ready);
        }
    }
}
