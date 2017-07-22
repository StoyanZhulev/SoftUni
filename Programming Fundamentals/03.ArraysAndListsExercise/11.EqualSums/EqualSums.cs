using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _11.EqualSums
{
    class EqualSums
    {
        static void Main(string[] args)
        {
            int[] array = Console.ReadLine()
                .Split(' ')
                .Select(int.Parse)
                .ToArray();
            bool isFound = false;
            int index = 0;

            if (array.Length == 1)
            {
                Console.WriteLine("0");
            }
            else
            {
                
                for (int i = 0; i < array.Length; i++)
                {
                    int leftSum = 0;
                    int rigghtSum = 0;
                   

                    for (int j = 0; j < i; j++)
                    {
                        leftSum += array[j];
                    }

                    for (int j = i + 1; j < array.Length; j++)
                    {
                        rigghtSum += array[j];
                    }

                    if(leftSum == rigghtSum)
                    {
                        isFound = true;
                        index = i;
                    }

                }

               if(isFound == false)
                {
                    Console.WriteLine("no");
                }
                else
                {
                    Console.WriteLine(index);
                }
            }
        }
    }
}
