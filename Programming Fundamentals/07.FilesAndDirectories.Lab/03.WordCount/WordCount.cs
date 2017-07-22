using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _03.WordCount
{
    class WordCount
    {
        static void Main(string[] args)
        {
            string[] words = File.ReadAllText("words.txt").ToLower().Split();
            string[] text = File.ReadAllText("text.txt").ToLower().Split(new char[] { '\n', '\r', ' ', '.', ',', '!', '?', '-' }, StringSplitOptions.RemoveEmptyEntries);

            Dictionary<string, int> wordsCount = new Dictionary<string, int>();
            foreach (var word in words)
            {
                wordsCount[word] = 0;
            }

            foreach (var word in text)
            {
                if(wordsCount.ContainsKey(word))
                {
                    wordsCount[word]++;
                }               
            }

            foreach (var item in wordsCount.OrderByDescending(p => p.Value))
            {
                File.AppendAllText("output.txt", string.Format("{0} - {1}{2}", item.Key, item.Value,Environment.NewLine));
            }
        }
    }
}
