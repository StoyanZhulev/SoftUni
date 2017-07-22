using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _10.CubeProperties
{
    class CubeProperties
    {
        static void Main(string[] args)
        {
            double side = double.Parse(Console.ReadLine());

            string type = Console.ReadLine();

            if(type == "face")
            {
                double faceDiagonal = Math.Sqrt(side* side * 2);
                Console.WriteLine("{0:f2}", faceDiagonal);
            }
            else if (type == "space")
            {
                double spaceDiagonal = Math.Sqrt(side*side * 3);
                Console.WriteLine("{0:f2}", spaceDiagonal);
            }
            else if(type == "volume")
            {
                double volume = side * side * side;
                Console.WriteLine("{0:f2}", volume);
            }
            else if (type == "area")
            {
                double area = 6 * side * side;
                Console.WriteLine("{0:f2}", area);
            }
        }
    }
}
