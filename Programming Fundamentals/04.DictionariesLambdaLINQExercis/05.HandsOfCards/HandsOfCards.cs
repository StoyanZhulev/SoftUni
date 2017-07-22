using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _05.HandsOfCards
{
    class HandsOfCards
    {
        static void Main(string[] args)
        {
            Dictionary<string, List<string>> playerCards = new Dictionary<string, List<string>>();

            string commandLine = Console.ReadLine();

            while (!commandLine.Equals("JOKER"))
            {
                string[] commandArgs = commandLine
                    .Split(new char[] { ':' }, StringSplitOptions.RemoveEmptyEntries);

                string playerName = commandArgs[0];
                string[] cards = commandArgs[1]
                    .Split(new char[] { ',' }, StringSplitOptions.RemoveEmptyEntries)
                    .Select(c => c.Trim())
                    .ToArray();

                if(!playerCards.ContainsKey(playerName))
                {
                    playerCards.Add(playerName, new List<string>());
                }

                playerCards[playerName].AddRange(cards);

                commandLine = Console.ReadLine();
            }
           
             PrintPlayersScores(playerCards);
        }

        private static void PrintPlayersScores(Dictionary<string, List<string>> playerCards)
        {
            foreach (var playerEntry in playerCards)
            {
                string playerName = playerEntry.Key;
                List<string> cards = playerEntry.Value.Distinct().ToList();

                int playerScore = 0;
                foreach (var card in cards)
                {
                    string rank = card.Substring(0, card.Length - 1);
                    string suite = card.Substring(card.Length - 1);

                    int rankPower = GetRank(card);
                    int suitePower = GetSuite(card);

                    playerScore += rankPower * suitePower;
                }
                Console.WriteLine("{0} -> {1}", playerName, playerScore);
            }

        }

        private static int GetSuite(string suite)
        {
            switch (suite)
            {
                case "S":
                    return 4;
                case "H":
                    return 3;
                case "D":
                    return 2;
                case "C":
                    return 1;
               default:
                    return 1;
                   
            }
        }

        private static int GetRank(string rank)
        {
            switch (rank)
            {
                case "2":
                    return 2;
                case "3":
                    return 3;
                case "4":
                    return 4;
                case "5":
                    return 5;
                case "6":
                    return 6;
                case "7":
                    return 7;
                case "8":
                    return 8;

                default:
                    return 1;
                  
            }
        }
    }
}
