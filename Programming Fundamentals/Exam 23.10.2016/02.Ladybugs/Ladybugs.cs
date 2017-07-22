using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _02.Ladybugs
{
    class Ladybugs
    {
        static void Main(string[] args)
        {
            int fieldSize = int.Parse(Console.ReadLine());
            int[] array = new int[fieldSize];

            int[] indexesOfLadybugs = Console.ReadLine().Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries).Select(int.Parse).ToArray();

            for (int i = 0; i < indexesOfLadybugs.Length; i++)
            {
                if (0 <= indexesOfLadybugs[i] && indexesOfLadybugs[i] < array.Length)
                {
                    array[indexesOfLadybugs[i]] = 1;
                }
            }

            string[] command = Console.ReadLine().Split();
            while (!command[0].Equals("end"))
            {
                int count = 0;
                int ladybugIndex = int.Parse(command[0]);
                switch (command[1])
                {
                    case "right":
                        ladybugIndex = int.Parse(command[0]);
                        if (ladybugIndex < 0 || ladybugIndex >= array.Length)
                        {
                            break;
                        }
                        else if (array[ladybugIndex] != 1)
                        {
                            break;
                        }
                        else
                        {
                            for (int i = ladybugIndex; i <= array.Length; i++)
                            {
                                string direction = command[1];
                                int positions = int.Parse(command[2]);
                                if (positions < 0)
                                {

                                    if ((ladybugIndex - Math.Abs(positions)) < 0)
                                    {
                                        array[ladybugIndex] = 0;
                                        break;
                                    }                                    
                                    else if (array[ladybugIndex - Math.Abs(positions)] == 0)
                                    {
                                        array[ladybugIndex] = 0;
                                        array[ladybugIndex - Math.Abs(positions)] = 1;
                                        break;
                                    }
                                    else
                                    {
                                        array[ladybugIndex] = 0;
                                        positions = Math.Abs(positions);
                                        positions += Math.Abs(positions);
                                        if ((ladybugIndex - Math.Abs(positions)) < 0)
                                        {
                                            break;
                                        }
                                        if (array[ladybugIndex - Math.Abs(positions)] == 0)
                                        {
                                            array[ladybugIndex - Math.Abs(positions)] = 1;
                                            break;
                                        }
                                        
                                    }
                                }


                                if ((ladybugIndex + positions) >= array.Length)
                                {
                                    array[ladybugIndex] = 0;
                                    break;
                                }                                
                                else if (array[ladybugIndex + positions] == 0)
                                {
                                    array[ladybugIndex] = 0;
                                    array[ladybugIndex + positions] = 1;
                                }
                                else
                                {
                                    
                                    positions += positions = count;
                                    if ((ladybugIndex + positions) > array.Length- 1)
                                    {
                                        array[ladybugIndex] = 0;
                                        break;
                                    }
                                    else if (array[ladybugIndex + positions] == 0)
                                    {
                                        array[ladybugIndex] = 0;
                                        array[ladybugIndex + positions] = 1;
                                    }
                                    count++;
                                }
                            }
                        }


                        break;
                    case "left":
                        ladybugIndex = int.Parse(command[0]);
                        if (ladybugIndex < 0 || ladybugIndex > array.Length - 1)
                        {
                            break;
                        }
                        else if (array[ladybugIndex] != 1)
                        {
                            break;
                        }
                        else
                        {
                            for (int i = ladybugIndex; i >= 0; i--)
                            {

                                string direction = command[1];
                                int positions = int.Parse(command[2]);
                                if (positions < 0)
                                {
                                    if ((ladybugIndex + Math.Abs(positions)) >= array.Length)
                                    {
                                        array[ladybugIndex] = 0;
                                        break;
                                    }                                    
                                    else if (array[ladybugIndex + Math.Abs(positions)] == 0)
                                    {
                                        array[ladybugIndex] = 0;
                                        array[ladybugIndex + Math.Abs(positions)] = 1;
                                        break;
                                    }
                                    else
                                    {
                                        
                                        positions = Math.Abs(positions);
                                        positions += Math.Abs(positions) + count;
                                        if ((ladybugIndex + Math.Abs(positions)) >= array.Length)
                                        {
                                            array[ladybugIndex] = 0;
                                            break;
                                        }
                                        if (array[ladybugIndex + positions] == 0)
                                        {
                                            array[ladybugIndex] = 0;
                                            array[ladybugIndex + positions] = 1;
                                            break;
                                        }
                                        count++;
                                    }

                                }


                                if ((ladybugIndex - positions) < 0)
                                {
                                    array[ladybugIndex] = 0;
                                    break;
                                }                                
                                else if (array[ladybugIndex - positions] == 0)
                                {
                                    array[ladybugIndex] = 0;
                                    array[ladybugIndex - positions] = 1;
                                }
                                else
                                {
                                    
                                    positions += positions + count;
                                    if ((ladybugIndex - positions) < 0)
                                    {
                                        array[ladybugIndex] = 0;
                                        break;
                                    }
                                    else if (array[ladybugIndex - positions] == 0)
                                    {
                                        array[ladybugIndex] = 0;
                                        array[ladybugIndex - positions] = 1;
                                    }
                                    count++;
                                }
                            }
                        }

                        break;
                    default:
                        break;
                }
                command = Console.ReadLine().Split();
            }

            Console.WriteLine(string.Join(" ", array));
        }
    }
}
