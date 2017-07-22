using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _09.ExamPrepI
{
    class SoftUniCoffeeOrders
    {
        static void Main(string[] args)
        {
            int orders = int.Parse(Console.ReadLine());
            decimal totalSum = 0;
            for (int i = 0; i < orders; i++)
            {
                decimal pricePerCapsule = decimal.Parse(Console.ReadLine());
                DateTime orderDate = DateTime.ParseExact(Console.ReadLine(), "d/M/yyyy", CultureInfo.InvariantCulture);
                decimal capsuleCount = decimal.Parse(Console.ReadLine());

                decimal daysInMonth = DateTime.DaysInMonth(orderDate.Year, orderDate.Month);

                decimal coffeePrice = (daysInMonth * capsuleCount) * pricePerCapsule;

                totalSum += coffeePrice;

                Console.WriteLine($"The price for the coffee is: ${coffeePrice:f2}");
                              
            }

            Console.WriteLine("Total: ${0:f2}", totalSum);
        }
    }
}
