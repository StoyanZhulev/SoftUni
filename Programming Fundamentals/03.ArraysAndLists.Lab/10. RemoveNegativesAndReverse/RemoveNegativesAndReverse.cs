using System;
using System.Collections.Generic;

namespace _10.RemoveNegativesAndReverse
{
    class RemoveNegativesAndReverse
    {
        static void Main(string[] args)
        {
            string[] numbersAsString = Console.ReadLine().Split(' ');
            List<int> numbers = new List<int>();

            foreach (var numbersAsText in numbersAsString)
            {
                numbers.Add(int.Parse(numbersAsText));
            }

           // List<int> positiveNumbers = new List<int>();
            for (int i = 0; i < numbers.Count; i++)
            {
                int number = numbers[i];

                if (number < 0)  //>0
                {
                     numbers.Remove(number);
                     i--;
                   // positiveNumbers.Add(number);
                }
            }
            numbers.Reverse();
            if (numbers.Count == 0)
                Console.WriteLine("empty");
            else
                Console.WriteLine(string.Join(" ", numbers));

            //int[] arr = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();
            //List<int> integers = new List<int>();
            //integers.AddRange(arr);
            //List<int> result = new List<int>();
            //result.AddRange(integers.FindAll(item => item > 0));
            //result.Reverse();
            //if (result.Count == 0)
            //{
            //    Console.WriteLine("empty");
            //}
            //else
            //{
            //    Console.WriteLine(string.Join(" ", result));
            //}


        }
    }
}
