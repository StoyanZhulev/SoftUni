using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _05.MagicExchageableWords
{
    class MagicExchageableWords
    {
        static void Main(string[] args)
        {
            string[] words = Console.ReadLine().Split();

            string firstWord = words[0];
            string secondWord = words[1];


            Dictionary<char, char> map = new Dictionary<char, char>();

            

            int length = Math.Min(firstWord.Length, secondWord.Length);
            for (int i = 0; i < length; i++)
            {
                if (!map.ContainsKey(firstWord[i]))
                {
                    if(map.ContainsValue(secondWord[i]))
                    {
                        Console.WriteLine("false");
                        return;
                    }
                       
                    map.Add(firstWord[i], secondWord[i]);
                }
                else
                {
                    if(map[firstWord[i]] != secondWord[i])
                    {
                        Console.WriteLine("false");
                        return;
                    }
                }
            }

            if(firstWord.Length == secondWord.Length)
            {
                Console.WriteLine("true");
                return;
            }

            string substring = String.Empty;
         
            if(firstWord.Length > secondWord.Length)
            {
                substring = firstWord.Substring(length);
               
            }
            else
            {
                substring = secondWord.Substring(length);
            }

           if(substring.All(ch => map.Values.Contains(ch) || map.Keys.Contains(ch)))
                {
                Console.WriteLine("true");
                return;
                }
            Console.WriteLine("false");
        }

     
    }
}
