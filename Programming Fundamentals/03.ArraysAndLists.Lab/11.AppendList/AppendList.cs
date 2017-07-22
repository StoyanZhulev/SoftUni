using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _11.AppendLists
{
    class AppendLists
    {
        static void Main(string[] args)
        {
            string[] numberAsString = Console.ReadLine().Split('|');
            List<int> numbers = new List<int>();

            for (int i = numberAsString.Length - 1; i >= 0; i--)
            {
                string[] currentCollection = numberAsString[i].Split(new char[] { ' ' },
                StringSplitOptions.RemoveEmptyEntries);
                for (int j = 0; j < currentCollection.Length; j++)
                {
                    numbers.Add(int.Parse(currentCollection[j]));
                }
            }

            Console.WriteLine(string.Join(" ", numbers));
        }
    }
}
