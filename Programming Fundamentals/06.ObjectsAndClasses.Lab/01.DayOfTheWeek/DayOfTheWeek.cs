using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _01.DayOfTheWeek
{
    class DayOfTheWeek
    {
        static void Main(string[] args)
        {

            int[] inputDate = Console.ReadLine().Split('-').Select(int.Parse).ToArray();
            int year = inputDate[2];
            int month = inputDate[1];
            int day = inputDate[0];
            DateTime date = new DateTime(year, month, day);
           
            Console.WriteLine(date.DayOfWeek);
           
        }
    }
}
