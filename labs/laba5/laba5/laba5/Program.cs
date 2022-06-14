using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;


namespace laba5
{
    class Program
    {
        private String model;
        private String type;
        private String price;

        public Program(String model, String type, String price) {
            this.model = model;
            this.type = type;
            this.price = price;
        }

        public static void IncreaseLength(ref string[] arr, int delta)
        {
            string[] tmp = new string[arr.Length + delta];
            Array.Copy(arr, 0, tmp, 0, arr.Length);
            arr = tmp;
        }
        public static void DeleteEmptyLines(String path)
        {
            string[] file = File.ReadAllLines(path);
            List<string> list = new List<string>(file);
            list.RemoveAll(x => x == string.Empty);
            File.WriteAllLines(path, list);
        }



        static void Main(string[] args)
        {
            string path = @"/Users/ryu/Desktop/rsoi/labs/laba5/laba5/db.txt";
            string path2 = @"/Users/ryu/Desktop/rsoi/labs/laba5/laba5/sorteddb.txt";

            Console.WriteLine("Menu:\n 1. Enter a new computer;\n 2. Edit a computer;\n 3. Delete a computer;\n 4. List all computers;\n 5. Sort computers by price;\n 6. Search for a computer by price;\n");
            int choice = int.Parse(Console.ReadLine());
            while (choice != 7)
            {
                switch(choice)
                {
                    case 1:{
                            Console.WriteLine("Enter the type, model and price:\n");
                            string type = Console.ReadLine();
                            string model = Console.ReadLine();
                            string price = Console.ReadLine();

                            Program obj = new Program(type, model, price);
                            FileStream fstr = new FileStream(path, FileMode.OpenOrCreate, FileAccess.Write);
                            fstr.Seek(0, SeekOrigin.End);
                            StreamWriter sw = new StreamWriter(fstr);
                            sw.WriteLine(obj.type + " " + obj.model + " " + obj.price + " ");
                            sw.Close();
                            fstr.Close();
                            break;
                        };
                    case 2:{
                            string line;
                            int i = 0;
                            int index = 0;
                            string[] temp = new string[0];
                            Console.WriteLine("Enter type:");
                            String chtoishem = Console.ReadLine();
                            Console.WriteLine("Enter new type:");
                            String new_type = Console.ReadLine();
                            using (StreamReader sr = new StreamReader(path))
                            {
                                while ((line = sr.ReadLine()) != null)
                                {
                                    if (line.StartsWith(chtoishem) || line.StartsWith(chtoishem.ToLower()) && (i == 0))
                                    {
                                        string[] newline = line.Split(" ");
                                        newline[0] = new_type;

                                        line = string.Join(" ", newline);
                                        //line = new_type;
                                        i = 1;
                                    }
                                    IncreaseLength(ref temp, 1);
                                    temp[index] = line;
                                    index = index + 1;
                                }
                            }
                            using (StreamWriter sw = new StreamWriter(path, false))
                            {
                                foreach (string str in temp)
                                    sw.WriteLine(str);
                            }
                            break;
                        }
                    case 3:
                        {
                            string line;
                            int i = 0;
                            int index = 0;
                            string[] temp = new string[0];
                            Console.WriteLine("Enter type:");
                            String find = Console.ReadLine();
                            using (StreamReader sr = new StreamReader(path))
                            {
                                while ((line = sr.ReadLine()) != null)
                                {
                                    if (line.StartsWith(find) || line.StartsWith(find.ToLower()) && (i == 0))
                                    {
                                        line = String.Empty;
                                        i = 1;
                                    }
                                    IncreaseLength(ref temp, 1);
                                    temp[index] = line;
                                    index = index + 1;
                                }
                                sr.Close();
                            }
                            using (StreamWriter sw = new StreamWriter(path, false))
                            {
                                foreach (string str in temp)
                                    sw.WriteLine(str);
                                sw.Close();
                            }
                            DeleteEmptyLines(path);
                            break;
                        };
                    case 4:
                        {
                            Console.WriteLine("List all computers:");
                            using (FileStream fstream = File.OpenRead(path))
                            {
                                byte[] array = new byte[fstream.Length];
                                fstream.Read(array, 0, array.Length);
                                string textFromFile = System.Text.Encoding.Default.GetString(array);
                                Console.WriteLine($"Text from file:\n{textFromFile}");
                                fstream.Close();
                            }
                            break;
                        }
                    case 5:
                        {
                            File.WriteAllLines(path, File.ReadAllLines(path, Encoding.Default).OrderBy(x => x));
                            Console.WriteLine("File successfully sorted");
                            //var contents = File.ReadAllLines(path);
                            //Array.Sort(contents);
                            //File.WriteAllLines(path2, contents);
                            break;
                        };
                    case 6:
                        {
                            string line;
                            Console.WriteLine("Enter type:");
                            String find = Console.ReadLine();
                            using (StreamReader sr = new StreamReader(path))
                            {
                                while ((line = sr.ReadLine()) != null)
                                {
                                    if (line.StartsWith(find) || line.StartsWith(find.ToLower()))
                                    {
                                        Console.WriteLine($"Found: {line}");
                                    }
                                }
                                sr.Close();
                            }
                            break;

                        }
                    case 7:
                        {
                            break;
                        };

                }
                Console.WriteLine("Menu:\n 1. Enter a new computer;\n 2. Edit a computer;\n 3. Delete a computer;\n 4. List all computers;\n 5. Sort computers by price;\n 6. Search for a computer by price;\n");
                choice = Convert.ToInt32(Console.ReadLine());
            }
        }
    }
}
