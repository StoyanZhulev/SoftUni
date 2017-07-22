using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _04.Palindromes.Lab
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] text = Console.ReadLine().Split(new char[] { ' ', '!', '?', '.', ',' },StringSplitOptions.RemoveEmptyEntries);

            List<string> palindromes = new List<string>();
            foreach (string word in text)
            {
                if(IsPalindrome(word))
                {
                    palindromes.Add(word);
                }
            }

            Console.WriteLine(string.Join(", ", palindromes.Distinct().OrderBy(x => x)));
        }

        private static bool IsPalindrome(string word)
        {
            bool result = word == string.Join("", word.Reverse());


            return result;
        }
    }
}
