using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _13.SplitByWordCasing
{
    class SplitByWordCasing
    {
        static void Main(string[] args)
        {
            char[] separators = new char[] { ',', ';', ':', '.', '!', '(', ')', '"', '\'', '\\', '/', '[', ']', ' ' };
            var input = Console.ReadLine().Split(separators, StringSplitOptions.RemoveEmptyEntries).ToList();


            List<string> UpperCase = new List<string>();
            List<string> MixedCase = new List<string>();
            List<string> LowerCase = new List<string>();

            foreach (var word in input)
            {
                bool isUpper = true;
                bool isLower = true;

                for (int i = 0; i < word.Length; i++)
                {
                    if (Char.IsLower(word[i]))
                    {
                        isUpper = false;
                    }
                    else if (Char.IsUpper(word[i]))
                    {
                        isLower = false;
                    }                    
                    else
                    {
                        isLower = false;
                        isUpper = false;
                    }
                }

                if(isUpper == true)
                {
                    UpperCase.Add(word);
                }
                else if(isLower == true)
                {
                    LowerCase.Add(word);
                }
                else
                {
                    MixedCase.Add(word);
                }
            }

            Console.WriteLine("Lower-case: {0}", string.Join(", ", LowerCase));

           
            Console.WriteLine("Mixed-case: {0}", string.Join(", ", MixedCase));

            
            Console.WriteLine("Upper-case: {0}",string.Join(", ", UpperCase));
        }
    }
}
