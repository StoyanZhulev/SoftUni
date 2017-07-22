using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _04.Palindromes
{
    class Palindromes
    {
        static void Main(string[] args)
        {
            string[] text = Console.ReadLine().Split(new char[] { ' ', ',', '.', '?', '!' }, StringSplitOptions.RemoveEmptyEntries);
            List<string> words = new List<string>();
            
            foreach (var word in text)
            {
                bool isPalindrome = true;
                for (int j = 0; j < word.Length / 2; j++)
                {
                   
                    if (word[j] != word[word.Length - j - 1])
                    {
                        isPalindrome = false;
                    }                
                }
                if (isPalindrome == true)
                {
                    words.Add(word);
                }
            }
                        
           words = words.OrderBy(x => x).ToList();
            Console.WriteLine(string.Join(", ", words.Distinct()));
        }
    }
}
