using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _07.SalesReportMethods
{
    class SalesReportMethods
    {
        static void Main(string[] args)
        {
            Sale[] sales = ReadSales();

            string[] towns = sales
                             .Select(s => s.Town)
                             .Distinct()
                             .OrderBy(t => t)
                             .ToArray();

            foreach (string town in towns)
            {
                decimal salesByTown = sales
                                      .Where(t => t.Town == town)
                                      .Select(s => s.Price * s.Quantity)
                                      .Sum();
                Console.WriteLine("{0} -> {1:f2}", town, salesByTown);
            }
        }

        static Sale[] ReadSales()
        {
            int salesCount = int.Parse(Console.ReadLine());

            Sale[] sales = new Sale[salesCount];

            for (int i = 0; i < salesCount; i++)
            {
                sales[i] = ReadSale();
            }

            return sales;
        }

        static Sale ReadSale()
        {
            string[] saleInfo = Console.ReadLine().Split();
            Sale sale = new Sale()
            {
                Town = saleInfo[0],
                Product = saleInfo[1],
                Price = decimal.Parse(saleInfo[2]),
                Quantity = decimal.Parse(saleInfo[3])
            };

            return sale;
        }
    }

    class Sale
    {
        public string Town { get; set; }
        public string Product { get; set; }
        public decimal Price { get; set; }
        public decimal Quantity { get; set; }
    }
}
