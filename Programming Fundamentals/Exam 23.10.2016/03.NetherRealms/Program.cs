using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace _03.NetherRealms
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] demonsInfo = Console.ReadLine().Split(new char[] { ',', ' ' }, StringSplitOptions.RemoveEmptyEntries);
            Regex regex = new Regex(@"(-\d.\d)");
            for (int i = 0; i < demonsInfo.Length; i++)
            {
                string demonsName = demonsInfo[i];
                Match match = regex.Match(demonsName);
                List<char> charsInName = new List<char>();
                for (int j = 0; j < demonsName.Length; j++)
                {
                    if (Char.IsLetter(demonsName[j]))
                    {
                        charsInName.Add(demonsName[j]);
                    }
                }
                double power = 0.0;
                if (match.Success)
                {

                    power += double.Parse(match.Groups[1].ToString());
                }

                int health = 0;
                for (int j = 0; j < charsInName.Count; j++)
                {
                    health += (int)(charsInName[j]);
                }
                Console.WriteLine(health);
                Console.WriteLine($"{power: f2}");
            }
            
        }
    }
}
