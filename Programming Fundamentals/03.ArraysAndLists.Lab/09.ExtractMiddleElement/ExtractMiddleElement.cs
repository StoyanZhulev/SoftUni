using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _09.ExtractMiddleElement
{
    class ExtractMiddleElement
    {
        static void Main(string[] args)
        {
            string[] n = Console.ReadLine().Split(' ');
            int[] array = n.Select(int.Parse).ToArray();



            if(array.Length == 1)
            {
                Console.WriteLine(array[0]);
            }
            else if(array.Length % 2 == 0)
            {
                //int first = (array.Length) / 2 - 1;
                //int second = (array.Length) / 2;
                //
                //Console.WriteLine(string.Join(", ", array[first], array[second]));
                EvenElements(array);
            }
            else if(array.Length % 2 != 0)
            {
                //int first = array.Length / 2 - 1;
                //int second = array.Length / 2;
                //int third = array.Length / 2 + 1;
                //
                //Console.WriteLine(string.Join(", ", array[first], array[second], array[third]));
                OddElements(array);
            }


        }

        static void EvenElements(int[] array)
        {
            int first = (array.Length) / 2 - 1;
            int second = (array.Length) / 2;

            Console.WriteLine(string.Join(", ", array[first], array[second]));
        }
        
        static void OddElements(int[] array)
        {
            int first = array.Length / 2 - 1;
            int second = array.Length / 2;
            int third = array.Length / 2 + 1;

            Console.WriteLine(string.Join(", ", array[first], array[second], array[third]));
        }
    }
}
