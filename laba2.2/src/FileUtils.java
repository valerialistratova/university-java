import java.io.*;

class FileUtils {

    private String fullpath;

    //constructor to create file's full path
    FileUtils(String path, String filename) {
        fullpath = path + filename + ".txt";
    }

    //printing our file
    void print(String fullpath) {
        try (BufferedReader br = new BufferedReader(new FileReader(fullpath))) {
            String s;
            while ((s = br.readLine()) != null) {
                System.out.println(s);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }


    void processText() {
        //creating an output file
        File newFile = new File("./" + "output" + ".txt");
        //if the file already exists, we rewrite it
        try {
            if (!newFile.createNewFile()) {
                rewrite(newFile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //creating a string to contain the whole text
        String text = "";
        try (BufferedReader br = new BufferedReader(new FileReader(fullpath))) {
            String s;
            while ((s = br.readLine()) != null) {
                text = text.concat(s);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        //creating an array of Strings only with words, lowercase them and splitting them
        String[] words = text.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
        //now we're gonna reuse text and write here all found word pairs
        text = "";
        //check if a pair of words has matching letters
        for (int i = 0; i < words.length - 1; i++) {
            if (words[i].charAt(words[i].length() - 1) == words[i + 1].charAt(0)) {
                text = text.concat(words[i] + " - " + words[i + 1] + "  |  " + "/n");
            }
        }
        write(text, newFile);

    }

    //writing all found pairs to the text
    private void write(String text, File file) {
        try (
                PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file, true)))) {
            out.append(text);
        } catch (IOException e) {
            System.err.format("Sth went wrong");
        }
    }


    //if an output file already exists, we're rewriting it
    private void rewrite(File file) {
        try (
                PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file, false)))) {
            out.write("");
        } catch (IOException e) {
            System.err.format("Sth went wrong");
        }
    }
}
