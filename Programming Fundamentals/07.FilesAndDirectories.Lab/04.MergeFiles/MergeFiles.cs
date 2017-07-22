using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _04.MergeFiles
{
    class MergeFiles
    {
        static void Main(string[] args)
        {
            string[] firstFile = File.ReadAllLines("fileOne.txt");
            string[] secondFile = File.ReadAllLines("fileTwo.txt");

            int maxLength = Math.Max(firstFile.Length, secondFile.Length);

            for (int i = 0; i < firstFile.Length; i++)
            {
                File.AppendAllText("output.txt", firstFile[i] + Environment.NewLine + secondFile[i] + Environment.NewLine);
            }
        }
    }
}
