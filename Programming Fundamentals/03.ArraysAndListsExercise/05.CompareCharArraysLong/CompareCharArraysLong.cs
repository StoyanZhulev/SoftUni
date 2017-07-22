using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _05.CompareCharArraysLong
{
    class CompareCharArraysLong
    {
        static void Main(string[] args)
        {
            char[] array1 = Console.ReadLine().Split(' ').Select(char.Parse).ToArray();
            char[] array2 = Console.ReadLine().Split(' ').Select(char.Parse).ToArray();
            
            if(array1.Length < array2.Length)
            {
                Console.WriteLine("{0}\n{1}", string.Join("",array1), string.Join("",array2));
            }
            else if(array2.Length < array1.Length)
            {
                Console.WriteLine("{0}\n{1}", string.Join("", array2), string.Join("", array1));
            }
            else
            {
                for (int i = 0; i < array1.Length; i++)
                {
                    if(array1[i] < array2[i])
                    {
                        Console.WriteLine("{0}\n{1}", string.Join("", array1), string.Join("", array2));
                        break;
                    }
                    else if (array2[i] < array1[i])
                    {
                        Console.WriteLine("{0}\n{1}", string.Join("", array2), string.Join("", array1));
                        break;
                        
                    }
                    else if (array1[i] == array2[i])
                    {
                        Console.WriteLine("{0}\n{1}", string.Join("", array1), string.Join("", array2));
                        break;
                    }
                }
            }
        }
    }
}
