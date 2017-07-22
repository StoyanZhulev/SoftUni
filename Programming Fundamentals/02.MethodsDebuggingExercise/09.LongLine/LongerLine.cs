using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _09.LongerLine
{
    class LongerLine
    {
        static void Main(string[] args)
        {
            double x1 = double.Parse(Console.ReadLine());
            double y1 = double.Parse(Console.ReadLine());
            double x2 = double.Parse(Console.ReadLine());
            double y2 = double.Parse(Console.ReadLine());

            double x3 = double.Parse(Console.ReadLine());
            double y3 = double.Parse(Console.ReadLine());
            double x4 = double.Parse(Console.ReadLine());
            double y4 = double.Parse(Console.ReadLine());

            double x1Distance = Math.Abs(x1 - 0);
            double y1Distance = Math.Abs(y1 - 0);
            double firstDistance = x1Distance + y1Distance;
            double x2Distance = Math.Abs(x2 - 0);
            double y2Distance = Math.Abs(y2 - 0);
            double secondDistance = x2Distance + y2Distance;

            double firstLine = Math.Abs(firstDistance + secondDistance);

            double x3Distance = Math.Abs(x3 - 0);
            double y3Distance = Math.Abs(y3 - 0);
            double thirdDistance = x3Distance + y3Distance;
            double x4Distance = Math.Abs(x4 - 0);
            double y4Distance = Math.Abs(y4 - 0);
            double fourthDistance = x4Distance + y4Distance;

            double secondLine = Math.Abs(thirdDistance + fourthDistance);

            if(firstLine >= secondLine)
            {
                if(firstDistance <= secondDistance)
                {
                    Console.Write("({0}, {1})", x1, y1);
                    Console.WriteLine("({0}, {1})", x2, y2);
                }
                else
                {
                    Console.Write("({0}, {1})", x2, y2);
                    Console.WriteLine("({0}, {1})", x1, y1);
                }
            }
            else 
            {
                if(thirdDistance <= fourthDistance)
                {
                    Console.Write("({0}, {1})", x3, y3);
                    Console.WriteLine("({0}, {1})", x4, y4);
                }
                else
                {
                    Console.Write("({0}, {1})", x4, y4);
                    Console.WriteLine("({0}, {1})", x3, y3);
                }
            }
        }
    }
}
