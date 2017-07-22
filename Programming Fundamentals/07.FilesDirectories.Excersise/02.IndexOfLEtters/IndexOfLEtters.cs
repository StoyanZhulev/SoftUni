using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _02.IndexOfLEtters
{
    class IndexOfLEtters
    {
        static void Main(string[] args)
        {
            char[] letters = new char[26];
            char currentChar = 'a';
            for (int i = 0; i < letters.Length; i++)
            {
                letters[i] = currentChar;
                currentChar++;
            }

            string[] lines = File.ReadAllLines("input.txt");
            
            for (int i = 0; i < lines.Length; i++)
            {
                string word = lines[i];
                string[] output = new string[word.Length];
                for (int j = 0; j < word.Length; j++)
                {
                    for (int k = 0; k < letters.Length; k++)
                    {
                        if(word[j] == letters[k])
                        {
                            File.AppendAllText("output.txt",$"{word[j]} -> {k}" + Environment.NewLine);
                        }
                    }
                }

                

            }
        }
    }
}
