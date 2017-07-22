using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _01.CoffeeOrder.Lab
{
    class CoffeeOrderLab
    {
        static void Main(string[] args)
        {
            int num = int.Parse(Console.ReadLine());
            decimal sum = 0;
            for (int i = 0; i < num; i++)
            {
                decimal price = decimal.Parse(Console.ReadLine());
                DateTime date = DateTime.ParseExact(Console.ReadLine(), "d/M/yyyy", CultureInfo.InvariantCulture);
                uint count = uint.Parse(Console.ReadLine());

                decimal currentPrice = DateTime.DaysInMonth(date.Year, date.Month) * count * price;
                sum += currentPrice;

                Console.WriteLine($"The price for the coffee is: ${currentPrice:f2}");

            }

            Console.WriteLine($"Total: ${sum:f2}");
        }
    }
}
