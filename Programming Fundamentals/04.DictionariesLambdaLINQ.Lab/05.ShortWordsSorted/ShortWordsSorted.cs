using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _05.ShortWordsSorted
{
    class ShortWordsSorted
    {
        static void Main(string[] args)
        {
            string text = Console.ReadLine().ToLower();
            char[] separator = new char[] { '.', ',', ':', ';', '(', ')', '[', ']', '"', '\'', '\\', '/', '!', '?', ' ' };

            var word = text.Split(separator, StringSplitOptions.RemoveEmptyEntries);

            var result = word.Where(w => w.Length < 5)
                             .Where(w => w != "")
                             .OrderBy(w => w)
                             .Distinct()
                             .ToArray();

            Console.WriteLine(string.Join(", ",result));

        }
    }
}
