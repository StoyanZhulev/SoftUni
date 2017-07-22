using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _01.OddLines
{
    class OddLines
    {
        static void Main(string[] args)
        {
            string[] text = File.ReadAllLines("input.txt");

            for (int i = 1; i < text.Length; i+=2)
            {
                File.AppendAllText("output.txt", text[i] + Environment.NewLine);
            }
        }
    }
}
