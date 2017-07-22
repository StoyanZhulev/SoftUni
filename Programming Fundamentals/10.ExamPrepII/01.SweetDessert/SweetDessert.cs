using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _01.SweetDessert
{
    class SweetDessert
    {
        static void Main(string[] args)
        {
            decimal amountOfCash = decimal.Parse(Console.ReadLine());
            decimal numberOfGuests = decimal.Parse(Console.ReadLine());
            decimal bananasPricePerUnit = decimal.Parse(Console.ReadLine());
            decimal eggsPricePerUnit = decimal.Parse(Console.ReadLine());
            decimal berriesPricePerKilo = decimal.Parse(Console.ReadLine());

            
            decimal setsOfPortions = Math.Ceiling(numberOfGuests / 6);
            decimal bananasPrice = setsOfPortions * (2 * bananasPricePerUnit);
            decimal eggsPrice = setsOfPortions * (4 * eggsPricePerUnit);
            decimal berriesPrice = setsOfPortions * ((decimal)0.2 * berriesPricePerKilo);

            decimal allPrice = bananasPrice + eggsPrice + berriesPrice;

            if(allPrice <= amountOfCash)
            {
                Console.WriteLine($"Ivancho has enough money - it would cost {allPrice:f2}lv.");
            }
            else
            {
                Console.WriteLine($"Ivancho will have to withdraw money - he will need {(allPrice - amountOfCash):f2}lv more.");
            }

        }
    }
}
