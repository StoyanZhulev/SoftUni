using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _05.FolderSize
{
    class FolderSize
    {
        static void Main(string[] args)
        {
            string[] files = Directory.GetFiles("TestFolder");

            double sum = 0;

            foreach (string file in files)
            {
                FileInfo fileInfo = new FileInfo(file);
                sum += fileInfo.Length;
            }

            int order = 0;
            string[] size = { "B", "KB", "MB" };
            sum = sum / 1024 / 1024;

            File.WriteAllText("sum.txt", sum.ToString());
        }
    }
}
