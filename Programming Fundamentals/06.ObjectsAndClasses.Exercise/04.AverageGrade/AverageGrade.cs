using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _04.AverageGrades
{
    class Program
    {
        static void Main(string[] args)
        {
            int numberOfStudents = int.Parse(Console.ReadLine());
            List<Student> students = new List<Student>();

            for (int i = 0; i < numberOfStudents; i++)
            {
                string[] inputTokens = Console.ReadLine().Split();

                string studentName = inputTokens[0];
                List<double> grades = new List<double>();
                for (int j = 1; j < inputTokens.Length; j++)
                {
                    grades.Add(double.Parse(inputTokens[j]));
                }
                Student student = new Student();
                student.Name = studentName;
                student.Grades = grades;

                students.Add(student);
            }
            foreach (Student student in students.Where(s => s.AverageGrade() >= 5).OrderBy(s => s.Name).ThenByDescending(s => s.AverageGrade()))
            {
                Console.WriteLine($"{student.Name} -> {student.AverageGrade():F2}");
            }
        }
    }

    class Student
    {
        public string Name { get; set; }
        public List<double> Grades { get; set; }
        public double AverageGrade()
        {
            double averageGrades = this.Grades.Average();
            return averageGrades;

            //get{ return Grades.Average(); } Алтернативен вариант
        }
    }
}
