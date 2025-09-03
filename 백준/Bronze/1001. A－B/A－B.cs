using System;

namespace MyCompiler {
    class Program {
        public static void Main(string[] args) {
            string[] st = Console.ReadLine().Split();
            int a = int.Parse(st[0]);
            int b = int.Parse(st[1]);
            Console.WriteLine(a-b);
        }
    }
}