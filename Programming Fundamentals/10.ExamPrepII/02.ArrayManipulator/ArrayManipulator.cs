using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _02.ArrayManipulator
{
    class ArrayManipulator
    {
        static void Main(string[] args)
        {
            List<int> nums = Console.ReadLine()
                .Split(' ').Select(int.Parse).ToList();

            string[] command = Console.ReadLine().Split();

            List<int> currentList = new List<int>();
            int index = 0;
            bool isFound = false;
            int count = 0;
            int counter = 0;
            while (!command[0].Equals("end"))
            {
                switch (command[0])
                {
                    case "exchange":
                        index = int.Parse(command[1]);

                        if (index < 0 || index > nums.Count - 1)
                        {
                            Console.WriteLine("Invalid index");
                            break;
                        }
                        else
                        {
                            currentList = nums.Skip(index + 1).Take(nums.Count - index - 1).ToList();
                            nums.RemoveRange(index + 1, nums.Count - index - 1);
                            nums.InsertRange(0, currentList);
                            index = 0;
                           
                        }                
                        
                        break;

                    case "max":
                        if (command[1].Equals("even"))
                        {
                            int maxEven = 0;
                            isFound = false;
                            index = 0;
                            for (int i = 0; i < nums.Count; i++)
                            {
                                if (nums[i] % 2 == 0)
                                {
                                    isFound = true;
                                    if (nums[i] >= maxEven)
                                    {
                                        maxEven = nums[i];
                                        index = i;
                                    }
                                }
                            }
                            if(isFound == false)
                            {
                                Console.WriteLine("No matches");
                            }
                            else
                            {
                                Console.WriteLine(index);
                            }
                            index = 0;
                            
                        }
                        else if (command[1].Equals("odd"))
                        {
                            int maxOdd = 0;
                            index = 0;
                            isFound = false;
                            for (int i = 0; i < nums.Count; i++)
                            {
                                if (nums[i] % 2 != 0)
                                {
                                    isFound = true;
                                    if (nums[i] >= maxOdd)
                                    {
                                        maxOdd = nums[i];
                                        index = i;
                                    }
                                }
                            }
                            if (isFound == false)
                            {
                                Console.WriteLine("No matches");
                            }
                            else
                            {
                                Console.WriteLine(index);
                            }
                            index = 0;
                        }
                        break;

                    case "min":
                        if (command[1].Equals("even"))
                        {
                            isFound = false;
                            int minEven = int.MaxValue;
                            index = 0;
                            for (int i = 0; i < nums.Count; i++)
                            {
                                if (nums[i] % 2 == 0)
                                {
                                    isFound = true;
                                    if (nums[i] <= minEven)
                                    {
                                        minEven = nums[i];
                                        index = i;
                                    }
                                }
                            }
                            if (isFound == false)
                            {
                                Console.WriteLine("No matches");
                            }
                            else
                            {
                                Console.WriteLine(index);
                            }
                            index = 0;
                        }
                        else if (command[1].Equals("odd"))
                        {
                            isFound = false;
                            int minOdd = int.MaxValue;
                            index = 0;
                            for (int i = 0; i < nums.Count; i++)
                            {
                                
                                if (nums[i] % 2 != 0)
                                {
                                    isFound = true;
                                    if (nums[i] <= minOdd)
                                    {
                                        minOdd = nums[i];
                                        index = i;
                                    }
                                }
                            }
                            if (isFound == false)
                            {
                                Console.WriteLine("No matches");
                            }
                            else
                            {
                                Console.WriteLine(index);
                            }
                            index = 0;
                        }
                        break;

                    case "first":
                        {                            
                            if(command[2].Equals("even"))
                            {
                                currentList.Clear();
                                count = int.Parse(command[1]);
                                counter = 0;
                                if (count > nums.Count)
                                {
                                    Console.WriteLine("Invalid count");
                                }
                                else
                                {

                                    isFound = false;
                                    for (int i = 0; i < nums.Count; i++)
                                    {
                                        if (nums[i] % 2 == 0)
                                        {
                                            isFound = true;
                                            counter++;
                                            currentList.Add(nums[i]);                                            
                                            if (counter == count)
                                            {
                                                break;
                                            }
                                        }
                                    }
                                    if (isFound == false)
                                    {
                                        Console.WriteLine("[]");
                                    }
                                    else
                                    {
                                        Console.WriteLine($"[{string.Join(", ",currentList)}]");
                                    }
                                }
                            }
                            else if(command[2].Equals("odd"))
                            {
                                
                                count = int.Parse(command[1]);
                                counter = 0;
                                if (count > nums.Count)
                                {
                                    Console.WriteLine("Invalid count");
                                }
                                else
                                {
                                    currentList.Clear();
                                    isFound = false;
                                    for (int i = 0; i < nums.Count; i++)
                                    {
                                        if (nums[i] % 2 != 0)
                                        {
                                            isFound = true;
                                            counter++;
                                            currentList.Add(nums[i]);
                                            if (counter == count)
                                            {
                                                break;
                                            }
                                        }
                                    }
                                    if (isFound == false)
                                    {
                                        Console.WriteLine("[]");
                                    }
                                    else
                                    {
                                        Console.WriteLine($"[{string.Join(", ", currentList)}]");
                                    }
                                }                             
                            }
                        }
                        break;

                    case "last":
                        if (command[2].Equals("even"))
                        {
                            count = int.Parse(command[1]);
                            counter = 0;
                            if (count > nums.Count)
                            {
                                Console.WriteLine("Invalid count");
                            }
                            else
                            {
                                isFound = false;
                                currentList.Clear();
                                for (int i = nums.Count - 1; i >= 0; i--)
                                {
                                    if (nums[i] % 2 == 0)
                                    {
                                        isFound = true;
                                        counter++;
                                        currentList.Add(nums[i]);
                                        currentList.Reverse();
                                        if (counter == count)
                                        {
                                            break;
                                        }
                                    }
                                }
                                if (isFound == false)
                                {
                                    Console.WriteLine("[]");
                                }
                                else
                                {
                                    Console.WriteLine($"[{string.Join(", ", currentList)}]");
                                }
                            }
                        }
                        else if (command[2].Equals("odd"))
                        {
                            count = int.Parse(command[1]);
                            counter = 0;
                            if (count > nums.Count)
                            {
                                Console.WriteLine("Invalid count");
                            }
                            else
                            {
                                currentList.Clear();
                                isFound = false;
                                for (int i = nums.Count - 1; i >= 0; i--)
                                {
                                    if (nums[i] % 2 != 0)
                                    {
                                        isFound = true;
                                        counter++;
                                        currentList.Add(nums[i]);
                                        currentList.Reverse();
                                        if (counter == count)
                                        {
                                            break;
                                        }
                                    }
                                }
                                if (isFound == false)
                                {
                                    Console.WriteLine("[]");
                                }
                                else
                                {
                                    Console.WriteLine($"[{string.Join(", ", currentList)}]");
                                }
                            }
                        }                        
                        break;

                    default:
                        Console.WriteLine("Invalid command");
                        break;                        
                }
                command = Console.ReadLine().Split(' ');
            }

            Console.WriteLine($"[{string.Join(", ", nums)}]");
        }
    }
}
