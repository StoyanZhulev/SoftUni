using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _12.MasterNumber
{
    class MasterNumber
    {
        static void Main(string[] args)
        {
            int number =int.Parse(Console.ReadLine());

           bool isPalindrom = isPalindrome(number);
           bool sumOfDigits = SumOfDigits(number);
           bool hasEvenDigit = HasEvenDigit(number);
          
            for (int i = 1; i <= number; i++)
            {
                if (isPalindrome(i) == true && SumOfDigits(i) == true && HasEvenDigit(i) == true)
                {
                    Console.WriteLine(i);
                }
            }            
        }

        static bool isPalindrome(int number)
        {
            string text = number.ToString();
            int length = text.Length;
            for (int i = 0; i < length / 2; i++)
            {
                if (text[i] != text[length - i - 1])
                    return false;
            }
            return true;
        }
        
        static bool SumOfDigits (int number)
        {
            string text = number.ToString();
            int sumOfDigits = 0;
            for (int i = 0; i < text.Length; i++)
            {
                sumOfDigits += int.Parse(text[i].ToString());
            }
            if (sumOfDigits % 7 == 0)
            {
                return true;
            }
            else
            {
                return false;
            }
            
                                 
        }

        static bool HasEvenDigit (int number)
        {
            string text = number.ToString();
            int evenCounter = 0;
            for (int i = 0; i < text.Length; i++)
            {
                int currentDigit = int.Parse(text[i].ToString());
                if(currentDigit % 2 == 0)
                {
                    evenCounter++;
                }
            }
            if(evenCounter > 0)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }
}
