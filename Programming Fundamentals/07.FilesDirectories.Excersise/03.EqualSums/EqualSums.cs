using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _03.EqualSums
{
    class EqualSums
    {
        static void Main(string[] args)
        {
            string[] lines = File.ReadAllLines("input.txt");

            for (int i = 0; i < lines.Length; i++)
            {
                string text = lines[i];
                int[] nums = text.Split().Select(int.Parse).ToArray();

                bool isFound = false;
                int index = 0;

                if (nums.Length == 1)
                {
                    File.AppendAllText("output.txt", "0" + Environment.NewLine);
                }
                else
                {
                  
                    for (int j = 0; j < nums.Length; j++)
                    {
                        int leftSum = 0;
                        int rightSum = 0;

                        for (int k = 0; k < j; k++)
                        {
                            leftSum += nums[k];
                        }

                        for (int k = j+1; k < nums.Length; k++)
                        {
                            rightSum += nums[k];
                        }

                        if(leftSum == rightSum)
                        {
                            isFound = true;
                            index = j;
                        }

                       
                    }
                    if (isFound == false)
                    {
                        File.AppendAllText("output.txt", "no" + Environment.NewLine);
                    }
                    else
                    {
                        File.AppendAllText("output.txt", index + Environment.NewLine);
                    }
                }
            }
        }
    }
}
