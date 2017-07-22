using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _02.RandomizeWords
{
    class RandomizeWords
    {
        static void Main(string[] args)
        {
            string[] text = Console.ReadLine().Split().ToArray();
            Random num = new Random();
            
            for (int pos1 = 0; pos1 < text.Length; pos1++)
            {
                int pos2 = num.Next(text.Length);
                string oldValue = text[pos1];
                text[pos1] = text[pos2];
                text[pos2] = oldValue;
            }

            Console.WriteLine(string.Join("\n", text));
        }
    }
}
