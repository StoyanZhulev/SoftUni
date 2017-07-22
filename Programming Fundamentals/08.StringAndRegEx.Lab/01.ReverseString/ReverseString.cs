using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _01.ReverseString
{
    class ReverseString
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();
            // char[] charArray = input.ToCharArray();
            // Array.Reverse(charArray);
                  //for (int i = input.Length - 1; i >=0; i--)
                  //{
                  //    Console.Write("{0}", input[i]);
                  //}

            //Console.WriteLine(charArray );
            Console.WriteLine(string.Join("", input.ToArray().Reverse()));
        }
    }
}
