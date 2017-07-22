using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _07.SalesReport
{
    class SalesReport
    {
        static void Main(string[] args)
        {
            int salesCount = int.Parse(Console.ReadLine());
            Sale[] sales = new Sale[salesCount];
            for (int i = 0; i < salesCount; i++)
            {
                string[] info = Console.ReadLine().Split();
                Sale sale = new Sale();
                sale.Town = info[0];
                sale.Product = info[1];
                sale.Price = decimal.Parse(info[2]);
                sale.Quantity = decimal.Parse(info[3]);

                sales[i] = sale;
            }

            string[] townsByName = sales
                                   .Select(sale => sale.Town)
                                   .Distinct()
                                   .OrderBy(t=> t)
                                   .ToArray();

            for (int i = 0; i < townsByName.Length; i++)
            {
                decimal sum = sales
                              .Where(sale => sale.Town == townsByName[i])
                              .Sum(sale => sale.Price * sale.Quantity);
                Console.WriteLine($"{townsByName[i]} -> {sum:f2}");
            }
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
