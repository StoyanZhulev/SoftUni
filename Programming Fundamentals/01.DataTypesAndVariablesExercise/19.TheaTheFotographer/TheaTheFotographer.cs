using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _19.TheaTheFotographer
{
    class TheaTheFotographer
    {
        static void Main(string[] args)
        {
            int picturesTaken = int.Parse(Console.ReadLine());
            int pictureFilterTime = int.Parse(Console.ReadLine());
            int percentGoodPictures = int.Parse(Console.ReadLine());
            int pictureUploadingTime = int.Parse(Console.ReadLine());
            
            long filteredPictures = (long) Math.Ceiling(picturesTaken * percentGoodPictures / 100d);
            long filterTime = (long)picturesTaken * pictureFilterTime;
            long uploadTime = filteredPictures * pictureUploadingTime;
            long totalTime = filterTime + uploadTime;

            TimeSpan time = TimeSpan.FromSeconds(totalTime);

            Console.WriteLine("{0:d\\:hh\\:mm\\:ss}", time);
            Console.WriteLine("{0:D1}:{1:D2}:{2:D2}:{3:D2}", timeSpan.Day, timeSpan.Hours, timeSpan.Minutes, timeSpan.Seconds);
                         
        }
    }
}
