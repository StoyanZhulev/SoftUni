using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _04.Files
{
    class Files
    {
        static void Main(string[] args)
        {
            int numberOfFiles = int.Parse(Console.ReadLine());

           
            SortedDictionary<string, SortedDictionary<string, long>> folder = new SortedDictionary<string, SortedDictionary<string, long>>();


            for (int i = 0; i < numberOfFiles; i++)
            {
                string[] fileInfo = Console.ReadLine().Split(new char[] { '\\', ';'}, StringSplitOptions.RemoveEmptyEntries);
                string folderName = fileInfo[0];
                string fileName = fileInfo[fileInfo.Length - 2];
                long fileSize = long.Parse(fileInfo[fileInfo.Length - 1]);

                if(!folder.ContainsKey(folderName))
                {
                    folder.Add(folderName, new SortedDictionary<string, long>());
                   
                }
                if(!folder[folderName].ContainsKey(fileName))
                {
                    folder[folderName].Add(fileName, fileSize);
                }
                else
                {
                    folder[folderName][fileName] = fileSize;
                }
                
            }

            string[] extensionAndRoot = Console.ReadLine().Split();
            string extension = extensionAndRoot[0];
            string root = extensionAndRoot[2];

            bool isFound = false;

             
            if(folder.ContainsKey(root))
            {
                foreach (KeyValuePair<string, long> kvp in folder[root].OrderByDescending(x => x.Value))
                {

                    if (kvp.Key.EndsWith($".{extension}"))
                    {
                        Console.WriteLine($"{kvp.Key} - {kvp.Value} KB");
                        isFound = true;
                    }
                }
            }
     

            if(isFound == false)
            {
                Console.WriteLine("No");
            }
        }
    }
}
