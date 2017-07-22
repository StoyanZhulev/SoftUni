using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _04.DistanceBetweenPoints
{
    class DistanceBetweenPoints
    {
        static void Main(string[] args)
        {
            Point[] points = ReadPoints();

            Point[] closestTwoPoints = FindClosestTwoPoints(points);

            
            PrintDistance(closestTwoPoints);
            PrinPoint(closestTwoPoints[0]);
            PrinPoint(closestTwoPoints[1]);

            
        }

        static double CalculateDistance(Point p1, Point p2)
        {
            int deltaX = p2.X - p1.X;
            int deltaY = p2.Y - p1.Y;
            return Math.Sqrt(deltaX * deltaX + deltaY * deltaY);

        }

        static Point[] FindClosestTwoPoints(Point[] points)
        {
            double minValue = double.MaxValue;
            Point[] closestTwoPoints = null;

            for (int p1 = 0; p1 < points.Length; p1++)
            {
                for (int p2 = p1+1; p2 < points.Length; p2++)
                {
                    double distance = CalculateDistance(points[p1], points[p2]);
                    if(distance < minValue)
                    {
                        minValue = distance;
                        closestTwoPoints = new Point[] { points[p1], points[p2] };
                    }
                }
            }

            return closestTwoPoints;
        }

        static Point ReadPoint()
        {
            int[] pointInfo = Console.ReadLine().Split().Select(int.Parse).ToArray();
            Point point = new Point();
            point.X = pointInfo[0];
            point.Y = pointInfo[1];
            return point;

        }

        static Point[] ReadPoints()
        {
            int n = int.Parse(Console.ReadLine());

            Point[] points = new Point[n];
            for (int i = 0; i < points.Length; i++)
            {
                points[i] = ReadPoint();
            }

            return points;
        }

        
        static void PrinPoint(Point point)
        {
            Console.WriteLine("({0}, {1})",point.X, point.Y );
        }

        static void PrintDistance(Point[] points)
        {
            double distance = CalculateDistance(points[0], points[1]);

            Console.WriteLine("{0:f3}", distance);
        }
    }

    class Point
    {
        public int X { get; set; }

        public int Y { get; set; }
    }


}
