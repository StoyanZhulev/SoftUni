using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _03.EnglishNameOfLastDigitt
{
    class EnglishNameOfLastDigitt
    {
        static void Main(string[] args)
        {
            string num = Console.ReadLine();

            NumName(num);
        }

        static void NumName(string num)
        {
            char lastNum = Convert.ToChar(num[num.Length - 1]);
            
            Console.WriteLine(lastNum.ToString());
            
        }
    }
}
