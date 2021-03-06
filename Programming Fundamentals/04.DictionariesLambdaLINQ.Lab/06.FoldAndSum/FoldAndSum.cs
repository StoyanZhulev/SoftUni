﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _06.FoldAndSum
{
    class FoldAndSum
    {
        static void Main(string[] args)
        {
            int[] array = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();
            int k = array.Length / 4;

            int[] row1Left = array.Take(k).Reverse().ToArray();
            int[] row1Right = array.Reverse().Take(k).ToArray();
            int[] row1 = row1Left.Concat(row1Right).ToArray();
            int[] row2 = array.Skip(k).Take(2 * k).ToArray();

            var sum = row1.Select((x, index) =>x + row2[index]);

            Console.WriteLine(string.Join(" ", sum));

            //for (int i = 0; i < row1Left.Length; i++)
            //{
            //    row2[i] += row1Left[i];
            //}
            //for (int i = 0; i < row1Right.Length; i++)
            //{
            //    row2[i + k] = row1Right[i];
            //}

            //Console.WriteLine(string.Join(" ", row2));
        }
    }
}
