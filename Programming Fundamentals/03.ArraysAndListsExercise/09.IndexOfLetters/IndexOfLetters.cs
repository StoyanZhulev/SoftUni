using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _09.IndexOfLetters
{
    class IndexOfLetters
    {
        static void Main(string[] args)
        {
            string word = Console.ReadLine();
            char[] array = new char[26];

            char currentChar = 'a';
            for (int i = 0; i < array.Length; i++)
            {
                array[i] = currentChar;
                currentChar++;
            }

            for (int i = 0; i < word.Length; i++)
            {
                for (int j = 0; j < array.Length; j++)
                {
                    if(word[i] == array[j])
                    {
                        Console.WriteLine("{0} -> {1}", word[i], j);
                    }
                }
            }
        }


    }
}
