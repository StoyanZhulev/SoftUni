using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace _04.Cubic_sMessages.Lab
{
    class CubesMessegeLab
    {
        static void Main(string[] args)
        {
            string encryptedMessage = Console.ReadLine();
            while (!encryptedMessage.Equals("Over!"))
            {
                int count = int.Parse(Console.ReadLine());

                string pattern = @"^([0-9]+)([a-zA-Z]{" + count + @"})([^a-zA-Z]*)$";
                Regex rgx = new Regex(pattern);

                Match match = rgx.Match(encryptedMessage);

                if(match.Success)
                {
                    string message = match.Groups[2].ToString();
                    Console.Write(message + " == ");

                    List<int> indexes = GetIndexes(match);
                    foreach (var index in indexes)
                    {
                        if (0 <= index && index < message.Length)
                        {
                            Console.Write(message[index]);
                        }
                        else
                        {
                            Console.Write(" ");
                        }
                    }
                    Console.WriteLine();
                }

                encryptedMessage = Console.ReadLine();
            }
            
           
        }

        private static List<int> GetIndexes(Match match)
        {
            string left = match.Groups[1].ToString();
            List<int> indexes = new List<int>();
            for (int i = 0; i < left.Length; i++)
            {
                if (Char.IsDigit(left[i]))
                {
                    indexes.Add(int.Parse(left[i].ToString()));
                }
            }

            string right = match.Groups[3].ToString();
            for (int i = 0; i < right.Length; i++)
            {
                if (Char.IsDigit(right[i]))
                {
                    indexes.Add(int.Parse(right[i].ToString()));
                }
            }
            return indexes;
        }
    }
}
