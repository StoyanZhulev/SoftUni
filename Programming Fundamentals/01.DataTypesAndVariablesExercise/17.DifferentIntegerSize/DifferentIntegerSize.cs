using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _17.DifferentIntegerSize
{
    class DifferentIntegerSize
    {
        static void Main(string[] args)
        {
            decimal N = decimal.Parse(Console.ReadLine());
          
            bool isByte = false;
            bool isSByte = false;
            bool isShort = false;
            bool isUShort = false;
            bool isInt = false;
            bool isUint = false;
            bool isLong = false;
           

            if (N >= -128 && N <= 127)
                isSByte = true;
            if (N >= 0 && N <= 255)
                isByte = true;
            if (N >= -32768 && N <= 32767)
                isShort = true;
            if (N >= 0 && N <= 65535)
                isUShort = true;
            if (N >= -2147483648 && N <= 2147483647)
                isInt = true;
            if (N >= 0 && N <= 4294967295)
                isUint = true;
            if (N >= -9223372036854775808 && N <= 9223372036854775807)
                isLong = true;
           
            if ( N > 9223372036854775807)
                Console.WriteLine("can't fit in any type");
            else if (isSByte == false && isByte == false && isShort == false && isUShort == false && isInt == false && isUint == false && isLong == false )
                Console.WriteLine("can't fit in any type");
            else
                Console.WriteLine("{0} can fit in:", N);

            if (isSByte == true)
                Console.WriteLine("* sbyte");
            if(isByte == true)
                Console.WriteLine("* byte");
            if(isShort == true)
                Console.WriteLine("* short");
            if(isUShort == true)
                Console.WriteLine("* ushort");
            if(isInt == true)
                Console.WriteLine("* int");
            if (isUint == true)
                Console.WriteLine("* uint");
            if(isLong == true)
                Console.WriteLine("* long");
         
        }
    }
}
