using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _07.PrimesInRange
{
    class PrimesInRange
    {
        static void Main(string[] args)
        {
            int startNum = int.Parse(Console.ReadLine());
            int endNum = int.Parse(Console.ReadLine());

            PrimesInTheRange(startNum, endNum);
        }


        static void PrimesInTheRange(int startNum, int endNum)
        {
            
            int num = startNum;
            for (int i = startNum; i <= endNum; i++)
            {
                bool isPrime = true;
                
                for (int j = 2; j <= Math.Sqrt(i); j++)
                {
                    if (i != j && i % j == 0)
                    {
                        isPrime = false;
                        
                    }
                                       
                }
                if (isPrime == true && i >1)
                    
                        Console.Write("{0}, ", i);
            }
        }
    }
}


