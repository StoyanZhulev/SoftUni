using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _08.CenterPodouble
{
    class CenterPodouble
    {
        static void Main(string[] args)
        {
            double x1 = double.Parse(Console.ReadLine());
            double y1 = double.Parse(Console.ReadLine());

            double x2 = double.Parse(Console.ReadLine());
            double y2 = double.Parse(Console.ReadLine());

            
            double firstDistance = FirsDistance(x1, y1);          
            double secondDistance = SecondDistance(x2, y2);

            if (firstDistance <= secondDistance)
            {
                Console.WriteLine("({0}, {1})", x1, y1);
            }
            else
            {
                Console.WriteLine("({0}, {1})", x2, y2);
            }
        }

       static double FirsDistance(double x1, double y1)
       {
           double x1Distance = Math.Abs(x1 - 0);
           double y1Distance = Math.Abs(y1 - 0);
           double firstDistance = x1Distance + y1Distance;
           return firstDistance;
       }
       
       static double SecondDistance( double x2, double y2)
       {
           double x2Distance = Math.Abs(x2 - 0);
           double y2Distance = Math.Abs(y2 - 0);
           double secondDistance = x2Distance + y2Distance;
           return secondDistance;
       }


    }
}
