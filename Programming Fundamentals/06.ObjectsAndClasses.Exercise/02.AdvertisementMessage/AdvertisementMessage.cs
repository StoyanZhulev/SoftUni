using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _02.AdvertisementMessage
{
    class AdvertisementMessage
    {
        static void Main(string[] args)
        {
            string[] phrases = new string[] { "Excellent product.", "Such a great product.", "I always use that product.", "Best product of its category.", "Exceptional product.", "I can’t live without this product." };
            string[] events = new string[] { "Now I feel good.", "I have succeeded with this product.", "Makes miracles. I am happy of the results!", "I cannot believe but now I feel awesome.", "Try it yourself, I am very satisfied.", "I feel great!" };
            string[] authors = new string[] { "Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva" };
            string[] cities = new string[] { "Burgas", "Sofia", "Plovdiv", "Varna", "Ruse" };

            int n = int.Parse(Console.ReadLine());

            Random phrase = new Random();
            Random revent = new Random();
            Random author = new Random();
            Random city = new Random();
            for (int i = 0; i < n; i++)
            {
               int phraseIndex = phrase.Next(0, phrases.Length);
                int eventIndex = revent.Next(0, events.Length);
                int authorIndex = author.Next(0, authors.Length);
                int townIndex = city.Next(0, cities.Length);
                Console.WriteLine("{0} {1} {2} - {3}", phrases[phraseIndex], events[eventIndex], authors[authorIndex], cities[townIndex]);
            }

        }
    }
}
