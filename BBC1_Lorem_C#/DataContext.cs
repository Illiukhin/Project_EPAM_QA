using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BBC1withLoremIpsum
{
    public static class DataContext
    {
        public static string Question { get; set; }
        public static int AverageNumberLorem { get; set; }

        public static Dictionary<string, string> TestUrl = new Dictionary<string, string>()
        {
            { "Lipsum", "https://www.lipsum.com/"},
            { "BBC", "https://www.bbc.com/"}
        };
    }
}
