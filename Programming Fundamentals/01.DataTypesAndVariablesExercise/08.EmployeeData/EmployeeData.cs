using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _08.EmployeeData
{
    class EmployeeData
    {
        static void Main(string[] args)
        {
            string firstName = "Amanda";
            string lastName = "Jonson";
            byte age = 27;
            char gander = 'f';
            long ID = 8306112507;
            int number = 27563571;

            Console.WriteLine("First name: "+ firstName);
            Console.WriteLine("Last name: {0}", lastName);
            Console.WriteLine(@"Age: {0}", age);
            Console.WriteLine("Gander: {0}\nPersonal ID: {1}", gander, ID);
            Console.WriteLine($"Unique Employee number: {number}");
        }
    }
}
