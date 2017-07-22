using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _01.LargestCommonEnd
{
    class LargestCommonEnd
    {
        static void Main(string[] args)
        {
            string[] array1 = Console.ReadLine().Split(' ');
            string[] array2 = Console.ReadLine().Split(' ');

            int array1Length = array1.Length;
            int array2Length = array2.Length;

            int shorter = Math.Min(array1Length, array2Length);
            int longer = Math.Max(array1Length, array2Length);
            int difference = longer - shorter;
            int longestCommonLeft = int.MinValue;
            int count = 0;

            for (int i = 0; i < shorter; i++)
            {
                if(array1[i] == array2[i])
                {
                    count++;
                }
            }
            if (count > longestCommonLeft)
            {
                longestCommonLeft = count;
                count = 0;
            }

            int longestCommonRight = 0;
            for (int i = shorter-1; i >=0; i--)
            {
                if (array1Length == longer)
                {
                    if(array1[i+difference] == array2[i])
                    {
                        count++;
                        longestCommonRight = count;
                    }
                }
                else if(array2Length == longer)
                {
                    if (array2[i+difference] == array1[i])
                    {
                        count++;
                        longestCommonRight = count;
                    }
                }
            }
            
            if(longestCommonLeft > longestCommonRight)
            {
                Console.WriteLine(longestCommonLeft);
            }
            else
            {
                Console.WriteLine(longestCommonRight);
            } 
        }
    }
}
