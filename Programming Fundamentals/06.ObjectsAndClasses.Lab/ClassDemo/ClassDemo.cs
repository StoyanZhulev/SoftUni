using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ClassDemo
{
    class ClassDemo
    {
        static void Main(string[] args)
        {
            Point p = new Point { X = 5, Y = 7 };

            Student stoyanZhulev = new Student();
            stoyanZhulev.FirstName = "Stoyan";
            stoyanZhulev.LastName = "Zhulev";

            Console.WriteLine(string.Format("{0}, {1}",p.X, p.Y));
            Console.WriteLine(stoyanZhulev.FirstName + " " + stoyanZhulev.LastName);
        }
    }

    public class Point
    {
        public int X { get; set; }

        public int Y { get; set; }
    }

    class Student
    {
        public string FirstName { get; set; }

        public string LastName { get; set; }
    }
}
