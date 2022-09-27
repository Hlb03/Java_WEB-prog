/*
  User: admin
  Cur_date: 27.09.2022
  Cur_time: 9:09
*/

import file_manipulations.util.SortByAsciiCode;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SortingTextByASCIITest {


    List<String> fileData = Arrays.asList(
            "Nice to see you here!",

            "In this brief article, we learned how to create a simple console-based \n" +
                    "application using Spring Boot.",

            "Hello world!",

            "Another short poem, The Phoenix and the Turtle, despairs the death of a legendary \n" +
                    "phoenix and his faithful turtle dove lover. \n" +
                    "It speaks to the frailty of love and commitment in a world where only \n" +
                    "death is certain.",

            "Welcome to sub directory!",

            "File inside second level directory.\n" +
                    "We can iterate over the list in a safe way, even when concurrent modification \n" +
                    "is happening"
    );

    List<String> fileSortedData = Arrays.asList(
            "    !Nceeeeehioorstuy",
            "\n               ,-.BISaaaaaaabbccccddeeeeeeeeeefgghhiiiiiiiilllllmnnnnnnooooooopppprrrrrsssssttttttuww",
            " !Hdellloorw",
            "\n\n\n                                     ,,..AIPTTaaaaaaaaaaaaaccdddddddddeeeeeeeeeeeeeeeeeeeeeeefffffghhhhhhhhhhhhhiiiiiiiiiiklllllllllmmmmnnnnnnnnnnnoooooooooooooopppprrrrrrrrrrrssssssstttttttttttttttttuuuvvvwwxxyyy",
            "   !Wbccdeeeilmooorrsttuy",
            "\n\n                   ,.FWaaaaaaaccccccddddeeeeeeeeeeeeeeeeeffghhhiiiiiiiiiiiillllmnnnnnnnnnnnoooooopprrrrrrssssstttttttuvvvwwyy"
    );


    @Test
    public void testSortingByASCII() {
        Assert.assertEquals(SortByAsciiCode.sortByAscii(fileData.get(0)), fileSortedData.get(0));
        Assert.assertEquals(SortByAsciiCode.sortByAscii(fileData.get(1)), fileSortedData.get(1));
        Assert.assertEquals(SortByAsciiCode.sortByAscii(fileData.get(2)), fileSortedData.get(2));
        Assert.assertEquals(SortByAsciiCode.sortByAscii(fileData.get(3)), fileSortedData.get(3));
        Assert.assertEquals(SortByAsciiCode.sortByAscii(fileData.get(4)), fileSortedData.get(4));
        Assert.assertEquals(SortByAsciiCode.sortByAscii(fileData.get(5)), fileSortedData.get(5));
    }

    @Test
    public void simpleASCIISortTest() {
        Assert.assertEquals(SortByAsciiCode.sortByAscii("D,MALo\nqT pR."), "\n ,.ADLMRTopq");
    }
}
