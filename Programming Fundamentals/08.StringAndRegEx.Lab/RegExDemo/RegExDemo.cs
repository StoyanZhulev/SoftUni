using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace RegExDemo
{
    class RegExDemo
    {
        static void Main(string[] args)
        {
            //slow
            string result = "";

            Stopwatch st = new Stopwatch();
            st.Start();

            for (int i = 0; i < 50000; i++)
            {
                result += (Convert.ToString(i, 2));
            }

            st.Stop();

            Console.WriteLine(st.Elapsed);


            //fast
            StringBuilder time = new StringBuilder();

            Stopwatch str = new Stopwatch();
            str.Start();

            for (int i = 0; i < 50000; i++)
            {
                time.Append(Convert.ToString(i, 2));
            }

            str.Stop();

            Console.WriteLine(str.Elapsed);
        }
    }
}
