using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _02.LineNumbers
{
    class LineNumbers
    {
        static void Main(string[] args)
        {
            string[] lines = File.ReadAllLines("input.txt");

            for (int i = 0; i < lines.Length; i++)
            {
                File.AppendAllText("output.txt", (i+1) + ". "+ lines[i]+Environment.NewLine);
            }
        }
    }
}
