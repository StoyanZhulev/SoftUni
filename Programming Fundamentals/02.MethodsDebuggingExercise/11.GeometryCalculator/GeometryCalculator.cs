using System;


namespace _11.GeometryCalculator
{
    class GeometryCalculator
    {
        static void Main(string[] args)
        {
            string type = Console.ReadLine();
                       
            if(type == "triangle")
            {
                double side = double.Parse(Console.ReadLine());
                double height = double.Parse(Console.ReadLine());
                double triangleArea = TriangleArea(side, height);
                Console.WriteLine("{0:f2}", triangleArea);
            }
            else if(type == "square")
            {
                double side = double.Parse(Console.ReadLine());
                
                double squareArea = SquareArea(side);
                Console.WriteLine("{0:f2}", squareArea);
            }
            else if (type == "rectangle")
            {
                double side = double.Parse(Console.ReadLine());
                double height = double.Parse(Console.ReadLine());
                double rectangleArea = RectangleArea(side, height);
                Console.WriteLine("{0:f2}", rectangleArea);
            }
            else if (type == "circle")
            {
                double side = double.Parse(Console.ReadLine());
                
                double circleArea = CircleArea(side);
                Console.WriteLine("{0:f2}", circleArea);
            }

        }

        static double TriangleArea (double side, double height)
        {
            double area = side * height / 2;
            return area;
        }

        static double SquareArea (double side)
        {
            double area = side * side;
            return area;
        }

        static double RectangleArea (double width, double height)
        {
            double area = width * height;
            return area;
        }

        static double CircleArea (double radius)
        {
            double area =(double) Math.PI * radius * radius;
            return area;
        }
    }
}
