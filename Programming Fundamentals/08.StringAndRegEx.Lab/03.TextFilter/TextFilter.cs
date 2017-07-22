using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _03.TextFilter
{
    class TextFilter
    {
        static void Main(string[] args)
        {
            string[] bannedWords = Console.ReadLine().Split(new char[] { ',', ' ' }, StringSplitOptions.RemoveEmptyEntries );
            string text = Console.ReadLine();

            foreach (var bannedWord in bannedWords)
            {
                if(text.Contains(bannedWord))
                {
                   text = text.Replace(bannedWord, new string('*', bannedWord.Length));
                }
            }

            Console.WriteLine(text);
        }
    }
}
