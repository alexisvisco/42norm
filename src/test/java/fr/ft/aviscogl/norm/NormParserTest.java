package fr.ft.aviscogl.norm;

import junit.framework.TestCase;

public class NormParserTest extends TestCase
{

    public void testParse()
    {
        NormParser normParser = new NormParser();

        for (NormResult normResult : normParser.parse("Norme: ./test_des_fonctions.c\n" +
                "Error: global scope bad aligned\n" +
                "Error: file must end with a single empty line\n" +
                "Error: 8 functions in the file\n" +
                "Error (line 16): bad indentation\n" +
                "Error (line 17): bad indentation\n" +
                "Error (line 18): bad indentation\n" +
                "Error (line 19): bad indentation\n" +
                "Error (line 20): bad indentation\n" +
                "Error (line 21): bad indentation\n" +
                "Error (line 22): bad indentation\n" +
                "Error (line 23): bad indentation\n" +
                "Error (line 26, col 6): global named hello is not well prefixed\n" +
                "Error (line 27, col 6): global named nul is not well prefixed\n" +
                "Error (line 28, col 6): global named one is not well prefixed\n" +
                "Error (line 29, col 6): global named special is not well prefixed\n" +
                "Error (line 42): line has 98 characters\n" +
                "Error (line 53): missing void in function test_strlen\n" +
                "Error (line 53): Space before function name\n" +
                "Error (line 53): function test_strlen has 26 lines\n" +
                "Error (line 55, col 5): error is instanciated during declaration\n" +
                "Error (line 83): C++ comment\n" +
                "Error (line 84): C++ comment\n" +
                "Error (line 85): C++ comment\n" +
                "Error (line 86): C++ comment\n" +
                "Error (line 87): C++ comment\n" +
                "Error (line 88): C++ comment\n" +
                "Error (line 89): C++ comment\n" +
                "Error (line 90): C++ comment\n" +
                "Error (line 91): C++ comment\n" +
                "Error (line 92): C++ comment\n" +
                "Error (line 93): C++ comment\n" +
                "Error (line 94): C++ comment\n" +
                "Error (line 95): C++ comment\n" +
                "Error (line 96): C++ comment\n" +
                "Error (line 97): C++ comment\n" +
                "Error (line 98): C++ comment\n" +
                "Error (line 99): C++ comment\n" +
                "Error (line 100): C++ comment\n" +
                "Error (line 101): C++ comment\n" +
                "Error (line 102): C++ comment\n" +
                "Error (line 103): C++ comment\n" +
                "Error (line 104): C++ comment\n" +
                "Error (line 105): C++ comment\n" +
                "Error (line 106): C++ comment\n" +
                "Error (line 107): C++ comment\n" +
                "Error (line 108): C++ comment\n" +
                "Error (line 109): C++ comment\n" +
                "Error (line 110): C++ comment\n" +
                "Error (line 111): C++ comment\n" +
                "Error (line 118, col 3): missing space around =\n" +
                "Error (line 120, col 7): missing space around -\n" +
                "Error (line 121, col 14): bad character after ,\n" +
                "Error (line 127): declarations in test_bzero are bad aligned\n" +
                "Error (line 127): Space before function name\n" +
                "Error (line 127): declarations in test_bzero must be at the top of the function\n" +
                "Error (line 127): declarations must be followed by one empty line in test_bzero\n" +
                "Error (line 132, col 5): i is instanciated during declaration\n" +
                "Error (line 135, col 26): missing space around +\n" +
                "Error (line 142): missing void in function test_memcpy\n" +
                "Error (line 142): Space before function name\n" +
                "Error (line 165): missing void in function test_strdup\n" +
                "Error (line 165): Space before function name\n" +
                "Error (line 165): declarations in test_strdup must be at the top of the function\n" +
                "Error (line 165): declarations must be followed by one empty line in test_strdup\n" +
                "Error (line 167): C++ comment\n" +
                "Error (line 169, col 7): s2 is instanciated during declaration\n" +
                "Error (line 171, col 7): s is instanciated during declaration\n" +
                "Error (line 176): missing void in function test_strcat\n" +
                "Error (line 176): Space before function name\n" +
                "Error (line 188): missing void in function main\n" +
                "Error (line 188): Space before function name\n" +
                "Error (line 199): C++ comment\n" +
                "Error (line 206, col 0): no newline after block")) {
            System.out.println(normResult);
        }
        ;
    }
}
