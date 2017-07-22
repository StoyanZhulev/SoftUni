using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _04.RoliTheCoder
{
    class RoliTheCoder
    {
        static void Main(string[] args)
        {
            string[] input = Console.ReadLine().Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries);

            Dictionary<int, Dictionary<string, List<string>>> eventsID = new Dictionary<int, Dictionary<string, List<string>>>();
            Dictionary<string, List<string>> events = new Dictionary<string, List<string>>();


            while (!input[0].Equals("Time"))
            {
                int id = int.Parse(input[0]);
                string eventName = input[1];
                if(eventName.StartsWith("#"))
                {
                    if(input.Last().Equals(input[1]))
                    {
                        
                        eventsID.Add(id, new Dictionary<string, List<string>>());
                        eventsID[id].Add(eventName, new List<string>());
                        eventsID[id][eventName].Add("0");
                        if (!events.ContainsKey(eventName))
                        {
                            events.Add(eventName, new List<string>());
                            
                        }
                    }
                    for (int i = 2; i < input.Length; i++)
                    {
                        
                        string participant = input[i];

                        if (eventsID.ContainsKey(id))
                        {                         
                            
                            if (eventsID[id].ContainsKey(eventName))
                            {
                                eventsID[id][eventName].Add(participant);
                                events[eventName].Add(participant);
                             
                            }               
                       
                        }
                        else
                        {
                            eventsID.Add(id, new Dictionary<string, List<string>>());
                            eventsID[id].Add(eventName, new List<string>());
                            eventsID[id][eventName].Add(participant);
                            if(!events.ContainsKey(eventName))
                            {
                                events.Add(eventName, new List<string>());
                                events[eventName].Add(participant);
                            }                           

                        }
                    }                
                }

                input = Console.ReadLine().Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries);
            }

           

            foreach (KeyValuePair<string, List<string>> kvp in events.OrderByDescending(x => x.Value.Count))
            {
                string[] name = kvp.Key.Split(new char[] { '#' }, StringSplitOptions.RemoveEmptyEntries);
                 string realName = name[0];
                Console.WriteLine($"{realName} - {kvp.Value.Distinct().Count()}");
                foreach (string n in events[kvp.Key].OrderBy(x => x).Distinct())
                {
                    Console.WriteLine(n);
                }
             
              
            }
        

            Console.WriteLine();
        }
    }
}
