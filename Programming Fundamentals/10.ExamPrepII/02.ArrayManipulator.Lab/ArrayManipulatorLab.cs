using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _02.ArrayManipulator.Lab
{
    class ArrayManipulatorLab
    {
        static void Main(string[] args)
        {
            List<int> nums = Console.ReadLine().Split().Select(int.Parse).ToList();

            string command = Console.ReadLine();

            while (!command.Equals("end"))
            {
                string[] userInput = command.Split();

                switch (userInput[0])
                {
                    case "exchange":
                       nums = ExecuteExchange(nums, userInput);
                        break;

                    case "max":
                        GetMaxIndex(nums, userInput);
                        break;

                    case "min":
                        GetMinIndex(nums, userInput);
                        break;

                    case "first":
                        GetFirst(nums, userInput);
                        break;

                    case "last":
                        GetLast(nums, userInput);
                        break;

                    default:
                        Console.WriteLine("Invalid command");
                        break;
                }

                command = Console.ReadLine();
            }
            Console.WriteLine($"[{string.Join(", ", nums)}]");
        }

        private static void GetLast(List<int> nums, string[] userInput)
        {
            int count = int.Parse(userInput[1]);
            if (count > nums.Count)
            {
                Console.WriteLine("Invalid count");
                return;
            }
            string type = userInput[2];
            int remainder = type == "even" ? 0 : 1;

            List<int> temp =nums.Where(x => x % 2 == remainder).Reverse().Take(count).Reverse().ToList();

            Console.WriteLine($"[{string.Join(", ", temp)}]");
        }

        private static void GetFirst(List<int> nums, string[] userInput)
        {
            int count = int.Parse(userInput[1]);
            if(count > nums.Count)
            {
                Console.WriteLine("Invalid count");
                return;
            }
            List<int> temp = new List<int>();

            string type = userInput[2];
            
            int remainder = type == "even" ? 0 : 1;

            for (int i = 0; i < nums.Count; i++)
            {
                if(nums[i] % 2 == remainder && temp.Count() < count)
                {
                    temp.Add(nums[i]);
                }
            }
            Console.WriteLine($"[{string.Join(", ", temp)}]");
        }

        private static void GetMinIndex(List<int> nums, string[] userInput)
        {
            string type = userInput[1];
            int min = int.MaxValue;
            int index = 0;

            if(type == "even")
            {
                for (int i = 0; i < nums.Count; i++)
                {
                    if (nums[i] % 2 == 0)
                    {
                        if (nums[i] <= min)
                        {
                            min = nums[i];
                            index = i;
                        }
                    }
                }
                if(min == int.MaxValue)
                {
                    Console.WriteLine("No matches");
                }
                else
                {
                    Console.WriteLine(index);
                }
                
            }
            else
            {
                for (int i = 0; i < nums.Count; i++)
                {
                    if (nums[i] % 2 != 0)
                    {
                        if (nums[i] <= min)
                        {
                            min = nums[i];
                            index = i;
                        }
                    }
                }
                if (min == int.MaxValue)
                {
                    Console.WriteLine("No matches");
                }
                else
                {
                    Console.WriteLine(index);
                }
            }
            
        }

        private static void GetMaxIndex(List<int> nums, string[] userInput)
        {
            string type = userInput[1];

            if (type == "even")
            {
                var filtered = nums.Where(x => x % 2 == 0);
                if(filtered.Count() > 0)
                {
                    int max = filtered.Max();
                    int maxIndex = nums.LastIndexOf(max);
                    Console.WriteLine(maxIndex);
                }
                else
                {
                    Console.WriteLine("No matches");
                }
            }
            else
            {
                var filtered = nums.Where(x => x % 2 != 0);
                if (filtered.Count() > 0)
                {
                    int max = filtered.Max();
                    int maxIndex = nums.LastIndexOf(max);
                    Console.WriteLine(maxIndex);
                }
                else
                {
                    Console.WriteLine("No matches");
                }
            }
        }

        private static List<int> ExecuteExchange(List<int> nums, string[] userInput)
        {
            int index = int.Parse(userInput[1]);

            if (index < 0 || nums.Count <= index)
            {
                Console.WriteLine("Invalid index");                                             
            }
            List<int> temp = nums.Skip(index + 1).ToList();
            temp.AddRange(nums.Take(index + 1));

            return temp;     
        }
    }
}
