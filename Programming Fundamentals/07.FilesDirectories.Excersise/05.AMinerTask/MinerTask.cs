using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _05.AMinerTask
{
    class MinerTask
    {
        static void Main(string[] args)
        {
            
            string[] lines = File.ReadAllLines("input.txt");
            Dictionary<string, int> resources = new Dictionary<string, int>();

            for (int i = 0; i < lines.Length; i+=2)
            {
                string resourceType = lines[i];
                if(resourceType == "stop")
                {
                    break;
                }
                else
                {
                    int resourceQuantity = int.Parse(lines[i + 1]);
                    if (!resources.ContainsKey(resourceType))
                    {
                        resources.Add(resourceType, 0);
                    }

                    resources[resourceType] += resourceQuantity;
                }
                   
                
               
            }

            foreach (KeyValuePair<string, int> resource in resources)
            {
                File.AppendAllText("output.txt", $"{resource.Key} -> {resource.Value}" + Environment.NewLine);
               
            }

        }
    }
}
