package scripts;

import com.google.common.io.Files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.nio.charset.Charset;

/**
 * @author bkovuri
 */
public class ChangeBookRatingFormat {

    public static void main(String args[]) throws Exception {

        String filePath = "/Users/bkovuri/bhanu/jyothi/itu/capstone/project/dataset/book/BX-CSV-Dump/ratings.csv";
        String writefilePath = "/Users/bkovuri/bhanu/jyothi/itu/capstone/project/dataset/book/BX-CSV-Dump/new_ratings.csv";

        BufferedReader reader = Files.newReader(new File(filePath), Charset.defaultCharset());
        BufferedWriter writer = Files.newWriter(new File(writefilePath), Charset.defaultCharset());

        String line = "";
        String writeLine = "";
        while ((line = reader.readLine()) != null)
        {

            String[] ratingArray = line.split(";");
            String bookId = ratingArray[1].replaceAll("^\"|\"$", "");
            int rating = Integer.parseInt(ratingArray[2].replaceAll("^\"|\"$", ""));
            String customer = ratingArray[0].replaceAll("^\"|\"$", "");

            writeLine = new StringBuilder().append(customer).append("\t")
                    .append(bookId).append("\t").append(rating).toString();
            writer.write(writeLine);
            writer.newLine();
        }

        reader.close();
        writer.close();
    }
}
