using System;
using System.Threading;

namespace Sort
{
    class Program
    {
        public static int[] insertionSort(int[] A)
        {                      
            for (int i = 1; i < A.Length; i++)
            {
                int h = A[i];
                int j = i - 1;
                while(j >= 0 && A[j]>h )
                {
                    A[j + 1] = A[j];
                    j = j - 1;
                }
                A[j + 1] = h;
            }
            return A;
        }
        static void Main(string[] args)
        {
            int[] A = { 4, 2, 3, 1 };
            A = insertionSort(A);
            for(int i = 0; i < A.Length; i++)
            {
                Console.Write(A[i] + " ");
            }
            Thread.Sleep(10000);
        }
    }
}
