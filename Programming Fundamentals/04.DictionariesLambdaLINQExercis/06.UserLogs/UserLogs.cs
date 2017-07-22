using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _06.USerLogs
{
    class UserLogs
    {
        static void Main(string[] args)
        {
            SortedDictionary<string, Dictionary<string, int>> userLogs = new SortedDictionary<string, Dictionary<string, int>>();
            string input = Console.ReadLine();

            while (!input.Equals("end"))
            {
                string[] text = input.Split(' ').ToArray();
                string[] IP = text[0].Split('=').ToArray();

                string ipAddres = IP[1];               
                string[] user = text[2].Split('=').ToArray();
                string userName = user[1];

                if (!userLogs.ContainsKey(userName))
                {
                    userLogs[userName] = new Dictionary<string, int>();
                    userLogs[userName].Add(ipAddres, 1);
                }
                else
                {
                    if (userLogs[userName].ContainsKey(ipAddres))
                    {
                        userLogs[userName][ipAddres]++;
                    }
                    else
                    {
                        userLogs[userName].Add(ipAddres, 1);
                    }
                }

                input = Console.ReadLine();

            }

            userLogs.OrderBy(x => x.Key);
            foreach (string userName in userLogs.Keys)
            {
                
                Console.WriteLine($"{userName}: ");

                userLogs[userName].OrderBy(x => x.Value);
                int count = 0;
                foreach (KeyValuePair<string, int> ipAddres in userLogs[userName])
                {
                    if (count == userLogs[userName].Count - 1)
                    {
                        Console.WriteLine($"{ipAddres.Key} => {ipAddres.Value}.");
                    }
                    else
                    {
                        Console.Write($"{ipAddres.Key} => {ipAddres.Value}, ");
                    }
                    count++;
                }
            }
        }

    }
}
