using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _02.Index_Lab
{
    class Index
    {
        static void Main(string[] args)
        {
            const int AlphabetSize = 26;

            char[] alphabet = new char[AlphabetSize];
            for (int i = 0; i < AlphabetSize; i++)
            {
                alphabet[i] = (char)(i + 97);
            } 

        }
    }
}
