using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _03.OddOcurrances
{
    class OddOcurrances
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine().ToLower();
            string[] words = input.Split(' ');

            Dictionary<string, int> count = new Dictionary<string, int>();
            foreach (var word in words)
            {
                if(count.ContainsKey(word))
                {
                    count[word]++;
                }
                else
                {
                    count[word] = 1;
                }
            }
            var results = new List<string>();
            foreach (var pair in count)
            {
                if(pair.Value % 2 != 0)
                {
                    results.Add(pair.Key);
                }
            }

            Console.WriteLine(string.Join(", ", results));
        }
    }
}
