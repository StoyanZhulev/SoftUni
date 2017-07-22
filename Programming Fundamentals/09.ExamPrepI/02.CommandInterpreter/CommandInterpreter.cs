using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _02.CommandInterpreter
{
    class CommandInterpreter
    {
        static void Main(string[] args)
        {
            string[] array = Console.ReadLine().Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries);

            string command = Console.ReadLine();

            while (!command.Equals("end"))
            {

                string[] commandArgs = command.Split();
                int start = 0;
                int count = 0;
                if (commandArgs[0].Equals("reverse"))
                {
                     start = int.Parse(commandArgs[2]);
                     count = int.Parse(commandArgs[4]);
                    if(start < 0 || count < 0 || start >= array.Length || (start + count) > array.Length)
                    {
                        Console.WriteLine("Invalid input parameters.");                       
                    }
                    else
                    {
                        string[] newArray = new string[count];
                            int index = 0;
                        for (int i = start; i <start + count; i++)
                        {
                            newArray[index] = array[i];
                            index++;
                        }
                        index = 0;
                        Array.Reverse(newArray);

                        for (int i = start; i <= count + 1; i++)
                        {
                            array[i] = newArray[index];
                            index++;
                        }
                    }
                }
                else if(commandArgs[0].Equals("sort"))
                {
                    start = int.Parse(commandArgs[2]);
                    count = int.Parse(commandArgs[4]);
                    if (start < 0 || count < 0 || start >= array.Length || (start + count) >array.Length)
                    {
                        Console.WriteLine("Invalid input parameters.");                        
                    }
                    else
                    {                     

                        string[] newArray = new string[count];
                        int index = 0;
                        for (int i = start; i < start + count; i++)
                        {
                            newArray[index] = array[i];
                            index++;
                        }
                        index = 0;
                        newArray = newArray.OrderBy(x => x).ToArray();

                        for (int i = start; i < start + count; i++)
                        {
                            array[i] = newArray[index];
                            index++;
                        }
                    }                   
                }
                else if(commandArgs[0].Equals("rollLeft"))
                {
                     count = int.Parse(commandArgs[1]);
                    if (count < 0)
                    {
                        Console.WriteLine("Invalid input parameters.");
                       
                    }
                    else
                    {
                        for (int rotation = 1; rotation <= count % array.Length; rotation++)
                        {
                            string first = array[0];
                            for (int j = 0; j < array.Length - 1; j++)
                            {
                                array[j] = array[(j + 1)];
                            }

                            array[array.Length - 1] = first;
                        }
                    }                   
                }
                else if(commandArgs[0].Equals("rollRight"))
                {
                     count = int.Parse(commandArgs[1]);
                    if (count < 0)
                    {
                        Console.WriteLine("Invalid input parameters.");                       
                    }
                    else
                    {
                        for (int rotation = 0; rotation < count % array.Length; rotation++)
                        {
                            string last = array[array.Length - 1];
                            for (int j = array.Length - 1; j > 0; j--)
                            {
                                array[j] = array[(j - 1)];
                            }

                            array[0] = last;
                        }
                    }
                    
                }            
                                
                command = Console.ReadLine();
            }

            Console.WriteLine($"[{string.Join(", ", array)}]");
        }
    }
}
