using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _4.FixEmails
{
    class FixEmails
    {
        static void Main(string[] args)
        {
            Dictionary<string, string> emailBox = new Dictionary<string, string>();

            string name = Console.ReadLine();
            

            while (!name.Equals("stop"))
            {
                string email = Console.ReadLine();
                string lastSymbols = email.Substring(email.Length - 2);
                if (!lastSymbols.Equals("us") && !lastSymbols.Equals("uk"))
                {
                    emailBox.Add(name, email);
                }
                
                name = Console.ReadLine();
                
                                            
            }
            foreach (KeyValuePair<string,string> mail in emailBox)
            {
                Console.WriteLine($"{mail.Key} -> {mail.Value}");
            }
        }
    }
}
