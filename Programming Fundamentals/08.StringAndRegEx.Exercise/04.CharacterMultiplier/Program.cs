using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _06.CharacterMultiplier
{
    class CharacterMultiplier
    {
        static void Main(string[] args)
        {
            string[] firstAndSecond = Console.ReadLine().Split();
            string first = firstAndSecond[0];
            string second = firstAndSecond[1];
            first.ToCharArray();
            second.ToCharArray();

            int minLength = Math.Min(first.Length, second.Length);
            int maxLength = Math.Max(first.Length, second.Length);

            int sum = 0;
            for (int i = 0; i < Math.Min(first.Length, second.Length); i++)
            {
                sum += (int)(first[i]) * (int)second[i];
            }

            if (first.Length > second.Length)
            {
                for (int i = minLength; i < maxLength; i++)
                {
                    sum += (int)first[i];
                }
            }
            else if (second.Length > first.Length)
            {
                for (int i = minLength; i < maxLength; i++)
                {
                    sum += (int)(second[i]);
                }
            }

            Console.WriteLine(sum);
        }
    }
}
