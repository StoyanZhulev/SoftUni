using System;

class PriceChangeAlert
{
    static void Main()
    {
        int n = int.Parse(Console.ReadLine());
        double priceThreshold = double.Parse(Console.ReadLine());
        double FirstPrice = double.Parse(Console.ReadLine());
        double lastPrice = double.Parse(Console.ReadLine());


        for (int i = 0; i < n - 1; i++)
        {
            double currentPrice = double.Parse(Console.ReadLine());
            double difference = GetPercentigeDifference(lastPrice, currentPrice);
            bool isSignificantDifference = PriceChangeAlert.isSignificantDifference(difference, priceThreshold);

            string message = GetMessege(currentPrice, lastPrice, difference, isSignificantDifference);
            Console.WriteLine(message);

            lastPrice = currentPrice;
        }
    }

    private static string GetMessege(double currentPrice, double lastPrice, double difference, bool isSignificantDifference)
    {
        string result = "";
        if (difference == 0)
        {
            result = string.Format("NO CHANGE: {0}", currentPrice);
        }
        else if (!isSignificantDifference)
        {
            result = string.Format("MINOR CHANGE: {0} to {1} ({2:F2}%)", lastPrice, currentPrice, difference);
        }
        else if (isSignificantDifference && (difference > 0))
        {
            result = string.Format("PRICE UP: {0} to {1} ({2:F2}%)", lastPrice, currentPrice, difference);
        }
        else if (isSignificantDifference && (difference < 0))
            result = string.Format("PRICE DOWN: {0} to {1} ({2:F2}%)", lastPrice, currentPrice, difference);

        return result;
    }

    private static bool isSignificantDifference(double difference, double priceThreshold)
    {
        if (Math.Abs(priceThreshold) >= priceThreshold)
        {
            return true;
        }

        return false;
    }

    private static double GetPercentigeDifference(double lastPrice, double currentPrice)
    {
        double result = (currentPrice - lastPrice) / lastPrice;
        return result;
    }
}
