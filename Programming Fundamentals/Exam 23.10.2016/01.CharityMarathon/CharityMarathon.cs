using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _01.CharityMarathon
{
    class CharityMarathon
    {
        static void Main(string[] args)
        {
            decimal days = decimal.Parse(Console.ReadLine());
            decimal runnersParticipating = decimal.Parse(Console.ReadLine());
            decimal averageLapsPerrunner = decimal.Parse(Console.ReadLine());
            decimal trackLength = decimal.Parse(Console.ReadLine());
            decimal trackCapacityPerDay = decimal.Parse(Console.ReadLine());
            decimal moneyPerKm = decimal.Parse(Console.ReadLine());

            decimal maxRunners = trackCapacityPerDay * days;
            decimal runningPlayers = 0;
            if(maxRunners >= runnersParticipating)
            {
                runningPlayers = runnersParticipating;
            }
            else
            {
                runningPlayers = maxRunners;
            }

            decimal totalMeters = runningPlayers * averageLapsPerrunner * trackLength;
            decimal totalKm = totalMeters / 1000;
            decimal money = totalKm * moneyPerKm;

            Console.WriteLine("Money raised: {0:f2}", money);
        }
    }
}
