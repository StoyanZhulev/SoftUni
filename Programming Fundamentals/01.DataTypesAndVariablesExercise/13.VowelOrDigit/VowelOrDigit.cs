using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _13.VowelOrDigit
{
    class VowelOrDigit
    {
        static void Main(string[] args)
        {
            char symbol;

            symbol = Convert.ToChar(Console.ReadLine());
            if(char.IsDigit(symbol))
                 Console.WriteLine("digit");
            else if (symbol == 'a' || symbol == 'o' || symbol == 'e' || symbol == 'i' || symbol == 'u')
                Console.WriteLine("vowel");
            else
                Console.WriteLine("other");
        }
    }
}
