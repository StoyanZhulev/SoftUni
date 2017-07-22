using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Demo
{
    class Demo
    {
        static void Main(string[] args)
        {
            DateTime today = DateTime.Now;
            Console.WriteLine("Today is: " + today);
            DateTime tomorrow = today.AddDays(1);
            Console.WriteLine("tomorrow is "+ tomorrow);
        }
    }
}
