using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _03.AMinerTask
{
    class MinerTask
    {
        static void Main(string[] args)
        {
            Dictionary<string, int> resources = new Dictionary<string, int>();

            string resourceType = Console.ReadLine();

            while (!resourceType.Equals("stop"))
            {
                int resourceQuantity = int.Parse(Console.ReadLine());

                if(!resources.ContainsKey(resourceType))
                {
                    resources.Add(resourceType, 0);
                }

                resources[resourceType] += resourceQuantity;
                resourceType = Console.ReadLine();
            }

            foreach (KeyValuePair<string, int> resource in resources)
            {
                Console.WriteLine($"{resource.Key} -> {resource.Value}");
            }
        }
    }
}
